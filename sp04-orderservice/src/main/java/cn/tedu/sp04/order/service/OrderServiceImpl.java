package cn.tedu.sp04.order.service;

import cn.tedu.sp01.pojo.Item;
import cn.tedu.sp01.pojo.Order;
import cn.tedu.sp01.pojo.User;
import cn.tedu.sp01.service.OrderService;
import cn.tedu.sp04.order.feign.ItemClient;
import cn.tedu.sp04.order.feign.UserClient;
import cn.tedu.web.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    private ItemClient itemClient;
    private UserClient userClient;

    @Autowired
    public OrderServiceImpl(ItemClient itemClient, UserClient userClient) {
        this.itemClient = itemClient;
        this.userClient = userClient;
    }

    @Override
    public Order getOrder(String orderId) {
        //调用user-service获取用户信息
        JsonResult<User> user = userClient.getUser(7);

        //调用item-service获取商品信息
        JsonResult<List<Item>> items = itemClient.getItems(orderId);

        Order order = new Order();
        order.setId(orderId);
        order.setUser(user.getData());
        order.setItems(items.getData());
        return order;
    }

    @Override
    public void addOrder(Order order) {
        // 调用item-service减少商品库存
        itemClient.decreaseNumber(order.getItems());

        // 调用user-service增加用户积分
        userClient.addScore(order.getUser().getId(), 100);
        log.info("保存订单：" + order);
    }

}
