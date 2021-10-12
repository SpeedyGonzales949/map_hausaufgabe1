package com.company;

public  class Noten{
    /*
pre:int []
post: int []
desc:zeigt alle Noten die die Prufung nicht gestanden haben
 */
    public int[] exam(int[] noten){
        System.out.print("Exam is on... ");
        for (int i=0;i<noten.length;i++)
            if(noten[i]>=40){//alle Noten uber 40 sind geloscht
                noten=removenote(noten,i);
                i--;
            }
        return noten;
    }
/*
pre:int []
post:int
desc:berechnet die Durchschnittsnote
 */

    public double average(int [] noten){
        int s=0;
        if(noten.length==0)
            return 0;
        for (int note:noten
        ) {
            s=s+note;//summe aller Noten


        }
        return s*1.0/noten.length;//arithmetische Mittel
    }

    /*
        pre:int []
        post:int []
        desc:rundet alle Noten
         */
    public int[] round(int [] noten){
        for (int i=0;i<noten.length;i++
        ) {
            if(noten[i]%10<5)
                noten[i]=noten[i]/10*10+5;
        }
        return noten;
    }

    /*
    pre:int []
    post:int
    desc:gibt zuruck die maximale gerundete Note
     */
    public int max_round(int [] noten){
        round(noten);
        int max=0;
        for (int note:noten
        ) {
            if(note>max)
                max=note;
        }
        return max;

    }
/*
pre:int[]
post:int[]
desc:removes an element from an array
 */
    public  int[] removenote(int[] arr,
                             int index)
    {
        if (arr == null
                || index < 0
                || index >= arr.length) {

            return arr;//falls array leer ist oder die Position nicht richtig ist, den Array wird zuruckgeliefert
        }
        int[] anotherArray = new int[arr.length - 1];
        System.arraycopy(arr, 0, anotherArray, 0, index);//loschen des Elementes
        System.arraycopy(arr, index + 1,anotherArray, index, arr.length - index - 1);

        return anotherArray;
    }

    /*
    pre:int[]
    desc: zeigt auf dem Bildshirm alle Elemente des Arrays
     */
    public void print_noten(int[] noten){
        for (int j : noten) System.out.print(j + " ");
        System.out.println();
    }
}
