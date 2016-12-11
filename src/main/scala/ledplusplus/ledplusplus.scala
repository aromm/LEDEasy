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

import java.io._

import scalafx.application.JFXApp


// Template for this taken from Jeb and Daniel piconot parser
object Led {
 
 def main(args: Array[String]): Unit = {

    val srcFileName = args.toList(1)
    val nameNoExtension = srcFileName.substring(0, srcFileName.indexOf("."))
    val sourceFile = io.Source.fromFile(srcFileName)
    val source = try sourceFile.mkString finally sourceFile.close()

    val parseResult = LedParser(source.toLowerCase())
  
  
    parseResult match {
      case LedParser.Success(ast, _) => evalAst(ast, nameNoExtension)
      case e: LedParser.NoSuccess => {
        System.err.println(e)
        System.exit(100)
      }
    }
  }

  def evalAst(ast: Prgm, fileName: String) = {

    // if (parseResult == LedParser.NoSuccess){
    //   println(parseResult)
    // }
  
    // val ast = parseResult.get
    val arduinoCode = evalProgram(ast)
  
  
    val dir = new File("./" + fileName);
    val file = new File("./" + fileName + "/" + fileName + ".ino")
    if(dir.exists){
      mkFile(file, arduinoCode)
    }
    else {
      // attempt to create the directory here
      val successful = dir.mkdir();
      if (successful)
      {
        mkFile(file, arduinoCode)
      }
      else
      {
        // creating the directory failed
        println("failed trying to create the directory");
      }
    }
  }

  def mkFile(file: File, code: String) = {
    val bw = new BufferedWriter(new FileWriter(file, false))
    bw.write(code)
    bw.close()
  }
}