import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class String_get_ip {
    public String GetFunction(String Address){
        try {
            URL url = new URL(Address);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("Get");
            conn.setConnectTimeout(15000);
            conn.setReadTimeout(10000);
            conn.setDoInput(true);
            conn.setDoOutput(true);

            InputStream is = conn.getInputStream();
            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String result;
            while ((result = br.readLine()) != null) {
                sb.append(result + '\n');
            }

            result = sb.toString();

            return result;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
