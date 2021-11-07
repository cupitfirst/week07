package com.bh1ofp.week07.service;

import com.bh1ofp.week07.common.SnowflakeIdWorker;
import com.bh1ofp.week07.dao.OrderRepository;
import com.bh1ofp.week07.entity.Order;
import com.bh1ofp.week07.entity.OrderDetail;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Resource
    private OrderRepository orderRepository;

    @Resource
    private SnowflakeIdWorker sfw;

    public int saveOrders(List<Order> orderList){

        return  orderRepository.saveAll(orderList).size();

    }

    public int saveOrder(Order order){
        return orderRepository.save(order).getId();
    }

    public Order makeOrder() throws Exception {
        Order order;
        OrderDetail orderDetail;
        List orderDetails = new ArrayList();;
        order = new Order();
        orderDetail = new OrderDetail();
        order.setOrderNo(String.valueOf(getOrderNo()));
        order.setUserId(1);
        order.setCreateDate(LocalDateTime.now());
//        System.out.println(LocalTime.now());
        orderDetail.setCommodityId(1);
        orderDetail.setCount(2);
        orderDetails.add(orderDetail);
        order.setOrderDetails(orderDetails);
        return order;
    }

    public void makeBatchOrders(){
        Order order;
        OrderDetail orderDetail;
        List orderDetails;
        List orders = new ArrayList();
        for(int i=0 ;i<1000000;i++){
            order = new Order();
            orderDetail = new OrderDetail();
            orderDetails = new ArrayList();
            order.setOrderNo(String.valueOf(i));
            order.setUserId(1);

            orderDetail.setCommodityId(1);
            orderDetail.setCount(2);
            orderDetails.add(orderDetail);
            order.setOrderDetails(orderDetails);
            orders.add(order);
        }
        this.saveOrders(orders);
    }

    public void insertOrders() throws Exception {
        for(int i =0  ; i<1000000 ; i++){
            orderRepository.save(this.makeOrder());
        }
    }

    public String getOrderNo() throws Exception {
//        SnowflakeIdWorker sfw =new SnowflakeIdWorker();
        return String.valueOf(sfw.nextId());
    }

}
