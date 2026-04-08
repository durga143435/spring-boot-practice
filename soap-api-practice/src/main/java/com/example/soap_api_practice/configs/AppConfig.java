package com.example.soap_api_practice.configs;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean(name = "soapRestTemplate")
    public RestTemplate template(){

        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpComponentsClientHttpRequestFactory factory =
                new HttpComponentsClientHttpRequestFactory(httpClient);
        return  new RestTemplate(factory);
    }

   /* @Bean(name= "service1RestTemplate")
    public RestTemplate service1RestTemplate(){
        //check how set baseUrl and default parameters in RestTemplate and RestClient
        RestTemplate template = new RestTemplate();
        template.
    }*/
}
