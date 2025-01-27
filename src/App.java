
import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.entities_enum.OrderStatus;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter cliente data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.next());

        Client client = new Client(name, email, birthDate);

        System.out.println("Enter order date: ");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());
        System.out.print("How many items to this order? ");
        int n = sc.nextInt();

        Order order = new Order(client, new Date(), status);

        for(int i = 1; i <= n; i++){
            System.out.println("Enter #" + i + " item data: ");
            System.out.print("Product name: ");
            sc.next();
            String nameProduct = sc.nextLine();
            System.out.print("Product price: ");
            Double price = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            OrderItem orderItem = new OrderItem(price, new Product(nameProduct, price), quantity);
            
            order.addItem(orderItem);
        }
        System.out.println("ORDER SUMMARY:");
        
        System.out.println(order);

    sc.close();
    }
}
