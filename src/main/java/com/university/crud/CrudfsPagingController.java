package com.university.crud;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public abstract class CrudfsPagingController<T> extends CrudfsController<T> {
    private static final String DATA_SIZE_HEADER = "X-HRTools-Data-Size";

    public CrudfsPagingController() {
    }

    @RequestMapping(
            value = {"/paged"},
            method = {RequestMethod.GET}
    )
    @ResponseBody
    public List<T> list(@RequestParam Integer currentPage, @RequestParam Integer pageSize, HttpServletResponse response) {
        Page page = this.getService().list(currentPage, pageSize);
        response.setHeader("X-HRTools-Data-Size", String.valueOf(page.getTotalElements()));
        return page.getContent();
    }

    @RequestMapping(
            value = {"/filter/paged"},
            method = {RequestMethod.GET}
    )
    @ResponseBody
    public List<T> filter(@RequestParam(
            defaultValue = ""
    ) String filter, @RequestParam(
            required = false
    ) String property, @RequestParam(
            defaultValue = "asc"
    ) String direction, @RequestParam Integer currentPage, @RequestParam Integer pageSize, HttpServletResponse response) {
        String safeProperty = property == null?"id":property;
        Page page = this.getService().filter(filter, safeProperty, direction, currentPage, pageSize);
        response.setHeader("X-HRTools-Data-Size", String.valueOf(page.getTotalElements()));
        return page.getContent();
    }

    protected abstract CrudfsPagingService<T> getService();
}