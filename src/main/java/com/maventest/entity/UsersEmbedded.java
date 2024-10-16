package com.maventest.entity;

import jakarta.persistence.*;

// Represents a table in db
// @Entity
// @Entity(name = "users")
@Entity
@Table(name = "user_embedded")
public class UsersEmbedded {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private int userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_email")
    private String userEmail;
    private String address;

    // Embedded class
    // Will create column in db present in this class
    // variable for this class will be column in this table
    private UserWishlist userWishlist;

    public UsersEmbedded() {}

    public UsersEmbedded(int userId, String userName, String userEmail, String address) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.address = address;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UserWishlist getUserWishlist() {
        return userWishlist;
    }

    public void setUserWishlist(UserWishlist userWishlist) {
        this.userWishlist = userWishlist;
    }

    @Override
    public String toString() {
        return "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", address='" + address;
    }
}