package com.carservice.carservice.Controllers;

import com.carservice.carservice.Converters.VehicleConverter;
import com.carservice.carservice.Domain.User;
import com.carservice.carservice.Domain.Vehicle;
import com.carservice.carservice.Domain.VehicleBrands;
import com.carservice.carservice.Exceptions.AlreadySameException;
import com.carservice.carservice.Models.VehicleForm;
import com.carservice.carservice.Services.UserService;
import com.carservice.carservice.Services.VehicleService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class VehicleController {

    private static final String VEHICLE_FORM = "vehicleForm";
    private static final String ERROR = "error";
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private UserService userService;


    @GetMapping("/admin/vehicles")
    public String vehiclesIndex(Model model) {

        List<Vehicle> vehiclesList= vehicleService.findAll();
        model.addAttribute("vehiclesList", vehiclesList);

        return "allVehicles";
    }

    @GetMapping("/admin/vehicles/add")
    public String vehicleAddForm(Model model) {

        List<User> usersList= userService.findAll();
        model.addAttribute(VEHICLE_FORM, new VehicleForm());
        model.addAttribute("vehicleBrandsList",getVehicleBrandsList());
        model.addAttribute("usersList", usersList);
        return "addVehicle";
    }

    @GetMapping("/admin/vehicles/{id}/edit")
    public String vehicleEditForm(Model model, @PathVariable(value = "id") Long vehicleid, @ModelAttribute(VEHICLE_FORM)VehicleForm vehicleForm ) {

        model.addAttribute(VEHICLE_FORM, vehicleService.findOne(vehicleid) );
        model.addAttribute("vehicleBrandsList",getVehicleBrandsList());

        return "editVehicle";
    }

    @PostMapping("/admin/vehicles")
    public String addVehicle(@Valid @ModelAttribute(VEHICLE_FORM)VehicleForm vehicleForm,
                          BindingResult bindingResult, HttpSession session,
                          RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "addVehicle";
        }



        try {
            Vehicle vehicle = VehicleConverter.buildVehicleObject(vehicleForm);
            vehicleService.save(vehicle);
            session.setAttribute("username", vehicleForm.getPlatenumber());

        } catch (Exception handleVehicleException) {
            redirectAttributes.addFlashAttribute("errorMessage", handleVehicleException.getMessage());
            logger.error("Vehicle add failed: " + handleVehicleException);
            return "redirect:/admin/vehicles/add";
        }



        redirectAttributes.addFlashAttribute("message", "You have sucessfully completed a Vehicle registration");
        return "redirect:/admin/vehicles";

    }

    @PostMapping("/admin/vehicles/{id}")
    public String updateVehicle(@Valid @ModelAttribute(VEHICLE_FORM)VehicleForm vehicleForm, @PathVariable(value = "id") Long vehicleid,
                               BindingResult bindingResult, HttpSession session,
                               RedirectAttributes redirectAttributes) {


        if (bindingResult.hasErrors()) {
            return "index";
        }


        try {
            vehicleForm.setUserelid(vehicleService.findOneUserId(vehicleid));
            Vehicle vehicle = VehicleConverter.buildVehicleObject(vehicleForm);
            vehicleService.save(vehicle);
            session.setAttribute("username", vehicleForm.getPlatenumber());

        } catch (Exception handleVehicleException) {
            redirectAttributes.addFlashAttribute("errorMessage", handleVehicleException.getMessage());
            logger.error("Vehicle edit failed: " + handleVehicleException);
            return "redirect:/admin/vehicles";
        }


        redirectAttributes.addFlashAttribute("message", "You have sucessfully edited a Vehicle");
        return "redirect:/admin/vehicles";

    }

    @PostMapping("/admin/vehicles/{id}/delete")
    public String deleteVehicle(@ModelAttribute(VEHICLE_FORM)VehicleForm vehicleForm, @PathVariable(value = "id") Long vehicleid,
                               BindingResult bindingResult, HttpSession session,
                               RedirectAttributes redirectAttributes) {

        Vehicle vehicleToDelete= vehicleService.findOne(vehicleid);

        if (bindingResult.hasErrors()) {
            return "index";
        }

        vehicleService.delete(vehicleToDelete);

        redirectAttributes.addFlashAttribute("message", "You have sucessfully deleted a Vehicle");
        return "redirect:/admin/vehicles";


        }



    private Map<String, String> getVehicleBrandsList() {
        Map<String, String> vehicleBrandsMap = new LinkedHashMap<>();
        Arrays.stream(VehicleBrands.values()).forEach(vehicleBrands -> vehicleBrandsMap.put(vehicleBrands.name(), vehicleBrands.getVehiclebrands()));
        return vehicleBrandsMap;
    }


    @ExceptionHandler({AlreadySameException.class})
    public RedirectView handleVehicleException(AlreadySameException e, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute(ERROR, e.getMessage());
        return new RedirectView("/admin/vehicles/add");
    }
}
