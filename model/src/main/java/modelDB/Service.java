package modelDB;

import javax.persistence.*;

@Entity
@Table(name = "service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idservice;

    private String name;
    private String cost;
    private String duration;

    public Long getIdservice() {
        return idservice;
    }

    public void setIdservice(Long idservice) {
        this.idservice = idservice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Service(){
    }

    public Service(String name, String cost, String duration) {
        this.name = name;
        this.cost = cost;
        this.duration = duration;
    }
}
