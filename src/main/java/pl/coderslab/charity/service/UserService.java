package pl.coderslab.charity.service;

import pl.coderslab.charity.model.User;

public interface UserService {

    void saveUser(User user);

    void updateUser(User user);
}
