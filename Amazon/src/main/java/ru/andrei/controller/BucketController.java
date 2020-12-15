package ru.andrei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.andrei.service.AmazonClient;
import ru.andrei.service.SendMessage;

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
        sendMessage.sendMessage("Try to send file "+ file.getName());
        String resultSendFile = this.amazonClient.uploadFile(file);
        sendMessage.sendMessage("File will be send" + file.getName());
        return resultSendFile;
    }

    @DeleteMapping("/deleteFile")
    public String deleteFile(@RequestPart(value = "url") String fileUrl) {
        sendMessage.sendMessage("Try to delete file "+ fileUrl);
        String resultDeleteFile = this.amazonClient.deleteFileFromS3Bucket(fileUrl);
        sendMessage.sendMessage("File was delete "+ fileUrl);
        return resultDeleteFile;
    }
}
