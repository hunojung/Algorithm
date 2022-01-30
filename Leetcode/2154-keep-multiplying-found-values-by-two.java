// https://leetcode.com/problems/keep-multiplying-found-values-by-two/
public int findFinalValue(int[] nums, int original) {

  int[] arr = new int[2001];

  for(int num : nums)
    arr[num]++;

  while(arr[original]>0)
    original*=2;

  return original;
}
