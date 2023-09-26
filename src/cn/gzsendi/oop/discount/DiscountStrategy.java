package cn.gzsendi.oop.discount;

/**
 * 优惠策略接口，用于定义优惠策略实现类必须实现哪些方法
 */
public interface DiscountStrategy {

    /**
     * 该接口定义了一个基于优惠策略计算出来的最终商品价格
     * @param price 商品的原始价格
     * @return 返回商品优惠之后的最终价格
     */
    double applyDiscount(double price);

}


