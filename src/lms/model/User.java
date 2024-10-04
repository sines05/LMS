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
public class User extends Person implements ManageRole {

    private RoleList roleList;
    private Role role;
    public  User(){
        
    }

    public User(Integer id, String firstname, String middlename, String lastname, String username, String password) {
        super(id, firstname, middlename, lastname);
        this.username = username;
        this.password = password;
    }
    private String username;
    private String password;

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the roleList
     */
    public RoleList getRoleList() {
        return roleList;
    }

    /**
     * @param roleList the roleList to set
     */
    public void setRoleList(RoleList roleList) {
        this.roleList = roleList;
    }

    @Override
    public void userRole(RoleList role) {
        switch (role) {
            case Administrator:
//                Administrator admin = new Administrator(role);
            case Director:
//                Director director = new Director(role);
            case Librarian:
//                Librarian librarian = new Librarian(role);

        }
    }

    /**
     * @return the role
     */
    public Role getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(Role role) {
        this.role = role;
    }

}
