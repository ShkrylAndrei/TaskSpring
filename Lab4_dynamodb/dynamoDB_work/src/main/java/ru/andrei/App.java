package ru.andrei;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {


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
