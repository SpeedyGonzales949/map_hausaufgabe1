package com.company;

import java.util.Random;

public class Array {
    private int[] array;

/*
pre:int
desc: bastelt den Array mit random naturliche Zahlen
 */
    public void generate(int n){
        array=new int[n];
        Random r=new Random();

        for(int i=0;i<n;i++){
            array[i]=r.nextInt(100);
            System.out.print(array[i]+" ");
        }
        System.out.println();

    }

/*
post: int
desc: gibt zuruck grosste Zahl im Array
 */
    public int max(){
        int max=0;
        for (int nr:this.array
             ) {
            if(max<nr)
                max=nr;
        }
        return max;
    }
/*
post:int
desc:gibt zuruck die kleinste Zahl im Array
 */
    public int min(){
        int min=101;
        for (int nr:this.array
        ) {
            if(min>nr)
                min=nr;
        }
        return min;
    }
/*
post:int
desc:gibt zuruck die grosste Summe von n-1 Zahlen, wobei n die lange der Zahlen ist
 */
    public int max_sum(){
        int x=min();
        int s=0;
        for (int nr:this.array
             ) {
            if(nr!=x || x==-1)
                s=s+nr;
            else{
                x=-1;
            }
        }
        return s;
    }
    /*
   post:int
   desc:gibt zuruck die kleinste Summe von n-1 Zahlen, wobei n die lange der Zahlen ist
    */
    public int min_sum(){
        int x=max();
        int s=0;
        for (int nr:this.array
        ) {
            if(nr!=x || x==-1)
                s=s+nr;
            else{
                x=-1;
            }
        }
        return s;
    }
}
