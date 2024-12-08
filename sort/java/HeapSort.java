/**
 * Question link
 *
 * 选择排序——堆排序 不稳定
 * O(nlogn)
 */
public class HeapSort {
    public static void heapSort(int[] nums) {
        //升序构造大顶堆，降序构造小顶堆
        int len=nums.length;
        for(int i=len/2-1;i>=0;i--){ //从最后一个非叶子节点开始，调整为堆
            adjustHeap(nums,i,len);
        }

        //堆构造完成
        for(int j=len-1;j>0;j--){  //堆顶是最大/最小元素，与末尾元素交换，末尾元素为第j+1大/小
            int tmp=nums[0];
            nums[0]=nums[j];
            nums[j]=tmp;

            adjustHeap(nums,0,j); //末尾元素已确定位置，对除末尾元素外的剩余元素重新调整为堆，堆顶又是最大/小
        }
    }

    public static void adjustHeap(int[]nums,int i,int len){
        int tmp=nums[i]; //父节点值
        for(int k=2*i+1;k<len;k=2*k+1){ //假定左节点是比较大的值 左孩子2*i+1, 右孩子2*i+2
            if(k+1<len && nums[k]<nums[k+1]){ //比较左右节点，确定最大值是哪一个
                k++;
            }
            if(nums[k]>tmp){ //与父节点交换，满足堆条件
                nums[i]=nums[k];
                nums[k]=tmp;
                i=k; //更新子节点为父节点，孙子节点为子节点（k=2*k+1) 再次循环
            }else{
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums={3,9,-1,10,20};
        heapSort(nums);
        print(nums);

        int[] nums2={0,-1,1,2,3,1};
        heapSort(nums2);
        print(nums2);
    }


    public static void print(int[] nums){
        for(int n:nums){
            System.out.printf("%4d",n);
        }
        System.out.println();
    }

}
