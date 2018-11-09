package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * @author В-87
 * @version $Id$
 * @since 0.1
 */

class DeleteItem implements UserAction {

    @Override
    public int key() {
        return 3;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("---------- Удаление заявки ----------");
        String id = input.ask("Введите ID заявки : ");
        if (tracker.delete(id)) {
            tracker.delete(id);
            System.out.println("Заявка успешно удалена.");
        } else {
            System.out.println("Заявка не найдена.");
        }
    }

    @Override
    public String info() {
        return "3. Удаление заявки";
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

    public void fillActions() {
        this.actions.add(new AddItem());
        this.actions.add(new ShowItems());
        this.actions.add(new MenuTracker.EditItem());
        this.actions.add(new DeleteItem());
        this.actions.add(new FindItemById());
        this.actions.add(new FindItemsByName());
        this.actions.add(new ExitProgram());
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

    private class AddItem implements UserAction {

        @Override
        public int key() {
            return 0;
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

        @Override
        public String info() {
            return "0. Добавление новой заявки";
        }
    }

    private class ShowItems implements UserAction {

        @Override
        public int key() {
            return 1;
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

        @Override
        public String info() {
            return "1. Список созданных заявок.";
        }
    }

    private static class EditItem implements UserAction {

        @Override
        public int key() {
            return 2;
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
        @Override
        public String info() {
            return "2. Изменение заявки.";
        }
    }

    private class FindItemById implements UserAction {

        @Override
        public int key() {
            return 4;
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

        @Override
        public String info() {
            return "4. Найти заявку по ID.";
        }
    }

    private class FindItemsByName implements UserAction {

        @Override
        public int key() {
            return 5;
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

        @Override
        public String info() {
            return "5. Найти заявку по имени.";
        }
    }

    private class ExitProgram implements UserAction {

        @Override
        public int key() {
            return 6;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.exit(0);
        }

        @Override
        public String info() {
            return "6. Выход.";
        }
    }
}