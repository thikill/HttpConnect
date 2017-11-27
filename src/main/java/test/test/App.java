package test.test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class App {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		testConnect02("http://xskt.com.vn/xyz");
		testConnect02("http://xskt.com.vn/rss-feed/mien-bac-xsmb.rss");
		//testConnect("http:testConnect02//kqxs.net.vn/rss-feed/xo-so-mien-bac-xsmb-xstd.rss");
		 //testConnect02("http://kqxs.net.vn/rss-feed/xo-so-mien-bac-xsmb-xstd.rss");
		// testConnect01("http://kqxs.net.vn/rss-feed/xo-so-mien-bac-xsmb-xstd.rss");
		 testConnect02("http://xoso.me/rss/xo-so-mien-bac.rss");
		 testConnect02("http://xosodaiphat.com/ket-qua-xo-so-mien-bac-xsmb.rss");
		 long end = System.currentTimeMillis();
		 System.out.println(end-start);

	}

	public static void testConnect02(String rss) {
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(rss);
            HttpResponse response = client.execute(request);
 
            int responseCode = response.getStatusLine().getStatusCode();
 
            System.out.println("**GET** request Url: " + request.getURI());
            System.out.println("Response Code: " + responseCode);
            System.out.println("Content:-\n");
/*            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
 
            String line = "";
            while ((line = rd.readLine()) != null) {
                System.out.println(line);
            }*/
 
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public static void testConnect01(String rss) {
		Document doc = null;
		try {
			doc = Jsoup.connect(rss).get();
		} catch (Exception e) {
			// log error
			e.printStackTrace();
		}
	}

	public static void testConnect(String rss) {
		try {
			URL url = new URL(rss);
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			conn.setConnectTimeout(100000);
			conn.setReadTimeout(100000);
			conn.connect();
			InputStream inputStream = url.openStream();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(rss);
			e.printStackTrace();
		}
	}
}
