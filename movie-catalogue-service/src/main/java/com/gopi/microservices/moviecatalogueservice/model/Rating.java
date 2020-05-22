/**
 * Created by gopinath_mb on 21-May-2020
 */
package com.gopi.microservices.moviecatalogueservice.model;

/**
 * @author gopinath_mb
 */
public class Rating
{

  private String movieId;

  private int rating;

  public Rating(String movieId, int rating)
  {
    super();
    this.movieId = movieId;
    this.rating = rating;
  }

  public String getMovieId()
  {
    return movieId;
  }

  public void setMovieId(String movieId)
  {
    this.movieId = movieId;
  }

  public int getRating()
  {
    return rating;
  }

  public void setRating(int rating)
  {
    this.rating = rating;
  }

}
