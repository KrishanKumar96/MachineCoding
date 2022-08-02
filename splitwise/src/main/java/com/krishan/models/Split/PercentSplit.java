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
public class PercentSplit extends Split{
        double percent;
        
        public PercentSplit(User user, double percent) {
                super(user);
                this.percent = percent;
        }

        public double getPercent() {
                return percent;
        }

        public void setPercent(double percent) {
                this.percent = percent;
        }
        
}
