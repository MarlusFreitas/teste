package entities;

public class OrderItem {
    private Integer quantity;
    private Double price;

    private Product product;

    public OrderItem() {
    }

    public OrderItem(Double price, Product product, Integer quantity) {
        this.price = price;
        this.product = product;
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public Product getProduct() {
        return product;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double subTotal(){
        return price * quantity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(product.getName());
        sb.append(", $").append(String.format("%.2f", price));
        sb.append(", Quantity: ").append(quantity);
        sb.append(", Subtotal").append(subTotal());
        sb.append("\n");
        return sb.toString();
    }


}
