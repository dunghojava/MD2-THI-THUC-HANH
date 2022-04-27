package service.Group;

import config.ConfigReadAndWriteFile;
import model.Group;
import model.PhoneBook;

import java.util.List;

public class GroupServiceIMPL implements IGroupService {

    public static String PATH = "D:\\CODEGYM-C0222I1\\Module 2\\Java Project\\MD2-THI-THUC-HANH\\src\\data\\group.txt";
    public static List<Group> groups = new ConfigReadAndWriteFile<Group>().readFromFile(PATH);

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public List<Group> findAll() {
        new ConfigReadAndWriteFile<Group>().writeToFile(PATH, groups);
        return groups;
    }

    @Override
    public void save(Group group) {
        new ConfigReadAndWriteFile<Group>().writeToFile(PATH, groups);
        groups.add(group);
    }

    @Override
    public Group findById(int id) {
        for (int i = 0; i < groups.size(); i++) {
            if (id == groups.get(i).getId()) {
                return groups.get(i);
            }
        }
        return null;
    }
}
