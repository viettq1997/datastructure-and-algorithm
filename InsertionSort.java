public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {1,2,7,10,12,6,5};
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > current) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = current;
        }

        for(int i = 0; i< array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
