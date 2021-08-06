# 후위표기법과 스택

---



## 후위표기법과 중위표기법



#### 중위 표기법 _Infix Notation_

우리가 일반적으로 사용하는 표기법으로 연산자가 피연산자 사이에 온다.

$A + B * C$

#### 후위 표기법  _Postfix Notation_

역폴란드 표기법 _RPN , Reverse Polish notation_ 이라고도 한다.

연산자가 피연산자 뒤에 위치하는 표기법으로 다음과 같이 표기한다.

$ABC*+$​

#### 전위표기법 _Prefix Notation_

연산자를 피연산자 앞에 표기하는 방식

$+AB$



### 후위표기법을 사용하는 이유

>  _후위표기법은 수식을 표현할때 특별한 변환이 필요없이,  수식을 앞에서부터 읽어나가면서 **스택** 에 저장하면 된다는 장점이있다_
>
> [wiki](https://ko.wikipedia.org/wiki/%EC%97%AD%ED%8F%B4%EB%9E%80%EB%93%9C_%ED%91%9C%EA%B8%B0%EB%B2%95)

컴퓨터 내부구조에서 후위표기법을 사용하는 것이 더 효율적이기 때문에 사용한다

프로그램으로 사칙연산을 계산하기위해 스택을 활용하는데 유리하다

중위표기법으로 작성된 수식은

1. 중위 -> 후위 변환
2. 계산

과정을 거치게 되는데 두 과정 모두 스택이 필요하다





## 중위 표기법 -> 후위 표기법 변환



```pseudocode
1. 피연산자는 스택에 넣지않고 그대로 출력
2. 연산자
   - 스택이 비어있을경우 push
   - 스택이 비어있지 않을경우 스택의 연산자와 우선순위를 비교, 
     stack top 연산자가 현재 연산자의 우선순위보다 낮을때 까지 pop 후 출력
     현재연산자 stack push

3. 왼쪽 괄호 `(` 를 만나면 stack push
4. 오른쪽 괄호 `)` 를 만나면 왼쪽 괄호 `(`가 나올때까지 모든 연산자 pop 후 출력 ->  `(` 삭제
5. 표기식에 문자가 남지 않았다면 stack 을 비운다 pop 후 출력
```



#### 연산자의 우선순위

1.  `*`,  `/` , `^`, `%`
2. `+`,  `-`
3. `(`



#### Pseudo Code

```pseudocode
function operate(표기식) {
  for char in 표기식 {
    if char is Number then print char

    else if char is '(' then stack.push

    else if char is ')' then
      while stack.top != '(' print stack.pop

    else if char is Operator then
      while stack.top.우선순위 < char.우선순위 {
        print stack.pop()
      }
  }

  while !stack empty {
    print stack.pop
  }
	return stack
}
```



### Python 구현



```python
def compareOp(op1: str, op2: str):
    priority = {
        '*': 5,
        '/': 5,
        '+': 3,
        '-': 3,
        '(': 1
    }
    return priority[op1] >= priority[op2]

def convertExpression(expression: str) -> list[str]:
    stack = []
    result = []

    for char in expression.replace(' ', ''):

        # if char in number:
        if re.match('[0-9a-zA-Z]', char):
            result.append(char)

        elif char == '(':
            stack.append(char)
        elif char == ')':
            while stack[-1] != '(':
                result.append(stack.pop())
            stack.pop()
        else:

            # 우선순위가 op1 < op2 일때 True
            while stack and not compareOp(char, stack[-1]):
                result.append(stack.pop())
            stack.append(char)
    while stack:
        result.append(stack.pop())
    return result
```



TEST code

```python
expressions = [
    '1+2*3',  # 123*+
    '(1+2)*3',  # 12+3*
    '((1-3) * (3 + 4)) / 2',  # 13-34+*2/
    'A*B-C/D'  # AB*CD/-

]

for expression in expressions:
    converted = ''.join(convertExpression(expression))
    print(converted)
```



## 변환된 후위표기식의 연산

후위 표기법을 계산할때 방법

1. 피연산자를 만나면 스택에 담는다
2. 연산자를 만나면 스택에서  두 개의 피연산자를 꺼내 연산후 다시 담는다
3. 연산이 끝났을때 스택에 남아있는 하나의 피연산자가 연산의 결과이다



#### Pseudocode

```pseudocode
function calculate(후위표기법) {

  for op in expression {
    if op is Number then stack.push op

    else then 
    a = stack.pop
    b = stack.pop
    result = operate a, op, b
    stack.push result
  }

  return stack.pop
}
```



#### Python 구현



```python
def calculate_postfix(postfix_exp: list[str]) -> int:
    stack = []

    for op in postfix_exp:

        if re.match('[0-9]', op):
            stack.append(op)

        else:
            b = stack.pop()
            a = stack.pop()
            result = operate(a, op, b)
            stack.append(result)

    return stack.pop()


def calculate(expression: str) -> int:

    convert = convertExpression(expression)

    return calculate_postfix(convert)

```



#### Test code



```python
expressions = [
    '1+2*3',  # 7
    '(1+2)*3',  # 9
    '((1-3) * (3 + 4)) / 2',  # -7.0
    '((2 * (2 ^ 3) - (2 ^ 2)) / 2) % 3'  # 0.0

]
for exp in expressions:
  print(calculate(exp))
```

