## Homework 3_1

[io 조건 확인](#io_homework3_1)

###ㄱ.head_node

head_node = 데이터 값이 없는 노드

init()함수로 head_node를 초기화한다.
<pre><code>void init(DlistNode *phead) {
	phead->llink = phead;
	phead->rlink = phead;
}</code></pre>

head_node를 다음과 같이 init하면 head_node가 자기 자신을 가리키기 때문에

circular double linked list 꼴이 된다.

###ㄴ.circular doubly linked list

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

[io 조건 확인](#io_homework2_1)

###ㄱ. 두개의 linked list merge하기

두개의 linked list merge의 원리는 node의 link 연결이다.

#### a. A linked list의 끝에 B linked list 이어붙익
