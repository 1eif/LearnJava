package cn.laufan;

public class FilterByNameCondition implements FilterCondition {
    @Override
    public boolean test(Product product) {
        return product.getName().contains("水");
    }
}
