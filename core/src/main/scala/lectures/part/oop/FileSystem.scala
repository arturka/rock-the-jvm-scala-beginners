package lectures.part.oop

import java.util.Scanner

import com.rtjvm.scala.oop.commands.Command
import com.rtjvm.scala.oop.files.Directory
import com.rtjvm.scala.oop.filesystem.State

object FileSystem extends App {

  override def main(args: Array[String]): Unit = {
    val root = Directory.root
    var state = State(root, root)
    val scanner = new Scanner(System.in)

    while (true) {
      state.show
      state = Command.from(scanner.nextLine()).apply(state)
    }
  }

}
