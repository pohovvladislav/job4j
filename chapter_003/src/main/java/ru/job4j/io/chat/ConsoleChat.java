package ru.job4j.io.chat;

import java.util.Objects;
import java.util.Scanner;

/**
 * Консольный чат.
 *
 * @author В-87
 */
public class ConsoleChat {

    /** Приветствие */
    private static final String GREETING = "Привет!";

    /** Команда остановки бота */
    private static final String STOP = "стоп";

    /** Команда запуска бота */
    private static final String RESUME = "продолжить";

    /** Команда завершения работы чата */
    private static final String CONCLUDE = "закончить";

    /** Бот */
    private final Bot bot;

    /** Начало общения? */
    private boolean startCommunication;

    /** Вызвана ли команда @STOP */
    private boolean stop;

    /** Вызвана ли команда @CONCLUDE */
    private boolean end;


    private ConsoleChat() {
        bot = new Bot();
        startCommunication = true;
        stop = false;
        end = false;
    }

    private String getAnswers() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private void manage(String message) {
        write(message);
        if (Objects.equals(CONCLUDE, message)) {
            end = true;
        } else {
            if (!stop) {
                botReplied(message);
            }
            if (Objects.equals(RESUME, message)) {
                stop = false;
                startCommunication = true;
            }
        }
    }

    private void write(String message) {
        bot.writeToLog("user: " + message);
        bot.writeToSource(message);
    }

    private void botReplied(String message) {
        if (Objects.equals(STOP, message)) {
            stop = true;
        } else {
            String text = bot.reply();
            System.out.println(text);

        }
    }

    private void printGreeting() {
        System.out.println(GREETING);
        bot.writeToLog("bot: " + GREETING);
    }

    /**
     * Запуск чата.
     */
    private void start() {
        while (!end) {
            if (startCommunication) {
                printGreeting();
                startCommunication = false;
            } else {
                String answers = getAnswers();
                manage(answers);
            }
        }
    }

    public static void main(String[] args) {
        ConsoleChat chat = new ConsoleChat();
        chat.start();
    }
}
