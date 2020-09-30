package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enums.OrderStatus;

public class Order {

	Date moment;
	OrderStatus status;
	List<OrderItem> items = new ArrayList<>();
	Cliente cliente;
	
	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void addItem(OrderItem orderItem) {
		this.items.add(orderItem);
	}
	
	public void removeItem(OrderItem orderItem) {
		this.items.remove(orderItem);
	}
	
	public Double total() {
		Double total = 0.0;
		for (OrderItem orderItem : items) {
			total += orderItem.Subtotal();
		}
		return total;
	}

	@Override
	public String toString() {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		StringBuilder sb = new StringBuilder();
		sb.append("Sumario do pedido:");
		sb.append("\nmomento: " + df.format(moment));
		sb.append("\nstatus: " + status);
		sb.append("\nCliente: " + cliente);
		sb.append("\nitens do pedido: \n");
		
		for (OrderItem orderItem : items) {
			sb.append(orderItem.getProduct().getName());
			sb.append(", $" + orderItem.getProduct().getPrice());
			sb.append(", Quantidade: " + orderItem.getQuantity());
			sb.append(", Subtotal: " + orderItem.Subtotal());
			sb.append("\n");
		}
		
		sb.append("\nValor total: " + total());
		
		
		return sb.toString();
	}
	
	

}
