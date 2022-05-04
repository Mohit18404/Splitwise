package com.swiggy.swiggy;

import com.swiggy.swiggy.Pojo.Group;
import com.swiggy.swiggy.Pojo.UserData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataPopulator {


    static Map<Integer, UserData> userDataMap = new HashMap<>();
    static Map<Integer, Group> groupDataMap = new HashMap<>();


    public static void getUserDataMap() {
        UserData u1 = UserData
                .builder()
                .userId(1)
                .name("mohit")
                .build();
        UserData u2 = UserData
                .builder()
                .userId(1)
                .name("rohit")
                .build();
        UserData u3 = UserData
                .builder()
                .userId(1)
                .name("anshik")
                .build();
        UserData u4 = UserData
                .builder()
                .userId(1)
                .name("yashu")
                .build();

        userDataMap.put(1, u1);
        userDataMap.put(2, u2);
        userDataMap.put(3, u3);
        userDataMap.put(4, u4);
    }

    public static void getGroupDataMap() {
        List<UserData> userDataList = new ArrayList<>();
        userDataMap.forEach( (key, value) -> userDataList.add(value));
        Group group = new Group();
        group.setGroupId(1);
        group.setGroupName("flat");
        group.setUserDataList(userDataList);

        groupDataMap.put(1, group);
    }

    public static Map<String, Double> balanceSheet = new HashMap<>();

    public static void getBalanceSheet() {
        balanceSheet.put("1 2", 0.0);
        balanceSheet.put("1 3", 0.0);
        balanceSheet.put("1 4", 0.0);
        balanceSheet.put("2 1", 0.0);
        balanceSheet.put("2 3", 0.0);
        balanceSheet.put("2 4", 0.0);
        balanceSheet.put("3 1", 0.0);
        balanceSheet.put("3 2", 0.0);
        balanceSheet.put("3 4", 0.0);
        balanceSheet.put("4 1", 0.0);
        balanceSheet.put("4 2", 0.0);
        balanceSheet.put("4 3", 0.0);
    }

    public static void setUp() {
        getUserDataMap();
        getGroupDataMap();
        getBalanceSheet();
    }

}
