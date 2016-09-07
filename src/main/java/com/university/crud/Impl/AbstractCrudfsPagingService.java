package com.university.crud.Impl;

import com.university.crud.CrudfsPagingRepository;
import com.university.crud.CrudfsPagingService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public abstract class AbstractCrudfsPagingService<T> extends AbstractCrudfsService<T> implements CrudfsPagingService<T> {
    public AbstractCrudfsPagingService() {
    }

    public Page<T> list(Integer currentPage, Integer pageSize) {
        return this.getRepository().findAll(new PageRequest(currentPage.intValue(), pageSize.intValue()));
    }

    public Page<T> filter(String filter, String sortProperty, String sortDirection, Integer currentPage, Integer pageSize) {
        return this.getRepository().filter(filter, new PageRequest(currentPage.intValue(), pageSize.intValue(), Sort.Direction.fromStringOrNull(sortDirection), new String[]{sortProperty}));
    }

    protected abstract CrudfsPagingRepository<T> getRepository();
}