package com.example.shopcouponms.Model.Request;

import lombok.Data;

import java.util.List;

@Data
public class CouponRequest {
    Long amount;
    List<String> itemList;
}
