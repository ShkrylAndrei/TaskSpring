package ru.andrei.service;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SendMessage {
    @Autowired
    private AmazonSQSAsync sqs;

    public void sendMessage(String message) {
        // Get the URL for a queue
        String queue_url = sqs.getQueueUrl("notifications-sqs-eu-central-1").getQueueUrl();


        SendMessageRequest send_msg_request = new SendMessageRequest()
                .withQueueUrl(queue_url)
                .withMessageBody(message)
                .withDelaySeconds(5);

        SendMessageResult result = sqs.sendMessage(send_msg_request);
        System.out.println(result);

    }

}
