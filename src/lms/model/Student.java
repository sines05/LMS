/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms.model;

import java.io.File;
import java.sql.Blob;

/**
 *
 * @author Aldrin
 */
public class Student extends Person {

    private Long barcode;
    private Course course;
    private String guardian;
    private String dobf;
    private Blob picture;

    public Student() {

    }

    public Student(String firstname, String middlename, String lastname, String mobileNo, String address, String email, String gender, File photo, String birthDate, Long barcode, Course course, String guardian) {
        super(firstname, middlename, lastname, mobileNo, address, email, gender, photo, birthDate);
        this.barcode = barcode;
        this.course = course;
        this.guardian = guardian;
    }

    /**
     * @return the course
     */
    public Course getCourse() {
        return course;
    }

    /**
     * @param course the course to set
     */
    public void setCourse(Course course) {
        this.course = course;
    }

    /**
     * @return the guardian
     */
    public String getGuardian() {
        return guardian;
    }

    /**
     * @param guardian the guardian to set
     */
    public void setGuardian(String guardian) {
        this.guardian = guardian;
    }

    /**
     * @return the barcode
     */
    public Long getBarcode() {
        return barcode;
    }

    /**
     * @param barcode the barcode to set
     */
    public void setBarcode(Long barcode) {
        this.barcode = barcode;
    }

    /**
     * @return the dobf
     */
    public String getDobf() {
        return dobf;
    }

    /**
     * @param dobf the dobf to set
     */
    public void setDobf(String dobf) {
        this.dobf = dobf;
    }

    /**
     * @return the picture
     */
    public Blob getPicture() {
        return picture;
    }

    /**
     * @param picture the picture to set
     */
    public void setPicture(Blob picture) {
        this.picture = picture;
    }

}
