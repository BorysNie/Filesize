require 'gets'

print 'Enter file size (MB): '
the_size = gets.chomp

fail 'bad file size' unless the_size =~ /^\d+$/

file_size = 0
string    = 'abcdefghijklmnopqrstuvwxyz0123456789'

File.open(the_size + 'MB', 'w') do |f|
  while file_size < the_size.to_i * 1048576 # bytes in 1MB
    f.print string
    file_size += string.size
  end
end
