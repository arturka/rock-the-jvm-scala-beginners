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

  override def asDirectory: Directory = this

  def hasEntry(name: String): Boolean = contents.exists(p => p.name == name)

  def getAllFoldersInPath: List[String] =
    path.substring(1).split(Directory.Separator).toList

  def findDescendant(path: List[String]): Directory =
    if (path.isEmpty) this
    else findEntry(path.head).asDirectory.findDescendant(path.tail)

  def addEntry(newEntry: DirEntry): Directory = new Directory(parentPath, name, contents :+ newEntry)

  def findEntry(rootPath: String): DirEntry = {
    def findEntryHelper(path: String, entries: List[DirEntry]): DirEntry = {
      if (entries.isEmpty) null
      else if (entries.head.name.equals(path)) entries.head
      else findEntryHelper(path, entries.tail)
    }

    findEntryHelper(rootPath, contents)
  }

  def replaceEntry(entryName: String, newEntry: DirEntry): Directory =
    new Directory(parentPath, name, contents.filter(p => !p.name.equals(entryName)) :+ newEntry)
}
