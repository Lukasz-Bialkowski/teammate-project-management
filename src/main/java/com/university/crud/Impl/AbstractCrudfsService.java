package com.university.crud.Impl;

import com.university.crud.CrudfsRepository;
import com.university.crud.CrudfsService;
import org.springframework.data.domain.Sort;

import java.util.List;

public abstract class AbstractCrudfsService<T> extends AbstractCrudService<T> implements CrudfsService<T> {
    public AbstractCrudfsService() {
    }

    public List<T> filter(String filter, String sortProperty, String sortDirection) {
        return this.getRepository().filter(filter, new Sort(Sort.Direction.fromString(sortDirection), new String[]{sortProperty}));
    }

    public List<T> list() {
        return this.getRepository().findAll(new Sort(Sort.Direction.fromString(this.getDefaultSortDirection()), new String[]{this.getDefaultSortProperty()}));
    }

    protected abstract CrudfsRepository<T> getRepository();

    public String getDefaultSortProperty() {
        return "id";
    }

    public String getDefaultSortDirection() {
        return Sort.Direction.ASC.name();
    }
}