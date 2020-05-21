/**
 * Created by gopinath_mb on 21-May-2020
 */
package com.gopi.microservices.ratingsdataservice.resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gopi.microservices.ratingsdataservice.model.Rating;

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
}
