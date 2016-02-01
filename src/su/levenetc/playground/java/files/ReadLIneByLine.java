package su.levenetc.playground.java.files;

import su.levenetc.playground.java.utils.Out;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by levenetc on 09/07/15.
 */
public class ReadLIneByLine {
	public static void read() {
		String fileName = "references.txt";
		int max = 0;
		String maxPackage = null;
		int total = 0;

		HashMap<String, Integer> packages = new HashMap<>();

		try {
			try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
				for (String line; (line = br.readLine()) != null; ) {

					String[] split = line.split(" ");
					int methods = Integer.valueOf(split[0]);
					total += methods;

					String pkg = split[1];
					packages.put(pkg, methods);

					if (max < methods) {
						max = methods;
						maxPackage = pkg;
					}
				}
				// line is not visible here.
			}
		} catch (IOException e) {
			Out.pln("error");
		}

		Out.pln("total: " + total);
		Out.pln("max at " + maxPackage + ": " + max);


		SortedSet<Integer> values = new TreeSet<>(packages.values());

		for (Integer value : values) {
			String pkg = "";
			for (Map.Entry<String, Integer> entry : packages.entrySet()) {
				if ((int) entry.getValue() == value) {
					pkg = entry.getKey();
				}
			}
			Out.pln(pkg + ": " + value);
		}
	}
}
