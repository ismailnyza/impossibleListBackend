package impossiblelist.service;

import impossiblelist.model.User;
import impossiblelist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    public Optional<User> updateUser(String id, User updatedUser) {
        return userRepository.findById(id).map(existingUser -> {
            updatedUser.setId(existingUser.getId());
            return userRepository.save(updatedUser);
        });
    }

    public List<User> getUsersByFilterCriteria(String filterCriteria) {
        return userRepository.findUsersByFilterCriteria(filterCriteria);
    }
}
