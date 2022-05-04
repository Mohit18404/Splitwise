package com.swiggy.swiggy.requests;

import com.swiggy.swiggy.Pojo.Split;
import com.swiggy.swiggy.Pojo.UserData;
import com.swiggy.swiggy.enums.ExpenseType;

import java.util.List;


public class AddExpenseRequest {
    private ExpenseType expenseType;
    private double amount;
    private UserData paidBy;
    private List<Split> splitList;

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public UserData getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(UserData paidBy) {
        this.paidBy = paidBy;
    }

    public List<Split> getSplitList() {
        return splitList;
    }

    public void setSplitList(List<Split> splitList) {
        this.splitList = splitList;
    }

    @Override
    public String toString() {
        return "AddExpenseRequest{" +
                "expenseType=" + expenseType +
                ", amount=" + amount +
                ", paidBy=" + paidBy +
                ", splitList=" + splitList +
                '}';
    }
}
