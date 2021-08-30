package cn.laufan;

public class FilterByTypeCondition implements FilterCondition{

    @Override
    public boolean test(Product product) {
        return product.getType().equals("数码类");
    }
}
