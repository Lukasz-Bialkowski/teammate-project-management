package com.university.service.impl;

import com.university.entity.enumeration.EmploymentForm;
import com.university.entity.enumeration.Position;
import com.university.service.DataProvider;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DefaultDataProvider implements DataProvider {

    @Override
    public List<Position> getAllPositions() {
        return Arrays.asList(Position.values());
    }

    @Override
    public List<EmploymentForm> getAllEmploymentForms() {
        return Arrays.asList(EmploymentForm.values());
    }
}
