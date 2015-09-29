package service.site;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TutBy implements ContainerRecords {

	
	private int currentPage;
	private int processedLinks;

	private String request = "http://jobs.tut.by/search/vacancy?text=&search_period=&items_on_page=80&page=";

	private String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 "
			+ "(KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36";

	public TutBy(HashMap<String, String> hashMap) {

		processedLinks = 0;
		currentPage = 0;
		

	}

	public HashMap<String, ArrayList<String>> getRecorder() {
		HashMap<String, ArrayList<String>> records = new HashMap<String, ArrayList<String>>();

		try {
			while (true) {
				try {
					
					Document doc = Jsoup.connect(request + currentPage)
							.userAgent(userAgent).timeout(5000).get();

					Elements elements = doc.select("a");

					for (Element elem : elements) {

						String title = elem.html();
						String url = elem.absUrl("href");

						if (title.contains("курс") && url.contains("http://jobs.tut.by/vacancy")) {
							processedLinks++;
							if (records.containsKey(title)) {
								records.get(title).add(url);

							} else {
								ArrayList<String> list = new ArrayList<String>();
								list.add(url);
								records.put(title, list);
							}
						}

					}
				} catch (SocketTimeoutException e) {
					System.out.println("SocketTimeoutException was broken");
				}
				try {
					Thread.sleep(1000l);
				} catch (InterruptedException e) {
					// FIXME Auto-generated catch block
					e.printStackTrace();
				}
				currentPage++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}

		return records;
	}

	public int getProcessedLinks() {
		return processedLinks;
	}

}
