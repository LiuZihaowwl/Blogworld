package com.hao.Blogworld.Controller;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/error")
public class MyErrorPageController  {

    /**
     * 404页面
     */
    @GetMapping(value = "/404")
    public String error_404() {
        return "common/error_404";
    }

    /**
     * 500页面
     */
    @GetMapping(value = "/500")
    public String error_500() {
        return "common/error_500";
    }
}
