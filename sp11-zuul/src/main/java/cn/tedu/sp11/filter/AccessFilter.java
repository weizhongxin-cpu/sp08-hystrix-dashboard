package cn.tedu.sp11.filter;

import cn.tedu.web.util.JsonResult;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Administrator
 * 2021/1/13 - 21:34
 * <p>
 * 自定义zuul过滤器，只需要添加component注解
 * zuul会自动配置这个过滤器
 */
@Component
public class AccessFilter extends ZuulFilter {
    // 前置、后置、路由、错误处理
    @Override
    public String filterType() {
        // return "pre";
        return FilterConstants.PRE_TYPE;
    }

    // 顺序号
    @Override
    public int filterOrder() {
        /*
        在zuul默认过滤器的第5个过滤器中，
        向context对象添加了service id
        在后面过滤器中才能访问service id
         */
        return 6;
    }

    // 针对当前这次请求，是否要执行过滤代码
    @Override
    public boolean shouldFilter() {
        /*
          如果请求商品，执行过滤
          如果请求用户或订单，跳过过滤
         */
        // 获取请求上下文对象
        RequestContext context = RequestContext.getCurrentContext();
        String serviceId = (String) context.get(FilterConstants.SERVICE_ID_KEY);
        return "item-service".equalsIgnoreCase(serviceId);
    }

    @Override
    public Object run() throws ZuulException {
        // 获取request对象
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();

        // 接收token参数
        String token = request.getParameter("token");

        // 如果没有token
        if (StringUtils.isBlank(token)){
            // 阻止继续访问
            context.setSendZuulResponse(false);
            // 直接返回响应
            context.addZuulResponseHeader("Content-Type", "application/json;charset=utf-8");
            context.setResponseStatusCode(JsonResult.NOT_LOGIN);
            context.setResponseBody(JsonResult.err().code(JsonResult.NOT_LOGIN).msg("未登录!").toString());
        }

        return null;// 该返回值无效，所以返回任何都可以
    }
}
