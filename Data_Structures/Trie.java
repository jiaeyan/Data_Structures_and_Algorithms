package data_structures;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Trie {

    // Returns the node which contains the whole prefix
	public Trie_Node prefix(Trie_Node root, String prefix) {
		Trie_Node temp = root;
		for (char ch : prefix.toCharArray()) {
			if (temp.children.get(ch) != null)
				temp = temp.children.get(ch);  //one char is one level in the tree, so we have to get down by temp = temp.children
			else return null;
		}
		return temp;
	}
	
	// Returns if the word is in the trie.
	public boolean search(Trie_Node root, String word) {
		Trie_Node node = prefix(root, word);
		return node != null && node.isEnd;
	}
	
	// Returns if there is any word in the trie
    // that starts with the given prefix.
	public boolean start(Trie_Node root, String prefix) {
		Trie_Node node = prefix(root, prefix);
		return node != null;
	}
	
	public void insert(Trie_Node root, String word) {
		Trie_Node temp = root;
		for (char ch : word.toCharArray()) {
			if (temp.children.get(ch) == null)
				temp.children.put(ch, new Trie_Node(ch));
			temp = temp.children.get(ch);
		}
		temp.isEnd = true;
	}
	
	public void delete(Trie_Node root, String word) {}
	
	//Display all words in given tire.
	public void showWords(Trie_Node root, StringBuilder sb, List<String> list){
		if (root == null) return;
		for (Map.Entry<Character, Trie_Node> entry : root.children.entrySet()) {
			Character ch = entry.getKey();
			Trie_Node node = entry.getValue();
			sb.append(ch);
			if (node.isEnd) list.add(sb.toString());
			showWords(node, sb, list);
			sb.deleteCharAt(sb.length()-1);
		}
	}
	
	public static void main(String[] args) {
		Trie t = new Trie();
		Trie_Node root = new Trie_Node();
		String[] strs = new String[] {"this", "is", "a", "test", "testment"};
		for (String str:strs) {t.insert(root, str);}
		System.out.println(t.search(root, "an"));
		t.insert(root, "an");
		System.out.println(t.search(root, "an"));
		t.insert(root, "is");
		System.out.println(t.search(root, "this"));
		System.out.println(t.search(root, "test"));
		System.out.println(t.search(root, "testment"));
		System.out.println(t.start(root, "testmen"));
		StringBuilder sb = new StringBuilder();
		List<String> list = new ArrayList<>();
		t.showWords(root, sb, list);
		for (String str:list) {System.out.println(str);}
	}

}