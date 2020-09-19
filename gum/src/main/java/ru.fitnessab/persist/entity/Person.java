package ru.fitnessab.persist.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @Email
    private String email;

    @Column
    @NotBlank
    private String login;

    @Column
    private String password;

    @Transient
    private String matchingPassword;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    @NotBlank
    private String phoneNumber;

    @Column
    private String gender;

    @Column
//    @DateTimeFormat
    private Date birthday;

    @OneToMany (mappedBy = "person")
    private List<Growth> growths;

    @OneToMany (mappedBy = "person")
    private List<Weigth> weigths;

    @OneToMany (mappedBy = "person")
    private List<Waist> waists;

    public Person() {
    }

    public Person(Integer id, @Email String email, @NotBlank String login, String password, String matchingPassword, String firstName, String lastName, @NotBlank String phoneNumber, String gender, Date birthday) {
        this.id = id;
        this.email = email;
        this.login = login;
        this.password = password;
        this.matchingPassword = matchingPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<Growth> getGrowths() {
        return growths;
    }

    public void setGrowths(List<Growth> growths) {
        this.growths = growths;
    }

    public List<Weigth> getWeigths() {
        return weigths;
    }

    public void setWeigths(List<Weigth> weigths) {
        this.weigths = weigths;
    }

    public List<Waist> getWaists() {
        return waists;
    }

    public void setWaists(List<Waist> waists) {
        this.waists = waists;
    }
}
