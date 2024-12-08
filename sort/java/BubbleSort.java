/**
 * Question link
 *
 * 交换排序——冒泡排序  稳定
 * O(n^2)
 */
public class BubbleSort {
    public static void bubblesort(int[] nums){
        int n=nums.length-1;
        for(int i=0;i<n;i++){ //第i轮
            for(int j=0;j<n-i;j++){ //每轮确定一个位置，故j=n-i
                if(nums[j]>nums[j+1]){ //相邻比较
                    int tmp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=tmp;
                }
            }
        }
    }

    public static void bubbleSortUpdate(int[] nums){
        int n=nums.length-1;
        boolean flag=true; //判断该轮是否无元素交换

        for(int i=0;i<n;i++){
            for(int j=0;j<n-i;j++){
                if(nums[j]>nums[j+1]){
                    int tmp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=tmp;
                    flag=false; //存在交换
                }
            }
            if(flag){
                break; //无交换,说明已经有序,结束
            }else{
                flag=true;  //重置
            }
        }
    }

    public static void main(String[] args) {
        int[] nums={3,9,-1,10,20};
        bubblesort(nums);
        print(nums);

        int[] nums2={0,-1,1,2,3,1};
        bubbleSortUpdate(nums2);
        print(nums2);
    }


    public static void print(int[] nums){
        for(int n:nums){
            System.out.printf("%4d",n);
        }
        System.out.println();
    }

}
