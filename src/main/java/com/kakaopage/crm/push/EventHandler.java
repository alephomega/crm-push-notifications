package com.kakaopage.crm.push;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;

import java.util.List;

public class EventHandler {

    private AmazonSQS sqs;

    void run() {

        while(true) {
            ReceiveMessageRequest request = new ReceiveMessageRequest();
            ReceiveMessageResult result = sqs.receiveMessage(request);
            List<Message> messages = result.getMessages();

            for (Message message : messages) {

            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException ignore) { }
        }
    }
}
