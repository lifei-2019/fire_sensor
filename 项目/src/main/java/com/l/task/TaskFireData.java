package com.l.task;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Order(1)
public class TaskFireData implements ApplicationRunner {

    @Resource(name = "continueread")
    private Continueread continueread;

    @Override
    public void run(ApplicationArguments applicationArguments) {
        int i = continueread.startComPort();
        if (i == 1) {
            // 启动线程来处理收到的数据
            continueread.start();
        } else {
            return;
        }
    }
}
