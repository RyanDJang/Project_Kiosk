import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Menu {
    private List<Product> items;

    public Menu() {
        items = new ArrayList<>();
    }

    public void addItem(Product product) {
        items.add(product);
    }

    public void display() {
        System.out.println("메뉴:");
        for (Product product : items) {
            System.out.println(product.getName() + " - 원" + product.getPrice());
            System.out.println("   " + product.getDescription());
        }
    }
}

class Product {
    private String name;
    private double price;
    private String description;

    public Product(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}

class Order {
    private List<Product> items;

    public Order() {
        items = new ArrayList<>();
    }

    public void addItem(Product product) {
        items.add(product);
    }

    public double calculateTotal() {
        double totalCost = 0.0;
        for (Product product : items) {
            totalCost += product.getPrice();
        }
        return totalCost;
    }

    public void display() {
        System.out.println("고객님의 주문 :");
        for (Product product : items) {
            System.out.println(product.getName() + " - 원" + product.getPrice());
            System.out.println("   " + product.getDescription());
        }
    }
}

public class CafeKiosk {
    public static void main(String[] args) {
        // Create a menu
        Menu menu = new Menu();
        menu.addItem(new Product("커피", 3500, "깊고 그윽한 향의 커피입니다."));
        menu.addItem(new Product("차", 4000, "다양한 종류의 차입니다."));
        menu.addItem(new Product("머핀", 3900, "맛있는 머핀입니다."));
        menu.addItem(new Product("샌드위치", 5000, "영양가 있는 샌드위치입니다."));

        // Initialize variables
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();

        // Display the menu to the customer
        System.out.println("메가커피에 오신 것을 환영합니다!");
        menu.display();

        // Take the customer's order
        while (true) {
            System.out.print("원하시는 메뉴를 골라주세요. 끝내시려면 '완료' 버튼을 눌러주세요.");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("완료")) {
                break;
            }

            Product selectedProduct = null;
            for (Product product : menu.getItems()) {
                if (product.getName().equalsIgnoreCase(choice)) {
                    selectedProduct = product;
                    break;
                }
            }

            if (selectedProduct != null) {
                order.addItem(selectedProduct);
            } else {
                System.out.println("메뉴에 없는 선택입니다. 다시 골라주세요.");
            }
        }

        // Display the customer's order and total cost
        order.display();
        System.out.println("총 금액 : 원" + order.calculateTotal());

        // Close the scanner
        scanner.close();
    }
}