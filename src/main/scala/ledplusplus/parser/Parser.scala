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
      (   "Effect"~name~"{"~(expr*)~"}"     ^^ {case "Effect"~n~"{"~body~"}"    ⇒ Effect(n, body) } 
        | "Main"~"{"~(expr*)~"}"            ^^ {case "Main"~"{"~body~"}"        => Main(body)} 
        | "Led count"~number~"pin"~number   ^^ {case "Led count"~c~"pin"~p      => LedData(c, p)})
        
      
    lazy val color: PackratParser[Color] = 
      (   "Red"~(opt("->"~>color))                                  ^^ {case "Red"~None             => RED
                                                                        case "Red"~Some(c)          => RANGE(RED, c)}
        | "Blue"~(opt("->"~>color))                                 ^^ {case "Blue"~None            => BLUE
                                                                        case "Blue"~Some(c)         => RANGE(BLUE, c)}
        | "Green"~(opt("->"~>color))                                ^^ {case "Green"~None           => GREEN
                                                                        case "Green"~Some(c)        => RANGE(GREEN, c)}
        | "Orange"~(opt("->"~>color))                               ^^ {case "Orange"~None          => ORANGE
                                                                        case "Orange"~Some(c)       => RANGE(ORANGE, c)}
        | "Indigo"~(opt("->"~>color))                               ^^ {case "Indigo"~None          => INDIGO
                                                                        case "Indigo"~Some(c)       => RANGE(INDIGO, c)}
        | "Pink"~(opt("->"~>color))                                 ^^ {case "Pink"~None            => PINK
                                                                        case "Pink"~Some(c)         => RANGE(PINK, c)}
        | "Rgb"~number~number~number~(opt("->"~>color))             ^^ {case "Rgb"~r~g~b~None       => RGB(r, g, b)
                                                                        case "Rgb"~r~g~b~Some(c)    => RANGE(RGB(r, g, b), c)}
        | "Rainbow"                                                 ^^ {case "Rainbow"              => RAINBOW})

// make setColor not strip color
    lazy val expr: PackratParser[Expr] = 
      (   "Set color"~color~"for"~duration    ^^ {case "Set color"~c~"for"~d => StripColor(c, d) } 
        | "Cascade"~color~"for"~duration       ^^ {case "Cascade"~c~"for"~d         => Cascade(c, d)}
        | "Cylon"~color~"for"~duration         ^^ {case "Cylon"~c~"for"~d           => Cylon(c, d)}
        | "Rainbow"~"for"~duration            ^^ {case "Rainbow"~"for"~d     => RainbowEffect(d)}
        | name                                ^^ {case n                     => CustomEffect(n)})

    // does this just consume our desired string or all the tokens in the world
    def name: Parser[String] =  """[a-zA-Z]+""".r ^^ { _.toString }

    // does this just consume our desired integer or all the tokens in the world
    def number: Parser[Integer] = wholeNumber ^^ {s ⇒ s.toInt}    

    // does this just consume our desired integer or all the tokens in the world
    def duration: Parser[Float] = floatingPointNumber ^^ {s ⇒ s.toFloat}    
}