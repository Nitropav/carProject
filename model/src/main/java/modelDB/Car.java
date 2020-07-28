package modelDB;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idcar;

    private String carname;
    private String statenumber;
    private String type_engine;
    private double value_engine;
    private int year;
    private String vincode;
    private Long iduser;

    public Car(String carname, String statenumber, String type_engine, double value_engine, int year, String vincode, Long iduser) {
        this.carname = carname;
        this.statenumber = statenumber;
        this.type_engine = type_engine;
        this.value_engine = value_engine;
        this.year = year;
        this.vincode = vincode;
        this.iduser = iduser;
    }

    public Car(String carname, String statenumber, String type_engine, double value_engine, int year, String vincode) {
        this.carname = carname;
        this.statenumber = statenumber;
        this.type_engine = type_engine;
        this.value_engine = value_engine;
        this.year = year;
        this.vincode = vincode;
    }

    public Car() {
    }

    public int getIdcar() {
        return idcar;
    }

    public void setIdcar(int idcar) {
        this.idcar = idcar;
    }

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    public String getStatenumber() {
        return statenumber;
    }

    public void setStatenumber(String statenumber) {
        this.statenumber = statenumber;
    }

    public String getType_engine() {
        return type_engine;
    }

    public void setType_engine(String type_engine) {
        this.type_engine = type_engine;
    }

    public double getValue_engine() {
        return value_engine;
    }

    public void setValue_engine(double value_engine) {
        this.value_engine = value_engine;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getVincode() {
        return vincode;
    }

    public void setVincode(String vincode) {
        this.vincode = vincode;
    }

    public Long getIduser() {
        return iduser;
    }

    public void setIduser(Long iduser) {
        this.iduser = iduser;
    }
}
