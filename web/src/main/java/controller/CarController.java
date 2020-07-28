package controller;

import modelDB.Car;
import projService.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/carlist")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public String carList(@RequestParam("id") Long id, Map<String, Object> model) {
        Iterable<Car> cars = carService.loadAllUserCars(id);
        model.put("cars", cars);

        return "carList";
    }

    @PostMapping
    public String addCar(Car car, @RequestParam("id") Long id, Map<String, Object> model) {
        car.setIduser(id);

        carService.saveCar(car);

        Iterable<Car> cars = carService.loadAllUserCars(id);
        model.put("cars", cars);

        return "carList";
    }

    @PostMapping("/filter")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String filterCar(@RequestParam("filter") String filter, Car car, Map<String, Object> model) {
        Iterable<Car> cars;
        if (filter != null && !filter.isEmpty()) {
            cars = carService.loadCarByVincode(filter);
        } else {
            cars = carService.loadAllUserCars(car.getIduser());
        }

        model.put("cars", cars);

        return "carList";
    }

    @PostMapping("deleteCar")
    public String deleteEvent(Car car, Map<String, Object> model) {
        carService.deleteCar(car);

//        carList(id, model);

        Iterable<Car> cars = carService.loadAllUserCars(car.getIduser());
        model.put("cars", cars);

        return "carList";
    }
}

