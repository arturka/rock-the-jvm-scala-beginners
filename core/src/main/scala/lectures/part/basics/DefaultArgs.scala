package lectures.part.basics

object DefaultArgs extends App {

  def trFact(n: Int, acc: Int = 1): Int =
    if (n <= 1) acc
    else trFact(n - 1, acc * n)

  def savePicture(format: String = "bmp", width: Int = 400, height: Int = 400): Unit = println(s"$format, width: $width, height: $height")

  savePicture(width = 30)
  savePicture()
  savePicture(width = 300, height = 200)
}
