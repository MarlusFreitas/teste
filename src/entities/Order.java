package entities;

import entities.entities_enum.OrderStatus;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private Date moment;
    private OrderStatus status;

    private Client client;
    private List<OrderItem> items = new ArrayList<>();


    public Order() {
    }

    public Order(Client client, Date moment, OrderStatus status) {
        this.client = client;
        this.moment = moment;
        this.status = status;
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

    public List<OrderItem> getItems() {
        return items;
    }

    public void addItem(OrderItem item){
        items.add(item);
    }

    public void removeItem(OrderItem item){
        items.remove(item);
    }

    public Double total(){
        double sum = 0;

        for (OrderItem orderItem : items) {
            sum += orderItem.subTotal();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order moment: ");
        sb.append(sdf.format(moment)).append("\n");
        sb.append("Order status: ").append(status).append("\n");
        sb.append("client: ").append(client);
        sb.append("Order items: ");
        for (OrderItem orderItem : items) {
            sb.append(orderItem);
        }
        sb.append("\n");
        sb.append("Total price: $");
        sb.append(String.format("%.2f", total()));
        return sb.toString();
    }


    
}
