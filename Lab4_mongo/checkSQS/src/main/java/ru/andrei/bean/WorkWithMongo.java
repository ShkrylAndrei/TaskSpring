package ru.andrei.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import ru.andrei.model.Message;
import ru.andrei.model.util.Status;
import ru.andrei.model.util.Type;
import ru.andrei.repository.MessageMongoRepository;

import java.util.Date;
import java.util.Optional;

@Service
public class WorkWithMongo {
    @Autowired
    MessageMongoRepository messageMongoRepository;


   public void saveNewMongo(String textMessage){
        Message message = new Message(2L,
                                      Status.NEW,
                                      Type.INFO,
                                      new Date(),
                                      new Date(),
                                      "ShkrylAndrei",
                                      "",
                                       textMessage);
        messageMongoRepository.save(message);
        System.out.println("Сохранили объект message");
    }

    public void deleteRecordMongo(Long id){
        Optional<Message> message = messageMongoRepository.findById(1L);
        messageMongoRepository.delete(message.get());
        System.out.println("Удалили объект message");
    }
}
