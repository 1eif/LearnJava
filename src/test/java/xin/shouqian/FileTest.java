package xin.shouqian;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    /**
     * 文件属性
     */
    @Test
    public void testFileProperty() {
        File file = new File("D:/aaa.exe");

        // 文件大小（字节）
        long size = file.length();
        System.out.println("file size:" + size);
        // 转换为可读性高的单位
        System.out.println("file size:" + byteCountToDisplay(BigInteger.valueOf(size)));

        // 文件的最后修改时间
        long timestamp = file.lastModified();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(timestamp);
        String lastmodified = simpleDateFormat.format(date);
        System.out.println("last modified:" + lastmodified);

        // 是否是隐藏文件
        boolean isHidden = file.isHidden();
        System.out.println("isHidden ? " + isHidden);
    }

    // 大数显示
    private String byteCountToDisplay(BigInteger size) {
        // 1024进制 byte->kb->MB->GB->TB->PB->EB

        final BigInteger ONE_KB = BigInteger.valueOf(1024);
        final BigInteger ONE_MB = ONE_KB.multiply(ONE_KB);
        final BigInteger ONE_GB = ONE_KB.multiply(ONE_MB);
        final BigInteger ONE_TB = ONE_KB.multiply(ONE_GB);
        final BigInteger ONE_PB = ONE_KB.multiply(ONE_TB);
        final BigInteger ONE_EB = ONE_KB.multiply(ONE_PB);

        String displaySize = "";
        if (size.divide(ONE_EB).compareTo(BigInteger.ZERO) > 0) {
            displaySize = size.divide(ONE_EB) + " EB";
        } else if (size.divide(ONE_PB).compareTo(BigInteger.ZERO) > 0) {
            displaySize = size.divide(ONE_PB) + " PB";
        } else if (size.divide(ONE_TB).compareTo(BigInteger.ZERO) > 0) {
            displaySize = size.divide(ONE_TB) + " TB";
        } else if (size.divide(ONE_GB).compareTo(BigInteger.ZERO) > 0) {
            displaySize = size.divide(ONE_GB) + " GB";
        } else if (size.divide(ONE_MB).compareTo(BigInteger.ZERO) > 0) {
            displaySize = size.divide(ONE_MB) + " MB";
        } else if (size.divide(ONE_KB).compareTo(BigInteger.ZERO) > 0) {
            displaySize = size.divide(ONE_KB) + " KB";
        } else {
            displaySize = size + " bytes";
        }
        return displaySize;
    }

    @Test
    public void testNumber() {
        long max = Long.MAX_VALUE;
        System.out.println(max);

        BigInteger bi = BigInteger.valueOf(Long.MAX_VALUE);
        bi = bi.add(BigInteger.ONE);
        System.out.println(bi);
    }
}
