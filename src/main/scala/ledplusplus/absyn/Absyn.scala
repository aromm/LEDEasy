package ledplusplus.absyn

// How do I call the semantics section from the abysn section..


// Color = Red | Blue | Green | Orange | Indigo | Pink | RGB Integer Integer Integer
sealed abstract class Color  // what does sealed do..
object BLACK extends Color
object NAVY extends Color
object DARKBLUE extends Color
object MEDIUMBLUE extends Color
object BLUE extends Color
object DARKGREEN extends Color
object GREEN extends Color
object TEAL extends Color
object DARKCYAN extends Color
object DEEPSKYBLUE extends Color
object DARKTURQUOISE extends Color
object MEDIUMSPRINGGREEN extends Color
object LIME extends Color
object SPRINGGREEN extends Color
object AQUA extends Color
object CYAN extends Color
object MIDNIGHTBLUE extends Color
object DODGERBLUE extends Color
object LIGHTSEAGREEN extends Color
object FORESTGREEN extends Color
object SEAGREEN extends Color
object DARKSLATEGRAY extends Color
object LIMEGREEN extends Color
object MEDIUMSEAGREEN extends Color
object TURQUOISE extends Color
object ROYALBLUE extends Color
object STEELBLUE extends Color
object DARKSLATEBLUE extends Color
object MEDIUMTURQUOISE extends Color
object INDIGO extends Color
object DARKOLIVEGREEN extends Color
object CADETBLUE extends Color
object CORNFLOWERBLUE extends Color
object MEDIUMAQUAMARINE extends Color
object DIMGRAY extends Color
object SLATEBLUE extends Color
object OLIVEDRAB extends Color
object SLATEGRAY extends Color
object LIGHTSLATEGRAY extends Color
object MEDIUMSLATEBLUE extends Color
object LAWNGREEN extends Color
object CHARTREUSE extends Color
object AQUAMARINE extends Color
object MAROON extends Color
object PURPLE extends Color
object OLIVE extends Color
object GRAY extends Color
object SKYBLUE extends Color
object LIGHTSKYBLUE extends Color
object BLUEVIOLET extends Color
object DARKRED extends Color
object DARKMAGENTA extends Color
object SADDLEBROWN extends Color
object DARKSEAGREEN extends Color
object LIGHTGREEN extends Color
object MEDIUMPURPLE extends Color
object DARKVIOLET extends Color
object PALEGREEN extends Color
object DARKORCHID extends Color
object YELLOWGREEN extends Color
object SIENNA extends Color
object BROWN extends Color
object DARKGRAY extends Color
object LIGHTBLUE extends Color
object GREENYELLOW extends Color
object PALETURQUOISE extends Color
object LIGHTSTEELBLUE extends Color
object POWDERBLUE extends Color
object FIREBRICK extends Color
object DARKGOLDENROD extends Color
object MEDIUMORCHID extends Color
object ROSYBROWN extends Color
object DARKKHAKI extends Color
object SILVER extends Color
object MEDIUMVIOLETRED extends Color
object INDIANRED extends Color
object PERU extends Color
object CHOCOLATE extends Color
object TAN extends Color
object LIGHTGRAY extends Color
object THISTLE extends Color
object ORCHID extends Color
object GOLDENROD extends Color
object PALEVIOLETRED extends Color
object CRIMSON extends Color
object GAINSBORO extends Color
object PLUM extends Color
object BURLYWOOD extends Color
object LIGHTCYAN extends Color
object LAVENDER extends Color
object DARKSALMON extends Color
object VIOLET extends Color
object PALEGOLDENROD extends Color
object LIGHTCORAL extends Color
object KHAKI extends Color
object ALICEBLUE extends Color
object HONEYDEW extends Color
object AZURE extends Color
object SANDYBROWN extends Color
object WHEAT extends Color
object BEIGE extends Color
object WHITESMOKE extends Color
object MINTCREAM extends Color
object GHOSTWHITE extends Color
object SALMON extends Color
object ANTIQUEWHITE extends Color
object LINEN extends Color
object LIGHTGOLDENRODYELLOW extends Color
object OLDLACE extends Color
object RED extends Color
object FUCHSIA extends Color
object MAGENTA extends Color
object DEEPPINK extends Color
object ORANGERED extends Color
object TOMATO extends Color
object HOTPINK extends Color
object CORAL extends Color
object DARKORANGE extends Color
object LIGHTSALMON extends Color
object ORANGE extends Color
object LIGHTPINK extends Color
object PINK extends Color
object GOLD extends Color
object PEACHPUFF extends Color
object NAVAJOWHITE extends Color
object MOCCASIN extends Color
object BISQUE extends Color
object MISTYROSE extends Color
object BLANCHEDALMOND extends Color
object PAPAYAWHIP extends Color
object LAVENDERBLUSH extends Color
object SEASHELL extends Color
object CORNSILK extends Color
object LEMONCHIFFON extends Color
object FLORALWHITE extends Color
object SNOW extends Color
object YELLOW extends Color
object LIGHTYELLOW extends Color
object IVORY extends Color
object WHITE extends Color
object RAINBOW extends Color
case class RGB (red: Integer, green: Integer, blue: Integer) extends Color 
case class RANGE (startColor: Color, endColor: Color) extends Color



sealed abstract class Prgm
case class Program (body: List[Stmt]) extends Prgm


// Stmt = Effect <name (STRING)> [Expr] | Main [Expr]
// main must run effects..1
sealed abstract class Stmt 
case class Effect (name: String, body: List[Expr]) extends Stmt
case class Main (body: List[Expr]) extends Stmt
case class LedData(count: Integer, pin: Integer) extends Stmt

sealed abstract class Expr // shouldnt be called expr
case class StripColor (col: Color, duration: Float) extends Expr
case class CustomEffect (name: String, loop: Integer) extends Expr
case class Cascade (col: Color, duration: Float) extends Expr
case class Cylon(col: Color, duration: Float) extends Expr
case class RainbowEffect (duration: Float) extends Expr

