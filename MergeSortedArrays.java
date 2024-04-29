import java.util.Arrays;

public class MergeSortedArrays {
        public static int[] merge(int[] arr1, int[] arr2) {
            int[] result = new int[arr1.length + arr2.length];
            int i = 0, j = 0, k = 0;

            while (i < arr1.length && j < arr2.length) {
                if (arr1[i] <= arr2[j]) {
                    result[k++] = arr1[i++];
                } else {
                    result[k++] = arr2[j++];
                }
            }

            while (i < arr1.length) {
                result[k++] = arr1[i++];
            }

            while (j < arr2.length) {
                result[k++] = arr2[j++];
            }

            return result;
        }

        public static void main(String[] args) {
            int[] arr1 = {2, 4, 7, 11};
            int[] arr2 = {1, 3, 4, 5, 8, 12};
            int[] result = merge(arr1, arr2);
            System.out.println(Arrays.toString(result)); // [1, 2, 3, 4, 4, 5, 7, 8, 11, 12]

            int[] arr3 = {2, 4, 7, 11};
            int[] arr4 = {8, 12};
            int[] result2 = merge(arr3, arr4);
            System.out.println(Arrays.toString(result2)); // [2, 4, 7, 8, 11, 12]
        }
    }

