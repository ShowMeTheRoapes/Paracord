package com.showmetheroapes.example.data;

import com.showmetheroapes.example.domain.User;

/**
 * Controller used to access data from the Github API.
 *
 * @author Dustin Roan (dustin.a.roan@gmail.com)
 *
 */
public class UserController {

	public User getAUser(final String userId) {
		// Do something here
		return new User.Builder().user(userId).build();
	}
}
