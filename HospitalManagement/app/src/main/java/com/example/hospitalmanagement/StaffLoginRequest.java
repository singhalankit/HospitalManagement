package com.example.hospitalmanagement;

public class StaffLoginRequest {

    private CommonAPIHeader header;
    private String firstName;
    private String lastName;
    private String staffId;
    private String middleName;
    private Integer age;
    private String gender;
    private String phone;
    private String email;
    private String profession;
    private String address;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public CommonAPIHeader getHeader() {
        return header;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getStaffId() {
        return staffId;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getProfession() {
        return profession;
    }

    public String getAddress() {
        return address;
    }

    public void setHeader(CommonAPIHeader header) {
        this.header = header;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
