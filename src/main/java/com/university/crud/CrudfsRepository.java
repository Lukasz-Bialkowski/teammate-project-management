package com.university.crud;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import java.util.List;

@NoRepositoryBean
public interface CrudfsRepository<T> extends JpaRepository<T, Long> {
    List<T> filter(@Param("filter") String var1, Sort var2);
}
