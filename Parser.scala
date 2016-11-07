package piconot.external
 
 import scala.util.parsing.combinator._
 import PiconotTypes._
 
 
 /** A recursive descent parser for the Piconot language. See design.md for
  *  the grammar.
  */
 object PiconotParser extends JavaTokenParsers with PackratParsers with RegexParsers {
 
   // parsing interface
   def apply(stmts: List(Stmt)): ParseResult[stmt] = {
     parseAll(program)
  }
}