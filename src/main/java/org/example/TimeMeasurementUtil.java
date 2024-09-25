package org.example;

import java.util.function.Supplier;

public class TimeMeasurementUtil {

	public static <T> long measureExecutionTime(Supplier<T> function) {
		long startTime = System.nanoTime();
		function.get();
		long endTime = System.nanoTime();
		return endTime - startTime;
	}

	public static <T> long measureExecutionTimeAndPrint(Supplier<T> function) {
		long startTime = System.nanoTime();
		function.get();
		long endTime = System.nanoTime();
		long time_taken = endTime - startTime;
		System.out.println("Time taken: " + time_taken + " ns\n" + "Time taken: " + time_taken / 1000000 + " ms");
		return time_taken;
	}
}
