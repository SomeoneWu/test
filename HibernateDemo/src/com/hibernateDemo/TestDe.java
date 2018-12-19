package com.hibernateDemo;

import java.util.Scanner;

public class TestDe {

	public static void main(String[] args) {
		int x , y;
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("X:");
		x = scan.nextInt();
		System.out.println("Y:");
		y = scan.nextInt();
		
		TestDe te = new TestDe();
		
		System.out.println(te.function(x, y));
		
	}
	
	public char function(int x , int y) {
		char t;
		
		if((x >= 90) && (y >= 90 )){
			t = 'A';
		}else {
			if((x + y) >= 165) {
				t = 'B';
			}else {
				t = 'C';
			}
		}
		return t;
	}

}
