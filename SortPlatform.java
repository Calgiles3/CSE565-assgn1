package assgn1;
/**
 * Basic helper functions for implementing a sorting algorithm.
 * 
 * @author Sedgewick and Wayne, Acuna
 * @version 1.0
 */

public class SortPlatform<T extends Comparable<T>>
{

    public static <T> boolean less(Comparable<T> v, T w) {
        return v.compareTo(w) < 0;
    }
    
    public static <T> void exch(Comparable<T>[] a, int i, int j) {
        Comparable<T> t = a[i]; a[i] = a[j]; a[j] = t;
    }
    
    public static <T> void show(Comparable<T>[] a) {
        for(int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
    
    @SuppressWarnings(value = {"unchecked"})
    public static <T> boolean isSorted(Comparable<T>[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], (T)a[i-1]))
                return false;
        
        return true;
    }
    
    public static void main(String[] args) {
        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        assert isSorted(a);
        show(a);
    }
}