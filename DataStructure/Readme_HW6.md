## Homework 6_1

[io 조건 확인](#io_homework6_1)

### ㄱ.heap 정리
heap : complete binary tree를 사용한다.  
complete binary tree를 사용하면 array로 구현할 수 있고, 각 node를  numbering 할 수 있다.

index of parent and child  
- parent node of node i : i/2
- Left child node of node i : 2*i
- Right child node of node i : 2i + 1

![image](https://user-images.githubusercontent.com/26458200/48529325-dab87580-e8d5-11e8-9765-a9a3c6044a17.png)


max_heap : key(parent node)>= key(child node)

min_heap : key(praent node)>= key(child node)

##### Insertion Max Heap
<pseudo_code>

````c
    insert_max_heap(A, key)

    heap_size <- heap_size + 1;
    i <- heap_size;
    A[i] <- key;
    while i != 1 and A[i] > A[PARENT(i)]do
        A[i] <-> A[PARENT];
        i <- PARENT(i);
````

````c
    parent (i) = A[i/2];
````

1. 새로운 node를 heap의 가장 마지막 node에 insert한다.  
2. insert된 node에서 root까지 경로에 있는 node들이 비교되고, 교환되어 max_heap을 만족한다.  

여기서 중요한건 exchange operation을 사용하지 않고 효율적으로 구현할 수 있다는 점이다. 


##### Deletion Max Heap
<pseudo_code>
````c
    delete_max_heap(A)

    item <- A[1]; 
    A[1] <- A[heap_size];
    heap_size <- heap_size - 1;

    i <- 2;
    while i<=heap_size do
        if i< heap_size and A[i+1]>A[i] //먼저 child node의 left right 비교
            then largest <- i+1;
        else largest <- i;

        if A[PARENT(largest)] > A[largest] // max_heap이 충족되면 break;
            then break;
        A[PARENT(largest)] <-> A[largest] //max_heap이 충족되지 않았기 때문에 swap
        i <- CHILD(largest);

    return item;
````

1. root node를 삭제한다.  
2. 가장 마지막 node를 root node로 이동한다.  
3. root에서 leaf node까지 경로에 있는 node들이 비교되고, 교환되어 max_heap을 만족한다.  

----

### ㄴ. build_max_heap

먼저 주어진 array가 있을때 heap에 먼저 모든 element를 삽입한다.  

1. leaf node들은 이미 heap property를 만족한다.  = [n/2]+1 ... n  
2. leaf node가 아닌 나머지 node들에 대한 processing을 진행한다. = 1 ... [n/2]

배열을 통해 [n/2] 에서 1로 아래에서 위로 이동하는 방식으로 heap을 충족 할 때까지 각 node를 이동한다.  
i가 processing되면 node i 의 child node가 heap을 충족한다. 이 i의 순서는 [n/2] to 1 이다.

![image](https://user-images.githubusercontent.com/26458200/48530046-54059780-e8d9-11e8-9084-3fd6cfab7da0.png)

processing 순서 : 5 - 4 - 3 - 2 - 1
5 : 5-10 비교 후 swap 선택  
4 : 8-9 max값 찾기 위해 cmp 후 cmp 값과 4 비교 후 swap 선택  
3 : 6-7 max값 찾기 위해 cmp 후 cmp 값과 3 비교 후 swap 선택  
2 : 4-5 max값 찾기 위해 cmp 후 cmp 값과 2 비교 후 swap 선택 // 그리고 4, 5 단계 다시 반복  
1 : 2-3 max값 찾기 위해 cmp 후 cmp 값과 1 비교 후 swap 선택 // 그리고 2, 3, 4, 5 단계 다시 반복  


##### cmp
<pseudo_code>
````c
    cmp(A, idx)
    //PARENT = idx, CHILD1 = idx*2, CHILD2= idx*2+1
    
    if(A[CHILD1] >A[CHILD2])
        return CHILD1;
    else
        return CHILD2;
````
##### change
<pseudo_code>
````c
    change(A, idx)
     //PARENT = idx, CHILD1 = idx*2, CHILD2= idx*2+1

    MAX <- cmp(A,idx);

    if(A[PARENT] < A[MAX]){
        A[PARENT] <-> A[MAX]

        if(MAX <= input_size/2 )
            chagne(A, idx)
    }
````

change의 recursion을 이용해서 root에서 leaf 까지 차례로 heap을 정렬한다.  

##### build_max_heap

<pseudo_code>
````c
    build_max_heap(A)

    for i in heap_size/2 to 0 {
        if(i is first){
            //first = heap_size/2
            if(A[first] < A[heap_size])
                A[first]<->A[heap_size];
        }else{
            change(A,i);
        }
    }
````

단순히 build_max_heap으로 recursion을 안 한 이유는, heap_size가 홀수인지 짝수인지에 따라 right child node의 유무가 결정되기 때문이다.   따라서 build_max_heap을 하기위한 5번의 반복중에 첫번째 반복일 때만, 홀수, 짝수 여부를 판단한 후 build_max_heap 안에서 자체적으로 swap이 이뤄지도록하고 나머지 2~5번의 반복에서는 change함수의 recursion을 이용한다.

## Homework 2_2

[io 조건 확인](#io_homework6_2)

### ㄱ. 변수 정리

##### input_huff  
huffman code의 data와 freq값을 저장해두는 구조체, 이 구조체 값을 tree와 heap의 요소값에 넣는 역할을 한다.  

##### TreeNode  
huffman tree의 Node에 각종 정보를 저장하는 구조체  
huffman 코드의 freq에 따른 data값에 대한 tree를 생성할 때 사용한다
처음에, freq 값만 있던 단말노드들을 min값부터 차례로 merge해서
tree로 엮는 작업을 할 예정이다.  
huffman tree를 만드는 이유는 encoding과 decoding 때문이다.

##### bits_stream  
tree로 문자와 하나씩 대응시킨 bit값을 이용해서 input으로 주어진 문자열을 bit로 바꾼 결과를 저장하는 구조체

##### element & HeapType  
heap을 가리키는 HeapType 구조체, heap의 요소들을 나타내는 element 구초제이다.  
heap을 사용하는 이유는, tree로 freq값들의 두개의 min값을 찾을 때, search에 걸리는 시간을 줄이기 위해서이다.  
즉, heap을 사용하면 단순하게 for문으로 min값을 찾는 것 보다 시간 복잡도가 더 적게 나오기 때문이다.

##### int **m_LUT & int *m_bit_size & int m_char_size  
문자와 bit를 하나씩 대응하기 위해서 사용하는 전역변수
m_LUT : 각각의 row가 각각의 문자와 대응한다.
m_bit_size: m_LUT의 n번째 row에 있는 문자열의 길이는 m_bit_size의 n번째 인덱스와 대응한다.  
m_char_size : bit와 대응시키는 문자의 개수 (여기서는 a,b,c,d,e,f 총 6개)

m_LUT  
a: 0000000000  
b: 1010000000  
c: 1000000000  
d: 1110000000  
e: 1101000000  
f: 1100000000  

m_bit_size  
1  
3  
3  
3  
4  
4  

m_char_size  6

-----

### ㄴ. 함수 정리

huffman_tree() : huffman_code에 대응되는 tree를 만들기 위한 함수이다.

huffman_traversal() : huffman_tree를 이용해서, huffman_code의 각 data에 대응하는 bit를 생성한다.

huffman_encoding() : 주어진 input string을 bit string으로 encoding한다.

huffman_decoding() : 주어진 bit string을 character string으로 decoding한다.

##### huffman_tree()
1. huffman_tree 초기 설정  
   
    leaf node 생성 후 요소 초기값 설정 = char을 갖고있는 node  
    data = char of huffman_code  
    key = frequency of huffman_code  
    bits[MAX_BIT] = 0  
    bit_size = 0  
    *left = null  
    *right = null  

    min값을 빠르게 찾기위한 heap생성  
    ptree = node  
    key = frequency of huffman_code

2. key값이 작은 두 값을 비교 후 merge  
    min_heap을 이용해서 key값이 작은 두 node를 merge한 root node를 생성한다.  
    delete_min_heap을 이용해서 두 node를 저장한 후, 새로운 node를 생성한다.  
    data = null  
    key = delete_min_heap1.key + delete_min_heap2.key  
    bits[MAX_BIT] = 0  
    bit_size = 0  
    *left = delete_min_heap1  
    *right = delete_min_heap2  

3. 남은 heap element는 root node  
   delete 2번, insert 1번으로인해 heap이 6개의 node를 갖고있다가 1개의 node를 갖게 된다. 이 node를 delete_min_heap을 하게되면 root node가 된다.

##### huffman_traversal(node)

huffman tree를 이용해서 각 bit값을 설정한다.  
tree의 left로 가면 bit 0을 추가, right로 가면 bit 1을 추가한다.

1. 도달한 node가 leaf node 일 때  
   결과값 배열에 해당 node를 저장한다.

2. 도달한 node가 leaf node가 아닐 때  
    2-1. 도달한 node의 left 값이 있을 때  
      left node의 bit와 bit_size를 설정한다.   
      huffman_traversal(node->left) : recursion으로 접근한다.  
    2-2. 도달한 node의 right 값이 있을 때  
      right node의 bit와 bit_size를 설정한다.  
      huffman_traversal(node->right) : recursion으로 접근한다.  

##### huffman_encoding()  

string의 각 char에 접근하고, 각 char에 맞는 bit와 bit_size를 bits_str->stream, bits_str->length 에 저장한다.   
이때, 접근한 각 char에 맞는 bit값을 대응시키기위해 m_LUT과 m_bit_size를 사용해야 하는데, 이때 char이 int로도 바뀔 수 있다는 점을 이용해서 index를 찾는다.  
a = 97, b = 98, c = 99, d = 100, e = 101, f = 102이고, m_LUT와 m_bit_size에는 각각 0, 1, 2, 3, 4, 5 index에 저장되어 있기 때문에 , idx = str[i] – 97 을이용해서 char data와 bit의 대응을 찾는다.  
이렇게 찾은 idx값을 이용해서, stream과 length를 저장한다.  

##### huffman_decoding()

decoding 방법은 이전에 생성한 Huffman_tree를 이용한다.  
하나씩 읽는 bit값에 따라 Huffman_tree의 root node에서 차례로 bit에 맞는 child node로 이동한다. (0일경우 left, 1일경우 right)  
이렇게 이동한 node가 leafnode일 경우에는, 그 leafnode가 가진 char data값을 output string에 저장하고, Huffman_tree의 root에서 새로운 search를 시작한다.  
output string의 길이와, 새로 추가할 char의 위치를 지정하기위해서 count를 이용한다.  

## IO condition

### <a id="io_homework6_1"></a>io_homework 6_1

build_max_heap 함수를 구현하라.

조건 1) 이미 힙에는 무작위로 key가 들어가 있다.  
조건 2) 힙 배열의 크기가 10 ,100, 1000 .. 커져도 heap sort의 runtime이 최소가 되도록 구현하여라

- 예제 출력
<pre><code>Input data
7634
9409
9898
414
1657
9912
8985
2167
3561
3293

Sorted data
414
1657
2167
3293
3561
7634
8985
9409
9898
9912

Sorting result is correct.</code></pre>

### <a id="io_homework6_2"></a>io_homework 6_2

input에 대한 encoding, decoding을 huffman binary tree를 이용해서 구현하여라  

조건 1) huffman_traversal 구현  
조건 2) huffman_encoding 구현  
조건 3) huffman_decoding 구현  

- 예제 출력

<pre><code>* Huffman codeword
a: 0
b: 101
c: 100
d: 111
e: 1101
f: 1100

* input chars: abacdebaf

* Huffman encoding
total length of bits stream: 23
bits stream: 01010100111110110101100

* Huffman decoding
total number of decoded chars: 9
decoded chars: abacdebaf</code></pre>
