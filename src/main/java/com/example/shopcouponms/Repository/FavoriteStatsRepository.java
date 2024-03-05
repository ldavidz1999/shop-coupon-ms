package com.example.shopcouponms.Repository;

import com.example.shopcouponms.Model.FavoriteStats;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteStatsRepository extends JpaRepository<FavoriteStats,Integer> {

    FavoriteStats findByItemId(String itemId);

    List<FavoriteStats> findAll();
}
