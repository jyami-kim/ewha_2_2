[Homework05_1]
postorder traversal�� ���� ������ �����Ͻÿ�

[Homework05_2]
treenode�� successor�� ã�� �Լ� tree_sucessor�� �����ϰ�, inorder traversal�� �°�
tree node�� data���� ����Ͻÿ�.

����1) Node�� �Ʒ��� ���� define �Ǿ��ִ�.
typedef struct TreeNode {
	char data
	TreeNode *left
	TreeNode *right
	TreeNode *parent
} TreeNode;

����2) Ʈ������� �迭�� ������ ����.
	n1 = { 'A', NULL, NULL, &n3 };
	n2 = { 'B', NULL, NULL, &n3 };
	n3 = { 'C', &n1, &n2, &n7 };
	n4 = { 'D', NULL, NULL, &n6 };
	n5 = { 'E', NULL, NULL, &n6 };
	n6 = { 'F', &n4, &n5, &n7 };
	n7 = { 'G', &n3, &n6, NULL };

����3) inorder traversal�� ����ϱ� ���� main()�Լ��� �Ʒ��� ����.
	TreeNode *q = exp;
	while (q->left) q = q->left; // Go to the leftmost node
	do
	{
		printf("%c\n", q->data); // Output data
		q = tree_successor(q); // Call the successor
	} while (q); // If not null
}



���� ���
========
A
C
B
G
D
F
E


[Homework05_3]
treenode�� predecessor�� ã�� �Լ� tree_predecessor�� �����ϰ�, inorder traversal�� �°�
tree node�� data���� ����Ͻÿ�.

����1) Node�� �Ʒ��� ���� define �Ǿ��ִ�.
typedef struct TreeNode {
	char data
	TreeNode *left
	TreeNode *right
	TreeNode *parent
} TreeNode;

����2) Ʈ������� �迭�� ������ ����.
	n1 = { 'A', NULL, NULL, &n3 };
	n2 = { 'B', NULL, NULL, &n3 };
	n3 = { 'C', &n1, &n2, &n7 };
	n4 = { 'D', NULL, NULL, &n6 };
	n5 = { 'E', NULL, NULL, &n6 };
	n6 = { 'F', &n4, &n5, &n7 };
	n7 = { 'G', &n3, &n6, NULL };

����3) inorder traversal�� ����ϱ� ���� main()�Լ��� �Ʒ��� ����.
	TreeNode *q = exp;

	while (q->right) q = q->right; // Go to the leftmost node

	do
	{
		printf("%c\n", q->data); // Output data
		q = tree_predecessor(q); // Call the successor
	} while (q); // If not null



���� ���
========
E
F
D
G
B
C
A