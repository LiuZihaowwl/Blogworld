package com.hao.Blogworld.Controller;

import com.hao.Blogworld.Entity.Blog;
import com.hao.Blogworld.Entity.User;
import com.hao.Blogworld.Service.BlogService;
import com.hao.Blogworld.Service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.instrument.classloading.jboss.JBossLoadTimeWeaver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.util.List;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;
    @Autowired
    Userservice userservice;
    @GetMapping("/blogManage")
    public String blogManage(Model model, HttpSession session){
        User user =(User)session.getAttribute("User");
        Long u_id = user.getU_id();
        List<Blog> blogs =  blogService.queryAllBlog(u_id);
        model.addAttribute("blogs",blogs);
        return "blogmanage";
    }
    @RequestMapping(value="/blogDetail",method= RequestMethod.GET)
    public String blogDetail(@RequestParam("id") Long id, Model model){
        Blog blog = blogService.queryBlogById(id);
        model.addAttribute("blog",blog);
        User user = userservice.queryUserById(blog.getU_id());
        model.addAttribute("user_name",user.getU_name());
        return "blogDetail";
    }
    @RequestMapping(value ="/blogDelete",method = RequestMethod.GET)
    public String blogDelete(@RequestParam("id") Long id,Model model){
        blogService.delete(id);
        return "blogDetail";
    }
    @RequestMapping(value ="/blogChange",method = RequestMethod.GET)
    public String blogChange(@RequestParam("id") Long id,Model model){
        Blog blog = blogService.queryBlogById(id);
        blogService.update(blog);
        model.addAttribute(blog);
        return "blogChange";
    }

}
