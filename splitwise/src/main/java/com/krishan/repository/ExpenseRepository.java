/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.krishan.repository;

import com.krishan.models.Expense.Expense;
import com.krishan.models.Split.Split;
import com.krishan.models.User;
import com.krishan.services.ExpenseService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author krish
 */
public class ExpenseRepository {
        List<Expense> expenseList;
        Map<String,User> userMap;
        Map<String , Map<String,Double>> balanceSheet;
        
        
        public ExpenseRepository(){
                userMap = new HashMap<String,User>() ;
                expenseList = new ArrayList<Expense>();
                balanceSheet = new HashMap<String , Map<String,Double>>();
        }
        public void addUser(User user){
                userMap.put(user.getUserName(),user);
                balanceSheet.put(user.getUserName(), new HashMap<>());
        }
        public User getUser(String userName){
                return userMap.get(userName);
        }
        
        public void addExpense(double expenseAmount, String amountPaidBy, List<Split> splits, String operation){
                Expense expense = new ExpenseService().createExpenses( amountPaidBy, expenseAmount, splits, operation);
                expenseList.add(expense);
                for(Split split : expense.getSplits()){
                        //System.out.println(split);
                        Map<String, Double> balances = balanceSheet.get(amountPaidBy);
                        String amountPaidTo =  split.getUser().getUserName();
                        if(!balances.containsKey(amountPaidTo)){
                                balances.put(amountPaidTo, 0.0);
                        }
                        balances.put(amountPaidTo, balances.get(amountPaidTo) + split.getAmount());    
                        
                        balances = balanceSheet.get(amountPaidTo);
                        if(!balances.containsKey(amountPaidBy)){
                                balances.put(amountPaidBy, 0.0);
                        }
                        balances.put(amountPaidBy, balances.get(amountPaidBy) - split.getAmount());    
                        
                }
        }
        
        public List<String> getBalance(String paidBy){
                List<String> ledger = new ArrayList<String>();
                Map<String,Double> balances = balanceSheet.get(paidBy);
                for(Map.Entry<String,Double> mp : balances.entrySet()){
                        ledger.add(checkSign(paidBy,mp.getKey(),mp.getValue()));
                }
                return ledger;
        }
        
        
        public List<String> getBalances(){
                List<String> ledger = new ArrayList<String>();
                for(Map.Entry<String,Map<String,Double>> bs : balanceSheet.entrySet()){
                        Map<String,Double> balances = bs.getValue();
                        for(Map.Entry<String,Double> mp : balances.entrySet()){
                                if(mp.getValue()>0)
                                        ledger.add(checkSign(bs.getKey(),mp.getKey(),mp.getValue()));
                        }
                }
                return ledger;
        }
        
        public String checkSign(String paidBy, String paidTo, double amount){
                if(amount>0){
                        return paidTo + " owes " + paidBy + " : " + amount;
                }
                else if(amount<0){
                        return paidBy + " owes " + paidTo + " : " + Math.abs(amount);
                }
                return "";
        }
}
