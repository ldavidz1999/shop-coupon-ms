package com.example.shopcouponms.Service;

import com.example.shopcouponms.Model.FavoriteStats;
import com.example.shopcouponms.Repository.FavoriteStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FavoriteStatServiceImpl implements  FavoriteStatService{

    @Autowired
    private FavoriteStatsRepository favoriteStatsRepository;
    @Override
    @Transactional
    public void saveOrUpdateFavoriteStat(String itemId) {
        FavoriteStats favoriteStats = favoriteStatsRepository.findByItemId(itemId);
        if (favoriteStats != null){
            favoriteStats.setQuantity(favoriteStats.getQuantity() + 1);
        } else {
            favoriteStats = new FavoriteStats();
            favoriteStats.setItemId(itemId);
            favoriteStats.setQuantity(1);
        }
        favoriteStatsRepository.save(favoriteStats);
    }

    @Override
    @Transactional
    public List<FavoriteStats> getFavoriteStatsOverall() {
        return favoriteStatsRepository.findAll();
    }
}
