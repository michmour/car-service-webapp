package com.carservice.carservice.Controllers;

import com.carservice.carservice.Converters.UserConverter;
import com.carservice.carservice.Domain.Repair;
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
    public String userEditForm(Model model,@PathVariable(value = "id") Long userid, @ModelAttribute(REGISTER_FORM)RegistrationForm registrationForm ) {

        // model.addAttribute("user", userid);
        User userList= userService.findOne(userid);

        String name= userList.getName();
        String surname=  userList.getSurname();
        String email=  userList.getEmail();
        String password=  userList.getPassword();
        String ssn=  userList.getSsn();
        String address=  userList.getAddress();
        String usertype= userList.getUsertype();
        List<Repair> servicescollection=  userList.getServicescollection();


        registrationForm.setName(name);
        registrationForm.setSurname(surname);
        registrationForm.setEmail(email);
        registrationForm.setPassword(password);
        registrationForm.setSsn(ssn);
        registrationForm.setAddress(address);
        registrationForm.setUserid(userid);
        registrationForm.setUsertype(usertype);
        registrationForm.setServicescollection(servicescollection);

        model.addAttribute(REGISTER_FORM, registrationForm );
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
            return "createUser";
        }


        redirectAttributes.addFlashAttribute("message", "You have sucessfully completed registration");
        return "redirect:/users";

    }

    @PostMapping("/users/{id}")
    public String updateUser(@Valid @ModelAttribute(REGISTER_FORM)RegistrationForm registrationForm,@PathVariable(value = "id") Long userid,
                          BindingResult bindingResult, HttpSession session,
                          RedirectAttributes redirectAttributes) {

        User userList= userService.findOne(userid);
        List<Repair> servicescollection=  userList.getServicescollection();
        registrationForm.setServicescollection(servicescollection);

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

    @PostMapping("users/{id}/delete")
    public String deleteUser(@ModelAttribute(REGISTER_FORM)RegistrationForm registrationForm,@PathVariable(value = "id") Long userid,
                             BindingResult bindingResult, HttpSession session,
                             RedirectAttributes redirectAttributes) {

        User userToDelete= userService.findOne(userid);

        if (bindingResult.hasErrors()) {
            return "index";
        }

        try {
            userService.delete(userToDelete);
            session.setAttribute("name", registrationForm.getName());

        } catch (Exception exception) {
            //if an error occurs show it to the user
            redirectAttributes.addFlashAttribute("errorMessage", exception.getMessage());
//                logger.error("User registration failed: " + exception);
            return "redirect:/users";
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
