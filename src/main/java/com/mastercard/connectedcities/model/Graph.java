package com.mastercard.connectedcities.model;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * This class simulates Graph funcationaliy
 * 
 * @author kapur
 *
 */
public class Graph {

	private LinkedList<String>[] graphArrayOfList;

	public Graph(int n) {

		graphArrayOfList = new LinkedList[n];

		for (int i = 0; i < graphArrayOfList.length; i++) {

			graphArrayOfList[i] = new LinkedList<String>();

		}
	}

	public LinkedList<String>[] getGraphArrayOfList() {
		return graphArrayOfList;
	}

	public void setGraphArrayOfList(LinkedList<String>[] graphArrayOfList) {
		this.graphArrayOfList = graphArrayOfList;
	}

	// adds edge to the graph
	public void addEdge(int n, String city) {
		graphArrayOfList[n].add(city);
	}

	// removes edge to the graph
	public void removeEdge(int n, String city) {
		graphArrayOfList[n].remove(city);
	}

	// adds edge before certain point in graph
	public void addEdgeBeforeIndex(int n, String city, int index) {
		graphArrayOfList[n].add(index, city);
	}

	// checks if given city is connected in the graph.
	public boolean isConnected(int n, String city) {
		LinkedList<String> edgeList = graphArrayOfList[n];
		for (String e : edgeList) {
			if (e.equalsIgnoreCase(city)) {
				return true;
			}
		}
		return false;
	}

	// gets index of city in linkedlist in a graph
	public int getIndex(int n, String city) {
		return graphArrayOfList[n].indexOf(city);
	}

	@Override
	public String toString() {
		return "Graph [graphArrayOfList=" + Arrays.toString(graphArrayOfList) + ", toString()=" + super.toString()
				+ "]";
	}

}
