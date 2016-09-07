package com.university.crud;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Transactional
@Validated
public interface CrudService<T> {
    List<T> list();

    T get(Long var1);

    T save(@Valid T var1);

    void remove(Long var1);

    T create();
}

