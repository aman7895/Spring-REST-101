package com.wiredbrain.friends;

import com.wiredbrain.friends.model.Friend;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class SystemTests {

    @Test
    public void testCreateReadDelete(){

        //Use Rest template
        RestTemplate restTemplate = new RestTemplate();
        //On this string
        String url="http://localhost:8080/friend";
        //Create a new friend
        Friend friend = new Friend("Gordon","Moore");
        ResponseEntity<Friend> entity= restTemplate.postForEntity(url,friend,Friend.class);
        //Try to "GET" it
        Friend[] friends = restTemplate.getForObject(url,Friend[].class);
        Assertions.assertThat(friends).extracting(Friend::getFirstName).contains("Gordon");
        //Try to "DELETE" it
        restTemplate.delete(url + "/" + entity.getBody().getId());
        Assertions.assertThat(restTemplate.getForObject(url,Friend[].class)).isEmpty();

    }
}
