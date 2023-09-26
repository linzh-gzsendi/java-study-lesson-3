package cn.gzsendi.oop.discount;

/**
 * 商品类
 */
public class Product {
    // 商品名
    private String name;
    // 商品原始价格
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
