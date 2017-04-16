package controller;

import entity.User;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 创建自: Sober 时间: 2016/12/2.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/queryUserList",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public List<User> queryUserList() throws Exception{
        return userService.queryUserList();
    }

    @RequestMapping(value = "/queryUserById",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public User queryUserById(int id) throws Exception{
        return userService.queryUserById(id);
    }

    @RequestMapping(value = "/addUser",method = {RequestMethod.POST,RequestMethod.GET})
    public void addUser(String user) throws Exception{
        User u = new User();
        JSONObject jsonObject = JSONObject.fromObject(user);
        u.setUsername(jsonObject.getString("username"));
        u.setPassword(jsonObject.getString("password"));
        u.setCreate_time(new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date()));
        userService.addUser(u);
    }

    @RequestMapping(value = "/deleteUserById",method = {RequestMethod.POST,RequestMethod.GET})
    public void deleteUserById(int id) throws Exception{
        userService.deleteUserById(id);
    }

    @RequestMapping(value = "/updateUser",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public void updateUser(String user) throws Exception{
        User u = new User();
        JSONObject jsonObject = JSONObject.fromObject(user);
        u.setId(jsonObject.getInt("id"));
        u.setUsername(jsonObject.getString("username"));
        u.setPassword(jsonObject.getString("password"));
        u.setCreate_time(jsonObject.getString("create_time"));
        userService.updateUser(u);
    }
}
