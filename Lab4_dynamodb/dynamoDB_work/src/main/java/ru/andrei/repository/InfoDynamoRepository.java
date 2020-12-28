package ru.andrei.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import ru.andrei.model.MessageDynamoDB;

import java.util.Optional;

@EnableScan
public interface InfoDynamoRepository extends CrudRepository<MessageDynamoDB,Long> {
    Optional<MessageDynamoDB> findById(Long id);
}

