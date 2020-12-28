package ru.andrei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.andrei.model.Message;
import ru.andrei.model.util.Status;
import ru.andrei.model.util.Type;
import ru.andrei.service.AmazonClient;
import ru.andrei.service.SendMessage;

import java.util.Date;

@RestController
@RequestMapping("/storage/")
public class BucketController {
    private AmazonClient amazonClient;
    @Autowired
    private SendMessage sendMessage;


    @Autowired
    BucketController(AmazonClient amazonClient) {
        this.amazonClient = amazonClient;
    }

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestPart(value = "file") MultipartFile file) {
        Message message = new Message();
        message.setStatus(Status.NEW);
        message.setType(Type.INFO);
        message.setCreated(new Date());
        message.setModified(new Date());
        message.setCreatedBy("Shkryl Andrei");
        message.setModifiedBy("AWS");
        message.setTextMessage("Try to send file "+ file.getName());
        message.setId((long)message.hashCode());

        sendMessage.sendMessage(message);

        //sendMessage.sendMessage("Try to send file "+ file.getName());
        String resultSendFile = this.amazonClient.uploadFile(file);

        message.setStatus(Status.COMPLETED);
        message.setType(Type.INFO);
        message.setCreated(new Date());
        message.setModified(new Date());
        message.setCreatedBy("Shkryl Andrei");
        message.setModifiedBy("AWS");
        message.setTextMessage("File was be send"+ file.getName());
        message.setId((long)message.hashCode());

        sendMessage.sendMessage(message);

        return resultSendFile;
    }

    @DeleteMapping("/deleteFile")
    public String deleteFile(@RequestPart(value = "url") String fileUrl) {
        Message message = new Message();
        message.setStatus(Status.NEW);
        message.setType(Type.INFO);
        message.setCreated(new Date());
        message.setModified(new Date());
        message.setCreatedBy("Shkryl Andrei");
        message.setModifiedBy("AWS");
        message.setTextMessage("Try to delete file "+ fileUrl);
        message.setId((long)message.hashCode());
        sendMessage.sendMessage(message);

        String resultDeleteFile = this.amazonClient.deleteFileFromS3Bucket(fileUrl);

        message.setStatus(Status.COMPLETED);
        message.setType(Type.INFO);
        message.setCreated(new Date());
        message.setModified(new Date());
        message.setCreatedBy("Shkryl Andrei");
        message.setModifiedBy("AWS");
        message.setTextMessage("File was delete "+ fileUrl);
        message.setId((long)message.hashCode());

        sendMessage.sendMessage(message);

        return resultDeleteFile;
    }
}
