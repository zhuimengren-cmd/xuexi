package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLB implements LoadBalancer{


    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final  int getAndIncrement() {
        int curret;
        int next;
        do {
            curret = this.atomicInteger.get();
            next = curret >= 2147483647 ? 0 : curret + 1;

        } while (this.atomicInteger.compareAndSet(curret,next));
        System.out.println("*********第几次访问next:" + next);
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {

        int index = getAndIncrement() % serviceInstances.size();

        return serviceInstances.get(index);
    }
}
