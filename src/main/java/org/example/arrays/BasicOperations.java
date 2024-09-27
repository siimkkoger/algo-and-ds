package org.example.arrays;

import static org.example.TimeMeasurementUtil.measureExecutionTimeAndPrint;

import java.util.Arrays;
import java.util.Random;

public class BasicOperations {

	public static void main(String[] args) {

		// insertion
		Integer[] arr_insertion = { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(insert(arr_insertion, 2, 6)));
		String[] arr_insertion_2 = { "a", "b", "c", "d", "e" };
		System.out.println(Arrays.toString(insert(arr_insertion_2, 3, "f")));

		// insertion 2
		Integer[] arr_insertion_3 = { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(insert2(arr_insertion_3, 2, 6)));
		String[] arr_insertion_4 = { "a", "b", "c", "d", "e" };
		System.out.println(Arrays.toString(insert2(arr_insertion_4, 3, "f")));

		// deletion
		Integer[] arr_del_1 = { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(delete(arr_del_1, 2)));
		String[] arr_del_2 = { "a", "b", "c", "d", "e" };
		System.out.println(Arrays.toString(delete(arr_del_2, 3)));

		// deletion 2
		Integer[] arr_del_3 = { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(delete2(arr_del_3, 2)));
		String[] arr_del_4 = { "a", "b", "c", "d", "e" };
		System.out.println(Arrays.toString(delete2(arr_del_4, 3)));

		// search
		Integer[] arr_search = { 1, 2, 3, 4, 5 };
		System.out.println(search(arr_search, 2));
		String[] arr_search_2 = { "a", "b", "c", "d", "e" };
		System.out.println(search(arr_search_2, 3));

		// search by value return index
		Integer[] arr_search_by_value_return_index = { 1, 2, 3, 4, 5 };
		System.out.println(searchByValueReturnIndex(arr_search_by_value_return_index, 2));
		String[] arr_search_by_value_return_index_2 = { "a", "b", "c", "d", "e" };
		System.out.println(searchByValueReturnIndex(arr_search_by_value_return_index_2, "d"));

		// measure execution time between loop and arrayCopy - insertion
		measureExecutionTimeAndPrint(() -> {
			Random random = new Random();
			int arraySize = 100000;
			Integer[] arr = new Integer[arraySize];

			// Fill array with random numbers between 1 and 100
			for (int i = 0; i < arraySize; i++) {
				arr[i] = random.nextInt(100) + 1;
			}

			// Generate random index and value for insertion
			int randomIndex = random.nextInt(arraySize + 1);
			int randomValue = random.nextInt(100) + 1;

			// Perform insertion
			arr = insert(arr, randomIndex, randomValue);
			for (int i = 0; i < 1000; i++) {
				arr = insert(arr, randomIndex, randomValue);
			}

			System.out.println("Inserted " + randomValue + " at index " + randomIndex);
			System.out.println("First 10 elements: " + Arrays.toString(Arrays.copyOf(arr, 10)) + "...");

			return arr;
		});

		// measure execution time between loop and arrayCopy - insertion 2
		measureExecutionTimeAndPrint(() -> {
			Random random = new Random();
			int arraySize = 100000;
			Integer[] arr = new Integer[arraySize];

			// Fill array with random numbers between 1 and 100
			for (int i = 0; i < arraySize; i++) {
				arr[i] = random.nextInt(100) + 1;
			}

			// Generate random index and value for insertion
			int randomIndex = random.nextInt(arraySize + 1);
			int randomValue = random.nextInt(100) + 1;

			// Perform insertion
			arr = insert2(arr, randomIndex, randomValue);
			for (int i = 0; i < 1000; i++) {
				arr = insert2(arr, randomIndex, randomValue);
			}

			System.out.println("Inserted " + randomValue + " at index " + randomIndex);
			System.out.println("First 10 elements: " + Arrays.toString(Arrays.copyOf(arr, 10)) + "...");

			return arr;
		});
	}

	public static <T> T[] insert(T[] arr, int index, T element) {
		if (index < 0 || index > arr.length) {
			throw new ArrayIndexOutOfBoundsException("Index " + index + " is out of bounds!");
		}
		T[] newArr = Arrays.copyOf(arr, arr.length + 1);
		System.arraycopy(arr, 0, newArr, 0, index);
		newArr[index] = element;
		System.arraycopy(arr, index, newArr, index + 1, arr.length - index);
		return newArr;
	}

	public static <T> T[] insert2(T[] arr, int index, T element) {
		if (index < 0 || index > arr.length) {
			throw new ArrayIndexOutOfBoundsException("Index " + index + " is out of bounds!");
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

	public static <T> T[] delete(T[] arr, int index) {
		if (index < 0 || index >= arr.length) {
			throw new ArrayIndexOutOfBoundsException("Index " + index + " is out of bounds!");
		}
		T[] newArr = Arrays.copyOf(arr, arr.length - 1);
		System.arraycopy(arr, 0, newArr, 0, index);
		System.arraycopy(arr, index + 1, newArr, index, arr.length - index - 1);
		return newArr;
	}

	public static <T> T[] delete2(T[] arr, int index) {
		if (index < 0 || index >= arr.length) {
			throw new ArrayIndexOutOfBoundsException("Index " + index + " is out of bounds!");
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
