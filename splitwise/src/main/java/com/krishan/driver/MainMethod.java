package com.krishan.driver;

import com.krishan.models.Split.EqualSplit;
import com.krishan.models.Split.ExactSplit;
import com.krishan.models.Split.PercentSplit;
import com.krishan.models.Split.Split;
import com.krishan.models.User;
import com.krishan.repository.ExpenseRepository;
import com.krishan.services.SplitWiseService;
import com.krishan.services.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author krish
 */
public class MainMethod {
        public static void main(String args[]){
                User user1 = new User(1, "user1","user1@gmail.com","9999999999");
                User user2 = new User(2, "user2","user2@gmail.com","8888888888");
                User user3 = new User(3, "user3","user3@gmail.com","7777777777");
                User user4 = new User(4, "user4","user4@gmail.com","6666666666");
                
                ExpenseRepository expenseRepository = new ExpenseRepository();
                UserService userService = new UserService(expenseRepository);
                userService.addUser(user1);
                userService.addUser(user2);
                userService.addUser(user3);
                userService.addUser(user4);
                SplitWiseService service = new SplitWiseService(expenseRepository);
                
                
                while (true) {
                        Scanner scan = new Scanner(System.in);
                        String[] commands = scan.nextLine().split(" ");
                        String action = commands[0];
                        switch (action){
                                case "EXPENSE":
                                        String amountPaidBy = commands[1];
                                        double expenseAmount = Double.parseDouble(commands[2]);
                                        int totalMembers = Integer.parseInt(commands[3]);
                                        List<Split> splits = new ArrayList<>();
                                        int expenseIndex = 3 + totalMembers + 1;
                                        String operation  = commands[expenseIndex];
                                        switch (operation){
                                                case "EQUAL":
                                                        for (int i = 0; i < totalMembers; i++) {
                                                            splits.add(new EqualSplit(userService.getUser(commands[4+i])));
                                                        }
                                                        service.addExpense(expenseAmount, amountPaidBy, splits, operation);
                                                        break;
                                            case "EXACT":
                                                        for (int i = 0; i < totalMembers; i++) {
                                                                System.out.println(commands[expenseIndex+i+1]);
                                                            splits.add(new ExactSplit(
                                                                            userService.getUser(commands[4+i]),
                                                                            Double.parseDouble(commands[expenseIndex+i+1]))
                                                            );
                                                        }
                                                        System.out.println(splits);
                                                        service.addExpense(expenseAmount, amountPaidBy, splits, operation);

                                                        break;
                                            case "PERCENT":
                                                        for (int i = 0; i < totalMembers; i++) {
                                                            splits.add(
                                                                    new PercentSplit(
                                                                            userService.getUser(commands[4+i]),
                                                                            Double.parseDouble(commands[expenseIndex+i+1]))
                                                            );
                                                        }
                                                        service.addExpense(expenseAmount, amountPaidBy, splits, operation);
                                                        break;
                                        }
                                        break;
                                        
                            case "SHOW":
                                if(commands.length == 1)
                                    service.showBalances();
                                else
                                    service.showBalance(commands[1]);
                                break;
                            case "QUIT":
                                 System.out.println("Quiting...");
                                 return;
                            default:
                                System.out.println("No Expected Argument Found");
                                break;
                        }

                    }
                
                
//                 while(true){
//                        Scanner sc = new Scanner(System.in);
//                        String commands[] = sc.nextLine().split(" ");
//                        
//                        switch(commands[0]){
//                                case "EXIT":
//                                        return;
//                                case "SHOW":
//                                        if(commands.length==1)
//                                                service.showBalances();
//                                        else
//                                                service.showBalance(commands[1]);
//                                        break;
//                                case "EXPENSE":
//                                        String amountPaidBy = commands[1];
//                                        double expenseAmount = Double.parseDouble(commands[2]);
//                                        System.out.println(expenseAmount);
//                        
//                                        int amongNoOfUsers = Integer.parseInt(commands[3]);
//                                        System.out.println(amongNoOfUsers);
//                                        
//                                        String[] usersWhoOwes = new String[amongNoOfUsers];
//                                        for(int i=0;i<amongNoOfUsers;i++){
//                                                usersWhoOwes[i] = commands[i+4];
//                                        }
//
//                                        String operation = commands[4+amongNoOfUsers];
//                                        System.out.println(operation);
//                                        List<Split> splits = new ArrayList<>();
//                                        switch(operation){
//                                                case "EQUAL":
//                                                        for(int i=0;i<amongNoOfUsers;i++){
//                                                                splits.add(new EqualSplit(userService.getUser(usersWhoOwes[i])));  
//                                                        }
//                                                        service.addExpense(expenseAmount, amountPaidBy, splits, operation);
//                                                        break;
//                                                case "EXACT":
//                                                        double exactAmountArr[] = new double[amongNoOfUsers];
//                                                        for(int i=0;i<amongNoOfUsers;i++){
//                                                                exactAmountArr[i] = Double.parseDouble(commands[5+i+amongNoOfUsers]);
//                                                        }
//                                                        for(int i=0;i<amongNoOfUsers;i++){
//                                                                splits.add(new ExactSplit(userService.getUser(usersWhoOwes[i]),exactAmountArr[i]));       
//                                                        }
//                                                        service.addExpense(expenseAmount, amountPaidBy, splits, operation);
//                                                        break;
//                                                case "PERCENT":
//                                                        double percentAmountArr[] = new double[amongNoOfUsers];
//                                                        for(int i=0;i<amongNoOfUsers;i++){
//                                                                percentAmountArr[i] = Double.parseDouble(commands[5+i+amongNoOfUsers]);
//                                                        }
//                                                        for(int i=0;i<amongNoOfUsers;i++){
//                                                                splits.add(new ExactSplit(userService.getUser(usersWhoOwes[i]),percentAmountArr[i]));       
//                                                        }
//                                                        service.addExpense(expenseAmount, amountPaidBy, splits, operation);
//                                                        break;
//                                                default:
//                                                        break;
//                                        }
//                                        break;
//                                default:
//                                        break;
//                        }
//                 
//                }
                
        }
}
