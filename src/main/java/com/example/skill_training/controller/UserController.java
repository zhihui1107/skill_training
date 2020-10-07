package com.example.skill_training.controller;

import com.example.skill_training.entity.User;
import com.example.skill_training.service.UserService;
import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/Login")
    public String GoLogin(HttpSession session, SessionStatus sessionStatus){
        session.invalidate();
        sessionStatus.setComplete();
        return "LoginAndRegister";
    }

    @RequestMapping(value = "/index",method = {RequestMethod.POST,RequestMethod.GET})
    public String Verify(String login_name,String password ,HttpSession session){
        User user = userService.Login(login_name);
        if(user==null){
            return "redirect:/Login";
        }
        else {
            if (login_name==null||password==null)
            {
                return "redirect:/Login";
            }
            else
            {
                if(user.getPassword().equals(password))
                {
                    String Id = user.getId();
                    String Name = user.getName();
                    session.setAttribute("id",Id);
                    session.setAttribute("name",Name);
                    return "index";
                }
                return "redirect:/Login";
            }
        }
    }
}
