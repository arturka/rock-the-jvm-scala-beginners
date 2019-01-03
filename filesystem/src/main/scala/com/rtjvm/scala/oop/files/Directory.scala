package com.rtjvm.scala.oop.files

object Directory {
  val Separator = "/"
  val RootPath = "/"

  def root: Directory = Directory.empty("", "")

  def empty(parentPath: String, name: String): Directory =
    new Directory(parentPath, name, List())
}

class Directory(override val parentPath: String,
                override val name: String,
                val contents: List[DirEntry])
  extends DirEntry(parentPath, name) {

}
