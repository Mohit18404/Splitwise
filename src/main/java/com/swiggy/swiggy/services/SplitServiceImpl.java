package com.swiggy.swiggy.services;

import com.swiggy.swiggy.DataPopulator;
import com.swiggy.swiggy.Pojo.Expense;
import com.swiggy.swiggy.Pojo.Split;
import com.swiggy.swiggy.enums.ExpenseType;
import com.swiggy.swiggy.Pojo.UserData;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SplitServiceImpl implements SplitService {

    @Override
    public Expense addExpense(ExpenseType expenseType, double amount, UserData paidBy, List<Split> splitList) {
        Expense expense = null;
        Map<String, Double> balanceSheet = DataPopulator.balanceSheet;

        if(expenseType.equals(ExpenseType.EQUAL)) {
            int numberOfSplits = splitList.size();;
            double amountToBeSplit = amount/numberOfSplits;
            for(Split split : splitList) {
                split.setAmount(amountToBeSplit);
            }

            expense = Expense.builder()
                    .expenseType(expenseType)
                    .amount(amount)
                    .date(new Date())
                    .paidBy(paidBy)
                    .splitList(splitList)
                    .build();

            for(Split split : splitList) {
                int userId2 = split.getUserData().getUserId();
                String expensekey1 = paidBy.getUserId() + " " + userId2;
                double amountToBeAdd = balanceSheet.get(expensekey1);
                amountToBeAdd+=split.getAmount();
                balanceSheet.put(expensekey1, amountToBeAdd);
                String expensekey2 = userId2 +" "+paidBy.getUserId();
                double amountToBeAdd1 = balanceSheet.get(expensekey2);
                amountToBeAdd1-=split.getAmount();
                balanceSheet.put(expensekey2, amountToBeAdd1);
            }

        }else if(expenseType.equals(ExpenseType.EXACT)) {

            expense = Expense.builder()
                    .expenseType(expenseType)
                    .amount(amount)
                    .date(new Date())
                    .paidBy(paidBy)
                    .splitList(splitList)
                    .build();
        }

        return expense;
    }

}
