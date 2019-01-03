package com.rtjvm.scala.oop.commands

import com.rtjvm.scala.oop.filesystem.State

object Command {
  val MkDir = "mkdir"

  def emptyCommand: Command = new Command {
    override def apply(state: State): State = state.setMessage("")
  }

  def incompleteCommand(name: String): Command = new Command {
    override def apply(state: State): State = state.setMessage(s"$name: incomplete command!")
  }

  def from(input: String): Command = {
    val tokens: Array[String] = input.split(" ")

    if (input.isEmpty || tokens.isEmpty) emptyCommand
    else if (MkDir.equals(tokens(0))) {
      if (tokens.length < 2) incompleteCommand(MkDir)
      else new Mkdir(tokens(1))
    } else new UnknownCommand()
  }

}

trait Command {


  def apply(state: State): State


}