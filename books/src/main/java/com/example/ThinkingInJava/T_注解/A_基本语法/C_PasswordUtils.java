package com.example.ThinkingInJava.T_注解.A_基本语法;

import java.util.List;

/**
 * Created by heshixiyang on 2017/2/3.
 */
/*
* 注释的时候使用键值对的形式，没有给出值的会使用默认值，如果没有默认值会报错。
* java内置了三种标准注解：@Override、@Deprecated、@SuppressWarning
* 四种元注解：
* 1.@Target：
*   1.ElementType.CONSTRUCTOR  构造器声明
*   2.ElementType.FIELD  字段声明包括enum实例
*   3.ElementType.LOCAL_VARIABLE  局部变量声明
*   4.ElementType.METHOD  方法声明
*   5.ElementType.PACKAGE  包声明
*   6.ElementType.PARAMETER  参数声明
*   7.ElementType.TYPE  类、接口或者enum声明
* 2.@Retention：
*   1.RetentionPolicy.SOURCE注解将被编译器丢弃
*   2.RetentionPolicy.CLASS注解在Class文件中，但是会被VM丢弃
*   3.RetentionPolicy.RUNTIME  在运行时也保存，所以我们可以通过反射机制读取注解信息
* 3.@Documented：此注解包含在javadoc中
* 4.@Inherited:允许子类继承父类中的注解。
* */
public class C_PasswordUtils {

    @B_UseCase(id=47,description = "Passwords must contain at least one numeric")
    public boolean validatePassword(String passWord){
        return !(passWord==null);
    }

    @B_UseCase(id=48)
    public String encryptPassword(String password){
        return new StringBuilder(password).reverse().toString();
    }

    @B_UseCase(id=49,description = "New Passwords can not equal previously used ones")
    public boolean checkForNewPassword(List<String> prevPasswords,String password){
        return !prevPasswords.contains(password);
    }

}
