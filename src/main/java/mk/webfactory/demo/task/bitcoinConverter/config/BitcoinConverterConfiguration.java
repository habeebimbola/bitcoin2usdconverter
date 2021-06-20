package mk.webfactory.demo.task.bitcoinConverter.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableWebMvc
@ConfigurationProperties("application.properties")
@EnableScheduling
public class BitcoinConverterConfiguration {

    @Bean
    public RestTemplate getRestTemplate(){
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.
                setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));

       RestTemplate restTemplate = new RestTemplateBuilder().
               additionalMessageConverters(mappingJackson2HttpMessageConverter).
               build();

        return restTemplate;
    }
}
