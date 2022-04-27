package controller;

import model.Group;
import service.Group.GroupServiceIMPL;

import java.util.List;

public class GroupController {
    GroupServiceIMPL groupServiceIMPL = new GroupServiceIMPL();

    public List<Group> showListGroup() {
        return groupServiceIMPL.findAll();
    }

    public void createGroup(Group group) {
        groupServiceIMPL.save(group);
    }

    public Group findById(int id) {
        return groupServiceIMPL.findById(id);
    }
}
