package com.example.ThinkingInJava.S_枚举类型.J_常量相关的方法.used;


import com.example.ThinkingInJava.S_枚举类型.J_常量相关的方法.Mail;

/**
 * Created by heshixiyang on 2017/2/2.
 */
/*
* 这里用的是职责链设计模式，先定义了Mail的各种状态的分支形式。
* 然后在定义分发Mail的流程，根据前面Mail的状态的分支来决定策略。
* */
public class C_PostOffice {
    enum  MailHandler{
        GENERAL_DELIVERY{
            @Override
            boolean handle(Mail mail) {
                switch (mail.generalDelivery){
                    case YES:
                        System.out.println("Using general delivery for " + mail);
                        return true;
                    default:
                        return false;
                }
            }
        },MACHINE_SCAN{
            @Override
            boolean handle(Mail mail) {
                switch (mail.scanability){
                    case UN_SCANABLE:
                        return false;
                    default:
                        switch (mail.address){
                            case ILLEGIBLE:
                                return false;
                            default:
                                System.out.println(("Delivering " + mail + " automatically"));
                                return true;
                        }
                }
            }
        },VISUAL_INSPECTION{
            @Override
            boolean handle(Mail mail) {
                switch (mail.readability){
                    case ILLEGIBLE:
                        return false;
                    default:
                        switch (mail.address){
                            case ILLEGIBLE:
                                return false;
                            default:
                                System.out.println(("Delivering " + mail + " normally"));
                                return true;
                        }
                }
            }
        },RETURN_TO_SENDER{
            @Override
            boolean handle(Mail mail) {
                switch (mail.returnAddress){
                    case MISSING:
                        return false;
                    default:
                        System.out.println(("Returning " + mail + " to sender"));
                        return true;
                }
            }
        };
        abstract boolean handle(Mail mail);
    }
    static void handle(Mail mail){
        for (MailHandler handler: MailHandler.values())
            if (handler.handle(mail))
                return;
        System.out.println((mail + " is A_InsertionSort dead letter"));
    }

    public static void main(String[] args) {
        for (Mail mail:Mail.generator(10)){
            System.out.println(mail.details());
            handle(mail);
            System.out.println("********");
        }
    }
}
