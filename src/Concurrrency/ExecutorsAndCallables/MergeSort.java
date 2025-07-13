package Concurrrency.ExecutorsAndCallables;

public class MergeSort {
    public static int[] merge(int[] leftArray, int[] rightArray) {
        int[] mergedArray = new int[leftArray.length + rightArray.length];
        int i = 0, j = 0, k = 0;
        while(i < leftArray.length && j < rightArray.length) {
            if(leftArray[i] <= rightArray[j]) mergedArray[k++] = leftArray[i++];
            else mergedArray[k++] = rightArray[j++];
        }
        while(i < leftArray.length) mergedArray[k++] = leftArray[i++];
        while(j < rightArray.length) mergedArray[k++] = rightArray[j++];
        return mergedArray;
    }

    public static int[] mergeSort(int[] array) {
        // Base Condition
        if(array.length <= 1) return array;
        int mid = array.length / 2;
        int[] leftArray = new int[mid];
        // for(int i = 0; i < leftArray.length; i++) leftArray[i] = array[i];
        System.arraycopy(array, 0, leftArray, 0, leftArray.length);
        int[] rightArray = new int[array.length - mid];
        // for(int i = 0; i < rightArray.length; i++) rightArray[i] = array[mid + i];
        System.arraycopy(array, mid, rightArray, 0, rightArray.length);
        leftArray = mergeSort(leftArray);
        rightArray = mergeSort(rightArray);

        return merge(leftArray, rightArray);
    }

    public static void main(String[] args) {
        int[] array = new int[] {15,1,8,2,3,9,4,0,7,6,12};
        int[] sortedArray = mergeSort(array);
        System.out.println("Sorted Array");
        for(int i : sortedArray) System.out.print(i+" ");
    }

}
