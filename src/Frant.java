// package whatever; // don't place package name!

import java.io.*;

class Frant {
    public static void main (String[] args) {
        System.out.println("Hello Java");
        int[] test = {1, 1, 1, 2, 1};
        System.out.println("{1, 1, 1, 2, 1} => " + canBalance(test));
        int[] test1 = {2, 1, 1, 2, 1};
        System.out.println("{2, 1, 1, 2, 1} => " + canBalance(test1));
        int[] test2 = {1, 2, 3, 4};
        System.out.println("{1, 2, 3, 4} => " + canBalance(test2));
        int[] test3 = {4, 1, 1, 1, 1};
        System.out.println("4, 1, 1, 1, 1 =>" + canBalance(test3));
        int[] test4 = {10, 10};
        System.out.println("{10, 10} =>" + canBalance(test4));
    }

    public static boolean canBalance(int[] arr) {
        int tracker = 0;
        int leftSum = 0;
        int rightSum = 0;

        //1, 3, 1= 5
        //2, 3, 5, 1= 11
        for (int n: arr) {
            leftSum += n;
            if (tracker == 0) rightSum = sum(arr, tracker + 1);
            else rightSum -= n;
            tracker++;
            if(leftSum == rightSum) return true;
            if (leftSum > rightSum) return false;
        }
        return false;
    }

    static int sum(int[] arr, int start) {
        int sum = 0;

        for (int i=start; i<arr.length; i++) {
            sum+= arr[i];
        }
        return sum;
    }
}

/*Given a non-empty array, return true if
there is a place to split the array so
that the sum of the numbers on the left side is equal to
the sum of the numbers on the right side.
You can assume all integers are positives

canBalance([1, 1, 1, 2, 1]) → true
canBalance([2, 1, 1, 2, 1]) → false
canBalance([1, 2, 3, 4]) → false
canBalance([4, 1, 1, 1, 1]) → true
canBalance([10, 10]) → true
*/
