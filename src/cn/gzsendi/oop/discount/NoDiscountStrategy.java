package cn.gzsendi.oop.discount;

/**
 * 无优惠的策略，即计算的时候直接返回商品原始价格
 */
public class NoDiscountStrategy implements DiscountStrategy {
    /**
     * 直接返回商品原始价格
     * @param price 商品的原始价格
     * @return 直接返回商品原始价格
     */
    @Override
    public double applyDiscount(double price) {
        return price;
    }
}
