package pl.kaczmarek.task.service;


import pl.kaczmarek.task.model.Group;

import java.util.List;

public interface GroupService {

    Group addGroup(String  group);
    void assignGroup(Long id);
    void cancelAssignGroup(Long id);
    void deleteGroup(Long id);
    void editGroup(Group group, Long id);
    Boolean canAddGroup();
    List<Group> getAllGroups();
    List<Group> getGroupsSorted(String field,String direction);
    Group getGroupById(Long id);
}
