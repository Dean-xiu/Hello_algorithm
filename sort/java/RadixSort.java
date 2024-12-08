/**
 * Question link
 *
 * 基数排序 稳定
 * O(nk)
 */
public class RadixSort {
    public static void radixSort(int[] nums) {
        int len=nums.length;
        int[][] bucket=new int[10][len]; //桶
        int[] bucketCounts=new int[10]; //统计每个桶里的放入的数据个数

        int min=nums[0],max=nums[0],offset=0; //找最大最小值，若全都是正整数，无需找最小值
        for(int i=0;i<len;i++){
            if(nums[i]<min){
                min=nums[i];
            }
            if(nums[i]>max){
                max=nums[i];
            }
        }
        if(min<0){  //如果最小值是负数，添加offset使整个数组成为正整数
            offset=-min;
            for(int i=0;i<len;i++){
                nums[i]+=offset;
            }
        }

        int maxLength=(max+"").length();  //计算最大值位数，即循环次数

        for(int k=0,n=1;k<maxLength;k++,n*=10){
            for(int i=0;i<len;i++){
                int digit=nums[i]/n%10; //计算当前位的值，从而放进相应的桶里，个位（n/1%10）->十位（n/10%10）->百位（n/100%10）
                bucket[digit][bucketCounts[digit]]=nums[i];
                bucketCounts[digit]++;
            }

            int index=0;
            for(int j=9;j>=0;j--){  //从桶里依次拿出来，放入原数组 ,降序就是倒着遍历桶 j=9;j>=0;j--
                if(bucketCounts[j]!=0){
                    for(int t=0;t<bucketCounts[j];t++){
                        nums[index]=bucket[j][t];
                        index++;
                    }
                    bucketCounts[j]=0; //清空桶计数以便下次重复使用
                }
            }
        }

        if(min<0){ //如果存在负数，减去偏移量恢复
            for(int i=0;i<len;i++){
                nums[i]-=offset;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums={3,9,-1,10,20};
        radixSort(nums);
        print(nums);


        int[] nums2={0,-1,1,2,3,1};
        radixSort(nums2);
        print(nums2);
    }


    public static void print(int[] nums){
        for(int n:nums){
            System.out.printf("%4d",n);
        }
        System.out.println();
    }
}
