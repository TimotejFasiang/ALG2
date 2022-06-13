package app;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.WindowConstants;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.VectorGraphicsEncoder;
import org.knowm.xchart.VectorGraphicsEncoder.VectorGraphicsFormat;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYSeries.XYSeriesRenderStyle;

/**
 * Creates and saves different graphs
 *
 * @author Timotej Fašiang
 */
public class Graph {

	/**
	 * Graphs and saves in .pdf format the heart rate data
	 *
	 * @param hrdata is the input data, in a String ArrayList format, that is to
	 * be turned into a graph
	 */
	public static void hrGraph(ArrayList<String> hrdata) { // Graphs and saves hr vs time

		double[] yData = new double[hrdata.size()];
		for (int i = 0; i < hrdata.size(); ++i) {
			yData[i] = Double.parseDouble(hrdata.get(i));
		}

		double[] xData = new double[hrdata.size()];
		for (int i = 0; i < hrdata.size(); ++i) {
			xData[i] = i;
		}

		XYChart chart = QuickChart.getChart("Heart Rate", "Minutes", "b/m", "Heart Rate", xData, yData);
		new SwingWrapper(chart).displayChart().setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

		try {
			VectorGraphicsEncoder.saveVectorGraphic(chart, "C:\\Users\\Timotej\\Documents\\NetBeansProjects\\Final\\src\\main\\java\\data\\hrGraph", VectorGraphicsFormat.PDF);
		} catch (IOException e) {
			System.out.println("Saving error for hr graph");
		}

	}

	/**
	 * Graphs and saves in .pdf format the lactate data
	 *
	 * @param lactatedata is the input data, in a String ArrayList format, that
	 * is to be turned into a graph
	 */
	public static void lactateGraph(ArrayList<String> lactatedata) { // Graphs and saves lactate vs time

		double[] yData = new double[lactatedata.size()];
		for (int i = 0; i < lactatedata.size(); ++i) {
			yData[i] = Double.parseDouble(lactatedata.get(i));
		}

		double[] xData = new double[lactatedata.size()];
		for (int i = 0; i < lactatedata.size(); ++i) {
			xData[i] = i;
		}

		XYChart chart = QuickChart.getChart("Lactate Level", "Minutes", "mmol/L", "Lactate", xData, yData);
		chart.getStyler().setDefaultSeriesRenderStyle(XYSeriesRenderStyle.Area);
		new SwingWrapper(chart).displayChart().setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		try {
			VectorGraphicsEncoder.saveVectorGraphic(chart, "C:\\Users\\Timotej\\Documents\\NetBeansProjects\\Final\\src\\main\\java\\data\\lactateGraph", VectorGraphicsFormat.PDF);
		} catch (IOException ex) {
			System.out.println("Saving error for lactate graph");
		}
	}

	/**
	 * Graphs and saves in .pdf format the heart rate and lactate data
	 *
	 * @param hrdata is half of the input data, in a String ArrayList format,
	 * that is to be turned into a graph
	 * @param lactatedata is half of the input data, in a String ArrayList
	 * format, that is to be turned into a graph
	 */
	public static void doubleGraph(ArrayList<String> hrdata, ArrayList<String> lactatedata) { // Graphs and saves lactate & hr vs time

		double[] yData = new double[hrdata.size()];
		for (int i = 0; i < hrdata.size(); ++i) {
			yData[i] = Double.parseDouble(hrdata.get(i));
		}

		double[] xData = new double[hrdata.size()];
		for (int i = 0; i < hrdata.size(); ++i) {
			xData[i] = i;
		}

		double[] y2Data = new double[lactatedata.size()]; // *20
		for (int i = 0; i < lactatedata.size(); ++i) {
			y2Data[i] = Double.parseDouble(lactatedata.get(i)) * 20;
		}

		double[] x2Data = new double[lactatedata.size()];
		for (int i = 0; i < lactatedata.size(); ++i) {
			x2Data[i] = i;
		}

		XYChart chart = QuickChart.getChart("Heart Rate & Lactate", "Minutes", "b/m & mmol/50ml", "Heart Rate", xData, yData);
		chart.addSeries("Lactate", x2Data, y2Data);
		new SwingWrapper(chart).displayChart().setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		try {
			VectorGraphicsEncoder.saveVectorGraphic(chart, "C:\\Users\\Timotej\\Documents\\NetBeansProjects\\Final\\src\\main\\java\\data\\doubleGraph", VectorGraphicsFormat.PDF);
		} catch (IOException ex) {
			System.out.println("Saving error for double graph");
		}
	}
}
