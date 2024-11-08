package com.evance.drinkstore.controller;

import com.evance.drinkstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private CartService cartService;

    @PostMapping("/submit")
    public String submitOrder(@RequestParam String customerName, @RequestParam String address) {
        // 在這裡處理訂單邏輯，保存訂單，並清空購物車
        cartService.clearCart();
        return "redirect:/order/success";
    }

    @GetMapping("/success")
    public String orderSuccess() {
        return "order/success";
    }
}
