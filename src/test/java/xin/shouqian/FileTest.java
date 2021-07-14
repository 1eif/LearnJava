package xin.shouqian;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class FileTest {

    /**
     * 文件分隔符
     */
    @Test
    public void testSeparator() {

        // 路径分隔符 \  /
        System.out.println("D:" + File.separator + "Data");

        String str = System.getProperty("file.separator");
        System.out.println(str);

        // PATH环境变量分隔符 ; :
        System.out.println(File.pathSeparator);
        System.out.println(System.getProperty("path.separator"));
    }


    /**
     * 获取系统相关信息
     */
    @Test
    public void testSystemProperty() {
        Properties properties = System.getProperties();
        Set<Map.Entry<Object, Object>> entries = properties.entrySet();
        for (Map.Entry<Object, Object>entry : entries) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

    }

    @Test
    public void testCreateFile() {
        File file = new File("D:/abc.txt");
//        File file = new File("D:/", "abc.txt");
        // 判断路径是否是一个文件
        System.out.println(file.isFile());

        // 判断路径是否存在
        System.out.println(file.exists());

        if (!file.exists()) {
            try {
                boolean isCreate = file.createNewFile();
                System.out.println("isCreate ?" + isCreate);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
