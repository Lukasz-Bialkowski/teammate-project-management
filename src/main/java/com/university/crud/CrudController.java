package com.university.crud;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public abstract class CrudController<T> {

    public CrudController() {
    }

    protected abstract CrudService<T> getService();

    @RequestMapping(method = {RequestMethod.GET})
    @ResponseBody
    public List<T> list() {
        return this.getService().list();
    }

    @RequestMapping(method = {RequestMethod.GET}, value = {"/{id}"})
    @ResponseBody
    public T get(@PathVariable("id") Long id) {
        return this.getService().get(id);
    }

    @RequestMapping(method = {RequestMethod.POST}, value = {"/save"})
    @ResponseBody
    public T save(@RequestBody T model, HttpServletResponse response) {
        response.setHeader("Persist status:", "OK");
        return this.getService().save(model);
    }

    @RequestMapping(method = {RequestMethod.DELETE}, value = {"/{id}"})
    @ResponseBody
    public void remove(@PathVariable("id") Long id) {
        this.getService().remove(id);
    }

    @RequestMapping(method = {RequestMethod.POST}, value = {"/create"})
    @ResponseBody
    public T create() {
        return this.getService().create();
    }

}