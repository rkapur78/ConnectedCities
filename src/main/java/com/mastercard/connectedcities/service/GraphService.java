package com.mastercard.connectedcities.service;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mastercard.connectedcities.model.Cities;
import com.mastercard.connectedcities.model.Graph;
import com.mastercard.connectedcities.util.ConnectedCitiesUtil;

@Service
public class GraphService {

	private static final Logger LOGGER = LoggerFactory.getLogger(GraphService.class);

	public String doWork(String source, String destination) throws Exception {

		List<Cities> ccList = ConnectedCitiesUtil.readFile();
		LOGGER.info("ccList {}", ccList);

		Graph graph = new Graph(ccList.size());

		for (int i = 0; i < ccList.size(); i++) {

			Cities cc = ccList.get(i);

			if (i == 0) {
				graph.addEdge(i, cc.getSource());
				graph.addEdge(i, cc.getDestination());

			} else {

				LinkedList<String> g[] = graph.getGraphArrayOfList();

				for (int n = 0; i < g.length; n++) {

					int indexs = graph.getIndex(n, cc.getSource());
					if (indexs != -1) {
						graph.addEdgeBeforeIndex(n, cc.getDestination(), indexs);
						break;
					}
					int indexd = graph.getIndex(n, cc.getDestination());
					if (indexd != -1) {
						graph.addEdgeBeforeIndex(n, cc.getSource(), indexd);
						break;
					}
					if ((indexs == -1) && (indexd == -1)) {
						graph.addEdge(i, cc.getSource());
						graph.addEdge(i, cc.getDestination());
						break;
					}
				}
			}
		}

		LinkedList<String> g[] = graph.getGraphArrayOfList();

		for (int i = 1; i < g.length; i++) {
			LinkedList<String> ilist = g[i];
			for (int j = 0; j < ilist.size(); j++) {
				if (graph.isConnected(i - 1, ilist.get(j))) {
					if (j == 0) {
						graph.addEdge(i - 1, ilist.get(j + 1));
						graph.removeEdge(i, ilist.get(j));
						graph.removeEdge(i, ilist.get(j + 1));
					} else {
						graph.addEdge(i - 1, ilist.get(j - 1));
						graph.removeEdge(i, ilist.get(j));
						graph.removeEdge(i, ilist.get(j - 1));
					}
					break;
				}
			}
		}

		boolean flag = false;

		for (int i = 0; i < g.length; i++) {
			if (graph.isConnected(i, source) && graph.isConnected(i, destination)) {
				flag = true;
				break;
			}
		}
		return (flag == true) ? "yes" : "no";
	}

}
