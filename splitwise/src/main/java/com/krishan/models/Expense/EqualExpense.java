/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.krishan.models.Expense;

import com.krishan.models.Split.EqualSplit;
import com.krishan.models.Split.Split;
import java.util.List;

/**
 *
 * @author krish
 */
public class EqualExpense extends Expense {
        
        public EqualExpense(double expenseAmount, String amountPaidBy, List<Split> splits) {
                super(expenseAmount, amountPaidBy, splits);
        }

        @Override
        public boolean validate() {
               for(Split split : getSplits()){
                       if(!(split instanceof EqualSplit))
                               return false;
               }
               return true;
        }
        
}
