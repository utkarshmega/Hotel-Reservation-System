package com.training.hotelreservationsystem;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class HotelReservationMethods {
	
	static ArrayList<Hotel> hotel = new ArrayList<>();
	
	public static void addHotel(String hotel_name, int rate)
	{
		hotel.add(new Hotel(hotel_name, rate));
	}
	
	/**
	 * To find the hotel with cheapest rate
	 */
	public static void findCheapestHotel(String startDate, String lastDate)
	{
		LocalDate entryDate = LocalDate.parse(startDate);
		LocalDate exitDate = LocalDate.parse(lastDate);
		
		Period diff = Period.between(entryDate, exitDate);
		int difference = diff.getDays();
		System.out.println(difference);
		int minimumRate = Integer.MAX_VALUE;
		String hotelName = "";
		for(Hotel hotelList : hotel)
		{
			int temp = hotelList.getRate() * difference;
			if(temp < minimumRate) {
				minimumRate = temp;
				hotelName = hotelList.getHotelName();
			}
		}
		System.out.println("Cheapest Hotel : "+hotelName);
		System.out.println("Minimum rate: "+minimumRate);
	}

}
