package LeetCode;

import java.util.TreeSet;

public class Google2 {

	public static void main(String[] args) {

		int[] flow = { 1, 3, 2, 5, 4 };

		System.out.println(kslots(flow, 1));
		System.out.println(kEmptySlots(flow, 1));
		
	}

	public static int kEmptySlots(int[] flowers, int k) {
        if (flowers == null || flowers.length < 1) {
            return -1;
        }
         
        // core logic
        TreeSet<Integer> bloomingTreeSet = new TreeSet<>();
        int day = 0;
        for(int flower: flowers) {
            day++;
            bloomingTreeSet.add(flower);
            Integer higher = bloomingTreeSet.higher(flower);
            Integer lower = bloomingTreeSet.lower(flower);
            if (higher != null && higher - flower - 1 == k || 
                lower != null && flower - lower - 1 == k ) {
                return day;
            }
        }
         
        return -1;
     }
	
	public static int kslots(int[] p, int k) {

		TreeSet<Integer> set = new TreeSet<>();

		for (int i = 0; i < p.length; i++) {

			set.add(p[i]);

		}

		if (k == p.length)

			return p.length;

		for (int i = p.length - 1; i >= 0; i--) {

			if (isThere(set, p[i], k, p.length)) {

				return i;

			}

			set.remove(p[i]);

		}

		return -1;

	}

	// this is variant -1.

	public static boolean isThere(TreeSet<Integer> set, int current, int k, int n) {

		int dif = (current - k) - 1;

		int add = current + k + 1;

		int currentIndex = set.headSet(current).size();

		int prevIndex = set.contains(dif) ? set.headSet(dif).size() : -1;

		int nextIndex = set.contains(add) ? set.headSet(add).size() : -1;

		// if else at start

		if (prevIndex == -1 && (dif == 0 && currentIndex == 0))

			return true;

		else if (prevIndex == -1 && currentIndex != 0)

			return false;

		// if at end

		if (nextIndex == -1 && (add == n + 1 && currentIndex == set.size() - 1))

			return true;

		else if (nextIndex == -1 && currentIndex != set.size() - 1)

			return false;

		// middle

		if (((prevIndex != -1) && (prevIndex + 1 == currentIndex))

				|| (currentIndex != -1 && (currentIndex + 1 == nextIndex)))

			return true;

		return false;

	}

	// Variant - 2: this is the latest variant. You may get this question. This
	// looks for a blossoming group.

	public static boolean isThereGroup(TreeSet<Integer> set, int current, int k, int n) {

		Integer left = set.lower(current);

		Integer right = set.higher(current);

		int leftMin = set.first();

		int rightMax = set.last();

		if (left != null && ((left - leftMin) + 1 == k) || (right != null && (rightMax - right) + 1 == k)) {

			return true;

		}

		return false;

	}

}