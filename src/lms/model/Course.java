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
public class Course {
    private Integer id;
    private String course;
    private String Acronym;

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
     * @return the course
     */
    public String getCourse() {
        return course;
    }

    /**
     * @param course the course to set
     */
    public void setCourse(String course) {
        this.course = course;
    }

    /**
     * @return the Acronym
     */
    public String getAcronym() {
        return Acronym;
    }

    /**
     * @param Acronym the Acronym to set
     */
    public void setAcronym(String Acronym) {
        this.Acronym = Acronym;
    }
    
}
