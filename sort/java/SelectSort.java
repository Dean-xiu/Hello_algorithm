/**
 * Question link
 *
 * 选择排序——简单选择  不稳定
 * O(n^2)
 */
public class SelectSort {
    public static void selectSort(int[] nums){
        int n=nums.length;
        for(int i=0;i<n-1;i++){ //n-1轮之后，最后一个元素的位置已经确定，无需再多一次遍历
            int minIndex=i; //假定i位置上就是第i小的元素
            for(int j=i+1;j<n;j++){ //遍历剩下的元素，确定实际第i小元素下标
                if(nums[j]<nums[minIndex]){
                    minIndex=j;
                }
            }

            if(minIndex!=i){ //发现假定错误，通过遍历找到了正确的第i小元素下标，则与当前元素交换
                int tmp=nums[minIndex];
                nums[minIndex]=nums[i];
                nums[i]=tmp;
            }
        }
    }
    public static void main(String[] args) {
        int[] nums={3,9,-1,10,20};
        selectSort(nums);
        print(nums);

        int[] nums2={0,-1,1,2,3,1};
        selectSort(nums2);
        print(nums2);
    }


    public static void print(int[] nums){
        for(int n:nums){
            System.out.printf("%4d",n);
        }
        System.out.println();
    }

}
