package day2Task1;

public class Main {

    public static void main(String[] args) {

        int[] arr = {11, 5, -7, 80, 1, -10};
        sort(arr);
        for (int x : arr) {
            System.out.println(x);
        }

    }

    public static void sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;

        }

    }
}
