package cn.tedu.sp09.feign;

import cn.tedu.sp01.pojo.User;
import cn.tedu.web.util.JsonResult;
import org.springframework.stereotype.Component;

/**
 * Administrator
 * 2020/11/21 - 21:21
 */
@Component
public class UserClientFB implements UserClient {
    @Override
    public JsonResult<User> getUser(Integer userId) {
        return JsonResult.err().msg("获取用户信息失败！");
    }

    @Override
    public JsonResult addScore(Integer userId, Integer score) {
        return JsonResult.err().msg("添加用户积分失败！");
    }
}
