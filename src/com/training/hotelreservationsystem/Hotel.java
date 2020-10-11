package com.training.hotelreservationsystem;

public class Hotel {

	private String hotelName;
	private int WeekDay_rate;
	private int special_WeekDay_rate;
	private int WeekEnd_rate;
	private int special_WeekEnd_rate;
	private int ratings;

	Hotel(String hotelName, int WeekDay_rate, int WeekEnd_rate, int ratings, int special_WeekDay_rate,
			int special_WeekEnd_rate) {
		this.setHotelName(hotelName);
		this.setWeekDay_rate(WeekDay_rate);
		this.setWeekEnd_Rate(WeekEnd_rate);
		this.setRatings(ratings);
		this.setSpecial_WeekDay_rate(special_WeekDay_rate);
		this.setSpecial_WeekEnd_rate(special_WeekEnd_rate);
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

	public int getRatings() {
		return ratings;
	}

	public void setRatings(int ratings) {
		this.ratings = ratings;
	}

	public int getSpecial_WeekDay_rate() {
		return special_WeekDay_rate;
	}

	public void setSpecial_WeekDay_rate(int special_WeekDay_rate) {
		this.special_WeekDay_rate = special_WeekDay_rate;
	}

	public int getSpecial_WeekEnd_rate() {
		return special_WeekEnd_rate;
	}

	public void setSpecial_WeekEnd_rate(int special_WeekEnd_rate) {
		this.special_WeekEnd_rate = special_WeekEnd_rate;
	}

}