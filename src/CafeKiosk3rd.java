import java.util.ArrayList;
import java.util.List;

class Menu {
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

class Product extends Menu {
    private int price;

    public Product(String name, int price, String description) {
        super(name, description);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}

class Order {
    private List<Product> products;

    public Order() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public List<Product> getProducts() {
        return products;
    }
}

public class StarbucksKiosk {
    public static void main(String[] args) {
        // 스타벅스 메뉴 생성
        Menu americanoMenu = new Menu("아메리카노", "에스프레소와 물을 섞은 음료");
        Product latte = new Product("카페 라떼", 5500, "에스프레소와 스팀 우유를 섞은 음료");
        Product cappuccino = new Product("카푸치노", 6000, "에스프레소, 스팀 우유, 우유 거품의 조합");

        // 주문 생성
        Order order = new Order();
        order.addProduct(americanoMenu);
        order.addProduct(latte);
        order.addProduct(cappuccino);

        // 주문 내역 출력
        System.out.println("주문 내역:");
        for (Product product : order.getProducts()) {
            System.out.println(product.getName() + " - " + product.getPrice() + "원 - " + product.getDescription());
        }
    }
}
