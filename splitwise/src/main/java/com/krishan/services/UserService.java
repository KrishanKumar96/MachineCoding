/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.krishan.services;

import com.krishan.models.User;
import com.krishan.repository.ExpenseRepository;

/**
 *
 * @author krish
 */
public class UserService {
        ExpenseRepository expenseRepository;
        
        public UserService(ExpenseRepository expenseRepository){
                this.expenseRepository = expenseRepository;
        }
        
        public void addUser(User user){
                expenseRepository.addUser(user);
        }
        
        public User getUser(String userName){
                return expenseRepository.getUser(userName);
        }
}
