package com.hao.Blogworld.Controller;

import com.hao.Blogworld.Entity.User;
import com.hao.Blogworld.Entity.User_auths;
import com.hao.Blogworld.Service.User_authsservice;
import com.hao.Blogworld.Service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    Userservice userservice;
    @Autowired
    User_authsservice user_authsservice;
    @PostMapping("/toLogin")
    public String login(@RequestParam("phone")String phone,@RequestParam("password")String password){
        User user = userservice.queryUserByPhone(phone);
        Long u_id = user.getU_id();
        User_auths user_auths = user_authsservice.queryUserByU_id(u_id);
        if(user.getEmail() == user_auths.getCredential()) {
            return "backsupport";
        }
        else
            return "backsupport";

    }
}
