package com.company;

import java.util.Random;

public class Array {
    private int[] array;

/*
pre:int
desc: bastelt den Array mit random naturliche Zahlen
 */
    public void generate(int n){
        if(n<1)
            return;
        array=new int[n];
        Random r=new Random();
        for(int i=0;i<n;i++){
            array[i]=r.nextInt(100);//bildet ein Array mit random Zahlen bis 100, wobei n ist die Lange der Array
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
        int min=101; //101=INT_MAX, weil Zahlen nicht grosser als 100 sind.
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
        //alle zahlen, die verschieden von min sind, werden addiert. Falls mehrere Zahlen gleich mit min sind, nur eine wird nicht addiert
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
        //alle zahlen, die verschieden von max sind, werden addiert. Falls mehrere Zahlen gleich mit max sind, nur eine wird nicht addiert
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
