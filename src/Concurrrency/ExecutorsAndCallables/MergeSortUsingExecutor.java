package Concurrrency.ExecutorsAndCallables;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.List;
import java.util.ArrayList;

public class MergeSortUsingExecutor implements Callable<List<Integer>> {
    List<Integer> array;
    ExecutorService executor;
    public MergeSortUsingExecutor(List<Integer> array, ExecutorService executor) {
        this.array = array;
        this.executor = executor;
    }

    public List<Integer> call() throws Exception {
        if(array.size() <= 1) return array;
        int mid = array.size() / 2;

        List<Integer> leftArray = new ArrayList<> (), rightArray  = new ArrayList<> ();
        for(int i = 0; i < array.size(); i++) {
            if(i < mid) leftArray.add(array.get(i));
            else rightArray.add(array.get(i));
        }

        MergeSortUsingExecutor leftSorter = new MergeSortUsingExecutor(leftArray, executor);
        MergeSortUsingExecutor rightSorter = new MergeSortUsingExecutor(rightArray, executor);

        // When executor submit is called it returns a Future Object
        Future<List<Integer>> leftFuture = executor.submit(leftSorter);
        Future<List<Integer>> rightFuture = executor.submit(rightSorter);

        // .get() Method of Future returns the original datatype
        leftArray = leftFuture.get();
        rightArray = rightFuture.get();

        // Merge both Arrays
        return merge(leftArray, rightArray);
    }

    public List<Integer> merge(List<Integer> leftArray, List<Integer> rightArray) {
        List<Integer> mergedArray = new ArrayList<> ();
        int i = 0, j = 0;
        while(i < leftArray.size() && j < rightArray.size()) {
            if(leftArray.get(i) <= rightArray.get(j)) {
                mergedArray.add(leftArray.get(i++));
            } else mergedArray.add(rightArray.get(j++));
        }
        // Adding Remaining Elements into the merged Array
        while(i < leftArray.size()) mergedArray.add(leftArray.get(i++));
        while(j < rightArray.size()) mergedArray.add(rightArray.get(j++));

        return mergedArray;
    }

    public static void main(String[] args) throws Exception {
        List<Integer> array = List.of(6,1,9,8,2,7,3,5,4);
        ExecutorService executorService = Executors.newCachedThreadPool(); // .newFixedThreadPool(5);
        MergeSortUsingExecutor sorter = new MergeSortUsingExecutor(array, executorService);
        Future<List<Integer>> sortedArray = executorService.submit(sorter);
        System.out.println(sortedArray.get());
        executorService.shutdown();
    }
}
