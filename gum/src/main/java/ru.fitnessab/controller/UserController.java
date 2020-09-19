package ru.fitnessab.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.fitnessab.persist.entity.User;
import ru.fitnessab.persist.repo.UserRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final static Logger logger = (Logger) LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    //отобразить весь список пользователей
    @GetMapping //обрабатываем запрос типа GET
    public String allUsers(Model model, @RequestParam(value = "name", required = false) String name) {
        logger.info("Filtering by name: {}", name);

        List<User> allUsers;
        if (name == null || name.isEmpty()) {
            allUsers = userRepository.findAll();
        } else {
            allUsers = userRepository.findByLoginLike("%" + name + "%");
        }
        model.addAttribute("users", allUsers);
        return "users";
    }

    @GetMapping("/{id}")
    public String editUser(@PathVariable("id") Integer id, Model model) {
        User user = userRepository.findById(id).get();
        model.addAttribute("user", user);
        return "user";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, Model model){
        User user = userRepository.findById(id).get();
        model.addAttribute("user", user);
        return "user_delete";
    }

    @GetMapping("/create")
    public String createUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user";
    }

    @PostMapping("/update")
    public String updateUser(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user"; //остаемся на той же странице
        }

//        bindingResult.rejectValue(user.getPassword(),user.getMatchingPassword());
        userRepository.save(user);
        return "redirect:/user";
    }

    @PostMapping("/delete")
    public String deleteUser(@Valid User user) {
        userRepository.delete(user);
        return "redirect:/user";
    }


}
