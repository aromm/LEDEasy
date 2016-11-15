package ledplusplus

import scala.tools.nsc.EvalLoop
import ledplusplus.parser._
import ledplusplus.semantics.evalProgram

object led extends EvalLoop with App {
  override def prompt = "> "

  loop { line ⇒
    LedParser(line) match {
      case LedParser.Success(t, _) ⇒ println(ledplusplus.semantics.evalProgram(t))
      case e: LedParser.NoSuccess  ⇒ println("no success")
    }
  }
}