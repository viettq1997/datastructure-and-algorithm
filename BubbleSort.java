public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {1,5,6,8,7};

        for (int i = 0; i <= array.length - 2; i++) {
            for(int j = i + 1; j <= array.length - 1; j++) {
                int temp;
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        for (int i = 0; i< array.length; i++) {
            System.out.println(array[i]);
        }
    }
}