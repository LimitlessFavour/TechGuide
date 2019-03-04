package com.example.techguide.model;

import java.util.Objects;

public class LecturerModel {
    String degree, department, email, imageUrl, level, name, officeAddress, phoneNumber;

    public LecturerModel() {
    }

    public LecturerModel(String degree, String department, String email, String imageUrl, String level, String name, String officeAddress, String phoneNumber) {
        this.degree = degree;
        this.department = department;
        this.email = email;
        this.imageUrl = imageUrl;
        this.level = level;
        this.name = name;
        this.officeAddress = officeAddress;
        this.phoneNumber = phoneNumber;
    }


    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LecturerModel that = (LecturerModel) o;
        return Objects.equals(degree, that.degree) &&
                Objects.equals(department, that.department) &&
                Objects.equals(email, that.email) &&
                Objects.equals(imageUrl, that.imageUrl) &&
                Objects.equals(level, that.level) &&
                Objects.equals(name, that.name) &&
                Objects.equals(officeAddress, that.officeAddress) &&
                Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(degree, department, email, imageUrl, level, name, officeAddress, phoneNumber);
    }

    @Override
    public String toString() {
        return "LecturerModel{" +
                "degree='" + degree + '\'' +
                ", department='" + department + '\'' +
                ", email='" + email + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", level='" + level + '\'' +
                ", name='" + name + '\'' +
                ", officeAddress='" + officeAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
