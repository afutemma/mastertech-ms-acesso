package com.mastertech.acesso.client;

import feign.Feign;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;

public class PortaClientConfiguration {


    @Bean
    public ErrorDecoder getErrorDecoder(){
        return new PortaClientDecoder();
    }


    @Bean
    public Feign.Builder builder() {
        FeignDecorators feignDecorators = FeignDecorators.builder()
                .withFallback(new PortaClientFallback(), RetryableException.class)
                .build();

        return Resilience4jFeign.builder(feignDecorators);
    }

}
