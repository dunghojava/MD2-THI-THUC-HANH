package service.PhoneBook;

import config.ConfigReadAndWriteFile;
import model.PhoneBook;

import java.util.List;

public class PhoneBookServiceIMPL implements IPhoneBookService {

    public static String PATH = "D:\\CODEGYM-C0222I1\\Module 2\\Java Project\\MD2-THI-THUC-HANH\\src\\data\\danhba.txt";
    public static List<PhoneBook> phoneBooks = new ConfigReadAndWriteFile<PhoneBook>().readFromFile(PATH);

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public List<PhoneBook> findAll() {
        new ConfigReadAndWriteFile<PhoneBook>().writeToFile(PATH, phoneBooks);
        return phoneBooks;
    }

    @Override
    public void save(PhoneBook phoneBook) {
        new ConfigReadAndWriteFile<PhoneBook>().writeToFile(PATH, phoneBooks);
        phoneBooks.add(phoneBook);
    }

    @Override
    public PhoneBook findById(int id) {
        for (int i = 0; i < phoneBooks.size(); i++) {
            if (id == phoneBooks.get(i).getId()) {
                return phoneBooks.get(i);
            }
        }
        return null;
    }
}
