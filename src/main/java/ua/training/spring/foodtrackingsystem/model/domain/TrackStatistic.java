package ua.training.spring.foodtrackingsystem.model.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class TrackStatistic {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_track_id")
    private ClientTrack clientTrack;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "food_id")
    private Food food;
    private Integer number;
    @Column(name = "date_time")
    private Date dateTime;

    public TrackStatistic() {
    }

    public TrackStatistic(ClientTrack clientTrack, Food food, Integer number, Date dateTime) {
        this.clientTrack = clientTrack;
        this.food = food;
        this.number = number;
        this.dateTime = dateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientTrack getClientTrack() {
        return clientTrack;
    }

    public void setClientTrack(ClientTrack clientTrack) {
        this.clientTrack = clientTrack;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}
