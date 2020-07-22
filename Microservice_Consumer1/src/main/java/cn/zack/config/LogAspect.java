package cn.zack.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class LogAspect {

    /**
     * 切入点: 所有带有@LogAnnotation注解的方法
     */
    @Pointcut("@annotation(cn.zack.config.LogAnnotation)")
    public void logPointCut() {
    }

    /**
     * 环绕通知
     */
    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        // 记录方法耗时
        long start = System.currentTimeMillis();

        System.out.println("前置增强开始========");
        // 获取执行当前方法的上下文request
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        // 从上下文中获取入参
        Map<String, Object> requestParameters = getRequestParameters(request);
        System.out.println("入参日志:");
        System.out.println(requestParameters);
        // 获取被增强的方法相关信息
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method pointMethod = signature.getMethod();
        // 取出注解上的值
        String logType = pointMethod.getAnnotation(LogAnnotation.class).logType();
        System.out.println("日志类型: " + logType);

        System.out.println("前置通知结束========");
        // 让目标方法执行, 并获取执行结果
        Object proceed = point.proceed();
        System.out.println("后置通知开始========");

        System.out.println(proceed);
        System.out.println("后置通知结束========");

        long end = System.currentTimeMillis();
        System.out.println("耗时:" + (end - start) + "ms");
        return proceed;
    }

    /**
     * 获取所有的请求参数
     *
     * @return
     */
    private Map<String, Object> getRequestParameters(HttpServletRequest request) {
        Enumeration<String> parameterNames = request.getParameterNames();
        HashMap<String, Object> parametersMap = new HashMap<>();

        String name;
        String value;
        while (parameterNames.hasMoreElements()) {
            name = String.valueOf(parameterNames.nextElement());
            value = request.getParameter(name);
            parametersMap.put(name, value);
        }
        return parametersMap;
    }
}