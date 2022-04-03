package com.iitr.gl.fop.dsa;

import java.util.Scanner;

public class DriverClass {

	public DriverClass() {
		
	}

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int option = 0;
		

			System.out.println("Please eneter number of elements");

			int size = scanner.nextInt();

			System.out.println("Please eneter" + size + "elements");

			int[] elements = new int[size];

			for (int i = 0; i < size; i++) {
				elements[i] = scanner.nextInt();
			}

			ArrayUtility utility = new ArrayUtility(elements, size);
			utility.displayElements();

			utility.sort();
			utility.displayElements();

			System.out.println("Please eneter number of times to be rotated");
			int rotateCount = scanner.nextInt();

			utility.rotateLeft(rotateCount);
			utility.displayElements();

			do {
				System.out.println("Please eneter the key to search in the elements");
				int searchKey = scanner.nextInt();

				int matchIndex = utility.searchUsingKey(searchKey);
				if (matchIndex == -1) {
					System.out.println(searchKey + " Not found in elements");
				} else {
					System.out.println("Element " + searchKey + " found at position : " + (matchIndex + 1));
				}

				System.out.println("Do you want to continue [ No-0, Yes-1] ?");
				option = scanner.nextInt();

			}while(option != 0);
	}
}
