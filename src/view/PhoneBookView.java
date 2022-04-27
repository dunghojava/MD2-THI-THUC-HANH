package view;

import controller.PhoneBookController;
import model.Group;
import model.PhoneBook;
import service.Group.GroupServiceIMPL;
import service.PhoneBook.PhoneBookServiceIMPL;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBookView {
    Scanner scanner = new Scanner(System.in);
    PhoneBookController phoneBookController = new PhoneBookController();
    List<Group> groupList = GroupServiceIMPL.groups;
    List<PhoneBook> phoneBookList = PhoneBookServiceIMPL.phoneBooks;
    PhoneBookServiceIMPL phoneBookServiceIMPL = new PhoneBookServiceIMPL();

    public void readFromFile() {
        System.out.println("== WRITE TO FILE ==");
        System.out.println(phoneBookController.showListPhoneBook());
    }

    public void writeToFile() {
        phoneBookController.showListPhoneBook();
        System.out.println("YOU HAVE WRITE TO FILE");
    }

    public void showListPhoneBook() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int phanNguyen = phoneBookServiceIMPL.findAll().size() / 5;
            int phanDu = phoneBookServiceIMPL.findAll().size() % 5;
            int k = 0;
            int count = 1;
            if (phanNguyen > 0) {
                for (int i = 0; i < phanNguyen; i++) {
                    for (int j = 0; j < 5; j++) {
                        System.out.println(phoneBookServiceIMPL.findAll().get(k));
                        k++;
                    }
                    System.out.println("----------------------------");
                    count++;
                    System.out.println("ẤN ENTER ĐỂ TIẾP TỤC SHOW");
                    String input = "";
                    input = scanner.nextLine();
                    if (input.equalsIgnoreCase("")) {
                        continue;
                    } else {
                        new PhoneBookView().showListPhoneBook();
                    }
                }
            }
            if (phanDu > 0) {
                for (int i = 0; i < phanDu; i++) {
                    PhoneBook phoneBook = phoneBookServiceIMPL.findAll().get(k);
                    System.out.println(phoneBook);
                    k++;
                }
            }
            System.out.println("=========================================");
            System.out.println("NHẬP MỘT KÝ TỰ BẤT KỲ ĐỂ TIẾP TỤC HOẶC QUIT ĐỂ QUAY LẠI MENU: ");
            String backMenu = scanner.nextLine();
            if (backMenu.equalsIgnoreCase("quit")) {
                new Main();
            }
        }
    }

    public void changeInformationPhoneBook() {
        while (true) {
            System.out.println("NHAP SDT CAN SUA");
            int checkPhoneNumber = Integer.parseInt(scanner.nextLine());
            if (phoneBookList.size() == 0) {
                System.out.println("DANH SACH DANH BA CHUA DUOC KHOI TAO");
                new Main();
            } else {
                int count = 0;
                for (int i = 0; i < phoneBookList.size(); i++) {
                    if (checkPhoneNumber == phoneBookList.get(i).getPhoneNumber()) {
                        System.out.println("NHAP HO VA TEN MOI");
                        phoneBookList.get(i).setName(scanner.nextLine());
                        System.out.println("NAHP GIOI TINH MOI");
                        phoneBookList.get(i).setSex(scanner.nextLine());
                        System.out.println("NHAP DIA CHI MOI");
                        phoneBookList.get(i).setAddress(scanner.nextLine());
                        System.out.println("NHAP NGAY SINH MOI");
                        phoneBookList.get(i).setBirthDate(scanner.nextLine());
                        System.out.println("NHAP EMAIL MOI");
                        phoneBookList.get(i).setEmail(scanner.nextLine());
                        System.out.println("NHAP GROUP MOI");
                        addGroupForPhoneBook(phoneBookList.get(i));
                        phoneBookController.showListPhoneBook();
                        count++;
                    }
                }
                if (count == 0) {
                    System.out.println("KHONG CO TRONG LIST");
                    new Main();
                }
            }
        }
    }

    public void searchPhoneBook() {
        while (true) {
            System.out.println("NHAP ID MUON TIM");
            int idCheck = Integer.parseInt(scanner.nextLine());
            int idValue = 0;
            for (int i = 0; i < phoneBookList.size(); i++) {
                if (phoneBookList.get(i).getId() == idCheck) {
                    idValue = i;
                }
            }
            if (idValue == 0) {
                System.out.println("ID KHÔNG CÓ TRONG DANH SÁCH");
            } else {
                System.out.println("PHONEBOOK MUON CHECK LA: " + phoneBookList.get(idValue));
            }
            System.out.println("=========================================");
            System.out.println("NHẬP PHÍM BẤT KỲ ĐỂ TIẾP TỤC HOẶC QUIT ĐỂ QUAY LẠI MENU!!");
            String backMenu = scanner.nextLine();
            if (backMenu.equalsIgnoreCase("quit")) {
                new Main();
            }
        }
    }

    public void removePhoneBook() {
        while (true) {
            System.out.println("NHAP ID MUON XOA");
            int idRemove = Integer.parseInt(scanner.nextLine());
            int idValue = 0;
            for (int i = 0; i < phoneBookList.size(); i++) {
                if (phoneBookList.get(i).getId() == idRemove) {
                    idValue = i;
                }
            }
            if (idValue == 0) {
                System.out.println("ID KHÔNG CÓ TRONG DANH SÁCH");
            } else {
                System.out.println("XOA THANH CONG " );
                phoneBookList.remove(idValue);
                phoneBookController.showListPhoneBook();
            }
            System.out.println("=========================================");
            System.out.println("NHẬP PHÍM BẤT KỲ ĐỂ TIẾP TỤC HOẶC QUIT ĐỂ QUAY LẠI MENU!!");
            String backMenu = scanner.nextLine();
            if (backMenu.equalsIgnoreCase("quit")) {
                new Main();
            }
        }
    }

    public void createPhoneBook() {
        while (true) {
            int idPhoneBook;
            if (phoneBookList.size() == 0) {
                idPhoneBook = 1;
            } else {
                idPhoneBook = phoneBookList.get(phoneBookList.size() - 1).getId() + 1;
            }
            System.out.println("NHAP SO DIEN THOAI");
            int phoneNumber = Integer.parseInt(scanner.nextLine());
            System.out.println("NHAP HO VA TEN");
            String name = scanner.nextLine();
            System.out.println("NHAP GIOI TINH");
            String sex = scanner.nextLine();
            System.out.println("NHAP DIA CHI");
            String address = scanner.nextLine();
            System.out.println("NHAP NGAY SINH");
            String birthDate = scanner.nextLine();
            System.out.println("NHAP EMAIL");
            String email = scanner.nextLine();
            boolean check = true;
            PhoneBook phoneBook = new PhoneBook(idPhoneBook, phoneNumber,name,sex,address,birthDate,email);
            addGroupForPhoneBook(phoneBook);
            phoneBookController.createPhoneBook(phoneBook);
            phoneBookController.showListPhoneBook();
            System.out.println("BAN DA KHOI TAO THANH CONG " + phoneBook);
            new Main();
        }
    }

    private void addGroupForPhoneBook(PhoneBook phoneBook) {
        System.out.println("NHAP ID CUA NHOM MUON THEM");
        List<Group> groups = new ArrayList<>();
        int count = 0;
        int idGroup = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < groupList.size(); i++) {
            if (idGroup == groupList.get(i).getId()) {
                System.out.println("ADD THANH CONG");
                groups.add(groupList.get(i));
                phoneBook.setGroupList(groups);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("KHONG CO ID GROUP");
            new Main();
        }
    }
}
