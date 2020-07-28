package controller;

import modelDB.*;
import repos.UserRepo;
import projService.CarService;
import projService.OrderService;
import projService.ServService;
import projService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class RegisterController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CarService carService;

    @Autowired
    private UserService userService;

    @Autowired
    private ServService servService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/registrationUserInfo")
    public String registrationUserInfo() {
        return "registrationUserInfo";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addInfoAboutUser(User User, Map<String, Object> model) {

        User UserFromDB = userRepo.findByUsername(User.getUsername());

        if (UserFromDB != null) {
            model.put("message", "User with number or email already exist!" + User.getFio());
            return "registrationUserInfo";
        }
        User.setActive(true);
        User.setRoles(Collections.singleton(Role.USER));
        userRepo.save(User);
        return "redirect:/login";
    }

    @GetMapping("/registerOnService")
    public String registrationOnService(@RequestParam("id_user") Long id, Map<String, Object> model) {

        System.out.println("USER = " + id);
        Iterable<Car> cars = carService.loadAllUserCars(id);
        model.put("cars", cars);
        Iterable<Service> services = servService.loadAllServices();
        model.put("flag", false);
        model.put("services", services);


        return "services";
    }

    private ArrayList<String[]> viewInfo = new ArrayList<>();
    private String result = "";
    private int res = 0;
    private int time = 0;
    private int time1 = 0;
    private String finish = "";
    private Master master = new Master();
    ArrayList<String> servs = new ArrayList<>();
    int sum = 0;
    boolean flag = true;
    Order order = new Order();

    @PostMapping("/registerOnService")
    public String addServiceInOrder(@RequestParam("id_user") int id,
                                    @RequestParam("choiceCar") String carName,
                                    @RequestParam("choiceService") String serviceName,
                                    @RequestParam("datatimestart") String datetimestart,
                                    Map<String, Object> model) {

        User user = userService.loadUserById(id);
        Service service = servService.loadServiceByname(serviceName);
        Iterable<Car> cars = carService.loadAllUserCars((long) user.getId());
        Car car = new Car();
        for (Car t : cars){
            if (t.getCarname().equals(carName)){
                car = t;
            }
        }

        model.put("cars", cars);
        Iterable<Service> services = servService.loadAllServices();
        model.put("flag", false);
        model.put("services", services);
        if (carName != null) {
            String[] tmp = new String[4];
            tmp[0] = carName;
            tmp[1] = serviceName;
            servs.add(serviceName);
            tmp[2] = datetimestart;
            tmp[3] = service.getCost();
            viewInfo.add(tmp);
            res += Integer.parseInt(tmp[3]);
            switch (serviceName) {
                case "Полировка":
                    master.setIdmaster(109L);
                    break;
                case "Замена амортизаторов":
                    master.setIdmaster(110L);
                    break;
                case "Чиповка":
                    master.setIdmaster(111L);
                    break;
                case "Электроника":
                    master.setIdmaster(112L);
                    break;
                case "Техосмотр":
                    master.setIdmaster(113L);
                    break;
                case "Чистка двигателя":
                    master.setIdmaster(114L);
                    break;
                case "Ремонт тормозов":
                    master.setIdmaster(115L);
                    break;
                case "Химчистка салона":
                    master.setIdmaster(116L);
                    break;
                case "Мойка":
                    master.setIdmaster(117L);
                    break;
                case "Диагностика":
                    master.setIdmaster(118L);
                    break;
            }
            String[] strings1;
            String[] strings2;
            String[] strings3;
            String delimeter1 = " ";
            String delimeter2 = ":";
            strings1 = tmp[2].split(delimeter1);
            strings2 = strings1[0].split(delimeter2);
            strings3 = service.getDuration().split(delimeter2);
            time = Integer.valueOf(strings2[0]) + Integer.valueOf(strings3[0]);
            time1 = Integer.valueOf(strings2[1]) + Integer.valueOf(strings3[1]);
            finish = time + ":" + time1 + " " + strings1[1];
            result = String.valueOf(res);
            sum = res;
            model.put("sum", result);
            model.put("OrderLines", viewInfo);
            model.put("flag", true);
        }

        if (flag) {
            order = new Order(datetimestart, finish, sum, user, master, "Обрабатывается", car);
            orderService.saveOrders(order);
            flag = false;
        }

        Service currService = servService.loadServiceByname(serviceName);
        orderService.addServices(order , currService);

        return "services";
    }
}
