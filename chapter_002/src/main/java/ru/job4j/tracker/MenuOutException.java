package ru.job4j.tracker;

/**
 * Класс принимает сообщение об ошибке и передает его в конструктор родителя.
 */
public class MenuOutException extends RuntimeException {
    public MenuOutException(String msg) {
        super(msg);
    }
}
