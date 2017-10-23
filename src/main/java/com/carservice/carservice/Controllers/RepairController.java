package com.carservice.carservice.Controllers;

import com.carservice.carservice.Converters.RepairConverter;
import com.carservice.carservice.Domain.Repair;
import com.carservice.carservice.Domain.User;
import com.carservice.carservice.Models.RepairForm;
import com.carservice.carservice.Services.RepairService;
import com.carservice.carservice.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class RepairController {
    


        private static final String REPAIR_FORM = "repairForm";

        @Autowired
        private RepairService repairService;

        @Autowired
        private UserService userService;


        @GetMapping("/repairs")
        public String repairsIndex(Model model) {


            List<Repair> repairsList= repairService.findAll();

            model.addAttribute("repairs", repairsList);


            return "index";
        }

        @GetMapping("/repairs/add")
        public String repairAddForm(Model model) {

            List<User> usersList= userService.findAll();
            model.addAttribute(REPAIR_FORM, new RepairForm());
            model.addAttribute("usersList", usersList);
            return "createRepair";
        }

        @GetMapping("/repairs/{id}/edit")
        public String repairEditForm(Model model, @PathVariable(value = "id") Long serviceid, @ModelAttribute(REPAIR_FORM)RepairForm repairForm ) {



            model.addAttribute(REPAIR_FORM, repairService.findOne(serviceid) );
            return "updateRepair";
        }

        @PostMapping("/repairs")
        public String addRepair(@Valid @ModelAttribute(REPAIR_FORM)RepairForm repairForm,
                              BindingResult bindingResult, HttpSession session,
                              RedirectAttributes redirectAttributes) {

            if (bindingResult.hasErrors()) {
                return "createUser";
            }

                Repair repair = RepairConverter.buildRepairObject(repairForm);
                repairService.save(repair);
             //   session.setAttribute("name", repairForm.getName());



        //    redirectAttributes.addFlashAttribute("message", "You have sucessfully completed registration");
            return "redirect:/repairs";

        }

        @PostMapping("/repairs/{id}")
        public String updateRepair(@Valid @ModelAttribute(REPAIR_FORM)RepairForm repairForm,@PathVariable(value = "id") Long serviceid,
                                 BindingResult bindingResult, HttpSession session,
                                 RedirectAttributes redirectAttributes) {


            if (bindingResult.hasErrors()) {
                return "index";
            }

                repairForm.setUserelid(repairService.findOneUserId(serviceid));
                Repair repair = RepairConverter.buildRepairObject(repairForm);
                repairService.save(repair);
              //  session.setAttribute("name", repairForm.getName());

            return "redirect:/repairs";

        }

        @PostMapping("repairs/{id}/delete")
        public String deleteRepair(@ModelAttribute(REPAIR_FORM)RepairForm repairForm, @PathVariable(value = "id") Long serviceid,
                                 BindingResult bindingResult, HttpSession session,
                                 RedirectAttributes redirectAttributes) {

            Repair repairToDelete= repairService.findOne(serviceid);

            if (bindingResult.hasErrors()) {
                return "index";
            }

                repairService.delete(repairToDelete);
          //      session.setAttribute("name", repairForm.getName());

            return "redirect:/repairs";

        }
//    @PostMapping("/repairs")
//    public void add(@Valid @RequestBody Repair user) {
//
//    }

//    @GetMapping("/get/{id}")
//    public @ResponseBody ResponseEntity<String>
//    findById(@PathVariable String id) {
//        return new ResponseEntity<String>("GET Response : "
//                + id, HttpStatus.OK);
//    }

//    @GetMapping("/repairs/{id}")
//    public String findById(Model model,@PathVariable(value = "id") Long serviceid) {
//
//        List<Repair> usersList= repairService.findOne(serviceid);
//
//        model.addAttribute("repairs", usersList);
//        return  "index";
////        if(user == null) {
////            return ResponseEntity.notFound().build();
////        }
////        return ResponseEntity.ok().body(user);
//    }
    }




