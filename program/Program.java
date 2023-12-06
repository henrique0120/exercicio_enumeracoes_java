package exe_fix_enum;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;




public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		SimpleDateFormat sdf0 = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf0.parse(sc.next());
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		sc.nextLine();
		String status = sc.nextLine();
		Client client = new Client(name, email, birthDate);
		Order order = new Order(sdf.parse("20/04/2018 11:25:09"), OrderStatus.valueOf(status), client);
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			System.out.println("Enter #" + i +" item data: ");
			System.out.print("Product name: ");
			sc.nextLine();
			String nameP = sc.nextLine();
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			OrderItem item = new OrderItem(quantity, price, new Product(nameP, price));
			order.addItem(item);
		}
		System.out.println();
		System.out.println(order);
		
		sc.close();
	}

}
