package ru.job4j.io.chat;

import java.io.*;

/**
 * Бот для консольного чата.
 * Он умеет пополнять свой словарный запас, формировать ответ случайным образом и вести запись диалога.
 */
class Bot {

    /** Файл, из которого бот берет ответы */
    private final File source = createSourceFile();

    /** Файл, в который происходит запись диалога */
    private final File log = createLogFile();

    private File createSourceFile() {
        String dir = System.getProperty("user.dir");
        return new File(dir + "/chapter_003/resources/answers.txt");
    }

    private File createLogFile() {
        String dir = System.getProperty("user.dir");
        return new File(dir + "/chapter_003/resources/log.txt");
    }

    private StringBuilder readSource() {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append(",");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder;
    }

    /**
     * Формирование ответа бота путем выбора случайной фразы из файла.
     *
     * @return ответ.
     */
    String reply() {
        String[] array = readSource().toString().split(",");
        int number = (int) (Math.random() * array.length);
        String message = array[number];
        writeToLog("bot: " + message);
        return message;
    }

    void writeToLog(String text) {
        try (FileWriter writer = new FileWriter(log, true)) {
            writer.write(text);
            writer.write(System.lineSeparator());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Пополнение словарного запаса бота.
     *
     * @param text ответ пользователя.
     */
    void writeToSource(String text) {
        try (FileWriter writer = new FileWriter(source, true)) {
            writer.write(text);
            writer.write(System.lineSeparator());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
