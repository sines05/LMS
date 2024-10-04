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
public class BookBorrow extends Book {

    private Student student;
    private User user;
    private Book book;
    private Penalty penalty;
    private Boolean returnBook;
    private Boolean wrongBarcode;

    /**
     * @return the student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * @param student the student to set
     */
    public void setStudent(Student student) {
        this.student = student;
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
     * @return the book
     */
    public Book getBook() {
        return book;
    }

    /**
     * @param book the book to set
     */
    public void setBook(Book book) {
        this.book = book;
    }

    /**
     * @return the penalty
     */
    public Penalty getPenalty() {
        return penalty;
    }

    /**
     * @param penalty the penalty to set
     */
    public void setPenalty(Penalty penalty) {
        this.penalty = penalty;
    }

    /**
     * @return the returnBook
     */
    public Boolean getReturnBook() {
        return returnBook;
    }

    /**
     * @param returnBook the returnBook to set
     */
    public void setReturnBook(Boolean returnBook) {
        this.returnBook = returnBook;
    }

    /**
     * @return the wrongBarcode
     */
    public Boolean getWrongBarcode() {
        return wrongBarcode;
    }

    /**
     * @param wrongBarcode the wrongBarcode to set
     */
    public void setWrongBarcode(Boolean wrongBarcode) {
        this.wrongBarcode = wrongBarcode;
    }

}
