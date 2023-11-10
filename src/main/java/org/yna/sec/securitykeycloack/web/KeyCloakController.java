package org.yna.sec.securitykeycloack.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.yna.sec.securitykeycloack.dto.UserDto;
import org.yna.sec.securitykeycloack.service.IKeyCloakService;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/keycloak/user")
@PreAuthorize("hasRole('client_admin')")
@RequiredArgsConstructor
public class KeyCloakController {

    private final IKeyCloakService iKeyCloakService;

    @GetMapping("search")
    public ResponseEntity<?> findAllUsers() {
        return ResponseEntity.ok(iKeyCloakService.findAllUsers());
    }

    @GetMapping("search/{username}")
    public ResponseEntity<?> findAllUsernames(@PathVariable String username) {
        return ResponseEntity.ok(iKeyCloakService.searchUserByUsername(username));
    }

    @PostMapping("create")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) throws URISyntaxException {
        String response = iKeyCloakService.createUser(userDto);
        return ResponseEntity.created(new URI("/keycloak/user/create")).body(response);
    }

    @PutMapping("update/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable String userId, @RequestBody UserDto userDto) {
        iKeyCloakService.updateUser(userId, userDto);
        return ResponseEntity.ok("User updated successfully !!!");
    }

    @DeleteMapping("delete/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable String userId) {
        iKeyCloakService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }


}
