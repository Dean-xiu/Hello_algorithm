/**
 * Question link
 *
 * 归并排序 稳定
 * O(nlogn)
 */
public class MergeSort {
    public static void mergeSort(int[] nums,int left,int right,int[] tmp){
       if(left<right){
           int mid=left+(right-left)/2; //不断从中切分
           mergeSort(nums,left,mid,tmp);  //对切分后的继续切分排序
           mergeSort(nums,mid+1,right,tmp);
           merge(nums,left,mid,right,tmp); //合并两个排好序的区间
       }

    }

    private static void merge(int[] nums, int left, int mid, int right, int[] tmp) {
        int i=left,j=mid+1; //i指向第一个有序区间的开始  j指向第二个有序区间的开始
        int t=0;
        while(i<=mid && j<=right){
            if(nums[i]<=nums[j]){ //比较大小，移动指针，放入合并序列tmp
                tmp[t]=nums[i];
                i++;
                t++;
            }else{
                tmp[t]=nums[j];
                j++;
                t++;
            }
        }

        while(i<=mid){   //判断两个区间是否有遗留元素，有遗留元素直接按序放入合并序列tmp
            tmp[t]=nums[i];
            t++;
            i++;
        }
        while(j<=right){
            tmp[t]=nums[j];
            t++;
            j++;
        }

        t=0;
        int leftIndex=left;  //合并序列已经有序，copy到原序列中，使原序列有序
        while(leftIndex<=right){
            nums[leftIndex]=tmp[t];
            leftIndex++;
            t++;
        }

    }

    public static void main(String[] args) {
        int[] nums={3,9,-1,10,20};
        mergeSort(nums,0,nums.length-1,new int[nums.length]);
        print(nums);
        

        int[] nums2={0,-1,1,2,3,1};
        mergeSort(nums2,0,nums2.length-1,new int[nums2.length]);
        print(nums2);
        
    }


    public static void print(int[] nums){
        for(int n:nums){
            System.out.printf("%4d",n);
        }
        System.out.println();
    }
}
