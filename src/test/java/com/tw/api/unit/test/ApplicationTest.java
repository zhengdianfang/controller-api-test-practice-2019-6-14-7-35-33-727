package com.tw.api.unit.test;


import com.tw.api.unit.test.services.ShowService;
import com.tw.api.unit.test.services.TextService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

	@Autowired
	private ShowService showService;

	@Test
	public void contextLoads() {
		Assert.assertEquals(showService.getShowLable(), TextService.ORIGINAL_OUTPUT);
	}

}
