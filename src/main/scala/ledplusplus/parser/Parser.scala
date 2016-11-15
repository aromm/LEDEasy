package ledplusplus.parser
 
import scala.util.parsing.combinator._
import scala.util._
import ledplusplus.abysn._


object LedParser extends JavaTokenParsers with PackratParsers{

    // parsing interface
    def apply(s: String): ParseResult[ledplusplus.absyn.Stmt] = parseAll(stmt, s)

    // expressions
    lazy val stmt: PackratParser[ledplusplus.absyn.Stmt] = 
      (   "Effect"~name~"{"~expr~"}" ^^ {case "Effect"~n~"{"~body~"}" ⇒ ledplusplus.absyn.Effect(n, body) } 
        | "Main"~"{"~expr~"}" ^^ {case "Main"~"{"~body~"}" => ledplusplus.absyn.Main(body)})
        
      
    lazy val color: PackratParser[ledplusplus.absyn.Color] = 
      (   "Red"   ^^ {case "Red" => ledplusplus.absyn.RED}
        | "Blue"   ^^ {case "Blue" => ledplusplus.absyn.BLUE}
        | "Green"   ^^ {case "Green" => ledplusplus.absyn.GREEN}
        | "Orange"   ^^ {case "Orange" => ledplusplus.absyn.ORANGE}
        | "Indigo"   ^^ {case "Indigo" => ledplusplus.absyn.INDIGO}
        | "Pink"   ^^ {case "Pink" => ledplusplus.absyn.PINK}
        | "Rgb"~number~" "~number~" "~number ^^ {case "Rgb"~r~" "~g~" "~b => ledplusplus.absyn.RGB(r, g, b)})

    lazy val expr: PackratParser[ledplusplus.absyn.Expr] = 
      (   "Strip color"~color~"for"~duration ^^ {case "Strip color"~c~"for"~d => ledplusplus.absyn.StripColor(c, d) } 
        | "Custom"~name                      ^^ {case "Custom"~n              => ledplusplus.absyn.CustomEffect(n)})

    // does this just consume our desired string or all the tokens in the world
    def name: Parser[String] = stringLiteral ^^ {case s => s}

    // does this just consume our desired integer or all the tokens in the world
    def number: Parser[Num] = wholeNumber ^^ {s ⇒ Num(s.toInt)}    

    // does this just consume our desired integer or all the tokens in the world
    def duration: Parser[Num] = wholeNumber ^^ {s ⇒ Num(s.toInt)}    
}