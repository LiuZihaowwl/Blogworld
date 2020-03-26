package com.hao.Blogworld.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {

    @GetMapping("/blogManage")
    public String blogManage(){
        return "blogmanage";
    }
}
