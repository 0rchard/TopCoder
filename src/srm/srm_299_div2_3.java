package srm;

import java.util.BitSet;
import java.util.Vector;

public class srm_299_div2_3 {
	int n;
	  
	  
	  public int remain (String [] interacts) {
	    n = interacts.length;
	    //Digraph g = new Digraph(n);
	    boolean [][] adj = new boolean[n][n];
	    boolean [][] reaches = new boolean[n][n];
	    for (int i = 0; i < n; i ++) {
	      for (int j = 0; j < n; j ++) {
	        if (interacts[i].charAt(j) == '-') {
	          //g.addEdge(i,j);
	          adj[i][j] = true;
	          reaches[i][j] = true;
	        }
	      }
	    }	    	    
	    
	    boolean changed = true;
	    while (changed) {
	      changed = false;
	      for (int i = 0; i < n; i ++)
	      for (int j = 0; j < n; j ++) {
	        if (!reaches[i][j]) {
	          for (int k = 0; k < n; k ++) {
	            if (reaches[i][k] && reaches[k][j]) {
	              reaches[i][j] = true;
	              changed = true;
	              break;
	            }
	          }
	        }
	      }
	    }
	    /*
	    for (int i=0; i<n; i++) {
	    	for(int j=0; j<n; j++)
	    		if (j<=n-1)
	    			System.out.print(String.valueOf(reaches[i][j])+",");
	    		else
	    			System.out.print(String.valueOf(reaches[i][j]));
	    	System.out.println();
	    }
	    */
	    
	    Vector<Vertex> comps = new Vector<Vertex> ();
	    BitSet set = new BitSet(n);
	    for (int i = 0; i < n; i ++) {
	      if (set.get(i)) continue;
	      Vertex v = new Vertex(i);
	      comps.add(v);
	      set.set(i);
	      for (int j = 0; j < n; j++) {
	        if (set.get(j)) continue;
	        if (reaches[i][j] && reaches[j][i]) {
	          set.set(j);
	        }
	      }
	    }
	    
	    Digraph graph = new Digraph(comps);
	    for (Vertex v: comps) {
	      for (Vertex w: comps) {
	        if (v!=w && reaches[v.index][w.index]) {
	          graph.addEdge(v,w);
	        }
	      }
	    }
	    int count = 0;
	    for (Vertex v:graph.vertices) {
	      if (v.indeg() == 0)
	        count ++;
	    }
	    return count;
	  }
	  
	  class Digraph {
	    Vector<Vertex> vertices;
	    
	    Digraph () {
	      vertices = new Vector<Vertex>();
	    }
	    
	    Digraph (int a) {
	      vertices = new Vector<Vertex>();
	      for (int i = 0; i < a; i ++)
	        vertices.add(new Vertex());
	    }
	    
	    Digraph (Vector<Vertex> v) {
	      vertices = v;
	    }
	    
	    public void addEdge(Vertex v, Vertex w) {
	      Edge e = new Edge(v,w);
	      v.addEdgeOut(e);
	      w.addEdgeIn(e);
	    }
	  }
	  
	  
	  class Edge {
	    Vertex v, w;
	    
	    Edge (Vertex v, Vertex w) {
	      this.v = v;
	      this.w = w;
	    }
	  }
	  
	  class Vertex {
	    Vector<Edge> in, out;
	    
	    int index;
	    
	    public Vertex () {
	      in = new Vector<Edge>();
	      out = new Vector<Edge>();
	    }
	    
	    public Vertex (int i) {
	      this();
	      index = i;
	    }
	    
	    public void addEdgeOut(Edge e) {
	      out.add(e);
	    }
	    
	    public void addEdgeIn (Edge e) {
	      in.add(e);
	    }
	    
	    public int indeg() {
	      return in.size();
	    }
	    
	    public int outdeg() {
	      return out.size();
	    }
	  }
	  
	  public static void main(String[] args) {
		  srm_299_div2_3 test = new srm_299_div2_3();
		  int mode = 0;
		  if (mode == 0) {
			  String[] interacts = new String[] {
					  "0+-",
					  "-0+",
					  "+-0"
			  };
			  System.out.println(new Integer(test.remain(interacts)));
		  }
		  
	  }
}
