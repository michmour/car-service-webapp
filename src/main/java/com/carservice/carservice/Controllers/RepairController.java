package com.carservice.carservice.Controllers;

import com.carservice.carservice.Converters.RepairConverter;
import com.carservice.carservice.Domain.Repair;
import com.carservice.carservice.Domain.RepairStatus;
import com.carservice.carservice.Domain.RepairType;
import com.carservice.carservice.Domain.User;
import com.carservice.carservice.Models.RepairForm;
import com.carservice.carservice.Services.RepairService;
import com.carservice.carservice.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.*;

@Controller
public class RepairController {
    


        private static final String REPAIR_FORM = "repairForm";

        @Autowired
        private RepairService repairService;

        @Autowired
        private UserService userService;


        @GetMapping("/admin/repairs")
        public String repairsIndex(Model model) {


            List<Repair> repairsList = repairService.findAll();

            model.addAttribute("repairs", repairsList);

            return "allRepairs";

        }


        @GetMapping("/admin/index")
        public String repairsIndexTen(Model model) {


            Page<Repair> repairsList= repairService.getTenRepairs();

            model.addAttribute("repairs", repairsList);

            return "index";
        }

        @GetMapping("/admin/repairs/add")
        public String repairAddForm(Model model) {


            List<User> usersList= userService.findAll();
            model.addAttribute(REPAIR_FORM, new RepairForm());
            model.addAttribute("repairStatusList", getRepairStatusList());
            model.addAttribute("repairTypeList", getRepairTypeList());
            model.addAttribute("usersList", usersList);
            return "addRepair";
        }

        @GetMapping("/admin/repairs/{id}/edit")
        public String repairEditForm(Model model, @PathVariable(value = "id") Long serviceid, @ModelAttribute(REPAIR_FORM)RepairForm repairForm ) {

            model.addAttribute(REPAIR_FORM, repairService.findOne(serviceid) );
            model.addAttribute("repairStatusList", getRepairStatusList());
            model.addAttribute("repairTypeList", getRepairTypeList());
            return "editRepair";
        }

        @PostMapping("/admin/repairs")
        public String addRepair(@Valid @ModelAttribute(REPAIR_FORM)RepairForm repairForm,
                              BindingResult bindingResult, HttpSession session,
                              RedirectAttributes redirectAttributes) {

            if (bindingResult.hasErrors()) {
                return "addRepair";
            }

                Repair repair = RepairConverter.buildRepairObject(repairForm);
                repairService.save(repair);
             //   session.setAttribute("name", repairForm.getName());



            redirectAttributes.addFlashAttribute("message", "You have sucessfully completed a Vehicle registration");
            return "redirect:/admin/repairs";

        }

        @PostMapping("/admin/repairs/{id}")
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

            redirectAttributes.addFlashAttribute("message", "You have sucessfully edited a Repair");
            return "redirect:/admin/repairs";

        }

        @PostMapping("/admin/repairs/{id}/delete")
        public String deleteRepair(@ModelAttribute(REPAIR_FORM)RepairForm repairForm, @PathVariable(value = "id") Long serviceid,
                                 BindingResult bindingResult, HttpSession session,
                                 RedirectAttributes redirectAttributes) {

            Repair repairToDelete= repairService.findOne(serviceid);

            if (bindingResult.hasErrors()) {
                return "index";
            }

                repairService.delete(repairToDelete);
          //      session.setAttribute("name", repairForm.getName());

            redirectAttributes.addFlashAttribute("message", "You have sucessfully deleted a Repair");
            return "redirect:/admin/repairs";

        }

    private Map<String, String> getRepairStatusList() {
        Map<String, String> repairStatusMap = new LinkedHashMap<>();
        Arrays.stream(RepairStatus.values()).forEach(repairStatus -> repairStatusMap.put(repairStatus.name(), repairStatus.getRepairStatus()));
        return repairStatusMap;
    }

    private Map<String, String> getRepairTypeList() {
        Map<String, String> repairTypeMap = new LinkedHashMap<>();
        Arrays.stream(RepairType.values()).forEach(repairType -> repairTypeMap.put(repairType.name(), repairType.getRepairType()));
        return repairTypeMap;
    }

}




