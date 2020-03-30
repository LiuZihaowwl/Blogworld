package com.hao.Blogworld.Controller;


import com.hao.Blogworld.Service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController_freemarker {
    @Autowired
    private Userservice userservice;
    @RequestMapping(value = "/see/user/{phone}",method = RequestMethod.GET)
    public String findUser(Model model , @PathVariable("phone")String phone){
        model.addAttribute("user",userservice.queryUserByPhone(phone));
        return "web/user";
    }

}
