package com.swiggy.swiggy.Pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserData {
    private int userId;
    private String name;
}
