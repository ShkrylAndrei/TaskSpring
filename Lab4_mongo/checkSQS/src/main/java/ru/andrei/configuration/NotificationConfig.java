package ru.andrei.configuration;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class NotificationConfig {

    @Bean
    public AWSCredentialsProvider awsCredentialsProvider(@Value("${cloud.aws.credentials.access-key}") String accessKey,
                                                         @Value("${cloud.aws.credentials.secret-key}") String secretKey) {
        return new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey));
    }

    @Bean
    @Primary
    public AmazonSQSAsync amazonSQSAsync(AWSCredentialsProvider awsCredentialsProvider, @Value("${sqs.notifications.queue.region}") String region) {
        return AmazonSQSAsyncClientBuilder
                .standard()
                .withRegion(region)
                .withCredentials(awsCredentialsProvider)
                .build();
    }

    @Bean
    public QueueMessagingTemplate queueMessagingTemplate(AmazonSQSAsync amazonSQSAsync) {
        return new QueueMessagingTemplate(amazonSQSAsync);
    }
}
