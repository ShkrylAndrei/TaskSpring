package ru.andrei.poller;

import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationSQSPoller {
    @SqsListener(value = "notifications-sqs-eu-central-1", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void receiveNotificationFromSQS(String message) {
        System.out.println(message);
    }
}
