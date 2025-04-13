package xlab.java.dataaccess.pojo;

import java.io.Serializable;

/**
 * @author CodeKing
 */
public class City implements Serializable {
  private int id;
  private String name;
  private String countryCode;
  private String district;
  private int population;

  public int getId() {
    return id;
  }

  public void setId(final int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(final String countryCode) {
    this.countryCode = countryCode;
  }

  public String getDistrict() {
    return district;
  }

  public void setDistrict(final String district) {
    this.district = district;
  }

  public int getPopulation() {
    return population;
  }

  public void setPopulation(final int population) {
    this.population = population;
  }

  @Override
  public String toString() {
    return "City{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", countryCode='" + countryCode + '\'' +
      ", district='" + district + '\'' +
      ", population=" + population +
      '}';
  }
}
