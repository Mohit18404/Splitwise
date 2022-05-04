package com.swiggy.swiggy.Pojo;

import lombok.Data;

import java.util.List;

@Data
public class Group {
    private int groupId;
    private String groupName;
    private List<UserData> userDataList;
}
