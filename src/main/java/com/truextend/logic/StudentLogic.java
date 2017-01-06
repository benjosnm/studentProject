/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.truextend.logic;

import com.truextend.model.Student;
import com.truextend.utils.StudentUtils;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author benjamin
 */
public class StudentLogic implements StudentLogicInterface {

    private Map<Integer, Student> storedStudents;

    public StudentLogic() {
        this.storedStudents = new HashMap<>();
    }

    public Map<Integer, Student> getStoredStudents() {
        return storedStudents;
    }

    public void setStoredStudents(Map<Integer, Student> storedStudents) {
        this.storedStudents = storedStudents;
    }

    @Override
    public void storeStudents(String filename) {
        BufferedReader br = null;
        String line = "";

        try {
            br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) {
                String[] studentData = line.split(StudentUtils.CSV_SPLIT);
                if (studentData.length == 4) {
                    Student student = new Student(studentData[0], studentData[1], studentData[2], studentData[3]);
                    String toID = studentData[0] + studentData[1] + studentData[2];
                    int hashCodeID = toID.hashCode();
                    this.storedStudents.put(hashCodeID, student);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StudentLogic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StudentLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Student createNewStudent(String type, String name, String gender) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddhhmmss");
        String lastUpdate = currentDate.format(formatter);

        Student student = new Student(type, name, gender, lastUpdate);
        String toID = type + name + gender;
        int hashCodeID = toID.hashCode();
        this.storedStudents.put(hashCodeID, student);
        return student;
    }

    @Override
    public void deleteStudent(String type, String name, String gender) {
        String toID = type + name + gender;
        int hashCodeID = toID.hashCode();
        this.deleteStudent(hashCodeID);
    }

    @Override
    public void deleteStudent(Integer hashID) {
        this.storedStudents.remove(hashID);
    }

    @Override
    public List<Student> searchStudents(List<String> byCriterias) {
        Map<Criteria, String> prepareCriterias = this.prepareCriterias(byCriterias);
        Collection<Student> values = storedStudents.values();
        List<Student> passCriteria = new ArrayList<>(values);

        for (Map.Entry<Criteria, String> criteriaEntry : prepareCriterias.entrySet()) {
            Criteria criteria = criteriaEntry.getKey();
            passCriteria = criteria.passCriteria(passCriteria, criteriaEntry.getValue());
        }
        
        passCriteria = this.orderListByCriteria(byCriterias, passCriteria);
        
        return passCriteria;
    }
    
    
    private Map<Criteria, String> prepareCriterias(List<String> criteriasList) {
        Map<Criteria, String> criteriaTypes = new HashMap<>();

        for (String arg : criteriasList) {
            if (arg.contains("type=")) {
                criteriaTypes.put(new CriteriaType(), arg.replace("type=", ""));
            } else if (arg.contains("name=")) {
                criteriaTypes.put(new CriteriaName(), arg.replace("name=", ""));
            } else if (arg.contains("gender=")) {
                String gender = arg.replace("gender=", "");
                gender = gender.equals("female") ? "F" : "M";
                criteriaTypes.put(new CriteriaGender(), gender);
            }
        }

        return criteriaTypes;
    }

    private List<Student> orderListByCriteria(List<String> byCriterias, List<Student> toSortList) {
        String orderBy = "";
        for (String order : byCriterias) {
            if(order.contains("orderBy=")){
                orderBy = order;
                break;
            }
        }
        
        switch (orderBy) {
                case "orderBy=Type":
                    toSortList.sort(Comparator.comparing(s -> s.getType()));
                    break;
                case "orderBy=Gender":
                    toSortList.sort(Comparator.comparing(s -> s.getGender()));
                    break;
                case "orderBy=LastUpdate":
                    toSortList.sort(Comparator.comparing(s -> s.getLastupdate()));
                    break;
                default:
                    toSortList.sort(Comparator.comparing(s -> s.getName()));
                    break;
            }
        
        return toSortList;
    }

}
