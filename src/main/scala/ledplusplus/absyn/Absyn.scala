package ledplusplus.absyn

// How do I call the semantics section from the abysn section..


// Color = Red | Blue | Green | Orange | Indigo | Pink | RGB Integer Integer Integer
sealed abstract class Color  // what does sealed do..
object RED extends Color
object BLUE extends Color
object GREEN extends Color
object ORANGE extends Color
object INDIGO extends Color
object PINK extends Color
case class RGB (red : Integer, green : Integer, blue : Integer) extends Color 


// Stmt = Effect <name (STRING)> [Expr] | Main [Expr]
// main must run effects..1
sealed abstract class Stmt 
case class Effect (name: String, body: List[Expr]) extends Stmt
case class Main (body: List[Expr]) extends Stmt

sealed abstract class Expr // shouldnt be called expr
case class StripColor (col: Color, duration: Integer) extends Expr
case class CustomEffect (name: String) extends Expr

