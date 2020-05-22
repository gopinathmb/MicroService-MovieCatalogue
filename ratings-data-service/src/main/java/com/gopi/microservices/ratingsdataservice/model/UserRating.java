/**
 * Created by gopinath_mb on 22-May-2020
 */
package com.gopi.microservices.ratingsdataservice.model;

import java.util.List;

/**
 * @author gopinath_mb
 */
public class UserRating
{
  private List<Rating> userRating;

  /**
   * @return the userRating
   */
  public List<Rating> getUserRating()
  {
    return userRating;
  }

  /**
   * @param userRating
   *          the userRating to set
   */
  public void setUserRating(List<Rating> userRating)
  {
    this.userRating = userRating;
  }
}
