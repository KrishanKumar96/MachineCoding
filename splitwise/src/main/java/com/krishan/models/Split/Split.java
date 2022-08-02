/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.krishan.models.Split;

import com.krishan.models.User;

/**
 *
 * @author krish
 */
public abstract class Split {
        private User user;
        double amount;

        public Split(User user) {
                this.user = user;
        }

        public User getUser() {
                return user;
        }

        public void setUser(User user) {
                this.user = user;
        }

        public double getAmount() {
                return amount;
        }

        public void setAmount(double amount) {
                this.amount = amount;
        }

        @Override
        public String toString() {
                return "Split{" + "user=" + user + ", amount=" + amount + '}';
        }
        
}
