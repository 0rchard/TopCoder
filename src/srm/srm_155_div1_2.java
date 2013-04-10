package srm;

import java.util.ArrayList;

public class srm_155_div1_2 {
	public int[] readKnots(String[] knots) {
		ArrayList<ArrayList<Integer>> pos_arr = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> ret = new ArrayList<Integer>();
		int index = 0;		
		for(index = 0; index < knots.length; ++index) {
			String str = knots[index];			
			int i = 0;
			while (i < str.length()) {
				ArrayList<Integer> pos = new ArrayList<Integer>();
				int start = str.indexOf("X", i);
				if (start == -1) {
					break;
				}
				int end = str.indexOf("-", start) == -1? str.length()-1 : str.indexOf("-", start);
				
				System.out.println(">[" + String.valueOf(start) + "," + String.valueOf(end) + "]");
				
				pos.add(start);
				pos.add(end);
				if (index == 0 || pos_arr.size() == 0) {
					pos_arr.add(pos);
				} else {
					int prv_start = -1;
					int prv_end = -1;
					for (int j = 0; j < pos_arr.size(); ++j) {
						ArrayList<Integer> t_pos = pos_arr.get(j);
						int cur_start = t_pos.get(0);
						int cur_end = t_pos.get(1);
						if (start > prv_end && end < cur_end) {
							pos_arr.add(j, pos);
							break;
						} else if (start < cur_start && end > cur_start && end <=cur_end) {
							t_pos.set(0, start);
							break;
						} else if (start > cur_end) {
							continue;
						} else if (start < cur_start && end > cur_end) {
							t_pos.set(0, start);
							t_pos.set(1, end);
						} else if (start < prv_end && end > prv_end) {
							ArrayList<Integer> p_pos = pos_arr.get(j-1);
							p_pos.set(1, end);
						} else if (start < prv_start && end > prv_end) {
							ArrayList<Integer> p_pos = pos_arr.get(j-1);
							p_pos.set(0,start);
							p_pos.set(1, end);
						}
						prv_start = t_pos.get(0);
						prv_end = t_pos.get(1);
					}
				}
				i = end + 1;
			}
			System.out.print("["+String.valueOf(pos_arr.get(0).get(0))+","+String.valueOf(pos_arr.get(0).get(1)) + "]");
			for (int k=1; k<pos_arr.size(); ++k) {				
				System.out.print(",["+String.valueOf(pos_arr.get(k).get(0))+","+String.valueOf(pos_arr.get(k).get(1)) + "]");
			}
			System.out.println();
		}
		
		for (String str : knots) {
			int n = 0;			
			for (int i = 0; i < pos_arr.size(); ++i) {
				ArrayList<Integer> pos = pos_arr.get(i);
				int start = pos.get(0);
				int end = pos.get(1);
				int x_start = str.indexOf("X", start);
				int x_end = 0;
				if (x_start != -1)
					x_end = str.indexOf("-", x_start) == -1 ? str.length() - 1
						: str.indexOf("-", x_start) - 1;				
				if (x_start != -1 && x_start <= end) {
					n = n * 10 + (x_end - x_start + 1);
				} else {
					n = n * 10;
				}
			}
			ret.add(n);
		}
		int[] ret_arr = new int[ret.size()];
		for (int i = 0; i < ret.size(); ++i) {
			ret_arr[i] = ret.get(i);
		}
		return ret_arr;
	}

	public static void main(String[] args) {
		srm_155_div1_2 test = new srm_155_div1_2();
		String[] knots = new String[]{ "XX---XXXX",
		  "XXX-----X" };
		int[] ret = test.readKnots(knots);
		for (int r : ret) {
			System.out.println(r);
		}
	}
}
