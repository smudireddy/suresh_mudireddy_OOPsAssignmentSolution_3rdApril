package com.iitr.gl.fop.dsa;

public class ArrayUtility {
	
	int[] elements; 
	int size;

	public ArrayUtility(int[] array, int size) {
		elements = array;
		this.size = size;
	}
	
	public void displayElements() {
		
		System.out.println("\n");
		for (int i = 0; i < elements.length; i++) {
			System.out.print(elements[i] + " ");
		}
		System.out.println("\n");
	}
	
	private void merge(int left, int mid, int right) {
		
		int leftArrayLen = mid - left+1;
		int rightArrayLen = right - mid;
		
		int[] leftArray = new int[leftArrayLen];
		int[] rightArray = new int[rightArrayLen];
		
		for(int i = 0; i < leftArrayLen; i++) {
			leftArray[i] = elements[i+left];
		}
		
		for (int i = 0; i < rightArrayLen; i++) {
            rightArray[i] = elements[i + mid + 1];
		}
		
		int i = 0;
		int j = 0;
		int k = left -1;
		
		while(i < leftArrayLen && j < rightArrayLen) {
		
			if(leftArray[i] < rightArray[j]) {
				k++;
				elements[k] = leftArray[i];
				i++;
			}
			else {
				k++;
				elements[k] = rightArray[j];
				j++;
			}
		}
		
		while(i<leftArrayLen) {
			k++;
			elements[k] = leftArray[i];
			i++;
		}
		
		while(j<rightArrayLen) {
			k++;
			elements[k] = rightArray[j];
			j++;
		}
	}
	
	private void sortElements(int left, int right) {
		
		if(left < right) {
		 
			int mid = (left+right)/2;
			
			sortElements(left, mid);
			sortElements(mid+1, right);
			merge(left, mid, right);
		}
	}
	
	public void sort() {
		
		System.out.println("Sorting elements ......\n");
		sortElements(0, size-1);
	}
	
	public void rotateLeft(int numberOfTimes) {
		
		if(numberOfTimes == 0) {
			return;
		}
		
		int element = elements[0]; 
		
		int i=0;
		
		for( ;i<size-1; i++) {
			elements[i] = elements[i+1];
		}
		elements[i] = element;
		
		rotateLeft(numberOfTimes-1);
	}
	
	public int searchUsingKey(int key) {
		
		int pIndex = pivotIndex();
		
		if(elements[pIndex] == key) {
		   return pIndex;	
		}
		else if(elements[0] <= key){
			return searchElementInRotatedArray(key, 0, pIndex - 1);
		}
		else {
			return searchElementInRotatedArray(key, pIndex+1, size-1);	
		}
	}
	
	private int pivotIndex() {
		
		int index = 0;
		while(index < size && elements[index] < elements[index+1]) {
			index++;
		}
		return index+1;
	}
	
	private int searchElementInRotatedArray(int key, int left, int right) {
		
		if (left > right) {
		   return -1; 
		}
		
		int mid = (left + right) / 2;

		if (elements[mid] == key) {
			return mid;
		} else if (elements[mid] > key) {
			return searchElementInRotatedArray(key, left, mid - 1);
		} else {
			return searchElementInRotatedArray(key, mid + 1, right);
		}
	}
}
