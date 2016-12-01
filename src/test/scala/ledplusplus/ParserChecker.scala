package ledplusplus.parser

import scala.language.implicitConversions
import org.scalacheck.Prop.forAll
import org.scalacheck.Properties
import ledplusplus.absyn._

object LedParseSpec extends Properties("Parser") {

    // some syntactic sugar for expressing parser tests
    implicit class ParseResultChecker(input: String) {
      def ~>(output: Expr) = {
        val result = LedParser(input)
        result.successful && result.get == output
      }
    }
    
    property("expr") = forAll { (str: String) ⇒
      s"Custom $str" ~> CustomEffect(str)
    } 
    
    // property("addition") = forAll { (n1: Int, n2: Int) ⇒
    //   s"$n1 + $n2" ~> (n1 |+| n2)   
    // } 
    
    // property("subtraction") = forAll { (n1: Int, n2: Int) ⇒
    //   s"$n1 - $n2" ~> (n1 |-| n2)   
    // } 
    
    // property("multiplication") = forAll { (n1: Int, n2: Int) ⇒
    //   s"$n1 * $n2" ~> (n1 |*| n2)   
    // } 
    
    // property("division") = forAll { (n1: Int, n2: Int) ⇒
    //   s"$n1 / $n2" ~> (n1 |/| n2)   
    // } 
    
    // property("parenthetical") = forAll { (n1: Int, n2: Int) ⇒
    //   s"$n1 * ($n2 + $n2)" ~> (n1 |*| (n2 |+| n2))   
    // } 
}