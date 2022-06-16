package app;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Creates and writes output information
 *
 * @author Timotej Fašiang
 */
public class Writer {

	/**
	 * Creates a file and writes athlete information to it.
	 *
	 * @param name is the name of the athlete;
	 * @param zoneHR is an ArrayList containing the athlete's HR zones
	 * @param maxLactate contains the maximum reached lactate value
	 * @throws IOException
	 */
	public static void WriteOutput(String name, ArrayList<String> zoneHR, double maxLactate) throws IOException {
		String outFileName = "data\\" + name + ".txt";
		try ( BufferedWriter writer = new BufferedWriter(new FileWriter(outFileName))) {
			writer.write(name + "\n");
			for (int i = 0; i < 5; i++) {
				writer.write("\n" + zoneHR.get(i));
			}
			writer.write("\n\nMax Lactate: " + maxLactate);
		}
	}

	public static void WriteBinaryOutput(String name, ArrayList<String> zoneHR, double maxLactate) throws IOException {
		String outFileName = "data\\" + name + ".bin";

		try ( FileOutputStream fileOs = new FileOutputStream(outFileName);  ObjectOutputStream writer = new ObjectOutputStream(fileOs);) {

			writer.writeUTF(name);
			for (int i = 0; i < 5; i++) {
				writer.writeUTF(zoneHR.get(i));
			}
			writer.writeDouble(maxLactate);
		}
	}
}
