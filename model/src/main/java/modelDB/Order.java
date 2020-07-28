package modelDB;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name="idorder")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idorder;

    private String timestart;
    private String timefinish;
    private int amount;
    @ManyToOne
    @JoinColumn(name="id")
    private User id;
    @ManyToOne
    @JoinColumn(name="idmaster")
    private Master idmaster;
    @ManyToOne
    @JoinColumn(name="idcar")
    private Car idcar;
    private String status;

    @ManyToMany
    @JoinTable(
            name = "order_services",
            joinColumns = { @JoinColumn(name = "idservice")},
            inverseJoinColumns = { @JoinColumn(name = "idorder") }
    )
    private Set<Service> services = new HashSet<>();

    public Order() {
    }

    public Order(String timestart, String timefinish, int amount, User id, Master idmaster, String status) {
        this.timestart = timestart;
        this.timefinish = timefinish;
        this.amount = amount;
        this.id = id;
        this.idmaster = idmaster;
        this.status = status;
    }

    public Order(String timestart, String timefinish, User id, Master idmaster, String status) {
        this.timestart = timestart;
        this.timefinish = timefinish;
        this.idmaster = idmaster;
        this.status = status;
    }

    public Order(String timestart, String timefinish, User id, Master idmaster, String status, Car idCar) {
        this.timestart = timestart;
        this.timefinish = timefinish;
        this.id = id;
        this.idmaster = idmaster;
        this.status = status;
        this.idcar = idCar;
    }

    public Order(String timestart, String timefinish, int amount, User id, Master idmaster, String status, Car idCar) {
        this.timestart = timestart;
        this.timefinish = timefinish;
        this.amount = amount;
        this.id = id;
        this.idmaster = idmaster;
        this.status = status;
        this.idcar = idCar;
    }

    public Order(String timestart, User id, String status) {
        this.timestart = timestart;
        this.id = id;
        this.status = status;
    }

    public Order(User id, Car idCar, String datetimestart, String status){
        this.id = id;
        this.idcar = idCar;
        this.timestart = datetimestart;
        this.status = status;
    }

    public String getTimestart() {
        return timestart;
    }

    public void setTimestart(String timestart) {
        this.timestart = timestart;
    }

    public String getTimefinish() {
        return timefinish;
    }

    public void setTimefinish(String timefinish) {
        this.timefinish = timefinish;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public User getId() {
        return id;
    }

    public void setId(User id) {
        this.id = id;
    }

    public Master getIdmaster() {
        return idmaster;
    }

    public void setIdmaster(Master idmaster) {
        this.idmaster = idmaster;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdorder() {
        return idorder;
    }

    public void setIdorder(int idorder) {
        this.idorder = idorder;
    }

    public Car getIdcar() {
        return idcar;
    }

    public void setIdcar(Car idcar) {
        this.idcar = idcar;
    }

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }
}
