package modelDB;

import javax.persistence.*;

@Entity
@Table(name = "master")
public class Master {
    @Id
    @Column(name="idmaster")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idmaster;

    private String fIO;
    private String date_of_birth;
    private int category;
    private int profile;
    private double salary;
    private String year_start_working;

    public Master(){
    }

    public Master(String fIO, String date_of_birth, int category, int profile, String year_start_working) {
        this.fIO = fIO;
        this.date_of_birth = date_of_birth;
        this.category = category;
        this.profile = profile;
        this.year_start_working = year_start_working;
    }

    public Long getIdmaster() {
        return idmaster;
    }

    public void setIdmaster(Long idmaster) {
        this.idmaster = idmaster;
    }

    public String getfIO() {
        return fIO;
    }

    public void setfIO(String fIO) {
        this.fIO = fIO;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public String getYear_start_working() {
        return year_start_working;
    }

    public void setYear_start_working(String year_start_working) {
        this.year_start_working = year_start_working;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}
