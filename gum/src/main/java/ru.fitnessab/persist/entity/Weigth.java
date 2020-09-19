package ru.fitnessab.persist.entity;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "weigths")
public class Weigth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Column
    private Integer weigth;

    @Column
    private Date actionData;

    public Weigth() {
    }

    public Weigth(Integer id, Person person, Integer weigth) {
        this.id = id;
        this.person = person;
        this.weigth = weigth;
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

    public Integer getWeigth() {
        return weigth;
    }

    public void setWeigth(Integer weigth) {
        this.weigth = weigth;
    }

    public Date getActionData() {
        return actionData;
    }

    public void setActionData(Date actionData) {
        this.actionData = Date.valueOf(LocalDate.now());
    }
}
