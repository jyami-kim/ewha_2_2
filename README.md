# DataStructure
2학년 2학기 자료구조 과제 정리

## Homework 2_1

[io 조건 확인]()

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


[io 조건 확인]()

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

