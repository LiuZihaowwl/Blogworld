package com.hao.Blogworld.Controller;
import com.hao.Blogworld.BlogworldApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testlogging")
public class TestController {
    private static Logger logger = LoggerFactory.getLogger(BlogworldApplication.class);

    @GetMapping("/hello")
    public String hello() {
            logger.info("test logging...");
            return "index";
        }
    }

