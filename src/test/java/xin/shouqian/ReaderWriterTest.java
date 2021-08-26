package xin.shouqian;

import org.junit.Test;

import java.io.*;
import java.lang.reflect.Parameter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

public class ReaderWriterTest {

    private static final String FILEPATH = "D:/a.txt";

    @Test
    public void testFileWriter() {
        try {
            Writer writer = new FileWriter(FILEPATH,true);// 追加模式
            char ch = 'A';
            writer.write(ch);
            writer.write("\r\n");
            writer.write("Hello Java");
            writer.write("\r\n");
            writer.write("中文\r\n");

            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFileReader() {
        try {
            Reader reader = new FileReader(FILEPATH);
//            int ch;
//            while ((ch = reader.read()) != -1) {
//                System.out.print((char) ch);
            int len;
            char[] buffer = new char[128];
            while ((len = reader.read(buffer)) != -1) {
                System.out.print(new String(buffer, 0, len));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testBufferedWriter() {
        try {

            Writer writer = new FileWriter(FILEPATH, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.write("aaaa\r\n");
            bufferedWriter.write("aaaabbbbb\r\n");

            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testBufferedReader() {
        try {
            Reader reader = new FileReader(FILEPATH);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String str;
            while ((str = bufferedReader.readLine()) != null) {
                System.out.println(str);
            }

            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPrintStream() {

        try {
            PrintStream printStream = new PrintStream(FILEPATH);

            printStream.println("Hello");

            printStream.flush();
            printStream.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPrintWrite() {
        try {
            PrintWriter printWriter = new PrintWriter(FILEPATH);

            printWriter.println("aaa");
            printWriter.flush();
            printWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void testScanner() {

        try {
            InputStream inputStream = new FileInputStream(FILEPATH);
            Scanner scanner = new Scanner(inputStream);

            // 更改默认分隔符
            //scanner.useDelimiter("\r\n");
            String lineSeparator = System.getProperty("line.separator");
            scanner.useDelimiter(lineSeparator);

            while (scanner.hasNext()) {
                String str = scanner.next();
                System.out.println(str);

            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFilesReader() {
        Path path = Paths.get(FILEPATH);

        try {
            List<String> stringList = Files.readAllLines(path);
            for (String str : stringList) {
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFilesWriter() {
        Path path = Paths.get(FILEPATH);

        String str = "hello";
        try {
            Files.write(path, str.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


