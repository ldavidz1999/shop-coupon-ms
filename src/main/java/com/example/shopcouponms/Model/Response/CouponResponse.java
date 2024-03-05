package com.example.shopcouponms.Model.Response;

import lombok.Data;

import java.util.List;

@Data
public class CouponResponse {
    public List<String> itemsIds;
    public Double total;
}
