package com.tkd.user.crud.app.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tkd.user.crud.app.dto.User;
import com.tkd.user.crud.app.exception.BadRequestException;
import com.tkd.user.crud.app.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll().stream().map(User::entityToDto).collect(Collectors.toList());
	}

	public User getUser(Long id) {
		return userRepository.findById(id).map(User::entityToDto)
				.orElseThrow(() -> new BadRequestException("Invalid User Id"));
	}

	public void createUser(User user) {
		userRepository.save(user.toEntity());
	}

	public void updateUser(Long id, User user) {
		user.setUserId(id);
		userRepository.save(user.toEntity());
	}

	public void deleteUser(Long id) {
		userRepository.deleteUserByUserId(id);
	}

	public static void main(String[] args) {
		int requiredAmount = 17;
		int[] coins = { 1, 5, 7 };
		Map<Integer, Integer> store = new HashMap<>();
		System.out.println(findMinCoins(requiredAmount, coins, store));
	}

	private static int findMinCoins(int requiredAmount, int[] coins, Map<Integer, Integer> store) {
		System.out.println(requiredAmount + "--" + Arrays.toString(coins));
		Integer existingValue = store.get(requiredAmount);
		if (existingValue != null) {
			return existingValue;
		}
		if (requiredAmount == 0) {
			return 0;
		}

		int answer = Integer.MAX_VALUE;
		boolean foundAnswer = false;
		for (int i = 0; i < coins.length; i++) {
			int currentCoin = coins[i];
			int subRequiredAmount = requiredAmount - currentCoin;
			if (requiredAmount - currentCoin >= 0) {
				int subAnswer = findMinCoins(subRequiredAmount, coins, store);
				if (subAnswer != -1 && subAnswer + 1 < answer) {
					foundAnswer = true;
					answer = subAnswer + 1;
				}
			}
		}
		answer = foundAnswer ? answer : -1;
		store.put(requiredAmount, answer);
		return answer;
				
	}

}
