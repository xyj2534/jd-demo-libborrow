package edu.jd.xyt.lib;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper //本注解明确说明本接口是mybatis的映射器
public interface LibDao {
    //@Select("select * from 借阅") 移至LibDao.xml

    List<Libborrow> findLibborrowList(QueryDto queryDto);

    @Update("update 借阅 set l_id = #{l_id},r_id = #{r_id},r_name = #{r_name},b_id = #{b_id},b_name = #{b_name},borrowDate = #{borrowDate},deadline = #{deadline},state = #{state} where L_id=#{l_id}")
    void updateLibborrow(LibborrowDto dto);

    @Delete("delete from 借阅 where L_id = #{l_id}")
    void deleteLibborrow(String L_id);


}
