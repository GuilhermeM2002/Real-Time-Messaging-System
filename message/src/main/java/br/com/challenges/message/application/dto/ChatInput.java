package br.com.challenges.message.application.dto;

public record ChatInput(String user, String message, Long roomId) {
}
