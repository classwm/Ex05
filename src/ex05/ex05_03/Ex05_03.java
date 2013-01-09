
package ex05.ex05_03;


public class Ex05_03 {
    
    public static void main(String[] args) {        
        
        String[] words = {"jeden", "dwa", "trzy", "cztery"};
        Integer[] numbers = {1, 2, 3, 4};
        
        DLCList lista01 = new DLCList(words);
        
//        for (String word : words) {
//            lista01.insert(word);
//        }       
        lista01.display();
        
//        separator("=", "Dodawanie do listy tablicy nowych elemenów", 16);        
//        for (Integer number : numbers) {
//            lista01.insert(number);
//        }
//        lista01.display();
        
        System.out.println("");
        separator("=", "Lista wraz z wartownikiem i wartościami pól elementów", 6);
        lista01.displayAll();
        
        separator("=", "Kasowanie trzy", 16);
        lista01.delete("trzy");        
        lista01.displayAll();     
        
        separator("=", "Kasowanie jeden", 16);
        lista01.delete("jeden");        
        lista01.displayAll();
        
        separator("=", "Kasowanie dwa", 16);
        lista01.delete("dwa");       
        lista01.displayAll();
        
        separator("=", "Kasowanie cztery", 16);
        lista01.delete("cztery");     
        lista01.displayAll();
        
      

        
        
    }    
    
    /**
     * Formatowanie wyjścia danych programu.
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
        System.out.println(" "+ info + ":");
    }
}


