# DataStructure
2학년 2학기 자료구조 과제 정리

## Homework 2_1

[io 조건 확인](#io_homework2_1)

### ㄱ.struct 정리
struct(구조체) : 정의만 해서는 사용할 수 없다, 변수로 선언해서 사용한다. 

JAVA의 class field = 구조체 멤버

JAVA의 object instance = 구조체 변수 선언

##### 구조체 정의 방법
<pre><code>struct [구조체이름] {
    [자료형] [멤버이름];
};
</code></pre>

<pre><code>struct [구조체이름] {
    [자료형] [멤버이름];
}[변수];
</code></pre>

##### 구조체 변수 선언 방법

<pre><code>struct [구조체이름] [변수]</code></pre>

<pre><code>구조체를 정의하는 동시에 [변수]를 선언한다. // 이때 변수는 전역변수이다. (main함수 바깥에 선언되기 때문)</code></pre>


----

### ㄴ.typedef 정리

typedef를 사용하면 구조체 변수를 선언할 때 일일이 struct 키워드를 붙이는 것을 생략한다.

이 경우, typedef로 구조체를 정의하면서 별칭(alias)를 지정하게 된다.

##### typedef 구조체 정의 방법

<pre><code>typedef struct [구조체이름] {
    [자료형] [멤버이름];
}[구조체 별칭];
</code></pre>

##### typedef 구조체 변수 선언 방법

<pre><code>[구조체별칭] [변수]</code></pre>

## Homework 2_2


[io 조건 확인](#io_homework2_2)

### ㄱ. 메모리할당 정리
![pointer](https://user-images.githubusercontent.com/26458200/46453047-3ae9d100-c7da-11e8-8362-3e915236c8d2.PNG)

3차원 배열을 만들기 위한 함수 mem_alloc_3D_double()에서 나타나는 메모리 할당을 표로 정리한 것이다.
이경우 배열의 크기는 2X3X4인 3차원 배열로 x=2 , y=3, z=4의 값을 갖는다.

배열의 m[][][]꼴의 값에 접근하기 위한 address는 m[][]이고,

m[][]의 address에 접근하기위한 address는 m[]이고 (address of address)

m[]의 address에 접근하기위한 address는 m이다. (address of address of address)

double*** 타입인 m은 m[0] m[1]의 두개의 double** 타입의 공간을 필요로하므로, (x=2)

double ***m = (double***)malloc(sizeof(double**)*x); 로 메모리 할당을 해준다.

이때, (double***)을 붙이는 이유는, malloc은 void값의 형태로 return되어 데이터형을 맞춰주기 위해서이다.

마찬가지로 m[i]는 double **타입으로, m[i][0] , m[i][1] , m[i][2]의 세개의 double* 타입의 공간을 필요로하므로, (y=3)

m[i] = (double**)malloc(sizeof(double*)*y); 로 메모리 할당을 해준다.

m[i][j]는 double* 타입으로, m[i][j][0], m[i][j][1], m[i][j][2], m[i][j][3]의 네개의 double 타입의 공간을 필요로해, (z=4)

m[i][j] = (double**)malloc(sizeof(double)*z); 로 메모리 할당을 해준다.

-----

### ㄴ. 메모리 해제 정리

할당된 메모리를 해제할 때에는, 할당과 반대의 순서로 메모리를 해제해야한다.

메모리 할당의 과정이 m -> m[i] -> m[i][j]였다면

메모리 해제의 과정은 m[i][j] -> m[i] -> m이다.

따라서 중첩 반복문을 이용하여 먼저 free(m[i][j])를 해주고, 그 밖에 반복문에서 free(m[i]) 

그리고 반복문의 밖에서 free(m)으로 3차원 배열의 메모리 공간을 모두 해제한다. 

결국 변수 m은 메모리가 할당되지 않은 상태, 즉 아무것도 가리키지 않는 NULL포인터로 만들어야 하므로 m=NULL; 을 마지막줄에 넣어준다.


## IO condition

### <a id="io_homework2_1"></a>io_homework 2_1

N*M크기의 sparse matrix의 element를 입력받은후, 이를 transpose matrix로 구현하세요.

첫째 줄에 Matrix의 row의 크기인 N값을 입력받습니다.

둘째 줄에 Matrix의 column의 크기인 M값을 입력받습니다.

셋째 줄에는 sparse matrix의 element수를 입력받습니다.

이후에는 sparse matrix의 element 수만큼 (row col element value) 형식의 입력을 반복합니다.

입력이 다 끝난 후, 출력은 dense matrix의 형식으로

입력받은 sparse matrix와 transpose operation이 이루어진 matrix 두개를 출력합니다.

- 예제 입력

Input row size: 6

Input col size: 6

Input terms(maximum is 10): 7

Input numbers by format row col value : 0 3 7

Input numbers by format row col value : 1 0 9

Input numbers by format row col value : 1 5 8

Input numbers by format row col value : 3 0 6

Input numbers by format row col value : 3 1 5

Input numbers by format row col value : 4 5 1

Input numbers by format row col value : 5 2 2

- 예제 출력

Matrix B

0 0 0 7 0 0

9 0 0 0 0 8

0 0 0 0 0 0

6 5 0 0 0 0

0 0 0 0 0 1

0 0 2 0 0 0

Matrix B^T

0 9 0 6 0 0

0 0 0 5 0 0

0 0 0 0 0 2

7 0 0 0 0 0

0 0 0 0 0 0

0 8 0 0 1 0

### <a id="io_homework2_2"></a>io_homework 2_2

x*y*z를 갖는 3차원 배열 A B C에 메모리를 할당하고, A+B의 값을 C에 저장하시오. (입력은 받지 않습니다.)

1. x,y,z는 입력받는다 format = x y z

2. 3차원 배열 A B C의 요소의 타입은 double으로 지정

3. A와 B 배열의 각 요소의 값은 입력받는다.

4. 이후A와 B 배열의 addtion operation을 한 결과를 C에 저장

5. A와 B의 메모리 공간을 해제

- 예제입력

input x, y, z (format = x y z): 2 3 4

Matrix A

matrix[0][0][0] = 1

matrix[0][0][1] = 2

matrix[0][0][2] = 3

matrix[0][0][3] = 4

matrix[0][1][0] = 5

matrix[0][1][1] = 6

matrix[0][1][2] = 7

matrix[0][1][3] = 8

matrix[0][2][0] = 9

matrix[0][2][1] = 10

matrix[0][2][2] = 11

matrix[0][2][3] = 12

matrix[1][0][0] = 13

matrix[1][0][1] = 14

matrix[1][0][2] = 15

matrix[1][0][3] = 16

matrix[1][1][0] = 17

matrix[1][1][1] = 18

matrix[1][1][2] = 19

matrix[1][1][3] = 20

matrix[1][2][0] = 21

matrix[1][2][1] = 22

matrix[1][2][2] = 23

matrix[1][2][3] = 24

Matrix B

matrix[0][0][0] = 1

matrix[0][0][1] = 1

matrix[0][0][2] = 1

matrix[0][0][3] = 1

matrix[0][1][0] = 1

matrix[0][1][1] = 1

matrix[0][1][2] = 1

matrix[0][1][3] = 1

matrix[0][2][0] = 1

matrix[0][2][1] = 1

matrix[0][2][2] = 1

matrix[0][2][3] = 1

matrix[1][0][0] = 1

matrix[1][0][1] = 1

matrix[1][0][2] = 1

matrix[1][0][3] = 1

matrix[1][1][0] = 1

matrix[1][1][1] = 1

matrix[1][1][2] = 1

matrix[1][1][3] = 1

matrix[1][2][0] = 1

matrix[1][2][1] = 1

matrix[1][2][2] = 1

matrix[1][2][3] = 1

- 예제출력

matrix[0][0][0] = 2.000000

matrix[0][0][1] = 3.000000

matrix[0][0][2] = 4.000000

matrix[0][0][3] = 5.000000

matrix[0][1][0] = 6.000000

matrix[0][1][1] = 7.000000

matrix[0][1][2] = 8.000000

matrix[0][1][3] = 9.000000

matrix[0][2][0] = 10.000000

matrix[0][2][1] = 11.000000

matrix[0][2][2] = 12.000000

matrix[0][2][3] = 13.000000

matrix[1][0][0] = 14.000000

matrix[1][0][1] = 15.000000

matrix[1][0][2] = 16.000000

matrix[1][0][3] = 17.000000

matrix[1][1][0] = 18.000000

matrix[1][1][1] = 19.000000

matrix[1][1][2] = 20.000000

matrix[1][1][3] = 21.000000

matrix[1][2][0] = 22.000000

matrix[1][2][1] = 23.000000

matrix[1][2][2] = 24.000000

matrix[1][2][3] = 25.000000
