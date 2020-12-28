package ru.andrei.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "info")
public class MessageDynamoDB {

    @DynamoDBHashKey(attributeName = "id")
    @DynamoDBAutoGeneratedKey
//    @GeneratedValue(generator = "system-uuid")
//    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private Long id;

    @DynamoDBAttribute
    private String status;
    @DynamoDBAttribute
    private String type;
    @DynamoDBAttribute
    private String created;
    @DynamoDBAttribute
    private String modified;
    @DynamoDBAttribute
    private String createdBy;
    @DynamoDBAttribute
    private String modifiedBy;
    @DynamoDBAttribute
    private String textMessage;


}

