package ru.andrei.poller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Service;
import ru.andrei.model.MessageDynamoDB;
import ru.andrei.repository.InfoDynamoRepository;

@Service
public class NotificationSQSPoller {
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private InfoDynamoRepository repo;


    @SqsListener(value = "notifications-sqs-eu-central-1", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void receiveNotificationFromSQS(String msg) {
        MessageDynamoDB message = null;
        try {
            message = mapper.readValue(msg, MessageDynamoDB.class);
            repo.save(message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(message);
    }
}
