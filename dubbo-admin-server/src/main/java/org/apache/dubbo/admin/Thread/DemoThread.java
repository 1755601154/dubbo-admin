package org.apache.dubbo.admin.Thread;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

/**
 * @author yuanlei
 * @date 2020-10-31
 */
@Component
@Slf4j
public class DemoThread implements DisposableBean,Runnable {

    private Thread thread;
    private volatile boolean someCondition = true;
    private int count = 1;

    public DemoThread() {
        this.thread = new Thread(this);
        this.thread.start();
        log.error("线程启动");
    }

    @SneakyThrows
    @Override
    public void run() {
        while (someCondition) {
            //执行任务
            log.info("任务第"+count+"次执行");
            Thread.sleep(2*1000L);
            count++;
            if(count>5){
                someCondition=false;
            }
        }

    }

    @Override
    public void destroy() throws Exception {
        someCondition = false;
    }
}
