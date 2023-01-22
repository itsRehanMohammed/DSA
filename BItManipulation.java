package DSA;

public class BItManipulation {

    public static void oddOrEven(int num) {
        int bitMask =1;
        if ((num & bitMask) == 0) {
            // even number
            System.out.println("even number");
        } else{
            // odd number
            System.out.println("odd number");
        }
    }
    
    public static int getIthBit(int n, int i) {
        int bitMask= 1<<i;
        if ((n & bitMask)==0) {
            return 0;
        } else {
            return 1;
        } 
    }

    public static int setIthBit(int n, int i) {
        int bitMask = 1<<i;
        return n | bitMask;
    }

    public static int clearIthBit(int n, int i) {
        int bitMask = ~(1 << i);
        return n & bitMask;
    }

    public static int updateIthBit(int num, int i, int newBit) {
        num = clearIthBit(num, i);
        int bitMask = newBit<<i;
        return num | bitMask;
    }

    public static int clearLastIthBits(int num, int i) {
        int bitMask= (~0)<<i;
        return num & bitMask;
    }

    public static int clearRangeOfBits(int num, int i, int j) {
        int a = (~0) << (j+1);
        int b = 1<< (i - 1);
        int bitMask = a | b;

        return num & bitMask;
    }

    public static boolean checkNumberIsPowerOfTwo(int num) {
        // 1st Approach
        // int bitMask = num & (num-1);
        // if (bitMask == 0) {
        //     return true;
        // }
        // return false;


        // 2nd Approach
        return (num & (num-1))== 0;
    }


    // Google, Amazon      || set bits == 1, clear bits == 0
    public static int checkSetOfBits(int num){ // O(log n)
        int count =0;
        while(num > 0){
            if ((num & 1 ) != 0) {  // checking number of 1 present 
                count++;
            }
           num= num>>1;             // decreasing 1 bit from the right 
        }
        return count;
    }

    // Google, Amazon      ||  clear bits == 0
    public static int checkClearOfBits(int num){ // O(log n)
        int count =0;
        while(num > 0){
            if ((num & 1 ) != 1) {  // checking number of 0 present 
                count++;
            }
           num= num>>1;             // decreasing 1 bit from the right 
        }
        return count;
    }

    public static int fastExponentiation(int num, int power){  // O(log n + 1)
        int ans  = 1;   // Initialize answer
        while(power > 0){
            if ((power & 1) != 0) {
                ans = ans * num;
            }
            num = num * num;        // Change num to num^2
            power = power >> 1;     // decreasing 1 bit from the right  OR  power = power/2 
        }

        return ans;
    }

    // Google    || Explanation same as fast Exponentiation the only diffrence is [at last do ans % mod]
    public static int modularExponentiation(int num, int power, int mod){  // O(log n + 1)
        int ans  = 1;   // Initialize answer
        while(power > 0){
            if ((power & 1) != 0) {
                ans = ans * num;
            }
            num = num * num;        // Change num to num^2
            power = power >> 1;     // decreasing 1 bit from the right  OR  power = power/2 
        }

        return ans % mod;           // ans module(%) mod
    }

    public static void main(String args[]) {
        System.out.println(modularExponentiation(5,3, 13));
    }
}





        // System.out.println(5 & 6);    // Binary AND operator
        // System.out.println(5 | 6);    // Binary OR operator
        // System.out.println(5 ^ 6);    // Binary XOR operator
        // System.out.println(~ 6);      // Binary One's Complement --- NOT operator
        // System.out.println(5<<3);     // Binary Left Shift operator  [Formula -- (a+2^b)]
        // System.out.println(6>>1);     // Binary Right Shift operator [Formula -- (a/2^b)]