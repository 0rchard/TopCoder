package srm;

public class srm_360_div2_3_correct {
	public int winningMove(int n) 
	  { 
	    int[] X = new int[2000001]; 
	    int i, j, k, t, b; 
	    int[] T = new int[8]; 
	     
	    for(i=0; i<X.length; i++) 
	      X[i] = 0; 
	     
	    for(i=1; i<X.length; i++) 
	    { 
	      if(i < 10) 
	      { 
	        X[i] = -1; 
	        continue; 
	      } 
	      t = i; 
	       
	      for(b=0; t>0; b++) 
	      { 
	        T[b] = t%10; 
	        t /= 10; 
	      } 
	       
	      for(j=b-1; j>=0; j--) 
	      { 
	        t = 0; 
	        for(k=j; k>=0; k--)
	        { 
	          t *= 10; 
	          t += T[k]; 
	         
	          if(t == 0) 
	            continue; 
	          if(X[i-t] == -1 // opponent losing 
	        		  && (X[i] == 0 // new node 
	        		  	|| t < X[i] // select min move
	        		  	|| X[i] == -1 // previous losing move, but now find a winning move
	        		  	)) 
	            X[i] = t; 
	          else if(X[i-t] > 0 // opponent winning 
	        		  && X[i] == 0 // new node
	        		  )
	            X[i] = -1; 
	        } 
	      } 
	    }
	     
	    return X[n]; 
	  } 
	public static void main(String[] args) {
		srm_360_div2_3_correct test = new srm_360_div2_3_correct();
		int mode = 3;
		int n;
		int ret;
		if (mode == 1) {
			
		} else if (mode == 2) {
			n = 20;
			ret = test.winningMove(n);
			System.out.println(String.valueOf(ret));
		} else if (mode == 3) {
			n = 239;
			ret = test.winningMove(n);
			System.out.println(String.valueOf(ret));
		}
	}
}
