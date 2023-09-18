package org.example.service;

import org.example.model.user.UserState;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import java.util.ArrayList;
import java.util.List;

public class EvosBotService {
    UserService userService = UserService.getInstance();

    public SendMessage requestContactMessage(String chatId) {
        SendMessage sendMessage = new SendMessage(chatId, "📞 Please share your number");
        sendMessage.setReplyMarkup(requestContactButton());
        return sendMessage;

    }

    public SendMessage requestLocationMessage(String chatId) {
        SendMessage sendMessage = new SendMessage(chatId, "\uD83D\uDCCD Please share your location");
        sendMessage.setReplyMarkup(requestLocationButton());
        return sendMessage;
    }

    public SendMessage welcomeMessage(String chatId) {
        SendMessage sendMessage = new SendMessage(chatId, "Welcome to Evos  \uD83C\uDF7D");
        sendMessage.setReplyMarkup(mainMenuButton());
        return sendMessage;
    }

    public SendMessage menuMessage(String chatId) {
        SendMessage sendMessage = new SendMessage(chatId, "Menyuni tanlang ");
        sendMessage.setReplyMarkup(menuButton());
        return sendMessage;
    }
    public SendMessage ContactMessage(String chatId) {
        SendMessage sendMessage = new SendMessage(chatId, "Menyuni tanlang ");
        sendMessage.setReplyMarkup(contactButton());
        return sendMessage;
    }
    public SendMessage AdminBuyurtmaMessage(String chatId) {
        SendMessage sendMessage = new SendMessage(chatId,"\uD83D\uDC68\uD83C\uDFFB\u200D\uD83D\uDCBB  Buyurtmani qabul qiluvchi");
        sendMessage.setReplyMarkup(AdminBuyurtmaButton());
        return sendMessage;
    }

    public SendPhoto lavashPhoto(String chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://img.freepik.com/free-photo/lavash-roll-with-onion-and-vegetables_140725-9844.jpg?w=2000"));
        sendPhoto.setReplyMarkup(lavashButton());
        return sendPhoto;
    }

    public SendPhoto molGushLavashPhoto(String chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://pasta.uz/upload/products/%D0%9B%D0%B0%D0%B2%D0%B0%D1%88.jpg"));
        sendPhoto.setCaption("Qarsildoq chipslar, yangi bodring va pomidorlar bilan lavashga oʼralgan yumshoq mol goʼshti, bizning taʼmi oʼtkir qayla bilan\n" +
                " Narxi: 26 000 so'm");
        sendPhoto.setReplyMarkup(buyurtmaBerishLavashButton());
        return sendPhoto;
    }
    public SendPhoto molGushShaurmaPhoto(String chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTx_mIYa8H27kN3J8I-4tEgik-gZeNheOjvCzf0PH6OtYEvAtDDIYeYybHrFV4StewXcks&usqp=CAU"));
        sendPhoto.setCaption("Qarsildoq chipslar, yangi bodring va pomidorlar bilan non ichiga solingan yumshoq mol goʼshtili shaurma, bizning taʼmi oʼtkir qayla bilan\n" +
                " Narxi: 26 000 so'm");
        sendPhoto.setReplyMarkup(buyurtmaBerishShaurmaButton());
        return sendPhoto;
    }
    public SendPhoto molGushPishloqLavashPhoto(String chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://yukber.uz/image/cache/catalog/kavash-700x700.jpg"));
        sendPhoto.setCaption("Qarsildoq chipslar, yangi bodring va pomidorlar bilan lavashga oʼralgan yumshoq mol goʼshtli va pishloqli, bizning taʼmi oʼtkir qayla bilan\n" +
                " Narxi: 25 000 so'm");
        sendPhoto.setReplyMarkup(buyurtmaBerishLavashButton());
        return sendPhoto;
    }
    public SendPhoto molGushPishloqShaurmaPhoto(String chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQcMMtFwK31cCSgq4wRxnQs4kq3zAYJSeZL4GN0gNYVko8RNY3SMuRJh29ezbxKDqupRj8&usqp=CAU"));
        sendPhoto.setCaption("Qarsildoq chipslar, yangi bodring va pomidorlar bilan non ichiga solingan yumshoq mol goʼshtli va pishloqli shaurma, bizning taʼmi oʼtkir qayla bilan\n" +
                " Narxi: 25 000 so'm");
        sendPhoto.setReplyMarkup(buyurtmaBerishShaurmaButton());
        return sendPhoto;
    }

