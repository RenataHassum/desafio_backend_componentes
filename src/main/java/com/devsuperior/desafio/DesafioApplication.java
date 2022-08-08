package com.devsuperior.desafio;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.devsuperior.desafio.entities.Order;
import com.devsuperior.desafio.services.OrderService;

@SpringBootApplication
@ComponentScan({"com.devsuperior"})
public class DesafioApplication implements CommandLineRunner {
	
	@Autowired
	public OrderService orderService;
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		SpringApplication.run(DesafioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.print("Código do pedido: ");
		Integer code = sc.nextInt();
		
		System.out.print("Valor básico: ");
		Double basic = sc.nextDouble();
		
		System.out.print("Porcentagem de desconto: ");
		Double discount = sc.nextDouble();
		
		Order order = new Order(code, basic, discount);
		System.out.println("Pedido código: " + order.getCode());
		System.out.printf("Valor total: R$ %.2f%n", orderService.total(order));
		
		sc.close();
	
	}
}
