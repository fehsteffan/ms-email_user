package com.ms.user.producers;


import com.ms.user.dtos.EmailDto;
import com.ms.user.model.UserModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducers {

    final RabbitTemplate rabbitTemplate;

    public UserProducers(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(UserModel userModel) {
        var emailDto = new EmailDto();
        emailDto.setUserID(userModel.getUserId());
        emailDto.setEmailTO(userModel.getEmail());
        emailDto.setSubject("Cadastro realizado com sucesso!");
        emailDto.setText(userModel.getName() + ", seja bem vindo(a)!  Agradecemos o seu cadastro!");

        rabbitTemplate.convertAndSend("", routingKey, emailDto);

    }

}
