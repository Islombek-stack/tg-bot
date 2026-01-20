package org.example;

public class RoleGuard {
    public static boolean hasRole(User user, Role... roles) {
        for (Role role : roles) {
            if (user.getRole() == role) return true;
        }
        return false;
    }
}
