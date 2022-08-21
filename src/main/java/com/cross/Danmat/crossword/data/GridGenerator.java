package com.cross.Danmat.crossword.data;
import java.util.ArrayList;

public class GridGenerator {
	
	private char[][] grid;
	private int gridLength;
	
	public GridGenerator (int length) {  // ������
		this.grid = new char[length][length];
		this.gridLength = length;
		for (int i = 0; i < this.gridLength; i++) {
			for (int j = 0; j < this.gridLength; j++) {
				this.grid[i][j] = 'O';
			}
		}
	}
	
	// ������: �׸��带 �׸��� �����ι�
	
	private void closeSquare (int x, int y) {  // ĭ �ݱ�
		this.grid[x][y] = 'X';
	}
	
	private void symmetricalCloser(int x, int y) {  // ��Ī�Ͽ� �ݱ�, (�׸����� ���̰� Ȧ���� ��츸)
		int median = this.gridLength / 2;
		closeSquare(x, y);
		int rowDifference = median - x;
		int columnDifference = median - y;
		closeSquare (median + rowDifference, median + columnDifference);
	}
	
	private void randomlyAndSymmetricallyClose() {  // �������� �ݵ�, ���� ĭ�� ��Ī�Ǵ� ĭ�� �Բ� �ݱ�
		int x = (int) (Math.random() * 10);
		int y = (int) (Math.random() * 10);
		
			if (x < this.gridLength && y < this.gridLength && this.grid[x][y] == 'O') {
				symmetricalCloser(x, y);
			}
			else {
				randomlyAndSymmetricallyClose();
			}
	}
	
	private void randomlyAndSymmetricallyCloseForLargeSize() {  
		// ũ�Ⱑ ū �׸��带 ���� ������ �� ��Ī �ݱ�
		int a = (int) (Math.random() * 10);
		int b = (int) (Math.random() * 10);
		int c = (int) (Math.random() * 10);
		int d = (int) (Math.random() * 10);
		int x = a + b;
		int y = c + d;
		
			if ( x < this.gridLength && y < this.gridLength && this.grid[x][y] == 'O') {
				symmetricalCloser(x, y);
			}
			else {
				randomlyAndSymmetricallyCloseForLargeSize();
			}
	}
	
	private void recursiveRowCloser (int x, int y) { 
		// �ϳ��� ���� �� ĭ�� �ǳʶپ� �����鼭 �׿� ��Ī�Ǵ� ĭ�� �Բ� �ݱ�
		if (y + 2 <= this.gridLength + 1) {
			symmetricalCloser(x, y);
			y = y + 2;
			recursiveRowCloser (x, y);
		}
	}
	
	public void makeAtOnce () {  // �پ��� �޼ҵ带 ��� �� �� �׸��� �����
		// ������ �Ʒ��������� �׸����� �߰������� �� ĭ�� ����� (�� ĭ�� ����� ���� �ݴ�) recursiveRowCloser ���� 
		for (int i = 0; i < this.gridLength / 2 + 1; i += 2) { // (1, 0), �� i = 1�������� �ݾƵ� ����
			recursiveRowCloser(i, 0);
		}
		// �� �� ����ȭ�� �׸��忡 ���ؼ� �����ϰ� ĭ �ݱ�
		if (this.gridLength == 11) { 
			for (int i = 1; i < 9; i++) { // �׸����� ���̰� 11�� ��� i < 9, 13�� ��� i < 14�� ����..
				randomlyAndSymmetricallyClose();
			}
		} else if (this.gridLength == 13) {
			for (int i = 1; i  < 14; i++) {
				randomlyAndSymmetricallyClose();
			}
		} else if (this.gridLength == 15) {
			for (int i = 1; i < 21; i++) {
				randomlyAndSymmetricallyClose();
			}
		} else if (this.gridLength == 17) {
			for (int i = 1; i < 29; i++) {
				randomlyAndSymmetricallyCloseForLargeSize();
			}
		} else if (this.gridLength == 19) {
			for (int i = 1; i < 34; i++) {
				randomlyAndSymmetricallyCloseForLargeSize();
			}
		}
		if (wellFormednessValidator() == false) { // ������ �׸��尡 �ƴ� ���, �ٽ� �ݺ�
			openAtOnce();
			makeAtOnce();
		}
	}
	
	private void openAtOnce() { // ��� ĭ�� ����, i.e. �׸��� �ʱ�ȭ
		for (int i = 0; i < this.gridLength; i++) {
			for (int j = 0; j < this.gridLength; j++) {
				this.grid[i][j] = 'O';
			}
		}
	}
	// ������ ��
	
