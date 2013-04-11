package srm;

public class srm_308_div1_2 {
	public String decode(String archive, String[] dictionary) {
		root = new Node(null, null, "");
		this.buildTree(dictionary);
		String ret = "";
		Node cur_node = root;
		for (int i=0; i<archive.length(); ++i) {
			char c = archive.charAt(i);
			if (c == '0') {
				cur_node = cur_node.left;			
			} else {
				cur_node = cur_node.right;				
			}
			if (cur_node.isLeaf()) {
				ret += cur_node.val;
				cur_node = root;
			}
		}
		return ret;
	}
	private void buildTree(String[] dictionary) {
		Node cur_node = root;
		// for (String path : dictionary) {
		for (int index = 0; index < dictionary.length; ++index) {
			String path = dictionary[index];
			cur_node = root;
			for (int i = 0; i < path.length(); ++i) {
				char c = path.charAt(i);
				if (c == '0' && cur_node.hasLeft()) {
					cur_node = cur_node.left;
				} else if (c == '1' && cur_node.hasRight()) {
					cur_node = cur_node.right;
				} else if (c == '0' && !cur_node.hasLeft()) {
					Node node = new Node(null, null, "");
					cur_node.left = node;
					cur_node = cur_node.left;
				} else if (c == '1' && !cur_node.hasRight()) {
					Node node = new Node(null, null, "");
					cur_node.right = node;
					cur_node = cur_node.right;
				}
			}
			if (cur_node.isLeaf()) {
				cur_node.val = String.valueOf((char)('A'+index));
			}			
		}
	}
	class Node {
		Node(Node l, Node r, String v) {
			this.left = l;
			this.right = r;
			this.val = v;
		}

		boolean hasLeft() {
			return (this.left != null);
		}

		boolean hasRight() {
			return (this.right != null);
		}

		boolean isLeaf() {
			return (!this.hasLeft() && !this.hasRight());
		}

		Node left = null;
		Node right = null;
		public String val = "";
	}
	private Node root = null;
	
	public static void main(String[] args) {
		srm_308_div1_2 test = new srm_308_div1_2();
		String[] dictionary = new String[]{
		"0",
		"111",
		"10"
		};
		System.out.println(test.decode("1110010", dictionary));
	}
}
