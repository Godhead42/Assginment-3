package org.example;

import java.util.ArrayList;

public class Cart {
    private static ArrayList<Electronics> cart = new ArrayList<Electronics>();
    private User user;

    public static void getCart() {
        for (int i=0; i < cart.size();i++){
            System.out.println(cart.get(i).toString());
        }
    }

    public void addCart(Electronics item) {
        cart.add(item);
    }

    public Cart(User user) {
        this.user = user;
    }
    public static void getsCart(){
        for(int i = 0;i< cart.size();i++){
            System.out.println(cart.get(i).toString());
        }
    }
    @Override
    public String toString() {
        int totalprice= 0;
        String string = "This is " + user.getUsername() + "'s cart:";
        if(cart != null){
            for(int i = 0;i< cart.size();i++){
                string = cart.get(i).toString();
                totalprice += cart.get(i).getElectronicPrice();
            }
        }else{
            string = "cart is empty!";
        }
        System.out.println("Total price:" + totalprice);
        return string;
    }
}
