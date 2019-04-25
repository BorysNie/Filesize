the_size = float(input('Enter file size (MB): '))

file_size = 0
string = 'abcdefghijklmnopqrstuvwxyz0123456789'

if the_size >= 0:
    File = open(str(the_size) + 'MB.txt', 'w')
    while file_size < (the_size * 1048576):  # bytes in 1MB
        File.write(string)
        file_size += len(string)
else:
    Error = ValueError('Please enter a positive number!')
    raise Error

