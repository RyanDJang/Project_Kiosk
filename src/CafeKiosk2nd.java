import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 메뉴 클래스 (Menu 클래스)
class AllMenu {
    private String name;
    private String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

// 상품 클래스 (Product 클래스) - 메뉴 클래스 상속
class Product extends Menu {
    private double price;

    public Product(String name, String description, double price) {
        super(name, description);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

// 주문 클래스 (Order 클래스)
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
        System.out.println("주문 내역:");
        for (Product product : items) {
            System.out.println(product.getName() + " - 원" + product.getPrice());
            System.out.println("   " + product.getDescription());
        }
    }
}

public class CafeKiosk {
    public static void main(String[] args) {
        // 메뉴 항목 생성
        Menu americanoMenu = new Menu("아메리카노", "진한 에스프레소와 물의 균형을 맞춘 음료");
        Menu latteMenu = new Menu("라떼", "에스프레소와 스팀밀크의 환상적인 조화");
        Menu croissantMenu = new Menu("크로와상", "부드럽고 바삭한 프랑스 페스츄리");
        Menu sandwichMenu = new Menu("샌드위치", "다양한 신선한 재료로 만든 샌드위치");

        // 상품 항목 생성
        Product americano = new Product("아메리카노", "진한 에스프레소와 물의 균형을 맞춘 음료", 4000);
        Product latte = new Product("라떼", "에스프레소와 스팀밀크의 환상적인 조화", 4500);
        Product croissant = new Product("크로와상", "부드럽고 바삭한 프랑스 페스츄리", 3000);
        Product sandwich = new Product("샌드위치", "다양한 신선한 재료로 만든 샌드위치", 6000);

        // 주문 객체 생성
        Order order = new Order();

        // 주문할 상품 추가
        order.addItem(americano);
        order.addItem(croissant);
        order.addItem(sandwich);

        // 주문 내역과 총 가격 출력
        order.display();
        System.out.println("총 금액: 원" + order.calculateTotal());
    }
}