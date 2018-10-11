#include <stdio.h>
#include <stdlib.h>

typedef int element;
typedef struct DlistNode {
	element data;
	struct DlistNode *llink;
	struct DlistNode *rlink;
}DlistNode;

void init(DlistNode *phead) {
	phead->llink = phead;
	phead->rlink = phead;
}

void display(DlistNode *phead) {
	DlistNode *p;
	for (p = phead->rlink; p != phead; p = p->rlink) {
		printf("<---|%x| data:%d, address:%x |%x|--->\n", p->llink, p->data, p, p->rlink);
	}
}

void dinsert_node(DlistNode *before, DlistNode *new_node) {
	new_node->llink = before;
	new_node->rlink = before->rlink;
	before->rlink->llink = new_node;
	before->rlink = new_node;
}

void dinsert_last_node(DlistNode *phead, DlistNode *new_node) {
	new_node->rlink = phead;
	new_node->llink = phead->llink;
	phead->llink->rlink = new_node;
	phead->llink = new_node;
}

int main() {
	DlistNode head_node;
	DlistNode *p[10];

	init(&head_node);

	for (int i = 0; i < 5; i++) {
		p[i] = (DlistNode *)malloc(sizeof(DlistNode));
		p[i]->data = i;
		dinsert_node(&head_node, p[i]);
	}

	//dinsert_node로 마지막에 insert하기
	p[9] = (DlistNode *)malloc(sizeof(DlistNode));
	p[9]->data = 9;
	dinsert_node(head_node.llink, p[9]);

	//dinsert_last_node함수 추가해서 마지막에 insert하기
	DlistNode *insert = (DlistNode*)malloc(sizeof(DlistNode));
	insert->data = 100;
	dinsert_last_node(&head_node, insert);

	display(&head_node);
}

