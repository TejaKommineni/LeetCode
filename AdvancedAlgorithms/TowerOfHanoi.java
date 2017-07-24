package LeetCode.AdvancedAlgorithms;

public class TowerOfHanoi {
	static int count = 0;

	public static void towerOfHanoi(int n, char fromrod, char torod, char auxrod) {
		count++;
		if (fromrod == 'B') {
			System.out.println("\n Moving all rods from leaning rod " + fromrod
					+ " to rod " + torod);
			return;
		}
		if (n == 1) {
			System.out.println("\n Move disk " + 1 + " from rod " + fromrod
					+ " to rod " + torod);
			return;
		}

		towerOfHanoi(n - 1, fromrod, auxrod, torod);
		System.out.println("\n Move disk " + n + " from rod " + fromrod
				+ " to rod " + torod);
		towerOfHanoi(n - 1, auxrod, torod, fromrod);
	}

	public static void main(String[] args) {
		int n = 1; // Number of disks
		towerOfHanoi(n, 'A', 'C', 'B'); // A, B and C are names of rods
		System.out.println(count);

	}

}
