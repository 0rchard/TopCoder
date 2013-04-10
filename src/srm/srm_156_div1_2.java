package srm;

import java.util.ArrayList;
import java.util.Iterator;

public class srm_156_div1_2 {
	private ArrayList<ArrayList<Integer> > all_permutations = new ArrayList<ArrayList<Integer> >();
	private int n_passenger = 0;
	public int timeWaiting(int[] arrivalTime, int[] startingFloor,
			int[] destinationFloor) {		
		n_passenger = arrivalTime.length;		
		int n_left = n_passenger, n_right = n_passenger;
		int count = 0;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i=0; i<n_passenger*2; ++i) {
			arr.add(0);
		}
		// generating permutation, similar with generating all valid parents, given number of parents
		genValidPermutation(n_left, n_right, arr, count);
		/*
		for (int i=0; i<all_permutations.size(); ++i) {
			ArrayList<Integer> t_arr = all_permutations.get(i);
			System.out.print("[");
			for(int j=0; j< t_arr.size(); ++j){
				if (j<t_arr.size()-1) {
					System.out.print(t_arr.get(j) + ",");
				} else {
					System.out.print(t_arr.get(j));
				}
			}
			System.out.println("]");
		}
		*/
		int min = Integer.MAX_VALUE;
		for (int i=0; i<all_permutations.size(); ++i) {
			ArrayList<Integer> perm = all_permutations.get(i);
			int trip_time = 0;
			int elevator = 1;
			int cur_time = 0;
			for(int j=0; j<perm.size(); ++j) {
				int index = Math.abs(perm.get(j)) - 1;
				if (perm.get(j) < 0) {
					trip_time = load(arrivalTime, startingFloor, destinationFloor, index, cur_time, elevator);
					cur_time += trip_time;
					elevator = startingFloor[index];
				} else {
					trip_time = takeoff(arrivalTime, startingFloor, destinationFloor, index, cur_time, elevator);
					cur_time += trip_time;
					elevator = destinationFloor[index];
				}
			}
			if (cur_time < min) {
				min = cur_time;
			}
		}
		return min;
	}
	
	private int load(int[] arrivalTime, int[] startingFloor, int[] destinationFloor, int index, int cur_time, int elevator) {
		int start = startingFloor[index];
		int arrival = arrivalTime[index];		
		int steps = start - elevator;
		int interval = arrival - cur_time;
		return Math.max(steps, interval);
	}
	
	private int takeoff(int[] arrivalTime, int[] startingFloor, int[] destinationFloor, int index, int cur_time, int elevator) {
		int destination = destinationFloor[index];
		int arrival = arrivalTime[index];
		int steps = destination - elevator;
		int interval = arrival - cur_time;
		return Math.max(steps, interval);
	}
	private void genValidPermutation(int n_left, int n_right, ArrayList<Integer> arr, int count) {
		if (n_left < 0 || n_right < n_left) {
			return;
		}
		if (n_left == 0 && n_right == 0) {
			all_permutations.add(new ArrayList<Integer>(arr));
			/*
			System.out.print("[");
			for(int j=0; j< arr.size(); ++j){
				if (j<arr.size()-1) {
					System.out.print(arr.get(j) + ",");
				} else {
					System.out.print(arr.get(j));
				}
			}
			System.out.println("]");
			*/
		} else {
			if (n_left > 0) {
				arr.set(count, -n_left);
				genValidPermutation(n_left - 1, n_right, arr, count+1);
			}
			if (n_right > n_left) {
				arr.set(count, n_right);
				genValidPermutation(n_left, n_right - 1, arr, count+1);
			}
		}		
	}
	public static void main(String[] args) {
		srm_156_div1_2 test = new srm_156_div1_2();
		int[] arrivalTime = new int[] {1000, 1200, 1600, 2000, 2400};
		int[] startingFloor = new int[] {500, 500, 500, 500, 500};
		int[] destinationFloor = new int[] {700, 300, 700, 300, 700};
		int minTime = test.timeWaiting(arrivalTime, startingFloor, destinationFloor);
		System.out.println(minTime);
	}
}
