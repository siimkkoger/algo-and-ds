package org.example.arrays;

import java.util.Arrays;

public class BasicOperations {

	public static final String INDEX_OUT_OF_BOUNDS_MESSAGE = "Index %d is out of bounds!";

	public static <T> T[] insert_withArrayCopy(T[] arr, int index, T element) {
		if (index < 0 || index > arr.length) {
			throw new ArrayIndexOutOfBoundsException(INDEX_OUT_OF_BOUNDS_MESSAGE.formatted(index));
		}
		T[] newArr = Arrays.copyOf(arr, arr.length + 1);
		System.arraycopy(arr, 0, newArr, 0, index);
		newArr[index] = element;
		System.arraycopy(arr, index, newArr, index + 1, arr.length - index);
		return newArr;
	}

	public static <T> T[] insert_withForLoop(T[] arr, int index, T element) {
		if (index < 0 || index > arr.length) {
			throw new ArrayIndexOutOfBoundsException(INDEX_OUT_OF_BOUNDS_MESSAGE.formatted(index));
		}
		T[] newArr = Arrays.copyOf(arr, arr.length + 1);
		for (int i = 0; i < arr.length + 1; i++) {
			if (i < index) {
				newArr[i] = arr[i];
			} else if (i == index) {
				newArr[i] = element;
			} else {
				newArr[i] = arr[i - 1];
			}
		}
		return newArr;
	}

	public static <T> T[] delete_withArrayCopy(T[] arr, int index) {
		if (index < 0 || index >= arr.length) {
			throw new ArrayIndexOutOfBoundsException(INDEX_OUT_OF_BOUNDS_MESSAGE.formatted(index));
		}
		T[] newArr = Arrays.copyOf(arr, arr.length - 1);
		System.arraycopy(arr, 0, newArr, 0, index);
		System.arraycopy(arr, index + 1, newArr, index, arr.length - index - 1);
		return newArr;
	}

	public static <T> T[] delete_withForLoop(T[] arr, int index) {
		if (index < 0 || index >= arr.length) {
			throw new ArrayIndexOutOfBoundsException(INDEX_OUT_OF_BOUNDS_MESSAGE.formatted(index));
		}
		T[] newArr = Arrays.copyOf(arr, arr.length - 1);
		for (int i = 0; i < arr.length; i++) {
			if (i < index) {
				newArr[i] = arr[i];
			} else if (i > index) {
				newArr[i - 1] = arr[i];
			}
		}
		return newArr;
	}

	public static <T> T search(T[] arr, int index) {
		return arr[index];
	}

	public static <T> int searchByValueReturnIndex(T[] arr, T value) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(value)) {
				return i;
			}
		}
		return -1;
	}
}
