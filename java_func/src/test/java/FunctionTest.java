import cn.laufan.*;
import org.junit.Test;

import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FunctionTest {

    List<Product> productList = Arrays.asList( //List.of()
            new Product("短裤", 328F, "服装类"),
            new Product("电脑", 888F, "数码类"),
            new Product("神仙水", 1288F, "美妆类"),
            new Product("麦克风", 588F, "数码类"),
            new Product("T恤", 220F, "服装类"),
            new Product("键盘", 599F, "数码类")
    );

    @Test
    public void test() {

        // 数码类
        List<Product> digitalProductList = new ArrayList<>();

        for (Product product : productList) {
            if ("数码类".equals(product.getType())) {
                digitalProductList.add(product);
            }
        }

        for (Product product : digitalProductList) {
            System.out.println(product);
        }
//        System.out.println(digitalProductList);

        System.out.println("==================================================");

        List<Product> highPriceProductList = new ArrayList<>();
        for (Product product : productList) {
            if (product.getPrice() >= 600) {
                highPriceProductList.add(product);
            }
        }

        for (Product product : highPriceProductList) {
            System.out.println(product);
        }
    }

    @Test
    public void test2() {
        List<Product> productList1 = filterByType(productList, "数码类");
        List<Product> productList2 = filterByType(productList, "美妆类");

        System.out.println(productList1);
        System.out.println(productList2);
        System.out.println("========================================");

        List<Product> productList3 = filterByPrice(productList, 1000F);

        System.out.println(productList3);
    }

    @Test
    public void test3() {

        // 策略模式
        List<Product> productList1 = filter(productList, new FilterByTypeCondition());

        System.out.println(productList1);

        List<Product> productList2 = filter(productList, new FilterByPriceCondition());

        System.out.println(productList2);

        List<Product> productList3 = filter(productList, new FilterByNameCondition());

        System.out.println(productList3);

    }

    @Test
    public void test4() {
        // 策略模式 + 匿名内部类
        List<Product> productList1 = filter(productList, new FilterCondition() {
            @Override
            public boolean test(Product product) {
                return product.getType().equals("服装类");
            }
        });

        System.out.println(productList1);

        List<Product> productList2 = filter(productList, new FilterCondition() {
            @Override
            public boolean test(Product product) {
                return product.getPrice() >= 1000;
            }
        });

        System.out.println(productList2);

    }

    @Test
    public void test5() {
        // lambda
        List<Product> productList1 = filter(productList, product -> product.getType().equals("数码类"));
        System.out.println(productList1);

        System.out.println("=======================");

        List<Product> productList2 = filter(productList, product -> product.getPrice() >= 600);
        System.out.println(productList2);
    }




    private List<Product> filter(List<Product> productList, FilterCondition condition) {
        List<Product> subList = new ArrayList<>();

        for (Product product : productList) {
            if (condition.test(product)) {
                subList.add(product);
            }
        }

        return subList;
    }

    // 类型过滤
    private List<Product> filterByPrice(List<Product> productList, Float price) {
        List<Product> subList = new ArrayList<>();
        for (Product product : productList) {
            if (product.getPrice() >= price) {
                subList.add(product);
            }
        }
        return subList;
    }

    // 类型过滤
    private List<Product> filterByType(List<Product> productList, String type) {

        List<Product> subList = new ArrayList<>();

        for (Product product : productList) {
            if (type.equals(product.getType())) {
                subList.add(product);
            }
        }

        return subList;
    }
}
