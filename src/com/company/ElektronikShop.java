package com.company;

import java.util.Random;

public class ElektronikShop {
    private Item [] items;


    public ElektronikShop(){
        this.generate();
    }
    /*
    desc:bildet den Shop mit random Produkte
     */
    private void generate(){
      Random r =new Random();
      int nr=r.nextInt(100);
      items=new Item[nr];
      for(int i=0;i<nr;i++){//bei jede Iteration wird eine Tastatur oder ein Usb mit einem random Kosten im Shop hinzugefugt
          if(r.nextBoolean()){
              Tastatur t=new Tastatur("Samsung",r.nextInt(1000),"DE");
              items[i]=t;
          }
          else{
              USB u =new USB("Apple",r.nextInt(50),"C");
              items[i]=u;
          }
      }
    }
    /*
    post: int
    desc: gibt zuruck das Kosten der billigsten Tastaur
     */
    public int cheap_keyboard(){
        int price=9999;
        for (Item item : items) {//wir iterieren durch den ganzen Shop um die billigste Tastatur zu finden
            if (item instanceof Tastatur) {
                if (item.getPrice() < price)
                    price = item.getPrice();
            }
        }
    return price;
    }
    /*
    desc:zeigt auf dem Bildshirm das teuerste Produkt
     */
    public void expansive_item(){
        Item item=this.items[0];
        for (Item it:this.items//wir iteriren durch den ganzen Shop um den teuerste Produkt zu finden
             ) {
            if(item.getPrice()<it.getPrice()){
                item=it;
            }
        }
        item.print_item();
    }

    /*
    pre:int
    desc:zeigt auf den Bildshirm das teuerste USB ,das sich in einem Budget befindet
     */
    public void expansive_usb(int budget){
        Item item = null;
        for (Item it:this.items//wir iteriren durch den ganzen Shop um den teuerste Usb zu finden
             ) {
            if(it instanceof USB && it.getPrice()<=budget && (item==null ||  it.getPrice()>item.getPrice())){
                item=it;

            }
        }
        if(item==null)
            System.out.println("Budget too low");
        else
            item.print_item();
    }

    /*
    pre:int
    desc: zeigt auf dem Bildshirm den maximalen Geldbetrag, anhand einer Budget und der Preislisten für die Tastaturen und USB-Laufwerke
     */
    public int max_items(int budget){
        Item x=null,y=null;
        int price=0;
        for(Item it1:this.items)//wir iteriren durch die Produkte n^2,wobei n die Anzahl der Produkte ist, um die Beste Moglichkeit zu finden
            if(it1 instanceof Tastatur)
                for(Item it2:this.items)
                    if(it2 instanceof USB){
                        if(it1.getPrice()+it2.getPrice()<=budget)
                            if (x==null  || it1.getPrice()+it2.getPrice()>=price ){
                                x=it1;
                                y=it2;
                                price=it1.getPrice()+it2.getPrice();
                        }
                    }
        if(x!=null){
            x.print_item(); y.print_item();
            return 1;//1 fur korrekte Finden der zwei Produkte
        }
        else
            return -1;//-1 wenn keine zwei Produkte den budget entsprechen

    }
}


abstract class Item{//base class fur die Produkte, ich benutze diese, damit ich ein Array von alle Produkte im Shop habe

    private String brand;
    private int price;
    public  Item(String brand,int price){
        this.brand=brand;
        this.price=price;
    }

    public int getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    abstract void print_item();

}

//Tastatur-Produkt
class Tastatur extends Item{
    private String language;

    public Tastatur(String brand, int price,String language) {
        super(brand, price);
        this.language=language;
    }

    @Override
    void print_item() {
        System.out.println("Tastaur "+this.getBrand()+" "+this.getPrice());
    }
}
//USB-Produkt
class USB extends Item{
    String type;
    public USB(String brand, int price,String type) {
        super(brand, price);
        this.type=type;
    }

    public String getType() {
        return type;
    }

    @Override
    void print_item() {
        System.out.println("USB "+this.type+" "+this.getPrice());
    }
}
