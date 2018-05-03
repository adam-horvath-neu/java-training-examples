package hu.neuron.service.test;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jglue.cdiunit.AdditionalPackages;
import org.jglue.cdiunit.CdiRunner;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mindrot.jbcrypt.BCrypt;

import hu.neuron.core.dao.impl.UserDaoImpl;
import hu.neuron.service.UserService;
import hu.neuron.service.impl.UserServiceImpl;
import hu.neuron.service.vo.Gender;
import hu.neuron.service.vo.UserVo;

@RunWith(CdiRunner.class)
@AdditionalPackages({UserServiceImpl.class,UserDaoImpl.class})

public class DataGenerator extends CommonTest {

	private static final Logger logger = LogManager.getLogger(DataGenerator.class);

	@Inject
	private UserService userService;

	@Test
	public void generateUsers() {
		try {

			JsonReader jsonReader = new JsonReader();
			JSONObject json = jsonReader.readJsonFromUrl("https://randomuser.me/api/0.8/?results=2000");
			JSONArray array = json.getJSONArray("results");
			for (int i = 0; i < array.length(); i++) {
				JSONObject jsonObject = array.getJSONObject(i);
				RandomUser randomUser = new RandomUser(jsonObject.getJSONObject("user"));

				UserVo user = new UserVo();
				user.setUsername(randomUser.getUsername());

				user.setPassword("password");

				user.setFirstname(randomUser.getPersonFirstName());
				user.setLastname(randomUser.getPersonLastName());
				user.setEmail(randomUser.getEmail());
				user.setPhone(randomUser.getPhone());
				user.setGender(Gender.valueOf(randomUser.getGender().toUpperCase()));
				URL url = new URL(randomUser.getPictureMedium());
				BufferedImage bufferedImage = ImageIO.read(url);

				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ImageIO.write(bufferedImage, "jpg", baos);
				baos.flush();
				byte[] data = baos.toByteArray();
				baos.close();

				user.setImage(data);

				userService.registration(user);
				logger.debug(user.getUsername());
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

}
