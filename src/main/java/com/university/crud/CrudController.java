package com.university.crud;

import com.fasterxml.jackson.annotation.JsonView;
import org.apache.tomcat.util.codec.EncoderException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public abstract class CrudController<T> {
    private static final Logger logger = LoggerFactory.getLogger(CrudController.class);
//    URLCodec codec = new URLCodec("UTF-8");

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
        String message = this.getSaveMessage();
        if(message != null) {
            response.setHeader("Persist status:", "OK");
//            response.setHeader("X-HRTools-Message", this.encodeMessage(message));
            response.setHeader("Persist message:", message);
        }

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

    protected String getSaveMessage() {
        return "Dane zostały zapisane";
    }
//
//    private String encodeMessage(String message) {
//        try {
//            return this.codec.encode(message);
//        } catch (EncoderException var3) {
//            LOGGER.warn("Failde to encode message");
//            return message;
//        }
//    }
}