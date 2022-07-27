package main

import ( 
    "bufio"
    "fmt"
    "os"
    "strconv"
    "math"
)

    
//addressing error variables
func check(e error) {
    if e != nil {
        panic(e)
    }
}

//finding out if a number is prime
//if prime the function returns a string label
//if not it returns an empty string
func isPrime(num int) string{
    //prime numbers start at 2. If the number is less than 2 it isn't a prime
    if num < 2{
        return ""
    }
    //a number is prime if it is doesn't have a number less than or equal to...
    //its sqrt as a factor
    sq_root := int(math.Sqrt(float64(num)))
    for i:=2; i<=sq_root; i++{
        if num % i == 0 {
            return ""
        }
    }
    return " => Prime"
}

func main(){
    //open file
    file, err := os.Open("numbers.txt")
    check(err)

    defer file.Close()

    //add scanner
    scanner := bufio.NewScanner(file)
    //use the isPrime function for each line
    for scanner.Scan() {
        number, err := strconv.Atoi(scanner.Text())
        check(err)
        fmt.Println(number, isPrime(number))
    }
}
