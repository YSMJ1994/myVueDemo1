package service;

import entity.User;
import mapper.UserQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 创建自: Sober 时间: 2016/12/4.
 */
@Service
@Transactional
public class UserService {
    @Autowired
    private UserQuery userQuery;

    public List<User> queryUserList() {
        return userQuery.queryUserList();
    }

    public User queryUserById(int id) {
        return userQuery.queryUserById(id);
    }

    public void addUser(User user) {
        userQuery.addUser(user);
    }

    public void deleteUserById(int id) {
        userQuery.deleteUserById(id);
    }

    public void updateUser(User user) {
        userQuery.updateUser(user);
    }
}
