package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 *@version $Id$
 *@since 0.1
 */
public class StartUI {
    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FINDID = "4";
    private static final String FINDNAME = "5";
    private static final String EXIT = "6";
    private final Input input;
    private final Tracker tracker;
    private boolean working = true;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        List<Integer> range = new ArrayList<>();
        menu.fillActions(this);
        for (int i = 0; i < menu.getActionsLength(); i++) {
            range.add(i);
        }
        do {
            menu.show();
            menu.select(input.ask("выберите :", range));

        } while (this.working);
    }

    public void stop() {
        this.working = false;
    }

    private void createItem() {
        System.out.println("---------- Добавление новой заявки ----------");
        String name = this.input.ask("Введите имя заявки : ");
        String desc = this.input.ask("Введите описание заявки : ");
        Long create = System.currentTimeMillis();
        Item item = new Item(name, desc, create);
        this.tracker.add(item);
        System.out.println("---------- Новая заявка с ID " + item.getId() + "------------");
    }

    private void listItem() {
        System.out.println("---------- Список заявок : ---------- ");
        System.out.printf("%-15s%-20s%s%n", "Имя", "Описание", "Дата создания");
        System.out.println("------------------------------------------------------");
        Item[] listFindAll = this.tracker.findAll();
        if (listFindAll.length != 0) {
            for (Item item : listFindAll) {
                System.out.printf("%-15.10s%-20.15s%s%n", item.getName(), item.getDescription(), item.getCreated());
            }
        } else {
            System.out.println("---------- Заявки не созданы. ----------");
        }
        System.out.println("------------------------------------------------------");
    }

    private void correctionItem() {
        System.out.println("---------- Изменение заявки ----------");
        String id = this.input.ask(" Введите ID заявки : ");
        Item searchItem = this.tracker.findById(id);
        if (searchItem != null) {
            String name = this.input.ask("Введите новое имя заявки : ");
            String desc = this.input.ask("Введите описание заявки : ");
            Long create = System.currentTimeMillis();
            Item item = new Item(name, desc, create);
            this.tracker.replace(id, item);
            System.out.println("Заявка успешно изменена.");
        } else {
            System.out.println("Заявка не найдена.");
        }
    }

    private void removalItem() {
        System.out.println("---------- Удаление заявки ----------");
        String id = this.input.ask("Введите ID заявки : ");
        if (tracker.delete(id)) {
            this.tracker.delete(id);
            System.out.println("Заявка успешно удалена.");
        } else {
            System.out.println("Заявка не найдена.");
        }
    }

    private void searchByIdItem() {
        String id = this.input.ask("Введите ID заявки : ");
        Item item = this.tracker.findById(id);
        if (item != null) {
            System.out.println("Заявка с данным ID : ");
            System.out.printf("%-15s%-20s%s%n", "Имя", "Описание", "Дата создания");
            System.out.println("------------------------------------------------------");
            System.out.printf("%-15.10s%-20.15s%s%n", item.getName(), item.getDescription(), item.getCreated());
            System.out.println("------------------------------------------------------");
        } else {
            System.out.println("Заявка не найдена.");
        }
    }

    private void searchByNameItem() {
        String name = this.input.ask("Введите имя заявки : ");
        System.out.println("---------- Список заявок : ---------- ");
        System.out.printf("%-15s%-20s%s%n", "Имя", "Описание", "Дата создания");
        System.out.println("------------------------------------------------------");
        Item[] listFindByName = this.tracker.findByName(name);
        if (listFindByName.length != 0) {
            for (Item item : listFindByName) {
                System.out.printf("%-15.10s%-20.15s%s%n", item.getName(), item.getDescription(), item.getCreated());
            }
        } else {
            System.out.println("---------- Заявок не найдено. ----------");
        }
        System.out.println("------------------------------------------------------");
    }

    private void showmenu() {
        System.out.println("Меню.");
        System.out.println("0. Создание новой заявки.");
        System.out.println("1. Список созданных заявок.");
        System.out.println("2. Изменить заявку.");
        System.out.println("3. Удаление заявки.");
        System.out.println("4. Найти заявку по ID.");
        System.out.println("5. Найти заявку по имени.");
        System.out.println("6. Выход.");
    }

    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}
