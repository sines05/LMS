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
public class BookRecieve {

    private Integer id;
    private Purchaser purchaser;
    private User user;
    private String reference;

    public BookRecieve() {

    }

    public BookRecieve(Integer id) {
        this.id = id;
    }

    public BookRecieve(Purchaser purchaser, User user) {
        this.purchaser = purchaser;
        this.user = user;
    }

    public BookRecieve(Integer id, Purchaser purchaser, User user) {
        this.id = id;
        this.purchaser = purchaser;
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
     * @return the purchaser
     */
    public Purchaser getPurchaser() {
        return purchaser;
    }

    /**
     * @param purchaser the purchaser to set
     */
    public void setPurchaser(Purchaser purchaser) {
        this.purchaser = purchaser;
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

    /**
     * @return the reference
     */
    public String getReference() {
        return reference;
    }

    /**
     * @param reference the reference to set
     */
    public void setReference(String reference) {
        this.reference = reference;
    }
    
  
}
