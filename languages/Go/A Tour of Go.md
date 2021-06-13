# A Tour of Go

## Hello World!

```go
package main

import "fmt"

func main() {
    fmt.Println("Hello World!")
}
```

### 함수의 인자 표현

둘 다 똑같음

```go
func add(int x, int y) int {
    return x + y
}
```

```go
func add(x, y int) int {
    return x + y
}
```

