package com.training.hotelreservationsystem;

import java.util.*;

public class HotelReservation {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("Enter hotel name");
			String hotel_name = sc.next();
			System.out.println("Enter week day rate for regular customer");
			int weekDayrate = sc.nextInt();
			System.out.println("Enter week end rate for regular customer");
			int weekEndrate = sc.nextInt();
			System.out.println("Enter the hotel rating from 1-5");
			int hotelRating = sc.nextInt();

			HotelReservationMethods.addHotel(hotel_name, weekDayrate, weekEndrate, hotelRating);
			System.out.println("To add more hotel Y/N");
			char choice = sc.next().charAt(0);
			if (choice == 'Y' || choice == 'y')
				continue;
			else
				break;
		}

		System.out.println("Find the cheapest hotel within given date range");
		System.out.println("Enter start date in format YYYY-MM-DD");
		String startDate = sc.next();
		System.out.println("Enter last date in format YYYY-MM-DD");
		String lastDate = sc.next();
		HotelReservationMethods.findCheapestHotel(startDate, lastDate);
		HotelReservationMethods.findBestRatedHotel(startDate, lastDate);

	}

}
