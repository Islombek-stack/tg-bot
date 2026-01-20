package org.example;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;


public class RoleBasedBot extends TelegramLongPollingBot {

    private final UserRepository userRepository = new UserRepository();

    @Override
    public void onUpdateReceived(Update update) {
        if (!update.hasMessage() || !update.getMessage().hasText()) return;

        Long chatId = update.getMessage().getChatId();
        Long telegramId = update.getMessage().getFrom().getId();
        String username = update.getMessage().getFrom().getUserName();
        String text = update.getMessage().getText();

        User user = userRepository.findOrCreate(telegramId, username);

        try {
            if (text.equals("/start")) {
                send(chatId, "Вы зарегистрированы. Роль: " + user.getRole());
            }
            else if (text.equals("/profile")) {
                send(chatId,
                        "ID: " + user.getTelegramId() +
                                "\nUsername: @" + user.getUsername() +
                                "\nRole: " + user.getRole()
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void send(Long chatId, String text) throws Exception {
        execute(new SendMessage(chatId.toString(), text));
    }

    @Override
    public String getBotUsername() {
        return BotConfig.getUsername();
    }

    @Override
    public String getBotToken() {
        return BotConfig.getToken();
    }
}
