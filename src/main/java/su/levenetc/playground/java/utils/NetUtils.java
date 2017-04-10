package su.levenetc.playground.java.utils;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

    public static String executePost(String targetUrl, Map<String, String> bodyParams) throws IOException {
        String params = "";
        for (String key : bodyParams.keySet()) {
            params += key + "=" + bodyParams.get(key) + "&";
        }
        return executePost(targetUrl, params);
    }

    public static String executePost(String targetURL, String bodyParams) throws IOException {

        URL url = new URL(targetURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.setRequestProperty("Content-Length", Integer.toString(bodyParams.getBytes().length));
        connection.setRequestProperty("Content-Language", "en-US");
        connection.setUseCaches(false);
        connection.setDoOutput(true);

        DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
        wr.writeBytes(bodyParams);
        wr.close();

        InputStream is = connection.getInputStream();

        String result = streamToString(is);


//        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
//        StringBuilder response = new StringBuilder();
//        String line;
//        while ((line = rd.readLine()) != null) {
//            response.append(line);
//            response.append('\r');
//        }
//        rd.close();

        connection.disconnect();

        return result;

    }

    public static String streamToString(InputStream inputStream) throws IOException {
        final int bufferSize = 1024;
        final char[] buffer = new char[bufferSize];
        final StringBuilder out = new StringBuilder();
        Reader in = new InputStreamReader(inputStream, "UTF-8");
        for (; ; ) {
            int rsz = in.read(buffer, 0, buffer.length);
            if (rsz < 0)
                break;
            out.append(buffer, 0, rsz);
        }
        return out.toString();
    }

    public static void createSocketServer(int port) throws IOException {

        Socket socket = null;
        boolean end = true;

        ServerSocket listener = new ServerSocket(port);
        while (end) {
            socket = listener.accept();
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(new Date().toString());
        }

        socket.close();
        listener.close();
    }
}
