package org.yna.sec.securitykeycloack.service;

import org.keycloak.representations.idm.UserRepresentation;
import org.yna.sec.securitykeycloack.dto.UserDto;

import java.util.List;

public interface IKeyCloakService {
    List<UserRepresentation>findAllUsers();
    List<UserRepresentation>searchUserByUsername(String username);
    String createUser(UserDto userDto);
    void deleteUser(String userId);
    void updateUser(String userId, UserDto userDto);
}
