/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms.util;

/**
 *
 * @author Aldrin
 */
public class LoginData {

    private static int id;
    private static String firstname;
    private static String middlename;
    private static String lastname;
    private static String username;
    private static String password;

    public LoginData() {

    }

    public LoginData(int id, String firstname, String middlename, String lastname, String username, String password, int roleId, String role) {
        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
    }

    /**
     * @return the id
     */
    public static int getId() {
        return id;
    }

    /**
     * @param aId the id to set
     */
    public static void setId(int aId) {
        id = aId;
    }

    /**
     * @return the firstname
     */
    public static String getFirstname() {
        return firstname;
    }

    /**
     * @param aFirstname the firstname to set
     */
    public static void setFirstname(String aFirstname) {
        firstname = aFirstname;
    }

    /**
     * @return the middlename
     */
    public static String getMiddlename() {
        return middlename;
    }

    /**
     * @param aMiddlename the middlename to set
     */
    public static void setMiddlename(String aMiddlename) {
        middlename = aMiddlename;
    }

    /**
     * @return the lastname
     */
    public static String getLastname() {
        return lastname;
    }

    /**
     * @param aLastname the lastname to set
     */
    public static void setLastname(String aLastname) {
        lastname = aLastname;
    }

    /**
     * @return the username
     */
    public static String getUsername() {
        return username;
    }

    /**
     * @param aUsername the username to set
     */
    public static void setUsername(String aUsername) {
        username = aUsername;
    }

    /**
     * @return the password
     */
    public static String getPassword() {
        return password;
    }

    /**
     * @param aPassword the password to set
     */
    public static void setPassword(String aPassword) {
        password = aPassword;
    }



}
