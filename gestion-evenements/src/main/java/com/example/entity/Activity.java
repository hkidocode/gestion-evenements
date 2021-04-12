package com.example.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "activities")
public class Activity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_activity")
    private short idActivity;
    @OneToOne
    @JoinColumn(name = "id_person", nullable = false)
    private Person person;

    private String name;
    @OneToOne
    @JoinColumn(name = "id_activity_type", nullable = false)
    private ActivityType activityType;
    @Column(nullable = false)
    private String description;
    @Column(name = "start_date", nullable = false)
    private Date startDate;
    @Column(name = "end_date", nullable = false)
    private Date endDate;

    public Activity() {
    }

    public Activity(Person person, String name, ActivityType activityType, String description, Date startDate, Date endDate) {
        this.person = person;
        this.name = name;
        this.activityType = activityType;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Activity(short idActivity, Person person, String name, ActivityType activityType, String description, Date startDate, Date endDate) {
        this.idActivity = idActivity;
        this.person = person;
        this.name = name;
        this.activityType = activityType;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public short getIdActivity() {
        return idActivity;
    }

    public void setIdActivity(short idActivity) {
        this.idActivity = idActivity;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
