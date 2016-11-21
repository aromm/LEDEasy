package ledplusplus.parser
 
import scala.util.parsing.combinator._
import scala.util._
import ledplusplus.absyn._


object LedParser extends JavaTokenParsers with PackratParsers with RegexParsers{

    // parsing interface
    def apply(s: String): ParseResult[Prgm] = parseAll(prgm, s)

    lazy val prgm: PackratParser[Prgm] = 
      (   (stmt*) ^^ {case s => Program(s)})
    // expressions
    lazy val stmt: PackratParser[Stmt] = 
      (   "Effect"~name~"{"~(expr*)~"}" ^^ {case "Effect"~n~"{"~body~"}" ⇒ Effect(n, body) } 
        | "Main"~"{"~(expr*)~"}" ^^ {case "Main"~"{"~body~"}" => Main(body)} 
        | "Led count" ~ number   ^^ {case "Led count" ~ n     => LedCount(n)}
        | "Led pin" ~ number   ^^ {case "Led pin" ~ n     => LedPin(n)})
        
      
    lazy val color: PackratParser[Color] = 
      (   "Red"                                 ^^ {case "Red" => RED}
        | "Blue"                                ^^ {case "Blue" => BLUE}
        | "Green"                               ^^ {case "Green" => GREEN}
        | "Orange"                              ^^ {case "Orange" => ORANGE}
        | "Indigo"                              ^^ {case "Indigo" => INDIGO}
        | "Pink"                                ^^ {case "Pink" => PINK}
        | "Rgb"~number~" "~number~" "~number    ^^ {case "Rgb"~r~" "~g~" "~b => RGB(r, g, b)})
        //| "Rainbow"                             ^^ {case "Rainbow" => RAINBOW})

// make setColor not strip color
    lazy val expr: PackratParser[Expr] = 
      (   "Set color"~color~"for"~duration ^^ {case "Set color"~c~"for"~d => StripColor(c, d) } 
        | "Custom"~name                      ^^ {case "Custom"~n              => CustomEffect(n)}
        | "Cascade"~color~duration      ^^ {case "Cascade"~c~d => Cascade(c, d)}
        | "Wave"~color~duration         ^^ {case "Wave"~c~d    => Wave(c, d)}
        | "Cylon"~color~duration        ^^ {case "Cylon"~c~d   => Cylon(c, d)}
        | "Rainbow"~duration            ^^ {case "Rainbow"~d   => Rainbow(d)})

    // does this just consume our desired string or all the tokens in the world
    def name: Parser[String] =  """[a-zA-Z]+""".r ^^ { _.toString }

    // does this just consume our desired integer or all the tokens in the world
    def number: Parser[Integer] = wholeNumber ^^ {s ⇒ s.toInt}    

    // does this just consume our desired integer or all the tokens in the world
    def duration: Parser[Integer] = wholeNumber ^^ {s ⇒ s.toInt}    
}