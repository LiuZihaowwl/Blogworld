package com.hao.Blogworld.Controller;

import com.hao.Blogworld.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class CommonController {
    @GetMapping("/index")
    public String index(Model model, HttpSession session){
        List<Integer> numbers = new ArrayList<>() ;
        for(int i = 0; i<6; i++){
            numbers.add((int)(1+Math.random()*(6-1+1)));
        }
        model.addAttribute("nums",numbers);
        return "index";
    }
}
