package com.mastercard.connectedcities.model;

/**
 * to hold the list from file
 * 
 * @author kapur
 *
 */
public class Cities {

	private String source;
	private String destination;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "ConnectedCities [source=" + source + ", destination=" + destination + "]";
	}

}
