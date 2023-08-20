import java.util.*;
import java.lang.*;

class Tree{
    public int [] treeArray;
    public int n;

    Tree(int [] arr){
        build(arr, 0, 0,arr.length-1);
        this.n = arr.length;
        this.treeArray = new int[4*n];
    }

    public void build(int [] arr, int index, int left, int  right){
        if(left == right){
            this.treeArray[index] = arr[left];
            return;
        }
        int mid = left+right;
        mid/=2;
        build(arr, index*2+1, left, mid);
        build(arr, index*2+2, mid+1, right);
        this.treeArray[index] = Math.min(this.treeArray[index*2+1], this.treeArray[index*2+2]);
    }

    public int querry(int index, int l, int r, int left, int right){
        if(l >= left && r <= right)
            return this.treeArray[index];

        if(l > right || r < left)
            return Integer.MAX_VALUE;

        int mid = left+right;
        mid/=2;
        int _left = querry(index*2+1, l, r, left, mid);
        int _right = querry(index*2+2, l, r, mid+1, right);
        return Math.min(_left, _right);
    }
}

public class SegmentTree {
    public static void main(String[] args) {
        int [] arr = {2, 3, 4, 5, 1};
        Tree tree1 = new Tree(arr);
        System.out.println(tree1.treeArray[0]);
        System.out.println(tree1.querry(0, 1,3,0,arr.length-1));
    }
}
