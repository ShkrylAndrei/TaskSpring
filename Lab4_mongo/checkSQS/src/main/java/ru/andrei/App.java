package ru.andrei;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.andrei.model.Message;
import ru.andrei.model.util.Status;
import ru.andrei.model.util.Type;
import ru.andrei.repository.MessageMongoRepository;

import java.util.Date;

@SpringBootApplication
public class App {

    @Autowired
    MessageMongoRepository messageMongoRepository;

//    @Bean
//    public void testMongo(){
//        Message message = new Message(1L, Status.NEW, Type.INFO,new Date(),new Date(),"ShkrylAndrei","");
//        messageMongoRepository.save(message);
//        System.out.println("Сохранили объект message");
//    }

    public static void main(String[] args) {

        SpringApplication.run(App.class, args);
    }
}
