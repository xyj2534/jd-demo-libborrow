package edu.jd.xyt.base;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*") // /* 表示所有请求都会被本过滤器拦截
public class CrosFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        HttpServletResponse resp = (HttpServletResponse) response;

        String path = req.getServletPath();//获取请求路径

        System.out.println("path:"+path);

        //跨域设置
        resp.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        resp.setHeader("Access-Control-Max-Age", "3600"); //设置预检过期时间时间
        resp.setHeader("Access-Control-Allow-Headers","Origin,X-Requested-With,Content-Type, Accept, Token,Authorization");


        //允许客户端发送session追踪信息
        resp.setHeader("Access-Control-Allow-Origin", req.getHeader("Origin"));
        resp.setHeader("Access-Control-Allow-Credentials", "true");


        chain.doFilter(request, response);//通过放行
    }

    @Override
    public void destroy() {

    }
}
