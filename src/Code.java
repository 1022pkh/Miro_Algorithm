import java.util.LinkedList;
import java.util.Queue;

public class Code {

	static int graph[][] = { { 0, 1, 1, 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 1, 0, 0, 0 }, { 1, 0, 0, 1, 0, 0, 1, 0 },
			{ 0, 0, 1, 0, 0, 1, 1, 0 }, { 0, 1, 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0, 1, 1 },
			{ 0, 0, 1, 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 1, 1, 0, 0 } };

	static Queue<Integer> queue = new LinkedList<Integer>();
	static int[] visitGraph = new int[graph.length];

	/*
	 * BFS 알고리즘 너비우선탐색
	 */
	public static void BFS(int startNode) {

		// 초기상태 : 모든 노드 방문하지 않은 상태.
		for (int i = 0; i < graph.length; i++)
			visitGraph[i] = 0;

		// 시작 노드는 방문 상태로.
		visitGraph[startNode - 1] = 1;

		queue.add(startNode);

		while (!queue.isEmpty()) {

			int current = queue.remove();
			System.out.print(current + " ");

			for (int i = 0; i < graph.length; i++) {

				if (graph[current - 1][i] == 1) {

					if (visitGraph[i] == 0) {
						visitGraph[i] = 1;
						queue.add(i + 1);
					}

				}

			}

		}

	}

	/*
	 * DFS 알고리즘 깊이우선탐색
	 */
	public static void DFS() {

		// 초기상태 : 모든 노드 방문하지 않은 상태.
		for (int i = 0; i < graph.length; i++)
			visitGraph[i] = 0;

		for (int i = 0; i < visitGraph.length; i++) {
			if (visitGraph[i] == 0){
				System.out.print(i+1 + " ");
				aDFS(i);
			}
		}
	}

	public static void aDFS(int node) {
		visitGraph[node] = 1;
		for (int i = 0; i < graph.length; i++) {

			if (graph[node][i] == 1) {

				if (visitGraph[i] == 0) {
					System.out.print(i+1 + " ");
					aDFS(i);
				}

			}

		}

	}

	public static void main(String[] args) {

		for (int i = 0; i < graph.length * graph[0].length; i++) {
			int row = i / graph[0].length; // 행
			int column = i % graph[0].length; // 열
			System.out.print(graph[row][column] + "\t");

			if (column == graph[0].length - 1) {
				System.out.println();
			}

		}

		System.out.println("--------");

		BFS(1);

		System.out.println();
		System.out.println("--------");

		DFS();

	}
}
