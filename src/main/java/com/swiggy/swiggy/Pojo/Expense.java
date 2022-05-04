package com.swiggy.swiggy.Pojo;

import com.swiggy.swiggy.enums.ExpenseType;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class Expense {
    private double amount;
    private UserData paidBy;
    private Date date;
    private List<Split> splitList;
    private ExpenseType expenseType;
}
