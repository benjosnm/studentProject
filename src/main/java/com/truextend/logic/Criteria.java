/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.truextend.logic;

import com.truextend.model.Student;
import java.util.List;

/**
 *
 * @author benjamin
 */
public interface Criteria {
    public List<Student> passCriteria(List<Student> student, String value);
}
