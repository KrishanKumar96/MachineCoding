/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.krishan.services;

import com.krishan.models.Expense.EqualExpense;
import com.krishan.models.Expense.ExactExpense;
import com.krishan.models.Expense.Expense;
import com.krishan.models.Expense.PercentExpense;
import com.krishan.models.Split.PercentSplit;
import com.krishan.models.Split.Split;
import com.krishan.repository.ExpenseRepository;
import java.util.List;

/**
 *
 * @author krish
 */
public class ExpenseService {

        public Expense createExpenses(String amountPaidBy, double expenseAmount, List<Split> splits, String operation ){
                switch(operation){
                        case "EQUAL":
                                double equalAmount = expenseAmount/(double)(splits.size());
                                for(Split split : splits){
                                        split.setAmount(equalAmount);
                                }
                                return new EqualExpense(expenseAmount, amountPaidBy, splits);
                                
                        case "EXACT":
                                return new ExactExpense(expenseAmount, amountPaidBy, splits);
                                
                        case "PERCENT":
                                for(Split split : splits){
                                        PercentSplit sp = (PercentSplit)split;
                                        sp.setAmount(expenseAmount * sp.getPercent() * 0.01);
                                }
                                return new PercentExpense(expenseAmount, amountPaidBy, splits);
                                
                        default:
                                return null;
                }
        }
}
