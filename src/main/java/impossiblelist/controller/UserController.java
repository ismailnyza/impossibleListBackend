package impossiblelist.controller;

import impossiblelist.model.User;
import impossiblelist.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class UserController {

    private UserService userService;

    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    public void deleteUser(String id) {
        userService.deleteUser(id);
    }

    public void deleteAllUsers() {
        userService.deleteAllUsers();
    }

    public User getUserById(String id) {
        return userService.getUserById(id).orElse(null);
    }

    public User updateUser(String id, User updatedUser) {
        return userService.updateUser(id, updatedUser).orElse(null);
    }

//    implement search for everything
    @GetMapping("/search")
    public List<User> getUsersByFilterCriteria(@RequestParam String filterCriteria) {
        return userService.getUsersByFilterCriteria(filterCriteria);
    }
}
