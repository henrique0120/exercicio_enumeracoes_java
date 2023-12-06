package exe_fix_enum;


public class OrderItem {
	private Integer quantity;
	private double price;
	
	private Product product;
	public OrderItem() {
		
	}

	public OrderItem(Integer quantity, double price, Product product) {
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double subTotal() {
		return quantity * price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public OrderItem(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return product + "Quantity: " + quantity +", Subtotal: $"+ String.format("%.2f", subTotal());
	}
	
	
}
