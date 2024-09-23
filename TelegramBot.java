package ru.homework.HomeWorkBot.serice;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.homework.HomeWorkBot.config.BotConfig;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    final BotConfig config;

    public TelegramBot (BotConfig config){
        this.config = config;
    }

    @Override
    public String getBotToken() {
        return config.getBotName();
    }

    @Override
    public String getBotUsername() {
        return config.getToken();
    }
    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()){
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            switch(messageText){

                case "/start":
                    try {
                        startCommandReceived(chatId, update.getMessage().getChat().getFirstName());
                    } catch (TelegramApiException e) {
                        ;
                    }
                    break;

                case "/help":
                    try{
                        helpCommandReceived(chatId, update.getMessage().getChat().getFirstName());
                    }catch(TelegramApiException e){
                        ;
                    }

                default:
                    try {
                        sendMessage(chatId, "Sorry< command wasn't recognized.");
                    } catch (TelegramApiException e) {
                        ;
                    }
                    break;
            }
        }

    }

    private void helpCommandReceived(long chatId, String name)throws TelegramApiException {

        String answer = "Hi, " + name + ". You can choose some interesting options like: ........ Thank you! ";
        sendMessage(chatId, answer);
    }

    private void startCommandReceived(long chatId, String name) throws TelegramApiException {

        String answer = "Hi, " + name + ", nice to meet you! ";
        sendMessage(chatId, answer);
    }

    private void sendMessage(long chatId, String textToSend) throws TelegramApiException {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);

        try {
            execute(message);
        }catch (TelegramApiException e){
            ;
        }

    }
}
