package com.devsuperior.desafio01;

import com.devsuperior.entities.Order;
import com.devsuperior.services.OrderService;
import com.devsuperior.services.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.devsuperior"})
public class Desafio01Application implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(Desafio01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Order order = new Order(1309, 95.90, 0.0);
		System.out.println("Pedido código " + order.getCode());
		System.out.printf("Valor total: R$ %.2f%n", orderService.total(order));
	}
}
