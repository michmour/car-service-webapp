package com.carservice.carservice.Controllers;

import com.carservice.carservice.Converters.UserConverter;
import com.carservice.carservice.Domain.User;
import com.carservice.carservice.Exceptions.AlreadySameException;
import com.carservice.carservice.Services.UserService;
import com.carservice.carservice.Models.UserForm;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {


    private static final String USER_FORM = "userForm";
    private static final String ERROR = "error";
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);



    @Autowired
    private UserService userService;

    @GetMapping("/user/profile")
    public String usersIndex(Model model) {

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            User userRepairs = userService.findUserByEmail(authentication.getName());
            model.addAttribute("userRepairs", userRepairs);

            return "usersIndex";
    }

    @GetMapping("/admin/users")
    public String adminIndex(Model model) {

        List<User> usersList= userService.findAll();
        model.addAttribute("users", usersList);

        return "allUsers";
    }



    @GetMapping("/admin/users/add")
    public String userAddForm(Model model) {
        model.addAttribute(USER_FORM, new UserForm());
        return "adduser";
    }

    @GetMapping("/admin/users/{id}/edit")
    public String userEditForm(Model model,@PathVariable(value = "id") Long userid, @ModelAttribute(USER_FORM)UserForm userForm) {


        model.addAttribute(USER_FORM, userService.findOne(userid) );
        return "edituser";
    }

    @PostMapping("/admin/users")
    public String addUser(@Valid @ModelAttribute(USER_FORM)UserForm userForm,
                          BindingResult bindingResult, HttpSession session,
                          RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "addUser";
        }




        try {
            User user = UserConverter.buildUserObject(userForm);
            userService.save(user);
            session.setAttribute("username", userForm.getEmail());

        } catch (Exception handleUserException) {
            redirectAttributes.addFlashAttribute("errorMessage",  handleUserException.getMessage());
            logger.error("User registration failed: " + handleUserException);
            return "redirect:/admin/users/add";

        }



        redirectAttributes.addFlashAttribute("message", "You have sucessfully completed registration");
        return "redirect:/admin/users";

    }


    @PostMapping("/admin/users/{id}")
    public String updateUser(@Valid @ModelAttribute(USER_FORM)UserForm userForm, @PathVariable(value = "id") Long userid,
                             BindingResult bindingResult, HttpSession session,
                             RedirectAttributes redirectAttributes) {


        if (bindingResult.hasErrors()) {
            return "index";
        }

            User user = UserConverter.buildUserObject(userForm);
            userService.save(user);



        redirectAttributes.addFlashAttribute("message", "You have sucessfully edited a User");
        return "redirect:/admin/users";

    }

    @PostMapping("/admin/users/{id}/delete")
    public String deleteUser(@ModelAttribute(USER_FORM)UserForm userForm, @PathVariable(value = "id") Long userid,
                             BindingResult bindingResult, HttpSession session,
                             RedirectAttributes redirectAttributes) {

        User userToDelete= userService.findOne(userid);

        if (bindingResult.hasErrors()) {
            return "index";
        }

            userService.delete(userToDelete);


        redirectAttributes.addFlashAttribute("message", "You have sucessfully deleted a User");
        return "redirect:/admin/users";

    }

    @GetMapping("/admin/search")
    public String getUsers() {

        return "searchUser";
    }

    @ExceptionHandler({AlreadySameException.class})
    public RedirectView handleUserException(AlreadySameException e, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute(ERROR, e.getMessage());
        return new RedirectView("/admin/users/add");
    }

}
