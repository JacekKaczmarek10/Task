package pl.kaczmarek.task.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.kaczmarek.task.dao.GroupRepository;
import pl.kaczmarek.task.model.Group;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Value("${max_group_number}")
    private int maxGroupNumber;

    @Override
    public Group addGroup(String group) {
        if (groupRepository.findAll().size() < maxGroupNumber){
            return groupRepository.save(new Group(group));
        }
        return null;
    }

    @Override
    public void assignGroup(Long id){
        Group group = groupRepository.getById(id);
        group.setNumberOfUsers(group.getNumberOfUsers()+1);
        groupRepository.save(group);
    }

    @Override
    public void cancelAssignGroup(Long id) {
        Group group = groupRepository.getById(id);
        if(group.getNumberOfUsers()>0) {
            group.setNumberOfUsers(group.getNumberOfUsers() - 1);
        }
        groupRepository.save(group);
    }

    @Override
    public void deleteGroup(Long id) {
        groupRepository.delete(groupRepository.getById(id));
    }

    @Override
    public void editGroup(Group group, Long id) {
        Group editGroup = groupRepository.getById(id);
        if(group.getNumberOfUsers()>0) {
            editGroup.setNumberOfUsers(group.getNumberOfUsers());
        }
        if(group.getName().length()>0) {
            editGroup.setName(group.getName());
        }
        groupRepository.save(editGroup);
    }

    @Override
    public Boolean canAddGroup() {
        if (groupRepository.findAll().size() == maxGroupNumber){
            return false;
        }
        return true;
    }

    @Override
    public List<Group> getAllGroups(){
        return groupRepository.findAll();
    }

    @Override
    public List<Group> getGroupsSorted(String field, String direction) {
        if(direction!=null) {
            if (direction.equals("asc")) {
                return groupRepository.findAll(Sort.by(Sort.Direction.ASC, field));
            } else if (direction.equals("desc")) {
                return groupRepository.findAll(Sort.by(Sort.Direction.DESC, field));
            }
        }
        return groupRepository.findAll();
    }

    @Override
    public Group getGroupById(Long id) {
        return groupRepository.getById(id);
    }
}
