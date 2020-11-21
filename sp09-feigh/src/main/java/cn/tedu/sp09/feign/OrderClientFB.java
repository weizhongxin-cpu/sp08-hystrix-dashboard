package cn.tedu.sp09.feign;

import cn.tedu.sp01.pojo.Order;
import cn.tedu.web.util.JsonResult;
import org.springframework.stereotype.Component;

/**
 * Administrator
 * 2020/11/21 - 21:20
 */
@Component
public class OrderClientFB implements OrderClient {
    @Override
    public JsonResult<Order> getOrder(String orderId) {
        return JsonResult.err().msg("获取订单失败！");
    }

    @Override
    public JsonResult addOrder() {
        return JsonResult.err().msg("添加订单失败！");
    }
}
