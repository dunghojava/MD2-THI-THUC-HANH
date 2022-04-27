package controller;

import model.PhoneBook;
import service.PhoneBook.PhoneBookServiceIMPL;

import java.util.List;

public class PhoneBookController {
    PhoneBookServiceIMPL phoneBookServiceIMPL = new PhoneBookServiceIMPL();

    public List<PhoneBook> showListPhoneBook() {
        return phoneBookServiceIMPL.findAll();
    }

    public void createPhoneBook(PhoneBook phoneBook) {
        phoneBookServiceIMPL.save(phoneBook);
    }

    public PhoneBook findById(int id) {
        return phoneBookServiceIMPL.findById(id);
    }
}
