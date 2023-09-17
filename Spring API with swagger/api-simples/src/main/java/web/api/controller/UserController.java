package web.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.api.model.User;
import web.api.repository.UserRepository;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository repository;
    @GetMapping("/users")
    public List<User> getUsers(){
        return repository.listAll();
    }
    @GetMapping("/users/{username}")
    public User getOne(@PathVariable("username") String username){
        return repository.findByUsername(username);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") Integer id){
        repository.deleteById(id);
    }

    @PostMapping("/users")
    public void postUser(@RequestBody User usuario){
        repository.save(usuario);
    }
}
