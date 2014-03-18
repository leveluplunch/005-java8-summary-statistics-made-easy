package com.levelup;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import com.google.common.math.DoubleMath;

/**
 * This java class is used with a screen cast 005
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/tutorials/005-java8-summary-statistics-made-easy/'>Summary statistics made easy</a>
 */
public class SummaryStatistics {

	private static List<Double> numbers = new ArrayList<Double>();

	@Before
	public void setup() {
		numbers.add(new Double(10));
		numbers.add(new Double(10));
		numbers.add(new Double(10));
		numbers.add(new Double(10));
		numbers.add(new Double(10));
		numbers.add(new Double(10));
		numbers.add(new Double(10));
		numbers.add(new Double(10));
		numbers.add(new Double(10));
		numbers.add(new Double(10));
	}

	@Test
	public void average_with_java() {

		Double sum = 0d;
		for (Double vals : numbers) {
			sum += vals;
		}

		sum = sum / numbers.size();

		assertEquals(new Double(10), sum);
	}

	@Test
	public void average_with_guava() {

		double average = DoubleMath.mean(numbers);
		assertEquals(10, average, 0);
	}

	@Test
	public void stats_with_java8() {

		OptionalDouble average = numbers.stream()
				.mapToDouble(Double::doubleValue).average();

		System.out.println(average.getAsDouble());

		OptionalDouble min = numbers.stream().mapToDouble(Double::doubleValue)
				.min();

		System.out.println(min);
	}

	@Test
	public void stats_with_java8_reduce() {

		Optional<Double> sum = numbers.stream().reduce((a, b) -> a + b);

		System.out.println(sum);
	}

	@Test
	public void statis_with_java8_reduction_target() {

		DoubleSummaryStatistics stats = numbers.stream().collect(
				Collectors.summarizingDouble(Double::doubleValue));

		System.out.println(stats);


	}

}
