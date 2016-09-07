package com.university.crud;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

@NoRepositoryBean
public interface CrudfsPagingRepository<T> extends CrudfsRepository<T> {
    Page<T> filter(@Param("filter") String var1, Pageable var2);
}
