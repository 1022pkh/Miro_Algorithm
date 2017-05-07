import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class TomatoNode {
	int x;
	int y;
	int day;

	public void setNode(int x, int y, int day) {
		this.x = x;
		this.y = y;
		this.day = day;
	}
}

public class Tomato {

	static int[][] tomatoBox;
	static int[][] visitBox;
	static Queue<TomatoNode> queue = new LinkedList<TomatoNode>();
	static int totalDay = -1;

	/*
	 * BFS 알고리즘 너비우선탐색
	 */
	public static void BFS() {

		TomatoNode tempNode = new TomatoNode();
		TomatoNode currentNode = null;

		while (!queue.isEmpty()) {

			currentNode = queue.remove();
			visitBox[currentNode.x][currentNode.y] = 1;

			// System.out.print("x : " + currentNode.x + " , y :" +
			// currentNode.y + " , len : " + currentNode.day);
			// System.out.println();

			if (currentNode.day > totalDay)
				totalDay = currentNode.day;

			// 상,하,좌,우 검사
			// 상
			if ((currentNode.x - 1) > -1) {

				if (tomatoBox[currentNode.x - 1][currentNode.y] == 0) {

					if (visitBox[currentNode.x - 1][currentNode.y] == 0) {

						visitBox[currentNode.x - 1][currentNode.y] = 1;

						tempNode = new TomatoNode();
						tempNode.setNode(currentNode.x - 1, currentNode.y, currentNode.day + 1);

						queue.add(tempNode);
					}

				}

			}

			// 하
			if ((currentNode.x + 1) < tomatoBox.length) {
				if (tomatoBox[currentNode.x + 1][currentNode.y] == 0) {

					if (visitBox[currentNode.x + 1][currentNode.y] == 0) {

						visitBox[currentNode.x + 1][currentNode.y] = 1;

						tempNode = new TomatoNode();
						tempNode.setNode(currentNode.x + 1, currentNode.y, currentNode.day + 1);

						queue.add(tempNode);
					}

				}
			}

			// 좌
			if ((currentNode.y - 1) > -1) {
				if (tomatoBox[currentNode.x][currentNode.y - 1] == 0) {

					if (visitBox[currentNode.x][currentNode.y - 1] == 0) {

						visitBox[currentNode.x][currentNode.y - 1] = 1;

						tempNode = new TomatoNode();
						tempNode.setNode(currentNode.x, currentNode.y - 1, currentNode.day + 1);

						queue.add(tempNode);
					}

				}
			}

			// 우
			if ((currentNode.y + 1) < tomatoBox[0].length) {
				if (tomatoBox[currentNode.x][currentNode.y + 1] == 0) {

					if (visitBox[currentNode.x][currentNode.y + 1] == 0) {

						visitBox[currentNode.x][currentNode.y + 1] = 1;

						tempNode = new TomatoNode();
						tempNode.setNode(currentNode.x, currentNode.y + 1, currentNode.day + 1);

						queue.add(tempNode);
					}

				}
			}

		}

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n_size;
		int m_size;

		// 2 ≤ M,N ≤ 1,000
		while (true) {
			n_size = scan.nextInt();

			if (n_size >= 2 && n_size <= 1000)
				break;
		}

		while (true) {
			m_size = scan.nextInt();

			if (m_size >= 2 && m_size <= 1000)
				break;
		}

		scan.nextLine();

		tomatoBox = new int[m_size][n_size];
		visitBox = new int[m_size][n_size];

		/*
		 * 토마토 상태 입력 받은 후...정렬
		 */

		int status;

		for (int i = 0; i < m_size; i++) {
			for (int j = 0; j < n_size; j++) {
				tomatoBox[i][j] = scan.nextInt();
			}
		}

		/*
		 * 방문 배열 초기화
		 */
		for (int i = 0; i < m_size; i++) {

			for (int j = 0; j < n_size; j++) {
				visitBox[i][j] = 0;
			}

		}

		TomatoNode ripeTomato;
		int riptCount = 0;

		// 1. 익은 토마토 찾아야한다.
		for (int i = 0; i < tomatoBox.length * tomatoBox[0].length; i++) {
			int row = i / tomatoBox[0].length; // 행
			int column = i % tomatoBox[0].length; // 열

			if (tomatoBox[row][column] == 1) {
				ripeTomato = new TomatoNode();
				ripeTomato.setNode(row, column, 0);
				queue.add(ripeTomato);
				riptCount++;
			}

		}


		if (riptCount == n_size * m_size) {
			totalDay = 0;
		} else if (riptCount == 0) {
			totalDay = -1;
		} else {
			BFS();

			for (int i = 0; i < visitBox.length * visitBox[0].length; i++) {
				int row = i / visitBox[0].length; // 행
				int column = i % visitBox[0].length; // 열

				if (visitBox[row][column] == 0 && tomatoBox[row][column] == 0) {
					totalDay = -1;
					break;
				}

			}
		}

		System.out.println(totalDay);

	}
}
