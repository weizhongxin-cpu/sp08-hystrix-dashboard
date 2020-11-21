package cn.tedu.sp09.feign;

import cn.tedu.sp01.pojo.Item;
import cn.tedu.web.util.JsonResult;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 降级类
 * Administrator
 * 2020/11/21 - 21:18
 */
@Component
public class ItemClientFB  implements ItemClient{
    @Override
    public JsonResult<List<Item>> getItems(String orderId) {
        return JsonResult.err().msg("获取订单商品列表失败！");
    }

    @Override
    public JsonResult decreaseNumber(List<Item> items) {
        return JsonResult.err().msg("减少库存失败！");
    }
}
