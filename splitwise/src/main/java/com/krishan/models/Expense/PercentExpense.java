/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.krishan.models.Expense;

import com.krishan.models.Split.PercentSplit;
import com.krishan.models.Split.Split;
import java.util.List;

/**
 *
 * @author krish
 */
public class PercentExpense extends Expense{
        public PercentExpense(double expenseAmount, String amountPaidBy, List<Split> splits) {
                super(expenseAmount, amountPaidBy, splits);
        }

        @Override
        public boolean validate() {
                double totalPercent = 0;
                for(Split split : getSplits()){
                        if(!(split instanceof PercentSplit))
                                return false;
                        PercentSplit ps = (PercentSplit) split;
                        totalPercent+=ps.getPercent();
                }
                return 100 == totalPercent;
        }
        
        
}
