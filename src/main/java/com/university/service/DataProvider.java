package com.university.service;

import com.university.entity.enumeration.EmploymentForm;
import com.university.entity.enumeration.Position;
import com.university.entity.enumeration.TaskPriority;

import java.util.List;

public interface DataProvider {

    List<Position> getAllPositions();

    List<EmploymentForm> getAllEmploymentForms();

    List<TaskPriority> getPriorityList();
}
