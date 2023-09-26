package cn.gzsendi.oop.discount;

import java.util.HashMap;
import java.util.Map;

/**
 * 商品价格计算器，实际上的系统可能没有这么简单，这里是简化的代码，直接使用 HashMap 来在内存里记录商品以及优惠策略的映射关系
 * 真实系统这些数据往往会记录在数据库中，等后面接触数据库之后这部分功能就能改造成跟现实系统更加接近的代码了
 */
public class PriceCalculator {

    // 此处模拟优惠记录的地方，实际上真实业务场景中这里可能是个数据库，用来记录业务运营人员在前端页面上配置的各种商品的打折优惠策略数据
    private final Map<Product, DiscountStrategy> productDiscountStrategyMap = new HashMap<>(10);

    // 模拟运营人员在前端页面上配置的各种商品的打折优惠策略
    public void registerDiscountStrategy(Product product, DiscountStrategy discountStrategy) {
        productDiscountStrategyMap.put(product, discountStrategy);
    }

    // 计算商品经过优惠策略计算之后的价格
    public double calculatePriceWithDiscount(Product product) {

        // 此处使用优惠策略接口类型来定义优惠策略，但各个策略的真实类型是接口的不同实现子类，
        // 此处即展示了Java的多态特性，即一个接口可能有多种不同的实现子类，但是这些不同的子类都可以当成是该接口的类型，即向上转型
        // 这种特性的好处在于，我们可以根据优惠策略的接口类来写计算商品最终价格的代码，即使后面我们想新增一些新的商品以及优惠策略，这部分代码固定下来了，可能不再需要去修改它了
        // 需要修改的地方仅仅在于新增商品类、策略类型，然后（在前端页面）配置两者的对应关系（此处即为修改 cn.gzsendi.main.PriceCalculatorMain main函数）
        // 减少修改已有代码往往意味着减少出错的机会、减少测试、开发等工作量，更是代码通用兼容性的体现
        DiscountStrategy discountStrategy = productDiscountStrategyMap.get(product);

        if (discountStrategy == null) {
            // 当给定的商品没有找到已注册的优惠策略，这里有两种选择，一种是直接抛出异常提醒用户，另一种直接使用无优惠策略，取决于业务场景
            // throw new IllegalArgumentException("商品[" + product.getName() + "] 没有注册优惠策略");
            discountStrategy = new NoDiscountStrategy();
        }

        return discountStrategy.applyDiscount(product.getPrice());
    }

}