    public SendPhoto tovuqGushLavashPhoto(String chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2NYHPecal07v6vBfggzZPNsbuiQxkCPwq7hrEXl_MKC-MJtRyLChqYJ16RXQbs1Cj70I&usqp=CAU"));
        sendPhoto.setCaption("Yangi bodring va pomidorlar, qarsildoq chipslar bilan lavashga oʼralgan qovurilgan tovuq filesi, bizning taʼmi oʼtkir maxsus qayla bilan\n" +
                " Narxi: 24 000 so'm");
        sendPhoto.setReplyMarkup(buyurtmaBerishLavashButton());
        return sendPhoto;
    }
    public SendPhoto tovuqGushShaurmaPhoto(String chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://pasta.uz/upload/products/%D0%91%D0%B8%D0%B3%20%D0%A8%D0%B0%D1%83%D1%80%D0%BC%D0%B0%20(%D0%A2%D0%BE%D0%B2%D1%83%D2%9B%20%D2%9B%D0%B0%D0%BB%D0%B0%D0%BC%D0%BF%D0%B8%D1%80%D0%BB%D0%B8).jpg"));
        sendPhoto.setCaption("Yangi bodring va pomidorlar, qarsildoq chipslar bilan non ichiga solingan shaurma qovurilgan tovuq filesi, bizning taʼmi oʼtkir maxsus qayla bilan\\n\" +\n" +
                "                \" Narxi: 27 000 so'm");
        sendPhoto.setReplyMarkup(buyurtmaBerishShaurmaButton());
        return sendPhoto;
    }
    public SendPhoto tovuqGushPishloqliLavashPhoto(String chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQigkVyG_t52q0MlIQAHdL6KmegB3vjRGtJZ1XzcpgXDTIjJX_WFMMAHKfar1KGbpAPEiw&usqp=CAU"));
        sendPhoto.setCaption("Yangi bodring va pomidorlar, qarsildoq chipslar bilan lavashga oʼralgan qovurilgan tovuq filesi, bizning taʼmi oʼtkir maxsus qayla bilan\n" +
                " Narxi: 22 000 so'm");
        sendPhoto.setReplyMarkup(buyurtmaBerishLavashButton());
        return sendPhoto;
    }
    public SendPhoto tovuqGushPishloqliShaurmaPhoto(String chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTx_mIYa8H27kN3J8I-4tEgik-gZeNheOjvCzf0PH6OtYEvAtDDIYeYybHrFV4StewXcks&usqp=CAU"));
        sendPhoto.setCaption("Yangi bodring va pomidorlar, qarsildoq chipslar bilan non ichiga solingan qovurilgan tovuq fileli shaurma, bizning taʼmi oʼtkir maxsus qayla bilan\n" +
                " Narxi: 22 000 so'm");
        sendPhoto.setReplyMarkup(buyurtmaBerishShaurmaButton());
        return sendPhoto;
    }
    public SendPhoto tovuqGushQalampirLavashPhoto(String chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSBHIVfSzOB3jnfQL5y2krQoHinP7n7Y-uXugoGM4XBntVbQ8TGAMHq3Q_UW8P300IZX-4&usqp=CAU"));
        sendPhoto.setCaption("Yangi bodring va pomidorlar, qarsildoq chipslar bilan lavashga oʼralgan qovurilgan tovuq filesi, bizning taʼmi oʼtkir maxsus qayla bilan\n" +
                " Narxi: 24 000 so'm");
        sendPhoto.setReplyMarkup(buyurtmaBerishLavashButton());
        return sendPhoto;
    }
    public SendPhoto tovuqGushQalampirShaurmaPhoto(String chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRd3eFl_a7P60wuIuB2GZRb7YPNObS0zzu5Sk1GlHu8vhnTO799yyPPHOeVV9eZRjN-8Zs&usqp=CAU"));
        sendPhoto.setCaption("Yangi bodring va pomidorlar, qarsildoq chipslar bilan non ichiga solingan qovurilgan tovuq fileli shaurma, bizning taʼmi oʼtkir maxsus qayla bilan\n" +
                " Narxi: 24 000 so'm");
        sendPhoto.setReplyMarkup(buyurtmaBerishShaurmaButton());
        return sendPhoto;
    }
    public SendPhoto molGushQalampirLavashPhoto(String chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjx5H_-ET3XHP9dQ_ZpHLAtfsx6v5uUU7EVT_nRhhKAB4zA7EhHvwRo26TpjUWjrf54Vg&usqp=CAU"));
        sendPhoto.setCaption("Qarsildoq chipslar, yangi bodring va pomidorlar bilan lavashga oʼralgan yumshoq mol goʼshti, bizning taʼmi oʼtkir qayla bilan\n" +
                " Narxi: 26 000 so'm");
        sendPhoto.setReplyMarkup(buyurtmaBerishLavashButton());
        return sendPhoto;
    }
    public SendPhoto molGushQalampirShaurmaPhoto(String chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTUmWgFkvtgCwAb5rFmPtSrO6FgEXyfa1GyIBB3IKN0sZSJM5ifDciFw8fMovlZ3hAsIv4&usqp=CAU"));
        sendPhoto.setCaption("Qarsildoq chipslar, yangi bodring va pomidorlar bilan non ichiga solingan yumshoq mol goʼshtli shaurma, bizning taʼmi oʼtkir qayla bilan\n" +
                " Narxi: 26 000 so'm");
        sendPhoto.setReplyMarkup(buyurtmaBerishShaurmaButton());
        return sendPhoto;
    }


