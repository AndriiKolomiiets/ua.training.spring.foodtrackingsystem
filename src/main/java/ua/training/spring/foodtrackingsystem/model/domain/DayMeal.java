package ua.training.spring.foodtrackingsystem.model.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class DayMeal {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;
    @Column(name = "date_time")
    private Date dateTime;
//todo: Might be a problem, relation might be a many to many!
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "food_id")
    private Food food;
    @Column(name = "number")
    private String number;
    @Column(name = "calories_status")
    private String caloriesStatus;
    @Column(name = "calories_to_norm")
    private String caloriesToNorm;

    public DayMeal() {
    }

    public DayMeal(Client client, Date dateTime, Food food, String number, String caloriesStatus, String caloriesToNorm) {
        this.client = client;
        this.dateTime = dateTime;
        this.food = food;
        this.number = number;
        this.caloriesStatus = caloriesStatus;
        this.caloriesToNorm = caloriesToNorm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCaloriesStatus() {
        return caloriesStatus;
    }

    public void setCaloriesStatus(String caloriesStatus) {
        this.caloriesStatus = caloriesStatus;
    }

    public String getCaloriesToNorm() {
        return caloriesToNorm;
    }

    public void setCaloriesToNorm(String caloriesToNorm) {
        this.caloriesToNorm = caloriesToNorm;
    }
}
