[Homework04_1]
circular doubly linked list를 이용하여 stack을 구현하시오

조건1) Node는 아래와 같이 define 되어있다.
typedef struct DlistNode {
	element data;
	struct DlistNode *llink;
	struct DlistNode *rlink;
} DlistNode;

조건2) 아래 main() 함수가 실행되면 성공
void main()
{
	LinkedStackType s;
	init(&s);
	push(&s, 1);
	push(&s, 2);
	push(&s, 3);

	printf("%d\n", pop(&s));
	printf("%d\n", pop(&s));
	printf("%d\n", pop(&s));
}

조건3) 사캠에 올라온 ‘linked_stack.cpp’ (simple linked list)를 기반으로 구현하시오

예제 출력
========
3
2
1

[Homework04_2]
사캠에 올라온 simulation.cpp는 은행창구 업무를 시뮬레이션하기위한 코드이다.
해당 코드는, 은행원이 1명이라고 가정했을 때이다.
코드를 수정하여 은행원이 2명이라고 가정했을 때를 구현하여라.

그리고 print_stat() 를 이용하여 결과를 출력하여라.

이때, 상대적으로 큰 숫자를 설정하면 의미있는 결과가 나온다 (= 시뮬레이션 결과)


예제출력
=======
Current time=1
Customer 0 comes in 1 minutes. Service time is 3 minutes.
Customer 0 starts service in 1 minutes. Wait time was 0 minutes. In bank_staff 1
Current time=2
Customer 1 comes in 2 minutes. Service time is 5 minutes.
Customer 1 starts service in 2 minutes. Wait time was 0 minutes. In bank_staff 2
Current time=3
Customer 2 comes in 3 minutes. Service time is 3 minutes.
Current time=4
Customer 3 comes in 4 minutes. Service time is 5 minutes.
Current time=5
Customer 2 starts service in 5 minutes. Wait time was 2 minutes. In bank_staff 1
Current time=6
Customer 3 starts service in 6 minutes. Wait time was 2 minutes. In bank_staff 2
Current time=7
Customer 4 comes in 7 minutes. Service time is 5 minutes.
Current time=8
Current time=9
Customer 5 comes in 9 minutes. Service time is 2 minutes.
Customer 4 starts service in 9 minutes. Wait time was 2 minutes. In bank_staff 1
Current time=10
Customer 6 comes in 10 minutes. Service time is 1 minutes.
====result====
Number of customers served = 5
Total wait time = 6 minutes
Average wait time per person = 1.200000 minutes
Number of customers still waiting = 2

[Homework4_2_appendix]
본인은 Homework4_2 구현을 바탕으로
시뮬레이션 상황에 대한 변수를 input값으로 주어 시뮬레이션 사용자가 값을 조정할 수 있게 한다.
은행창구 현장의 다양한 상황에 대한 시뮬레이션을 할 수 있도록 코드를 수정하였다.
수정 가능한 변수는 다음과 같다

1. 창구의 수(=bank_staff의 수) // int bank_staffs_number
2. 한 타임에 고객이 올 확률 (=>n분당 1명일 경우엔 1/n을 대입) //float arrival_prob
3. 시뮬레이션 시간 (=n분) //int duration
4. 한명이 은행창구에서 업무를 보는 최대 시간 //max_serv_time

입력받은 변수를 바탕으로 시뮬레이션 결과를 확인 할 수 있다.

예제입력
=======
input the number of bank_staffs: 4
input the average number of customers arriving in one time unit (0.0 ~ 1.0): 0.9
input the simulation duration: 20
input the max serve time: 10

예제출력
=======
Current time=1
Customer 0 comes in 1 minutes. Service time is 6 minutes.
Customer 0 starts service in 1 minutes. Wait time was 0 minutes. In 1 bank_staff
Current time=2
Customer 1 comes in 2 minutes. Service time is 9 minutes.
Customer 1 starts service in 2 minutes. Wait time was 0 minutes. In 2 bank_staff
Current time=3
Customer 2 comes in 3 minutes. Service time is 5 minutes.
Customer 2 starts service in 3 minutes. Wait time was 0 minutes. In 3 bank_staff
Current time=4
Customer 3 comes in 4 minutes. Service time is 9 minutes.
Customer 3 starts service in 4 minutes. Wait time was 0 minutes. In 4 bank_staff
Current time=5
Customer 4 comes in 5 minutes. Service time is 8 minutes.
Current time=6
Customer 5 comes in 6 minutes. Service time is 9 minutes.
Current time=7
Customer 6 comes in 7 minutes. Service time is 6 minutes.
Customer 4 starts service in 7 minutes. Wait time was 2 minutes. In 1 bank_staff
Current time=8
Customer 7 comes in 8 minutes. Service time is 1 minutes.
Customer 5 starts service in 8 minutes. Wait time was 2 minutes. In 3 bank_staff
Current time=9
Customer 8 comes in 9 minutes. Service time is 4 minutes.
Current time=10
Customer 9 comes in 10 minutes. Service time is 2 minutes.
Current time=11
Customer 6 starts service in 11 minutes. Wait time was 4 minutes. In 2 bank_staff
Current time=12
Customer 10 comes in 12 minutes. Service time is 2 minutes.
Current time=13
Customer 11 comes in 13 minutes. Service time is 1 minutes.
Customer 7 starts service in 13 minutes. Wait time was 5 minutes. In 4 bank_staff
Current time=14
Customer 12 comes in 14 minutes. Service time is 6 minutes.
Customer 8 starts service in 14 minutes. Wait time was 5 minutes. In 4 bank_staff
Current time=15
Customer 13 comes in 15 minutes. Service time is 7 minutes.
Customer 9 starts service in 15 minutes. Wait time was 5 minutes. In 1 bank_staff
Current time=16
Customer 14 comes in 16 minutes. Service time is 2 minutes.
Current time=17
Customer 15 comes in 17 minutes. Service time is 5 minutes.
Customer 10 starts service in 17 minutes. Wait time was 5 minutes. In 1 bank_staff
Customer 11 starts service in 17 minutes. Wait time was 4 minutes. In 2 bank_staff
Customer 12 starts service in 17 minutes. Wait time was 3 minutes. In 3 bank_staff
Current time=18
Customer 16 comes in 18 minutes. Service time is 1 minutes.
Customer 13 starts service in 18 minutes. Wait time was 3 minutes. In 2 bank_staff
Customer 14 starts service in 18 minutes. Wait time was 2 minutes. In 4 bank_staff
Current time=19
Customer 17 comes in 19 minutes. Service time is 8 minutes.
Customer 15 starts service in 19 minutes. Wait time was 2 minutes. In 1 bank_staff
Current time=20
Customer 18 comes in 20 minutes. Service time is 6 minutes.
Customer 16 starts service in 20 minutes. Wait time was 2 minutes. In 4 bank_staff
=====result=====
Number of customers served = 17
Total wait time = 44 minutes
Average wait time per person = 2.588235 minutes
Number of customers still waiting = 2