	// ��� ����� - ������ �׸��尡 ������ �ִ� ��Ͽ� ���� ������ ����Ʈ�� ����Ʈ�� ���·� �����ϴ� �����ι�
	private int rightwardSquareCounter(int x, int y) { // �Էµ� ��ǥ�� ������ ��ǥ�� ������ ���� ��ĭ ���� ���ϱ�
		int count = 0;
		if (y < this.gridLength) {
			if (this.grid[x][y] == 'O') {
				count++;
				count += rightwardSquareCounter(x, y + 1);
			}
		}
		return count;
	}
	private int leftwardSquareCounter(int x, int y) { // �Էµ� ��ǥ�� ������ ��ǥ�� ���� ���� ��ĭ ���� ���ϱ�
		int count = 0;
		if (y > -1) {
			if (this.grid[x][y] == 'O') {
				count++;
				count += leftwardSquareCounter(x, y - 1);
			}
		}
		return count;
	}
	private int downwardSquareCounter(int x, int y) { // �Էµ� ��ǥ�� ������ ��ǥ�� �Ʒ��� ���� ��ĭ ���� ���ϱ�
		int count = 0;
		if (x < this.gridLength) {
			if (this.grid[x][y] == 'O') {
				count++;
				count += downwardSquareCounter(x + 1, y);
			}
		}
		return count;
	}
	private int upwardSquareCounter(int x, int y) { // �Էµ� ��ǥ�� ������ ��ǥ�� ���� ���� ��ĭ ���� ���ϱ�
		int count = 0;
		if (x > -1) {
			if (this.grid[x][y] == 'O') {
				count++;
				count += upwardSquareCounter(x - 1, y);
			}
		}
		return count;
	}
	private int horizontalSquareCounter(int x, int y) {
		// �Էµ� ��ǥ�� ����� ���� ��ĭ ���� ���ϱ�
		if (this.grid[x][y] == 'X') {
			return -30;
		}
		else {
			return rightwardSquareCounter(x, y) + leftwardSquareCounter(x, y) - 1;
		}
	}
	private int verticalSquareCounter(int x, int y) {
		// �Էµ� ��ǥ�� ����� ���� ��ĭ ���� ���ϱ�
		if (this.grid[x][y] == 'X') {
			return -30;
		}
		else {
			return downwardSquareCounter(x, y) + upwardSquareCounter(x, y) - 1;
		}
	}
	private int getBlockType(int x, int y) {
		// �Էµ� ��ǥ�� ��������� ��ϰ� ����Ǿ� �ִ��� ���������� ��ϰ� ����Ǿ� �ִ���,
		// �ƴϸ� �� �� ���� �˾Ƴ���
		if (horizontalSquareCounter(x, y) > 1 && verticalSquareCounter(x, y) > 1) {
			return -50; // ��������� ���, ���������� ��� �� �ٿ� ����Ǿ� �ִ� ���
		}
		else if (horizontalSquareCounter(x,y) > 1 && verticalSquareCounter(x, y) == 1) {
			return 100; // ��������� ��ϰ� ����Ǿ� �ִ� ���
		}
		else if (horizontalSquareCounter(x,y) == 1 && verticalSquareCounter(x,y) > 1) {
			return -100; // ���������� ��ϰ� ����Ǿ� �ִ� ���
		}
		else if (horizontalSquareCounter(x,y) == -30 && verticalSquareCounter(x,y) == -30) {
			return -30; // ��ǥ�� �����ִ� ���, �� "X" �ΰ��
		}
		else {
			return -1;
		}
	}
	private int horizontalCoordinateFinder(int x, int y) {
		// �Էµ� ��ǥ�� ���򼱻����� ����Ǿ� �ִ� ����� ���ʳ� ��ǥ ���ϱ�
		if (this.grid[x][y] == 'X') { // �Էµ� ��ǥ�� �������� ���
			return -1;
		}
		else {
			for (int i = y; i > -1; i--) {
				if (this.grid[x][i] == 'X') { // ex) (1,3)���� "X"�� ������ ���, ����� ���ʳ� ��ǥ�� (1,4)��
					return i + 1;
				}
			}
		return 0; // "X"�� ������ �ʾ��� ���, �� y�� ��ǥ 0���� ���� ���.
		}
	}
	private int verticalCoordinateFinder(int x, int y) {
		// �Էµ� ��ǥ�� ������������ ����Ǿ� �ִ� ����� �� �� ��ǥ ���ϱ�
		if (this.grid[x][y] == 'X') {
			return -1;
		}
		else {
			for (int i = x; i > -1; i--) {
				if (this.grid[i][y] == 'X') { // ex) (2,2)���� "X"�� ������ ���, ����� �� �� ��ǥ�� (2,3)��
					return i + 1;
				}
			}
		return 0; // "X"�� ������ �ʾ��� ���, �� x�� ��ǥ 0���� ���� ���.
		}
	}
	private int[] getInfoOfBlock(int x, int y) { // �Էµ� ��ǥ�� ����Ǿ� �ִ� ����� ���� ȹ��
		// ��ĭ�� ����: x��ǥ, y��ǥ, ����, ����(����, ����), �������� ����
		int xCoordinate = -1;
		int yCoordinate = -1;
		int length = -1;
		int type = getBlockType(x, y);
		int intersection = -1;
		
		if (type == 100) { // ����� ����� ������ ���
			xCoordinate = x;
			yCoordinate = horizontalCoordinateFinder(x, y);
			length = horizontalSquareCounter(x, y);
			int count = 0;
			for (int i = yCoordinate; i < length + yCoordinate; i++) {
				if (verticalSquareCounter(xCoordinate, i) > 1) {
					count++;
				}
			}
			intersection = count;
		}
		else if (type == -100) { // ����� ����� ������ ���
			xCoordinate = verticalCoordinateFinder(x, y);
			yCoordinate = y;
			length = verticalSquareCounter(x, y);
			int count = 0;
			for (int i = xCoordinate; i < length + xCoordinate; i++) {
				if (horizontalSquareCounter(i, yCoordinate) > 1) {
					count++;
				}
			}
			intersection = count;
		}
		else if (type == -50) {  // ��ǥ�� �������� ����, ������ �ߺ��ǹǷ� ���� ĭ�� ���� �����ϰ� ó��
			xCoordinate = 0;
			yCoordinate = 0;
			length = 0;
			type = 0;
			intersection = 0;
		}
		else if (type == -30) { // ���� ĭ, �� "X"�� ���
			xCoordinate = 0;
			yCoordinate = 0;
			length = 0;
			type = 0;
			intersection = 0;
		}
		int[] info = {xCoordinate, yCoordinate, length, type, intersection};
		return info;
	}
	public ArrayList<int[]> getEveryInfoOfBlocks() { 
		//  n x n �׸��� �� �����ϴ� ��� ��ǥ�� ����� ����� ���� ȹ��
		ArrayList<int[]> everyBlock = new ArrayList<int[]>();
		for (int i = 0; i < this.gridLength; i++) {
			for (int j = 0; j < this.gridLength; j++) {
				everyBlock.add(getInfoOfBlock(i, j));
			}
		}
	return everyBlock;
	}
	// ��� ����� ��
	
