/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.krishan.models.Expense;

import com.krishan.models.Split.ExactSplit;
import com.krishan.models.Split.Split;
import java.util.List;

/**
 *
 * @author krish
 */
public class ExactExpense extends Expense{
        
        public ExactExpense(double expenseAmount, String amountPaidBy, List<Split> splits) {
                super(expenseAmount, amountPaidBy, splits);
        }

        @Override
        public boolean validate() {
                double totalAmount = 0;
                double expenseAmount = getExpenseAmount();
                for(Split split: getSplits()){
                        if(!(split instanceof ExactSplit))
                                return false;
                        totalAmount+=split.getAmount();
                }
                return totalAmount == expenseAmount;
        }
        
}
