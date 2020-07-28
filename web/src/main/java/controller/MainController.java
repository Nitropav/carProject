package controller;

import modelDB.Order;
import modelDB.User;
import projService.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller

public class MainController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public String hello() {
        return "main";
    }

    @RequestMapping("/login")
    public String getLogin(@RequestParam(value = "error", required = false) String error,
                           @RequestParam(value = "logout", required = false) String logout,
                           Model model) {
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);
        return "login";
    }

    @GetMapping("/main")
    public String me(Map<String, Object> model) {

        return "main";
    }

    @GetMapping("/about")
    public String about(Map<String, Object> model) {

        return "about";
    }

    @GetMapping("/myOrders")
    public String orderHistory(@RequestParam("id_user") String user,
                               @RequestParam(value = "action", required = false) String action,
                               @RequestParam(value = "order", required = false) String idorder,
                               Model model) {
        if (action != null) {
            Order order = orderService.loadOrder((int) Long.parseLong(idorder));
            orderService.deleteOrder(order);
        }
        User u = new User();
        u.setId(Integer.valueOf(user));
        Iterable<Order> orders = orderService.loadAllUserOrders(u);
        model.addAttribute("orders", orders);

        return "order";
    }
}