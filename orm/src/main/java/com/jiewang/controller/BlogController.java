package com.jiewang.controller;

import com.jiewang.domain.Blog;
import com.jiewang.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/blogs/{id}", method = RequestMethod.GET)
    public Object getAdvertiser(
        @PathVariable("id") String id
    ) {

        Blog blog = blogService.selectEntryByKey(id);

        return blog;
    }

}
