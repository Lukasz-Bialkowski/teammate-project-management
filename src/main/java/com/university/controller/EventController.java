package com.university.controller;

import com.university.crud.CrudController;
import com.university.crud.CrudService;
import com.university.entity.Event;
import com.university.entity.Project;
import com.university.entity.User;
import com.university.security.CurrentUser;
import com.university.service.EventService;
import com.university.service.ProjectService;
import com.university.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/project/{projectId}/event")
public class EventController extends CrudController<Event> {

    private EventService eventService;
    private ProjectService projectService;
    private UserService userService;

    @Autowired
    public EventController(EventService eventService, ProjectService projectService, UserService userService) {
        this.eventService = eventService;
        this.projectService = projectService;
        this.userService = userService;
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
    public Event saveProjectEvent(@PathVariable("projectId") Long projectId, @RequestBody Event model, Authentication authentication) {
        CurrentUser userDetails = (CurrentUser) authentication.getPrincipal();
        User loggedUser = userService.get(userDetails.getUser().getId());
        model.setOwner(loggedUser);

        Project project = projectService.get(projectId);
        project.addEvent(model);
        Event savedEvent = eventService.save(model);
        projectService.save(project);
        return savedEvent;
    }
}
