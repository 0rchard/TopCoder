package srm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Arrays;

public class srm_147_2 {
	public String snaug(int[] initialFood, int rounds) {
		int[] prvFood = new int[6];
		int base = (int)Math.pow(4, rounds);
		for (int i = 0; i < 6; i++) {
			prvFood[i] = initialFood[i] * base;
		}
		int[] curFood = new int[6];
		int total = rounds;
		while (rounds > 0) {
			curFood = distribute(prvFood);						
			prvFood = curFood;
			rounds--;
		}
		String result;
		int lcf = LCF(curFood[2], base);
		if (curFood[2] % base == 0) {
			result = String.valueOf(curFood[2]/base);
		} else {
			result = String.valueOf(curFood[2]/lcf) + "/" + String.valueOf(base/lcf);
		}		 
		return result;
	}
	
	private int LCF(int m, int n) {
		int m_cup = m, n_cup = n;
		int res = m_cup % n_cup;
		while (res != 0) {
			m_cup = n_cup;
			n_cup = res;
			res = m_cup % n_cup;
		}
		return n_cup;
	}

	private int[] neighbor(int index) {
		int[] neighbors = new int[4];
		int count = 0;
		int start = 0;
		if (index % 2 == 0) {
			start = (index+2) % 6;
		} else {
			start = (index+1) % 6;
		}
		while (count<4) {
			neighbors[count] = start;
			start = (start+1) % 6;
			count ++;
		}			
		return neighbors;
	}

	private int[] distribute(int[] curFood) {		
		int income, outcome;
		int[] tempFood = new int[6];
		for (int i=0; i<6; ++i) {
			tempFood[i] = 0;
		}
		for(int i=0; i<6; ++i) {
			int[] neighbors = neighbor(i);
			income = 0;
			for(int j=0; j<4; ++j) {
				income += curFood[neighbors[j]] / 4;
			}
			tempFood[i] = income;
		}
		return tempFood;
	}

	public static void main(String[] args) {
		srm_147_2 test = new srm_147_2();
		String result = "";
		int[] case_1 = new int[]{0,0,4,0,0,0};
		result = test.snaug(case_1, 1);
		System.out.println(result);
		result = test.snaug(case_1, 2);
		System.out.println(result);
		result = test.snaug(case_1, 3);
		System.out.println(result);
		
		int[] case_2 = new int[]{1,2,3,4,5,6};
		result = test.snaug(case_2, 1);
		System.out.println(result);
		ArrayList<String> a = new ArrayList<String>();	
		ArrayList<Double> b = new ArrayList<Double>();
	}
}
