package cn.zack.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zack
 * 自定义zuul过滤器
 */
public class ZuulFilterTest extends ZuulFilter {
    private static final Logger logger = LoggerFactory.getLogger(ZuulFilterTest.class);

    /**
     * 过滤器的类型
     * @return
     */
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 过滤器的执行顺序
     * @return
     */
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1;
    }

    /**
     * 过滤器是否执行
     * @return
     */
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑
     * @return
     * @throws ZuulException
     */
    public Object run() throws ZuulException {
        // 取当前requestcontext域
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        logger.info("===============");
        logger.info(String.format("send %s request to %s",request.getMethod(),request.getRequestURL().toString()));
        logger.info("===============");
        return null;
    }
}
