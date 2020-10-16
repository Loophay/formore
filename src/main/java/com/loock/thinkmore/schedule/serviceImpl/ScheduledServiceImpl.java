package com.loock.thinkmore.schedule.serviceImpl;

import com.loock.thinkmore.schedule.service.ScheduledService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * 创建定时任务实现类
 * @author loock
 */
@Service
public class ScheduledServiceImpl implements ScheduledService {

    @Scheduled(cron = "0/2 * * * * *")
    @Override
    public void hello() {
        System.out.println("执行定时任务");
    }
}
