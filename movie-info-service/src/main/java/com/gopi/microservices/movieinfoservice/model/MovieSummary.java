/**
 * Created by gopinath_mb on 23-May-2020
 */
package com.gopi.microservices.movieinfoservice.model;

/**
 * @author gopinath_mb
 */
public class MovieSummary
{
  private Integer id;

  private String title;
  
  private String overview;

  public MovieSummary()
  {
  }

  public MovieSummary(int id, String title,String overview)
  {
    super();
    this.id = id;
    this.title = title;
    this.overview=overview;
  }

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public String getTitle()
  {
    return title;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  /**
   * @return the overview
   */
  public String getOverview()
  {
    return overview;
  }

  /**
   * @param overview the overview to set
   */
  public void setOverview(String overview)
  {
    this.overview = overview;
  }

}
