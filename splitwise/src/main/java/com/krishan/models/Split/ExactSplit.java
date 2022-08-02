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
public class ExactSplit extends Split{
        public ExactSplit(User user, double amount) {
                super(user);
                this.amount = amount;
        }

        
}
