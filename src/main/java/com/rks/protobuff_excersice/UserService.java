package com.rks.protobuff_excersice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rks.protobuff_excersice.generated.model.UserProto;
import com.rks.protobuff_excersice.generated.model.UserProto.User;
import com.rks.protobuff_excersice.model.UserEntity;
import com.rks.protobuff_excersice.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public UserProto.User save(UserProto.User user) {
		UserEntity saved = userRepository.save(protoToEntity(user));
		return entityToProto(saved);
	}

	private UserEntity protoToEntity(UserProto.User proto) {
		return new UserEntity(proto.getId(), proto.getName(), proto.getEmail());
	}

	private UserProto.User entityToProto(UserEntity entity) {
		return UserProto.User.newBuilder().setId(entity.getId() != null ? entity.getId() : "").setName(entity.getName())
				.setEmail(entity.getEmail()).build();
	}

	public List<User> getAll() {
		return userRepository.findAll().stream().map(this::entityToProto).toList();
	}

}
