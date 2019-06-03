package ua.training.spring.foodtrackingsystem.model.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table (name = "clients"/*, joinC=@JoinColumn (name="user_id")*/)
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date birthDay;
    private Integer weight;
    private Integer height;
    private String lifeStyle;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public Client(Date birthDay, Integer weight, Integer height, String lifeStyle, User user) {
        this.birthDay = birthDay;
        this.weight = weight;
        this.height = height;
        this.lifeStyle = lifeStyle;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
