package com.medlink.tracker.dto;

import java.util.List;

public class ChatRequestDto {

    private String message;
    private String userRole;
    private List<HistoryMessage> history;

    public ChatRequestDto() {}

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getUserRole() { return userRole; }
    public void setUserRole(String userRole) { this.userRole = userRole; }

    public List<HistoryMessage> getHistory() { return history; }
    public void setHistory(List<HistoryMessage> history) { this.history = history; }

    public static class HistoryMessage {
        private String role;
        private String content;

        public HistoryMessage() {}

        public String getRole() { return role; }
        public void setRole(String role) { this.role = role; }

        public String getContent() { return content; }
        public void setContent(String content) { this.content = content; }
    }
}
