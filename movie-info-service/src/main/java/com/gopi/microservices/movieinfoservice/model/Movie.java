/**
 * Created by gopinath_mb on 21-May-2020
 */
package com.gopi.microservices.movieinfoservice.model;

/**
 * @author gopinath_mb
 */
public class Movie
{
  private String movieId;

  private String name;

  private String desc;

  public Movie(String movieId, String name, String desc)
  {
    super();
    this.movieId = movieId;
    this.name = name;
    this.desc = desc;
  }

  public String getMovieId()
  {
    return movieId;
  }

  public void setMovieId(String movieId)
  {
    this.movieId = movieId;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getDesc()
  {
    return desc;
  }

  public void setDesc(String desc)
  {
    this.desc = desc;
  }

}
