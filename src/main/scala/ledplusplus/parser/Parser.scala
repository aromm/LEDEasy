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
      (   "effect"~name~"{"~(expr*)~"}"     ^^ {case "effect"~n~"{"~body~"}"    ⇒ Effect(n, body) } 
        | "main"~"{"~(expr*)~"}"            ^^ {case "main"~"{"~body~"}"        => Main(body)} 
        | "led"~"count"~number~"pin"~number   ^^ {case "led"~"count"~c~"pin"~p      => LedData(c, p)})
        
      
    lazy val color: PackratParser[Color] = 
      (   "black"~(opt("->"~>color))                    ^^ {case "black"~None                       => BLACK
                                                            case "black"~Some(c)                    => RANGE(BLACK, c)}
        | "navy"~(opt("->"~>color))                     ^^ {case "navy"~None                        => NAVY
                                                            case "navy"~Some(c)                     => RANGE(NAVY, c)}
        | "darkblue"~(opt("->"~>color))                 ^^ {case "darkblue"~None                    => DARKBLUE
                                                            case "darkblue"~Some(c)                 => RANGE(DARKBLUE, c)}
        | "mediumblue"~(opt("->"~>color))               ^^ {case "mediumblue"~None                  => MEDIUMBLUE
                                                            case "mediumblue"~Some(c)               => RANGE(MEDIUMBLUE, c)}
        | "blue"~(opt("->"~>color))                     ^^ {case "blue"~None                        => BLUE
                                                            case "blue"~Some(c)                     => RANGE(BLUE, c)}
        | "darkgreen"~(opt("->"~>color))                ^^ {case "darkgreen"~None                   => DARKGREEN
                                                            case "darkgreen"~Some(c)                => RANGE(DARKGREEN, c)}
        | "green"~(opt("->"~>color))                    ^^ {case "green"~None                       => GREEN
                                                            case "green"~Some(c)                    => RANGE(GREEN, c)}
        | "teal"~(opt("->"~>color))                     ^^ {case "teal"~None                        => TEAL
                                                            case "teal"~Some(c)                     => RANGE(TEAL, c)}
        | "darkcyan"~(opt("->"~>color))                 ^^ {case "darkcyan"~None                    => DARKCYAN
                                                            case "darkcyan"~Some(c)                 => RANGE(DARKCYAN, c)}
        | "deepskyblue"~(opt("->"~>color))              ^^ {case "deepskyblue"~None                 => DEEPSKYBLUE
                                                            case "deepskyblue"~Some(c)              => RANGE(DEEPSKYBLUE, c)}
        | "darkturquoise"~(opt("->"~>color))            ^^ {case "darkturquoise"~None               => DARKTURQUOISE
                                                            case "darkturquoise"~Some(c)            => RANGE(DARKTURQUOISE, c)}
        | "mediumspringgreen"~(opt("->"~>color))        ^^ {case "mediumspringgreen"~None           => MEDIUMSPRINGGREEN
                                                            case "mediumspringgreen"~Some(c)        => RANGE(MEDIUMSPRINGGREEN, c)}
        | "lime"~(opt("->"~>color))                     ^^ {case "lime"~None                        => LIME
                                                            case "lime"~Some(c)                     => RANGE(LIME, c)}
        | "springgreen"~(opt("->"~>color))              ^^ {case "springgreen"~None                 => SPRINGGREEN
                                                            case "springgreen"~Some(c)              => RANGE(SPRINGGREEN, c)}
        | "aqua"~(opt("->"~>color))                     ^^ {case "aqua"~None                        => AQUA
                                                            case "aqua"~Some(c)                     => RANGE(AQUA, c)}
        | "cyan"~(opt("->"~>color))                     ^^ {case "cyan"~None                        => CYAN
                                                            case "cyan"~Some(c)                     => RANGE(CYAN, c)}
        | "midnightblue"~(opt("->"~>color))             ^^ {case "midnightblue"~None                => MIDNIGHTBLUE
                                                            case "midnightblue"~Some(c)             => RANGE(MIDNIGHTBLUE, c)}
        | "dodgerblue"~(opt("->"~>color))               ^^ {case "dodgerblue"~None                  => DODGERBLUE
                                                            case "dodgerblue"~Some(c)               => RANGE(DODGERBLUE, c)}
        | "lightseagreen"~(opt("->"~>color))            ^^ {case "lightseagreen"~None               => LIGHTSEAGREEN
                                                            case "lightseagreen"~Some(c)            => RANGE(LIGHTSEAGREEN, c)}
        | "forestgreen"~(opt("->"~>color))              ^^ {case "forestgreen"~None                 => FORESTGREEN
                                                            case "forestgreen"~Some(c)              => RANGE(FORESTGREEN, c)}
        | "seagreen"~(opt("->"~>color))                 ^^ {case "seagreen"~None                    => SEAGREEN
                                                            case "seagreen"~Some(c)                 => RANGE(SEAGREEN, c)}
        | "darkslategray"~(opt("->"~>color))            ^^ {case "darkslategray"~None               => DARKSLATEGRAY
                                                            case "darkslategray"~Some(c)            => RANGE(DARKSLATEGRAY, c)}
        | "limegreen"~(opt("->"~>color))                ^^ {case "limegreen"~None                   => LIMEGREEN
                                                            case "limegreen"~Some(c)                => RANGE(LIMEGREEN, c)}
        | "mediumseagreen"~(opt("->"~>color))           ^^ {case "mediumseagreen"~None              => MEDIUMSEAGREEN
                                                            case "mediumseagreen"~Some(c)           => RANGE(MEDIUMSEAGREEN, c)}
        | "turquoise"~(opt("->"~>color))                ^^ {case "turquoise"~None                   => TURQUOISE
                                                            case "turquoise"~Some(c)                => RANGE(TURQUOISE, c)}
        | "royalblue"~(opt("->"~>color))                ^^ {case "royalblue"~None                   => ROYALBLUE
                                                            case "royalblue"~Some(c)                => RANGE(ROYALBLUE, c)}
        | "steelblue"~(opt("->"~>color))                ^^ {case "steelblue"~None                   => STEELBLUE
                                                            case "steelblue"~Some(c)                => RANGE(STEELBLUE, c)}
        | "darkslateblue"~(opt("->"~>color))            ^^ {case "darkslateblue"~None               => DARKSLATEBLUE
                                                            case "darkslateblue"~Some(c)            => RANGE(DARKSLATEBLUE, c)}
        | "mediumturquoise"~(opt("->"~>color))          ^^ {case "mediumturquoise"~None             => MEDIUMTURQUOISE
                                                            case "mediumturquoise"~Some(c)          => RANGE(MEDIUMTURQUOISE, c)}
        | "indigo"~(opt("->"~>color))                   ^^ {case "indigo"~None                      => INDIGO
                                                            case "indigo"~Some(c)                   => RANGE(INDIGO, c)}
        | "darkolivegreen"~(opt("->"~>color))           ^^ {case "darkolivegreen"~None              => DARKOLIVEGREEN
                                                            case "darkolivegreen"~Some(c)           => RANGE(DARKOLIVEGREEN, c)}
        | "cadetblue"~(opt("->"~>color))                ^^ {case "cadetblue"~None                   => CADETBLUE
                                                            case "cadetblue"~Some(c)                => RANGE(CADETBLUE, c)}
        | "cornflowerblue"~(opt("->"~>color))           ^^ {case "cornflowerblue"~None              => CORNFLOWERBLUE
                                                            case "cornflowerblue"~Some(c)           => RANGE(CORNFLOWERBLUE, c)}
        | "mediumaquamarine"~(opt("->"~>color))         ^^ {case "mediumaquamarine"~None            => MEDIUMAQUAMARINE
                                                            case "mediumaquamarine"~Some(c)         => RANGE(MEDIUMAQUAMARINE, c)}
        | "dimgray"~(opt("->"~>color))                  ^^ {case "dimgray"~None                     => DIMGRAY
                                                            case "dimgray"~Some(c)                  => RANGE(DIMGRAY, c)}
        | "slateblue"~(opt("->"~>color))                ^^ {case "slateblue"~None                   => SLATEBLUE
                                                            case "slateblue"~Some(c)                => RANGE(SLATEBLUE, c)}
        | "olivedrab"~(opt("->"~>color))                ^^ {case "olivedrab"~None                   => OLIVEDRAB
                                                            case "olivedrab"~Some(c)                => RANGE(OLIVEDRAB, c)}
        | "slategray"~(opt("->"~>color))                ^^ {case "slategray"~None                   => SLATEGRAY
                                                            case "slategray"~Some(c)                => RANGE(SLATEGRAY, c)}
        | "lightslategray"~(opt("->"~>color))           ^^ {case "lightslategray"~None              => LIGHTSLATEGRAY
                                                            case "lightslategray"~Some(c)           => RANGE(LIGHTSLATEGRAY, c)}
        | "mediumslateblue"~(opt("->"~>color))          ^^ {case "mediumslateblue"~None             => MEDIUMSLATEBLUE
                                                            case "mediumslateblue"~Some(c)          => RANGE(MEDIUMSLATEBLUE, c)}
        | "lawngreen"~(opt("->"~>color))                ^^ {case "lawngreen"~None                   => LAWNGREEN
                                                            case "lawngreen"~Some(c)                => RANGE(LAWNGREEN, c)}
        | "chartreuse"~(opt("->"~>color))               ^^ {case "chartreuse"~None                  => CHARTREUSE
                                                            case "chartreuse"~Some(c)               => RANGE(CHARTREUSE, c)}
        | "aquamarine"~(opt("->"~>color))               ^^ {case "aquamarine"~None                  => AQUAMARINE
                                                            case "aquamarine"~Some(c)               => RANGE(AQUAMARINE, c)}
        | "maroon"~(opt("->"~>color))                   ^^ {case "maroon"~None                      => MAROON
                                                            case "maroon"~Some(c)                   => RANGE(MAROON, c)}
        | "purple"~(opt("->"~>color))                   ^^ {case "purple"~None                      => PURPLE
                                                            case "purple"~Some(c)                   => RANGE(PURPLE, c)}
        | "olive"~(opt("->"~>color))                    ^^ {case "olive"~None                       => OLIVE
                                                            case "olive"~Some(c)                    => RANGE(OLIVE, c)}
        | "gray"~(opt("->"~>color))                     ^^ {case "gray"~None                        => GRAY
                                                            case "gray"~Some(c)                     => RANGE(GRAY, c)}
        | "skyblue"~(opt("->"~>color))                  ^^ {case "skyblue"~None                     => SKYBLUE
                                                            case "skyblue"~Some(c)                  => RANGE(SKYBLUE, c)}
        | "lightskyblue"~(opt("->"~>color))             ^^ {case "lightskyblue"~None                => LIGHTSKYBLUE
                                                            case "lightskyblue"~Some(c)             => RANGE(LIGHTSKYBLUE, c)}
        | "blueviolet"~(opt("->"~>color))               ^^ {case "blueviolet"~None                  => BLUEVIOLET
                                                            case "blueviolet"~Some(c)               => RANGE(BLUEVIOLET, c)}
        | "darkred"~(opt("->"~>color))                  ^^ {case "darkred"~None                     => DARKRED
                                                            case "darkred"~Some(c)                  => RANGE(DARKRED, c)}
        | "darkmagenta"~(opt("->"~>color))              ^^ {case "darkmagenta"~None                 => DARKMAGENTA
                                                            case "darkmagenta"~Some(c)              => RANGE(DARKMAGENTA, c)}
        | "saddlebrown"~(opt("->"~>color))              ^^ {case "saddlebrown"~None                 => SADDLEBROWN
                                                            case "saddlebrown"~Some(c)              => RANGE(SADDLEBROWN, c)}
        | "darkseagreen"~(opt("->"~>color))             ^^ {case "darkseagreen"~None                => DARKSEAGREEN
                                                            case "darkseagreen"~Some(c)             => RANGE(DARKSEAGREEN, c)}
        | "lightgreen"~(opt("->"~>color))               ^^ {case "lightgreen"~None                  => LIGHTGREEN
                                                            case "lightgreen"~Some(c)               => RANGE(LIGHTGREEN, c)}
        | "mediumpurple"~(opt("->"~>color))             ^^ {case "mediumpurple"~None                => MEDIUMPURPLE
                                                            case "mediumpurple"~Some(c)             => RANGE(MEDIUMPURPLE, c)}
        | "darkviolet"~(opt("->"~>color))               ^^ {case "darkviolet"~None                  => DARKVIOLET
                                                            case "darkviolet"~Some(c)               => RANGE(DARKVIOLET, c)}
        | "palegreen"~(opt("->"~>color))                ^^ {case "palegreen"~None                   => PALEGREEN
                                                            case "palegreen"~Some(c)                => RANGE(PALEGREEN, c)}
        | "darkorchid"~(opt("->"~>color))               ^^ {case "darkorchid"~None                  => DARKORCHID
                                                            case "darkorchid"~Some(c)               => RANGE(DARKORCHID, c)}
        | "yellowgreen"~(opt("->"~>color))              ^^ {case "yellowgreen"~None                 => YELLOWGREEN
                                                            case "yellowgreen"~Some(c)              => RANGE(YELLOWGREEN, c)}
        | "sienna"~(opt("->"~>color))                   ^^ {case "sienna"~None                      => SIENNA
                                                            case "sienna"~Some(c)                   => RANGE(SIENNA, c)}
        | "brown"~(opt("->"~>color))                    ^^ {case "brown"~None                       => BROWN
                                                            case "brown"~Some(c)                    => RANGE(BROWN, c)}
        | "darkgray"~(opt("->"~>color))                 ^^ {case "darkgray"~None                    => DARKGRAY
                                                            case "darkgray"~Some(c)                 => RANGE(DARKGRAY, c)}
        | "lightblue"~(opt("->"~>color))                ^^ {case "lightblue"~None                   => LIGHTBLUE
                                                            case "lightblue"~Some(c)                => RANGE(LIGHTBLUE, c)}
        | "greenyellow"~(opt("->"~>color))              ^^ {case "greenyellow"~None                 => GREENYELLOW
                                                            case "greenyellow"~Some(c)              => RANGE(GREENYELLOW, c)}
        | "paleturquoise"~(opt("->"~>color))            ^^ {case "paleturquoise"~None               => PALETURQUOISE
                                                            case "paleturquoise"~Some(c)            => RANGE(PALETURQUOISE, c)}
        | "lightsteelblue"~(opt("->"~>color))           ^^ {case "lightsteelblue"~None              => LIGHTSTEELBLUE
                                                            case "lightsteelblue"~Some(c)           => RANGE(LIGHTSTEELBLUE, c)}
        | "powderblue"~(opt("->"~>color))               ^^ {case "powderblue"~None                  => POWDERBLUE
                                                            case "powderblue"~Some(c)               => RANGE(POWDERBLUE, c)}
        | "firebrick"~(opt("->"~>color))                ^^ {case "firebrick"~None                   => FIREBRICK
                                                            case "firebrick"~Some(c)                => RANGE(FIREBRICK, c)}
        | "darkgoldenrod"~(opt("->"~>color))            ^^ {case "darkgoldenrod"~None               => DARKGOLDENROD
                                                            case "darkgoldenrod"~Some(c)            => RANGE(DARKGOLDENROD, c)}
        | "mediumorchid"~(opt("->"~>color))             ^^ {case "mediumorchid"~None                => MEDIUMORCHID
                                                            case "mediumorchid"~Some(c)             => RANGE(MEDIUMORCHID, c)}
        | "rosybrown"~(opt("->"~>color))                ^^ {case "rosybrown"~None                   => ROSYBROWN
                                                            case "rosybrown"~Some(c)                => RANGE(ROSYBROWN, c)}
        | "darkkhaki"~(opt("->"~>color))                ^^ {case "darkkhaki"~None                   => DARKKHAKI
                                                            case "darkkhaki"~Some(c)                => RANGE(DARKKHAKI, c)}
        | "silver"~(opt("->"~>color))                   ^^ {case "silver"~None                      => SILVER
                                                            case "silver"~Some(c)                   => RANGE(SILVER, c)}
        | "mediumvioletred"~(opt("->"~>color))          ^^ {case "mediumvioletred"~None             => MEDIUMVIOLETRED
                                                            case "mediumvioletred"~Some(c)          => RANGE(MEDIUMVIOLETRED, c)}
        | "indianred"~(opt("->"~>color))                ^^ {case "indianred"~None                   => INDIANRED
                                                            case "indianred"~Some(c)                => RANGE(INDIANRED, c)}
        | "peru"~(opt("->"~>color))                     ^^ {case "peru"~None                        => PERU
                                                            case "peru"~Some(c)                     => RANGE(PERU, c)}
        | "chocolate"~(opt("->"~>color))                ^^ {case "chocolate"~None                   => CHOCOLATE
                                                            case "chocolate"~Some(c)                => RANGE(CHOCOLATE, c)}
        | "tan"~(opt("->"~>color))                      ^^ {case "tan"~None                         => TAN
                                                            case "tan"~Some(c)                      => RANGE(TAN, c)}
        | "lightgray"~(opt("->"~>color))                ^^ {case "lightgray"~None                   => LIGHTGRAY
                                                            case "lightgray"~Some(c)                => RANGE(LIGHTGRAY, c)}
        | "thistle"~(opt("->"~>color))                  ^^ {case "thistle"~None                     => THISTLE
                                                            case "thistle"~Some(c)                  => RANGE(THISTLE, c)}
        | "orchid"~(opt("->"~>color))                   ^^ {case "orchid"~None                      => ORCHID
                                                            case "orchid"~Some(c)                   => RANGE(ORCHID, c)}
        | "goldenrod"~(opt("->"~>color))                ^^ {case "goldenrod"~None                   => GOLDENROD
                                                            case "goldenrod"~Some(c)                => RANGE(GOLDENROD, c)}
        | "palevioletred"~(opt("->"~>color))            ^^ {case "palevioletred"~None               => PALEVIOLETRED
                                                            case "palevioletred"~Some(c)            => RANGE(PALEVIOLETRED, c)}
        | "crimson"~(opt("->"~>color))                  ^^ {case "crimson"~None                     => CRIMSON
                                                            case "crimson"~Some(c)                  => RANGE(CRIMSON, c)}
        | "gainsboro"~(opt("->"~>color))                ^^ {case "gainsboro"~None                   => GAINSBORO
                                                            case "gainsboro"~Some(c)                => RANGE(GAINSBORO, c)}
        | "plum"~(opt("->"~>color))                     ^^ {case "plum"~None                        => PLUM
                                                            case "plum"~Some(c)                     => RANGE(PLUM, c)}
        | "burlywood"~(opt("->"~>color))                ^^ {case "burlywood"~None                   => BURLYWOOD
                                                            case "burlywood"~Some(c)                => RANGE(BURLYWOOD, c)}
        | "lightcyan"~(opt("->"~>color))                ^^ {case "lightcyan"~None                   => LIGHTCYAN
                                                            case "lightcyan"~Some(c)                => RANGE(LIGHTCYAN, c)}
        | "lavender"~(opt("->"~>color))                 ^^ {case "lavender"~None                    => LAVENDER
                                                            case "lavender"~Some(c)                 => RANGE(LAVENDER, c)}
        | "darksalmon"~(opt("->"~>color))               ^^ {case "darksalmon"~None                  => DARKSALMON
                                                            case "darksalmon"~Some(c)               => RANGE(DARKSALMON, c)}
        | "violet"~(opt("->"~>color))                   ^^ {case "violet"~None                      => VIOLET
                                                            case "violet"~Some(c)                   => RANGE(VIOLET, c)}
        | "palegoldenrod"~(opt("->"~>color))            ^^ {case "palegoldenrod"~None               => PALEGOLDENROD
                                                            case "palegoldenrod"~Some(c)            => RANGE(PALEGOLDENROD, c)}
        | "lightcoral"~(opt("->"~>color))               ^^ {case "lightcoral"~None                  => LIGHTCORAL
                                                            case "lightcoral"~Some(c)               => RANGE(LIGHTCORAL, c)}
        | "khaki"~(opt("->"~>color))                    ^^ {case "khaki"~None                       => KHAKI
                                                            case "khaki"~Some(c)                    => RANGE(KHAKI, c)}
        | "aliceblue"~(opt("->"~>color))                ^^ {case "aliceblue"~None                   => ALICEBLUE
                                                            case "aliceblue"~Some(c)                => RANGE(ALICEBLUE, c)}
        | "honeydew"~(opt("->"~>color))                 ^^ {case "honeydew"~None                    => HONEYDEW
                                                            case "honeydew"~Some(c)                 => RANGE(HONEYDEW, c)}
        | "azure"~(opt("->"~>color))                    ^^ {case "azure"~None                       => AZURE
                                                            case "azure"~Some(c)                    => RANGE(AZURE, c)}
        | "sandybrown"~(opt("->"~>color))               ^^ {case "sandybrown"~None                  => SANDYBROWN
                                                            case "sandybrown"~Some(c)               => RANGE(SANDYBROWN, c)}
        | "wheat"~(opt("->"~>color))                    ^^ {case "wheat"~None                       => WHEAT
                                                            case "wheat"~Some(c)                    => RANGE(WHEAT, c)}
        | "beige"~(opt("->"~>color))                    ^^ {case "beige"~None                       => BEIGE
                                                            case "beige"~Some(c)                    => RANGE(BEIGE, c)}
        | "whitesmoke"~(opt("->"~>color))               ^^ {case "whitesmoke"~None                  => WHITESMOKE
                                                            case "whitesmoke"~Some(c)               => RANGE(WHITESMOKE, c)}
        | "mintcream"~(opt("->"~>color))                ^^ {case "mintcream"~None                   => MINTCREAM
                                                            case "mintcream"~Some(c)                => RANGE(MINTCREAM, c)}
        | "ghostwhite"~(opt("->"~>color))               ^^ {case "ghostwhite"~None                  => GHOSTWHITE
                                                            case "ghostwhite"~Some(c)               => RANGE(GHOSTWHITE, c)}
        | "salmon"~(opt("->"~>color))                   ^^ {case "salmon"~None                      => SALMON
                                                            case "salmon"~Some(c)                   => RANGE(SALMON, c)}
        | "antiquewhite"~(opt("->"~>color))             ^^ {case "antiquewhite"~None                => ANTIQUEWHITE
                                                            case "antiquewhite"~Some(c)             => RANGE(ANTIQUEWHITE, c)}
        | "linen"~(opt("->"~>color))                    ^^ {case "linen"~None                       => LINEN
                                                            case "linen"~Some(c)                    => RANGE(LINEN, c)}
        | "lightgoldenrodyellow"~(opt("->"~>color))     ^^ {case "lightgoldenrodyellow"~None        => LIGHTGOLDENRODYELLOW
                                                            case "lightgoldenrodyellow"~Some(c)     => RANGE(LIGHTGOLDENRODYELLOW, c)}
        | "oldlace"~(opt("->"~>color))                  ^^ {case "oldlace"~None                     => OLDLACE
                                                            case "oldlace"~Some(c)                  => RANGE(OLDLACE, c)}
        | "red"~(opt("->"~>color))                      ^^ {case "red"~None                         => RED
                                                            case "red"~Some(c)                      => RANGE(RED, c)}
        | "fuchsia"~(opt("->"~>color))                  ^^ {case "fuchsia"~None                     => FUCHSIA
                                                            case "fuchsia"~Some(c)                  => RANGE(FUCHSIA, c)}
        | "magenta"~(opt("->"~>color))                  ^^ {case "magenta"~None                     => MAGENTA
                                                            case "magenta"~Some(c)                  => RANGE(MAGENTA, c)}
        | "deeppink"~(opt("->"~>color))                 ^^ {case "deeppink"~None                    => DEEPPINK
                                                            case "deeppink"~Some(c)                 => RANGE(DEEPPINK, c)}
        | "orangered"~(opt("->"~>color))                ^^ {case "orangered"~None                   => ORANGERED
                                                            case "orangered"~Some(c)                => RANGE(ORANGERED, c)}
        | "tomato"~(opt("->"~>color))                   ^^ {case "tomato"~None                      => TOMATO
                                                            case "tomato"~Some(c)                   => RANGE(TOMATO, c)}
        | "hotpink"~(opt("->"~>color))                  ^^ {case "hotpink"~None                     => HOTPINK
                                                            case "hotpink"~Some(c)                  => RANGE(HOTPINK, c)}
        | "coral"~(opt("->"~>color))                    ^^ {case "coral"~None                       => CORAL
                                                            case "coral"~Some(c)                    => RANGE(CORAL, c)}
        | "darkorange"~(opt("->"~>color))               ^^ {case "darkorange"~None                  => DARKORANGE
                                                            case "darkorange"~Some(c)               => RANGE(DARKORANGE, c)}
        | "lightsalmon"~(opt("->"~>color))              ^^ {case "lightsalmon"~None                 => LIGHTSALMON
                                                            case "lightsalmon"~Some(c)              => RANGE(LIGHTSALMON, c)}
        | "orange"~(opt("->"~>color))                   ^^ {case "orange"~None                      => ORANGE
                                                            case "orange"~Some(c)                   => RANGE(ORANGE, c)}
        | "lightpink"~(opt("->"~>color))                ^^ {case "lightpink"~None                   => LIGHTPINK
                                                            case "lightpink"~Some(c)                => RANGE(LIGHTPINK, c)}
        | "pink"~(opt("->"~>color))                     ^^ {case "pink"~None                        => PINK
                                                            case "pink"~Some(c)                     => RANGE(PINK, c)}
        | "gold"~(opt("->"~>color))                     ^^ {case "gold"~None                        => GOLD
                                                            case "gold"~Some(c)                     => RANGE(GOLD, c)}
        | "peachpuff"~(opt("->"~>color))                ^^ {case "peachpuff"~None                   => PEACHPUFF
                                                            case "peachpuff"~Some(c)                => RANGE(PEACHPUFF, c)}
        | "navajowhite"~(opt("->"~>color))              ^^ {case "navajowhite"~None                 => NAVAJOWHITE
                                                            case "navajowhite"~Some(c)              => RANGE(NAVAJOWHITE, c)}
        | "moccasin"~(opt("->"~>color))                 ^^ {case "moccasin"~None                    => MOCCASIN
                                                            case "moccasin"~Some(c)                 => RANGE(MOCCASIN, c)}
        | "bisque"~(opt("->"~>color))                   ^^ {case "bisque"~None                      => BISQUE
                                                            case "bisque"~Some(c)                   => RANGE(BISQUE, c)}
        | "mistyrose"~(opt("->"~>color))                ^^ {case "mistyrose"~None                   => MISTYROSE
                                                            case "mistyrose"~Some(c)                => RANGE(MISTYROSE, c)}
        | "blanchedalmond"~(opt("->"~>color))           ^^ {case "blanchedalmond"~None              => BLANCHEDALMOND
                                                            case "blanchedalmond"~Some(c)           => RANGE(BLANCHEDALMOND, c)}
        | "papayawhip"~(opt("->"~>color))               ^^ {case "papayawhip"~None                  => PAPAYAWHIP
                                                            case "papayawhip"~Some(c)               => RANGE(PAPAYAWHIP, c)}
        | "lavenderblush"~(opt("->"~>color))            ^^ {case "lavenderblush"~None               => LAVENDERBLUSH
                                                            case "lavenderblush"~Some(c)            => RANGE(LAVENDERBLUSH, c)}
        | "seashell"~(opt("->"~>color))                 ^^ {case "seashell"~None                    => SEASHELL
                                                            case "seashell"~Some(c)                 => RANGE(SEASHELL, c)}
        | "cornsilk"~(opt("->"~>color))                 ^^ {case "cornsilk"~None                    => CORNSILK
                                                            case "cornsilk"~Some(c)                 => RANGE(CORNSILK, c)}
        | "lemonchiffon"~(opt("->"~>color))             ^^ {case "lemonchiffon"~None                => LEMONCHIFFON
                                                            case "lemonchiffon"~Some(c)             => RANGE(LEMONCHIFFON, c)}
        | "floralwhite"~(opt("->"~>color))              ^^ {case "floralwhite"~None                 => FLORALWHITE
                                                            case "floralwhite"~Some(c)              => RANGE(FLORALWHITE, c)}
        | "snow"~(opt("->"~>color))                     ^^ {case "snow"~None                        => SNOW
                                                            case "snow"~Some(c)                     => RANGE(SNOW, c)}
        | "yellow"~(opt("->"~>color))                   ^^ {case "yellow"~None                      => YELLOW
                                                            case "yellow"~Some(c)                   => RANGE(YELLOW, c)}
        | "lightyellow"~(opt("->"~>color))              ^^ {case "lightyellow"~None                 => LIGHTYELLOW
                                                            case "lightyellow"~Some(c)              => RANGE(LIGHTYELLOW, c)}
        | "ivory"~(opt("->"~>color))                    ^^ {case "ivory"~None                       => IVORY
                                                            case "ivory"~Some(c)                    => RANGE(IVORY, c)}
        | "white"~(opt("->"~>color))                    ^^ {case "white"~None                       => WHITE
                                                            case "white"~Some(c)                    => RANGE(WHITE, c)}
        | "rgb"~number~number~number~(opt("->"~>color)) ^^ {case "rgb"~r~g~b~None                   => RGB(r, g, b)
                                                            case "rgb"~r~g~b~Some(c)                => RANGE(RGB(r, g, b), c)}
        | "rainbow"                                     ^^ {case "rainbow"                          => RAINBOW})

