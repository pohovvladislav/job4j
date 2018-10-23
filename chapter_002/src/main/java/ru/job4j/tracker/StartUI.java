package ru.job4j.tracker;

/**
 *
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

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showmenu();
            String answear = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answear)) {
                this.createItem();
            } else if (SHOW.equals(answear)) {
                this.listItem();
            } else if(EDIT.equals(answear)) {
                this.correctionItem();
            } else if (DELETE.equals(answear)) {
                this.removalItem();
            } else if (FINDID.equals(answear)) {
                this.searchByIdItem();
            } else if (FINDNAME.equals(answear)) {
                this.searchByNameItem();
            } else if (EXIT.equals(answear)) {
                exit = true;
            }
        }
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
        System.out.printf("%-15s%-20s%s%n", "Имя", "Описание","Дата создания");
        System.out.println("------------------------------------------------------");
        if (this.tracker.findAll().length != 0) {
            for (Item item : this.tracker.findAll()) {
                System.out.printf("%-15.10s%-20.15s%s%n", item.getName(), item.getDescription(), item.getCreated());
            }
        } else {
            System.out.println("---------- Заявки не созданы. ----------");
        }
        System.out.println("------------------------------------------------------");
    }

    private void correctionItem() {
        System.out.println("---------- Изменение заявки ----------");
        String Id = this.input.ask(" Введите ID заявки : ");
        Item searchItem = this.tracker.findById(Id);
        if (searchItem != null) {
            String name = this.input.ask("Введите новое имя заявки : ");
            String desc = this.input.ask("Введите описание заявки : ");
            Long create = System.currentTimeMillis();
            Item item = new Item(name, desc, create);
            this.tracker.replace(Id, item);
            System.out.println("Заявка успешно изменена.");
        } else {
            System.out.println("Заявка не найдена.");
        }
    }

    private void removalItem() {
        System.out.println("---------- Удаление заявки ----------");
        String Id = this.input.ask("Введите ID заявки : ");
        if (tracker.delete(Id)) {
            this.tracker.delete(Id);
            System.out.println("Заявка успешно удалена.");
        } else {
            System.out.println("Заявка не найдена.");
        }
    }

    private void searchByIdItem() {
        String Id = this.input.ask("Введите ID заявки : ");
        Item item = this.tracker.findById(Id);
        if (item != null) {
            System.out.println("Заявка с данным ID : ");
            System.out.printf("%-15s%-20s%s%n", "Имя", "Описание","Дата создания");
            System.out.println("------------------------------------------------------");
            System.out.printf("%-15.10s%-20.15s%s%n",item.getName(), item.getDescription(), item.getCreated());
            System.out.println("------------------------------------------------------");
        } else {
            System.out.println("Заявка не найдена.");
        }
    }

    private void searchByNameItem() {
        String name = this.input.ask("Введите имя заявки : ");
        System.out.println("---------- Список заявок : ---------- ");
        System.out.printf("%-15s%-20s%s%n", "Имя", "Описание","Дата создания");
        System.out.println("------------------------------------------------------");
        if (this.tracker.findByName(name).length != 0) {
            for (Item item : this.tracker.findByName(name)) {
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
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
