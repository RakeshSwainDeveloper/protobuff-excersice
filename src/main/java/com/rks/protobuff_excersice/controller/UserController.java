package com.rks.protobuff_excersice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rks.protobuff_excersice.UserService;
import com.rks.protobuff_excersice.generated.model.UserProto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	
	@PostMapping("/get")
	public void test() {
		System.out.println("Hello rakesh-------------------");
	}

	@PostMapping(consumes = "application/x-protobuf", produces = "application/x-protobuf")
	public UserProto.User create(@RequestBody UserProto.User user) {
		return userService.save(user);
	}

	@GetMapping(produces = "application/x-protobuf")
	public UserProto.UserList getAll() {
		List<UserProto.User> users = userService.getAll();
		return UserProto.UserList.newBuilder().addAllUsers(users).build();
	}

}
