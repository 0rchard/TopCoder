package srm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class srm_154_div1_2 {
	public String[] sortResults(String[] data) {
		if (data.length < 1) {
			return new String[]{};
		}
		Comparator<ArrayList<String> > customComp = new Comparator<ArrayList<String> >() {
			@Override public int compare(ArrayList<String> a, ArrayList<String> b) {
				String name_a = a.get(0);
				String name_b = b.get(0);
				int rank_a = Integer.parseInt(a.get(1));
				int rank_b = Integer.parseInt(b.get(1));
				if (rank_a != rank_b) {
					return rank_a < rank_b? -1 : 1;
				} else {
					return name_a.compareTo(name_b);
				}
			}
		};
		int r = data.length;
		int c = data[0].split(" ").length - 1;
		SortedMap<ArrayList<String>, String> m = new TreeMap<ArrayList<String>, String>(customComp);
		double[] arr = new double[r*c];
		String[] name_arr = new String[r];
		int i = 0;
		int cur_r = 0;
		for (String str:data) {
			String[] fields = str.split(" ");
			name_arr[cur_r++] = fields[0];
			for(int cur_c=0; cur_c<c; ++cur_c) {
				arr[i++] = Double.parseDouble(fields[1+cur_c]);
			}
		}
		for (cur_r=0; cur_r<r; ++cur_r) {
			double score = 0.0;
			ArrayList<String> m_key = new ArrayList<String>();
			String ret_str = name_arr[cur_r];
			int rank = 0;
			for (int cur_c=0; cur_c<c; ++cur_c) {
				score += arr[cur_r*c + cur_c];
				rank += getRank(arr, cur_r, cur_c, r, c);
			}
			m_key.add(name_arr[cur_r]);
			m_key.add(String.valueOf(rank));
			ret_str += " " + String.valueOf(rank);
			ret_str += " " + String.valueOf(score);
			m.put(m_key, ret_str);
		}
		
		String[] ret = new String[r];
		Iterator iter = m.entrySet().iterator();
		i=0;
		while(iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			ret[i++] = (String)entry.getValue();
		}
		return ret;
	}
	private int getRank(double[] arr, int cur_r, int cur_c, int r, int c) {
		double score = 0.0;
		int rank = 0;

		score = arr[cur_r * c + cur_c];
		for (int i = 0; i < r; ++i) {
			if (score <= arr[i * c + cur_c]) {
				rank++;
			}
		}
		return rank;
	}
	public static void main(String[] args) {
		srm_154_div1_2 test = new srm_154_div1_2();
		String[] inputs = new String[]{"A 90.7 92.9 87.4","B 90.5 96.6 88.0","C 92.2 91.0 95.3"};
		String[] outputs = test.sortResults(inputs);
		for(String output: outputs) {
			System.out.println(output);
		}
		
		String str = "-XXX---XX----X";
		String str_1 = "----X----_";
		int start = str_1.indexOf("X", 0);
		int end = str_1.indexOf("X", start);
		System.out.println(String.valueOf(start)+":"+String.valueOf(end));
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
	}
}
