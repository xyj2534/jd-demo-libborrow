package edu.jd.xyt.common;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class Utils {

    //工具类方法一般为静态的

    private static final String MYBATIS_CONFIG = "/mybatis.xml";
    private static final SqlSessionFactory FACTORY = buildFactory();

    private static SqlSessionFactory buildFactory()  {
        try {
            InputStream in = Resources.getResourceAsStream(MYBATIS_CONFIG);

            //会话工厂
            return new SqlSessionFactoryBuilder().build(in);
        }catch (Exception e){
            //RuntimeException是非受查异常
            throw new RuntimeException("创建SqlSessionFactory失败！",e);
        }
    }

    public static SqlSessionFactory getFactory(){
        return FACTORY;
    }

    public static SqlSession openSession(){
        return FACTORY.openSession();
    }


    /**
     * 将一个Java对象转换为json串，并向浏览器（客户端）输出
     * @param resp 响应对象
     * @param obj 需要转化为json串的java对象
     * @throws IOException
     */
    public static void outJson(HttpServletResponse resp,Object obj) throws IOException {
        //json格式的媒体标准：application/json
        resp.setContentType("application/json;charset=UTF-8");//设置字符编码
        PrintWriter out = resp.getWriter();//获取向客户端发送字符信息流对象
        // 将list集合对象转化为json格式字符串
        String jsonString = JSON.toJSONString(obj);
        out.print(jsonString);

        out.flush();
        out.close();
    }

    public static void outResult(HttpServletResponse resp,Result result) throws IOException {
        outJson(resp, result);
    }

    //泛型：类型的变量
    public static <T> T getBeanFromRequest(Class<T> beanClass , HttpServletRequest request) throws IOException {
        Reader in = request.getReader();
        CharArrayWriter out = new CharArrayWriter();
        char[] cbuf = new char[1024];
        int len = -1;
        while((len = in.read(cbuf))!=-1){
            out.write(cbuf, 0, len);
        }
        out.flush();
        out.close();
        in.close();

        String json = out.toString();

        return JSON.parseObject(json, beanClass);
    }
}
