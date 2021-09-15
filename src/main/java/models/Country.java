package models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(fetch = FetchType.EAGER,targetEntity = City.class)
    List<City> cities;

    public Country() {
    }

    public Country(Integer id, String name, List<City> cities) {
        this.id = id;
        this.name = name;
        this.cities = cities;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<City> getStudents() {
        return cities;
    }

    public void setStudents(List<City> cities) {
        this.cities = cities;
    }
}
