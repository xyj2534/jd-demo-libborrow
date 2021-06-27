package edu.jd.xyt.lib;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.jd.xyt.common.Utils;
import org.apache.ibatis.session.SqlSession;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibService {
    public Map<String,Object> getLibborrowList(QueryDto queryDto) {

        SqlSession sess = Utils.openSession();
        try{
            LibDao dao = sess.getMapper(LibDao.class);

            //执行映射器方法之前立即执行分页参数（页码和每页记录数）的设置
            PageHelper.startPage(queryDto);
            //queryDto extends paraParam属性 继承！！！
            List<Libborrow> libList = dao.findLibborrowList(queryDto);

            //执行映射器方法之后，立即执行PageInfo对象的创建
            PageInfo<Libborrow> pageInfo = new PageInfo<Libborrow>(libList);

            Map<String,Object> page = new HashMap<>();
            page.put("current", pageInfo.getPageNum());//当前页
            page.put("pageSize",pageInfo.getPageSize());//每页最大记录数
            page.put("total",pageInfo.getTotal());//总记录数
            page.put("pages",pageInfo.getPages());//总页数
            page.put("size",pageInfo.getSize());//当前页实际记录数
            page.put("list",pageInfo.getList());//当前页的数据记录
            page.put("first",1);
            page.put("pre",pageInfo.getPrePage());
            page.put("next",pageInfo.getNextPage());
            page.put("last",pageInfo.getPages());

            sess.commit();
            return page;

        }catch(Exception e){
            sess.rollback();
            throw new RuntimeException("查询借阅信息失败！",e);
        }finally {
            sess.close();
        }
    }
    public void addLibborrow(LibborrowDto dto) {

        SqlSession sess = Utils.openSession();
        try{
            LibDao dao = sess.getMapper(LibDao.class);

            //MM00n  自动构造ID
            Calendar cal = Calendar.getInstance();//获得当前日期
            int month = cal.get(Calendar.MONTH)+1;//cal.get(Calendar.MONTH) 获取的月份从0开始
            String mon = month<10?("0"+month):(""+month);
            String newNum = dao.findLibborrowNewNum(mon);
            dto.setL_id(mon+newNum);
            dao.insertLibborrow(dto);
            sess.commit();
        }catch(Exception e){
            sess.rollback();
            throw new RuntimeException("新增教师信息失败！",e);
        }finally {
            sess.close();
        }
    }

    public void modifyLibborrow(LibborrowDto dto) {
        SqlSession sess = Utils.openSession();
        try{
            LibDao dao = sess.getMapper(LibDao.class);
            dao.updateLibborrow(dto);
            sess.commit();

        }catch(Exception e){
            sess.rollback();
            throw new RuntimeException("修改借阅信息失败！",e);
        }finally {
            sess.close();
        }
    }

    public void removeLibborrow(LibborrowDto dto) {
        SqlSession sess = Utils.openSession();
        try{
            LibDao dao = sess.getMapper(LibDao.class);
            dao.deleteLibborrow(dto.getL_id());
            sess.commit();

        }catch(Exception e){
            sess.rollback();
            if(e instanceof  RuntimeException){
                throw e;
            }
            throw new RuntimeException("删除借阅信息失败！",e);
        }finally {
            sess.close();
        }
    }
}
