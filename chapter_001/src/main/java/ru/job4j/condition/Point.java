package ru.job4j.condition;

/**
 * @author Vladislav Popoov(mailto:navodbmd.2@mail.ru)
 *  * @version $Id$
 *  * @since 0.1
 *
 */
public class Point {
    private int x;
    private int y;

    /**
     * Конструктор.
     * @param x 1 координата.
     * @param y 2 координата.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Расстояние между точками.
     * @param that вторая точка.
     * @return расстояние.
     */
    public double distanceTo(Point that) {
        return Math.sqrt(Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2));
    }

    /**
     * Задание параметров точек.
     * @param args координаты точек
     */
    public static void main(String[] args) {
        Point a = new Point(0, 1);
        Point b = new Point(2, 5);

        System.out.println("x1 = " + a.x);
        System.out.println("y1 = " + a.y);
        System.out.println("x2 = " + b.x);
        System.out.println("y2 = " + b.y);

        double result = a.distanceTo(b);
        System.out.println("Расстояние между точками А и В : " + result);
    }
}