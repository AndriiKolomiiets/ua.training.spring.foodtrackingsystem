package ua.training.spring.foodtrackingsystem.model.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Food {
    @Id
    @GeneratedValue(generator= "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;
    @NotBlank(message = "Please, input the food name")
    @Column(name = "food_name")
    private String foodName;
    @NotBlank(message = "Please, input the number of calories")
    @Column(name = "calories")
    private String calories;
    @NotBlank(message = "Please, input the number of proteins")
    @Column(name = "proteins")
    private String proteins;
    @NotBlank(message = "Please, input the number of lipids")
    @Column(name = "lipids")
    private String lipids;
    @NotBlank(message = "Please, input the number of carbs")
    @Column(name = "carbs")
    private String carbs;

    public Food() {
    }

    public Food(@NotBlank(message = "Please, input the food name") String foodName,
                @NotBlank(message = "Please, input the number of calories") String calories,
                @NotBlank(message = "Please, input the number of proteins") String proteins,
                @NotBlank(message = "Please, input the number of lipids") String lipids,
                @NotBlank(message = "Please, input the number of carbs") String carbs) {
        this.foodName = foodName;
        this.calories = calories;
        this.proteins = proteins;
        this.lipids = lipids;
        this.carbs = carbs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public String getProteins() {
        return proteins;
    }

    public void setProteins(String proteins) {
        this.proteins = proteins;
    }

    public String getLipids() {
        return lipids;
    }

    public void setLipids(String lipids) {
        this.lipids = lipids;
    }

    public String getCarbs() {
        return carbs;
    }

    public void setCarbs(String carbs) {
        this.carbs = carbs;
    }
}
