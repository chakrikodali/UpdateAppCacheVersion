package packit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UpdateAppCacheVersion {
	public static void main(String[] args) throws IOException {
		String s=null,m = null;
		File f = new File(args[0]);
		File tmp = new File(f.getAbsolutePath()+".tmp");
		File jsFile = new File(args[1]);
		BufferedReader br = new BufferedReader(new FileReader(f));
		BufferedWriter bw = new BufferedWriter(new FileWriter(tmp));
		while (null != (s = br.readLine())) {
			if(s.toUpperCase().contains("VERSION")) {
				m = s.replace(s.substring(s.toUpperCase().indexOf("VERSION") + 8, s.length()),
						String.valueOf(jsFile.length()));
				bw.write(m);
			} else {
				bw.write(s);
			}
			bw.newLine();
		}
		br.close();
		bw.close();
		
		if(!f.delete()) {
			System.out.println("Error deleting file:"+f.getAbsolutePath());
		}
		tmp.renameTo(f);
	}
}
