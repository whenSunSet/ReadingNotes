package com.example.ThinkingInJava.T_注解.B_编写注释处理器;

import com.example.T_注解.B_编写注释处理器.used.B_SQLString;
import com.example.T_注解.B_编写注释处理器.used.D_DBTable;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by heshixiyang on 2017/2/3.
 */
public class TableCreator {
    public static void main(String[] args) throws ClassNotFoundException {
//        if (args.length<1){
//            System.out.println("arguments: annotated classes");
//            System.exit(0);
//        }
        args=new String[]{"com.example.twenty_注解.two_编写注释处理器.C_Member"};
        for (String className:args){
            Class<?> cl=Class.forName(className);
            D_DBTable DDbTable =cl.getAnnotation(D_DBTable.class);
            if (DDbTable ==null){
                System.out.println(("No D_DBTable annotations in class " + className));
                continue;
            }
            String tableName= DDbTable.name();
            if (tableName.length()<1)
                tableName=cl.getName().toUpperCase();
            List<String> columnDefs=new ArrayList<>();
            for (Field field:cl.getDeclaredFields()){
                String columnName=null;
                Annotation[] annotations=field.getDeclaredAnnotations();
                if (annotations.length<1) continue;
                if (annotations[0] instanceof SQLInteger)
                if (annotations[0] instanceof SQLInteger){
                    SQLInteger sqlInteger=(SQLInteger)annotations[0];

                    if (sqlInteger.name().length()<1)
                        columnName=field.getName().toUpperCase();
                    else
                        columnName=sqlInteger.name();

                    columnDefs.add(columnName+" INT "+getConstraints(sqlInteger.constraints()));
                }

                if (annotations[0] instanceof B_SQLString){
                    B_SQLString BSqlString_ =(B_SQLString)annotations[0];

                    if (BSqlString_.name().length()<1)
                        columnName=field.getName().toUpperCase();
                    else
                        columnName= BSqlString_.name();

                    columnDefs.add(columnName+" VARCHAR("+ BSqlString_.value()+")"+getConstraints(BSqlString_.constraints()));
                }

                StringBuilder createCommand=new StringBuilder("CREATE TABLE "+tableName+"(");

                for (String columnDef : columnDefs)
                    createCommand.append("\n     "+columnDef+",");
                String tableCreate =createCommand.substring(0,createCommand.length()-1)+");";
                System.out.println(("Table Creation SQL for " + className + " is :\n" + tableCreate));
            }
        }
    }

    public static String getConstraints(Constraints con){
        String constraints="";
        if (!con.allowNull())
            constraints+=" NOT NULL";
        if (con.primaryKey())
            constraints+=" PRIMARY KEY";
        if (con.unique())
            constraints+=" UNIQUE ";
        return constraints;
    }
}
