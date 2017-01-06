/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.truextend.model;

import java.io.Serializable;

/**
 *
 * @author benjamin
 */
public class Student implements Serializable {

    private String name;
    private String gender;
    private String type;
    private String lastUpdate;

    public Student(String type, String name, String gender, String lastupdate) {
        this.name = name;
        this.gender = gender;
        this.type = type;
        this.lastUpdate = lastupdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLastupdate() {
        return lastUpdate;
    }

    public void setLastupdate(String lastupdate) {
        this.lastUpdate = lastupdate;
    }

    public String toString() {
        return this.type + ", " + this.name + ", " + this.gender + ", " + this.lastUpdate;
    }
}
