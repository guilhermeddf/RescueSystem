package br.ufrn.extension.gatinhos.rescuesystem.user;

import java.util.List;

public interface UserService {
    void save(User user);
    User findUser(String id);
    void delete(String id);
    void update(String id, User user);
    List<User> listUsers();
}
