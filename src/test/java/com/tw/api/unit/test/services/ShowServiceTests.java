package com.tw.api.unit.test.services;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ShowServiceTests {
	private static final String MOCK_OUTPUT = "Mocked show label";

	@Mock
	private TextService textService;

	@InjectMocks
	private ShowService showService;

	public void setUp() throws Exception {
		when(textService.getText()).thenReturn(MOCK_OUTPUT);
	}

	@Test
	public void contextLoads() {
		Assert.assertEquals(showService.getShowLable(), MOCK_OUTPUT);

	}

}
