package test;

public class printPar {
	public void printParents(int l, int r, char[] str, int count) {
		if (l < 0 || r < l) {
			return;
		}
		if (l==0 && r==0) {
			System.out.println(str);
		} else {
			if (l>0) {
				str[count] = '(';
				printParents(l-1, r, str, count+1);
			}
			if (r>l) {
				str[count] = ')';
				printParents(l, r-1, str, count+1);
			}
			//System.out.println(str);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 4;
		char[] str = new char[count*2];
		printPar test = new printPar();
		test.printParents(count, count, str, 0);
	}

}
