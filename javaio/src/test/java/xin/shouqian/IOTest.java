package xin.shouqian;

import org.junit.Test;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IOTest {

    @Test
    public void testCopyFile() {

        try {
            //InputStream inputStream = new FileInputStream("D:/temp/aaa.txt");
            InputStream inputStream = new FileInputStream(new File("D:/temp/aaa.txt"));
            OutputStream outputStream = new FileOutputStream("D:/temp/bbb.txt");
            // 大文件会很慢
            int readByte;
            while ((readByte = inputStream.read()) != -1) {
                outputStream.write(readByte);
            }

            outputStream.flush();
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCopyFile2() {

        try {
            InputStream inputStream = new FileInputStream("D:/temp/aaa.txt");
            OutputStream outputStream = new FileOutputStream("D:/temp/bbb.txt");

            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0 , len);
            }

            outputStream.flush();
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCopyFile3() {

        try {
            InputStream inputStream = new FileInputStream("D:/temp/aaa.txt");
            OutputStream outputStream = new FileOutputStream("D:/temp/bbb.txt");


            // 装饰者模式
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

//            int readByte;
//            while ((readByte = bufferedInputStream.read()) != -1) {
//                bufferedOutputStream.write(readByte);
//            }

            byte[] buffer = new byte[1024];
            int len;
            while ((len = bufferedInputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer, 0 , len);
            }

            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            bufferedInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCopyFile4() {

        Path sourcePath = Paths.get("D:/temp/aaa.txt");
        Path targetPath = Paths.get("D:/temp/bbb.txt");

        try {
            Files.copy(sourcePath, targetPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testCopyFile5() {

        try {
            FileChannel sourceChannel = new FileInputStream("D:/temp/aaa.txt").getChannel();
            FileChannel targetChannel = new FileOutputStream("D:/temp/bbb.txt").getChannel();

            // in -> out
            //sourceChannel.transferTo(0, sourceChannel.size(), targetChannel);
            targetChannel.transferFrom(sourceChannel, 0, sourceChannel.size());

            sourceChannel.close();
            targetChannel.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCopyFile6() {

        try {
            RandomAccessFile readFile = new RandomAccessFile("D:/temp/aaa.txt", "r");
            RandomAccessFile writeFile = new RandomAccessFile("D:/temp/bbb.txt", "rw");

            byte[] buffer = new byte[1024];
            int len;
            while ((len = readFile.read(buffer)) != -1) {
                writeFile.write(buffer, 0 , len);
            }

            readFile.close();
            writeFile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
