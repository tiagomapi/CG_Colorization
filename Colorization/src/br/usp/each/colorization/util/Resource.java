package br.usp.each.colorization.util;

import java.net.URL;

abstract public class Resource {

	public static String getPath(String resource) {
		URL url = Resource.class.getResource(resource);
		if (url != null) return url.getPath();

		return "";
	}

	public static String getIconPath(String icon) {
		return Resource.getPath("/assets/icons/" + icon);
	}

	public static String getImagePath(String image) {
		return Resource.getPath("/assets/images/" + image);
	}
}
