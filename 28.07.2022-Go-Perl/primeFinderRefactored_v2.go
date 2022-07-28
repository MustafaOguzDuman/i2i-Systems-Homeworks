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


func isPrime(num int) string{
    if num < 2 {
        return "\n"
    }

    sq_root := int(math.Sqrt(float64(num)))
    for i:=2; i<=sq_root; i++{
        if num % i == 0 {
            return "\n"
        }
    }
    return " => Prime\n"
}

func main(){
    file, err := os.Open("numbers.txt")
    check(err)

    defer file.Close()

    writefile, err := os.Create("result.txt")
    check(err)
    defer writefile.Close()

    var finalresults string = ""

    scanner := bufio.NewScanner(file)
    for scanner.Scan() {
        number, err := strconv.Atoi(scanner.Text())
        check(err)
        //fmt.Println(number, isPrime(number))
        concatenated := fmt.Sprintf("%d%s", number, isPrime(number))
        finalresults = fmt.Sprintf("%s%s", finalresults, concatenated)
    }
    error := os.WriteFile("result.txt", []byte(finalresults), 0644)
    check(error)
}
