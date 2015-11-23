package main;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import service.site.TutBy;
import util.UtilFile;

public class Main {
	public static void main(String[] args) throws IOException {
		Map<String,String> hashMap = new HashMap<String, String>();
		if(args.length == 0)
			hashMap.put("search_period", "1");
		else hashMap.put("search_period", args[0]);
		TutBy t = new TutBy(hashMap);
		UtilFile.writeSearchWorkHtml(t.getRecorder());
		System.out.println("processed pages = "+t.getProcessedLinks());
	}
}
