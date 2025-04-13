package xlab.java.dataaccess.mybatis.mappers;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author CodeKing
 */
public interface CityMapper {

  /**
   * 分页查询。
   * @param pageSize 每页数据条数
   * @param pageIndex 页码
   * @return
   */
  public List<List<?>> getCitiesByPage(@Param("pageSize") final int pageSize,
                                       @Param("pageIndex") final int pageIndex);
}
