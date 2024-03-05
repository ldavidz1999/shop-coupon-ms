package com.example.shopcouponms.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "favorite_stats")
public class FavoriteStats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "item_id")
    private String itemId;
    private Integer quantity;
}
