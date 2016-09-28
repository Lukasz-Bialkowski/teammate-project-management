package com.university.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/docs")
public class DocsController {

    @RequestMapping(method = {RequestMethod.GET})
    @ResponseBody
    public List<String> list() {
        return Arrays.asList("Docs1: content1", "Docs2: content2");
    }
}
