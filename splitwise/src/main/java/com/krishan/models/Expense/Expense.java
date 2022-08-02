/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.krishan.models.Expense;

import com.krishan.models.Split.Split;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author krish
 */
public abstract class Expense {
        private String expenseId;
        private double expenseAmount;
        private String amountPaidBy;
        private List<Split> splits;

        public Expense(double expenseAmount, String amountPaidBy, List<Split> splits) {
                this.expenseId = UUID.randomUUID().toString();
                this.expenseAmount = expenseAmount;
                this.amountPaidBy = amountPaidBy;
                this.splits = splits;
        }

        public String getExpenseId() {
                return expenseId;
        }

        public void setExpenseId(String expenseId) {
                this.expenseId = expenseId;
        }

        public double getExpenseAmount() {
                return expenseAmount;
        }

        public void setExpenseAmount(double expenseAmount) {
                this.expenseAmount = expenseAmount;
        }

        public String getAmountPaidBy() {
                return amountPaidBy;
        }

        public void setAmountPaidBy(String amountPaidBy) {
                this.amountPaidBy = amountPaidBy;
        }

        public List<Split> getSplits() {
                return splits;
        }

        public void setSplits(List<Split> splits) {
                this.splits = splits;
        }
        
        public abstract boolean validate();
}
