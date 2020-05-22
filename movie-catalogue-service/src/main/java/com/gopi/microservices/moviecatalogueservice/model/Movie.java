/**
 * Created by gopinath_mb on 21-May-2020
 */
package com.gopi.microservices.moviecatalogueservice.model;

/**
 * @author gopinath_mb
 */
public class Movie
{
  private String movieId;

  private String name;

  public Movie()
  {

  }

  public Movie(String movieId, String name)
  {
    super();
    this.movieId = movieId;
    this.name = name;
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

}