// make setColor not strip color
    lazy val expr: PackratParser[Expr] = 
      (   "set color color"~"="~color~"time"~"="~duration     ^^ {case "set color color"~"="~c~"time"~"="~d     => StripColor(c, d)} 
        | "set color time"~"="~duration~"color"~"="~color     ^^ {case "set color time"~"="~d~"color"~"="~c     => StripColor(c, d)}
        | "cascade color"~"="~color~"time"~"="~duration       ^^ {case "cascade color"~"="~c~"time"~"="~d       => Cascade(c, d)}
        | "cascade time"~"="~duration~"color"~"="~color       ^^ {case "cascade time"~"="~d~"color"~"="~c       => Cascade(c, d)}
        | "cylon color"~"="~color~"time"~"="~duration         ^^ {case "cylon color"~"="~c~"time"~"="~d         => Cylon(c, d)}
        | "cylon time"~"="~duration~"color"~"="~color         ^^ {case "cylon time"~"="~d~"color"~"="~c         => Cylon(c, d)}
        | "rainbow time"~"="~duration                         ^^ {case "rainbow time"~"="~d                     => RainbowEffect(d)}
        | name~(opt("times"~>"="~>number))                      ^^ {case n~None                                     => CustomEffect(n, 1)
                                                                    case n~Some(nu)                                 => CustomEffect(n, nu)})

    // does this just consume our desired string or all the tokens in the world
    def name: Parser[String] =  """[a-zA-Z]+""".r ^^ { _.toString }

    // does this just consume our desired integer or all the tokens in the world
    def number: Parser[Integer] = wholeNumber ^^ {s ⇒ s.toInt}    

    // does this just consume our desired integer or all the tokens in the world
    def duration: Parser[Float] = floatingPointNumber ^^ {s ⇒ s.toFloat}    
}