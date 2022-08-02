/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.krishan.models;

/**
 *
 * @author krish
 */
public class User { 
        int userId;
        String userName;
        String emailId;
        String mobileNumber;

        public User(int userId, String name, String emailId, String mobileNumber) {
                this.userName = name;
                this.userId = userId;
                this.emailId = emailId;
                this.mobileNumber = mobileNumber;
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

        public String getEmailId() {
                return emailId;
        }

        public void setEmailId(String emailId) {
                this.emailId = emailId;
        }

        public String getMobileNumber() {
                return mobileNumber;
        }

        public void setMobileNumber(String mobileNumber) {
                this.mobileNumber = mobileNumber;
        }

        @Override
        public String toString() {
                return "User{" + "userId=" + userId + ", userName=" + userName + ", emailId=" + emailId + ", mobileNumber=" + mobileNumber + '}';
        }
        
}