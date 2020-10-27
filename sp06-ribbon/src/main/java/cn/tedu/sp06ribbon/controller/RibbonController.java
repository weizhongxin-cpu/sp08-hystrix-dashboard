package cn.tedu.sp06ribbon.controller;

import cn.tedu.sp01.pojo.Item;
import cn.tedu.web.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Administrator
 * 2020/10/27 - 16:56
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
        return restTemplate.getForObject("http://localhost:8001/{1}", JsonResult.class);
    }
}
