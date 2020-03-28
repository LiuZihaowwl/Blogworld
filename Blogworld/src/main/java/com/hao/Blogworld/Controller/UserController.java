package com.hao.Blogworld.Controller;

import com.hao.Blogworld.Entity.User;
import com.hao.Blogworld.Entity.User_auths;
import com.hao.Blogworld.Service.User_authsservice;
import com.hao.Blogworld.Service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    Userservice userservice;
    @Autowired
    User_authsservice user_authsservice;
    @PostMapping("/toLogin")
    public String login(@RequestParam("phone")String phone, @RequestParam("password")String password, Model model, HttpSession session){
        User user = userservice.queryUserByPhone(phone);
        Long u_id = user.getU_id();
        User_auths user_auths = user_authsservice.queryUserByU_id(u_id);
        session.setAttribute("User",user);
        if(password.equals(user_auths.getCredential())) {
            model.addAttribute("user",user);
            return "user_admin_test";
        }
        else
            return "login";
    }
    @GetMapping("/autho_detail")
    public String blogManage(Model model, HttpSession session){
        User user =(User)session.getAttribute("User");
        model.addAttribute("user",user);
        return "authodetail";
    }
    @GetMapping("/sign_up")
    public String  sign(){
        return "sign";
    }
    @PostMapping("/register")
    public String register(@RequestParam("username")String name, @RequestParam("password")String password,@RequestParam("phone")String phone,@RequestParam("email")String email,@RequestParam("gender")String gender){
        User user = new User();
        user.setU_name(name);
        user.setEmail(email);
        user.setPhone(phone);
        user.setGender(gender);
        user.setSignal("Blogworld");
        userservice.add(user);
        Long u_id = userservice.queryUserByPhone(phone).getU_id();
        User_auths u = new User_auths();
        u.setU_id(u_id);
        u.setCredential(password);
        u.setIfverified("0");
        user_authsservice.add(u);
        return "login";

    }
}
