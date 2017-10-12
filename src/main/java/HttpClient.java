import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {

    public static final String URL = "<http url goes here>";

    /**
     * Simple Get Request
     */
    public static void httpGet() {
        String l;
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(URL);
            HttpURLConnection c = (HttpURLConnection) url.openConnection();

            c.setRequestMethod("GET");
            c.addRequestProperty("Content-Type", "application/json");

            BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
            while ((l = br.readLine()) != null) {
                sb.append(l);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Simple Post Request
     */
    public static void httpPost() {
        String l;
        StringBuilder sb = new StringBuilder();
        final String postBody = "{}";
        try {
            URL url = new URL(URL);
            HttpURLConnection c = (HttpURLConnection) url.openConnection();

            c.setRequestMethod("POST");
            c.setDoOutput(true);
            c.addRequestProperty("Content-Type", "application/json");

            OutputStream os = c.getOutputStream();
            os.write(postBody.getBytes());
            os.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
            while ((l = br.readLine()) != null) {
                sb.append(l);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Simple Put Request
     */
    public static void httpPut() throws Exception {
        String l;
        StringBuilder sb = new StringBuilder();
        final String putBody = "{}";
        try {
            URL url = new URL(URL);
            HttpURLConnection c = (HttpURLConnection) url.openConnection();

            c.setRequestMethod("PUT");
            c.setDoOutput(true);
            c.addRequestProperty("Content-Type", "application/json");

            OutputStream os = c.getOutputStream();
            os.write(putBody.getBytes());
            os.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
            while ((l = br.readLine()) != null) {
                sb.append(l);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("hello world!");
    }
}
