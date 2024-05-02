import java.util.*;

public class SelectionSort {
    static Scanner sc = new Scanner(System.in);

    public static void takeInput(int arr[]) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
    }

    public static void printArr(int arr[], String name) {
        System.out.print(name + " = ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }

    public static int selectionSort(int[] arr) {
        int totSwap = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int minPost = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minPost]) {
                    minPost = j;
                }
            }
            if (i != minPost) {
                int temp = arr[minPost];
                arr[minPost] = arr[i];
                arr[i] = temp;
                totSwap++;
            }
            // printArr(arr, "New Arr = ");
        }
        return totSwap;
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.print("Enter the length of the Array : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter Elements of the Array : ");
        takeInput(arr);
        printArr(arr, "Before Sorting");
        int swap = selectionSort(arr);
        printArr(arr, "After Sorting");
        System.out.print("With total swap : " + swap);
    }
}
