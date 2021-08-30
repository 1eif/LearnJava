package xin.shouqian;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CsvTest {

    @Test
    public void testWriterCsv() {

        Product[] products = new Product[] {
                new Product("笔记本", 9999,"黑色"),
                new Product("手机", 3999,"红色"),
                new Product("书", 9,"白色")
        };

        try {
            PrintStream printStream = new PrintStream("D:/a.csv", "GBK");

            printStream.println("Name,Price,Color");
            for (Product product : products) {
                printStream.println(product.getName() + "," + product.getPrice() + "," + product.getColor());
            }

            printStream.flush();
            printStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testReaderCsv() {
        try {
            Scanner scanner = new Scanner(new FileInputStream("D:/a.csv"), "GBK");
            scanner.useDelimiter("\r\n");

            List<Product> productList = new ArrayList<>();

            int i = 0;
            while (scanner.hasNext()) {
                String line = scanner.next();

                i++;
                if(i == 1) {
                    continue;
                }

                String[] strs = line.split(",");
                Product product = new Product(strs[0], Double.valueOf(strs[1]), strs[2]);

                productList.add(product);

                for (Product p : productList) {
                    System.out.println(p);

                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}


