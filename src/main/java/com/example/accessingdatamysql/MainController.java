package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UserRepository userRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestBody User user) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestBody means it is a parameter from the POST request

        if (user == null || user.getName() == null || user.getEmail() == null) {
            return "Erro: Parâmetros inválidos!";
        }

        userRepository.save(user);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @PutMapping(path="/update/{id}") // Map ONLY PUT Requests
    public @ResponseBody String updateUser (@PathVariable String id, @RequestBody User user) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestBody means it is a parameter from the PUT request
        // @PathVariable means it is a parameter from the URL

        if (user == null || user.getName() == null || user.getEmail() == null) {
            return "Erro: Parâmetros inválidos!";
        }

        Optional<User> optionalExistingUser = userRepository.findById(id);
        if (optionalExistingUser.isEmpty()) {
            return "Erro: Usuário não encontrado!";
        }

        User existingUser = optionalExistingUser.get();
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        userRepository.save(existingUser);
        return "Atualizado";
    }
}