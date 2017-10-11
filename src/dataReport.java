package singleProcessor;

import java.util.ArrayList;

public class dataReport {
	
	private ArrayList<Long> values = new ArrayList<>();

	public dataReport(ArrayList<Long> data) {
		this.values = data;
	}
	
	public double getMax() {
		double max = values.get(0);
		for(double i: values) {
			if(i>max) {
				max = i;
			}
		}
		return max;
	}
	
	public double getMin() {
		double min = values.get(0);
		for(double i: values) {
			if(i<min) {
				min = i;
			}
		}
		return min;
	}
	
	public double getMean() {
		int sum = 0;
		for (double a : values) {
			sum += a;
		}
		return sum / values.size();
	}

	 public double getSD() {
		double mean = getMean();
		double temp = 0;
		for (double a : values) {
			temp += (a - mean) * (a - mean);
		}
		return Math.sqrt(temp / (values.size() - 1));

	}
	 public double getAVG() {
			double temp = 0;
			for (double a : values) {
				temp++;
			}
			return temp/(values.size());

		}
}
