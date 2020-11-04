package com.example.studentapi.config;

import com.example.studentapi.external.address.AddressLookup;
import com.example.studentapi.external.address.AddressLookupViaCep;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableJpaRepositories("com.example.studentapi.student")
public class ApplicationConfig {

  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder builder) {
    return builder.build();
  }

  @Bean
  public AddressLookup addressLookupViaCepConfiguration(RestTemplate restTemplate) {
    return new AddressLookupViaCep(restTemplate);
  }
}
