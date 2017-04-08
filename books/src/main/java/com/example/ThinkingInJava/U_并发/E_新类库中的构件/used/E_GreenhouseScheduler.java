package com.example.ThinkingInJava.U_并发.E_新类库中的构件.used;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by heshixiyang on 2017/2/7.
 */
/*
* ScheduledThreadPoolExecutor可以延时调用线程或者延时重复调度线程。
* 这里用 Collections.synchronizedList(new ArrayList<>());获取一个自动同步的List
* */
public class E_GreenhouseScheduler {
    private volatile  boolean light=false;
    private volatile  boolean water=false;
    private String thermostat="Day";

    public synchronized String getThermostat() {
        return thermostat;
    }

    public synchronized void setThermostat(String thermostat) {
        this.thermostat = thermostat;
    }

    ScheduledThreadPoolExecutor scheduledThreadPoolExecutor=new ScheduledThreadPoolExecutor(10);
    public void schedule(Runnable event,long delay){
        scheduledThreadPoolExecutor.schedule(event,delay, TimeUnit.MILLISECONDS);
    }
    public void repeat(Runnable event,long initialDelay,long period){
        scheduledThreadPoolExecutor.scheduleAtFixedRate(event,initialDelay,period,TimeUnit.MILLISECONDS);
    }

    class LightOn implements Runnable{
        @Override
        public void run() {
            System.out.println("Turning on light");
            light=true;
        }
    }

    class LightOff implements Runnable{
        @Override
        public void run() {
            System.out.println("Turning off light");
            light=false;
        }
    }

    class WaterOn implements Runnable{
        @Override
        public void run() {
            System.out.println("Turning on water");
            water=true;
        }
    }

    class WaterOff implements Runnable{
        @Override
        public void run() {
            System.out.println("Turning off water");
            water=false;
        }
    }

    class ThermostatDay implements Runnable{
        @Override
        public void run() {
            System.out.println("Day");
            setThermostat("Day");
        }
    }

    class ThermostatNight implements Runnable{
        @Override
        public void run() {
            System.out.println("Night");
            setThermostat("Night");
        }
    }

    class Bell implements Runnable{
        @Override
        public void run() {
            System.out.println("Bing!");
        }
    }

    class Terminate implements Runnable{

        @Override
        public void run() {
            System.out.println("Terminating");
            scheduledThreadPoolExecutor.shutdownNow();
            new Thread(){
                @Override
                public void run() {
                    for (DataPoint dataPoint:data)
                        System.out.println(dataPoint);
                }
            }.start();
        }
    }

    static class DataPoint{
        final Calendar time;
        final float temperature;
        final float humidity;

        public DataPoint(Calendar time, float temperature,float humidity) {
            this.humidity = humidity;
            this.temperature = temperature;
            this.time = time;
        }

        @Override
        public String toString() {
            return time.getTime()+String.format(" temperature: %1$.1f humidity: %2$.2f",temperature,humidity);
        }
    }

    private Calendar lastTime=Calendar.getInstance();
    {
        lastTime.set(Calendar.MINUTE,30);
        lastTime.set(Calendar.SECOND,00);
    }
    private float lastTemp =65.0f;
    private int tempDirection=+1;
    private float lastHumidity=50.0f;
    private float humidityDirection=+1;
    private Random random=new Random(47);
    List<DataPoint> data= Collections.synchronizedList(new ArrayList<>());

    class CollectData implements Runnable{
        @Override
        public void run() {
            System.out.println("Collecting data");
            synchronized (E_GreenhouseScheduler.this){
                lastTime.set(Calendar.MINUTE,lastTime.get(Calendar.MINUTE)+30);
                if (random.nextInt(5)==4)
                    tempDirection=-tempDirection;
                lastTemp = lastTemp+tempDirection*(1.0f+random.nextFloat());
                if (random.nextInt(5)==4)
                    humidityDirection=-humidityDirection;
                lastHumidity=humidityDirection*random.nextFloat();
                data.add(new DataPoint((Calendar)lastTime.clone(),lastTemp,lastHumidity));
            }
        }
    }

    public static void main(String[] args) {
        E_GreenhouseScheduler EGreenhouseScheduler =new E_GreenhouseScheduler();
        EGreenhouseScheduler.schedule(EGreenhouseScheduler.new Terminate(),5000);
        EGreenhouseScheduler.repeat(EGreenhouseScheduler.new Bell(),0,1000);
        EGreenhouseScheduler.repeat(EGreenhouseScheduler.new ThermostatNight(),0,2000);
        EGreenhouseScheduler.repeat(EGreenhouseScheduler.new ThermostatDay(),0,1400);
        EGreenhouseScheduler.repeat(EGreenhouseScheduler.new LightOff(),0,400);
        EGreenhouseScheduler.repeat(EGreenhouseScheduler.new LightOn(),0,200);
        EGreenhouseScheduler.repeat(EGreenhouseScheduler.new WaterOff(),0,800);
        EGreenhouseScheduler.repeat(EGreenhouseScheduler.new WaterOn(),0,600);
        EGreenhouseScheduler.repeat(EGreenhouseScheduler.new CollectData(),500,500);
    }
}
