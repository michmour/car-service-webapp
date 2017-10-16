package com.carservice.carservice.Controllers;

import com.carservice.carservice.Converters.UserConverter;
import com.carservice.carservice.Domain.User;
import com.carservice.carservice.Services.UserService;
import com.carservice.carservice.Models.RegistrationForm;
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


    private static final String REGISTER_FORM = "registrationForm";

    @Autowired
    private UserService userService;


//    @GetMapping("/users")
//    public List<User> findAll() {
//        return userService.findAll();
//    }

//    @PostMapping("/users/update")
//    public String updateUser(Model model, @ModelAttribute(REGISTER_FORM)RegistrationForm registrationForm){
//        model.addAttribute("msg",registrationForm.getName());
//        return "index";
//    }

    @GetMapping("/users")
    public String usersIndex(Model model) {

        List<User> usersList= userService.findAll();
        model.addAttribute("users", usersList);

        return "index";
    }

    @GetMapping("/users/add")
    public String userAddForm(Model model) {
        model.addAttribute(REGISTER_FORM, new RegistrationForm());
        return "createUser";
    }

    @GetMapping("/users/{id}/edit")
    public String userEditForm(Model model,@PathVariable(value = "id") Long userid ) {
       // model.addAttribute("user", userid);

        String name=  userService.findNameById(userid);

        RegistrationForm registrationForm =new RegistrationForm();
        registrationForm.setName(name);
        registrationForm.setSurname("surname");
        registrationForm.setUserid(String.valueOf(userid));

        model.addAttribute(REGISTER_FORM, registrationForm);
        return "updateUser";
    }

    @PostMapping("/users")
    public String addUser(@Valid @ModelAttribute(REGISTER_FORM)RegistrationForm registrationForm,
                          BindingResult bindingResult, HttpSession session,
                          RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "createUser";
        }

        //here we would have the logic for sending the registration request  to our service
        // and then redireect to the home page
        //we want to show the user's username in the homepage welcome message, so we'll use session storage for that
        //We'll also pass a second parameter using Redirect attributes to do the same thing

        try {
            User user = UserConverter.buildUserObject(registrationForm);
            userService.save(user);
            session.setAttribute("name", registrationForm.getName());

        } catch (Exception exception) {
            //if an error occurs show it to the user
            redirectAttributes.addFlashAttribute("errorMessage", exception.getMessage());
//                logger.error("User registration failed: " + exception);
            return "redirect:/createUser";
        }


        redirectAttributes.addFlashAttribute("message", "You have sucessfully completed registration");
        return "redirect:/users";

    }

    @PostMapping("/users/update")
    public String updateUser(@Valid @ModelAttribute(REGISTER_FORM)RegistrationForm registrationForm,
                          BindingResult bindingResult, HttpSession session,
                          RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "index";
        }

        //here we would have the logic for sending the registration request  to our service
        // and then redireect to the home page
        //we want to show the user's username in the homepage welcome message, so we'll use session storage for that
        //We'll also pass a second parameter using Redirect attributes to do the same thing

        try {
            User user = UserConverter.buildUserObject(registrationForm);
            userService.save(user);
            session.setAttribute("name", registrationForm.getName());

        } catch (Exception exception) {
            //if an error occurs show it to the user
            redirectAttributes.addFlashAttribute("errorMessage", exception.getMessage());
//                logger.error("User registration failed: " + exception);
            return "redirect:/updateUser";
        }


        redirectAttributes.addFlashAttribute("message", "You have sucessfully completed registration");
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
