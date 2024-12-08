/**
 * Question link
 *
 * 插入排序——希尔排序 不稳定
 * O(nlogn)
 */
public class ShellSort {
    public static void shellSortExchange(int[] nums){
        int len=nums.length;
        for(int gap=len/2;gap>0;gap/=2){ //按gap进行分组
            for(int i=0;i<=gap;i++){ //遍历每一个gap组
                for(int j=i+gap;j<len;j+=gap){ //本循环是为了往前倒腾
                    if(nums[j-gap]>nums[j]){
                        int temp=nums[j-gap];
                        nums[j-gap]=nums[j];
                        nums[j]=temp;
                    }
                }
            }
        }
    }


    public static void shellSortShift(int[] nums){
        int len=nums.length;
        for(int gap=len/2;gap>0;gap/=2){
            for(int i=gap;i<len;i++){
                int left=i-gap;
                while (left>= 0 && nums[i] < nums[left]) {
                    int insert=nums[i];
                    nums[left + gap] = nums[left];//比较过的值右移
                    nums[left]=insert;

                    left -= gap;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums={3,9,-1,10,20};
        shellSortExchange(nums);
        print(nums);
        shellSortShift(nums);
        print(nums);

        int[] nums2={0,-1,1,2,3,1};
        shellSortExchange(nums2);
        print(nums2);
        shellSortShift(nums2);
        print(nums2);
    }


    public static void print(int[] nums){
        for(int n:nums){
            System.out.printf("%4d",n);
        }
        System.out.println();
    }
}
