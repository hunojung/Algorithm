// https://leetcode.com/problems/add-digits/

// 미친 답안
class Solution {
    public int addDigits(int num) {
        if(num % 9 == 0 && num != 0) return 9;
        return num % 9;
    }
}

// 제출 답안
class Solution {
    public int addDigits(int num) {
        while(num>9){
            int mod = (num%10);
            num/=10;
            num += mod;
        }
        return num;
    }
}
