package ledplusplus

// import scala.tools.nsc.EvalLoop
import ledplusplus.parser._
import ledplusplus.semantics.evalProgram
import ledplusplus.absyn._

// object led extends EvalLoop with App {
//   override def prompt = "> "

// // check to make sure first thing to parse is LED_count and maybe the pin too 

//   loop { line ⇒
//     LedParser(line) match {
//       case LedParser.Success(t, _) ⇒ println(ledplusplus.semantics.evalProgram(t))
//       case e: LedParser.NoSuccess  ⇒ println("no success")
//     }
//   }
// }


import java.io.File
import scalafx.application.JFXApp


// Template for this taken from Jeb and Daniel piconot parser
object Led {
 
 def main(args: Array[String]): Unit = {
    println("Hello, world!")
  
 // val args = parameters.unnamed

 //  val srcFileName = args(0)
    val srcFileName = "test.txt"
    val sourceFile = io.Source.fromFile(srcFileName)
    val source = try sourceFile.mkString finally sourceFile.close()

 //  // parse file
 //  val sourceFile = io.Source.fromFile(srcFileName)
 //  val source = try sourceFile.mkString finally sourceFile.close()

    println("My Code")
  println(source)
  Console.out.flush
  println("The parsed code")
  println(LedParser(source))
  Console.out.flush

  val parseResult = LedParser(source)

  require(parseResult.successful)

  // val expr: Expr = CustomEffect("hello")
  // val exprL: List[Expr] = List(expr)

  // val stmt: Stmt = Main(exprL)
  // val stmtL: List[Stmt] = List(stmt)

  // val prgm: Prgm = Program(stmtL)

  // val arduinoCode = evalProgram(prgm)

  val ast = parseResult.get
  val arduinoCode = evalProgram(ast)

  println("The arduino code")
  println(arduinoCode)
    Console.out.flush

}
}