package br.ufrn.extension.gatinhos.rescuesystem.user.v1;

import br.ufrn.extension.gatinhos.rescuesystem.user.User;
import br.ufrn.extension.gatinhos.rescuesystem.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/user")
public class UserController {
    private final UserService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void save (@RequestBody User user){
        service.save(user);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> listAll(){
        return service.listUsers();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User findUser(@PathVariable String id){
        return service.findUser(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateRescue(@PathVariable String id, @RequestBody User user) {
        service.update(id, user);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}/delete")
    public void deleteRescue(@PathVariable String id){
        service.delete(id);
    }
}
