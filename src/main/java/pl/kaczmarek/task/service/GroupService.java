package pl.kaczmarek.task.service;


import pl.kaczmarek.task.model.Group;

import java.util.List;

public interface GroupService {

    void addGroup(String  group);
    void assignGroup(Long id);
    void cancelAssignGroup(Long id);
    void deleteGroup(Long id);
    void editGroup(Group group, Long id);
    List<Group> getAllGroups();
    Group getGroupById(Long id);
}
