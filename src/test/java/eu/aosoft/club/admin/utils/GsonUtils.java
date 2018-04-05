/**
 * 
 */
package eu.aosoft.club.admin.utils;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @author Offermann Alexander
 *
 */
public class GsonUtils {

	@SuppressWarnings("rawtypes")
	public static List jsonToList(String json, TypeToken token) {
		Gson gson = new Gson();
		return gson.fromJson(json, token.getType());
	}

	public static String objectToJson(Object obj) {
		Gson gson = new Gson();
		return gson.toJson(obj);
	}

	public static <T> T jsonToObject(String json, Class<T> classOf) {
		Gson gson = new Gson();
		return gson.fromJson(json, classOf);
	}
	
}
