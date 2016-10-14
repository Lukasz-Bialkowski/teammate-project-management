package com.university.service.impl;

import com.university.crud.Impl.AbstractCrudService;
import com.university.entity.Event;
import com.university.repository.EventRepository;
import com.university.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl extends AbstractCrudService<Event> implements EventService {

    private EventRepository eventRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Event create() {
        return new Event();
    }

    @Override
    protected JpaRepository<Event, Long> getRepository() {
        return eventRepository;
    }
}
