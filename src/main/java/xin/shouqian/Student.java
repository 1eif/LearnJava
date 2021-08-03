package xin.shouqian;

import java.io.Serializable;

public class Student implements Serializable { // 序列化必须实现这个空接口

    // 序列化版本ID，校验作用
    private static final long serialVersionUID = 1L;

    private String id;
    private String userName;
    private String address;
    // transient关键字不参与序列化
    // get出值为null
    private transient String zipCode;

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
