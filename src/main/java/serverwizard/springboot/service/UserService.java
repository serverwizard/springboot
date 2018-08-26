package serverwizard.springboot.service;


import serverwizard.springboot.domain.user.User;

public interface UserService {
    User addUser(User user);
    User getUserByEmail(String email);
}
