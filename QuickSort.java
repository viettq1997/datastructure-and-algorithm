public class QuickSort {
    
    public static void main(String[] args) {
        // int[] arr = {1,9,6,2,3,7,5,44,55,66,41,52};
        int[] arr = {6,1,9,3,7,10,2,8,0};
        sort(arr, 0, arr.length - 1);
        for (int i = 0; i< arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }


    private static void sort(int arr[], int low, int high) {
        if (low >= high) return;
        int pivot = (high + low)/2;
        int i = low;
        int j = high;
        // do {
            while (arr[i] < arr[pivot])i++;
            while (arr[j] > arr[pivot])j--;
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        // } while (i < j);
        
        sort(arr, low, j);
        sort(arr, i, high);
    }
}
