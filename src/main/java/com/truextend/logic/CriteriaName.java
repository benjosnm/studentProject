/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.truextend.logic;

import com.truextend.model.Student;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author benjamin
 */
public class CriteriaName implements Criteria {

    @Override
    public List<Student> passCriteria(List<Student> students, String value) {
        List<Student> collect = students.stream()
                .filter(s -> s.getName().equals(value))
                .collect(Collectors.toList());

        return collect;
    }

}
