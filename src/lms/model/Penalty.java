/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms.model;

/**
 *
 * @author Aldrin
 */
public class Penalty {

    private Integer id;
    private Float rate;
    private Boolean active;
    private String dateTime;
    private User user;
    private Integer daysToBorrow;
    private Boolean sunday;
    private Boolean monday;
    private Boolean tuesady;
    private Boolean wednsday;
    private Boolean thursday;
    private Boolean friday;
    private Boolean saturday;
    
    
    

    public Penalty() {

    }

    public Penalty(Integer id, Float penalty, Boolean active, String dateTime, User user) {
        this.id = id;
        this.rate = penalty;
        this.active = active;
        this.dateTime = dateTime;
        this.user = user;

    }

    public Penalty(Float penalty, Boolean active, String dateTime, User user) {
        this.rate = penalty;
        this.active = active;
        this.dateTime = dateTime;
        this.user = user;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the rate
     */
    public Float getRate() {
        return rate;
    }

    /**
     * @param rate the rate to set
     */
    public void setRate(Float rate) {
        this.rate = rate;
    }

    /**
     * @return the active
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(Boolean active) {
        this.active = active;
    }

    /**
     * @return the dateTime
     */
    public String getDateTime() {
        return dateTime;
    }

    /**
     * @param dateTime the dateTime to set
     */
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }
    
    public String toString(){
       String p= String.valueOf(getRate());
        return p;
    }

    /**
     * @return the daysToBorrow
     */
    public Integer getDaysToBorrow() {
        return daysToBorrow;
    }

    /**
     * @param daysToBorrow the daysToBorrow to set
     */
    public void setDaysToBorrow(Integer daysToBorrow) {
        this.daysToBorrow = daysToBorrow;
    }

    /**
     * @return the sunday
     */
    public Boolean getSunday() {
        return sunday;
    }

    /**
     * @param sunday the sunday to set
     */
    public void setSunday(Boolean sunday) {
        this.sunday = sunday;
    }

    /**
     * @return the monday
     */
    public Boolean getMonday() {
        return monday;
    }

    /**
     * @param monday the monday to set
     */
    public void setMonday(Boolean monday) {
        this.monday = monday;
    }

    /**
     * @return the tuesady
     */
    public Boolean getTuesady() {
        return tuesady;
    }

    /**
     * @param tuesady the tuesady to set
     */
    public void setTuesady(Boolean tuesady) {
        this.tuesady = tuesady;
    }

    /**
     * @return the wednsday
     */
    public Boolean getWednsday() {
        return wednsday;
    }

    /**
     * @param wednsday the wednsday to set
     */
    public void setWednsday(Boolean wednsday) {
        this.wednsday = wednsday;
    }

    /**
     * @return the thursday
     */
    public Boolean getThursday() {
        return thursday;
    }

    /**
     * @param thursday the thursday to set
     */
    public void setThursday(Boolean thursday) {
        this.thursday = thursday;
    }

    /**
     * @return the friday
     */
    public Boolean getFriday() {
        return friday;
    }

    /**
     * @param friday the friday to set
     */
    public void setFriday(Boolean friday) {
        this.friday = friday;
    }

    /**
     * @return the saturday
     */
    public Boolean getSaturday() {
        return saturday;
    }

    /**
     * @param saturday the saturday to set
     */
    public void setSaturday(Boolean saturday) {
        this.saturday = saturday;
    }

}
