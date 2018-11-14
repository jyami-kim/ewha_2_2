
#include "stdlib.h"
#include "stdio.h"
#include "string.h"

#define MAX_ELEMENT 1000
#define MAX_BIT		10
#define MAX_CHAR	20

// Input data for huffman code
typedef struct input_huff {
	char *data;		// Character array (a ~ f)
	int *freq;		// Frequency array
	int size;		// Number of characters
} input_huff;

// Structure for huffman binary tree
typedef struct TreeNode {
	char data;			// Character (a ~ f)
	int key;			// Frequency
	int bits[MAX_BIT];	// Huffman codeword
	int bit_size;		// Huffman codeword's size
	struct TreeNode *l;	// Left child of huffman binary tree
	struct TreeNode *r;	// Right child of huffman binary tree
} TreeNode;

// Structure for bits stream
typedef struct bits_stream {
	int *stream;
	int length;
} bits_stream;

// Elements used in the heap
typedef struct element {
	TreeNode *ptree;
	int key;	// frequency of each character
} element;

// Heap
typedef struct HeapType {
	element heap[MAX_ELEMENT];
	int heap_size;
} HeapType;

int **m_LUT, *m_bit_size;
int	m_char_size = 6;

// Initialization
void init(HeapType *h)
{
	h->heap_size = 0;
}
//
int is_empty(HeapType *h)
{
	if (h->heap_size == 0)
		return true;
	else
		return false;
}

void insert_min_heap(HeapType *h, element item)
{
	int i;
	i = ++(h->heap_size);

	// compare it with the parent node in an order from the leaf to the root
	while ((i != 1) && (item.key < h->heap[i / 2].key)) {
		h->heap[i] = h->heap[i / 2];
		i /= 2;
	}
	h->heap[i] = item; // Insert new node
}

element delete_min_heap(HeapType *h)
{
	int parent, child;
	element item, temp;
	item = h->heap[1];
	temp = h->heap[(h->heap_size)--];
	parent = 1;
	child = 2;
	while (child <= h->heap_size) {
		if ((child < h->heap_size) && (h->heap[child].key) > h->heap[child + 1].key)
			child++;
		if (temp.key <= h->heap[child].key) break;
		h->heap[parent] = h->heap[child];
		parent = child;
		child *= 2;
	}
	h->heap[parent] = temp;
	return item;
}

// Node generation in binary tree
TreeNode *make_tree(TreeNode *left, TreeNode *right)
{
	TreeNode *node = (TreeNode *)malloc(sizeof(TreeNode));
	if (node == NULL) {
		fprintf(stderr, "Memory allocation error\n");
		exit(1);
	}
	node->l = left;
	node->r = right;
	return node;
}

// Binary tree removal
void destroy_tree(TreeNode *root)
{
	if (root == NULL) return;
	destroy_tree(root->l);
	destroy_tree(root->r);
	free(root);
}

// Huffman code generation
element huffman_tree(input_huff *huff)
{
	int i;
	TreeNode *node, *x;
	HeapType heap;
	element e, e1, e2;
	init(&heap);

	int n = huff->size;

	for (i = 0; i<n; i++) {
		node = make_tree(NULL, NULL); //branch가 null인 tree node 생성
		e.ptree = node;
		node->data = huff->data[i];
		e.key = node->key = huff->freq[i]; //key: frequency
		memset(node->bits, 0, sizeof(int)*MAX_BIT); //메모리 시작 주소, 메모리 채우고 싶은 값, 채우고자하는 바이트 수
		node->bit_size = 0;
		//treenode의 값을 모두 0으로 초기화하고, 
		//이 treenode를 elt와 연결지어, 이 elt를 heqp에 삽입

		insert_min_heap(&heap, e); //key값 즉 frequency에 따른 min_heap이 생성된다.
		//단말노드를 생성했다고 생각하자!
	}

	for (i = 1; i<n; i++) {
		// Delete two nodes with minimum values
		e1 = delete_min_heap(&heap);
		e2 = delete_min_heap(&heap); //key값 비교하면 e1<e2

		// Merge two nodes
		x = make_tree(e1.ptree, e2.ptree); //x는 tree node
		e.ptree = x;
		x->data = NULL;
		e.key = x->key = e1.key + e2.key;
		memset(x->bits, 0, sizeof(int)*MAX_BIT);
		x->bit_size = 0;
		//두개의 node를 합친 중간노드 생성해서 heap에 넣기

		insert_min_heap(&heap, e);
	}

	e = delete_min_heap(&heap); // Final Huffman binary tree
	//insert2번 delete1번을 하니까 heap에 들어있는 node의 수가 6에서 1로 줄고, 그 1개는 maxkey를 갖는 노드가 된다.

	return e;
	//	destroy_tree(e.ptree);
}


// Generate the huffman codeword from the huffman binary tree
// Hint: use the recursion for tree traversal
// input: root node
// output: m_LUT, m_bit_size
int count =0;

TreeNode *arr[MAX_CHAR];

void huffman_traversal(TreeNode *node)
{
	//m_LUT에 숫자를 부여한 것들을 저장한다.
	//m_bit_size 각 부여한 byte들의 길이를 잰다.
	
	while (node != NULL) {
		//abcdef 순서로 m_LUT m_bit_size 
		if (node->l == NULL & node->r == NULL) {
			arr[count++] = node;
			break;
		}
		else {
			if (node->l != NULL) {
				for (int i = 0; i < node->bit_size; i++) {
					node->l->bits[i] = node->bits[i];
				}
				node->l->bits[node->bit_size] = 0;
				node->l->bit_size = node->bit_size + 1;
				huffman_traversal(node->l);
			}

			if (node->r != NULL) {
				for (int i = 0; i < node->bit_size; i++) {
					node->r->bits[i] = node->bits[i];
				}
				node->r->bits[node->bit_size] = 1;
				node->r->bit_size = node->bit_size + 1;
				huffman_traversal(node->r);
			}
			break;
		}
	}
}

