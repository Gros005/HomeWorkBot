package ru.homework.HomeWorkBot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update    ;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

//Defines Bot activity with reference to BotInitializer

@Component
public class TelegramBot extends TelegramLongPollingBot{

    @Override
    public void onUpdateReceived(Update update){
        //Handles receiving of messages.
        if(update.hasMessage() && update.getMessage().hasText()){
            String messageText = update.getMessage().getText();
            //Retrieves chatID to reply
            long chatId = update.getMessage().getChatId();

            SendMessage myMessage = new SendMessage();
            myMessage.setChatId(String.valueOf(chatId));
            myMessage.setText("You said: " + messageText);

            try{
                execute(myMessage);
            } catch(TelegramApiException error){
                error.printStackTrace();
            }
        }

    }

    @Override
    public String getBotUsername() {
        return "YourHomeWorkBot";
    }

    @Override
    public String getBotToken() {
        return "7845355248:AAHfsZULKIJb1xd8DgrdxF6KiM914bxFK2I";
    }
}
