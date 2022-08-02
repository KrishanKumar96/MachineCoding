/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.krishan.services;

import com.krishan.models.Split.Split;
import com.krishan.repository.ExpenseRepository;
import java.util.List;

/**
 *
 * @author krish
 */
public class SplitWiseService {
    ExpenseRepository expenseRepository;

    public SplitWiseService(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }

    public void addExpense(double expenseAmount, String amountPaidBy, List<Split > splits, String operation) {
        expenseRepository.addExpense(expenseAmount,amountPaidBy,splits, operation);
        System.out.println("OK");
    }

    public void showBalance(String userName) {
        List<String> balances = expenseRepository.getBalance(userName);
        if (balances.isEmpty()) {
            System.out.println("No balances");
        } else {
            for(String balance: balances){
                System.out.println(balance);
            }
        }
    }

    public void showBalances(){
        List<String> balances = expenseRepository.getBalances();
        if (balances.isEmpty()) {
            System.out.println("No balances");
        } else {
            for(String balance: balances){
                System.out.println(balance);
            }
        }
    }
}