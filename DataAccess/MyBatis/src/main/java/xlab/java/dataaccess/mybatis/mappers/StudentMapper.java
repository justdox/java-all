package xlab.java.dataaccess.mybatis.mappers;

import org.apache.ibatis.annotations.Param;
import xlab.java.dataaccess.pojo.Student;
import xlab.java.dataaccess.pojo.StudentExample;

import java.util.List;

public interface StudentMapper {
    long countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);
}
