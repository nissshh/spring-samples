/**
 * 
 */
package com.mycompany.boot.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.boot.data.modal.User;

/**
 * User Controller for authorization
 * 
 * @author NishantS
 *
 */

@RestController
@RequestMapping("/user")
public class UserController extends BaseService {

	@RequestMapping(consumes = "application/json", method = RequestMethod.POST , produces = "application/json")
	@ResponseBody
	public ResponseEntity<?> getUser(@RequestBody User user ) {
		if (user != null && user.getUsername().equalsIgnoreCase("test") && user.getPassword().equalsIgnoreCase("test")) {
			return ResponseEntity.status(HttpStatus.OK).body("{\"firstname\":\"TestUser\",lastname:\"TestSurname\",email:\"testemail@testserver.com\"}");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

}
