package com.university.crud;

import org.springframework.data.domain.Page;

public interface CrudfsPagingService<T> extends CrudfsService<T> {
    Page<T> list(Integer var1, Integer var2);

    Page<T> filter(String var1, String var2, String var3, Integer var4, Integer var5);
}