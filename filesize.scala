import java.io._

object Filesize {

  var file_size  = 0
  val characters = "abcdefghijklmnopqrstuvwxyz0123456789"

  def createFile(the_size: Float, file_name: String) {
    if (the_size > 0) {
      val f = new File(file_name)
      var file_write = new FileWriter(f)
      while (file_size <= (the_size * 1048576)) { // bytes in 1MB
        file_write.write(characters)
        file_size = file_size + characters.length() }
      file_write.close()
      println("File " + file_name + " created!")
    } else {
      println("Enter a valid number! \n") }
  }

  def main(args: Array[String]) {
    println("Enter file size (MB:) ")
    val x = scala.io.StdIn.readLine()

    val the_size  = x.toFloat
    val file_name = (the_size + "MB.txt")

    createFile(the_size, file_name)
  }
}
