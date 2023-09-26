package cn.gzsendi.oop.discount;

/**
 * 百分比折扣优惠策略
 */
public class PercentageDiscountStrategy implements DiscountStrategy {

    // 百分比折扣力度
    private final double percentage;

    public PercentageDiscountStrategy(double percentage) {
        this.percentage = percentage;
    }

    /**
     * 计算折扣之后商品的优惠价格
     * @param price 商品的原始价格
     * @return 折扣之后商品的优惠价格
     */
    @Override
    public double applyDiscount(double price) {
        return price * (percentage / 100);
    }
}
