package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * @author В-87
 * @version $Id$
 * @since 0.1
 */

class DeleteItem extends BaseAction {

    public DeleteItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("---------- Удаление заявки ----------");
        String id = input.ask("Введите ID заявки : ");
        if (tracker.delete(id)) {
            System.out.println("Заявка успешно удалена.");
        } else {
            System.out.println("Заявка не найдена.");
        }
    }
}

public class MenuTracker {
    private Tracker tracker;
    private Input input;
    private List<UserAction> actions = new ArrayList<>();


    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public int getActionsLength() {
        return this.actions.size();
    }

    public void fillActions(StartUI ui) {
        this.actions.add(new AddItem(0, "Создание новой заявки."));
        this.actions.add(new ShowItems(1, "Список созданных заявок."));
        this.actions.add(new MenuTracker.EditItem(2, "Изменить заявку."));
        this.actions.add(new DeleteItem(3, "Удаление заявки."));
        this.actions.add(new FindItemById(4, "Найти заявку по ID."));
        this.actions.add(new FindItemsByName(5, "Найти заявку по имени."));
        this.actions.add(new ExitProgram(6, "Выход.", ui));
    }

    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("---------- Добавление новой заявки ----------");
            String name = input.ask("Введите имя заявки : ");
            String desc = input.ask("Введите описание заявки : ");
            Long create = System.currentTimeMillis();
            Item item = new Item(name, desc, create);
            tracker.add(item);
            System.out.println("---------- Новая заявка с ID " + item.getId() + "------------");
        }
    }

    private class ShowItems extends BaseAction {

        public ShowItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("---------- Список заявок : ---------- ");
            System.out.printf("%-15s%-20s%s%n", "Имя", "Описание", "Дата создания");
            System.out.println("------------------------------------------------------");
            Item[] listFindAll = tracker.findAll();
            if (listFindAll.length != 0) {
                for (Item item : listFindAll) {
                    System.out.printf("%-15.10s%-20.15s%s%n", item.getName(), item.getDescription(), item.getCreated());
                }
            } else {
                System.out.println("---------- Заявки не созданы. ----------");
            }
            System.out.println("------------------------------------------------------");
        }
    }

    private static class EditItem extends BaseAction {

        public EditItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("---------- Изменение заявки ----------");
            String id = input.ask(" Введите ID заявки : ");
            Item searchItem = tracker.findById(id);
            if (searchItem != null) {
                String name = input.ask("Введите новое имя заявки : ");
                String desc = input.ask("Введите описание заявки : ");
                Long create = System.currentTimeMillis();
                Item item = new Item(name, desc, create);
                tracker.replace(id, item);
                System.out.println("Заявка успешно изменена.");
            } else {
                System.out.println("Заявка не найдена.");
            }
        }
    }

    private class FindItemById extends BaseAction {

        public FindItemById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите ID заявки : ");
            Item item = tracker.findById(id);
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
    }

    private class FindItemsByName extends BaseAction {

        public FindItemsByName(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите имя заявки : ");
            System.out.println("---------- Список заявок : ---------- ");
            System.out.printf("%-15s%-20s%s%n", "Имя", "Описание", "Дата создания");
            System.out.println("------------------------------------------------------");
            Item[] listFindByName = tracker.findByName(name);
            if (listFindByName.length != 0) {
                for (Item item : listFindByName) {
                    System.out.printf("%-15.10s%-20.15s%s%n", item.getName(), item.getDescription(), item.getCreated());
                }
            } else {
                System.out.println("---------- Заявок не найдено. ----------");
            }
            System.out.println("------------------------------------------------------");
        }
    }

    private class ExitProgram extends BaseAction {
        private final StartUI ui;

        public ExitProgram(int key, String name, StartUI ui) {
            super(key, name);
            this.ui = ui;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            this.ui.stop();
        }
    }
}