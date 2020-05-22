/**
 * Created by gopinath_mb on 21-May-2020
 */
package com.gopi.microservices.ratingsdataservice.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gopi.microservices.ratingsdataservice.model.Rating;
import com.gopi.microservices.ratingsdataservice.model.UserRating;

/**
 * @author gopinath_mb
 */
@RestController
@RequestMapping("/ratingsData")
public class RatingsResource
{

  @RequestMapping("/{movieId}")
  public Rating getRating(@PathVariable String movieId)
  {
    return new Rating(movieId, 3);
  }

  @RequestMapping("/users/{userId}")
  public UserRating getUserRating(@PathVariable String userId)
  {
    List<Rating> ratings = Arrays.asList(new Rating("123", 4),
        new Rating("456", 3));

    UserRating userRating = new UserRating();
    userRating.setUserRating(ratings);
    return userRating;
  }
}
