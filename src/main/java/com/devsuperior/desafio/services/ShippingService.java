package com.devsuperior.desafio.services;

import org.springframework.stereotype.Service;

import com.devsuperior.desafio.entities.Order;

@Service
public class ShippingService {
	
	public double shipment(Order order) {
		if(order.getBasic() > 200.0) {
			return 0.0;
		} else if (order.getBasic() < 200.00 && order.getBasic() > 100.0) {
			return 12.0;
		} else {
			return 20.0;
		}
	}
}
