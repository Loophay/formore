package com.loock.thinkmore.asynctask.service;

import com.loock.thinkmore.asynctask.serviceinterface.AsyncService;
import org.springframework.stereotype.Service;

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
