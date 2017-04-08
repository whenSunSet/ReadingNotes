package com.example.ThinkingInJava.T_注解.B_编写注释处理器.used;


import com.example.ThinkingInJava.T_注解.B_编写注释处理器.Constraints;
import com.example.ThinkingInJava.T_注解.B_编写注释处理器.SQLInteger;

/**
 * Created by heshixiyang on 2017/2/3.
 */
/*
* firstName使用了快捷方式：如果在注释中定义了名为value的元素，并且其为唯一需要赋值的元素，就可以用快捷方式赋值。
* 注解不支持继承，也就是说不能用关键字extends来继承某个@interface
* */
@D_DBTable(name = "MEMBER")
public class C_Member {
    @B_SQLString(value = 30,name = "xue")
    String firstName;

    @B_SQLString(50)
    String lastName;

    @SQLInteger()
    Integer age;

    @B_SQLString(value = 30,constraints = @Constraints(primaryKey = true))
    String handle;

    static int memberCount;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getHandle() {
        return handle;
    }

    @Override
    public String toString() {
        return handle;
    }
}
