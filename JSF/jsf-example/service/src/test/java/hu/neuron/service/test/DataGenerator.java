package hu.neuron.service.test;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;

import hu.neuron.core.dao.impl.UserDaoImpl;
import hu.neuron.service.impl.UserServiceImpl;
import hu.neuron.service.vo.Gender;
import hu.neuron.service.vo.UserVo;

public class DataGenerator  extends CommonTest{

	private static final Logger logger = LogManager.getLogger(DataGenerator.class);
	@Test
	public void generateUsers() {
		try {

			JsonReader jsonReader = new JsonReader();
			JSONObject json = jsonReader.readJsonFromUrl("https://randomuser.me/api/0.8/?results=20");
			JSONArray array = json.getJSONArray("results");
			for (int i = 0; i < array.length(); i++) {
				JSONObject jsonObject = array.getJSONObject(i);
				RandomUser randomUser = new RandomUser(jsonObject.getJSONObject("user"));

				UserVo user = new UserVo();
				user.setUsername(randomUser.getUsername());
				String encPassword = BCrypt.hashpw("pasword", BCrypt.gensalt());

				user.setPassword(encPassword);

				user.setGender(Gender.valueOf(randomUser.getGender().toUpperCase()));
				URL url = new URL(randomUser.getPictureMedium());
				BufferedImage bufferedImage = ImageIO.read(url);

				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ImageIO.write(bufferedImage, "jpg", baos);
				baos.flush();
				byte[] data = baos.toByteArray();
				baos.close();

				user.setImage(data);

				UserServiceImpl impl = new UserServiceImpl();
				impl.setUserDao(new UserDaoImpl());
				impl.registration(user);
				logger.debug(user.getUsername());
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

}
