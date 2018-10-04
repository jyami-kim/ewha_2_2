#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

#define MAX_TERMS 10

typedef struct {
	int row;
	int col;
	int value;
} element;

typedef struct SparseMatrix {
	element data[MAX_TERMS];
	int rows; //matrix size
	int cols; //matrix size
	int terms; // number of non-zero
} SparseMatrix;

SparseMatrix matrixInput() {
	SparseMatrix m;
	printf("Input row size: ");
	scanf("%d", &m.rows);
	printf("Input col size: ");
	scanf("%d", &m.cols);
	printf("Input terms(maximum is 10): ");
	scanf("%d", &m.terms);
	for (int i = 0; i < m.terms; i++) {
		printf("Input numbers by format row col value : ");
		scanf("%d %d %d", &m.data[i].row, &m.data[i].col, &m.data[i].value);
	}
	return m;
}

SparseMatrix transposMatrix(SparseMatrix m) {
	SparseMatrix trans;
	int count = 0;

	trans.rows = m.cols;
	trans.cols = m.rows;
	trans.terms = m.terms;

	while (count < m.terms) {
		trans.data[count].col = m.data[count].row;
		trans.data[count].row = m.data[count].col;
		trans.data[count].value = m.data[count].value;
		count++;
	}
	return trans;
}

void printMat(SparseMatrix m) {
	int r = m.rows;
	int c = m.cols;
	int term = m.terms;

	int **array = (int **)malloc(sizeof(int *)*r);
	for (int i = 0; i < r; i++) {
		array[i] = (int *)malloc(sizeof(int)*c);
	}
	
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			array[i][j] = 0;
		}
	}

	for (int i = 0; i < term; i++) {
		array[m.data[i].row][m.data[i].col] = m.data[i].value;
	}

	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			printf("%d ", array[i][j]);
		}
		printf("\n");
		free(array[i]);
	}
	free(array);
}

int main()
{
	//Add B as an input. USE your own example freely.
	SparseMatrix mat = matrixInput();
	printf("\nMatrix B\n");
	printMat(mat);
	printf("\nMatrix B^T\n");
	//Perform the transpose operation
	SparseMatrix transmat;
	transmat = transposMatrix(mat);
	printMat(transmat);
	return 0;
}