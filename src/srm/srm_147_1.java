package srm;

public class srm_147_1 {

	private int nextMale(int index, int totalSlot, String[] arr) {
		while (arr[index].equals("F")) {
			index = (index + 1) % totalSlot;
		}
		return index;
	}

	public String order(int numMales, int numFemales, int K) {
		int totalSlot = numFemales + numMales;
		String[] arr = new String[totalSlot];
		for (int i = 0; i < numMales + numFemales; i++) {
			arr[i] = "M";
		}
		int start = 0;
		int remainFemales = numFemales;
		int remainMales = numMales;

		int index = 0;
		while (remainFemales > 0) {
			for (int i = 0; i < K-1; i++) {
				index = nextMale(start, totalSlot, arr);
				start = (index + 1) % totalSlot;
			}
			arr[start % totalSlot] = "F";
			start = (start + 1) % totalSlot;
			remainFemales--;
		}
		String result = "";
		for (int i = 0; i < totalSlot; i++) {
			result += arr[i];
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		srm_147_1 test = new srm_147_1();
		String str = test.order(5, 5, 3);
		System.out.println(str);
		str = test.order(7, 3, 1);
		System.out.println(str);
	}

}
