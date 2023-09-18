package org.example;

import lombok.SneakyThrows;
import org.example.model.user.UserState;
import org.example.repository.UserRepositoryImpl;
import org.example.service.EvosBotService;
import org.example.service.UserService;
import org.example.model.user.User;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Contact;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public class EvosBot extends TelegramLongPollingBot {
    UserService userService = UserService.getInstance();

    EvosBotService evosBotService = new EvosBotService();
    UserRepositoryImpl userRepository = UserRepositoryImpl.getInstance();

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            String text = message.getText();
            System.out.println(text);
            Long chatId = message.getChatId();

            User currentUser = userService.getByChatId(chatId);

            if (currentUser == null) {
                if (message.hasContact()) {
                    Chat chat = message.getChat();
                    Contact contact = message.getContact();
                    userService.addUser(contact, chat.getBio(), chat.getUserName(), 0);
                    userService.updateState(chatId, UserState.REGISTERED);
                    execute(evosBotService.welcomeMessage(chatId.toString()));
                } else {
                    execute(evosBotService.requestContactMessage(chatId.toString()));
                }
                return;
            }
            switch (text) {
                case "/start" -> {
                    execute(evosBotService.welcomeMessage(chatId.toString()));
                    currentUser.setState(UserState.REGISTERED);
                    userService.updateState(chatId, UserState.REGISTERED);
                    return;
                }
                case "\uD83C\uDF7D  Menyu" -> {
                    userService.updateState(chatId, UserState.MENU);
                    currentUser.setState(UserState.MENU);
                    execute(evosBotService.menuMessage(chatId.toString()));
                }
                case "\uD83E\uDED4  Lavash" -> {
                    currentUser.setState(UserState.LAVASH);
                    userService.updateState(chatId, UserState.LAVASH);
                    execute(evosBotService.lavashPhoto(chatId.toString()));
                    execute(new SendMessage(chatId.toString(), "Tanlang"));
                    return;
                }
                case "\uD83E\uDD59  Shaurma" -> {
                    currentUser.setState(UserState.SHAURMA);
                    userService.updateState(chatId, UserState.SHAURMA);
                    execute(evosBotService.shaurmaPhoto(chatId.toString()));
                    execute(new SendMessage(chatId.toString(), "Tanlang"));
                    return;
                }
                case "\uD83C\uDF54  Burger" -> {
                    currentUser.setState(UserState.BURGER);
                    userService.updateState(chatId, UserState.BURGER);
                    execute(evosBotService.burgerPhoto(chatId.toString()));
                    execute(new SendMessage(chatId.toString(), "Tanlang"));
                    return;
                }
                case "\uD83C\uDF2D  Hot_Dog" -> {
                    currentUser.setState(UserState.HOD_DOG);
                    userService.updateState(chatId, UserState.HOD_DOG);
                    execute(evosBotService.hotDogPhoto(chatId.toString()));
                    execute(new SendMessage(chatId.toString(), "Tanlang"));
                    return;
                }
                case "\uD83C\uDF7E  Ichimlik" -> {
                    currentUser.setState(UserState.ICHIMLIK);
                    userService.updateState(chatId, UserState.ICHIMLIK);
                    execute(evosBotService.ichimlikPhoto(chatId.toString()));
                    execute(new SendMessage(chatId.toString(), "Tanlang"));
                    return;
                }
                case "\uD83D\uDCDE  Contacts" -> {
                    execute(evosBotService.ContactMessage(chatId.toString()));
                    currentUser.setState(UserState.CONTACT);
                    userService.updateState(chatId, UserState.CONTACT);
                    return;
                }
                case "\uD83D\uDE96  Buyurtma berish" -> {
                    execute(evosBotService.AdminBuyurtmaMessage(chatId.toString()));
                    userService.updateState(chatId, UserState.BUYURTMA_BERISH);
                    return;
                }
            }

            switch (currentUser.getState()) {
                case MENU -> {
                    if (message.getText().equals("⬅️  Ortga")) {
                        userService.updateState(chatId, UserState.REGISTERED);
                        execute(evosBotService.welcomeMessage(chatId.toString()));
                    }
                }
                case LAVASH -> {
                    if (message.getText().equals("\uD83E\uDED4  Mol go'shtidan lavash")) {
                        execute(evosBotService.molGushLavashPhoto(chatId.toString()));
                        userService.updateState(chatId, UserState.BUYURTMA_BERISH);
                    }
                    else if (message.getText().equals("\uD83E\uDED4  Mol go'shtidan pishloqli lavash")) {
                        execute(evosBotService.molGushPishloqLavashPhoto(chatId.toString()));
                        userService.updateState(chatId, UserState.BUYURTMA_BERISH);
                    }
                    else if (message.getText().equals("\uD83E\uDED4  Tovuq go'shtli lavash")) {
                        execute(evosBotService.tovuqGushLavashPhoto(chatId.toString()));
                        userService.updateState(chatId, UserState.BUYURTMA_BERISH);
                    }
                    else if (message.getText().equals("\uD83E\uDED4  Tovuq go'shtidan pishloqli lavash")) {
                        execute(evosBotService.tovuqGushPishloqliLavashPhoto(chatId.toString()));
                        userService.updateState(chatId, UserState.BUYURTMA_BERISH);
                    }
                    else if (message.getText().equals("\uD83E\uDED4  Mol go'shtidan qalampir lavash")) {
                        execute(evosBotService.molGushQalampirLavashPhoto(chatId.toString()));
                        userService.updateState(chatId, UserState.BUYURTMA_BERISH);
                    }
                    else if (message.getText().equals("\uD83E\uDED4  Tovuq go'shtidan qalampir lavash")) {
                        execute(evosBotService.tovuqGushQalampirLavashPhoto(chatId.toString()));
                        userService.updateState(chatId, UserState.BUYURTMA_BERISH);
                    }
                   else if (message.getText().equals("⬅️  Ortga")) {
                        userService.updateState(chatId, UserState.LAVASH);
                        execute(evosBotService.menuMessage(chatId.toString()));
                    }
                }
                case SHAURMA -> {
                    if (message.getText().equals("\uD83E\uDD59  Mol go'shtidan shaurma")) {
                        execute(evosBotService.molGushShaurmaPhoto(chatId.toString()));
                        userService.updateState(chatId, UserState.BUYURTMA_BERISH);
                    }
                    else if (message.getText().equals("\uD83E\uDD59  Tovuq go'shtli shaurma")) {
                        execute(evosBotService.tovuqGushShaurmaPhoto(chatId.toString()));
                        userService.updateState(chatId, UserState.BUYURTMA_BERISH);
                    }
                    else if (message.getText().equals("\uD83E\uDD59  Mol go'shtidan pishloqli shaurma")) {
                        execute(evosBotService.molGushPishloqShaurmaPhoto(chatId.toString()));
                        userService.updateState(chatId, UserState.BUYURTMA_BERISH);
                    }
                    else if (message.getText().equals("\uD83E\uDD59  Tovuq go'shtidan pishloqli shaurma")) {
                        execute(evosBotService.tovuqGushPishloqliShaurmaPhoto(chatId.toString()));
                        userService.updateState(chatId, UserState.BUYURTMA_BERISH);
                    }
                   else if (message.getText().equals("\uD83E\uDD59  Tovuq go'shtidan qalampir shaurma")) {
                        execute(evosBotService.tovuqGushQalampirShaurmaPhoto(chatId.toString()));
                        userService.updateState(chatId, UserState.BUYURTMA_BERISH);
                    }
                    else if (message.getText().equals("\uD83E\uDD59  Mol go'shtidan qalampir shaurma")) {
                        execute(evosBotService.molGushQalampirShaurmaPhoto(chatId.toString()));
                        userService.updateState(chatId, UserState.BUYURTMA_BERISH);
                    }
                    else if (message.getText().equals("⬅️  Ortga")) {
                        userService.updateState(chatId, UserState.LAVASH);
                        execute(evosBotService.menuMessage(chatId.toString()));
                    }
                }
                case BURGER -> {
                    if (message.getText().equals("\uD83C\uDF54  Gamburger")) {
                        execute(evosBotService.gamburgerBurgerPhoto(chatId.toString()));
                        userService.updateState(chatId, UserState.BUYURTMA_BERISH);
                    }
                    else if (message.getText().equals("\uD83C\uDF54  Double burger")) {
                        execute(evosBotService.doubleBurgerBurgerPhoto(chatId.toString()));
                        userService.updateState(chatId, UserState.BUYURTMA_BERISH);
                    }
                    else if (message.getText().equals("\uD83C\uDF54  Cheese burger")) {
                        execute(evosBotService.cheeseBurgerBurgerPhoto(chatId.toString()));
                        userService.updateState(chatId, UserState.BUYURTMA_BERISH);
                    }
                    else if (message.getText().equals("\uD83C\uDF54  Double cheese")) {
                        execute(evosBotService.doubleCheeseBurgerPhoto(chatId.toString()));
                        userService.updateState(chatId, UserState.BUYURTMA_BERISH);
                    }
                    else if (message.getText().equals("⬅️  Ortga")) {
                        userService.updateState(chatId, UserState.BURGER);
                        execute(evosBotService.menuMessage(chatId.toString()));
                    }
                }
                case HOD_DOG -> {
                    if (message.getText().equals("\uD83C\uDF2D  Hot-dog baguette")) {
                        execute(evosBotService.hotDogBaugetteHotDogPhoto(chatId.toString()));
                        userService.updateState(chatId, UserState.BUYURTMA_BERISH);
                    }
                    else if (message.getText().equals("\uD83C\uDF2D  Hot-dog baguette double")) {
                        execute(evosBotService.hotDogBaugetteDoubleHotDogPhoto(chatId.toString()));
                        userService.updateState(chatId, UserState.BUYURTMA_BERISH);
                    }
                    else if (message.getText().equals("\uD83C\uDF2D  Sub tovuq")) {
                        execute(evosBotService.subTovuqHotDogPhoto(chatId.toString()));
                        userService.updateState(chatId, UserState.BUYURTMA_BERISH);
                    }
                    else if (message.getText().equals("\uD83C\uDF2D  Sub tovuq cheese")) {
                        execute(evosBotService.subTovuqCheeseHotDogPhoto(chatId.toString()));
                        userService.updateState(chatId, UserState.BUYURTMA_BERISH);
                    }
                    else if (message.getText().equals("\uD83C\uDF2D  Sub go'sht")) {
                        execute(evosBotService.subGushHotDogPhoto(chatId.toString()));
                        userService.updateState(chatId, UserState.BUYURTMA_BERISH);
                    }
                    else if (message.getText().equals("\uD83C\uDF2D  Sub go'sht cheese")) {
                        execute(evosBotService.subGushCheeseHotDogPhoto(chatId.toString()));
                        userService.updateState(chatId, UserState.BUYURTMA_BERISH);
                    }
                    else if (message.getText().equals("\uD83C\uDF2D  Hot-dog classic")) {
                        execute(evosBotService.hotDogClassicHotDogPhoto(chatId.toString()));
                        userService.updateState(chatId, UserState.BUYURTMA_BERISH);
                    }
                    else if (message.getText().equals("\uD83C\uDF2D  Hot-dog kids")) {
                        execute(evosBotService.hotDogKidsHotDogPhoto(chatId.toString()));
                        userService.updateState(chatId, UserState.BUYURTMA_BERISH);
                    }
                    else if (message.getText().equals("⬅️  Ortga")) {
                        userService.updateState(chatId, UserState.HOD_DOG);
                        execute(evosBotService.menuMessage(chatId.toString()));
                    }
                }
                case ICHIMLIK -> {
                    if (message.getText().equals("\uD83C\uDF78  Suv 0,5")) {
                        execute(evosBotService.suvYarimIchimlikPhoto(chatId.toString()));
                        userService.updateState(chatId, UserState.BUYURTMA_BERISH);
                    }
                    else if (message.getText().equals("\uD83E\uDDC3  Sok dena")) {
                        execute(evosBotService.sokDenaIchimlikPhoto(chatId.toString()));
                        userService.updateState(chatId, UserState.BUYURTMA_BERISH);
                    }
                    else if (message.getText().equals("\uD83E\uDD64  Pepsi 0,5")) {
                        execute(evosBotService.pepsiYarimIchimlikPhoto(chatId.toString()));
                        userService.updateState(chatId, UserState.BUYURTMA_BERISH);
                    }
                    else if (message.getText().equals("\uD83E\uDD64  Pepsi 1,5")) {
                        execute(evosBotService.pepsiBirYarimIchimlikPhoto(chatId.toString()));
                        userService.updateState(chatId, UserState.BUYURTMA_BERISH);
                    }
                    else if (message.getText().equals("☕️  Ko'k choy")) {
                        execute(evosBotService.kukChoyIchimlikPhoto(chatId.toString()));
                        userService.updateState(chatId, UserState.BUYURTMA_BERISH);
                    }
                    else if (message.getText().equals("☕️  Qora choy")) {
                        execute(evosBotService.qoraChoyIchimlikPhoto(chatId.toString()));
                        userService.updateState(chatId, UserState.BUYURTMA_BERISH);
                    }
                    else if (message.getText().equals("☕️  Limonli ko'k choy")) {
                        execute(evosBotService.limonKukChoyIchimlikPhoto(chatId.toString()));
                        userService.updateState(chatId, UserState.BUYURTMA_BERISH);
                    }
                    else if (message.getText().equals("☕️  Limonli qora choy")) {
                        execute(evosBotService.limonQoraChoyIchimlikPhoto(chatId.toString()));
                        userService.updateState(chatId, UserState.BUYURTMA_BERISH);
                    }
                    else if (message.getText().equals("\uD83C\uDF77  Bliss sharbati")) {
                        execute(evosBotService.blissSharbatiIchimlikPhoto(chatId.toString()));
                        userService.updateState(chatId, UserState.BUYURTMA_BERISH);
                    }
                    if (message.getText().equals("⬅️  Ortga")) {
                        userService.updateState(chatId, UserState.ICHIMLIK);
                        execute(evosBotService.menuMessage(chatId.toString()));
                    }
                }case BUYURTMA_BERISH -> {
                    if (message.getText().equals("⬅️  Ortga")) {
                        userService.updateState(chatId, UserState.LAVASH);
                        execute(evosBotService.lavashPhoto(chatId.toString()));
                    }
                    else if (message.getText().equals("◀️  Ortga")) {
                        userService.updateState(chatId, UserState.SHAURMA);
                        execute(evosBotService.shaurmaPhoto(chatId.toString()));
                    }
                    else if (message.getText().equals("↖️  Ortga")) {
                        userService.updateState(chatId, UserState.BURGER);
                        execute(evosBotService.burgerPhoto(chatId.toString()));
                    }
                    else if (message.getText().equals("⏪  Ortga")) {
                        userService.updateState(chatId, UserState.HOD_DOG);
                        execute(evosBotService.hotDogPhoto(chatId.toString()));
                    }
                    else if (message.getText().equals("\uD83D\uDD19  Ortga")) {
                        userService.updateState(chatId, UserState.ICHIMLIK);
                        execute(evosBotService.ichimlikPhoto(chatId.toString()));
                    }
                }
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "evosDeleverybot";
    }

    @Override
    public String getBotToken() {
        return "6018943175:AAEjrrn-o6BOiHSQfP1HM9N76BLPfM-EMlY";
    }
}
