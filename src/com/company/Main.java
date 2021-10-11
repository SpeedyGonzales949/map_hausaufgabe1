package com.company;


import java.util.Random;

public class Main {

    public static void main(String[] args) {
    	System.out.println("---ex1---");
    	Noten n=new Noten();
    	int[] noten={10,20,84,30,40,50,60,62,64,72,76};
		n.print_noten(noten);

		//a

		System.out.println("Failed Marks:");
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
		b.setNr1(new int[]{1, 3, 8, 0,0});
		b.setNr2(new int []{1, 6, 9, 0, 0});
		b.print_num(b.sum());
		b.print_num(b.dif());
		b.print_num(b.mul(4));
		b.print_num(b.div(2));


		System.out.println("---ex4---");
		ElektronikShop shop =new ElektronikShop();
		System.out.println(shop.cheap_keyboard());
		shop.expansive_item();
		shop.expansive_usb(10);
		shop.max_items(300);
    }


}

