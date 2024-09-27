package org.example.arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.TimeMeasurementUtil.measureExecutionTime;

import java.util.Random;

import org.junit.jupiter.api.Test;

class BasicOperationsPerformanceTest {

	@Test
	void testInsertPerformance_arrayCopy_vs_forLoop() {
		final int ARRAY_SIZE = 100000;
		final int ITERATIONS = 100;

		long timeTakenWithArrayCopy = measureExecutionTime(() -> {
			var random = new Random();
			var arr = new Integer[ARRAY_SIZE];

			for (int i = 0; i < ARRAY_SIZE; i++) {
				arr[i] = random.nextInt(Integer.MAX_VALUE);
			}

			int randomIndex = random.nextInt(ARRAY_SIZE);
			int randomValue = random.nextInt(Integer.MAX_VALUE);
			arr = BasicOperations.insert_withArrayCopy(arr, randomIndex, randomValue);

			for (int i = 0; i < ITERATIONS; i++) {
				randomIndex = random.nextInt(ARRAY_SIZE);
				randomValue = random.nextInt(Integer.MAX_VALUE);
				arr = BasicOperations.insert_withArrayCopy(arr, randomIndex, randomValue);
			}

			return arr;
		});

		long timeTakenWithLoop = measureExecutionTime(() -> {
			var random = new Random();
			var arr = new Integer[ARRAY_SIZE];

			for (int i = 0; i < ARRAY_SIZE; i++) {
				arr[i] = random.nextInt(Integer.MAX_VALUE);
			}

			int randomIndex = random.nextInt(ARRAY_SIZE);
			int randomValue = random.nextInt(Integer.MAX_VALUE);
			arr = BasicOperations.insert_withForLoop(arr, randomIndex, randomValue);

			for (int i = 0; i < 100; i++) {
				randomIndex = random.nextInt(ARRAY_SIZE);
				randomValue = random.nextInt(Integer.MAX_VALUE);
				arr = BasicOperations.insert_withForLoop(arr, randomIndex, randomValue);
			}

			return arr;
		});

		System.out.println("Time taken with array copy: " + timeTakenWithArrayCopy / 1_000_000 + " ms\n"
				+ "Time taken with for loop: " + timeTakenWithLoop / 1_000_000 + " ms");
		assertThat(timeTakenWithArrayCopy).isLessThan(timeTakenWithLoop);
	}

	@Test
	void testDeletePerformance_arrayCopy_vs_forLoop() {
		final int ARRAY_SIZE = 100000;
		final int ITERATIONS = 100;

		long timeTakenWithArrayCopy = measureExecutionTime(() -> {
			var random = new Random();
			var arr = new Integer[ARRAY_SIZE];

			for (int i = 0; i < ARRAY_SIZE; i++) {
				arr[i] = random.nextInt(Integer.MAX_VALUE);
			}

			int randomIndex = random.nextInt(ARRAY_SIZE);
			arr = BasicOperations.delete_withArrayCopy(arr, randomIndex);

			for (int i = 0; i < ITERATIONS; i++) {
				randomIndex = random.nextInt(ARRAY_SIZE);
				BasicOperations.delete_withArrayCopy(arr, randomIndex);
			}

			return arr;
		});

		long timeTakenWithLoop = measureExecutionTime(() -> {
			var random = new Random();
			var arr = new Integer[ARRAY_SIZE];

			for (int i = 0; i < ARRAY_SIZE; i++) {
				arr[i] = random.nextInt(Integer.MAX_VALUE);
			}

			int randomIndex = random.nextInt(ARRAY_SIZE);
			arr = BasicOperations.delete_withForLoop(arr, randomIndex);

			for (int i = 0; i < ITERATIONS; i++) {
				randomIndex = random.nextInt(ARRAY_SIZE);
				BasicOperations.delete_withForLoop(arr, randomIndex);
			}

			return arr;
		});

		System.out.println("Time taken with array copy: " + timeTakenWithArrayCopy / 1_000_000 + " ms\n"
				+ "Time taken with for loop: " + timeTakenWithLoop / 1_000_000 + " ms");
		assertThat(timeTakenWithArrayCopy).isLessThan(timeTakenWithLoop);
	}
}
