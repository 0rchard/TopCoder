package srm;

public class srm_157_div1_3 {
	public int maxCover(int width, int height, int[] pWidth, int[] pHeight) {
		return 0;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		srm_157_div1_3 test = new srm_157_div1_3();				
		int mode = 0;		
		if (mode == 0) {
			int width = 10;
			int height = 10;
			int[] pWidth = new int[]{7,4,1,8};
			int[] pHeight = new int[]{3,5,3,4};
			System.out.println(test.maxCover(width, height, pWidth, pHeight));
		} else if (mode == 1) {
			int width = 90;
			int height = 80;
			int[] pWidth = new int[]{64,51};
			int[] pHeight = new int[]{42,51};
			System.out.println(test.maxCover(width, height, pWidth, pHeight));
		} else if (mode == 2) {
			int width = 8;
			int height = 6;
			int[] pWidth = new int[]{6,6,2,4,2};
			int[] pHeight = new int[]{2,2,4,2,4};
			System.out.println(test.maxCover(width, height, pWidth, pHeight));
		} else if (mode == 3) {
			int width = 100;
			int height = 93;
			int[] pWidth = new int[]{68,50,18,52,62};
			int[] pHeight = new int[]{27,15,37,45,50};
			System.out.println(test.maxCover(width, height, pWidth, pHeight));
		} else if (mode == 4) {
			int width = 19;
			int height = 20;
			int[] pWidth = new int[]{1,2,4,8,16};
			int[] pHeight = new int[]{1,2,4,8,16};
			System.out.println(test.maxCover(width, height, pWidth, pHeight));
		} else if (mode == 5) {
			int width = 40;
			int height = 30;
			int[] pWidth = new int[]{35};
			int[] pHeight = new int[]{25};
			System.out.println(test.maxCover(width, height, pWidth, pHeight));
		} 
	}
}
