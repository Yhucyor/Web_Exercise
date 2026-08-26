package thuc.ute.utils;

import java.util.HashMap;
import java.util.Map;

import com.cloudinary.Cloudinary;

public class CloudinaryUtil {

	private static final Cloudinary cloudinary;

	static {

		Map<String, String> config = new HashMap<>();

		config.put("gnht4fer", "YOUR_CLOUD_NAME");
		config.put("api_key", "997495484919781");
		config.put("api_secret", "Z6y76Ybd8vwWrOiOzbMXrnH_JOs");

		cloudinary = new Cloudinary(config);
	}

	public static Cloudinary getCloudinary() {
		return cloudinary;
	}
}