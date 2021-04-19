package br.ufrn.extension.gatinhos.rescuesystem.user;

import br.ufrn.extension.gatinhos.rescuesystem.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public User findUser(String id) {
        return repository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public void update(String id, User user) {
        User u = repository.findById(id).orElseThrow(UserNotFoundException::new);
        u.setUserRoles(user.getUserRoles());
        u.setActive(user.isActive());
        u.setAddress(user.getAddress());
        repository.save(u);
    }

    @Override
    public List<User> listUsers() {
        return repository.findAll();
    }
}
