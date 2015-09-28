
public class Dealer {

	public String parsePlayerID(String data) {
		String delims = "[ ]+";
		String[] parsed = data.split(delims);
		return parsed[0];
	}

}
