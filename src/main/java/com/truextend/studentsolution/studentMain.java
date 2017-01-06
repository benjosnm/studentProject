/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.truextend.studentsolution;

import com.truextend.logic.StudentLogic;
import com.truextend.logic.StudentLogicInterface;
import com.truextend.model.Student;
import com.truextend.utils.StudentUtils;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *
 * @author benjamin
 */
public class studentMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.exit(0);
        }

        String filename = args[0];
        StudentLogicInterface logic = new StudentLogic();

        if (args.length > 1) {
            List<String> criteria = Arrays.asList(args);
            
            logic.storeStudents(filename);
            
            List<Student> resultStudents = logic.searchStudents(criteria);
            
            StudentUtils.printResults(resultStudents);
        }

    }

    

}
