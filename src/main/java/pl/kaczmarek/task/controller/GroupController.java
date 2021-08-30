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
    public String addCGroup(@Valid Group group, BindingResult result){
        if(result.hasErrors()){
            return "add_group";
        }
        groupService.addGroup(group.getName());
        return "redirect:/displayGroups";
    }

    @PostMapping("/edit/{id}")
    public String editGroup(@PathVariable("id") Long id,
                            @Valid Group group,
                            BindingResult result){
        if(result.hasErrors()){
            return "edit_group";
        }
        groupService.editGroup(group,id);
        return "redirect:/displayGroups";
    }

    @RequestMapping(value = "/assign-group/{id}", method = {RequestMethod.GET,RequestMethod.POST})
    public String assignGroup(@PathVariable("id") Long id){
        groupService.assignGroup(id);
        return "redirect:/showApplyForm";
    }

    @PostMapping("/cancel-apply-group/{id}")
    public String cancelAssignGroup(@PathVariable("id") Long id){
        groupService.cancelAssignGroup(id);
        return "redirect:/showApplyForm";
    }


    @PostMapping("/delete/{id}")
    public String deleteGroup(@PathVariable("id") Long id){
        groupService.deleteGroup(id);
        return "redirect:/displayGroups";
    }







}
