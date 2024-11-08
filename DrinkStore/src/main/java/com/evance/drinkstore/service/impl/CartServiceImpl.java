package com.evance.drinkstore.service.impl;

import com.evance.drinkstore.service.CartService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService {

    // 假設我們用 Map 來保存購物車中的商品，商品 ID -> 商品數量
    private Map<Long, Integer> cartItems = new HashMap<>();

    // 添加商品到購物車
    public void addToCart(Long productId) {
        cartItems.put(productId, cartItems.getOrDefault(productId, 0) + 1);
    }

    // 獲取所有購物車中的商品 ID 和數量
    public Map<Long, Integer> getCartItems() {
        return cartItems;
    }

    // 計算購物車中的商品總數
    public int getCartItemCount() {
        return cartItems.values().stream().mapToInt(Integer::intValue).sum();
    }

    // 清空購物車
    public void clearCart() {
        cartItems.clear();
    }

    // 移除某一商品
    public void removeItem(Long productId) {
        cartItems.remove(productId);
    }
}
