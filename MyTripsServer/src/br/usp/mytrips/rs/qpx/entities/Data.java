package br.usp.mytrips.rs.qpx.entities;

import javax.ejb.Stateless;

@Stateless
public class Data {

	private String kind = "qpxexpress#data";
	private Airport[] airport;
	private City[] city;
	private Aircraft[] aircraft;
	private Tax[] tax;
	private Carrier[] carrier;
}
