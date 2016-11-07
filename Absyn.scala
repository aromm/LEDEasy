// How do I call the semantics section from the abysn section..
var statements: List(Stmt)

abstract class Color 
object Red extends Color
object Blue extends Color
object Green extends Color
object Orange extends Color
object Indigo extends Color
object Pink extends Color
case class RGB (red : int, green : int, blue : int) extends Color {

}

abstract class Stmt // might not be necessary
case class StripColor (col: Color, duration: int) extends Stmt {

}
case class Effect (name: String, body: List(Stmt)) extends Stmt {

}

def runLEDs (/* list of statements?*/)
