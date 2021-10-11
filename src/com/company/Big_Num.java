package com.company;

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
        for(int i= this.nr1.length-1;i>=0;i--){
            nr[i+1]=(this.nr1[i]+this.nr2[i]+x)%10;
            if(this.nr1[i]+this.nr2[i]+x>=10)
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
     */
    public int[] dif(){
        int carry=0;
        int[] nr3=new int[this.nr1.length];
        for(int i=this.nr1.length-1;i>=0;i--){
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
     */
    public int[] mul(int x){
        int carry =0;
        int[] nr=new int[this.nr1.length+1];

        for(int i=this.nr1.length-1;i>=0;i--){
            nr[i+1]=(this.nr1[i]*x+carry)%10;
            carry=(x*this.nr1[i])/10;
        }
        return nr;
    }
    /*
    pre:int[]
    post:int []
    desc:berechnet die Division einer grossen Zahl mit einem Ziffer
     */
    public int[] div(int x){
        int[] nr=new int[this.nr1.length];
        int carry=0;
        for(int i=0;i<this.nr1.length;i++){
            nr[i]=(carry*10+this.nr1[i])/x;
            carry=(carry*10+this.nr1[i])%x;

        }
        return nr;
    }
    public void print_num(int[] nr){
        for (int x:nr
        ) {
            System.out.print(x);
        }
        System.out.println();
    }
}
