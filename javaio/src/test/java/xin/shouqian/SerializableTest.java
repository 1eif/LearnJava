package xin.shouqian;

import org.junit.Test;

import java.io.*;

public class SerializableTest {

    @Test
    public void testWriterObject() {
        Student student = new Student();
        student.setId("1001");
        student.setUserName("张三");
        student.setAddress("北京");

        try {
            // 序列化
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("D:/student.lf"));
            outputStream.writeObject(student);

            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testReadObject() {
        try {

            // 反序列化
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("D:/student.lf"));

            Student student = (Student) inputStream.readObject();
            System.out.println(student.getId());
            System.out.println(student.getUserName());
            System.out.println(student.getAddress());

            inputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
