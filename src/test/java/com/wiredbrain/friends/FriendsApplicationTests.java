package com.wiredbrain.friends;

import com.wiredbrain.friends.controllers.FriendController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FriendsApplicationTests {

	@Autowired
	FriendController friendController;

	@Test
	public void contextLoads() {
		Assert.assertNotNull(friendController);
	}

}
