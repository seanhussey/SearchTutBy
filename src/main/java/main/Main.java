package main;

import java.io.IOException;

import service.site.TutBy;
import util.UtilFile;

public class Main {
	public static void main(String[] args) throws IOException {
		TutBy t = new TutBy(null);
		UtilFile.writeSearchWorkHtml(t.getRecorder());
		System.out.println("processed pages = "+t.getProcessedLinks());
	}
}
