package ru.fitnessab.persist.entity;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "growths")
public class Growth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Column
    private Integer growth;

    @Column
    private Date actionData;


    public Growth() {
    }

    public Growth(Integer id, Person person, Integer growth) {
        this.id = id;
        this.person = person;
        this.growth = growth;
        this.actionData = Date.valueOf(LocalDate.now());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Integer getGrowth() {
        return growth;
    }

    public void setGrowth(Integer growth) {
        this.growth = growth;
    }

    public Date getActionData() {
        return actionData;
    }

    public void setActionData(Date actionData) {
        this.actionData = Date.valueOf(LocalDate.now());
    }
}
