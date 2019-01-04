package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author В-87
 * @version $Id$
 * @since 0.1
 */



public class MenuTracker {
    private Tracker tracker;
    private Input input;
    private List<UserAction> actions = new ArrayList<>();
    private final Consumer<String> output;


    public MenuTracker(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    public int getActionsLength() {
        return this.actions.size();
    }

    public void fillActions(StartUI ui) {
        this.actions.add(new AddItem(0, "Создание новой заявки."));
        this.actions.add(new ShowItems(1, "Список созданных заявок."));
        this.actions.add(new EditItem(2, "Изменить заявку."));
        this.actions.add(new DeleteItem(3, "Удаление заявки."));
        this.actions.add(new FindItemById(4, "Найти заявку по ID."));
        this.actions.add(new FindItemsByName(5, "Найти заявку по имени."));
        this.actions.add(new ExitProgram(6, "Выход.", ui));
    }

    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    public void show(Consumer<String> cos) {
        for (UserAction action : this.actions) {
            if (action != null) {
                cos.accept(action.info());
            }
        }
    }

    private class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите имя заявки : ");
            String desc = input.ask("Введите описание заявки : ");
            Long create = System.currentTimeMillis();
            Item item = new Item(name, desc, create);
            tracker.add(item);
            output.accept("Новая заявка с ID " + item.getId());
        }
    }

    private class ShowItems extends BaseAction {

        public ShowItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            Item[] listFindAll = tracker.findAll();
            if (listFindAll.length != 0) {
                for (Item item : listFindAll) {
                    output.accept(String.format("Name: %s| Desc: %s| Id: %s",
                            item.getName(), item.getDescription(), item.getId())
                    );
                }
            } else {
                output.accept("Заявки не созданы.");
            }
        }
    }

    private class EditItem extends BaseAction {

        public EditItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask(" Введите ID заявки : ");
            Item searchItem = tracker.findById(id);
            if (searchItem != null) {
                String name = input.ask("Введите новое имя заявки : ");
                String desc = input.ask("Введите описание заявки : ");
                Long create = System.currentTimeMillis();
                Item item = new Item(name, desc, create);
                tracker.replace(id, item);
                output.accept("Заявка успешно изменена.");
            } else {
                output.accept("Заявка не найдена.");
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
                output.accept(String.format("Name: %s| Desc: %s| Id: %s",
                        item.getName(), item.getDescription(), item.getId()));
            } else {
                output.accept("Заявка не найдена.");
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
            Item[] listFindByName = tracker.findByName(name);
            if (listFindByName.length != 0) {
                for (Item item : listFindByName) {
                    output.accept(String.format("Name: %s| Desc: %s| Id: %s",
                            item.getName(), item.getDescription(), item.getId()));
                }
            } else {
                output.accept("Заявок не найдено.");
            }
        }
    }

   private class DeleteItem extends BaseAction {

        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите ID заявки : ");
            if (tracker.delete(id)) {
                output.accept("Заявка успешно удалена.");
            } else {
                output.accept("Заявка не найдена.");
            }
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