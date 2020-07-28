package projService;

import modelDB.Service;
import repos.ServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
public class ServService {
    @Autowired
    private ServiceRepo serviceRepo;

    @Transactional
    public List<Service> loadServiceByCost(String cost) {
        return serviceRepo.findByCost(cost);
    }

    @Transactional
    public Iterable<Service> loadAllServices() {
        return serviceRepo.findAll();
    }

    @Transactional
    public Service saveServices(Service service) {
        return serviceRepo.save(service);
    }

    @Transactional
    public void deleteService(Service service) {
        serviceRepo.delete(service);
    }

    @Transactional
    public Service loadServiceByname(String name) {
        return serviceRepo.findByName(name);
    }

}