    public SendPhoto shaurmaPhoto(String chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcStHLrzGM_z7gzKrkqru8DtfpUzXi99T56iCg&usqp=CAU"));
        sendPhoto.setReplyMarkup(shaurmaButton());
        return sendPhoto;
    }

    public SendPhoto burgerPhoto(String chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSH-pEHXsTE0SaCwMeHcds2_zzEqMLIHLftDQ&usqp=CAU"));
        sendPhoto.setReplyMarkup(burgerButton());
        return sendPhoto;
    }

    public SendPhoto gamburgerBurgerPhoto(String chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQFIkI7Qbts-wiF_OphUZ71xFk7xwLvS64-8g&usqp=CAU"));
        sendPhoto.setCaption("Yumshoq kulcha, yumshoq mol goʼshtidan kotlet, tuzlangan bodringlar, yangi pomidorlar, qizil piyoz va ikkita maxsus qayla bilan qarsildoq muztogʼ salati\n" +
                " Narxi: 21 000 so'm");
        sendPhoto.setReplyMarkup(buyurtmaBerishBurgerButton());
        return sendPhoto;
    }
    public SendPhoto doubleBurgerBurgerPhoto(String chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ-dfyVklhB_MrbiJR4OcgMnVW7rZxHOwSP0w&usqp=CAU"));
        sendPhoto.setCaption("Yumshoq kulcha, yumshoq mol goʼshtidan kotlet, tuzlangan bodringlar, yangi pomidorlar, qizil piyoz va ikkita maxsus qayla bilan qarsildoq muztogʼ salati\n" +
                " Narxi: 23 000 so'm");
        sendPhoto.setReplyMarkup(buyurtmaBerishBurgerButton());
        return sendPhoto;
    }
    public SendPhoto cheeseBurgerBurgerPhoto(String chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRqG4A6j7S7S2P6vg4kvqx8KMV5ZjGueg08gg&usqp=CAU"));
        sendPhoto.setCaption("Yumshoq kulcha, bir boʼlak eritilgan Cheddar pishlogʼi bilan mol goʼshtidan yumshoq kotlet, tuzlangan bodring, yangi pomidorlar, qizil piyoz va ikkita maxsus qayla bilan qarsildoq muztogʼ salati\n" +
                " Narxi: 22 000 so'm");
        sendPhoto.setReplyMarkup(buyurtmaBerishBurgerButton());
        return sendPhoto;
    }
    public SendPhoto doubleCheeseBurgerPhoto(String chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRVglQJNTWbTxuF2GF14eECogP6OIGaDAQFEQ&usqp=CAU"));
        sendPhoto.setCaption("Yumshoq kulcha, yumshoq mol goʼshtidan kotlet, tuzlangan bodringlar, yangi pomidorlar, qizil piyoz va ikkita maxsus qayla bilan qarsildoq muztogʼ salati\n" +
                " Narxi: 21 000 so'm");
        sendPhoto.setReplyMarkup(buyurtmaBerishBurgerButton());
        return sendPhoto;
    }
    public SendPhoto hotDogPhoto(String chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ02tnnZrDYTtsNIvsW6zeeF7GAVTgVVIR8KA&usqp=CAU"));
        sendPhoto.setReplyMarkup(hotDogButton());
        return sendPhoto;
    }
    public SendPhoto hotDogBaugetteHotDogPhoto(String chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRmfaAdxIFrepKmIothP0VXz2nZQYed_GejDf7Z_K2unXaUVI39Gjr9LhL6borEghlbzwI&usqp=CAU"));
        sendPhoto.setCaption("Kunjutli kulcha, sosiska, tuzlangan bodring, pomidorlar, yangi muztogʼ salati va maxsus qayla\n" +
                " Narxi: 13 000 so'm");
        sendPhoto.setReplyMarkup(buyurtmaBerishHotdogButton());
        return sendPhoto;
    }
    public SendPhoto hotDogBaugetteDoubleHotDogPhoto(String chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRmfaAdxIFrepKmIothP0VXz2nZQYed_GejDf7Z_K2unXaUVI39Gjr9LhL6borEghlbzwI&usqp=CAU"));
        sendPhoto.setCaption("Kunjutli kulcha, ikkita sosiska, tuzlangan bodringlar, pomidorlar, yangi muztogʼ salati va maxsus qayla\n" +
                " Narxi: 20 000 so'm");
        sendPhoto.setReplyMarkup(buyurtmaBerishHotdogButton());
        return sendPhoto;
    }
    public SendPhoto subTovuqHotDogPhoto(String chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://media1.sacurrent.com/sacurrent/imager/u/original/21304064/summer_group-14.jpg"));
        sendPhoto.setCaption("Kunjutli kulcha, tovuq gushti, tuzlangan bodringlar, pomidorlar, yangi muztogʼ salati va maxsus qayla\n" +
                " Narxi: 16 000 so'm");
        sendPhoto.setReplyMarkup(buyurtmaBerishHotdogButton());
        return sendPhoto;
    }
    public SendPhoto subTovuqCheeseHotDogPhoto(String chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSjfoXE56duRpQrOEsJIyRr2GtL1n1oUIVV77QqoMxDZRbWwMxtmPr-PzTYT38tipbvzI0&usqp=CAU"));
        sendPhoto.setCaption("Kunjutli kulcha, tovuq gushti, tuzlangan bodringlar, pomidorlar, yangi muztogʼ salati va maxsus qayla\n" +
                " Narxi: 18 000 so'm");
        sendPhoto.setReplyMarkup(buyurtmaBerishHotdogButton());
        return sendPhoto;
    }
    public SendPhoto subGushHotDogPhoto(String chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTFVvWvc986w2YZRnJ6SubLDmJY5Tw7zIhEwHTugFkJWv9MciZszwmtSWWT2FUlA3f-Aqs&usqp=CAU"));
        sendPhoto.setCaption("Kunjutli kulcha, qoramol gushti, tuzlangan bodringlar, pomidorlar, yangi muztogʼ salati va maxsus qayla\n" +
                " Narxi: 18 000 so'm");
        sendPhoto.setReplyMarkup(buyurtmaBerishHotdogButton());
        return sendPhoto;
    }
    public SendPhoto subGushCheeseHotDogPhoto(String chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS4vb289XgTlRr5TQU0yzUS-2Bju3kvMw2ArXTH1QWC_j4QRmSSLNtlw_3sDBH-QRYLLYE&usqp=CAU"));
        sendPhoto.setCaption("Kunjutli kulcha, qoramol gushti, tuzlangan bodringlar, pomidorlar, yangi muztogʼ salati va maxsus qayla\n" +
                " Narxi: 20 000 so'm");
        sendPhoto.setReplyMarkup(buyurtmaBerishHotdogButton());
        return sendPhoto;
    }
    public SendPhoto hotDogClassicHotDogPhoto(String chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQNavh4zN6gP6QP_t9y7dt_0jvBchN9jqL4oxKWeuwnUerTSHR5AFTPr1rVnt1SZUYh7T4&usqp=CAU"));
        sendPhoto.setCaption("Kulcha, sosiska, ketchup va xantal, qovurilgan piyoz\n" +
                " Narxi: 8 000 so'm");
        sendPhoto.setReplyMarkup(buyurtmaBerishHotdogButton());
        return sendPhoto;
    }
    public SendPhoto hotDogKidsHotDogPhoto(String chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTsA8QudMXlX_OvQzm57JK7T-HUjJcHy2Uao4j_XXG-lB8S_0Eo0sRgOqy8zJIARmR_lSk&usqp=CAU"));
        sendPhoto.setCaption("Kulcha, sosiska, ketchup va xantal, qovurilgan piyoz\n" +
                " Narxi: 8 000 so'm");
        sendPhoto.setReplyMarkup(buyurtmaBerishHotdogButton());
        return sendPhoto;
    }
    public SendPhoto ichimlikPhoto(String chatId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRAFmyKxzG-oK1wYSek9nBHU-vQYeXp05N3pg&usqp=CAU"));
        sendPhoto.setReplyMarkup(ichimlikButton());
        return sendPhoto;
    }

