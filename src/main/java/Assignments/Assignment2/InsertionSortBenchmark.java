package Assignments.Assignment2;
import edu.neu.coe.info6205.util.Timer;
import edu.neu.coe.info6205.sort.elementary.InsertionSort;
import java.util.Random;

public class InsertionSortBenchmark {
    
    private static Random random = new Random();
    
    public static void main (String[] args) {
        
        int lenth, times;
        Integer[] nums;
        double result;
        times = 50;
        
        
        lenth = 1000;
        nums = createNums(lenth);
        warmup(nums);
        
        result = run(times, nums);
        System.out.println("Average time of " + lenth + " random nums for " + times + " tests: " + result);
        
        partordered(nums);
        result = run(times, nums);
        System.out.println("Average time of " + lenth + " part ordered nums for " + times + " tests: " + result);
        
        ordered(nums);
        result = run(times, nums);
        System.out.println("Average time of " + lenth + " ordered nums for " + times + " tests: " + result);
        
        reversed(nums);
        result = run(times, nums);
        System.out.println("Average time of " + lenth + " reversed nums for " + times + " tests: " + result);
        
        lenth = 2000;
        nums = createNums(lenth);
        warmup(nums);
        
        result = run(times, nums);
        System.out.println("Average time of " + lenth + " random nums for " + times + " tests: " + result);
        
        partordered(nums);
        result = run(times, nums);
        System.out.println("Average time of " + lenth + " part ordered nums for " + times + " tests: " + result);
        
        ordered(nums);
        result = run(times, nums);
        System.out.println("Average time of " + lenth + " ordered nums for " + times + " tests: " + result);
        
        reversed(nums);
        result = run(times, nums);
        System.out.println("Average time of " + lenth + " reversed nums for " + times + " tests: " + result);
        
        lenth = 4000;
        nums = createNums(lenth);
        //warmup(nums);
        
        result = run(times, nums);
        System.out.println("Average time of " + lenth + " random nums for " + times + " tests: " + result);
        
        partordered(nums);
        result = run(times, nums);
        System.out.println("Average time of " + lenth + " part ordered nums for " + times + " tests: " + result);
        
        ordered(nums);
        result = run(times, nums);
        System.out.println("Average time of " + lenth + " ordered nums for " + times + " tests: " + result);
        
        reversed(nums);
        result = run(times, nums);
        System.out.println("Average time of " + lenth + " reversed nums for " + times + " tests: " + result);
        
        lenth = 8000;
        nums = createNums(lenth);
        warmup(nums);
        
        result = run(times, nums);
        System.out.println("Average time of " + lenth + " random nums for " + times + " tests: " + result);
        
        partordered(nums);
        result = run(times, nums);
        System.out.println("Average time of " + lenth + " part ordered nums for " + times + " tests: " + result);
        
        ordered(nums);
        result = run(times, nums);
        System.out.println("Average time of " + lenth + " ordered nums for " + times + " tests: " + result);
        
        reversed(nums);
        result = run(times, nums);
        System.out.println("Average time of " + lenth + " reversed nums for " + times + " tests: " + result);
        
        lenth = 16000;
        nums = createNums(lenth);
        warmup(nums);
        
        result = run(times, nums);
        System.out.println("Average time of " + lenth + " random nums for " + times + " tests: " + result);
        
        partordered(nums);
        result = run(times, nums);
        System.out.println("Average time of " + lenth + " part ordered nums for " + times + " tests: " + result);
        
        ordered(nums);
        result = run(times, nums);
        System.out.println("Average time of " + lenth + " ordered nums for " + times + " tests: " + result);
        
        reversed(nums);
        result = run(times, nums);
        System.out.println("Average time of " + lenth + " reversed nums for " + times + " tests: " + result);
        
    }
    
    private static void ordered(Integer[] nums) {
        InsertionSort<Integer> iSort = new InsertionSort();
        iSort.sort(nums, 0, nums.length);
    }
    
    private static void partordered(Integer[] nums) {
        if (nums.length < 3) {
            return;
        }
        int k = nums.length / 3;
        InsertionSort<Integer> iSort = new InsertionSort();
        for (int i = 0; i < 3; i++) {
            iSort.sort(nums, i * k, (i + 1) * k);
        }
    }
    private static void reversed(Integer[] nums) {
        ordered(nums);
        int lenth = nums.length;
        int d = lenth / 2;
        int temp;
        for (int i = 0; i < d; i++) {
            temp = nums[i];
            nums[i] = nums[lenth - 1 - i];
        }
    }
    
    private static Integer[] createNums(int lenth) {
        Integer[] res = new Integer[lenth];
        for (int i = 0; i < lenth; i++) {
            res[i] = random.nextInt();
        }
        return res;
    }
    
    private static void warmup(Integer[] nums) {
        InsertionSort iSort = new InsertionSort();
        for (int i = 0; i < 100; i++) {
            iSort.sort(nums, true);
        }
    }
    
    private static double run(int times, Integer[] nums) {
        InsertionSort<Integer> iSort = new InsertionSort();
        Timer timer = new Timer();
        return timer.repeat(times, () -> {
            iSort.sort(nums, true);
            return null;
            
        });
    }
}
