package com.carservice.carservice.Controllers;

import com.carservice.carservice.Converters.UserConverter;
import com.carservice.carservice.Domain.User;
import com.carservice.carservice.Services.UserService;
import com.carservice.carservice.Models.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {


    private static final String USER_FORM = "userForm";

    @Autowired
    private UserService userService;


    @GetMapping("/users")
    public String usersIndex(Model model) {

        List<User> usersList= userService.findAll();
        model.addAttribute("users", usersList);

        return "index";
    }

    @GetMapping("/users/add")
    public String userAddForm(Model model) {
        model.addAttribute(USER_FORM, new UserForm());
        return "createUser";
    }

    @GetMapping("/users/{id}/edit")
    public String userEditForm(Model model,@PathVariable(value = "id") Long userid, @ModelAttribute(USER_FORM)UserForm userForm) {


        model.addAttribute(USER_FORM, userService.findOne(userid) );
        return "updateUser";
    }

    @PostMapping("/users")
    public String addUser(@Valid @ModelAttribute(USER_FORM)UserForm userForm,
                          BindingResult bindingResult, HttpSession session,
                          RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "createUser";
        }

            User user = UserConverter.buildUserObject(userForm);
            userService.save(user);



        redirectAttributes.addFlashAttribute("message", "You have sucessfully completed registration");
        return "redirect:/users";

    }

    @PostMapping("/users/{id}")
    public String updateUser(@Valid @ModelAttribute(USER_FORM)UserForm userForm, @PathVariable(value = "id") Long userid,
                             BindingResult bindingResult, HttpSession session,
                             RedirectAttributes redirectAttributes) {


        if (bindingResult.hasErrors()) {
            return "index";
        }

            User user = UserConverter.buildUserObject(userForm);
            userService.save(user);




        return "redirect:/users";

    }

    @PostMapping("users/{id}/delete")
    public String deleteUser(@ModelAttribute(USER_FORM)UserForm userForm, @PathVariable(value = "id") Long userid,
                             BindingResult bindingResult, HttpSession session,
                             RedirectAttributes redirectAttributes) {

        User userToDelete= userService.findOne(userid);

        if (bindingResult.hasErrors()) {
            return "index";
        }

            userService.delete(userToDelete);

        return "redirect:/users";

    }
//    @PostMapping("/users")
//    public void add(@Valid @RequestBody User user) {
//
//    }

//    @GetMapping("/get/{id}")
//    public @ResponseBody ResponseEntity<String>
//    findById(@PathVariable String id) {
//        return new ResponseEntity<String>("GET Response : "
//                + id, HttpStatus.OK);
//    }

//    @GetMapping("/users/{id}")
//    public String findById(Model model,@PathVariable(value = "id") Long userid) {
//
//        List<User> usersList= userService.findOne(userid);
//
//        model.addAttribute("users", usersList);
//        return  "index";
////        if(user == null) {
////            return ResponseEntity.notFound().build();
////        }
////        return ResponseEntity.ok().body(user);
//    }
}