    public SendPhoto suvYarimIchimlikPhoto(String chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ61WJkA_gXwtjvx4Q6ETIV7Irayh0J0so9Aw&usqp=CAU"));
        sendPhoto.setCaption("Ichimlik suvi\n" +
                " Narxi: 3 000 so'm");
        sendPhoto.setReplyMarkup(buyurtmaBerishIchimlikButton());
        return sendPhoto;
    }
    public SendPhoto sokDenaIchimlikPhoto(String chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRv1jREtgbJkVXnP7-8qEicm8n7TgccLQr3Iw&usqp=CAU"));
        sendPhoto.setCaption("Dena soki\n" +
                " Narxi: 12 000 so'm");
        sendPhoto.setReplyMarkup(buyurtmaBerishIchimlikButton());
        return sendPhoto;
    }
    public SendPhoto pepsiYarimIchimlikPhoto(String chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQpo-I1l4vYvbmfFFNuVrUp4xVfhVbZFatXNA&usqp=CAU"));
        sendPhoto.setCaption("Pepsi 0,5\n" +
                " Narxi: 7 000 so'm");
        sendPhoto.setReplyMarkup(buyurtmaBerishIchimlikButton());
        return sendPhoto;
    }
    public SendPhoto pepsiBirYarimIchimlikPhoto(String chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS_AevfT6XDEzN-_TO0BTDXvdwAJQQhjEkMmA&usqp=CAU"));
        sendPhoto.setCaption("Pepsi 1,5\n" +
                " Narxi: 14 000 so'm");
        sendPhoto.setReplyMarkup(buyurtmaBerishIchimlikButton());
        return sendPhoto;
    }
    public SendPhoto kukChoyIchimlikPhoto(String chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRfxa5bnGZkyZ0Q-w5c9pp0KS4IOQBge-IDHA&usqp=CAU"));
        sendPhoto.setCaption("Ko'k choy\n" +
                " Narxi: 5 000 so'm");
        sendPhoto.setReplyMarkup(buyurtmaBerishIchimlikButton());
        return sendPhoto;
    }
    public SendPhoto qoraChoyIchimlikPhoto(String chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT-5paN4NpDu8a0z9bZ7AhmhzT79jUsLtvfKQ&usqp=CAU"));
        sendPhoto.setCaption("Qora choy\n" +
                " Narxi: 5 000 so'm");
        sendPhoto.setReplyMarkup(buyurtmaBerishIchimlikButton());
        return sendPhoto;
    }
    public SendPhoto limonKukChoyIchimlikPhoto(String chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTwDWkVdJQD18qI7lpSrhVnTQwWU8FSBbAJ8g&usqp=CAU"));
        sendPhoto.setCaption("Limon ko'k choy\n" +
                " Narxi: 7 000 so'm");
        sendPhoto.setReplyMarkup(buyurtmaBerishIchimlikButton());
        return sendPhoto;
    }
    public SendPhoto limonQoraChoyIchimlikPhoto(String chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRulZ61e75PJ1uxOeeQuUFLUaPPS329s9dVVw&usqp=CAU"));
        sendPhoto.setCaption("Limon qora choy\n" +
                " Narxi: 7 000 so'm");
        sendPhoto.setReplyMarkup(buyurtmaBerishIchimlikButton());
        return sendPhoto;
    }
    public SendPhoto blissSharbatiIchimlikPhoto(String chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQkzYtaVTbpwQda3nViKJBESCVdSjwr58YfWQ&usqp=CAU"));
        sendPhoto.setCaption("Bliss sharbati\n" +
                " Narxi: 17 000 so'm");
        sendPhoto.setReplyMarkup(buyurtmaBerishIchimlikButton());
        return sendPhoto;
    }

