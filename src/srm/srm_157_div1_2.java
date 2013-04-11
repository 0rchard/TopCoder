package srm;

import java.util.ArrayList;

public class srm_157_div1_2 {
	public String[] layout(String[] tbl) {
		String first_line = tbl[0];
		ArrayList<String[]> first_tuples = extractTuple(first_line);
		int col = 0;
		for(int i=0; i<first_tuples.size(); i++) {
			String[] tuple = first_tuples.get(i);
			col += Integer.parseInt(tuple[0]);
		}		
		int row = tbl.length;
		String[][] table = new String[row][col];
		for(int r=0; r<row; r++) {
			for (int c=0; c<col; c++) {
				table[r][c] = "";
			}
		}
		for (int r = 0; r < row; ++r) {
			String line = tbl[r];
			ArrayList<String[]> tuples = extractTuple(line);
			for (int t = 0; t < tuples.size(); ++t) {
				String[] tuple = tuples.get(t);
				if (tuple.length >= 3) {
					int c_span = Integer.parseInt(tuple[0]);
					int r_span = Integer.parseInt(tuple[1]);
					String ch = tuple[2];
					int start_c = 0; // rectangle starting col
					for (int m = 0; m < r_span; m++) {
						int cur_c = start_c;
						int n = 0;
						while(n < c_span) {
							if (table[r+m][cur_c].equals("")) {
								if (m==0 && n==0) {
									start_c = cur_c;
								}
								table[r+m][cur_c++] = ch;
								n++;
							} else {
								cur_c ++;
							}							
						}						
					}
				}
			}
		}
		String[] ret = new String[row];
		for (int r = 0; r < row; ++r) {			
			String t_str = "";
			for (int c = 0; c < col; c++) {
				t_str += table[r][c];
			}
			ret[r] = t_str;
		}
		return ret;
	}

	public ArrayList<String[]> extractTuple(String line) {
		ArrayList<String[]> arr = new ArrayList<String[]>();
		line = line.replaceAll("\\)\\(", ",");
		line = line.replaceAll("\\(", "").replaceAll("\\)", "");
		String[] buffer = line.split(",");
		int n_tuple = buffer.length / 3;
		for (int n = 0; n < n_tuple; n++) {
			String[] tuple = new String[3];
			tuple[0] = buffer[n * 3];
			tuple[1] = buffer[n * 3 + 1];
			tuple[2] = buffer[n * 3 + 2];
			arr.add(tuple);
		}
		return arr;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		srm_157_div1_2 test = new srm_157_div1_2();
		int test_case = 0;
		if (test_case == 2) {
			String[] str_arr = new String[] { 
					"(1,3,N)(3,2,E)(3,1,M)(1,1,Q)",
					"(1,1,T)(3,1,U)", "(1,1,Y)(4,5,A)(1,2,V)(1,2,W)",
					"(1,3,G)(1,3,Z)", "(1,2,S)(1,3,D)", "",
					"(1,2,P)(1,2,F)(1,3,J)", "(1,1,L)(3,3,K)(1,1,R)",
					"(3,2,B)(1,1,D)", "(2,1,A)",
					"(2,3,O)(4,1,X)(1,1,I)(1,1,B)", "(3,2,H)(3,2,C)", "" };
			String[] ret = test.layout(str_arr);
			for (int i = 0; i < ret.length; ++i) {
				System.out.println(ret[i]);
			}
		} else if (test_case == 1) {
			String[] str_arr = new String[] {
					"(1,3,N)(3,2,E)(3,1,M)(1,1,Q)",
					 "(1,1,T)(3,1,U)",
					 "(1,1,Y)(4,5,A)(1,2,V)(1,2,W)",
					 "(1,3,G)(1,3,Z)",
					 "(1,2,S)(1,3,D)",
					 "",
					 "(1,2,P)(1,2,F)(1,3,J)",
					 "(1,1,L)(3,3,K)(1,1,R)",
					 "(3,2,B)(1,1,D)",
					 "(2,1,A)",
					 "(2,3,O)(4,1,X)(1,1,I)(1,1,B)",
					 "(3,2,H)(3,2,C)",
					 ""
					};
			String[] ret = test.layout(str_arr);
			for (int i = 0; i < ret.length; ++i) {
				System.out.println(ret[i]);
			}
		} else if (test_case == 0) {
			String[] str_arr = new String[] {
					"(1,1,A)(2,1,B)(1,1,C)(1,1,D)",
					 "(1,1,E)(1,1,F)(1,1,G)(1,1,H)(1,1,I)",
					 "(1,3,J)(1,1,K)(3,2,L)",
					 "(1,1,M)",
					 "(1,1,N)(1,1,O)(1,1,P)(1,1,Q)",
					 "(1,1,R)(1,1,S)(1,1,T)(1,1,U)(1,1,V)"
					};
			String[] ret = test.layout(str_arr);
			for (int i = 0; i < ret.length; ++i) {
				System.out.println(ret[i]);
			}
		}
	}
}
