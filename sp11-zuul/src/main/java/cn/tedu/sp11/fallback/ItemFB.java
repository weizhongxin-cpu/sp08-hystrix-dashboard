package cn.tedu.sp11.fallback;

import cn.tedu.web.util.JsonResult;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Administrator
 * 2021/1/14 - 20:37
 */
@Component
public class ItemFB implements FallbackProvider {
    /*
    要返回service-id
    表示这个降级类，是针对哪个服务进行降级
    如以下，是针对item-service
    如果return "*"，或者return null,则针对所有服务
     */
    @Override
    public String getRoute() {
        return "item-service";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        /*
        返回降级响应
        在response对象中，要设置http协议的状态码，协议头，协议体
         */
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.OK.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.OK.getReasonPhrase();
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                /*
                JsonResult {code:400,msg:"调用商品服务失败!",data:null}
                 */
                String json = JsonResult.err().msg("调用商品服务失败!来自Zuul-ItemFB").toString();
                return new ByteArrayInputStream(json.getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                /*
                Context-Type:application/json;charset=UTF-8
                 */
                HttpHeaders h = new HttpHeaders();
                h.setContentType(MediaType.APPLICATION_JSON);
                return h;
            }
        };
    }
}
