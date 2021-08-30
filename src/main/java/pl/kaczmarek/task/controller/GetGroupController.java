package pl.kaczmarek.task.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
        Boolean canAddGroup = groupService.canAddGroup();
        model.addAttribute("canAddGroup", canAddGroup);
        return "add_group";
    }

    @GetMapping("/showEditGroupForm/{id}")
    public String editGroup(@PathVariable("id") Long id, Model model){
        Group group = groupService.getGroupById(id);
        model.addAttribute("group",group);
        return "edit_group";
    }

    @GetMapping("/showApplyForm")
    public String applyToGroup(Model model){
        model.addAttribute("groups",groupService.getAllGroups());
        return "apply_to_group";
    }

    @GetMapping("/displayGroups")
    public String getAllGroups(Model model,
                               @RequestParam(required = false)String sortField,
                               @RequestParam(required = false)String sortDir){
        model.addAttribute("groups",groupService.getGroupsSorted(sortField,sortDir));
        model.addAttribute("sortField",sortField);
        model.addAttribute("sortDir",sortDir);
        model.addAttribute("canAddGroup",groupService.canAddGroup());

        String reverseSortDir = "asc";
        if(sortDir!=null && sortDir.equals("asc")){
            reverseSortDir = "desc";
        }
        model.addAttribute("reverseSortDir",reverseSortDir);
        return "group_management";
    }
}
