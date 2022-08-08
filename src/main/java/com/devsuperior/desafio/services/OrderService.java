package com.devsuperior.desafio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.desafio.entities.Order;

@Service
public class OrderService {
	
	@Autowired
	ShippingService shippingService;
	
	public double total(Order order) {
		
		double shipping = shippingService.shipment(order);
		double total = order.getBasic() - order.getBasic() * (order.getDiscount() / 100) + shipping;
		return total;
	}	
}
