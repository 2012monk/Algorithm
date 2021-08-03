# LIS 최장 부분 증가 수열

## DP 를 사용해서 풀기

O(n^2)

수열을 순회하며 각 인덱스 수열의 길이를 1로 초기화

수열의 길이를 저장해 놓았던 배열을 순회하면서 가장 큰 값 + 1을 업데이트 한다


## Binary Search 를 이용해 개선

Binary Search 의 시간복잡도는 O(log n) 이다
이를 적용하면 O(nlog n)으로 개선시킬수있다

결과 배열에 수열의 첫번째 요소를 넣어 초기화


수열을 순회하며 배열에 들어갈 자리를 찾는다

- 배열의 마지막 요소보다 크면 배열에 추가
- 작으면 배열을 순회하면서 자신보다 큰 요소 자리에 넣는다 Binary Search 사용

```
arr = [2, 1, 3, 5, 4]
lis = [2]

i = 1
list = [1]  #  자신보다 큰 값의 인덱스 자리에 넣는다 idx=0

i = 3
list = [1, 3]

i = 5
list = [1, 3, 5]

i = 4
list = [1, 3, 4] # idx=3
 
```

하지만 이 방법을 사용할 경우 실제 lis 를 알아낼수는 없다

```
arr = [2,3,4,1]
lis = [2,3,4]
i = 1

lis = [1, 3, 4]

```

### 참고

[lis1](https://chanhuiseok.github.io/posts/algo-49/)


[lis2](https://jins-dev.tistory.com/entry/%EC%B5%9C%EC%A0%81%ED%99%94%EB%90%9C-LISLongest-Increasing-Subsequence-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98%EA%B3%BC-%ED%95%B4-%EC%B0%BE%EA%B8%B0#recentEntries)


[binary search](https://cjh5414.github.io/binary-search/)


