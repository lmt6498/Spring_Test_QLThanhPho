package models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Vui long nhap vao 1 chuoi")
    private String name;
    @Pattern(regexp = "^[0-9]+",message = "Dien tich phai la so")
    private String area;
    private String img;
    @Pattern(regexp = "^[0-9]+",message = "Dan so phai la so!")
    private String population;
    @Pattern(regexp = "^[0-9]+",message = "GDP phai la so!")
    private String GDP;
    private String description;
    @ManyToOne
    @JoinColumn(name = "id_country")
    private Country country;


    public City() {
    }

    public City(Integer id, String name, String area, String img, String population, String GDP, String description, Country country) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.img = img;
        this.population = population;
        this.GDP = GDP;
        this.description = description;
        this.country = country;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getGDP() {
        return GDP;
    }

    public void setGDP(String GDP) {
        this.GDP = GDP;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
