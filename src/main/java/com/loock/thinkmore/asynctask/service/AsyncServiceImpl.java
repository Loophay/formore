package com.loock.thinkmore.asynctask.service;

import com.loock.thinkmore.asynctask.serviceinterface.AsyncService;
import org.springframework.stereotype.Service;

/**
 * 创建异步任务实现
 * @author loock
 */
@Service
public class AsyncServiceImpl implements AsyncService {

    @Override
    public void hello() {
        try{
            System.out.println("数据处理中");
            Thread.sleep(4000);
            System.out.println("数据处理完毕");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
