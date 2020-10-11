package com.training.hotelreservationsystem;

public class Hotel {

	private String hotelName;
	private int WeekDay_rate;
	private int WeekEnd_rate;

	Hotel(String hotelName, int WeekDay_rate, int WeekEnd_rate) {
		this.setHotelName(hotelName);
		this.setWeekDay_rate(WeekDay_rate);
		this.setWeekEnd_Rate(WeekEnd_rate);
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getWeekEnd_Rate() {
		return WeekEnd_rate;
	}

	public void setWeekEnd_Rate(int WeekEnd_rate) {
		this.WeekEnd_rate = WeekEnd_rate;
	}

	public int getWeekDay_rate() {
		return WeekDay_rate;
	}

	public void setWeekDay_rate(int weekDay_rate) {
		WeekDay_rate = weekDay_rate;
	}

}