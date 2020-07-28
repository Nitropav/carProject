package controller;

import modelDB.Service;
import projService.ServService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/service")
@PreAuthorize("hasAuthority('ADMIN')")
public class ServiceController {
    @Autowired
    private ServService servService;

    @GetMapping
    public String ServiceList(Map<String, Object> model) {
        Iterable<Service> services = servService.loadAllServices();
        model.put("services", services);

        return "service";
    }

    @PostMapping
    public String addService(@RequestParam String name, @RequestParam String cost, @RequestParam String duration, Map<String, Object> model) {
        Service service = new Service(name, cost, duration);

        servService.saveServices(service);

        Iterable<Service> services = servService.loadAllServices();
        model.put("services", services);

        return "service";
    }

    @PostMapping("/filter")
    public String filterService(@RequestParam("filter") String filter, Map<String, Object> model) {
        Iterable<Service> services;
        if (filter != null && !filter.isEmpty()) {
            services = servService.loadServiceByCost(filter);
        } else {
            services = servService.loadAllServices();
        }

        model.put("services", services);

        return "service";
    }

    @PostMapping("deleteService")
    public String delete(@RequestParam("idService") Service service, Map<String, Object> model) {
        servService.deleteService(service);

        Iterable<Service> services = servService.loadAllServices();
        model.put("services", services);

        return "service";
    }

    @GetMapping("/{service}")
    public String editService(@PathVariable Service service, Model model) {
        model.addAttribute("service", service);
        return "editService";
    }

    @PostMapping("/show")
    public String edit(@RequestParam String name, @RequestParam String cost, @RequestParam String duration, @RequestParam("idservice") Service service) {
        service.setName(name);
        service.setCost(cost);
        service.setDuration(duration);

        servService.saveServices(service);

        return "redirect:/service";
    }
}
