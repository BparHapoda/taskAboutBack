package org.example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Item item1 = new Item("Кольцо", 3, 1);
        Item item2 = new Item("Ожерелье", 4, 6);
        Item item3 = new Item("Колье", 5, 4);
        Item item4 = new Item("Кулон", 8, 7);
        Item item5 = new Item("Диадема", 9, 6);

        ArrayList<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);


        fillTable(items, new Back(13));


    }

    public static void fillTable(List<Item> items, Back back) {
        ArrayList<Integer> result = new ArrayList<>();
        int a[][] = new int[items.size() + 1][back.getCapacity() + 1];
        int w[] = new int[items.size()];
        int p[] = new int[items.size()];

        int count = 0;
        for (Item item : items
        ) {
            w[count] = item.getWeight();
            p[count] = item.getPrice();
            count++;
        }
        for (int i = 0; i < w.length; i++) {
            System.out.print(w[i] + " ");
        }
        System.out.println("");
        for (int i = 0; i < w.length; i++) {
            System.out.print(p[i] + " ");
        }
        System.out.println("");


        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < a[0].length; j++) {
                if (i == 1) {
                    a[i][j] = (w[i - 1] > j) ? 0 : p[i - 1];
                } else {
                    a[i][j] = (w[i - 1] > j) ? a[i - 1][j] : Math.max(a[i - 1][j], a[i - 1][j - w[i - 1]] + p[i - 1]);
                }
            }
        }
        printTable(a);
        result = findTable(a, w, p);
        System.out.println(" ");
        System.out.println("У нас на столе лежат драгоценности :");
        System.out.println("-----------------------------------");
        items.forEach((Item item) -> System.out.print(item));
        System.out.println("");
        System.out.println("В " + back + "для получения максимальной стоимости вещей мы положим :");
        System.out.println("-----------------------------------");
        result.forEach((Integer number) -> System.out.print(items.get(number - 1)));
    }

    public static ArrayList<Integer> findTable(int a[][], int w[], int p[]) {
        ArrayList<Integer> b = new ArrayList<>();

        int indexX = a[0].length - 1;
        int indexY = a.length - 1;
        for (int i = indexY; i > 0; i--) {
            if (a[indexY][indexX] != a[indexY - 1][indexX]) {
                b.add(indexY);
                indexX = indexX - w[indexY - 1];
                indexY--;
            } else {
                indexY--;
            }
        }

        return b;
    }

    public static void printTable(int a[][]) {
        int k = a.length;
        int s = a[0].length;

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < s; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println("");
        }
    }
}