package model;

import java.io.Serializable;
import java.util.List;

public class PhoneBook implements Serializable {
    private int id;
    private int phoneNumber;
    private String name;
    private String sex;
    private String address;
    private String birthDate;
    private String email;
    private List<Group> groupList = null;

    public PhoneBook() {
    }

    public PhoneBook(int id, int phoneNumber, String name, String sex, String address, String birthDate, String email, List<Group> groupList) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.birthDate = birthDate;
        this.email = email;
        this.groupList = groupList;
    }

    public PhoneBook(int id, int phoneNumber, String name, String sex, String address, String birthDate, String email) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.birthDate = birthDate;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String isSex() {
        return sex;
    }

    @Override
    public String toString() {
        return '\n' + "PhoneBook{" +
                "id=" + id +
                ", phoneNumber=" + phoneNumber +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", email='" + email + '\'' +
                ", groupList=" + groupList +
                '}';
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }
}
