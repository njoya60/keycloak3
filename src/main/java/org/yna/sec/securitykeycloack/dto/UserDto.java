package org.yna.sec.securitykeycloack.dto;

import lombok.Builder;

import java.util.Set;

@Builder
public record UserDto(String username, String email, String firstName,
                      String lastName, String password, Set<String> roles) {
}
