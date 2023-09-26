package cn.gzsendi.main;

import cn.gzsendi.oop.discount.*;

public class PriceCalculatorMain {

    public static void main(String[] args) {
        // 商场国庆期间为了促销搞起了优惠活动
        PriceCalculator calculator = new PriceCalculator();

        // 满1000减200优惠策略
        DiscountStrategy fixedAmountDiscount1000minus200 = new FixedAmountDiscountStrategy(1000, 200);
        // 8折优惠策略
        DiscountStrategy percentageDiscount80 = new PercentageDiscountStrategy(80);
        // 平价商品不打折策略
        DiscountStrategy noDiscount = new NoDiscountStrategy();

        Product sportShoes = new Product("品牌运动鞋", 1200);
        Product tShirt = new Product("男装上衣", 100);
        Product fruit = new Product("苹果", 10);

        calculator.registerDiscountStrategy(sportShoes, fixedAmountDiscount1000minus200);
        calculator.registerDiscountStrategy(tShirt, percentageDiscount80);
        calculator.registerDiscountStrategy(fruit, noDiscount);

        System.out.println("[" + sportShoes.getName() + "] 商品在此次促销活动中的售价为：" + calculator.calculatePriceWithDiscount(sportShoes));
        System.out.println("[" + tShirt.getName() + "] 商品在此次促销活动中的售价为：" + calculator.calculatePriceWithDiscount(tShirt));
        System.out.println("[" + fruit.getName() + "] 商品在此次促销活动中的售价为：" + calculator.calculatePriceWithDiscount(fruit));
    }
}
