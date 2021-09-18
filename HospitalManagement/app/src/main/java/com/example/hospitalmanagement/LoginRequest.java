package com.example.hospitalmanagement;

public class LoginRequest {
    private String userName;
    private String password;
    private CommonAPIHeader header;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", header=" + header +
                '}';
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CommonAPIHeader getHeader() {
        return header;
    }

    public void setHeader(CommonAPIHeader header) {
        this.header = header;
    }
}
