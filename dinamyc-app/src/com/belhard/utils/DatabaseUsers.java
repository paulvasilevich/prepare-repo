package com.belhard.utils;

import java.util.*;

public class DatabaseUsers {

    public static Map<String, User> usersMap = new LinkedHashMap<>();
    public static Map<String, Message> messagesSport = new LinkedHashMap<>();
    public static Map<String, Message> messagesAutoMoto = new LinkedHashMap<>();
    public static Map<String, Message> messagesFinance = new LinkedHashMap<>();

    static {
        messagesSport.put("user1", new Message("user1 say something about sport"));
        messagesSport.put("user2", new Message("user2 say something about sport"));
        messagesSport.put("user3", new Message("user3 say something about sport"));
        messagesAutoMoto.put("user1", new Message("user1 say something about automoto"));
        messagesAutoMoto.put("user2", new Message("user2 say something about automoto"));
        messagesAutoMoto.put("user3", new Message("user3 say something about automoto"));
        messagesFinance.put("user1", new Message("user1 say something about finance"));
        messagesFinance.put("user2", new Message("user2 say something about finance"));
        messagesFinance.put("user3", new Message("user3 say something about finance"));
        usersMap.put("user1", new User("001", "Andy", "12345"));
        usersMap.put("user2", new User("002", "Randy", "67890"));
        usersMap.put("user3", new User("003", "Gandy", "24680"));
    }

    public DatabaseUsers() {
    }

    public static Map<String, User> getUsersMap() {
        return usersMap;
    }

    public static Map<String, Message> getMessagesSport() {
        return messagesSport;
    }

    public static void setMessagesSport(Map<String, Message> messagesSport) {
        DatabaseUsers.messagesSport = messagesSport;
    }

    public static Map<String, Message> getMessagesCar() {
        return messagesAutoMoto;
    }

    public static void setMessagesCar(Map<String, Message> messagesAutoMoto) {
        DatabaseUsers.messagesAutoMoto = messagesAutoMoto;
    }

    public static Map<String, Message> getMessagesFinance() {
        return messagesFinance;
    }

    public static void setMessagesFinance(Map<String, Message> messagesFinance) {
        DatabaseUsers.messagesFinance = messagesFinance;
    }

    public static void setUsersMap(Map<String, User> usersMap) {
        DatabaseUsers.usersMap = usersMap;
    }
}
