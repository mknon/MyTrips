package br.usp.mytrips.rs.qpx.request;

import javax.ejb.Stateless;

@Stateless
public class Passenger {

	private String kind = "qpxexpress#passengerCounts";
	private Integer adultCount = null;
	private Integer childCount = null;;
	private Integer infantInLapCount = null;;
	private Integer infantInSeatCount = null;;
	private Integer seniorCount = null;
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public Integer getAdultCount() {
		return adultCount;
	}
	public void setAdultCount(Integer adultCount) {
		this.adultCount = adultCount;
	}
	public Integer getChildCount() {
		return childCount;
	}
	public void setChildCount(Integer childCount) {
		this.childCount = childCount;
	}
	public Integer getInfantInLapCount() {
		return infantInLapCount;
	}
	public void setInfantInLapCount(Integer infantInLapCount) {
		this.infantInLapCount = infantInLapCount;
	}
	public Integer getInfantInSeatCount() {
		return infantInSeatCount;
	}
	public void setInfantInSeatCount(Integer infantInSeatCount) {
		this.infantInSeatCount = infantInSeatCount;
	}
	public Integer getSeniorCount() {
		return seniorCount;
	}
	public void setSeniorCount(Integer seniorCount) {
		this.seniorCount = seniorCount;
	};
	
}
