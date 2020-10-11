package com.training.hotelreservationsystem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class HotelReservationMethods {

	static ArrayList<Hotel> hotel = new ArrayList<>();

	public static void addHotel(String hotel_name, int weekDayrate, int weekEndrate, int hotelRating,
			int special_WeekDay_rate, int special_WeekEnd_rate) {
		hotel.add(new Hotel(hotel_name, weekDayrate, weekEndrate, hotelRating, special_WeekDay_rate,
				special_WeekEnd_rate));
	}

	/**
	 * To find the hotel with cheapest rate
	 */
	public static void findCheapestHotel(String startDate, String lastDate) {
		LocalDate entryDate = LocalDate.parse(startDate);
		LocalDate exitDate = LocalDate.parse(lastDate);

		int weekEndDays = 0, weekDays = 0;

		int minimumRate = Integer.MAX_VALUE;

		for (LocalDate date = entryDate; date.isBefore(exitDate); date = date.plusDays(1)) {
			int day = date.getDayOfWeek().getValue();
			if (day == 6 || day == 7) {
				weekEndDays++;
			} else
				weekDays++;
		}
		if (exitDate.getDayOfWeek().getValue() == 6 || exitDate.getDayOfWeek().getValue() == 7)
			weekEndDays++;
		else
			weekDays++;

		ArrayList<Hotel> cheapestHotel = new ArrayList<>();
		for (Hotel hotelList : hotel) {
			int temp = (hotelList.getWeekDay_rate() * weekDays) + (hotelList.getWeekEnd_Rate() * weekEndDays);
			if (temp < minimumRate) {
				minimumRate = temp;
				cheapestHotel.clear();
				cheapestHotel.add(hotelList);
			} else if (temp == minimumRate) {
				cheapestHotel.add(hotelList);
			}
		}
		int maxRating = 0;
		String hotelName = "";
		for (Hotel printCheapestHotel : cheapestHotel) {
			if (printCheapestHotel.getRatings() > maxRating) {
				maxRating = printCheapestHotel.getRatings();
				hotelName = printCheapestHotel.getHotelName();
			}
		}
		System.out.println("Cheapest Best Rated hotel is \n" + hotelName);
		System.out.println("Rating : " + maxRating);
		System.out.println("Total cost : " + minimumRate);

	}

	/**
	 * find best rated hotel for regular customers
	 */
	public static void findBestRatedHotel(String startDate, String lastDate) {
		LocalDate entryDate = LocalDate.parse(startDate);
		LocalDate exitDate = LocalDate.parse(lastDate);

		int weekEndDays = 0, weekDays = 0;

		for (LocalDate date = entryDate; date.isBefore(exitDate); date = date.plusDays(1)) {
			int day = date.getDayOfWeek().getValue();
			if (day == 6 || day == 7) {
				weekEndDays++;
			} else
				weekDays++;
		}
		if (exitDate.getDayOfWeek().getValue() == 6 || exitDate.getDayOfWeek().getValue() == 7)
			weekEndDays++;
		else
			weekDays++;

		String hotelName = "";
		int tempRating = 0, cost = 0;
		for (Hotel hotelList : hotel) {

			if (hotelList.getRatings() > tempRating) {
				cost = (hotelList.getWeekDay_rate() * weekDays) + (hotelList.getWeekEnd_Rate() * weekEndDays);
				hotelName = hotelList.getHotelName();
				tempRating = hotelList.getRatings();
			}
		}
		System.out.println("Best Rated hotel is \n" + hotelName);
		System.out.println("Rating : " + tempRating);
		System.out.println("Total cost : " + cost);

	}

	/**
	 * to find the cheapest hotel for rewarded customers
	 */
	public static void findCheapestHotelForRewardedCustomers(String startDate, String lastDate) {
		LocalDate entryDate = LocalDate.parse(startDate);
		LocalDate exitDate = LocalDate.parse(lastDate);

		int weekEndDays = 0, weekDays = 0;

		int minimumRate = Integer.MAX_VALUE;

		for (LocalDate date = entryDate; date.isBefore(exitDate); date = date.plusDays(1)) {
			int day = date.getDayOfWeek().getValue();
			if (day == 6 || day == 7) {
				weekEndDays++;
			} else
				weekDays++;
		}
		if (exitDate.getDayOfWeek().getValue() == 6 || exitDate.getDayOfWeek().getValue() == 7)
			weekEndDays++;
		else
			weekDays++;

		ArrayList<Hotel> cheapestHotel = new ArrayList<>();
		for (Hotel hotelList : hotel) {
			int temp = (hotelList.getSpecial_WeekDay_rate() * weekDays)
					+ (hotelList.getSpecial_WeekEnd_rate() * weekEndDays);
			if (temp < minimumRate) {
				minimumRate = temp;
				cheapestHotel.clear();
				cheapestHotel.add(hotelList);
			} else if (temp == minimumRate) {
				cheapestHotel.add(hotelList);
			}
		}
		int maxRating = 0;
		String hotelName = "";
		for (Hotel printCheapestHotel : cheapestHotel) {
			if (printCheapestHotel.getRatings() > maxRating) {
				maxRating = printCheapestHotel.getRatings();
				hotelName = printCheapestHotel.getHotelName();
			}
		}
		System.out.println("Cheapest Best Rated hotel for rewarded customer is \n" + hotelName);
		System.out.println("Rating : " + maxRating);
		System.out.println("Total cost : " + minimumRate);

	}

	/**
	 * to calculate the total cost of the hotel within the given date range
	 */
	public static int totalCost(Hotel h, LocalDate start, LocalDate end) {
		int weekEndDays = 0, weekDays = 0;

		for (LocalDate date = start; date.isBefore(end); date = date.plusDays(1)) {
			int day = date.getDayOfWeek().getValue();
			if (day == 6 || day == 7) {
				weekEndDays++;
			} else
				weekDays++;
		}
		if (end.getDayOfWeek().getValue() == 6 || end.getDayOfWeek().getValue() == 7)
			weekEndDays++;
		else
			weekDays++;

		int temp = (h.getSpecial_WeekDay_rate() * weekDays) + (h.getSpecial_WeekEnd_rate() * weekEndDays);
		return temp;
	}

	/**
	 * to find the cheapest best rated hotel for rewarded customer using java streams
	 */
	public static void findBestRatedForRewardedUsingStream(String startDate, String lastDate) {
		LocalDate entryDate = LocalDate.parse(startDate);
		LocalDate exitDate = LocalDate.parse(lastDate);

		int cost = hotel.stream().map(h -> totalCost(h, entryDate, exitDate)).min(Integer::compare).get();
		ArrayList<Hotel> tempList = (ArrayList<Hotel>) hotel.stream()
				.filter(h -> totalCost(h, entryDate, exitDate) == cost).collect(Collectors.toList());
		
		Hotel maxRatedHotel = tempList.stream().max((h1,h2) -> h1.getRatings() - h2.getRatings()).get();
		String hotelName = maxRatedHotel.getHotelName();
		int maxRating = maxRatedHotel.getRatings();
		System.out.println("\nThe cheapest best rated hotel for rewarded customer using javaa streams is ");
		System.out.println("Hotel name" +hotelName);
		System.out.println("Rating : " +maxRating);
		System.out.println("Total Cost = " +cost);		
	}

}
