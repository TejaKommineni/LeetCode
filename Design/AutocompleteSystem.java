package LeetCode.Design;

import java.util.*;

public class AutocompleteSystem {
    private TrieNode rootNode;
    private TrieNode curNode;
    private StringBuilder input;

    private class TrieNode implements Comparable<TrieNode>{
        String sentence;
        int count;
        TrieNode parent;
        TrieNode[] children;
        List<TrieNode> top3;

        public TrieNode(TrieNode parent) {
            this.parent = parent;
            children = new TrieNode[128];
            top3 = new ArrayList<TrieNode>();
        }
        public int compareTo(TrieNode node) {
            if (this.count == node.count) {
                return this.sentence.compareTo(node.sentence);
            }
            return node.count - this.count;
        }
    }

    private boolean checkEqual(TrieNode node1, TrieNode node2) {
        return node1.sentence.equals(node2.sentence);
    }

    private void addSentence(String sentence, int count) {
        TrieNode node = rootNode;

        // get to the leave node.
        for (char c : sentence.toCharArray()) {
            if (node.children[c] == null) {
                node.children[c] = new TrieNode(node);   // set parent as current node
            }
            node = node.children[c];
        }
        node.sentence = sentence;
        node.count = node.count + count;

        // pop up from leave node all the way to root node.  update top3
        TrieNode cur = node;
        while (cur.parent != null) {
            if (cur.top3.size() == 0) {
                cur.top3.add(node);
            }
            else {
                boolean contains = false;
                for (TrieNode n : cur.top3) {
                    if (checkEqual(n, node)) {
                        contains = true;
                        break;
                    }
                }

                if (!contains) {
                    cur.top3.add(node);
                }
                Collections.sort(cur.top3);
                if (cur.top3.size() > 3) {
                    cur.top3.remove(cur.top3.size() - 1);
                }
            }

            cur = cur.parent;
        }


    }

    // assume curNode never be null
    private List<String> inputHelper(char c){
        input.append(c);

        if (curNode == null || curNode.children[c] == null) {
            curNode = null;
            return new ArrayList<String>();
        }

        List<String> res = new ArrayList<>();
        TrieNode next = curNode.children[c];
        for (TrieNode node : next.top3) {
            res.add(node.sentence);
        }

        curNode = next;
        return res;
    }

    public AutocompleteSystem(String[] sentences, int[] times) {
        rootNode = new TrieNode(null);
        curNode = rootNode;
        input = new StringBuilder();

        for (int i=0; i<sentences.length; i++) {
            addSentence(sentences[i], times[i]);
        }

    }

    public List<String> input(char c) {
        if (c == '#') {
            addSentence(input.toString(), 1);

            input = new StringBuilder();
            curNode = rootNode;
            return new ArrayList<String>();
        }
        else {
            return inputHelper(c);
        }
    }


}