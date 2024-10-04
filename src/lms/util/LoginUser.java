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
public class LoginUser {

    private static lms.model.User user;

    /**
     * @return the user
     */
    public static lms.model.User getUser() {
        return user;
    }

    /**
     * @param aUser the user to set
     */
    public static void setUser(lms.model.User aUser) {
        user = aUser;
    }

   

}
