
public class Product {
	private int productId;
	private String name, description;
	
	public Product(int productId, String name, String description, float price) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	private float price;
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name
				+ ", description=" + description + ", price=" + price + "]";
	}
	public int getProductId() {
		return productId;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public float getPrice() {
		return price;
	}
	
	
}
