package srm;

public class tc004_round3_div1_1 {
	public int maxCredit(int[] a, int[] b, int[] c, int[] d, int[] e) {
		int res = 0;
		int hits[][] = new int[5][];
		hits[0] = a;
		hits[1] = b;
		hits[2] = c;
		hits[3] = d;
		hits[4] = e;
		
		int[] mr = new int[5];
		for(int i=0; i<5; ++i) mr[i] = -1;
		int[] pos = new int[5];
		for(int i=0; i<5; ++i) pos[i] = 0;
		
		for(int i=0; i<200000; ++i) {
			for(int j=0; j<5; ++j) {
				if (pos[j]>=hits[j].length) continue;
				if (hits[j][pos[j]] < i) {
					mr[j] = hits[j][pos[j]];
					pos[j]++;
				}
			}
			int num_diff = 0;
			for(int j=0; j<5; ++j) {
				if(mr[j] == -1) continue;
				if (i-mr[j]<=1000) num_diff ++;
			}
			if (num_diff >= 3) {
				res ++;
				for(int j=0; j<5; ++j) mr[j] = -1;
			}
		}		
		return res;
	}	
}