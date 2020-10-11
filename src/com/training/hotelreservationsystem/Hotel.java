package com.training.hotelreservationsystem;

public class Hotel {

	private String hotelName;
	private int rate;

	Hotel(String hotelName, int rate) {
		this.setHotelName(hotelName);
		this.setRate(rate);
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

}