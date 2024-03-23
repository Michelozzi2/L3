package com.example;


public class App {

	public static int calculsX(int x){
		if (x < 0) 
			x = -x;
		else 
			x -= 1;
		if (x == 2) 
			x = 1;
		else 
			x += 2;
		return x;
		}

        public static void main(String[] args) {
            System.out.println("CalculsX pour -5: " + calculsX(-5));
            System.out.println("CalculsX pour 0: " + calculsX(0));
            System.out.println("CalculsX pour 2: " + calculsX(2));
            System.out.println("CalculsX pour 5: " + calculsX(5));
        }
	
}