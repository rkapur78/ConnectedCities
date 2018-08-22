package com.mastercard.connectedcities;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastercard.connectedcities.service.GraphService;

@RunWith(SpringRunner.class)
public class GraphServiceTests {

	@Test
	public void GraphServiceHappyPath() throws Exception {

		GraphService service = new GraphService();

		assertEquals("yes", service.doWork("Boston", "Newark"));
		assertEquals("yes", service.doWork("Boston", "Philadelphia"));
		assertEquals("yes", service.doWork("New York", "Newark"));
		assertEquals("yes", service.doWork("Boston", "Newark"));
	}

	@Test
	public void GraphServiceNegativePath() throws Exception {

		GraphService service = new GraphService();

		assertEquals("no", service.doWork("Boston", "Albany"));
	}

}
