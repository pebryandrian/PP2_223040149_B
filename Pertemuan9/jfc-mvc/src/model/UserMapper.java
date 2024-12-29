package model;

import java.util.List;

public interface UserMapper {
    void insertUser(User user);
    List<User> getUsers();
}
    