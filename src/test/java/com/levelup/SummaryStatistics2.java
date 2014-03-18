package com.levelup;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

/**
 * This java class is used with a screen cast 005
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/tutorials/005-java8-summary-statistics-made-easy/'>Summary statistics made easy</a>
 */
public class SummaryStatistics2 {

	class Company {

		double revenue;

		public Company(double revenue) {
			super();
			this.revenue = revenue;
		}

		public double getRevenue() {
			return revenue;
		}
	}

	List<Company> companies;

	@Before
	public void setUp() {
		companies = new ArrayList<>();
		companies.add(new Company(100.12));
		companies.add(new Company(142.65));
		companies.add(new Company(12.1));
		companies.add(new Company(184.90));
	}

	@Test
	public void stats_with_java8() {

		DoubleSummaryStatistics stats = companies.stream().collect(
				Collectors.summarizingDouble(Company::getRevenue));

		System.out.println(stats);

		OptionalDouble average = companies.stream()
				.mapToDouble(Company::getRevenue).average();

		System.out.println(average);

	}

}
