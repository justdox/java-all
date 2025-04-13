package xlab.java.dataaccess.mybatis;

import org.apache.ibatis.session.SqlSession;
import xlab.java.dataaccess.mybatis.mappers.CityMapper;
import xlab.java.dataaccess.mybatis.mappers.StudentMapper;
import xlab.java.dataaccess.mybatis.utils.MyBatisUtils;
import xlab.java.dataaccess.mybatis.utils.PageResult;
import xlab.java.dataaccess.pojo.City;
import xlab.java.dataaccess.pojo.Student;
import xlab.java.dataaccess.pojo.StudentExample;

import java.util.List;

import static xlab.java.dataaccess.pojo.StudentExample.Criteria;

/**
 * @author CodeKing
 */
public class MyBatisApp {
  public static void main(String[] args) {
    System.out.println("Hello world!");

    try (final SqlSession sqlSession = MyBatisUtils.createSqlSession()) {
      final CityMapper cityMapper = sqlSession.getMapper(CityMapper.class);
      final List<List<?>> results = cityMapper.getCitiesByPage(10, 1);
      final PageResult<City> pageResult = MyBatisUtils.toPageResult(results);

      System.out.println(pageResult.getTotal());

      for (final City city : pageResult.getItems()) {
        System.out.println(city);
      }

      StudentExample example = new StudentExample();
      Criteria criteria = example.createCriteria();
      criteria.andAgeGreaterThan(10);
      example.setOrderByClause("age asc, name desc");

      StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
      List<Student> students = studentMapper.selectByExample(example);

      for (final Student student : students) {
        System.out.println(student);
      }
    }
  }
}
