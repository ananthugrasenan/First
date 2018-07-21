import java.util.Arrays;

public class Mergify {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        System.out.println("Hello world!");
        /*
        for (int o : merge(new int[] {1,2,3,6,19}, new int[] {3,6,7,8, 33,45,66,78})) {
            System.out.println(o);
        }
        */
        System.out.println(java.util.Arrays.toString(merge(new int[] {1,2,3,6,19}, new int[] {3,6,7,8, 33,45,66,78})));


        System.out.println(reverse("glad to meet you"));

        int[] sorted = {2, 4, 6, 15, 34, 44, 46, 47, 65};
        System.out.println(binarysearch(sorted, 0, sorted.length-1, 44));
        System.out.println(binarysearch(sorted, 0, sorted.length-1, 49));
    }

    public static int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        int leftTracker = 0;
        int rightTracker = 0;
        for (int i=0; i<left.length + right.length; i++) {
            if (leftTracker >= left.length) {
                System.arraycopy(right, rightTracker, merged, i, right.length-rightTracker);
                return merged;
            }
            else if (rightTracker >= right.length) {
                System.arraycopy(left, leftTracker, merged, i, left.length-leftTracker);
                return merged;
            }

            if (left[leftTracker] < right[rightTracker]) {
                merged[i] = left[leftTracker];
                leftTracker++;
            }
            else {
                merged[i] = right[rightTracker];
                rightTracker++;
            }

        }
        return merged;

    }

    public static String reverse(String input) {
        // Base
        if (input.length() <= 1) return input;
        else return String.valueOf(input.charAt(input.length()-1))
                + reverse(input.substring(0,input.length()-1));
    }

    public static int binarysearch (int[] sorted, int left, int right, int val) {
        System.out.println("Search for " + val + " in " + Arrays.toString(sorted)
                + " left: " + left + "right:" + right);
        if (left > right) return -1;

        int mid = (left+right)/2;
        int midVal = sorted[mid];
        System.out.println("midVal: " + midVal);
        if (midVal == val) return mid;
        else if (left == right) return -1;
        else if (midVal > val) return binarysearch(sorted, left, mid, val);
        else return binarysearch(sorted, ++mid, right, val);
    }
}
