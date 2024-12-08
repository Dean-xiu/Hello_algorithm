/**
 * Question link
 *
 * 交换排序——快速排序 不稳定
 * O(nlogn)
 */
public class QuickSort {
    public static void quickSortBasedOnFirst(int[] nums,int start,int end){
        if(start<=end){
            int l=start,r=end;
            int base=nums[start];  //假设以第一个元素为基准元素，实现规则：基准以左小于基准元素，基准以右大于基准元素
            while(l!=r){
                while(l<r && nums[r]>=base) r--; //从右向左，找到第一个小于基准元素的位置
                while(l<r && nums[l]<=base) l++; //从左向右，找到第一个大于基准元素的位置

                if(l<r){  //交换使满足规则
                    int tmp=nums[l];
                    nums[l]=nums[r];
                    nums[r]=tmp;
                }
            }
            nums[start]=nums[l]; //交换基准元素到正确基准位置
            nums[l]=base;
            //递归左右区间
            quickSortBasedOnFirst(nums,start,l-1);
            quickSortBasedOnFirst(nums,l+1,end);
        }
    }

    public static void quickSortBasedOnLast(int[]nums,int start,int end){
        if(start<=end){
            int l=start,r=end;
            int base=nums[end];
            while(l!=r){
                while(l<r && nums[l]<=base) l++;
                while(l<r && nums[r]>=base) r--;

                if(l<r){
                    int tmp=nums[l];
                    nums[l]=nums[r];
                    nums[r]=tmp;
                }
            }

            nums[end]=nums[r];
            nums[r]=base;
            quickSortBasedOnLast(nums,start,l-1);
            quickSortBasedOnLast(nums,l+1,end);
        }
    }

    public static void quickSortBasedOnMid(int[] nums,int start,int end){
        int l=start,r=end;
        int base=nums[l+(r-l)/2];
        while(nums[l]<base) l++;
        while(nums[r]>base) r--;
        if(l<=r){
            int tmp=nums[l];
            nums[l]=nums[r];
            nums[r]=tmp;

            l++;
            r--;
        }
        if(start<r) quickSortBasedOnMid(nums,start,r);
        if(l<end) quickSortBasedOnMid(nums,l,end);
    }
    public static void main(String[] args) {
        int[] nums={3,9,-1,10,20};
        quickSortBasedOnFirst(nums,0,nums.length-1);
        print(nums);
        quickSortBasedOnLast(nums,0,nums.length-1);
        print(nums);
        quickSortBasedOnMid(nums,0,nums.length-1);
        print(nums);




        int[] nums2={0,-1,1,2,3,1};
        quickSortBasedOnFirst(nums2,0,nums2.length-1);
        print(nums2);
        quickSortBasedOnLast(nums2,0,nums2.length-1);
        print(nums2);
        quickSortBasedOnMid(nums2,0,nums2.length-1);
        print(nums2);
    }


    public static void print(int[] nums){
        for(int n:nums){
            System.out.printf("%4d",n);
        }
        System.out.println();
    }


}
