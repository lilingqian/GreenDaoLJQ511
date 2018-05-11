package com.example.lenovo.greendao_ljq_511.bean;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

//定义表名
@Entity(nameInDb = "t_user")
public class User {
    @Id(autoincrement = true)
    private Long id;
    //定义属性的这个属性在数据的名字
    @Property(nameInDb = "t_name")
    private String name;
    @Property
    private String age;
    @Transient//这个是不生成这个字段
    private String agent;

    @Generated(hash = 1666193281)
    public User(Long id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return this.age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    //重写tostring
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                +
                        '}';
    }
}

