package com.university.crud;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Transactional
@Validated
public interface CrudfsService<T> extends CrudService<T> {
    List<T> filter(String var1, String var2, String var3);

    List<String> getSortProperties();

    String getDefaultSortProperty();

    String getDefaultSortDirection();

    Class<T> getCls();
}
