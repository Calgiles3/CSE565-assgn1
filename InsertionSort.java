package assgn1;
/**
 * A sample insertion sort implementation.
 * 
 * @author Sedgewick and Wayne, Acuna
 * @version 1.0
 */

@SuppressWarnings("rawtypes")
public class InsertionSort<T> extends SortPlatform
{
    @SuppressWarnings("unchecked")
	public static <T> void sort(Comparable<T>[] a) {
        int N = a.length;
        
        for (int i = 1; i < N; i++)
        {
            // Insert a[i] among a[i-1], a[i-2], a[i-3]... ..
            for (int j = i; j > 0 && less(a[j], (T)a[j-1]); j--)
                exch(a, j, j-1);
        }
    }
    
    public static void main(String[] args) {
        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}