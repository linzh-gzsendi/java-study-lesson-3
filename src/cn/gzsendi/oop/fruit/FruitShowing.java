package cn.gzsendi.oop.fruit;

// 父类：水果类
class Fruit {
    protected String name;
    protected String color;

    public Fruit(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public void eat() {
        System.out.println("吃水果：" + color + "颜色的" + name);
    }
}

// 子类：苹果类
class Apple extends Fruit {
    private String variety;

    public Apple(String name, String color, String variety) {
        super(name, color);
        this.variety = variety;
    }

    public String getVariety() {
        return variety;
    }

    @Override
    public void eat() {
        System.out.println("吃苹果，颜色：" + this.color + "，品种：" + variety);
        System.out.println("吃苹果，颜色：" + this.getColor() + "，品种：" + getVariety());
    }
}

// 子类：香蕉类
class Banana extends Fruit {
    private int length;

    public Banana(String name, String color, int length) {
        super(name, color);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void eat() {
        System.out.println("吃香蕉，颜色：" + this.color + "，长度：" + length);
        System.out.println("吃香蕉，颜色：" + this.getColor() + "，长度：" + getLength());
    }

}

public class FruitShowing {
    public static void main(String[] args) {
        Apple apple = new Apple("苹果", "红色", "红富士");
        apple.eat();

        Banana banana = new Banana("香蕉", "黄色", 15);
        banana.eat();
    }
}