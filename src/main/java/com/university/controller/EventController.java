package com.university.controller;

import com.university.crud.CrudController;
import com.university.crud.CrudService;
import com.university.entity.Event;
import com.university.entity.Project;
import com.university.service.EventService;
import com.university.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Set;

@RestController
@RequestMapping("/project/{projectId}/event")
public class EventController extends CrudController<Event> {

    private EventService eventService;
    private ProjectService projectService;

    @Autowired
    public EventController(EventService eventService, ProjectService projectService) {
        this.eventService = eventService;
        this.projectService = projectService;
    }

    @Override
    protected CrudService<Event> getService() {
        return eventService;
    }

    @RequestMapping(method = {RequestMethod.GET}, value = "/projectevents")
    @ResponseBody
    public Set<Event> projectEvents(@PathVariable("projectId") Long projectId) {
        Project project = projectService.get(projectId);
        return project.getEvents();
    }

    @RequestMapping(method = {RequestMethod.POST}, value = {"/saveprojectevent"})
    @ResponseBody
    public Event saveProjectEvent(@PathVariable("projectId") Long projectId, @RequestBody Event model, HttpServletResponse response) {
        Project project = projectService.get(projectId);
        project.addEvent(model);
        Event savedEvent = eventService.save(model);
        projectService.save(project);
        return savedEvent;
    }
}
