package com.company;

import java.util.Arrays;

public class Big_Num {
    private int[] nr1,nr2;


    public void setNr1(int[] nr1) {
        this.nr1 = nr1;
    }

    public void setNr2(int[] nr2) {
        this.nr2 = nr2;
    }

    /*
    pre:int[]
    post:int []
    desc:berechnet die Summe zweier sehr grossen Zahlen
     */
    public int[]  sum(){
        int x=0;
        int[] nr =new int[this.nr1.length+1];
        for(int i= this.nr1.length-1;i>=0;i--){//wir addieren Ziffer mit Ziffer von Ende angefangen
            nr[i+1]=(this.nr1[i]+this.nr2[i]+x)%10;
            if(this.nr1[i]+this.nr2[i]+x>=10)//carry kann nur 0 oder 1 sein bei Addition
                x=1;
            else
                x=0;
        }
        if(x==1)
            nr[0]=1;
        return nr;

    }

    /*
    pre:int[]
    post:int []
    desc:berechnet die Differenz zweier sehr grossen Zahlen
    !zweite Zahl muss immer grosser sein!
     */
    public int[] dif(){
        for(int i=0;i<nr1.length;i++)//swap wenn zahl1 grosser als zahl2 ist
            if(this.nr1[i]>this.nr2[i]){
                int [] temp;
                temp=nr1;
                nr1=nr2;
                nr2=temp;
                break;
            }

        int carry=0;
        int[] nr3=new int[this.nr1.length];
        for(int i=this.nr1.length-1;i>=0;i--){ //wir subtrahieren Ziffer mit Ziffer von Ende angefangen
              nr3[i]=this.nr2[i]-this.nr1[i];
              if(nr3[i]<0){
                  nr3[i]+=10;
                  nr2[i-1]--;
              }


        }
       return nr3;
    }

    /*
    pre:int[]
    post:int []
    desc:berechnet die Multiplikation einer grossen Zahl mit einem Ziffer
    !eine Zahl muss immer nur eine Ziffer enthalten!
     */
    public int[] mul(){
        if(this.nr1.length!=1 && this.nr2.length!=1)
            return null;//falls keine Zahlen, aus eine enizige Ziffer gebildet, sind, wird null zuruckgeliefert
        for(int i=0;i<nr1.length;i++)
            if(this.nr1.length==1 && this.nr2.length!=1){
                int [] temp;
                temp=nr1;
                nr1=nr2;
                nr2=temp;
                break;
            }

        int carry =0;
        int[] nr=new int[this.nr1.length+1];//this.nr1.length+1 weil Ergebnis eine Ziffer  mehr haben kann

        for(int i=this.nr1.length-1;i>=0;i--){
            nr[i+1]=(this.nr1[i]*this.nr2[0]+carry)%10;
            carry=(this.nr2[0]*this.nr1[i])/10;
        }
        return nr;
    }
    /*
    pre:int[]
    post:int []
    desc:berechnet die Division einer grossen Zahl mit einem Ziffer
     !eine Zahl muss immer nur eine Ziffer enthalten!
     */
    public int[] div(){
        if((this.nr1[0]==0||this.nr2[0]==0)||(this.nr1.length!=1 && this.nr2.length!=1) )
            return null;//falls keine Zahlen, aus eine enizige Ziffer gebildet, sind, wird null zuruckgeliefert
        for(int i=0;i<nr1.length;i++)//swap wenn nr1 hat nur einen Ziffer und nr2 hat mehere, immer wird nr1 durch nr2 geteilt
            if(this.nr1.length==1 && this.nr2.length!=1){
                int [] temp;
                temp=nr1;
                nr1=nr2;
                nr2=temp;
                break;
            }

        int[] nr=new int[this.nr1.length];
        int carry=0;
        for(int i=0;i<this.nr1.length;i++){
            nr[i]=(carry*10+this.nr1[i])/this.nr2[0];
            carry=(carry*10+this.nr1[i])%this.nr2[0];

        }
        return nr;
    }
    /*
    pre:int[]
    desc: zeigt auf den Bildshirm die ganze Zahl
     */
    public void print_num(int[] nr){
        if(nr==null){
            System.out.println(Arrays.toString(nr));
            return;
        }

        for (int x:nr
        ) {
            System.out.print(x);
        }
        System.out.println();
    }
}
