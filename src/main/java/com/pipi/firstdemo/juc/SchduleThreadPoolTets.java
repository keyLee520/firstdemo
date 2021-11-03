package com.pipi.firstdemo.juc;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class SchduleThreadPoolTets {

    public static void main(String[] args) {
//        Log log = LogFactory.getLog("SchduleThreadPoolTets");
        // timertest();
        Runnable runnable = ()->{
            System.out.println(1);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable runnable1 = ()->{
            System.out.println(2);
        };
//        ExecutorService executorService = Executors.newFixedThreadPool(1);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);



    }




    private static void timertest() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println(111);
            }
        };
        timer.purge();
        timer.scheduleAtFixedRate(task,new Date(),1000);
    }
}
