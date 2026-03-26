package com.medlink.tracker.controller;

import com.medlink.tracker.dto.ChatRequestDto;
import com.medlink.tracker.dto.ChatResponseDto;
import com.medlink.tracker.service.ChatBotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chatbot")
@CrossOrigin(origins = "*")
public class ChatBotController {

    private final ChatBotService chatBotService;

    public ChatBotController(ChatBotService chatBotService) {
        this.chatBotService = chatBotService;
    }

    @PostMapping("/message")
    public ResponseEntity<ChatResponseDto> sendMessage(@RequestBody ChatRequestDto request) {
        String reply = chatBotService.getReply(request);
        return ResponseEntity.ok(new ChatResponseDto(reply));
    }
}
