package controller;

import entity.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 创建自: Sober 时间: 2016/12/2.
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/queryUserList", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String queryUserList() throws Exception {
        JSONArray jsonArray = JSONArray.fromObject(userService.queryUserList());
        return jsonArray.toString();
    }

    @RequestMapping(value = "/queryUserById", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String queryUserById(@RequestBody String user) throws Exception {
        JSONObject jsonId = JSONObject.fromObject(user);
        JSONObject json = JSONObject.fromObject(userService.queryUserById(jsonId.getInt("id")));
        return json.toString();
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public void addUser(@RequestBody String user) throws Exception {
        List<User>  list =  userService.queryUserList();
        User u = new User();
        JSONObject jsonObject = JSONObject.fromObject(user);
        u.setUsername(jsonObject.getString("username"));
        u.setPassword(jsonObject.getString("password"));
        u.setCreate_time(new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date()));
        for(User us: list) {
            if(us.getUsername().equals(u.getUsername())) {
                return;
            }
        }
        userService.addUser(u);
    }

    @RequestMapping(value = "/deleteUserById", method = {RequestMethod.POST, RequestMethod.GET})
    public void deleteUserById(@RequestBody String id) throws Exception {
        JSONObject jsonObject = JSONObject.fromObject(id);
        userService.deleteUserById(jsonObject.getInt("id"));
    }

    @RequestMapping(value = "/updateUser", method = {RequestMethod.POST, RequestMethod.GET})
    public void updateUser(@RequestBody String user) throws Exception {
        User u = new User();
        JSONObject jsonObject = JSONObject.fromObject(user);
        u.setId(jsonObject.getInt("id"));
        u.setUsername(jsonObject.getString("username"));
        u.setPassword(jsonObject.getString("password"));
        u.setCreate_time(jsonObject.getString("create_time"));
        userService.updateUser(u);
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public void test(@RequestBody Map map) throws Exception {
        System.out.println(map.get("test"));
    }
}
