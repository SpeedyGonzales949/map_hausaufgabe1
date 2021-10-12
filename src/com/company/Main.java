package com.company;



public class Main {

    public static void main(String[] args) {
    	System.out.println("---ex1---");
    	Noten n=new Noten();
    	int[] noten={10,20,84,30,40,50,60,62,64,72,76};
		n.print_noten(noten);

		//a
		n.print_noten(n.exam(noten));

		//b
		System.out.println("Average Mark: "+n.average(noten));

		//c
		n.print_noten(n.round(noten));

		//d
		System.out.println(n.max_round(noten));


		System.out.println("---ex2---");
		Array a =new Array();
		a.generate(5);
		System.out.println(a.max());
		System.out.println(a.min());
		System.out.println(a.max_sum());
		System.out.println(a.min_sum());

		System.out.println("---ex3---");
		Big_Num b=new Big_Num();
		b.setNr1(new int[]{9, 0, 0, 0,0});
		b.setNr2(new int []{1, 1, 1, 1, 1});
		b.print_num(b.sum());
		b.print_num(b.dif());
		b.setNr2(new int[]{2});
		b.print_num(b.mul());
		b.setNr2(new int[]{5});
		b.print_num(b.div());


		System.out.println("---ex4---");
		ElektronikShop shop =new ElektronikShop();
		System.out.println(shop.cheap_keyboard());
		shop.expansive_item();
		shop.expansive_usb(10);
		shop.max_items(100);
    }


}

