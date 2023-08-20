import java.util.*;
import java.lang.*;

public class Trie {
    public static class Node{
        boolean end;
        Node [] children;

        Node(){
            this.end = false;
            this.children = new Node[26];
        }
    }

    public static Node root;

    public static void init(){
        root = new Node();
    }

    public static void insert(String str){
        Node temp = root;

        for(char _ch : str.toCharArray()){
            int ch = _ch-'a';
            if(temp.children[ch] == null){
                temp.children[ch] = new Node();
            }
            temp = temp.children[ch];
        }
        temp.end = true;
    }

    public static boolean search(String str){
        Node temp = root;

        for(char _ch : str.toCharArray()){
            int ch = _ch - 'a';
            if(temp.children[ch] == null)   return false;

            temp = temp.children[ch];
        }
        return (temp.end) ? true : false;
    }

    public static void main(String [] args){
        init();
        insert("word");
        insert("break");
        System.out.println(search("breal"));
    }
}
