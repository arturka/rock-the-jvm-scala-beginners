package com.rtjvm.scala.oop.commands
import com.rtjvm.scala.oop.files.Directory
import com.rtjvm.scala.oop.filesystem.State

object Mkdir {

  def checkIllegal(name: String): Boolean = {
    name.contains(".")
  }

  def doMkdir(state: State, name: String): State = {
    val wd = state.wd
    val fullPath = wd.path

    val allDirsInPath = wd.getAllFoldersInPath

    val newDir = Directory.empty(fullPath, name)

    val newRoot = updateStructure(state.root, allDirsInPath, newDir)

    val newWorkingDirectory = newRoot.findDescendant(allDirsInPath)

    State(newRoot, newWorkingDirectory)
  }

  def updateStructure(root: Directory, path: List[String], dir: Directory): Directory = {
    if (path.isEmpty) root.addEntry(dir)
    else {
      val oldEntry = root.findEntry(path.head)
      root.replaceEntry(oldEntry.name, updateStructure(oldEntry.asDirectory, path.tail, dir))
    }
  }


}

class Mkdir(name: String) extends Command {

  override def apply(state: State): State = {
    val wd = state.wd
    if (wd.hasEntry(name)) {
      state.setMessage(s"$name is already exists!")
    } else if (name.contains(Directory.Separator)) {
      state.setMessage(s"$name must not contains separators!")
    } else if (Mkdir.checkIllegal(name)) {
      state.setMessage(s"$name illegal name!")
    } else {
      Mkdir.doMkdir(state, name)
    }
  }

}
