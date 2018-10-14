/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
/**
 *
 * @author nicola
 */
public class User implements Serializable {
    
    private String name;
    private String surname;
    // DA SISTEMARE CON APPROPRIATA CLASSE DELLE DATE
    private String date;
    // DA CONTROLLARE CON TIPO CHAR
    private String gender;
    private String numberPhone;
    private String email;
    private String job;
    private String placeInterest;
    // DA CONTROLLARE CON TIPO CHAR
    private String role;
    private String password;
    private LinkedList<WorkingSession> works;

    public User(String name, String surname, String date, String gender, String numberPhone, 
            String email, String job, String placeInterest, String role, String password,
            LinkedList<WorkingSession> works) {
        this.name = name;
        this.surname = surname;
        this.date = date;
        this.gender = gender;
        this.numberPhone = numberPhone;
        this.email = email;
        this.job = job;
        this.placeInterest = placeInterest;
        this.role = role;
        this.password = password;
        this.works = works;
    }

    public User() {
        this.name = "";
        this.surname = "";
        this.date = "";
        this.gender = "";
        this.numberPhone = "";
        this.email = "";
        this.job = "";
        this.placeInterest = "";
        this.role = "";
        this.password = "";
        this.works = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDate() {
        return date;
    }

    public String getGender() {
        return gender;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public String getJob() {
        return job;
    }

    public String getPlaceInterest() {
        return placeInterest;
    }

    public String getRole() {
        return role;
    }

    public LinkedList<WorkingSession> getWorks() {
        return works;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setPlaceInterest(String placeInterest) {
        this.placeInterest = placeInterest;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setWorks(WorkingSession work) {
        works.add(work);
    }
    
}
