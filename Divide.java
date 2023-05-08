//Time =  O(log n), where n is the absolute value of the dividend
//Space = O(1)

class Solution {
    public int divide(int dividend, int divisor) {
        // Check for edge case where dividend is equal to the minimum integer value and divisor is -1
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        // Convert both dividend and divisor to long to handle edge cases
        long dividendLong = Math.abs((long) dividend);
        long divisorLong = Math.abs((long) divisor);
        
        // Initialize variables for the quotient and remainder
        int quotient = 0;
        long remainder = 0;
        
        // Iterate through each bit of the dividend from left to right
        for (int i = 31; i >= 0; i--) {
            // Shift the remainder left by 1 bit and add the next bit of the dividend
            remainder = (remainder << 1) | ((dividendLong >> i) & 1);
            
            // If the remainder is greater than or equal to the divisor, subtract the divisor from the remainder
            if (remainder >= divisorLong) {
                remainder -= divisorLong;
                quotient |= (1 << i);
            }
        }
        
        // Determine the sign of the result based on the signs of the dividend and divisor
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            quotient = -quotient;
        }
        
        // Return the quotient as an integer
        return quotient;
    }
}
