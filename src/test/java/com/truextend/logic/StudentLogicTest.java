/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.truextend.logic;

import com.truextend.model.Student;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.*;

/**
 *
 * @author benjamin
 */
public class StudentLogicTest {
    
    public StudentLogicTest() {
    }

    /**
     * Test of storeStudents method, of class StudentLogic.
     */
    @org.junit.Test
    public void testStoreStudents() {
        System.out.println("storeStudents");
        String filename = "example.csv";
        StudentLogic instance = new StudentLogic();
        instance.storeStudents(filename);
        Map<Integer, Student> storedStudents = instance.getStoredStudents();
        assertNotNull(storedStudents);
        assertEquals(100, storedStudents.size());
    }

    /**
     * Test of createNewStudent method, of class StudentLogic.
     */
    @org.junit.Test
    public void testCreateNewStudent() {
        System.out.println("createNewStudent");
        String type = "Kinder";
        String name = "Pablo";
        String gender = "M";
        StudentLogic instance = new StudentLogic();
        Student result = instance.createNewStudent(type, name, gender);
        assertNotNull(result);
    }

    /**
     * Test of deleteStudent method, of class StudentLogic.
     */
    @org.junit.Test
    public void testDeleteStudent_3args() {
        System.out.println("deleteStudent");
        String type = "";
        String name = "";
        String gender = "";
        StudentLogic instance = new StudentLogic();
        instance.deleteStudent(type, name, gender);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteStudent method, of class StudentLogic.
     */
    @org.junit.Test
    public void testDeleteStudent_Integer() {
        System.out.println("deleteStudent");
        Integer hashID = null;
        StudentLogic instance = new StudentLogic();
        instance.deleteStudent(hashID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchStudents method, of class StudentLogic.
     */
    @org.junit.Test
    public void testSearchStudents() {
        System.out.println("searchStudents");
        List<String> byCriterias = null;
        StudentLogic instance = new StudentLogic();
        List<Student> expResult = null;
        List<Student> result = instance.searchStudents(byCriterias);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
