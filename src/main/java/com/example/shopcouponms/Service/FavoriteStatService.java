package com.example.shopcouponms.Service;

import com.example.shopcouponms.Model.FavoriteStats;

import java.util.List;

public interface FavoriteStatService {
    public void saveOrUpdateFavoriteStat(String itemId);
    public List<FavoriteStats> getFavoriteStatsOverall();
}
