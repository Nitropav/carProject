package repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import modelDB.Car;

import java.util.List;

@Repository
public interface CarRepo extends CrudRepository<Car, Long> {
    List<Car> findByVincode(String vincode);

    List<Car> findByIdcar(int idcar);

    List<Car> findByIduser(Long iduser);

    Car findByIduserAndCarname(int iduser, String carname);
}
