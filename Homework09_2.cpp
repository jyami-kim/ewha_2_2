#include <stdio.h>
#include <stdlib.h>
#include <string.h>


# define RAND_MAX 10000;



typedef struct TreeNode {
	int key;
	struct TreeNode* left;
	struct TreeNode* right;
}TreeNode;

typedef struct TreeType {
	TreeNode* root;
}TreeType;

void init(TreeType* bt) {
	bt->root = NULL;
}

void insert_node(TreeType *bt, int key) {
	TreeNode *p, *t;
	TreeNode *n;
	t = bt->root;
	p = NULL;

	while (t != NULL) {
		if (key == t->key) {
			return;
		}
		else {
			p = t;
			if (key < t->key)
				t = t->left;
			else
				t = t->right;
		}
	}

	n = (TreeNode *)malloc(sizeof(TreeNode));
	if (n == NULL) return;
	
	n->key = key;
	n->left = n->right = NULL;

	if (p != NULL) {
		if (key < p->key)
			p->left = n;
		else p->right = n;
	}
	else {
		bt->root = n;
	}
}

void inorder(TreeNode* node) {
	if (node != NULL) {
		inorder(node->left);
		printf("%d ", node->key);
		inorder(node->right);
	}
}

int main() {
	int input_size = 1000;

	// output: sorted result
	int *input = (int *)malloc(sizeof(int)*input_size);

	TreeType* bt = (TreeType *)malloc(sizeof(TreeType));
	init(bt);

	// Generate an input data randomly
	printf("===== bst sort 이전 =====\n");
	for (int i = 0; i < input_size; i++) {
		input[i] = rand();
		printf("%d  ", input[i]);
		insert_node(bt, input[i]);
	}

	printf("\n===== bst sort 이후 =====\n");
	inorder(bt->root);
}



