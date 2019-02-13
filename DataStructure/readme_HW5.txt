[Homework05_1]
postorder traversal의 유도 과정을 서술하시오

[Homework05_2]
treenode의 successor을 찾는 함수 tree_sucessor을 구현하고, inorder traversal에 맞게
tree node의 data값을 출력하시오.

조건1) Node는 아래와 같이 define 되어있다.
typedef struct TreeNode {
	char data
	TreeNode *left
	TreeNode *right
	TreeNode *parent
} TreeNode;

조건2) 트리노드의 배열은 다음과 같다.
	n1 = { 'A', NULL, NULL, &n3 };
	n2 = { 'B', NULL, NULL, &n3 };
	n3 = { 'C', &n1, &n2, &n7 };
	n4 = { 'D', NULL, NULL, &n6 };
	n5 = { 'E', NULL, NULL, &n6 };
	n6 = { 'F', &n4, &n5, &n7 };
	n7 = { 'G', &n3, &n6, NULL };

조건3) inorder traversal을 출력하기 위한 main()함수는 아래와 같다.
	TreeNode *q = exp;
	while (q->left) q = q->left; // Go to the leftmost node
	do
	{
		printf("%c\n", q->data); // Output data
		q = tree_successor(q); // Call the successor
	} while (q); // If not null
}



예제 출력
========
A
C
B
G
D
F
E


[Homework05_3]
treenode의 predecessor을 찾는 함수 tree_predecessor을 구현하고, inorder traversal에 맞게
tree node의 data값을 출력하시오.

조건1) Node는 아래와 같이 define 되어있다.
typedef struct TreeNode {
	char data
	TreeNode *left
	TreeNode *right
	TreeNode *parent
} TreeNode;

조건2) 트리노드의 배열은 다음과 같다.
	n1 = { 'A', NULL, NULL, &n3 };
	n2 = { 'B', NULL, NULL, &n3 };
	n3 = { 'C', &n1, &n2, &n7 };
	n4 = { 'D', NULL, NULL, &n6 };
	n5 = { 'E', NULL, NULL, &n6 };
	n6 = { 'F', &n4, &n5, &n7 };
	n7 = { 'G', &n3, &n6, NULL };

조건3) inorder traversal을 출력하기 위한 main()함수는 아래와 같다.
	TreeNode *q = exp;

	while (q->right) q = q->right; // Go to the leftmost node

	do
	{
		printf("%c\n", q->data); // Output data
		q = tree_predecessor(q); // Call the successor
	} while (q); // If not null



예제 출력
========
E
F
D
G
B
C
A