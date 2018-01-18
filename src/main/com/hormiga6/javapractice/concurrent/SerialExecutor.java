package com.hormiga6.javapractice.concurrent;

import java.util.ArrayDeque;
import java.util.concurrent.*;

public class SerialExecutor implements Executor {
    private final ArrayDeque<Runnable> mTasks = new ArrayDeque<>();
    private Runnable mActive;
    private static final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4,4,2, TimeUnit.SECONDS,  new LinkedBlockingQueue<Runnable>(128));

    @Override
    public synchronized void execute(Runnable r) {
        mTasks.offer(new Runnable() {
            @Override
            public void run() {
                try{
                    r.run();
                }finally {
                    scheduleNext();
                }
            }
        });
        if(mActive == null){
            scheduleNext();
        }
    }

    private synchronized void scheduleNext(){
        if((mActive = mTasks.poll()) != null){
            threadPoolExecutor.execute(mActive);
        }
    }
}
