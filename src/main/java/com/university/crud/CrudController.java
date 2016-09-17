package com.university.crud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public abstract class CrudController<T> {

    private static final Logger logger = LoggerFactory.getLogger(CrudController.class);

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

    @RequestMapping(method = {RequestMethod.GET}, value = {"/create"})
    @ResponseBody
    public T create() {
        return this.getService().create();
    }

//    private String encodeMessage(String message) {
//        try {
//            return this.codec.encode(message);
//        } catch (EncoderException var3) {
//            LOGGER.warn("Failde to encode message");
//            return message;
//        }
//    }
//    URLCodec codec = new URLCodec("UTF-8");
}