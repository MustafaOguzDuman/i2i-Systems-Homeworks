package main

import ( 
    "bufio"
    "fmt"
    "os"
    "strconv"
    "math"
)


func isPrime(num int){
    if(num < 2){
        fmt.Println(num)
    }
    sq_root := int(math.Sqrt(float64(num)))
    for i:=2; i<=sq_root; i++{
        if num % i == 0 {
            fmt.Println(num)
        }
    }
    fmt.Println(num, " => Prime")
}

func main(){
    file, err := os.Open("numbers.txt")
    if err != nil {
        panic(err)
    }

    defer file.Close()

    scanner := bufio.NewScanner(file)
    for scanner.Scan() {
        num, err := strconv.Atoi(scanner.Text())
        if err != nil {
            panic(err)
        }
        if(num < 2){
            fmt.Println(num)
        } else{
            var cond bool
            cond = true
            sq_root := int(math.Sqrt(float64(num)))
            for i:=2; i<=sq_root; i++{
                if num % i == 0 {
                    fmt.Println(num)
                    cond = false
                    break
                }
            }
            if(cond){
                fmt.Println(num, " => Prime")
            }
        }
        
    }
}