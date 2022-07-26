package main

import ( 
    "bufio"
    "fmt"
    "os"
    "strconv"
    "math"
)

    
func check(e error) {
    if e != nil {
        panic(e)
    }
}

func isPrime(num int) string{
    if(num < 2){
        return ""
    }
    sq_root := int(math.Sqrt(float64(num)))
    for i:=2; i<=sq_root; i++{
        if num % i == 0 {
            return ""
        }
    }
    return " => Prime"
}

func main(){
    file, err := os.Open("numbers.txt")
    check(err)

    defer file.Close()

    scanner := bufio.NewScanner(file)
    for scanner.Scan() {
        number, err := strconv.Atoi(scanner.Text())
        check(err)
        fmt.Println(number, isPrime(number))
    }
}