	// �׸��� �˻��: ������ �׸��尡 ���������� �����ϴ� ����(well-formed)�� �׸�������, �Ǵ� "������" �׸������� �˻��ϴ� �����ι�
	public int closedSquareCounter() { // ���� �ִ� ĭ�� ���� ����
		int count = 0;
		for (int i = 0; i < this.gridLength; i++) {
			for (int j = 0; j < this.gridLength; j++) {
				if (this.grid[i][j] == 'X') {
					count++;
				}
			}
		}
		return count;
	}
	public int openedSquareCounter() { // ���� ĭ�� ���� ����
		int count = 0;
		for (int i = 0; i < this.gridLength; i++) {
			for (int j = 0; j < this.gridLength; j++) {
				if (this.grid[i][j] == 'O') {
					count++;
				}
			}
		}
		return count;
	}
	public boolean wellFormednessValidator() {  // �׸��尡 ���������� �����ϴ� ������ �׸������� �˻��ϱ�
		for (int i = 0; i < this.gridLength; i++) {
			for (int j = 0; j < this.gridLength; j++) {
				int[] temp = getInfoOfBlock(i, j);
					int xCoordinate = temp[0];
					int yCoordinate = temp[1];
					int length = temp[2];
					int type = temp[3];
					if (xCoordinate == -1 && yCoordinate == -1 && length == -1 && type == -1) {
						// ���� ���(���� ������ ���̰� 1�� ���)�� �����ϴ� ���̽�
						return false;
					}
			}
		}
		return true;
	}
	public void showGrid() {   // �׸��� �����ֱ�
		for (int i = 0; i < this.gridLength; i++) {
			for (int j = 0; j < this.gridLength; j++) {
				System.out.print(this.grid[i][j] + " ");
			}
			System.out.println("");
		}
	}
	// �׸��� �˻�� ��
}
