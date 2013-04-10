package srm;

public class srm_144_1 {
	public String[] decode(String message) {
		String[] decodeArray = {"None","None"};
		decodeArray[0] = decode_subroutine(0, message);
		decodeArray[1] = decode_subroutine(1, message);
		return decodeArray;
	}
	private String decode_subroutine(int p_2, String message) {
		String decodeStr = "";		
		int p_1 = message.charAt(0) - '0';
		if (p_1 < 0 || p_1 > 2) {
			decodeStr = "None";
		} else {
			decodeStr += String.valueOf(p_2) + String.valueOf(p_1);
			for (int i=1; i<message.length(); ++i) {
				int q = message.charAt(i) - '0';
				int p = q - p_1 - p_2;
				if (p<0 || p>1) {
					decodeStr = "None";
					break;
				} else {
					decodeStr += String.valueOf(p);
				}
				p_2 = p_1;
				p_1 = p;
			}			
		}
		return decodeStr;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		srm_144_1 case_1 = new srm_144_1();
		String[] out = case_1.decode("3");
		for (String str : out) {
			System.out.println(str);
		}		
	}

}
