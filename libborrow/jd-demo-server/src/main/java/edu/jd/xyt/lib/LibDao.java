package edu.jd.xyt.lib;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper //本注解明确说明本接口是mybatis的映射器
public interface LibDao {
    //@Select("select * from 借阅") 移至LibDao.xml

    List<Libborrow> findLibborrowList(QueryDto queryDto);

    @Update("update 借阅 set borrowDate = #{borrowDate},deadline = #{deadline},state = #{state} where L_id=#{l_id}")
    void updateLibborrow(LibborrowDto dto);

    @Delete("delete from 借阅 where L_id = #{l_id}")
    void deleteLibborrow(String L_id);

    @Insert("insert into 借阅(l_id,r_id,r_name,b_id,b_name,borrowDate,deadline,state) values(#{l_id},#{r_id},#{b_id},#{b_name},now(),date_add(now(), interval 1 week),0)")
    void insertLibborrow(LibborrowDto dto);

    @Select("select lpad(ifnull(max(convert(substring(l_id,3,3),signed)),0)+1,3,'0')  from 借阅 where l_id like concat(#{prefix},'%')")
    String findLibborrowNewNum(String prefix);
}
