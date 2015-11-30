package br.usp.each.colorization.color;

public abstract class ColorsBlender {

	private final static int SMOOTHNESS = 4;
	
	private static double weightFunction(double d) {
		return Math.pow(d, -SMOOTHNESS);
	}

	private static double getColorComponent(YCbCrColor color,
		String component) {
		if (color == null) return 0.0;

		component = component.toLowerCase();		
		if (component == "cb") return color.cb;
		if (component == "cr") return color.cr;

		return 0.0;
	}

	private static double calculate(YCbCrColor[] colors, double[] distances,
		String component) {
		if (colors == null || distances == null) return 0.0;

		double chroma = 0;
		double sumWeights = 0;

		for (int i = 0; i < distances.length; i++) {
			double weight = weightFunction(distances[i]);

			chroma += weight * getColorComponent(colors[i], component);
			sumWeights += weight;
		}

		if (sumWeights != 0) chroma /= sumWeights;

		return chroma;
	}

	public static double[] blend(YCbCrColor[] colors, double[] distances) {
		double[] chrominances = new double[2];

		chrominances[0] = calculate(colors, distances, "cb");
		chrominances[1] = calculate(colors, distances, "cr");

		return chrominances;
	}	
}
