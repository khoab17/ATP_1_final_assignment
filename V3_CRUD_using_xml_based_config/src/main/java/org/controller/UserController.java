package org.controller;

import org.dao.UserDao;
import org.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {



    @RequestMapping("/list")
    public String showForm(Model model) {
        //UserDao userDaoImp=new UserDao();
        UserDao userDao=new UserDao();
        List<User> users= userDao.getAll();
        model.addAttribute("users",users);
        return "user-list";
    }
    @RequestMapping("create")
    public String create()
    {
        return "user-form";
    }

    @RequestMapping ("update")
    public String update(@RequestParam("id") int id,Model model)
    {
        UserDao userDao=new UserDao();
        User user=userDao.get(id);
        model.addAttribute("user",user);
        return "user-update";
    }

    @RequestMapping("save")
    public String save(@ModelAttribute("user") User user){
        UserDao userDao=new UserDao();
        userDao.Update(user);
        return "redirect:/user/list";
    }

    @RequestMapping("delete")
    public String delete (int id)
    {
        UserDao userDao=new UserDao();
        userDao.delete(id);
        return "redirect:/user/list";
    }

}
