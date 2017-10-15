package com.carservice.carservice.controllers;

import com.carservice.carservice.converters.UserConverter;
import com.carservice.carservice.forms.RegistrationForm;
import com.carservice.carservice.models.User;
import com.carservice.carservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class RegistrationController {

    private static final String REGISTER_FORM = "registrationForm";

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute(REGISTER_FORM, new RegistrationForm());
        return "register";
    }



        @RequestMapping(value = "/register", method = RequestMethod.POST)
        public String register(@Valid @ModelAttribute(REGISTER_FORM)
                RegistrationForm registrationForm,
                BindingResult bindingResult, HttpSession session,
                RedirectAttributes redirectAttributes) {

            if (bindingResult.hasErrors()) {
                return "register";
            }

            //here we would have the logic for sending the registration request  to our service
            // and then redireect to the home page
            //we want to show the user's username in the homepage welcome message, so we'll use session storage for that
            //We'll also pass a second parameter using Redirect attributes to do the same thing

            try {
                User user = UserConverter.buildUserObject(registrationForm);
                userService.save(user);
                session.setAttribute("username", registrationForm.getName());

            } catch (Exception exception) {
                //if an error occurs show it to the user
                redirectAttributes.addFlashAttribute("errorMessage", exception.getMessage());
//                logger.error("User registration failed: " + exception);
                return "redirect:/register";
            }


            redirectAttributes.addFlashAttribute("message", "You have sucessfully completed registration");
            return "redirect:/users";


        }
    }

