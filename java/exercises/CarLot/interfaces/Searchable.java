package com.skillstorm.assignments.week5.car_lot.interfaces;
import java.util.List;

/*
 * The functional interface filters a list of elements matching the keyword
 */
@FunctionalInterface
public interface Searchable<T> {
	public List<T> filter(String keyword);
}
