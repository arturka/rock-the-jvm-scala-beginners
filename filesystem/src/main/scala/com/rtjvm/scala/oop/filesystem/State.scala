package com.rtjvm.scala.oop.filesystem

import com.rtjvm.scala.oop.files.Directory

object State {
  val ShellToken: String = "$ "

  def apply(root: Directory, wd: Directory, output: String = ""): State =
    new State(root, wd, output)
}

class State(val root: Directory, val wd: Directory, val output: String) {

  def show: Unit = {
    println(output)
    print(State.ShellToken)
  }

  def setMessage(message: String): State =
    State(root, wd, message)
}
