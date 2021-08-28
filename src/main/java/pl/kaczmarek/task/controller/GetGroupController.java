package pl.kaczmarek.task.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.kaczmarek.task.model.Group;
import pl.kaczmarek.task.service.GroupServiceImpl;

@Controller
public class GetGroupController {

    private final GroupServiceImpl groupService;

    public GetGroupController(GroupServiceImpl groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/showAddGroupForm")
    public String showAddGroupForm(Model model){
        Group group = new Group();
        model.addAttribute("group", group);
        return "add_group";
    }

    @GetMapping("/showEditGroupForm/{id}")
    public String deleteGroup(@PathVariable("id") Long id, Model model){
        Group group = groupService.getGroupById(id);
        model.addAttribute("group",group);
        return "edit_group";
    }

    @GetMapping("/apply")
    public String applyToGroup(Model model){
        model.addAttribute("groups",groupService.getAllGroups());
        return "apply_to_group";
    }

    @GetMapping("/edit")
    public String editGroup(Model model){
        model.addAttribute("groups",groupService.getAllGroups());
        return "edit_group";
    }

    @GetMapping("/display")
    public String getAllGroups(Model model){
        model.addAttribute("groups",groupService.getAllGroups());
        return "group_management";
    }
}
