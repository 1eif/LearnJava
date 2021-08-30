package cn.laufan;

public class FilterByPriceCondition implements FilterCondition {
    @Override
    public boolean test(Product product) {
        return product.getPrice() >= 600;
    }
}
