package ex05.ex05_03;

public class Ex05_03 {

    public static void main(String[] args) {

        String[] words = {"jeden", "dwa", "trzy", "cztery"};
        Integer[] numbers = {1, 2, 3, 4};

        separator("=", "Tworzenie listy z tablicy", 16);
        DLCList list01 = new DLCList(words);
        list01.display();

        separator("=", "Dodawanie do listy nowych elemenów", 16);
        for (Integer number : numbers) {
            list01.insert(number);
        }
        list01.display();

        separator("=", "Test działania search - szukania podanego elementu", 8);

        System.out.println("Element '3'" + (list01.search(3) != null ? "" : " nie") + " występuje na liście.");
        System.out.println("Element 'dwa'" + (list01.search("dwa") != null ? "" : " nie") + " występuje na liście.");
        System.out.println("Element '-32'" + (list01.search(-32) != null ? "" : " nie") + " występuje na liście.");
        System.out.println("Element 'ABC'" + (list01.search("ABC") != null ? "" : " nie") + " występuje na liście.");

        separator("=", "Kasowanie elemenów", 16);

        list01.display();
        for (Integer number : numbers) {
            list01.delete(number);
        }
        list01.display();

        System.out.println("");
        separator("=", "Lista wraz z wartownikiem i wartościami pól elementów", 6);
        list01.displayAll();

        separator("=", "Kasowanie trzy", 16);
        list01.delete("trzy");
        list01.displayAll();

        separator("=", "Kasowanie jeden", 16);
        list01.delete("jeden");
        list01.displayAll();

        separator("=", "Kasowanie dwa", 16);
        list01.delete("dwa");
        list01.displayAll();

        separator("=", "Kasowanie cztery", 16);
        list01.delete("cztery");
        list01.displayAll();
    }

    /**
     * Formatowanie wyjścia danych programu.
     *
     * @param sep Ciąg znaków separatora.
     * @param info String z opisem następnego bloku wypisanych danych.
     * @param i Ilośc powtórzen wyświetlenia separatora.
     */
    private static void separator(String sep, String info, int i) {
        System.out.println("");
        while (i > 0) {
            System.out.print(sep);
            i--;
        }
        System.out.println(" " + info + ":");
    }
}
