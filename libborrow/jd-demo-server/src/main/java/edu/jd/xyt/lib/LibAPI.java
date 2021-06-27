package edu.jd.xyt.lib;

import edu.jd.xyt.common.Result;
import edu.jd.xyt.common.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet({
        "/lib/libList",
        "/lib/libDoUpd",
        "/lib/libDoDel",
        "/lib/libDoAdd"
})
public class LibAPI extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LibService libService = new LibService();
        request.setCharacterEncoding("UTF-8");
        String path = request.getServletPath();

        if("/lib/libDoAdd".equals(path)){

            LibborrowDto dto = Utils.getBeanFromRequest(LibborrowDto.class,request);
            //System.out.println("dto:"+dto);
            libService.addLibborrow(dto);

            Utils.outJson(response, Result.success());

        }

        if("/lib/libDoUpd".equals(path)){

            try {
                LibborrowDto dto = Utils.getBeanFromRequest(LibborrowDto.class,request);
                //System.out.println("dto:"+dto);
                libService.modifyLibborrow(dto);

                Utils.outJson(response, Result.success());
            } catch (IOException e) {
                e.printStackTrace();
                throw e;
            }

        }

        else if("/lib/libDoDel".equals(path)){

            try {
                LibborrowDto dto = Utils.getBeanFromRequest(LibborrowDto.class,request);
                //System.out.println("dto:"+dto);
                libService.removeLibborrow(dto);

                Utils.outJson(response, Result.success());
            } catch (Exception e) {
                e.printStackTrace();
                Utils.outJson(response, Result.fail(Result.ERR_CODE_BUSINESS, e.getMessage()));
            }

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //接收客户端（浏览器）传来的参数,并将参数封装为Java对象
        request.setCharacterEncoding("UTF-8");
        QueryDto queryDto = new QueryDto();

        try {
            queryDto.setPageNum(Integer.parseInt(request.getParameter("pageNum")));
        } catch (Exception e) {}

        try {
            queryDto.setPageSize(Integer.parseInt(request.getParameter("pageSize")));
        } catch (Exception e) {}

        queryDto.setL_id(request.getParameter("l_id"));
        queryDto.setR_id(request.getParameter("r_id"));
        queryDto.setR_name(request.getParameter("r_name"));
        queryDto.setB_id(request.getParameter("b_id"));
        queryDto.setB_name(request.getParameter("b_name"));
        queryDto.setStart_borrowDate(request.getParameter("start_borrowDate"));
        queryDto.setEnd_borrowDate(request.getParameter("end_borrowDate"));



        //创建业务模型对象（服务对象/Service对象），通过业务对象执行业务方法
        LibService libService = new LibService();
        Map<String,Object> page =  libService.getLibborrowList(queryDto);

        //通过视图生成json
        //Utils.outJson(response, libList);
        Utils.outResult(response, Result.success(page));

    }
}
