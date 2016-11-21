package ledplusplus

import ledplusplus.absyn._


////////////////////// THIS ISN'T RIGHT //////////////////////
package object semantics {
    var initCode = "#include <Adafruit_NeoPixel.h>\n"
    initCode += "#define TOP_DOWN 0\n"

    //////////////////////////////////////////////////////
    ////////// Include built in colors////////////////////
    //////////////////////////////////////////////////////

    initCode += "#define BLACK           0x000000\n"
    initCode += "#define NAVY            0x000080\n"
    initCode += "#define DARKBLUE        0x00008B\n"
    initCode += "#define MEDIUMBLUE      0x0000CD\n"
    initCode += "#define BLUE            0x0000FF\n"
    initCode += "#define DARKGREEN       0x006400\n"
    initCode += "#define GREEN           0x008000\n"
    initCode += "#define TEAL            0x008080\n"
    initCode += "#define DARKCYAN        0x008B8B\n"
    initCode += "#define DEEPSKYBLUE     0x00BFFF\n"
    initCode += "#define DARKTURQUOISE       0x00CED1\n"
    initCode += "#define MEDIUMSPRINGGREEN   0x00FA9A\n"
    initCode += "#define LIME            0x00FF00\n"
    initCode += "#define SPRINGGREEN     0x00FF7F\n"
    initCode += "#define AQUA            0x00FFFF\n"
    initCode += "#define CYAN            0x00FFFF\n"
    initCode += "#define MIDNIGHTBLUE        0x191970\n"
    initCode += "#define DODGERBLUE      0x1E90FF\n"
    initCode += "#define LIGHTSEAGREEN       0x20B2AA\n"
    initCode += "#define FORESTGREEN     0x228B22\n"
    initCode += "#define SEAGREEN        0x2E8B57\n"
    initCode += "#define DARKSLATEGRAY       0x2F4F4F\n"
    initCode += "#define LIMEGREEN       0x32CD32\n"
    initCode += "#define MEDIUMSEAGREEN      0x3CB371\n"
    initCode += "#define TURQUOISE       0x40E0D0\n"
    initCode += "#define ROYALBLUE       0x4169E1\n"
    initCode += "#define STEELBLUE       0x4682B4\n"
    initCode += "#define DARKSLATEBLUE       0x483D8B\n"
    initCode += "#define MEDIUMTURQUOISE     0x48D1CC\n"
    initCode += "#define INDIGO          0x4B0082\n"
    initCode += "#define DARKOLIVEGREEN      0x556B2F\n"
    initCode += "#define CADETBLUE       0x5F9EA0\n"
    initCode += "#define CORNFLOWERBLUE      0x6495ED\n"
    initCode += "#define MEDIUMAQUAMARINE    0x66CDAA\n"
    initCode += "#define DIMGRAY         0x696969\n"
    initCode += "#define SLATEBLUE       0x6A5ACD\n"
    initCode += "#define OLIVEDRAB       0x6B8E23\n"
    initCode += "#define SLATEGRAY       0x708090\n"
    initCode += "#define LIGHTSLATEGRAY      0x778899\n"
    initCode += "#define MEDIUMSLATEBLUE     0x7B68EE\n"
    initCode += "#define LAWNGREEN       0x7CFC00\n"
    initCode += "#define CHARTREUSE      0x7FFF00\n"
    initCode += "#define AQUAMARINE      0x7FFFD4\n"
    initCode += "#define MAROON          0x800000\n"
    initCode += "#define PURPLE          0x800080\n"
    initCode += "#define OLIVE           0x808000\n"
    initCode += "#define GRAY            0x808080\n"
    initCode += "#define SKYBLUE         0x87CEEB\n"
    initCode += "#define LIGHTSKYBLUE        0x87CEFA\n"
    initCode += "#define BLUEVIOLET      0x8A2BE2\n"
    initCode += "#define DARKRED         0x8B0000\n"
    initCode += "#define DARKMAGENTA     0x8B008B\n"
    initCode += "#define SADDLEBROWN     0x8B4513\n"
    initCode += "#define DARKSEAGREEN        0x8FBC8F\n"
    initCode += "#define LIGHTGREEN      0x90EE90\n"
    initCode += "#define MEDIUMPURPLE        0x9370DB\n"
    initCode += "#define DARKVIOLET      0x9400D3\n"
    initCode += "#define PALEGREEN       0x98FB98\n"
    initCode += "#define DARKORCHID      0x9932CC\n"
    initCode += "#define YELLOWGREEN     0x9ACD32\n"
    initCode += "#define SIENNA          0xA0522D\n"
    initCode += "#define BROWN           0xA52A2A\n"
    initCode += "#define DARKGRAY        0xA9A9A9\n"
    initCode += "#define LIGHTBLUE       0xADD8E6\n"
    initCode += "#define GREENYELLOW     0xADFF2F\n"
    initCode += "#define PALETURQUOISE           0xAFEEEE\n"
    initCode += "#define LIGHTSTEELBLUE      0xB0C4DE\n"
    initCode += "#define POWDERBLUE      0xB0E0E6\n"
    initCode += "#define FIREBRICK       0xB22222\n"
    initCode += "#define DARKGOLDENROD       0xB8860B\n"
    initCode += "#define MEDIUMORCHID        0xBA55D3\n"
    initCode += "#define ROSYBROWN       0xBC8F8F\n"
    initCode += "#define DARKKHAKI       0xBDB76B\n"
    initCode += "#define SILVER          0xC0C0C0\n"
    initCode += "#define MEDIUMVIOLETRED         0xC71585\n"
    initCode += "#define INDIANRED       0xCD5C5C\n"
    initCode += "#define PERU            0xCD853F\n"
    initCode += "#define CHOCOLATE       0xD2691E\n"
    initCode += "#define TAN         0xD2B48C\n"
    initCode += "#define LIGHTGRAY       0xD3D3D3\n"
    initCode += "#define THISTLE         0xD8BFD8\n"
    initCode += "#define ORCHID          0xDA70D6\n"
    initCode += "#define GOLDENROD       0xDAA520\n"
    initCode += "#define PALEVIOLETRED       0xDB7093\n"
    initCode += "#define CRIMSON         0xDC143C\n"
    initCode += "#define GAINSBORO       0xDCDCDC\n"
    initCode += "#define PLUM            0xDDA0DD\n"
    initCode += "#define BURLYWOOD       0xDEB887\n"
    initCode += "#define LIGHTCYAN       0xE0FFFF\n"
    initCode += "#define LAVENDER        0xE6E6FA\n"
    initCode += "#define DARKSALMON      0xE9967A\n"
    initCode += "#define VIOLET          0xEE82EE\n"
    initCode += "#define PALEGOLDENROD       0xEEE8AA\n"
    initCode += "#define LIGHTCORAL      0xF08080\n"
    initCode += "#define KHAKI           0xF0E68C\n"
    initCode += "#define ALICEBLUE       0xF0F8FF\n"
    initCode += "#define HONEYDEW        0xF0FFF0\n"
    initCode += "#define AZURE           0xF0FFFF\n"
    initCode += "#define SANDYBROWN      0xF4A460\n"
    initCode += "#define WHEAT           0xF5DEB3\n"
    initCode += "#define BEIGE           0xF5F5DC\n"
    initCode += "#define WHITESMOKE      0xF5F5F5\n"
    initCode += "#define MINTCREAM       0xF5FFFA\n"
    initCode += "#define GHOSTWHITE      0xF8F8FF\n"
    initCode += "#define SALMON          0xFA8072\n"
    initCode += "#define ANTIQUEWHITE        0xFAEBD7\n"
    initCode += "#define LINEN           0xFAF0E6\n"
    initCode += "#define LIGHTGOLDENRODYELLOW    0xFAFAD2\n"
    initCode += "#define OLDLACE         0xFDF5E6\n"
    initCode += "#define RED         0xFF0000\n"
    initCode += "#define FUCHSIA         0xFF00FF\n"
    initCode += "#define MAGENTA         0xFF00FF\n"
    initCode += "#define DEEPPINK        0xFF1493\n"
    initCode += "#define ORANGERED       0xFF4500\n"
    initCode += "#define TOMATO          0xFF6347\n"
    initCode += "#define HOTPINK         0xFF69B4\n"
    initCode += "#define CORAL           0xFF7F50\n"
    initCode += "#define DARKORANGE      0xFF8C00\n"
    initCode += "#define LIGHTSALMON     0xFFA07A\n"
    initCode += "#define ORANGE          0xFFA500\n"
    initCode += "#define LIGHTPINK       0xFFB6C1\n"
    initCode += "#define PINK            0xFFC0CB\n"
    initCode += "#define GOLD            0xFFD700\n"
    initCode += "#define PEACHPUFF       0xFFDAB9\n"
    initCode += "#define NAVAJOWHITE     0xFFDEAD\n"
    initCode += "#define MOCCASIN        0xFFE4B5\n"
    initCode += "#define BISQUE          0xFFE4C4\n"
    initCode += "#define MISTYROSE       0xFFE4E1\n"
    initCode += "#define BLANCHEDALMOND      0xFFEBCD\n"
    initCode += "#define PAPAYAWHIP      0xFFEFD5\n"
    initCode += "#define LAVENDERBLUSH       0xFFF0F5\n"
    initCode += "#define SEASHELL        0xFFF5EE\n"
    initCode += "#define CORNSILK        0xFFF8DC\n"
    initCode += "#define LEMONCHIFFON        0xFFFACD\n"
    initCode += "#define FLORALWHITE     0xFFFAF0\n"
    initCode += "#define SNOW            0xFFFAFA\n"
    initCode += "#define YELLOW          0xFFFF00\n"
    initCode += "#define LIGHTYELLOW     0xFFFFE0\n"
    initCode += "#define IVORY           0xFFFFF0\n"
    initCode += "#define WHITE           0xFFFFFF\n"


    //////////////////////////////////////////////////////
    ////////  Include code for base features  ////////////
    ////////     and Default pin/led values   ////////////
    //////////////////////////////////////////////////////
    initCode += "\n"
    initCode += "\n"
    initCode += "\n"
    // initCode += "#define PIN 4\n"
    // initCode += "#define LED_COUNT 12\n"
    // initCode += "\n"
    // initCode += "// Create an instance of the Adafruit_NeoPixel class called \"leds\".\n"
    // initCode += "// That'll be what we refer to from here on...\n"
    // initCode += "Adafruit_NeoPixel leds = Adafruit_NeoPixel(LED_COUNT, PIN, NEO_GRB + NEO_KHZ800);\n"
    // initCode += "\n"

    //////////////////////////////////////////////////////
    //////////  Include Arduino Setup code  //////////////
    //////////////////////////////////////////////////////

    // initCode += "void setup()\n"
    // initCode += "{\n"
    // initCode += "\tleds.begin();  // Call this to start up the LED strip.\n"
    // initCode += "\tclearLEDs();   // This function, defined below, turns all LEDs off...\n"
    // initCode += "\tleds.show();   // ...but the LEDs don't actually update until you call this.\n"
    // initCode += "}\n"
    // initCode += "\n"
    
    //////////////////////////////////////////////////////
    //////////////  The Set Color method /////////////////
    //////////////////////////////////////////////////////
    // initCode += "void setColor(int color, int duration){\n"
    // initCode += "\tbyte red = (color & 0xFF0000) >> 16;\n"
    // initCode += "\tbyte green = (color & 0x00FF00) >> 8;\n"
    // initCode += "\tbyte blue = (color & 0x0000FF);\n"
    // initCode += "\n"
    // initCode += "\tfor(int i=0; i<LED_COUNT; i++){\n"
    // initCode += "\t\tleds.setPixelColor(i, red, green, blue);\n"
    // initCode += "\t}\n"
    // initCode += "\tleds.show();\n"
    // initCode += "\tdelay(duration*1000);\n"
    // initCode += "}\n"
    // initCode += "\n"

    // ////////////////////////////////////////////////////////
    // ////////////////   Clear LEDs method   /////////////////
    // ////////////////////////////////////////////////////////

    // initCode += "void clearLEDs()\n"
    // initCode += "{\n"
    // initCode += "\tfor (int i=0; i<LED_COUNT; i++)\n"
    // initCode += "\t{\n"
    // initCode += "\t\tleds.setPixelColor(i, 0);\n"
    // initCode += "\t}\n"
    // initCode += "}\n"

    initCode += "\n"
    initCode += "\n"
    initCode += "\n"
    initCode += "\n"
    initCode += "//-------------------------------------------\n"
    initCode += "//-------- BEGIN USER GENERATED CODE --------\n"
    initCode += "//-------------------------------------------\n"
    initCode += "\n"
    initCode += "\n"
    initCode += "\n"



    def evalProgram(program: Prgm): String = program match {
        case Program(body)      => initCode + evalStmts(body)
        case default            => "//program Default//"
    }
    def evalStmts (stmts: List[Stmt]): String = {
        if (stmts.isEmpty){
            ""
        }
        else{
            evalStmt(stmts.head) + evalStmts(stmts.tail)
        }
    }
    // base code needs to have expr features build in

    def evalStmt (stmt: Stmt): String = stmt match {
        case Effect(name, body)              => voidFuncHeader(name) + evalExprs(body) + "}\n"
        case Main(body)                      => loopFuncHeader() + evalExprs(body) + "}\n"
        case LedCount(count)                 => "#define LED_COUNT " + count + "\n" + declareLeds() + declareSetup() + declareHelperFuncs()
        case LedPin(pin)                     => "#define PIN " + pin + "\n"
        case default                         => "//Stmt default//"
    }

    def declareLeds() = 
         "Adafruit_NeoPixel leds = Adafruit_NeoPixel(LED_COUNT, PIN, NEO_GRB + NEO_KHZ800);\n\n"

    def declareSetup() = 
          "void setup()\n" + 
          "{\n" +
          "\tleds.begin();  // Call this to start up the LED strip.\n" +
          "\tclearLEDs();   // This function, defined below, turns all LEDs off...\n" +
          "\tleds.brightness(20);"
          "\tleds.show();   // ...but the LEDs don't actually update until you call this.\n" +
          "}\n" +
          "\n" 

    def declareHelperFuncs() = 
        //////////////////////////////////////////// +
        ////   SET COLOR  method   ///////////////// +
        //////////////////////////////////////////// +    
        "void setColor(int color, int duration){\n" +
        "\tbyte red = (color & 0xFF0000) >> 16;\n" +
        "\tbyte green = (color & 0x00FF00) >> 8;\n" +
        "\tbyte blue = (color & 0x0000FF);\n" +
        "\n" +
        "\tfor(int i=0; i<LED_COUNT; i++){\n" +
        "\t\tleds.setPixelColor(i, red, green, blue);\n" +
        "\t}\n" +
        "\tleds.show();\n" +
        "\tdelay(duration*1000);\n" +
        "}\n" +
        "\n" +
        //////////////////////////////////////////// +
        ////   Clear LEDs method   ///////////////// +
        //////////////////////////////////////////// +
        "void clearLEDs()\n" +
        "{\n" +
        "\tfor (int i=0; i<LED_COUNT; i++)\n" +
        "\t{\n" +
        "\t\tleds.setPixelColor(i, 0);\n" +
        "\t}\n" +
        "}\n" +
        //////////////////////////////////////////// +
        ////  Rainbow LED method   ///////////////// +
        //////////////////////////////////////////// +
        "uint32_t rainbowColor(byte position)\n"+
        "{\n"+
        "\t// 6 total zones of color change:\n"+
        "\tif (position < 31)  // Red -> Yellow (Red = FF, blue = 0, green goes 00-FF)\n"+
        "\t{\n"+
        "\t\treturn leds.Color(0xFF, position * 8, 0);\n"+
        "\t}\n"+
        "\telse if (position < 63)  // Yellow -> Green (Green = FF, blue = 0, red goes FF->00)\n"+
        "\t{\n"+
        "\t\tposition -= 31;\n"+
        "\t\treturn leds.Color(0xFF - position * 8, 0xFF, 0);\n"+
        "\t}\n"+
        "\telse if (position < 95)  // Green->Aqua (Green = FF, red = 0, blue goes 00->FF)\n"+
        "\t{\n"+
        "\t\tposition -= 63;\n"+
        "\t\treturn leds.Color(0, 0xFF, position * 8);\n"+
        "\t}\n"+
        "\telse if (position < 127)  // Aqua->Blue (Blue = FF, red = 0, green goes FF->00)\n"+
        "\t{\n"+
        "\t\tposition -= 95;\n"+
        "\t\treturn leds.Color(0, 0xFF - position * 8, 0xFF);\n"+
        "\t}\n"+
        "\telse if (position < 159)  // Blue->Fuchsia (Blue = FF, green = 0, red goes 00->FF)\n"+
        "\t{\n"+
        "\t\tposition -= 127;\n"+
        "\t\treturn leds.Color(position * 8, 0, 0xFF);\n"+
        "\t}\n"+
        "\telse  //160 <position< 191   Fuchsia->Red (Red = FF, green = 0, blue goes FF->00)\n"+
        "\t{\n"+
        "\t\tposition -= 159;\n"+
        "\t\treturn leds.Color(0xFF, 0x00, 0xFF - position * 8);\n"+
        "\t}\n"+
        "}\n"+
        "\n"+
        "void rainbow(int duration){\n"+
        "\tint delayVal = 50;\n"+
        "\tfloat timeScale = duration*1000.0/(LED_COUNT*delayVal);\n"+
        "\tint iterCount = (int)(LED_COUNT * timeScale);\n"+
        "\t//float rainbowScale = 192 / LED_COUNT;\n"+
        "\t\n"+
        "\tfor (int i = 0; i < LED_COUNT; i++){\n"+
        "\t\tleds.setPixelColor( i % LED_COUNT, rainbowColor(i % LED_COUNT));\n"+
        "\t}\n"+
        "\tleds.show();\n"+
        "\tdelay(duration*1000); \n"+
        "}\n"+
        "\n"

    def voidFuncHeader(name: String) = 
        "void " + name + "() {\n"

    def loopFuncHeader() = 
        "void loop() {\n"

    def evalExprs(exprs: List[Expr]): String = {
        if (exprs.isEmpty){
            ""
        }
        else {
            evalExpr(exprs.head) + evalExprs(exprs.tail)
        }
    }

    def evalExpr(expr: Expr): String = expr match {
        case StripColor(col, dur)   => "\tsetColor(" + evalColor(col) + ", " + dur + ");\n"
        case CustomEffect(name)     => "\t" + name + "();\n"
        case Cascade(col, dur)      => "\tcascade(" + evalColor(col) + ", " + dur + ");\n"
        case Wave(col, dur)         => "\twave(" + evalColor(col) + ", " + dur + ");\n"
        case Cylon(col, dur)        => "\tcylon(" + evalColor(col) + ", " + dur + ");\n"
        case Rainbow(dur)           => "\trainbow(" + dur + ");\n"
        case default                     => "//Expr default//"
    }

    def evalColor(col: Color): String = col match {
        case RED        => "RED"
        case BLUE       => "BLUE"
        case GREEN      => "GREEN"
        case ORANGE     => "ORANGE"
        case INDIGO     => "INDIGO"
        case PINK       => "PINK"
        case RGB(r,g,b) => evalRGB(r, g, b)
        case default    => "// default //"
        //case RAINBOW    => "RAINBOW"
    }

    def evalRGB(red: Integer, green: Integer, blue: Integer): String = {
        val redHex = Integer.toHexString(red)
        val greenHex = Integer.toHexString(green)
        val blueHex = Integer.toHexString(blue)
        "0x" + redHex + greenHex + blueHex
    }

}