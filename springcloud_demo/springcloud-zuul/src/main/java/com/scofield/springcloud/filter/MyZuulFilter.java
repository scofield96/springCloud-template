package com.scofield.springcloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Scofield
 * @date 2020/3/28 11:05
 * @description
 */
public class MyZuulFilter extends ZuulFilter {



    @Override
    public boolean shouldFilter() {
        // 1.获取当前RequestContext 对象
        RequestContext context = RequestContext.getCurrentContext(); //threadLocal.get() 线程本地化
        // 2.获取当前请求对象
        HttpServletRequest request = context.getRequest();
        // 3.获取当前请求要访问的目标地址
        String parameter = request.getParameter("signal");

        //相等执行run()方法
        return "hello".equals(parameter);

    }

    @Override
    public Object run() throws ZuulException {
        // 执行具体过滤逻辑
        System.err.println("run()方法执行了 ...");
        //忽略此方法的返回值，所以返回null，不做特殊处理
        return null;
    }

    @Override
    public String filterType() {
        // 返回当前过滤器类型
        // 可选类型包括：pre、route、post、static
        // 如果需要在目标微服务前面执行过滤操作，选用pre 类型

        return "pre";
    }


    @Override
    public int filterOrder() {
        // 过滤器执行顺序
        return 0;
    }


}