int **mem_2D_int(int row, int col)
{
	int **m2 = (int **)malloc(sizeof(int *)*row);
	for (int i = 0; i<row; i++)
		m2[i] = (int *)malloc(sizeof(int)*col);
	return m2;
}

void print_codeword()
{
	printf("* Huffman codeword\n");
	for (int i = 0; i < m_char_size; i++)
	{
		switch (i) {
		case 0:
			printf("%c: ", 'a');
			break;
		case 1:
			printf("%c: ", 'b');
			break;
		case 2:
			printf("%c: ", 'c');
			break;
		case 3:
			printf("%c: ", 'd');
			break;
		case 4:
			printf("%c: ", 'e');
			break;
		case 5:
			printf("%c: ", 'f');
			break;
		}

		for (int j = 0; j < m_bit_size[i]; j++)
			printf("%d", m_LUT[i][j]);

		printf("\n");
	}

}

void sort_leaf() {
	HeapType h;
	init(&h);

	for (int i = 0; i < m_char_size; i++) {
		element e;
		e.key = arr[i]->data;
		e.ptree = arr[i];
		insert_min_heap(&h, e);
	}

	for (int i = 0; i < m_char_size; i++) {
		element e;
		e = delete_min_heap(&h);
		m_bit_size[i] = e.ptree->bit_size;
		for (int j = 0; j < m_bit_size[i]; j++) {
			m_LUT[i][j] = e.ptree->bits[j];
		}
	}
}

int* finding(char c) {
	return m_LUT[c - 97]; //a값의 int형은 97이고, m_LUT에는 index 0에 들어있기 때문에!
}

// Input: 'str'
// Output: 'bits_stream' (consisting of 0 or 1)
// 'bits_stream' is generated using 'm_LUT' generated by the huffman binary tree
// Return the total length of bits_stream
void huffman_encoding(char *str, bits_stream *bits_str)
{	
	for (int i = 0; i < strlen(str); i++) {
		int idx = str[i] - 97; //a값의 int형은 97이고, m_LUT에는 index 0에 들어있기 때문에
		for (int j = 0; j < m_bit_size[idx]; j++) {
			bits_str->stream[bits_str->length + j] = m_LUT[idx][j];
		}
		bits_str->length += m_bit_size[idx];
	}

	printf("\n* Huffman encoding\n");
	printf("total length of bits stream: %d\n", bits_str->length);
	printf("bits stream: ");
	for (int i = 0; i < bits_str->length; i++)
		printf("%d", bits_str->stream[i]);
	printf("\n");
}

// input: 'bits_stream' and 'total_length'
// output: 'decoded_str'
int huffman_decoding(bits_stream *bits_str, TreeNode *node, char *decoded_str)
{
	int count = 0;
	TreeNode *cur = node;
	for (int i = 0; i < bits_str->length; i++) {
		if (bits_str->stream[i] == 0)
			cur = cur->l;
		else
			cur = cur->r;
		if (cur->l == NULL and cur->r == NULL) {
			decoded_str[count++] = cur->data;
			cur = node;
		}
	}

	printf("\n* Huffman decoding\n");
	printf("total number of decoded chars: %d\n", count);
	printf("decoded chars: ");
	for (int i = 0; i < count; i++)
		printf("%c", decoded_str[i]);
	printf("\n");

	return (count);
}

void main()
{
	char data[] = { 'a', 'b', 'c', 'd', 'e', 'f' };
	int freq[] = { 45, 13, 12, 16, 9, 5 };

	input_huff *huff1 = (input_huff *)malloc(sizeof(input_huff));
	huff1->data = data; //data array
	huff1->freq = freq; //freq array
	huff1->size = m_char_size; //6

	// m_LUT: each row corresponds to the codeword for each character
	// m_bit_size: 1D array of codeword size for each character
	// For instance, a = 0, b = 101, ...
	// 1st row of 'm_LUT': 0 0 ... 0
	// 2nd row of 'm_LUT': 1 0 1 ...0
	// m_bit_size = {1, 3, ...}
	m_LUT = mem_2D_int(m_char_size, MAX_BIT); //2차원 배열 설정 6X10 //2차원포인터
	m_bit_size = (int *)malloc(sizeof(int)*m_char_size); //1차원 포인터 //크기가 6인 배열 bit의 크기를 저장한다.

	// Generate the huffman binary tree on heap
	// 'element_root': element containing the root node
	element element_root = huffman_tree(huff1);

	// Generate the huffman codeword from the huffman binary tree
	huffman_traversal(element_root.ptree);

	sort_leaf();


	//printf out the huffman codeword
	print_codeword();

	
	//example of input data
	char str[MAX_CHAR] = { "abacdebaf" };
	//char str[MAX_CHAR] = { "ab" };
	char decoded_str[MAX_CHAR];

	printf("\n* input chars: ");
	for (int i = 0; i < strlen(str); i++)
		printf("%c", str[i]);
	printf("\n");
	
	//start encoding
	bits_stream *bits_str1 = (bits_stream *)malloc(sizeof(bits_stream));
	bits_str1->stream = (int *)malloc(sizeof(int)*MAX_BIT * MAX_CHAR);
	memset(bits_str1->stream, -1, sizeof(int)*MAX_BIT * MAX_CHAR);
	bits_str1->length = 0;

	huffman_encoding(str, bits_str1);

	int decoded_char_length = huffman_decoding(bits_str1, element_root.ptree, decoded_str);
	
}