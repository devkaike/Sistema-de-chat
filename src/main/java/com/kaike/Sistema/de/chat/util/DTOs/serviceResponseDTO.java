package com.kaike.Sistema.de.chat.util.DTOs;

public record serviceResponseDTO<Type>(int status, Type message) {
}
