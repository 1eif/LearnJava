package xin.shouqian;

import org.junit.Test;

import java.io.*;

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
}
