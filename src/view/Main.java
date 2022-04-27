package view;

import controller.GroupController;
import model.Group;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);

    public Main() {
        String chooseMenu = "";
        System.out.println("======== CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ ========");
        System.out.println("1. DANH SÁCH ");
        System.out.println("2. THÊM MỚI");
        System.out.println("3. CẬP NHẬT");
        System.out.println("4. XÓA ");
        System.out.println("5. TÌM KIẾM");
        System.out.println("6. ĐỌC TỪ FILE");
        System.out.println("7. GHI VÀO FILE");
        System.out.println("8. THOÁT");
        System.out.println("CHỌN CHỨC NĂNG: ");
        chooseMenu = scanner.nextLine();
        switch (chooseMenu) {
            case "1":
                new PhoneBookView().showListPhoneBook();
            case "2":
                new PhoneBookView().createPhoneBook();
            case "3":
                new PhoneBookView().changeInformationPhoneBook();
            case "4":
                new PhoneBookView().removePhoneBook();
            case "5":
                new PhoneBookView().searchPhoneBook();
            case "6":
                new PhoneBookView().readFromFile();
            case "7":
                new PhoneBookView().writeToFile();
        }
    }

    public static void main(String[] args) {
        GroupController groupController = new GroupController();
        List<Group> groupList = new ArrayList<>();
        groupController.createGroup(new Group(3, "Ban be"));
        groupController.createGroup(new Group(2, "Gia dinh"));
        groupController.createGroup(new Group(1, "Cong viec"));
        groupController.createGroup(new Group(4, "Khach hang"));
        new Main();
    }
}
