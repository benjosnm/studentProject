/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.truextend.logic;

import com.truextend.model.Student;
import java.util.List;
import java.util.Map;

/**
 *
 * @author benjamin
 */
public interface StudentLogicInterface {
    
    void storeStudents(String filename);
    
    Student createNewStudent(String type, String name, String gender);
    
    void deleteStudent(String type, String name, String gender);
    
    void deleteStudent(Integer hashID);
    
    List<Student> searchStudents(List<String> byCriterias);
}
