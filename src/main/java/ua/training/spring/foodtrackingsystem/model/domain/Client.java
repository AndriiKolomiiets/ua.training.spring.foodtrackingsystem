package ua.training.spring.foodtrackingsystem.model.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;
    @NotBlank(message = "Please, fill the birth date")
    @Column(name = "birth_date")
    private Date birthDate;
    @NotBlank(message = "Please, fill the weight field")
    private Integer weight;
    @NotBlank(message = "Please, fill the height field")
    private Integer height;
    @NotBlank(message = "Please, choose the lifestyle")
    @Column(name = "life_style")
    private String lifeStyle;
    @Column(name = "calories_norm")
    private Integer caloriesNorm;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
   private List<ClientTrack> clientTrack = new ArrayList<>();

    public Client(Date birthDate, Integer weight, Integer height, String lifeStyle, Integer caloriesNorm) {
        this.birthDate = birthDate;
        this.weight = weight;
        this.height = height;
        this.lifeStyle = lifeStyle;
        this.caloriesNorm = caloriesNorm;
    }

    public List<ClientTrack> getClientTrack() {
        return clientTrack;
    }

    public void setClientTrack(List<ClientTrack> clientTrack) {
        this.clientTrack = clientTrack;
    }

    public Integer getCaloriesNorm() {
        return caloriesNorm;
    }

    public void setCaloriesNorm(Integer caloriesNorm) {
        this.caloriesNorm = caloriesNorm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getLifeStyle() {
        return lifeStyle;
    }

    public void setLifeStyle(String lifeStyle) {
        this.lifeStyle = lifeStyle;
    }

}
