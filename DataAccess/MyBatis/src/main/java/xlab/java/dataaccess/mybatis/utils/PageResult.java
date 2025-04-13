package xlab.java.dataaccess.mybatis.utils;

import java.util.List;

/**
 * @author CodeKing
 */
public class PageResult<T> {

  private int total;

  private List<T> items;

  public int getTotal() {
    return total;
  }

  public void setTotal(final int total) {
    this.total = total;
  }

  public List<T> getItems() {
    return items;
  }

  public void setItems(final List<T> items) {
    this.items = items;
  }
}
