package collections;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ResourceReader {
	public static String[] getValuesOnLine(String path, int line) throws IOException {
		String[] tmp = null;
		String l = "";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path + ".txt"));
			int count = 0;
			
			l = br.readLine();
			
			while(l != null) {
				if(count == line) break;
				l = br.readLine();
				count += 1;
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		if(l != null)
			tmp = l.split(";");
		
		return tmp;
	}
}
