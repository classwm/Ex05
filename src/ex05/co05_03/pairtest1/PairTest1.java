package ex05.co05_03.pairtest1;

/**
 * @version 1.00 2004-05-10
 * @author Cay Horstmann
 */
public class PairTest1 {

    public static void main(String[] args) {
        String[] words = {"Mary", "had", "a", "little", "lamb"};
        Pair<String> mm = ArrayAlg.minmax(words);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());

        Integer[] integers = {1, 2, 3, 4, 1, 10, 40, 3};
        Pair<Integer> nn = ArrayAlg.minmax(integers);
        System.out.println("min = " + nn.getFirst());
        System.out.println("max = " + nn.getSecond());

        Triple<Integer> tt = ArrayAlg.minmedmax(integers);
        System.out.println("min = " + tt.getFirst());
        System.out.println("max = " + tt.getSecond());
        System.out.println("Średnia = " + tt.getThird());
    }
}

class ArrayAlg {

    /**
     * Gets the minimum and maximum of an array of strings.
     *
     * @param a an array of strings
     * @return a pair with the min and max value, or null if a is null or empty
     */
    public static Pair<String> minmax(String[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        String min = a[0];
        String max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) {
                min = a[i];
            }
            if (max.compareTo(a[i]) < 0) {
                max = a[i];
            }
        }
        return new Pair<String>(min, max);
    }

    static Pair<Integer> minmax(Integer[] integers) {
        if (integers == null || integers.length == 0) {
            return null;
        }
        int min = integers[0];
        int max = integers[0];
        for (int i = 1; i < integers.length; i++) {
            if (integers[i] < min) {
                min = integers[i];
            }
            if (integers[i] > max) {
                max = integers[i];
            }
        }
        return new Pair<Integer>(min, max);
    }

    static Triple<Integer> minmedmax(Integer[] integers) {
        if (integers == null || integers.length == 0) {
            return null;
        }

        int min = integers[0];
        int med = 0;
        int max = integers[0];

        for (int i = 1; i < integers.length; i++) {
            if (integers[i] < min) {
                min = integers[i];
            }
            if (integers[i] > max) {
                max = integers[i];
            }
            med += (int) integers[i];
        }
        med = med / integers.length;

        return new Triple<Integer>(min, max, med);
    }

    public static <T extends Comparable<T>> Pair<T> minmax(T[] a) {

        if (a == null || a.length == 0) {
            return null;
        }

        T min = a[0];
        T max = a[0];

        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) {
                min = a[i];
            }
            if (max.compareTo(a[i]) < 0) {
                max = a[i];
            }
        }
        return new Pair<T>(min, max);
    }
    
}
// comparable czyli compareTo - String i Integer
