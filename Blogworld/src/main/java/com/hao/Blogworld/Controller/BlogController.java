package com.hao.Blogworld.Controller;

import com.hao.Blogworld.Entity.Blog;
import com.hao.Blogworld.Entity.User;
import com.hao.Blogworld.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;
    @GetMapping("/blogManage")
    public String blogManage(Model model, HttpSession session){
        User user =(User)session.getAttribute("User");
        Long u_id = user.getU_id();
        List<Blog> blogs =  blogService.queryAllBlog(u_id);
        model.addAttribute("blogs",blogs);
        return "blogmanage";
    }
}
