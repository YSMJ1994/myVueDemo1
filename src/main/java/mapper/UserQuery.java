package mapper;

import entity.User;

import java.util.List;

/**
 * 创建自: Sober 时间: 2016/12/2.
 */
public interface UserQuery {
    List<User> queryUserList();
    User queryUserById(int id);
    void addUser(User user);
    void deleteUserById(int id);
    void updateUser(User user);
}
