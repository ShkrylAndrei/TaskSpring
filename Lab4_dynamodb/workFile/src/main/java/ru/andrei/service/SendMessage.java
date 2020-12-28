package ru.andrei.service;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.andrei.model.Message;


@Service
public class SendMessage {
    ObjectMapper mapper = new ObjectMapper ();

    @Autowired
    private AmazonSQSAsync sqs;
    //ссылка
    //https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/examples-sqs-message-queues.html

    public void sendMessage(String message) {
        // Get the URL for a queue
        String queue_url = sqs.getQueueUrl("notifications-sqs-eu-central-1").getQueueUrl();


        SendMessageRequest send_msg_request = new SendMessageRequest()
                .withQueueUrl(queue_url)
                .withMessageBody(message)
                .withDelaySeconds(5);

        SendMessageResult result = sqs.sendMessage(send_msg_request);
        //почему здесь вывод в консоль не работает
        System.out.println(result);
        //sqs.sendMessage(send_msg_request);
    }

    public void sendMessage(Message message) {
        // Get the URL for a queue
        String queue_url = sqs.getQueueUrl("notifications-sqs-eu-central-1").getQueueUrl();

        String jsonString = null;
        try {
            jsonString = mapper.writeValueAsString(message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        SendMessageRequest send_msg_request = new SendMessageRequest()
                .withQueueUrl(queue_url)
                .withMessageBody(jsonString)
                .withDelaySeconds(5);

        SendMessageResult result = sqs.sendMessage(send_msg_request);
        System.out.println(result);
    }

}
