package ru.fitnessab.persist.entity;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "waists")
public class Waist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Column
    private Integer waist;

    @Column
    private Date actionData;

    public Waist() {
    }

    public Waist(Integer id, Person person, Integer waist) {
        this.id = id;
        this.person = person;
        this.waist = waist;
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

    public Integer getWaist() {
        return waist;
    }

    public void setWaist(Integer waist) {
        this.waist = waist;
    }

    public Date getActionData() {
        return actionData;
    }

    public void setActionData(Date actionData) {
        this.actionData = Date.valueOf(LocalDate.now());
    }
}
