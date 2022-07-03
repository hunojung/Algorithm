// https://leetcode.com/problems/median-of-two-sorted-arrays/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] arr = new int[m+n];
        int idx = 0,idx1 = 0, idx2 = 0;
        while(idx1<m && idx2<n){
            if(nums1[idx1]<nums2[idx2]){
                arr[idx++] = nums1[idx1++];
            }else{
                arr[idx++] = nums2[idx2++];
            }
        }
        while(idx1<m){
            arr[idx++] = nums1[idx1++];
        }
        while(idx2<n){
            arr[idx++] = nums2[idx2++];
        }
        
        int mid = (m+n)/2;
        if((m+n)%2==0){
            //System.out.println(mid+" "+arr[mid]+" "+arr[mid-1]);
            return (double)(arr[mid]+arr[mid-1])/(double)2;
        }else{
            return arr[mid];
        }
    }
}
