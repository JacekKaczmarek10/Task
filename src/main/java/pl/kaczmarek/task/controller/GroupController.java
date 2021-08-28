package pl.kaczmarek.task.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.kaczmarek.task.model.Group;
import pl.kaczmarek.task.service.GroupServiceImpl;

import javax.validation.Valid;

@Controller
public class GroupController {


    // wstrzykiwanie zaleznosci przez konstruktor
    private final GroupServiceImpl groupService;

    public GroupController(GroupServiceImpl groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/")
    public String hello(){
        return "home";
    }


    // POST METHODS
    @PostMapping("/add-group")
    public String addCGroup(@Valid Group group, BindingResult result, Model model){
        if(result.hasErrors()){
            return "redirect:/showAddGroupForm";
        }
        groupService.addGroup(group.getName());
        return "redirect:/display";
    }

    @PostMapping("/delete/{id}")
    public String deleteGroup(@PathVariable("id") Long id){
        groupService.deleteGroup(id);
        return "redirect:/display";
    }

    @PostMapping("/cancel-apply-group/{id}")
    public String cancelAssignGroup(@PathVariable("id") Long id){
        groupService.cancelAssignGroup(id);
        return "redirect:/apply";
    }

    @PostMapping("/assign-group/{id}")
    public String assignGroup(@PathVariable("id") Long id){
        groupService.assignGroup(id);
        return "redirect:/apply";
    }

    @PostMapping("/edit/{id}")
    public String editGroup(@PathVariable("id") Long id,
                               @ModelAttribute("group") Group group){
        groupService.editGroup(group,id);
        return "redirect:/display";
    }

}
