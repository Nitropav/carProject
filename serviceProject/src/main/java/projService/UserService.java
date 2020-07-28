package projService;

import modelDB.User;
import repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private MailSender mailSender;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }

    @Transactional
    public Iterable<User> loadAllUsers(){
        return userRepo.findAll();
    }

    @Transactional
    public User saveUsers(User user){
        return userRepo.save(user);
    }

    @Transactional
    public void deleteUser(User user){
        userRepo.delete(user);
    }

    @Transactional
    public List<User> loadUserByActive(boolean active){
        return  userRepo.findByActive(active);
    }

    @Transactional
    public User loadUserById(int id){
        return userRepo.findById(id);
    }

    @Transactional
    public void leaveAnswer(User user){
        mailSender.send(user.getEmail(), "Станция техобслуживание Звезда", String.format("Ваш заказ выполнен. \n%s Можете забрать свой автомобиль. Автосервис Звезда и его владелец: Трошко Илья.", user.getUsername()));
    }
}
