package org.example;

import java.io.InputStream;
import java.util.Properties;

public class BotConfig {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input =
                     BotConfig.class
                             .getClassLoader()
                             .getResourceAsStream("config.properties")) {

            if (input == null) {
                throw new RuntimeException("config.properties not found");
            }
            properties.load(input);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getUsername() {
        return properties.getProperty("bot.username");
    }

    public static String getToken() {
        return properties.getProperty("bot.token");
    }
}
