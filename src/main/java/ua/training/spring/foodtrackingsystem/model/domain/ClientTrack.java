package ua.training.spring.foodtrackingsystem.model.domain;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;

@Entity
public class ClientTrack {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "date")
    private Date date;
    @Column(name = "calories_status")
    private String caloriesStatus;
    @Column(name = "calories_to_norm")
    private Integer caloriesToNorm;

   public ClientTrack() {
   }

    public ClientTrack(Client client, Date date, String caloriesStatus, Integer caloriesToNorm) {
        this.client = client;
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCaloriesStatus() {
        return caloriesStatus;
    }

    public void setCaloriesStatus(String caloriesStatus) {
        this.caloriesStatus = caloriesStatus;
    }

    public Integer getCaloriesToNorm() {
        return caloriesToNorm;
    }

    public void setCaloriesToNorm(Integer caloriesToNorm) {
        this.caloriesToNorm = caloriesToNorm;
    }
}
