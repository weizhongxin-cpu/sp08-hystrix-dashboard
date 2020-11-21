package cn.tedu.sp09.controller;

import cn.tedu.sp01.pojo.Item;
import cn.tedu.sp01.pojo.Order;
import cn.tedu.sp01.pojo.User;
import cn.tedu.sp09.feign.ItemClient;
import cn.tedu.sp09.feign.OrderClient;
import cn.tedu.sp09.feign.UserClient;
import cn.tedu.web.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Administrator
 * 2020/11/21 - 19:20
 */
@Slf4j
@RestController
public class FeignController {
    private ItemClient itemClient;
    private UserClient userClient;
    private OrderClient orderClient;

    @Autowired
    public void setItemClient(ItemClient itemClient) {
        this.itemClient = itemClient;
    }

    public void setUserClient(UserClient userClient) {
        this.userClient = userClient;
    }

    public void setOrderClient(OrderClient orderClient) {
        this.orderClient = orderClient;
    }
    @GetMapping("/item-service/{orderId}")
    public JsonResult<List<Item>> getItems(@PathVariable String orderId){
        return itemClient.getItems(orderId);
    }
    @GetMapping("/item-service/decreaseNumber")
    public JsonResult<List<Item>> decreaseNumber(@PathVariable List<Item> items){
        return itemClient.decreaseNumber(items);
    }
    @GetMapping("/user-service/{userId}")
    public JsonResult<User> getUser(@PathVariable Integer userId){
        return userClient.getUser(userId);
    }
    @GetMapping("/user-service/{userId}/score")
    public JsonResult<User> addScore(@PathVariable Integer userId,Integer score){
        return userClient.addScore(userId, score);
    }
    @GetMapping("/order-service/{orderId}")
    public JsonResult<Order> getOrder(@PathVariable String orderId){
        return orderClient.getOrder(orderId);
    }
    @GetMapping("/order-service/")
    public JsonResult<?> addOrder(){
        return orderClient.addOrder();
    }
}
