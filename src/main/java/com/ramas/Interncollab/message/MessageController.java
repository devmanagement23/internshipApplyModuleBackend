package com.ramas.Interncollab.message;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ramas.Interncollab.dto.MessageDTO;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
	
	
	 @Autowired
	    private MessageService messageService;

	    @PostMapping
	    public ResponseEntity<Message> sendMessage(@RequestBody MessageDTO messageDTO) {
	        Message message = messageService.sendMessage(messageDTO);
	        return ResponseEntity.ok(message);
	    }

	    @GetMapping("/application/{applicationId}")
	    public ResponseEntity<List<Message>> getMessages(@PathVariable Long applicationId) {
	        List<Message> messages = messageService.getMessages(applicationId);
	        return ResponseEntity.ok(messages);
	    }

}
