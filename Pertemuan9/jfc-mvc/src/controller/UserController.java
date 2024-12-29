package controller;

import model.*;
import view.UserView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UserController {
    private UserView view;
    private UserMapper mapper;

    public UserController(UserView view, UserMapper mapper) {
        this.view = view;
        this.mapper = mapper;

        view.addAddUserListener(new AddUserListener());
        view.addRefreshListener(new RefreshListener());
    }

    class AddUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = view.getName();
            String email = view.getEmail();
            if (!name.isEmpty() && !email.isEmpty()) {
                User user = new User(name, email);
                mapper.insertUser(user);
                JOptionPane.showMessageDialog(view, "User added successfully!");
            } else {
                JOptionPane.showMessageDialog(view, "Please fill in all fields");
            }
        }
    }

    class RefreshListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            List<User> users = mapper.getUsers();
            String[] userArray = users.stream()
                    .map(user -> user.getName() + " (" + user.getEmail() + ")")
                    .toArray(String[]::new);
            view.setUsers(userArray);
        }
    }
}
