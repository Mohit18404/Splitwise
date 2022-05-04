package com.swiggy.swiggy.services;

import com.swiggy.swiggy.Pojo.Expense;
import com.swiggy.swiggy.Pojo.Split;
import com.swiggy.swiggy.Pojo.UserData;
import com.swiggy.swiggy.enums.ExpenseType;
import org.apache.catalina.User;

import java.util.List;

public interface SplitService {
//    show();
//    showAll();
    Expense addExpense(ExpenseType expenseType, double amount, UserData paidBy, List<Split> splitList);
}
