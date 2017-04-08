package com.example.ThinkingInJava.S_枚举类型.J_常量相关的方法;

import com.example.S_枚举类型.F_随机选取.Enums;

import java.util.Iterator;

/**
 * Created by heshixiyang on 2017/2/2.
 */
public class Mail {
    public enum GeneralDelivery{YES,NO1,NO2,NO3,NO4,NO5}
    public enum Scanability{UN_SCANABLE,YES1,YES2,YES3,YES4}
    public enum Readability{ILLEGIBLE,YES1,YES2,YES3,YES4}
    public enum Address{ILLEGIBLE,OK1,OK2,OK3,OK4,OK5,OK6}
    public enum ReturnAddress{MISSING,OK1,OK2,OK3,OK4,OK5}

    public GeneralDelivery generalDelivery;
    public Scanability scanability;
    public Readability readability;
    public Address address;
    public ReturnAddress returnAddress;
    static long counter=0;
    long id=counter++;

    @Override
    public String toString() {
        return "Mail "+id;
    }

    public String details(){
        return toString()+
                ",General Delivery "+generalDelivery+
                ",Address Scanability "+scanability+
                ",Address Readability "+readability+
                ",Address Address: "+address+
                ", Return address: "+returnAddress;
    }

    public static Mail randomMail(){
        Mail mail=new Mail();
        mail.generalDelivery= Enums.random(GeneralDelivery.class);
        mail.scanability=Enums.random(Scanability.class);
        mail.readability=Enums.random(Readability.class);
        mail.address=Enums.random(Address.class);
        mail.returnAddress=Enums.random(ReturnAddress.class);
        return mail;
    }

    public static Iterable<Mail> generator(final int count){
        return new Iterable<Mail>() {
            int n=count;
            @Override
            public Iterator<Mail> iterator() {
                return new Iterator<Mail>() {
                    @Override
                    public boolean hasNext() {
                        return n-->0;
                    }

                    @Override
                    public Mail next() {
                        return randomMail();
                    }
                };
            }
        };
    }
}
