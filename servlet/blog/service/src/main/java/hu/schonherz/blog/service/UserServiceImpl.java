package hu.schonherz.blog.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;

import hu.schonherz.blog.core.UserDao;
import hu.schonherz.blog.core.UserDto;
import hu.schonherz.blog.service.api.user.exception.UserNotFoundException;
import hu.schonherz.blog.service.api.user.service.UserService;
import hu.schonherz.blog.service.api.user.vo.User;
import hu.schonherz.blog.service.api.user.vo.UserResult;

public class UserServiceImpl implements UserService {

	private UserResult result;

	public UserServiceImpl() {
		result = init();
	}

	@Override
	public List<User> findAllUser() {
		return result.getResults().stream().sorted(Comparator.comparing(User::getEmail)).collect(Collectors.toList());
	}

	private UserResult init() {
		Gson gson = new Gson();
		ClassLoader classLoader = getClass().getClassLoader();
		try (InputStream inputStream = classLoader.getResourceAsStream("example.txt");
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));) {

			result = gson.fromJson(bufferedReader, UserResult.class);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @param name
	 * @return
	 */
	public User findUserByName(String name) throws UserNotFoundException {

		UserDao dao = new UserDao();
		UserDto userDto = dao.findByName(name);
		if (userDto != null) {
			return UserConverter.toUser(userDto);
		} else {
			throw new UserNotFoundException();
		}
	}
}
