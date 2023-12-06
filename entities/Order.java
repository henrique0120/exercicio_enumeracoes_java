package exe_fix_enum;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private Date moment;
	private OrderStatus status;
	
	private Client client;
	
	private List<OrderItem> orders = new ArrayList<>();
	public Order() {
	}


	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}


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
	
	public void addItem(OrderItem item) {
		orders.add(item);
	}
	public void removeItem(OrderItem item) {
		orders.remove(item);
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public Order(Client client) {
		this.client = client;
	}

	public double total() {
		double sum = 0.0;
		for(OrderItem x : orders) {
			sum += x.subTotal();
		}
		return sum;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY:\n");
		sb.append("Order moment: " );
		sb.append(sdf.format(moment));
		sb.append("\nOrder status: "); 
		sb.append(status);
		sb.append("\n");
		sb.append("Client: "); 
		sb.append(client); 
		sb.append("\nOrder items: \n");
		for(OrderItem x : orders) {
			sb.append(x + "\n");
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();

	}
	
}
