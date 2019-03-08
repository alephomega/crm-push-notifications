package com.kakaopage.crm.push;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;

import java.util.List;

public class EventDispatcher implements Runnable {

    private final AmazonSQS sqs;

    public EventDispatcher(AmazonSQS sqs) {
        this.sqs = sqs;
    }

    @Override
    public void run() {

        while(true) {
            ReceiveMessageRequest request = new ReceiveMessageRequest();
            ReceiveMessageResult result = sqs.receiveMessage(request);
            List<Message> messages = result.getMessages();

            for (Message message : messages) {
                handle(message);
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException ignore) { }
        }
    }

    private void handle(Message message) {

    }
}
