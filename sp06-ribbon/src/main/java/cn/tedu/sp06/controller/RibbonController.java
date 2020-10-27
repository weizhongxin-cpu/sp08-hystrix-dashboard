package cn.tedu.sp06.controller;

import cn.tedu.sp01.pojo.Item;
import cn.tedu.sp01.pojo.User;
import cn.tedu.web.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Administrator
 * 2020/10/27 - 17:14
 */
@RestController
@RequestMapping("/")
public class RibbonController {
    private RestTemplate restTemplate;
    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @GetMapping("item-service/{orderId}")
    public JsonResult<List<Item>> getItems(@PathVariable String orderId){
        // 向指定微服务地址发送 get请求，并获得该服务的返回结果
        // {1} 占位符，用 orderId填充
        // 使用restTemplate工具，调用远程商品服务
        return restTemplate.getForObject(
                "http://localhost:8001/{1}",
                JsonResult.class,
                orderId);
    }

    @PostMapping("item-service/decreaseNumber")
    public JsonResult<?> decreaseNumber(@RequestBody List<Item> items){
        // 用restTemplate调用远程服务，发送post请求
        // 商品数据放在协议体，向远程服务提交
        return restTemplate.postForObject(
                "http://localhost:8001/decreaseNumber",
                items,
                JsonResult.class
        );
    }

    @GetMapping("user-service/{userId}")
    public JsonResult<User> getUser(@PathVariable Integer userId){
        return restTemplate.getForObject(
                "http://localhost:8001/{1}",
                JsonResult.class,
                userId
        );
    }
}
