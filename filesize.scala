import java.io._ import scala.io._ object Filesize {
  def main(args: Array[String]) {
    var file_size = 0
    val characters = "abcdefghijklmnopqrstuvwxyz123456"
    val file_mb = "MB"
    println("Enter file size (MB:) ")
    val x = scala.io.StdIn.readLine()
    val the_size = x.toFloat
    val file_name = (the_size + file_mb)
    if (the_size > 0) {
      val f = new File(file_name)
      var file_write = new FileWriter(f)
      while (file_size <= (the_size * 1048576)) { // bytes in 1MB
        file_write.write(characters)
        file_size = file_size + characters.length() }
      println("File " + file_name + " created!")
      file_write.close()
    } else {
      println("Enter a valid number! \n") }
  }
}
