package su.levenetc.algorithms.utils;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by elevenetc on 16/07/15.
 */
public class NetUtils {
	public static String getParam(String url, String paramName) {

		try {
			List<NameValuePair> values = URLEncodedUtils.parse(new URI(url), "UTF-8");

			for (NameValuePair pair : values) {
				if (pair.getName().equals(paramName)) {
					return pair.getValue();
				}
			}

		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		return null;
	}
}
