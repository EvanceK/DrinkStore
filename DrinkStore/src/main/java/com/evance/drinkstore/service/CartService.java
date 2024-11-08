package com.evance.drinkstore.service;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: CartService
 * ClassName: com.evance.drinkstore.service
 * Description:
 *
 * @Author: Evance
 * @Create: 2024/11/8-下午 03:38
 */
public interface CartService {
    void addToCart(Long productId);
    Map<Long, Integer> getCartItems();

    int getCartItemCount();

    void clearCart();

    void removeItem(Long productId);
}
