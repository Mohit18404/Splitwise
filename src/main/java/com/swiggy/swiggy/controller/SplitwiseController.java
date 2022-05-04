package com.swiggy.swiggy.controller;

import com.swiggy.swiggy.DataPopulator;
import com.swiggy.swiggy.Pojo.Split;
import com.swiggy.swiggy.enums.ExpenseType;
import com.swiggy.swiggy.requests.AddExpenseRequest;
import com.swiggy.swiggy.services.SplitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class SplitwiseController {

    @Autowired
    private SplitServiceImpl splitService;

    @PostMapping("/add")
    public void addExpenses(@RequestBody AddExpenseRequest addExpenseRequest) throws Exception {
        if (addExpenseRequest.getExpenseType().equals(ExpenseType.EXACT)) {
            List<Split> splitList = addExpenseRequest.getSplitList();
            double amountTotal = 0;
            for (Split split :
                    splitList) {
                amountTotal += split.getAmount();
            }

            if (amountTotal != addExpenseRequest.getAmount()) {
                throw new Exception(HttpStatus.BAD_REQUEST.name());
            } else {
                splitService.addExpense(addExpenseRequest.getExpenseType(), addExpenseRequest.getAmount()
                        , addExpenseRequest.getPaidBy(), addExpenseRequest.getSplitList());
            }
        } else {
            splitService.addExpense(addExpenseRequest.getExpenseType(), addExpenseRequest.getAmount()
                    , addExpenseRequest.getPaidBy(), addExpenseRequest.getSplitList());
        }
    }

    @GetMapping("set")
    public void setUp() {
        DataPopulator.setUp();
    }

    @GetMapping("show")
    public String show(@RequestParam int first, @RequestParam int second) {
        String response = "";
        Map<String, Double> data = DataPopulator.balanceSheet;

        String key = first + " " + second;
        double amount =  data.get(key);

        if(amount<0) {
            response = first + " owe " + amount +" to the " + second;
        }else {
            response = second + " owe " + amount +" to the " + first;
        }

        return response;
    }

}
