package ru.homework.homeworkbot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update    ;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


//Defines Bot activity with reference to BotInitializer

@Component
public class TelegramBot extends TelegramLongPollingBot{

    @Override
    public void onUpdateReceived(Update update) {
        //Handles receiving of messages.
        if (update.hasMessage() && update.getMessage().hasText()) {
            if (update.getMessage().getText().equals("\start")) {
                String message_text = update.getMessage().getText();
                //Retrieves chatID to reply
                long chatId = update.getMessage().getChatId();

                SendMessage myMessage = getSendMessage(chatId);
                try {
                    execute(myMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else {

            }
        } else if (update.hasCallbackQuery()) {}
    }

    private static SendMessage getSendMessage(long chatId) {
        SendMessage myMessage = new SendMessage();
        myMessage.setChatId(String.valueOf(chatId));
        myMessage.setText("You send \start");

        InlineKeyboardMarkup markupInLine = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine = new ArrayList<>();

        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("Update message Text");
        button.setCallbackData("update_msg_text");

        rowInLine.add(button);
        rowsInLine.add(rowInLine);

        markupInLine.setKeyboard(rowsInLine);
        myMessage.setReplyMarkup(markupInLine);
        return myMessage;
    }

    @Override
    public String getBotUsername() {
        return "YourHomeWorkBot";
    }

    //чтение токена из файла
    public String readTokenFile(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\JAVA\\token.txt"));
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public String getBotToken() {
        return readTokenFile();
    }
}
