package com.example.EffectiveJava.B_创建和销毁对象;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by heshixiyang on 2017/5/26.
 */
public class A_考虑用静态工厂方法代替构造器 {
    /**
     * 优势：1.有名字：如果有多个构造器，那么用户可能不能区分各个构造器的用途。
     *       2.能复用：不必每次调用都创建新的类型，对于频繁创建而变化又不是很大的类有大帮助
     *       3.可抽象：构造方法只能返回本类的实例，而这个可以返回本类的任何子类型
     *
     * 劣势：1.如果类没有public或protect的构造方法就不能被子类化
     *       2.静态工厂方法就是一个静态方法，没有特别之处，所以没有构造器实例化那么明显。
     */

    //优势1
    static class Number{
        public Number(int a) {
            System.out.println("返回偶数");
        }
        public Number(int a,int b) {
            System.out.println("返回奇数");
        }
        public Number(int a,int b,int c) {
            System.out.println("返回素数");
        }

        public static Number provide偶数(){
            return new Number(0);
        }
        public static Number provide奇数(){
            return new Number(0,1);
        }
        public static Number provide素数(){
            return new Number(0,1,2);
        }
    }

    //优势2  放要发出大量网络请求的时候
    static class Request{
        private static Request singleInstanceGet=new Request(0);
        private static Request singleInstancePost=new Request(0,1);
        private static Request singleInstancePut=new Request(0,1,2);

        private int param1;
        private int param2;
        private int param3;

        public Request(int a) {
            System.out.println("GET请求");
        }
        public Request(int a, int b) {
            System.out.println("POST请求");
        }
        public Request(int a, int b, int c) {
            System.out.println("PUT请求");
        }

        public static Request provideGetRequest(int a){
            singleInstanceGet.param1=a;
            return singleInstanceGet;
        }
        public static Request providePostRequest(int a, int b){
            singleInstancePost.param1=a;
            singleInstancePost.param2=b;
            return singleInstancePost;
        }
        public static Request providePutRequest(int a, int b, int c){
            singleInstancePut.param1=a;
            singleInstancePut.param2=b;
            singleInstancePut.param3=c;
            return singleInstancePut;
        }
    }

    //优势3
    interface Service{
        void doSomeThing();
    }

    interface ServiceProvider{
        Service provideService();
    }

    static class Services{
        private Services() {
        }

        private static final Map<String,ServiceProvider> providers=new ConcurrentHashMap<>();
        public static final String DEFAULT_PROVIDER_NAME="def";

        public static void registerDefaultProvider(ServiceProvider serviceProvider){
            registerProvider(DEFAULT_PROVIDER_NAME,serviceProvider);
        }

        public static void registerProvider(String name,ServiceProvider serviceProvider){
            providers.put(name,serviceProvider);
        }

        public static Service newInstance(){
            return providers.get(DEFAULT_PROVIDER_NAME).provideService();
        }

        public static Service newInstance(String name) throws IllegalAccessException {
            ServiceProvider serviceProvider=providers.get(name);
            if (serviceProvider==null)throw new IllegalAccessException("No provider register with name:"+name);
            return serviceProvider.provideService();
        }
    }

    static class ServiceOne implements Service{
        public ServiceOne() {
            System.out.println("ServiceOne be created");
        }

        @Override
        public void doSomeThing() {
            System.out.println("ServiceOne do something");
        }
    }
    static class ServiceTwo implements Service{
        public ServiceTwo() {
            System.out.println("ServiceTwo be created");
        }

        @Override
        public void doSomeThing() {
            System.out.println("ServiceTwo do something");
        }
    }

    static class ServiceOneProvider implements ServiceProvider{
        @Override
        public Service provideService() {
            return new ServiceOne();
        }
    }

    static class ServiceTwoProvider implements ServiceProvider{
        @Override
        public Service provideService() {
            return new ServiceTwo();
        }
    }

    public static void main(String[] args) throws IllegalAccessException {
        Number.provide偶数();
        Number.provide奇数();
        Number.provide素数();


        Request.provideGetRequest(1);
        Request.providePostRequest(1,2);
        Request.providePutRequest(1,2,3);


        Services.registerDefaultProvider(new ServiceOneProvider());
        Services.registerProvider("serviceOneProvider",new ServiceOneProvider());
        Services.registerProvider("serviceTwoProvider",new ServiceTwoProvider());

        Services.newInstance().doSomeThing();
        Services.newInstance("serviceOneProvider").doSomeThing();
        Services.newInstance("serviceTwoProvider").doSomeThing();
    }


}
