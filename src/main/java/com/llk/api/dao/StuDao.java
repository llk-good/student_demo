package com.llk.api.dao;

import com.llk.api.model.po.Student;
import com.llk.api.model.vo.StudentParams;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StuDao {
    @Insert("insert into t_stu (name,age,sex,birthday) value(#{name},#{age},#{sex},#{birthday})")
    void addStudent(Student stu);

    @Select(("<script> select count(*) from t_stu where 1=1 " +
            "<if test ='name != null and name != &quot;&quot;'> and name = #{name}</if>" +
            "<if test='birthdaymin != null'>  and birthday >= #{birthdaymin} </if>" +
            "<if test='birthdaymax != null'>  and birthday &lt;= #{birthdaymax} </if> " +
            "</script>"))
    Integer queryDataCount(StudentParams params);

    @Select(("<script> select * from t_stu where 1=1 " +
            "<if test ='name != null and name != &quot;&quot;'> and name = #{name}</if>" +
            "<if test='birthdaymin != null'>  and birthday >= #{birthdaymin} </if>" +
            "<if test='birthdaymax != null'>  and birthday &lt;= #{birthdaymax} </if> " +
            "limit #{start},#{size} </script>"))
    List<Student> queryListDataByParams(StudentParams params);

    @Delete("delete from t_stu where id = #{id}")
    void delStu(Integer id);

    @Select("select * from t_stu where id = #{id}")
    Student queryDataById(Integer id);

    @Update("update t_stu set name=#{name},sex=#{sex},birthday=#{birthday},age=#{age} where id=#{id}")
    void updateStu(Student stu);
}
