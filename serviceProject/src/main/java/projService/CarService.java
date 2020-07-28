package projService;

import modelDB.Car;
import repos.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarService {

    @Autowired
    private CarRepo carRepo;

    @Transactional
    public Iterable<Car> loadCarByVincode(String vincode){
        return carRepo.findByVincode(vincode);
    }

    @Transactional
    public Iterable<Car> loadAllCars(){
        return carRepo.findAll();
    }


    @Transactional
    public Iterable<Car> loadCarById(int idcar){
        return carRepo.findByIdcar(idcar);
    }

    @Transactional
    public Iterable<Car> loadAllUserCars(Long iduser){
        return carRepo.findByIduser(iduser);
    }

    @Transactional
    public Car loadCarBycarnameAndIduser(int iduser, String carname){
        return carRepo.findByIduserAndCarname(iduser, carname);
    }

    @Transactional
    public Car saveCar(Car car){
        return carRepo.save(car);
    }

    @Transactional
    public void deleteCar(Car car){
        carRepo.delete(car);
    }
}
