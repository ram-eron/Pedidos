package main;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import entities.Cliente;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enums.OrderStatus;

public class Main {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws ParseException {
		Cliente cli1 = new Cliente();
		Order order = new Order();
		
		cli1.setNome(imputDados("nome do cliente"));
		cli1.setEmail(imputDados("email do cliente"));
		cli1.setBirthDate(imputDados("data de Aniversario do cliente (DD/MM/YYYY)"));
		
		// atribuindo o cliente ao pedido
		order.setCliente(cli1);
		
		System.out.println("\n\n");
		
		System.out.println("Dados do pedido: ");
		
		//status do pedido
		order.setStatus(OrderStatus.valueOf(imputDados("Status")));
		
		// Montando objeto Order com dados do pedido
		Integer x = Integer.parseInt(imputDados("quantidade de itens"));
		for (int i = 0; i < x; i++) {
			String nome = imputDados("nome do produto " + (i+1));
			Double preco = Double.parseDouble(imputDados("preço do produto " + (i+1)));
			Integer qtd = Integer.parseInt(imputDados("quantidade desse produto"));
			
			order.addItem(new OrderItem(qtd,preco,new Product(nome, preco)));
		}
		order.setMoment(new Date());
		
		System.out.println(order);
		
	}

	private static String imputDados(String texto) {
		System.out.println("informe o " + texto + " :");
		return sc.nextLine();
	}
	
}
