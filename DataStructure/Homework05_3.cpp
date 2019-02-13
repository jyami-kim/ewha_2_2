#include <stdio.h>


typedef struct TreeNode {
	char data;
	struct TreeNode *left, *right, *parent;
} TreeNode;

// G
// C F
// A B D E

TreeNode n1, n2, n3, n4, n5, n6, n7;

TreeNode *tree_predecessor(TreeNode *p)
{
	TreeNode *x, *y;

	x = p; y = NULL;

	if (x->left != NULL) {// 자식요소가 있다.
		x = x->left;
		while (x->right != NULL) {
			x = x->right;
		}  // x left 노드의 right most node로 이동
		return x;
	}

	y = x->parent;
	while ((y != NULL) && (x == (y->left))) {
		x = y;
		y = y->parent;
	}
	return y;
}

int main()
{
	n1 = { 'A', NULL, NULL, &n3 };
	n2 = { 'B', NULL, NULL, &n3 };
	n3 = { 'C', &n1, &n2, &n7 };
	n4 = { 'D', NULL, NULL, &n6 };
	n5 = { 'E', NULL, NULL, &n6 };
	n6 = { 'F', &n4, &n5, &n7 };
	n7 = { 'G', &n3, &n6, NULL };
	TreeNode *exp = &n7;

	TreeNode *q = exp;

	while (q->right) q = q->right; // Go to the leftmost node

	do
	{
		printf("%c\n", q->data); // Output data
		q = tree_predecessor(q); // Call the successor
	} while (q); // If not null
}