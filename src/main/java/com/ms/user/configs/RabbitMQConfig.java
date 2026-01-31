package com.ms.user.configs;


import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.context.annotation.Configuration;
import tools.jackson.databind.ObjectMapper;


@Configuration
public class RabbitMQConfig {


    public JacksonJsonMessageConverter jacksonJsonMessageConverter(){
        ObjectMapper objectMapper = new ObjectMapper();
    return new JacksonJsonMessageConverter();

           }

    }
