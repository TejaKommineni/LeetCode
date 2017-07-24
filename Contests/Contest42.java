package LeetCode.Contests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Contest42 {

	class TrieNode {
		char c;
		HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
		boolean isLeaf;

		public TrieNode() {
		}

		public TrieNode(char c) {
			this.c = c;
		}
	}

	public class Trie {
		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		// Inserts a word into the trie.
		public void insert(String word) {
			HashMap<Character, TrieNode> children = root.children;

			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);

				TrieNode t;
				if (children.containsKey(c)) {
					t = children.get(c);
				} else {
					t = new TrieNode(c);
					children.put(c, t);
				}

				children = t.children;

				// set leaf node
				if (i == word.length() - 1)
					t.isLeaf = true;
			}
		}

		public String searchNode(String str) {
			Map<Character, TrieNode> children = root.children;
			TrieNode t = null;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (children.containsKey(c)) {

					t = children.get(c);
					children = t.children;
					if (t != null && t.isLeaf)
						return str.substring(0, i + 1);
				} else {
					return str;
				}

			}

			return str;
		}
	}

	public String replaceWords(List<String> dict, String sentence) {

		Trie tried = new Trie();
		for (int i = 0; i < dict.size(); i++) {
			tried.insert(dict.get(i));
		}
		String sentenced[] = sentence.split(" ");
		String answer = "";
		for (int i = 0; i < sentenced.length; i++) {
			answer = answer + " " + tried.searchNode(sentenced[i]);
		}
		return answer.trim();
	}

	public int findLongestChain(int[][] pairs) {

		Arrays.sort(pairs, new Comparator<int[]>() {

			public int compare(int[] a, int[] b) {
				if (a[0] == b[0])
					return a[1] - b[1];
				else
					return a[0] - b[0];
			}
		}

		);
		int count = 0;
		int mem[] = new int[pairs.length];
		mem[0] = 1;
		for (int i = 0; i < pairs.length; i++) {
			for (int j = 0; j < i; j++) {
				if (pairs[j][1] < pairs[i][0]) {

					mem[i] = Math.max(mem[i], mem[j] + 1);
					count = Math.max(count, mem[i]);
				}
			}

		}
		return count;
	}

	public static boolean isPalindrome(String s, int start, int end) {
		if (start == end)
			return true;
		for (int i = 0; i <= (end - start) / 2; i++) {
			if (s.charAt(i + start) != s.charAt(end - i))
				return false;
		}

		return true;

	}

	public int countSubstrings(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = s.length() - 1; j >= i; j--) {
				if (s.charAt(i) == s.charAt(j)) {
					if (isPalindrome(s, i, j))
						count++;
				}
			}
		}
		return count;

	}

	public static void main(String[] args) {
		Contest42 c = new Contest42();
		List dict = new ArrayList();
		dict.add("cat");
		dict.add("bat");
		dict.add("rat");

		System.out.println(c.replaceWords(dict, "the cattle was rattled by the battery"));

	}
}