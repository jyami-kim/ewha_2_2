## Homework 3_1

[io 조건 확인](#io_homework3_1)

### ㄱ.head_node

head_node = 데이터 값이 없는 노드

init()함수로 head_node를 초기화한다.
<pre><code>void init(DlistNode *phead) {
	phead->llink = phead;
	phead->rlink = phead;
}</code></pre>

head_node를 다음과 같이 init하면 head_node가 자기 자신을 가리키기 때문에

circular double linked list 꼴이 된다.

### ㄴ.circular doubly linked list

doubly linked list는
<pre><code>typedef int element;
typedef struct DlistNode {
	element data;
	struct DlistNode *llink;
	struct DlistNode *rlink;
}DlistNode;</code></pre>

다음 구조를 가지고있다 하나의 Node에 llink, rrlink의 값이 들어가 있기 때문에, 

하나의 노드에서 왼쪽, 오른쪽을 모두 접근 할 수 있어 doubly linked list라고 한다.

첫번째 노드의 llink가 마지막 노드를 가리키고

마지막 노드의 rlink가 첫번째 노드를 가리키면 

list의 link가 원의 형태를 갖고있기 때문에, circular의 특징을 갖는다.

이때 circular을 갖지 않으려면, 첫번째 노드의 llink와 마지막노드의 rlink를 NULL로 설정하며 된다.

## Homework 3_2

[io 조건 확인](#io_homework3_2)

### ㄱ. 두개의 linked list merge하기

두개의 linked list merge의 원리는 node의 link 연결이다.

#### a. A linked list의 끝에 B linked list 이어붙이기

ListNode *ahead = A Linked list의 head pointer

ListNode *bhead = B Linked list의 head pointer

ahead -> link를 통해 A linked list의 마지막 노드에 접근한다 .(alast)

alast -> link = bhead 로 지정한다.

즉, A 리스트의 마지막 노드의 link를 B 리스트의 첫번째 노드로 연결한다.

#### b. A linked list와 B의 linked list의 데이터 값을 합쳐서 새로운 linked list만들기
<pre><code>void make_C(ListNode *A, ListNode *B, ListNode **C) {
	while (!(A == NULL) || !(B == NULL)) {
		element input_C;
		if (A == NULL || B == NULL) {
			if (A == NULL) {
				input_C = B->data;
				B = B->link;
			}
			else {
				input_C = A->data;
				A = A->link;
			}
		}
		else {
			if (A->data < B->data) {
				input_C = A->data;
				A = A->link;
			}
			else {
				input_C = B->data;
				B = B->link;
			}
		}
		insert_last(C, input_C);
	}
}</code></pre>

<strike>
추가로 드는 생각은
ListNode *p = ListNode** C로 설정하여
insert last()대신에
p->data = inputC;
p= p->link; 
을 이용한다면 시간 복잡도를 조금 줄일 수 있지 않을까 싶다.
</strike>

## Homework 3_3

[io 조건 확인](#io_homework3_3)

### ㄱ.ListType
<pre><code>typedef int element;
typedef struct ListNode {
	element data;
	struct ListNode *link;
}ListNode;

typedef struct {
	ListNode *head;
	ListNode *tail;
	int length;
}ListType;</code></pre>

다음과 같은 구조체를 선언하다면

한개의 ListType은 하나의 linked list를 구현한다.

하나의 linked list안에는 여러개의 node가 있기 때문에.

따라서 ListType 하나당 여러개의 ListNode를 갖고있다.

ListType을 사용한다면

head pointer로 linked list의 첫번째 노드에 접근 할 수 있고

tail pointer로 linked list의 마지막 노드에 접근 할 수 있다.

따라서 여기서 tail, head 포인터의 존재로,

원하는 위치의 Node (첫번째, 마지막)를 삽입하고 제거하는 것이 용이 해진다.

### <a id="io_homework3_1"></a>io_homework 3_1
[Homework03_1]

다음 조건을 가진 doubly linked list를 구현하시오.

linked list data순서 :  4 - 3 - 2 - 1 - 0 - 9 - 100

1. 4 3 2 1 0은 dinsert_node(&head_node, new_node) 를 이용하여 insert하세요

2. 9는 dinsert_node() 함수를 이용해서 linked list의 마지막에 insert하세요

3. 100은 dinsert_node()함수를 구현해서 linked list의 마지막에 insert하세요

4. 출력형식은 <---|[현재 node의 llink 주소]| data: [현재 node의 data값], address: [현재 node의 주소]|[현재 node의 rlink 주소]|--->

예제 출력
<pre><code><---|6ffb58| data:4, address:79a440 |795288|--->
<---|79a440| data:3, address:795288 |795250|--->
<---|795288| data:2, address:795250 |7953d0|--->
<---|795250| data:1, address:7953d0 |795398|--->
<---|7953d0| data:0, address:795398 |79a478|--->
<---|795398| data:9, address:79a478 |79a4b0|--->
<---|79a478| data:100, address:79a4b0 |6ffb58|--->
</pre></code>

### <a id="io_homework3_2"></a>io_homework 3_2

[Homework03_2]

a = {1,2,5,10,15,20,25}

b = {3,7,8,15,18,30}

두개의 배열을 linked list로 만들고, a와 b를 합친 새로운 linked list C를 만드는 함수를 만들어라

이때 c는 오름차순으로 합쳐지게 한다.

출력형식은 아래와 같다.

예제출력
<pre><code>a = 1->2->5->10->15->20->25->
b = 3->7->8->15->18->30->
c = 1->2->3->5->7->8->10->15->15->18->20->25->30->
</pre></code>

### <a id="io_homework3_3"></a>io_homework 3_3

[Homework03_3]

아래와 같이 linked list를 정의하고,
<pre><code>typedef int element;
typedef struct ListNode {
	element data;
	struct ListNode *link;
} ListNode;

typedef struct {
	ListNode *head;// Head pointer
	ListNode *tail;// Tail pointer
	int length;// # of nodes
} ListType;
ListType list1;
</code></pre>

아래 main함수가 실행했을 때, 예제 출력이 나오도록 List ADT를 구현하여라

<pre><code>int main()
{
	ListType list1;
	init(&list1);
	add_first(&list1, 20);
	add_last(&list1, 30);
	add_first(&list1, 10);
	add_last(&list1, 40);
	add(&list1, 2, 70);
	display(&list1);
	delete(&list1, 2);
	delete_first(&list1);
	delete_last(&list1);
	display(&list1);
	printf("%s\n", is_in_list(&list1, 20) == TRUE ? "TRUE": "FALSE");
	printf("%d\n", get_entry(&list1, 0));
}

</code></pre>

이때 함수는 Lec04-List의 p55-p61을 보고 재 구현하며,

add_first, add_last, delete_first, delete_last, add, delet는 새로 추가한다.

예제 출력
<pre><code>(10 20 70 25 30 40 )
(10 20 70 25 30 40 30 )
(10 20 70 25 30 40 30 100 )
(20 25 30 40 30 100 )
(20 25 30 40 30 )
(25 30 40 30 )
(25 30 40 )
FALSE
25
</pre></code>
