package divide_conquer;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/powx-n/description/">powx-n</a>
 */
public class PowN {
    /**
     * Fast Power
     * TC: O(logn)  The time of binary splitting of n
     * SC: O(1)
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if(x==0.0f) return 0.0d;
        if(n<0){
            x=1/x;
            n=-n;
        }

        int res=1;
        while (n > 0) {
            if ((n & 1) == 1) {
                res*=x;
            }
            x*=x;
            n >>= 1;
        }
        return res;
    }
}
