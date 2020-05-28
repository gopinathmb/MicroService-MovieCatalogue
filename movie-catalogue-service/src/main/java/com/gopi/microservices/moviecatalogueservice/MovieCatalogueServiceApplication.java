/**
 * Created by gopinath_mb on 21-May-2020
 */
package com.gopi.microservices.moviecatalogueservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;

/**
 * @author gopinath_mb
 */
@SpringBootApplication
@EnableHystrix
@EnableCircuitBreaker
@EnableHystrixDashboard
public class MovieCatalogueServiceApplication
{

  public static void main(String[] args)
  {
    SpringApplication.run(MovieCatalogueServiceApplication.class, args);
  }

  @Bean
  @LoadBalanced
  public RestTemplate getRestTemplate()
  {
    HttpComponentsClientHttpRequestFactory requestFactory=new HttpComponentsClientHttpRequestFactory();
    requestFactory .setConnectTimeout(3000);
    RestTemplate restTemplate = new RestTemplate(requestFactory);
    return restTemplate;
  }

  public Builder getWebClientBuilder()
  {

    return WebClient.builder();
  }

}
