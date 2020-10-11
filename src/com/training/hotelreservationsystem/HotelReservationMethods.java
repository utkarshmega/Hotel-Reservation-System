package com.training.hotelreservationsystem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class HotelReservationMethods {

	static ArrayList<Hotel> hotel = new ArrayList<>();

	public static void addHotel(String hotel_name, int weekDayrate, int weekEndrate, int hotelRating) {
		hotel.add(new Hotel(hotel_name, weekDayrate, weekEndrate, hotelRating));
	}

	/**
	 * To find the hotel with cheapest rate
	 */
	public static void findCheapestHotel(String startDate, String lastDate) {
		LocalDate entryDate = LocalDate.parse(startDate);
		LocalDate exitDate = LocalDate.parse(lastDate);

		int weekEndDays = 0, weekDays = 0;

		int minimumRate = Integer.MAX_VALUE;
		String hotelName = "";
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
			}
			else if(temp == minimumRate) {
				cheapestHotel.add(hotelList);
			}
		}
		for(Hotel printCheapestHotel : cheapestHotel) {
			System.out.println("Cheapest Hotel : " + printCheapestHotel.getHotelName());
			System.out.println("Minimum rate: " + minimumRate);
		}
	}

}
