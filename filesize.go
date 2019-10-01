package main

import (
    "fmt"
	"os"
	"strconv"
)

func user_input() int {
	var userIn int
	fmt.Print("Enter the file size to be generated in MB's: ")
	fmt.Scanln(&userIn)
	return userIn
}

func int_to_string(userIn int) string {
	return strconv.Itoa(userIn)
}

func generate_file(userIn int, fileName string) {
	chars := "abcdefghijklmnopqrstuvwxyz0123456789"
	fileSize := 0

	if _, err := os.Stat(fileName); os.IsNotExist(err) {
		f, err := os.OpenFile(fileName, os.O_APPEND|os.O_CREATE|os.O_WRONLY, 0744)
		if err != nil { panic(err) }

		defer f.Close()

		for fileSize < userIn * 1048576 {
			if _, err := f.WriteString(chars); err != nil { panic(err) }
			fileSize += len(chars)
		}
	}
}

func main() {
	userIn := user_input()
	sizeStr := int_to_string(userIn)
	fileName := sizeStr + "MB.txt"

	if userIn <= 0 {
		fmt.Print("Enter a positive number! \n")
		main()
	} else {
		generate_file(userIn, fileName)
		fmt.Print("Done!\n")
	}
}