/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.truextend.utils;

import com.truextend.model.Student;
import java.util.List;

/**
 *
 * @author benjamin
 */
public class StudentUtils {
    public final static String CSV_SPLIT = ",";
    public final static String TYPE_PREFIX = "type=";
    public final static String NAME_PREFIX = "name=";
    public final static String GENDER_PREFIX = "gender=";
    
    public static void printResults(List<Student> processStudents) {
        processStudents.forEach((student) -> {
            System.out.println(student.toString());
        });
    }
}
