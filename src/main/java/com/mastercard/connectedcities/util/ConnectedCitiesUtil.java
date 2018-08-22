package com.mastercard.connectedcities.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;

import com.mastercard.connectedcities.model.Cities;

public final class ConnectedCitiesUtil {

	private ConnectedCitiesUtil() {

	}

	public static List<Cities> readFile() throws FileNotFoundException, IOException {
		List<Cities> ccList = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(
				new FileReader(new File(new ClassPathResource("city.txt").getURI())))) {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				String temp[] = line.split(",");
				Cities cc = new Cities();
				cc.setSource(temp[0]);
				cc.setDestination(temp[1]);
				ccList.add(cc);
				line = br.readLine();
			}
		}
		return ccList;
	}
}
