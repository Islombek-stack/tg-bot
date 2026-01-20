package org.example;
import java.time.LocalDateTime;

public class User {
    private Long id;
    private Long telegramId;
    private String username;
    private Role role;
    private LocalDateTime createdAt;

    public User(Long telegramId, String username) {
        this.telegramId = telegramId;
        this.username = username;
        this.role = Role.USER;
        this.createdAt = LocalDateTime.now();
    }
    public Long getTelegramId() {
        return telegramId;
    }
    public String getUsername() {
        return username;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role ) {
        this.role = role;
    }
}
