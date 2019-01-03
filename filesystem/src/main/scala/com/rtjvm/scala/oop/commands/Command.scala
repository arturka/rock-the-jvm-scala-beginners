package com.rtjvm.scala.oop.commands

import com.rtjvm.scala.oop.filesystem.State

object Command {

  def from(input: String): Command =
    new UnknownCommand()
}

trait Command {

  def apply(state: State): State
}