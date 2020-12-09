package com.atguigu.springcloud.serviceImp;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PaymentServiceImp implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;
    public int create(Payment payment){
        return paymentDao.create(payment);

    }

    public Payment getPaymentById(@Param("id") long id){
        return paymentDao.getPaymentById(id);
    }


}
