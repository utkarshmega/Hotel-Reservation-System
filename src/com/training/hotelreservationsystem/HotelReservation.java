package com.training.hotelreservationsystem;

import java.util.*;

public class HotelReservation {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ArrayList<Hotel> hotel = new ArrayList<>();

		while (true) {

			System.out.println("Enter hotel name");
			String hotel_name = sc.next();
			System.out.println("Enter rate for regular customer");
			int rate = sc.nextInt();

			hotel.add(new Hotel(hotel_name, rate));
			System.out.println("To add more hotel Y/N");
			char choice = sc.next().charAt(0);
			if (choice == 'Y' || choice == 'y')
				continue;
			else
				break;
		}

	}

}
