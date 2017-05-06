import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
	int x;
	int y;
	int len;

	public void setNode(int x, int y, int len) {
		this.x = x;
		this.y = y;
		this.len = len;
	}
}

public class Miro {

	static int[][] miro;
	static int[][] visitMiro;
	static Queue<Node> queue = new LinkedList<Node>();
	static int totalCount;

	/*
	 * BFS 알고리즘 너비우선탐색
	 */
	public static void BFS() {

		// 시작 노드는 방문 상태로.
		visitMiro[0][0] = 1;

		Node tempNode = new Node();
		tempNode.setNode(0, 0, 1);

		queue.add(tempNode);

		while (!queue.isEmpty()) {

			Node currentNode = queue.remove();
//			System.out.print("x : " + currentNode.x + " , y :" + currentNode.y+" , len : " + currentNode.len);
//			System.out.println();
			//
			// 목표지점도달 정지.
			if (currentNode.x == miro.length - 1 && currentNode.y == miro[0].length - 1) {
				totalCount = currentNode.len;
				break;
			}

			// 상,하,좌,우 검사
			// 상
			if ((currentNode.x - 1) > -1) {

				if (miro[currentNode.x - 1][currentNode.y] == 1) {

					if (visitMiro[currentNode.x - 1][currentNode.y] == 0) {

						visitMiro[currentNode.x - 1][currentNode.y] = 1;

						tempNode = new Node();
						tempNode.setNode(currentNode.x - 1, currentNode.y, currentNode.len+1);

						queue.add(tempNode);
					}

				}

			}

			// 하
			if ((currentNode.x + 1) < miro.length) {
				if (miro[currentNode.x + 1][currentNode.y] == 1) {

					if (visitMiro[currentNode.x + 1][currentNode.y] == 0) {

						visitMiro[currentNode.x + 1][currentNode.y] = 1;

						tempNode = new Node();
						tempNode.setNode(currentNode.x + 1, currentNode.y, currentNode.len+1);

						queue.add(tempNode);
					}

				}
			}

			// 좌
			if ((currentNode.y - 1) > -1) {
				if (miro[currentNode.x][currentNode.y - 1] == 1) {

					if (visitMiro[currentNode.x][currentNode.y - 1] == 0) {

						visitMiro[currentNode.x][currentNode.y - 1] = 1;

						tempNode = new Node();
						tempNode.setNode(currentNode.x, currentNode.y - 1, currentNode.len+1);

						queue.add(tempNode);
					}

				}
			}

			// 우
			if ((currentNode.y + 1) < miro[0].length) {
				if (miro[currentNode.x][currentNode.y + 1] == 1) {

					if (visitMiro[currentNode.x][currentNode.y + 1] == 0) {

						visitMiro[currentNode.x][currentNode.y + 1] = 1;

						tempNode = new Node();
						tempNode.setNode(currentNode.x, currentNode.y + 1, currentNode.len+1);

						queue.add(tempNode);
					}

				}
			}

		}

	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n_size = scan.nextInt();
		int m_size = scan.nextInt();
		scan.nextLine();

		miro = new int[n_size][m_size];
		visitMiro = new int[n_size][m_size];

		String line;

		/*
		 * 미로 상태 입력 받은 후...정렬
		 */
		for (int i = 0; i < n_size; i++) {

			line = scan.nextLine();
			char[] chars = line.toCharArray();
			int j = 0;

			for (char ch : chars) {
				if (ch == '1')
					miro[i][j++] = 1;
				else
					miro[i][j++] = 0;
			}

		}

		/*
		 * 방문 배열 초기화
		 */
		for (int i = 0; i < n_size; i++) {

			for (int j = 0; j < m_size; j++) {
				visitMiro[i][j] = 0;
			}

		}

		// System.out.println();
		// for (int i = 0; i < n_size; i++) {
		//
		// for (int j = 0; j < m_size; j++) {
		// System.out.print(miro[i][j] + " ");
		// }
		//
		// System.out.println();
		// }

		BFS();

		System.out.println(totalCount);

	}

}
