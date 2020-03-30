package com.hao.Blogworld.Controller;

import com.hao.Blogworld.Entity.Result;
import com.hao.Blogworld.Entity.User;
import com.hao.Blogworld.Entity.User_auths;
import com.hao.Blogworld.Service.User_authsservice;
import com.hao.Blogworld.Service.Userservice;
import com.hao.Blogworld.Util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Api(tags = "用户管理")
@Controller
@Validated
public class UserController {
    @Autowired
    Userservice userservice;
    @Autowired
    User_authsservice user_authsservice;
    @PostMapping("/toLogin")
    @ApiOperation(value = "用户登录验证")
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
    @ResponseBody
    public Result register(@Valid @RequestParam("username")String name, @RequestParam("password")String password, @RequestParam("phone")String phone, @RequestParam("email")@Email String email, @RequestParam("gender")String gender) throws ParseException {
        @Valid User user = new User();
        user.setU_name(name);
        user.setEmail(email);
        user.setPhone(phone);
        user.setGender(gender);
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd");
        Date date = new Date();// 获取当前时间
        user.setBirthday(sdf.parse(sdf.format(date)));
        user.setSignal("Blogworld");
        userservice.add(user);
        Long u_id = userservice.queryUserByPhone(phone).getU_id();
        User_auths u = new User_auths();
        u.setU_id(u_id);
        u.setCredential(password);
        u.setIfverified("0");
        user_authsservice.add(u);
        return MessageUtil.success(u);

    }
}
