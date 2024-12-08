/**
 * Question link
 *
 * 插入排序——简单插入 稳定
 * O(n^2)
 */
public class InsertSort {
    public static void  insertSort(int[]nums){
        int len=nums.length;

        for(int i=0;i<len-1;i++){ //第i轮，每轮确定一个位置，所以共len-1轮，假定0-i是有序的
            for(int j=i+1;j>0;j--){ //在0-i中找到i+1的位置
                if(nums[j]<nums[j-1]){
                    int tmp=nums[j];
                    nums[j]=nums[j-1];
                    nums[j-1]=tmp;
                }else{
                    break;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] nums={3,9,-1,10,20};
        insertSort(nums);
        print(nums);

        int[] nums2={0,-1,1,2,3,1};
        insertSort(nums2);
        print(nums2);
    }


    public static void print(int[] nums){
        for(int n:nums){
            System.out.printf("%4d",n);
        }
        System.out.println();
    }
}
