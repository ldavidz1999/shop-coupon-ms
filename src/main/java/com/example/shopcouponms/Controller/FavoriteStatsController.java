package com.example.shopcouponms.Controller;


import com.example.shopcouponms.Model.FavoriteStats;
import com.example.shopcouponms.Service.FavoriteStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shop-coupon/api/coupon/")
public class FavoriteStatsController {
    @Autowired
    private FavoriteStatService favoriteStatService;
    @GetMapping("/stats")
    public ResponseEntity<List<FavoriteStats>> getFavoriteStats(){
        List<FavoriteStats> response = favoriteStatService.getFavoriteStatsOverall();
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
}
