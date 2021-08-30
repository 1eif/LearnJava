package cn.laufan;

public interface FilterCondition {

    // 策略模式
    // 接口作为参数传入
    boolean test(Product product);
}
