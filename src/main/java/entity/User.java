package entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 创建自: Sober 时间: 2017/4/13.
 */
@Component
public class User implements Serializable {
    private int id;
    private String username;
    private String password;
    private String create_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", create_time='" + create_time + '\'' +
                '}';
    }
}