    private ReplyKeyboardRemove removeReplyKeyboard() {
        ReplyKeyboardRemove remove = new ReplyKeyboardRemove();
        remove.setRemoveKeyboard(true);
        return remove;
    }
    public ReplyKeyboardMarkup requestContactButton() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);

        KeyboardRow row = new KeyboardRow();
        KeyboardButton button = new KeyboardButton("📞  Share phone number");
        button.setRequestContact(true);
        row.add(button);

        replyKeyboardMarkup.setKeyboard(List.of(row));
        return replyKeyboardMarkup;
    }
    public ReplyKeyboardMarkup requestLocationButton() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);

        KeyboardRow row = new KeyboardRow();
        KeyboardButton button = new KeyboardButton("\uD83D\uDCCD  Share Location");
        button.setRequestLocation(true);
        row.add(button);

        replyKeyboardMarkup.setKeyboard(List.of(row));
        return replyKeyboardMarkup;
    }
    public ReplyKeyboardMarkup mainMenuButton() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);

        List<KeyboardRow> rows = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        KeyboardButton button = new KeyboardButton("\uD83C\uDF7D  Menyu");
        row.add(button);

        button = new KeyboardButton("📞  Contacts");
        row.add(button);

        rows.add(row);

        replyKeyboardMarkup.setKeyboard(rows);
        return replyKeyboardMarkup;
    }
    public InlineKeyboardMarkup contactButton() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();

        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("✉️  Telegram");
        button.setUrl("https://t.me/Abduvohidov_I");
        button.setCallbackData("ffffff");
        row.add(button);

        button = new InlineKeyboardButton();
        button.setText("✉️  Telegram channel");
        button.setUrl("https://t.me/evosuzbekistan");
        button.setCallbackData("ffffff");
        row.add(button);

        rows.add(row);
        row = new ArrayList<>();

        button = new InlineKeyboardButton();
        button.setText("\uD83D\uDCD5  Instagram");
        button.setCallbackData("ffffff");
        button.setUrl("https://instagram.com/evosuzbekistan?igshid=YmMyMTA2M2Y=");
        row.add(button);

        rows.add(row);

        inlineKeyboardMarkup.setKeyboard(rows);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup AdminBuyurtmaButton() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();

        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("📞  Buyurtmani qabul qiluvchi");
        button.setUrl("https://t.me/Abduvohidov_I");
        button.setCallbackData("ffffff");
        row.add(button);

        rows.add(row);

        inlineKeyboardMarkup.setKeyboard(rows);
        return inlineKeyboardMarkup;
    }
    public ReplyKeyboardMarkup menuButton() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);

        List<KeyboardRow> rows = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        row.add("\uD83E\uDED4  Lavash");
        row.add("\uD83E\uDD59  Shaurma");

        rows.add(row);

        row = new KeyboardRow();
        row.add("\uD83C\uDF54  Burger");
        row.add("\uD83C\uDF2D  Hot_Dog");

        rows.add(row);

        row = new KeyboardRow();
        row.add("\uD83C\uDF7E  Ichimlik ");
        row.add("⬅️  Ortga");

        rows.add(row);

        replyKeyboardMarkup.setKeyboard(rows);
        return replyKeyboardMarkup;
    }
    public ReplyKeyboardMarkup lavashButton() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);

        List<KeyboardRow> rows = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        row.add("\uD83E\uDED4  Mol go'shtidan lavash");
        row.add("\uD83E\uDED4  Tovuq go'shtli lavash");

        rows.add(row);

        row = new KeyboardRow();
        row.add("\uD83E\uDED4  Mol go'shtidan pishloqli lavash");
        row.add("\uD83E\uDED4  Tovuq go'shtidan pishloqli lavash");

        rows.add(row);

        row = new KeyboardRow();
        row.add("\uD83E\uDED4  Mol go'shtidan qalampir lavash");
        row.add("\uD83E\uDED4  Tovuq go'shtidan qalampir lavash");

        rows.add(row);

        row = new KeyboardRow();
        KeyboardButton button = new KeyboardButton("⬅️  Ortga");
        row.add(button);

        rows.add(row);

        replyKeyboardMarkup.setKeyboard(rows);
        return replyKeyboardMarkup;
    }
    public ReplyKeyboardMarkup shaurmaButton() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);

        List<KeyboardRow> rows = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        row.add("\uD83E\uDD59  Mol go'shtidan shaurma");
        row.add("\uD83E\uDD59  Tovuq go'shtli shaurma");

        rows.add(row);

        row = new KeyboardRow();
        row.add("\uD83E\uDD59  Mol go'shtidan pishloqli shaurma");
        row.add("\uD83E\uDD59  Tovuq go'shtidan pishloqli shaurma");

        rows.add(row);

        row = new KeyboardRow();
        row.add("\uD83E\uDD59  Mol go'shtidan qalampir shaurma");
        row.add("\uD83E\uDD59  Tovuq go'shtidan qalampir shaurma");

        rows.add(row);

        row = new KeyboardRow();
        KeyboardButton button = new KeyboardButton("⬅️  Ortga");
        row.add(button);

        rows.add(row);

        replyKeyboardMarkup.setKeyboard(rows);
        return replyKeyboardMarkup;
    }
    public ReplyKeyboardMarkup burgerButton() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);

        List<KeyboardRow> rows = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        row.add("\uD83C\uDF54  Gamburger");
        row.add("\uD83C\uDF54  Double burger");

        rows.add(row);

        row = new KeyboardRow();
        row.add("\uD83C\uDF54  Cheese burger");
        row.add("\uD83C\uDF54  Double cheese");

        rows.add(row);

        row = new KeyboardRow();
        KeyboardButton button = new KeyboardButton("⬅️  Ortga");
        row.add(button);

        rows.add(row);

        replyKeyboardMarkup.setKeyboard(rows);
        return replyKeyboardMarkup;
    }
    public ReplyKeyboardMarkup hotDogButton() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);

        List<KeyboardRow> rows = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        row.add("\uD83C\uDF2D  Hot-dog baguette");
        row.add("\uD83C\uDF2D  Hot-dog baguette double");

        rows.add(row);

        row = new KeyboardRow();
        row.add("\uD83C\uDF2D  Sub tovuq");
        row.add("\uD83C\uDF2D  Sub tovuq cheese");

        rows.add(row);

        row = new KeyboardRow();
        row.add("\uD83C\uDF2D  Sub go'sht");
        row.add("\uD83C\uDF2D  Sub go'sht cheese");

        rows.add(row);

        row = new KeyboardRow();
        row.add("\uD83C\uDF2D  Hot-dog classic");
        row.add("\uD83C\uDF2D  Hot-dog kids");

        rows.add(row);

        row = new KeyboardRow();
        KeyboardButton button = new KeyboardButton("⬅️  Ortga");
        row.add(button);

        rows.add(row);

        replyKeyboardMarkup.setKeyboard(rows);
        return replyKeyboardMarkup;
    }
    public ReplyKeyboardMarkup ichimlikButton() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);

        List<KeyboardRow> rows = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        row.add("\uD83C\uDF78  Suv 0,5");
        row.add("\uD83E\uDDC3  Sok dena");

        rows.add(row);

        row = new KeyboardRow();
        row.add("🥤  Pepsi 0,5");
        row.add("🥤  Pepsi 1,5");

        rows.add(row);

        row = new KeyboardRow();
        row.add("☕️  Ko'k choy");
        row.add("☕️  Qora choy");

        rows.add(row);

        row = new KeyboardRow();
        row.add("☕️  Limonli ko'k choy");
        row.add("☕️  Limonli qora choy");

        rows.add(row);

        row = new KeyboardRow();
        row.add("\uD83C\uDF77  Bliss sharbati");
        row.add("⬅️  Ortga");

        rows.add(row);

        replyKeyboardMarkup.setKeyboard(rows);
        return replyKeyboardMarkup;
    }
    public ReplyKeyboardMarkup buyurtmaBerishLavashButton() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);

        List<KeyboardRow> rows = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        row.add("\uD83D\uDE96  Buyurtma berish");

        rows.add(row);

        row = new KeyboardRow();
        KeyboardButton button = new KeyboardButton("⬅️  Ortga");
        row.add(button);

        rows.add(row);

        replyKeyboardMarkup.setKeyboard(rows);
        return replyKeyboardMarkup;
    }
    public ReplyKeyboardMarkup buyurtmaBerishShaurmaButton() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);

        List<KeyboardRow> rows = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        row.add("\uD83D\uDE96  Buyurtma berish");

        rows.add(row);

        row = new KeyboardRow();
        KeyboardButton button = new KeyboardButton("◀️  Ortga");
        row.add(button);

        rows.add(row);

        replyKeyboardMarkup.setKeyboard(rows);
        return replyKeyboardMarkup;
    }
    public ReplyKeyboardMarkup buyurtmaBerishBurgerButton() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);

        List<KeyboardRow> rows = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        row.add("\uD83D\uDE96  Buyurtma berish");

        rows.add(row);

        row = new KeyboardRow();
        KeyboardButton button = new KeyboardButton("↖️  Ortga");
        row.add(button);

        rows.add(row);

        replyKeyboardMarkup.setKeyboard(rows);
        return replyKeyboardMarkup;
    }
    public ReplyKeyboardMarkup buyurtmaBerishHotdogButton() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);

        List<KeyboardRow> rows = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        row.add("\uD83D\uDE96  Buyurtma berish");

        rows.add(row);

        row = new KeyboardRow();
        KeyboardButton button = new KeyboardButton("⏪  Ortga");
        row.add(button);

        rows.add(row);

        replyKeyboardMarkup.setKeyboard(rows);
        return replyKeyboardMarkup;
    }
    public ReplyKeyboardMarkup buyurtmaBerishIchimlikButton() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);

        List<KeyboardRow> rows = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        row.add("\uD83D\uDE96  Buyurtma berish");

        rows.add(row);

        row = new KeyboardRow();
        KeyboardButton button = new KeyboardButton("\uD83D\uDD19  Ortga");
        row.add(button);

        rows.add(row);

        replyKeyboardMarkup.setKeyboard(rows);
        return replyKeyboardMarkup;
    }
}
