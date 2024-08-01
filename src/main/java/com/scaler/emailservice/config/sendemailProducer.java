package com.scaler.emailservice.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scaler.emailservice.DTos.sendEmailDTO;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class sendemailProducer {
    private ObjectMapper objectMapper;
    public sendemailProducer(ObjectMapper objectMapper){
        this.objectMapper=objectMapper;
    }
    @KafkaListener(topics="sendEmail",groupId="Emailservice")//consumer of kafka message and it is listening on topic mentioned in user service.
    public void handleMessage(String message){
        sendEmailDTO sendemailDTO=null;
        try{
            sendemailDTO=objectMapper.readValue(message, sendEmailDTO.class);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(sendemailDTO);
    }
}
