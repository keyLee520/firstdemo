package com.pipi.firstdemo.likou;

import java.util.concurrent.atomic.LongAdder;

/**
 * 哲学家进餐问题
 */
class DiningPhilosophers {

    public DiningPhilosophers() {

    }

  volatile LongAdder currnum = new LongAdder();

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        if(currnum.intValue()==philosopher){
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            putRightFork.run();
            currnum.increment();
        }


    }
}