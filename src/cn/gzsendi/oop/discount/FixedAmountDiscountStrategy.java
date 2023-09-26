package cn.gzsendi.oop.discount;

/**
 * 满减优惠策略
 */
public class FixedAmountDiscountStrategy implements DiscountStrategy {

    // 商品价格满多少
    private final double threshold;
    // 减价多少
    private final double discountAmount;

    public FixedAmountDiscountStrategy(double threshold, double discountAmount) {
        // 先检查一下优惠减价是否比满减的门槛价还低，比如满30减50，这就不合理了
        if (threshold < discountAmount)
            throw new IllegalArgumentException("门槛价低于优惠减价，请检查策略是否合理！");

        this.threshold = threshold;
        this.discountAmount = discountAmount;
    }

    /**
     * 计算满减优惠的商品价格，
     * @param price 商品的原始价格
     * @return
     */
    public double applyDiscount(double price) {
        // 如果商品不满足门槛价，则返回商品原始价格，否则减去优惠价格
        return price < threshold ? price : price - discountAmount;
    }
}
