/**
 * Created by gopinath_mb on 27-May-2020
 */
package com.gopi.microservices.moviecatalogueservice.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gopi.microservices.moviecatalogueservice.model.Rating;
import com.gopi.microservices.moviecatalogueservice.model.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author gopinath_mb
 */
@Service
public class UserRatingInfo
{

  @Autowired
  private RestTemplate restTemplate;

  @HystrixCommand(fallbackMethod = "getFallbackRatingInfo")
  public UserRating getRatingInfo(String userId)
  {
    return restTemplate.getForObject(
        "http://ratings-data-service/ratingsData/users/" + userId,
        UserRating.class);
  }

  private UserRating getFallbackRatingInfo(String userId)
  {
    UserRating userRating = new UserRating();
    userRating.setUserRating(
        Arrays.asList(new Rating("100", 4), new Rating("200", 3)));
    return userRating;

  }

}
