package org.example;
import java.util.*;

public class UserRepository {
    private final Map<Long, User> users = new HashMap<>();

    public User findOrCreate(Long telegramId, String username) {
        return users.computeIfAbsent(
                telegramId,
                id -> new User(id, username)
        );
    }

    public User findByTelegramId(Long telegramId) {
        return users.get(telegramId);
    }

    public Collection<User> findAll() {
        return users.values();
    }
}
