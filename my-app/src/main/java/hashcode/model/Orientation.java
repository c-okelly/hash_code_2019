package hashcode.model;

public enum Orientation {

	HORIZONTAL,VERTICAL;

	public static Orientation getOrientation(String string) {
		switch (string) {
		case "H":
			return HORIZONTAL;
		case "V":
			return VERTICAL;
		default:
			break;
		}
		return null;
	}
	
}

