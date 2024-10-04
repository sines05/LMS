/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms.model;

import java.io.File;
import java.sql.Blob;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class Book {

    private Integer id;
    private String isbn;
    private String title;
    private ArrayList<Author> authorList;
    private Publisher publisher;
    private String description;
    private String notes;
    private String subjects;
    private Integer quantity;
    private Float price;
    private String url;
    private CallNumberLine1 callNoLine1;
    private String callNoLine2;
    private String callNoLine3;
    private String callNoLine4;
    private Genre genre; 
    private BookRecieve bookRecieve;
    private File photo;
    private String authorsName;
    

    public Book() {

    }

    public Book(Integer id,String isbn,String title, ArrayList<Author> authorList, Publisher publisher, String description, String notes, String subjects, Integer quantity, Float price, String url, CallNumberLine1 callNumberLine1, String callNumberLine2, String callNumberLine3, String callNumberLine4, Genre genre) {
        this.id = id;
        this.isbn = isbn;
        this.title =title;
        this.authorList = authorList;
        this.publisher = publisher;
        this.description = description;
        this.notes = notes;
        this.subjects = subjects;
        this.quantity = quantity;
        this.price = price;
        this.url = url;
        this.callNoLine1 = callNumberLine1;
        this.callNoLine2 = callNumberLine2;
        this.callNoLine3 = callNumberLine3;
        this.callNoLine4 = callNumberLine4;
        this.genre = genre;
    }

    public Book(String isbn,String title, ArrayList<Author> authorList, Publisher publisher, String description, String notes, String subjects, Integer quantity, Float price, String url, CallNumberLine1 callNumberLine1, String callNumberLine2, String callNumberLine3, String callNumberLine4, Genre genre) {
        this.id = id;
        this.isbn = isbn;
        this.title =title;
        this.authorList = authorList;
        this.publisher = publisher;
        this.description = description;
        this.notes = notes;
        this.subjects = subjects;
        this.quantity = quantity;
        this.price = price;
        this.url = url;
        this.callNoLine1 = callNumberLine1;
        this.callNoLine2 = callNumberLine2;
        this.callNoLine3 = callNumberLine3;
        this.callNoLine4 = callNumberLine4;
        this.genre = genre;
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
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }


    /**
     * @return the publisher
     */
    public Publisher getPublisher() {
        return publisher;
    }

    /**
     * @param publisher the publisher to set
     */
    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * @return the subjects
     */
    public String getSubjects() {
        return subjects;
    }

    /**
     * @param subjects the subjects to set
     */
    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    /**
     * @return the quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the price
     */
    public Float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Float price) {
        this.price = price;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the callNoLine1
     */
    public CallNumberLine1 getCallNoLine1() {
        return callNoLine1;
    }

    /**
     * @param callNoLine1 the callNoLine1 to set
     */
    public void setCallNoLine1(CallNumberLine1 callNoLine1) {
        this.callNoLine1 = callNoLine1;
    }

    /**
     * @return the callNoLine2
     */
    public String getCallNoLine2() {
        return callNoLine2;
    }

    /**
     * @param callNoLine2 the callNoLine2 to set
     */
    public void setCallNoLine2(String callNoLine2) {
        this.callNoLine2 = callNoLine2;
    }

    /**
     * @return the callNoLine3
     */
    public String getCallNoLine3() {
        return callNoLine3;
    }

    /**
     * @param callNoLine3 the callNoLine3 to set
     */
    public void setCallNoLine3(String callNoLine3) {
        this.callNoLine3 = callNoLine3;
    }

    /**
     * @return the callNoLine4
     */
    public String getCallNoLine4() {
        return callNoLine4;
    }

    /**
     * @param callNoLine4 the callNoLine4 to set
     */
    public void setCallNoLine4(String callNoLine4) {
        this.callNoLine4 = callNoLine4;
    }

    /**
     * @return the genre
     */
    public Genre getGenre() {
        return genre;
    }

    /**
     * @param genre the genre to set
     */
    public void setGenre(Genre genre) {
        this.genre = genre;
    }


    /**
     * @return the authorList
     */
    public ArrayList<Author> getAuthorList() {
        return authorList;
    }

    /**
     * @param authorList the authorList to set
     */
    public void setAuthorList(ArrayList<Author> authorList) {
        this.authorList = authorList;
    }

    /**
     * @return the bookRecieve
     */
    public BookRecieve getBookRecieve() {
        return bookRecieve;
    }

    /**
     * @param bookRecieve the bookRecieve to set
     */
    public void setBookRecieve(BookRecieve bookRecieve) {
        this.bookRecieve = bookRecieve;
    }

    /**
     * @return the authorsName
     */
    public String getAuthorsName() {
        return authorsName;
    }

    /**
     * @param authorsName the authorsName to set
     */
    public void setAuthorsName(String authorsName) {
        this.authorsName = authorsName;
    }
    public String toString(){
        return getTitle();
    }

}
