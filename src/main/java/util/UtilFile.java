package util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;

public class UtilFile {
	
	final static private String BEGINHTML="<!DOCTYPE html>\n\r"
			+ "<html>"
			+ "<head><meta charset='utf-8'/></head>\n\r"
			+"<body>\n\r";
	final static private String ENDHTML="</body>\n\r"
			+ "</html>";
			
	void writeToFile(HashMap<String,ArrayList<String>> hashmap){
		
	}
	public static void writeWholeHtml(String text) throws IOException {
		SimpleDateFormat simple = new SimpleDateFormat("hh-mm-ss");
		String line = simple.format(new Date());
		File f = new File(line+".html");
		Writer writer = new OutputStreamWriter(new BufferedOutputStream(
				new FileOutputStream(f)), "UTF-8");
			writer.write(text);
		writer.close();
	}
	public static void writeSearchWorkHtml(HashMap<String,ArrayList<String>> hashMap) throws IOException {
		
		SimpleDateFormat simple = new SimpleDateFormat("hh-mm-ss");
		String line = simple.format(new Date());
		line +="_work_search";
		File f = new File(line+".html");
		Writer writer = new OutputStreamWriter(new BufferedOutputStream(
				new FileOutputStream(f)), "UTF-8");
			writer.write(BEGINHTML);
			
			for(Entry<String, ArrayList<String>> entry:hashMap.entrySet()){
				
				writer.write("\n\r<br>"+entry.getKey()+"<br>\n\r");
				for(String link:entry.getValue())
					writer.write("<a href='"+link+"'>    "+link+"</a><br>");
			}
			
			writer.write(ENDHTML);
		writer.close();
		System.out.println(new File("").getCanonicalPath()+"/"+line);
	}
		
}	
