package com.loock.thinkmore.asynctask.serviceinterface;

import org.springframework.scheduling.annotation.Async;

/**
 * 创建一个异步任务的接口
 */
public interface AsyncService {

    @Async
    void hello();
}
