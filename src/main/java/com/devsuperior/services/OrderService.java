package com.devsuperior.services;

import com.devsuperior.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ShippingService shippingService;

    public double total(Order order) {
        if(order.getDiscount() != 0.0) {
            double desconto = order.getBasic() - (order.getBasic() * (order.getDiscount() / 100));
            return desconto + shippingService.shipment(order);
        } else
            return order.getBasic() + shippingService.shipment(order);
    }
}
