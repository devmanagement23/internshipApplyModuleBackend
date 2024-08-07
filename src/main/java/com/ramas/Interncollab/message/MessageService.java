package com.ramas.Interncollab.message;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramas.Interncollab.dto.MessageDTO;


@Service
public class MessageService {
	
	 @Autowired
	    private MessageRepository messageRepository;

	    public Message sendMessage(MessageDTO messageDTO) {
	        Message message = new Message();
	        message.setApplicationId(messageDTO.getApplicationId());
	        message.setSenderId(messageDTO.getSenderId());
	        message.setContent(messageDTO.getContent());
	        return messageRepository.save(message);
	    }

	    public List<Message> getMessages(Long applicationId) {
	        return messageRepository.findByApplicationId(applicationId);
	    }

}
