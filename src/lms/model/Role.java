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
public class Role {
    private int id;
    private RoleList roleList;

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

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
}
