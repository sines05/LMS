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
public class Faculty extends Person {

    private Long barcode;
    private Blob picture;

    public Faculty() {

    }

    public Faculty(String firstname, String middlename, String lastname, String mobileNo, String address, String email, String gender, File photo, Long barcode) {
     
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
