import java.util.*;
import java.lang.*;

class Solution{
    public void printArray(int [] arr){
        for(int ele : arr)
            System.out.print(ele + " ");
        System.out.println();
    }

    public void swap(int [] arr, int i1 ,int i2){
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
    public void permute(int [] arr, int st, int end){
        if(st == end)
            printArray(arr);

        for(int i=st ; i<end ; i++){
            swap(arr, i, st);
            permute(arr, st+1, end);
            swap(arr, i, st);
        }
    }
}

public class PermutateArray {
    public static void main(String [] args){
        int [] arr = {1,2,3,4};
        Solution sol = new Solution();
        sol.permute(arr, 0, arr.length);
    }
}
