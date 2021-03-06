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
        case LedData(count, pin)             => "#define LED_COUNT " + count + "\n" + "#define PIN " + pin + "\n" + declareLeds() + declareSetup() + declareHelperFuncs()
        case default                         => "//Stmt default//"
    }

    def declareLeds() = 
         "Adafruit_NeoPixel leds = Adafruit_NeoPixel(LED_COUNT, PIN, NEO_GRB + NEO_KHZ800);\n\n"

    def declareSetup() = 
          "void setup()\n" + 
          "{\n" +
          "\tleds.begin();  // Call this to start up the LED strip.\n" +
          "\tclearLEDs();   // This function, defined below, turns all LEDs off...\n" +
          "\tleds.setBrightness(20);\n" +
          "\tleds.show();   // ...but the LEDs don't actually update until you call this.\n" +
          "}\n" +
          "\n" 
    
    def evalExprs(exprs: List[Expr]): String = {
        if (exprs.isEmpty){
            ""
        }
        else {
            evalExpr(exprs.head) + evalExprs(exprs.tail)
        }
    }

    def evalExpr(expr: Expr): String = expr match {
        case StripColor(col, dur)       => "\tsetColor(" + evalColor(col) + ", " + dur + ");\n"
        case CustomEffect(name, loop)   => evalCustom(name, loop)
        case Cascade(col, dur)          => "\tcascade(" + evalColor(col) + ", " + dur + ");\n"
        case Cylon(col, dur)            => "\tcylon(" + evalColor(col) + ", " + dur + ");\n"
        case RainbowEffect(dur)         => "\trainbow(" + dur + ");\n"
        case default                    => "//Expr default//"
    }

    def evalCustom(name: String, loop: Integer): String = {
        if (loop == 1) {
            "\t" + name + "();\n"
        }
        else if (loop >= 0){
            "\tfor(int cus = 0; cus < " + loop + "; cus++){\n" +
            "\t\t" + name + "();\n" +
            "\t}\n"
        }
        else {
            "//Custom Error//"
        }
   
    }

    def evalColor(col: Color): String = col match {
        case BLACK                  => "BLACK, -1"
        case NAVY                   => "NAVY, -1"
        case DARKBLUE               => "DARKBLUE, -1"
        case MEDIUMBLUE             => "MEDIUMBLUE, -1"
        case BLUE                   => "BLUE, -1"
        case DARKGREEN              => "DARKGREEN, -1"
        case GREEN                  => "GREEN, -1"
        case TEAL                   => "TEAL, -1"
        case DARKCYAN               => "DARKCYAN, -1"
        case DEEPSKYBLUE            => "DEEPSKYBLUE, -1"
        case DARKTURQUOISE          => "DARKTURQUOISE, -1"
        case MEDIUMSPRINGGREEN      => "MEDIUMSPRINGGREEN, -1"
        case LIME                   => "LIME, -1"
        case SPRINGGREEN            => "SPRINGGREEN, -1"
        case AQUA                   => "AQUA, -1"
        case CYAN                   => "CYAN, -1"
        case MIDNIGHTBLUE           => "MIDNIGHTBLUE, -1"
        case DODGERBLUE             => "DODGERBLUE, -1"
        case LIGHTSEAGREEN          => "LIGHTSEAGREEN, -1"
        case FORESTGREEN            => "FORESTGREEN, -1"
        case SEAGREEN               => "SEAGREEN, -1"
        case DARKSLATEGRAY          => "DARKSLATEGRAY, -1"
        case LIMEGREEN              => "LIMEGREEN, -1"
        case MEDIUMSEAGREEN         => "MEDIUMSEAGREEN, -1"
        case TURQUOISE              => "TURQUOISE, -1"
        case ROYALBLUE              => "ROYALBLUE, -1"
        case STEELBLUE              => "STEELBLUE, -1"
        case DARKSLATEBLUE          => "DARKSLATEBLUE, -1"
        case MEDIUMTURQUOISE        => "MEDIUMTURQUOISE, -1"
        case INDIGO                 => "INDIGO, -1"
        case DARKOLIVEGREEN         => "DARKOLIVEGREEN, -1"
        case CADETBLUE              => "CADETBLUE, -1"
        case CORNFLOWERBLUE         => "CORNFLOWERBLUE, -1"
        case MEDIUMAQUAMARINE       => "MEDIUMAQUAMARINE, -1"
        case DIMGRAY                => "DIMGRAY, -1"
        case SLATEBLUE              => "SLATEBLUE, -1"
        case OLIVEDRAB              => "OLIVEDRAB, -1"
        case SLATEGRAY              => "SLATEGRAY, -1"
        case LIGHTSLATEGRAY         => "LIGHTSLATEGRAY, -1"
        case MEDIUMSLATEBLUE        => "MEDIUMSLATEBLUE, -1"
        case LAWNGREEN              => "LAWNGREEN, -1"
        case CHARTREUSE             => "CHARTREUSE, -1"
        case AQUAMARINE             => "AQUAMARINE, -1"
        case MAROON                 => "MAROON, -1"
        case PURPLE                 => "PURPLE, -1"
        case OLIVE                  => "OLIVE, -1"
        case GRAY                   => "GRAY, -1"
        case SKYBLUE                => "SKYBLUE, -1"
        case LIGHTSKYBLUE           => "LIGHTSKYBLUE, -1"
        case BLUEVIOLET             => "BLUEVIOLET, -1"
        case DARKRED                => "DARKRED, -1"
        case DARKMAGENTA            => "DARKMAGENTA, -1"
        case SADDLEBROWN            => "SADDLEBROWN, -1"
        case DARKSEAGREEN           => "DARKSEAGREEN, -1"
        case LIGHTGREEN             => "LIGHTGREEN, -1"
        case MEDIUMPURPLE           => "MEDIUMPURPLE, -1"
        case DARKVIOLET             => "DARKVIOLET, -1"
        case PALEGREEN              => "PALEGREEN, -1"
        case DARKORCHID             => "DARKORCHID, -1"
        case YELLOWGREEN            => "YELLOWGREEN, -1"
        case SIENNA                 => "SIENNA, -1"
        case BROWN                  => "BROWN, -1"
        case DARKGRAY               => "DARKGRAY, -1"
        case LIGHTBLUE              => "LIGHTBLUE, -1"
        case GREENYELLOW            => "GREENYELLOW, -1"
        case PALETURQUOISE          => "PALETURQUOISE, -1"
        case LIGHTSTEELBLUE         => "LIGHTSTEELBLUE, -1"
        case POWDERBLUE             => "POWDERBLUE, -1"
        case FIREBRICK              => "FIREBRICK, -1"
        case DARKGOLDENROD          => "DARKGOLDENROD, -1"
        case MEDIUMORCHID           => "MEDIUMORCHID, -1"
        case ROSYBROWN              => "ROSYBROWN, -1"
        case DARKKHAKI              => "DARKKHAKI, -1"
        case SILVER                 => "SILVER, -1"
        case MEDIUMVIOLETRED        => "MEDIUMVIOLETRED, -1"
        case INDIANRED              => "INDIANRED, -1"
        case PERU                   => "PERU, -1"
        case CHOCOLATE              => "CHOCOLATE, -1"
        case TAN                    => "TAN, -1"
        case LIGHTGRAY              => "LIGHTGRAY, -1"
        case THISTLE                => "THISTLE, -1"
        case ORCHID                 => "ORCHID, -1"
        case GOLDENROD              => "GOLDENROD, -1"
        case PALEVIOLETRED          => "PALEVIOLETRED, -1"
        case CRIMSON                => "CRIMSON, -1"
        case GAINSBORO              => "GAINSBORO, -1"
        case PLUM                   => "PLUM, -1"
        case BURLYWOOD              => "BURLYWOOD, -1"
        case LIGHTCYAN              => "LIGHTCYAN, -1"
        case LAVENDER               => "LAVENDER, -1"
        case DARKSALMON             => "DARKSALMON, -1"
        case VIOLET                 => "VIOLET, -1"
        case PALEGOLDENROD          => "PALEGOLDENROD, -1"
        case LIGHTCORAL             => "LIGHTCORAL, -1"
        case KHAKI                  => "KHAKI, -1"
        case ALICEBLUE              => "ALICEBLUE, -1"
        case HONEYDEW               => "HONEYDEW, -1"
        case AZURE                  => "AZURE, -1"
        case SANDYBROWN             => "SANDYBROWN, -1"
        case WHEAT                  => "WHEAT, -1"
        case BEIGE                  => "BEIGE, -1"
        case WHITESMOKE             => "WHITESMOKE, -1"
        case MINTCREAM              => "MINTCREAM, -1"
        case GHOSTWHITE             => "GHOSTWHITE, -1"
        case SALMON                 => "SALMON, -1"
        case ANTIQUEWHITE           => "ANTIQUEWHITE, -1"
        case LINEN                  => "LINEN, -1"
        case LIGHTGOLDENRODYELLOW   => "LIGHTGOLDENRODYELLOW, -1"
        case OLDLACE                => "OLDLACE, -1"
        case RED                    => "RED, -1"
        case FUCHSIA                => "FUCHSIA, -1"
        case MAGENTA                => "MAGENTA, -1"
        case DEEPPINK               => "DEEPPINK, -1"
        case ORANGERED              => "ORANGERED, -1"
        case TOMATO                 => "TOMATO, -1"
        case HOTPINK                => "HOTPINK, -1"
        case CORAL                  => "CORAL, -1"
        case DARKORANGE             => "DARKORANGE, -1"
        case LIGHTSALMON            => "LIGHTSALMON, -1"
        case ORANGE                 => "ORANGE, -1"
        case LIGHTPINK              => "LIGHTPINK, -1"
        case PINK                   => "PINK, -1"
        case GOLD                   => "GOLD, -1"
        case PEACHPUFF              => "PEACHPUFF, -1"
        case NAVAJOWHITE            => "NAVAJOWHITE, -1"
        case MOCCASIN               => "MOCCASIN, -1"
        case BISQUE                 => "BISQUE, -1"
        case MISTYROSE              => "MISTYROSE, -1"
        case BLANCHEDALMOND         => "BLANCHEDALMOND, -1"
        case PAPAYAWHIP             => "PAPAYAWHIP, -1"
        case LAVENDERBLUSH          => "LAVENDERBLUSH, -1"
        case SEASHELL               => "SEASHELL, -1"
        case CORNSILK               => "CORNSILK, -1"
        case LEMONCHIFFON           => "LEMONCHIFFON, -1"
        case FLORALWHITE            => "FLORALWHITE, -1"
        case SNOW                   => "SNOW, -1"
        case YELLOW                 => "YELLOW, -1"
        case LIGHTYELLOW            => "LIGHTYELLOW, -1"
        case IVORY                  => "IVORY, -1"
        case WHITE                  => "WHITE, -1"
        case RGB(r,g,b)             => evalRGB(r, g, b)
        case RAINBOW                => "-1, -1"
        case RANGE(sc, ec)          => evalRange(sc, ec)
        case default                => "// default //"
    }

    def evalRGB(red: Integer, green: Integer, blue: Integer): String = {
        val redHex = Integer.toHexString(red)
        val greenHex = Integer.toHexString(green)
        val blueHex = Integer.toHexString(blue)
        "0x" + redHex + greenHex + blueHex + ", -1"
    }

    def evalRange(startColor : Color, endColor : Color): String = {
        val sc = evalColor(startColor)
        val ec = evalColor(endColor)

        val scNoComma = sc.replaceAll(", -1", "")
        val ecNoComma = ec.replaceAll(", -1", "")

        scNoComma + ", " + ecNoComma
    }
    def declareHelperFuncs() = 
        //////////////////////////////////////////// +
        ////   SET COLOR  method   ///////////////// +
        //////////////////////////////////////////// +    
        "/********************************\n"+
        "* If End Color is not -1, then\n"+
        "* the user has specified a color\n"+
        "* range for fading so run\n"+
        "* *setColorWithoutRange*. otherwise,\n"+
        "* run *setColorWithRange*\n"+
        "********************************/\n"+
        "void setColor(long startColor, long endColor, float duration){\n"+
        "\n"+
        "   if (endColor != -1) {\n"+
        "    setColorWithRange(startColor, endColor, duration);\n"+
        "   }\n"+
        "   else {\n"+
        "    setColorWithoutRange(startColor, duration);\n"+
        "   }\n"+
        "}\n"+
        "\n"+
        "void setColorWithRange(long startColor, long endColor, float duration) {\n"+
        "  byte start_red = (startColor & 0xFF0000) >> 16;\n"+
        "  byte start_green = (startColor & 0x00FF00) >> 8;\n"+
        "  byte start_blue = (startColor & 0x0000FF);\n"+
        "  byte end_red = (endColor & 0xFF0000) >> 16;\n"+
        "  byte end_green = (endColor & 0x00FF00) >> 8;\n"+
        "  byte end_blue = (endColor & 0x0000FF);\n"+
        "  \n"+
        "  short delta_red = end_red - start_red;\n"+
        "  short delta_green = end_green - start_green;\n"+
        "  short delta_blue = end_blue - start_blue;\n"+
        "  \n"+
        "  int delayVal = 5;\n"+
        "  int steps = (int)(duration*1000/delayVal);\n"+
        "  \n"+
        "  float red_step = delta_red*1.0/steps;\n"+
        "  float green_step = delta_green*1.0/steps;\n"+
        "  float blue_step = delta_blue*1.0/steps;\n"+
        "  \n"+
        "  for (int i = 0; i < steps; i++){\n"+
        "   for (int j = 0; j < LED_COUNT; j++){\n"+
        "    leds.setPixelColor(j, start_red + red_step*i, start_green + green_step*i, start_blue + blue_step*i);\n"+
        "   }\n"+
        "   leds.show();\n"+
        "   delay(delayVal);\n"+
        "  } \n"+
        "}\n"+
        "\n"+
        "void setColorWithoutRange(long color, float duration) {\n"+
        "    boolean rainbow = color == -1;\n"+
        "    byte red = (color & 0xFF0000) >> 16;\n"+
        "    byte green = (color & 0x00FF00) >> 8;\n"+
        "    byte blue = (color & 0x0000FF);\n"+
        "\n"+
        "    for(int i=0; i<LED_COUNT; i++){\n"+
        "    if(rainbow){\n"+
        "        color = rainbowColor(i);\n"+
        "        red = (color & 0xFF0000) >> 16;\n"+
        "        green = (color & 0x00FF00) >> 8;\n"+
        "        blue = (color & 0x0000FF);\n"+
        "    }\n"+
        "        leds.setPixelColor(i, red, green, blue);\n"+
        "    }\n"+
        "    leds.show();\n"+
        "    delay(duration*1000);\n"+
        "}\n"+
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
        "void rainbow(float duration){\n" +
        "\tint delayVal = 50;\n" +
        "\tint iterCount = (int)(duration*1000/delayVal);\n" +
        "\tfloat rainbowScale = 192 / LED_COUNT;\n" +
        "\t\n" +
        "\tfor (int i = 0; i < iterCount; i++){\n" +
        "\tfor (int j = 0; j < LED_COUNT; j++){\n" +
        "\t\tleds.setPixelColor(j, rainbowColor((int)(rainbowScale * (j + i)) % 192));\n" +
        "\t}\n" +
        "\tleds.show();\n" +
        "\tdelay(delayVal);\n" +
        "\t}\n" +
        "}\n" +
        "\n"+
        "\n"+
        "/********************************\n"+
        "* If End Color is not -1, then\n"+
        "* the user has specified a color\n"+
        "* range for fading so run\n"+
        "* *cylonWithoutRange*. otherwise,\n"+
        "* run *cylonWithRange*\n"+
        "********************************/\n"+
        "void cylon(long startColor, long endColor, float duration){\n"+
        "  if(endColor != -1){\n"+
        "    cylonWithRange(startColor, endColor, duration);\n"+
        "  }\n"+
        "  else {\n"+
        "    cylonWithoutRange(startColor, duration);\n"+
        "  }\n"+
        "}\n"+
        "\n"+
        "void cylonWithoutRange(long color, float duration)\n"+
        "{\n"+
        "    // weight determines how much lighter the outer \"eye\" colors are\n"+
        "    const byte weight = 4;\n"+
        "    float delayVal = duration/(2*LED_COUNT)*1000;\n"+
        "    boolean rainbow = color == -1;\n"+
        "\n"+
        "    // Start at closest LED, and move to the outside\n"+
        "    for (int i = 0; i <= LED_COUNT - 1; i++)\n"+
        "    {\n"+
        "\n"+
        "        if(rainbow){\n"+
        "            color = rainbowColor(i);\n"+
        "        }\n"+
        "        // It'll be easier to decrement each of these colors individually\n"+
        "        // so we'll split them out of the 24-bit color value\n"+
        "        byte red = (color & 0xFF0000) >> 16;\n"+
        "        byte green = (color & 0x00FF00) >> 8;\n"+
        "        byte blue = (color & 0x0000FF);\n"+
        "        \n"+
        "        clearLEDs();\n"+
        "        leds.setPixelColor(i, red, green, blue);  // Set the bright middle eye\n"+
        "        // Now set two eyes to each side to get progressively dimmer\n"+
        "        for (int j = 1; j < 3; j++)\n"+
        "        {\n"+
        "            if (i - j >= 0)\n"+
        "                leds.setPixelColor(i - j, red / (weight * j), green / (weight * j), blue / (weight * j));\n"+
        "            if (i - j <= LED_COUNT)\n"+
        "                leds.setPixelColor(i + j, red / (weight * j), green / (weight * j), blue / (weight * j));\n"+
        "        }\n"+
        "        leds.show();  // Turn the LEDs on\n"+
        "        delay(delayVal);  // Delay for visibility\n"+
        "    }\n"+
        "\n"+
        "    // Now we go back to where we came. Do the same thing.\n"+
        "    for (int i = LED_COUNT - 2; i >= 1; i--)\n"+
        "    {\n"+
        "        if(rainbow){\n"+
        "            color = rainbowColor(i);\n"+
        "        }\n"+
        "        // It'll be easier to decrement each of these colors individually\n"+
        "        // so we'll split them out of the 24-bit color value\n"+
        "        byte red = (color & 0xFF0000) >> 16;\n"+
        "        byte green = (color & 0x00FF00) >> 8;\n"+
        "        byte blue = (color & 0x0000FF);\n"+
        "        \n"+
        "        clearLEDs();\n"+
        "        leds.setPixelColor(i, red, green, blue);\n"+
        "        for (int j = 1; j < 3; j++)\n"+
        "        {\n"+
        "            if (i - j >= 0)\n"+
        "                leds.setPixelColor(i - j, red / (weight * j), green / (weight * j), blue / (weight * j));\n"+
        "            if (i - j <= LED_COUNT)\n"+
        "                leds.setPixelColor(i + j, red / (weight * j), green / (weight * j), blue / (weight * j));\n"+
        "        }\n"+
        "\n"+
        "        leds.show();\n"+
        "        delay(delayVal);\n"+
        "    }\n"+
        "}\n"+
        "\n"+
        "void cylonWithRange(long startColor, long endColor, float duration){\n"+
        "    // weight determines how much lighter the outer \"eye\" colors are\n"+
        "  const byte weight = 4;\n"+
        "  int steps = 2*LED_COUNT;\n"+
        "  float delayVal = duration/(steps)*1000;\n"+
        "\n"+
        "  byte start_red = (startColor & 0xFF0000) >> 16;\n"+
        "  byte start_green = (startColor & 0x00FF00) >> 8;\n"+
        "  byte start_blue = (startColor & 0x0000FF);\n"+
        "  byte end_red = (endColor & 0xFF0000) >> 16;\n"+
        "  byte end_green = (endColor & 0x00FF00) >> 8;\n"+
        "  byte end_blue = (endColor & 0x0000FF);\n"+
        "  \n"+
        "  short delta_red = end_red - start_red;\n"+
        "  short delta_green = end_green - start_green;\n"+
        "  short delta_blue = end_blue - start_blue;\n"+
        "  \n"+
        "  \n"+
        "  float red_step =delta_red*1.0/steps;\n"+
        "  float green_step =delta_green*1.0/steps;\n"+
        "  float blue_step =delta_blue*1.0/steps;\n"+
        "  //   Start at closest LED, and move to the outside\n"+
        "  for (int i = 0; i <= steps/2 - 1; i++)\n"+
        "  {\n"+
        "\n"+
        "    byte red = start_red + red_step*i;\n"+
        "    byte blue = start_blue + blue_step*i;\n"+
        "    byte green = start_green + green_step*i;\n"+
        "    \n"+
        "    clearLEDs();\n"+
        "    leds.setPixelColor(i, red, green, blue);  // Set the bright middle eye\n"+
        "    // Now set two eyes to each side to get progressively dimmer\n"+
        "    for (int j = 1; j < 3; j++)\n"+
        "    {\n"+
        "      if (i - j >= 0)\n"+
        "        leds.setPixelColor(i - j, red / (weight * j), green / (weight * j), blue / (weight * j));\n"+
        "      if (i - j <= LED_COUNT)\n"+
        "        leds.setPixelColor(i + j, red / (weight * j), green / (weight * j), blue / (weight * j));\n"+
        "    }\n"+
        "    leds.show();  // Turn the LEDs on\n"+
        "    delay(delayVal);  // Delay for visibility\n"+
        "  }\n"+
        "\n"+
        "  // Now we go back to where we came. Do the same thing.\n"+
        "  for (int i = steps/2 - 2; i >= 1; i--)\n"+
        "  {\n"+
        "    byte red = start_red + red_step*i;\n"+
        "    byte blue = start_blue + blue_step*i;\n"+
        "    byte green = start_green + green_step*i;\n"+
        "    \n"+
        "    clearLEDs();\n"+
        "    leds.setPixelColor(i, red, green, blue);\n"+
        "    for (int j = 1; j < 3; j++)\n"+
        "    {\n"+
        "      if (i - j >= 0)\n"+
        "        leds.setPixelColor(i - j, red / (weight * j), green / (weight * j), blue / (weight * j));\n"+
        "      if (i - j <= LED_COUNT)\n"+
        "        leds.setPixelColor(i + j, red / (weight * j), green / (weight * j), blue / (weight * j));\n"+
        "    }\n"+
        "\n"+
        "    leds.show();\n"+
        "    delay(delayVal);\n"+
        "  }\n"+
        "}\n"+
        "\n"+
        "/********************************\n"+
        "* If End Color is not -1, then\n"+
        "* the user has specified a color\n"+
        "* range for fading so run\n"+
        "* *cascadeWithoutRange*. otherwise,\n"+
        "* run *cascadeWithRange*\n"+
        "********************************/\n"+
        "void cascade(long startColor, long endColor, float duration){\n"+
        "  if (endColor != -1) {\n"+
        "    cascadeWithRange(startColor, endColor, duration);\n"+
        "  }\n"+
        "  else {\n"+
        "    cascadeWithoutRange(startColor, duration);\n"+
        "  }\n"+
        "}\n"+
        "\n"+
        "void cascadeWithoutRange(long color, float duration)\n"+
        "{\n"+
        "    boolean rainbow = color == -1;\n"+
        "    float delayVal = LED_COUNT/duration;\n"+
        "    for (int i = 0; i < LED_COUNT; i++)\n"+
        "    {\n"+
        "        if(rainbow){\n"+
        "            color = rainbowColor(i);\n"+
        "        }\n"+
        "        clearLEDs();  // Turn off all LEDs\n"+
        "        leds.setPixelColor(i, color);  // Set just this one\n"+
        "        leds.show();\n"+
        "        delay(delayVal);\n"+
        "    }\n"+
        "\n"+
        "}\n"+
        "\n"+
        "void cascadeWithRange(long startColor, long endColor, float duration){\n"+
        "\n"+
        "  int steps = LED_COUNT;\n"+
        "  float delayVal = duration/(steps)*1000;\n"+
        "\n"+
        "  byte start_red = (startColor & 0xFF0000) >> 16;\n"+
        "  byte start_green = (startColor & 0x00FF00) >> 8;\n"+
        "  byte start_blue = (startColor & 0x0000FF);\n"+
        "  byte end_red = (endColor & 0xFF0000) >> 16;\n"+
        "  byte end_green = (endColor & 0x00FF00) >> 8;\n"+
        "  byte end_blue = (endColor & 0x0000FF);\n"+
        "  \n"+
        "  short delta_red = end_red - start_red;\n"+
        "  short delta_green = end_green - start_green;\n"+
        "  short delta_blue = end_blue - start_blue;\n"+
        "  \n"+
        "  \n"+
        "  float red_step =delta_red*1.0/steps;\n"+
        "  float green_step =delta_green*1.0/steps;\n"+
        "  float blue_step =delta_blue*1.0/steps;\n"+
        "\n"+
        "  for (int i = 0; i < steps; i++)\n"+
        "  {\n"+
        "    byte red = start_red + red_step*i;\n"+
        "    byte blue = start_blue + blue_step*i;\n"+
        "    byte green = start_green + green_step*i;\n"+
        " \n"+
        "    clearLEDs();  // Turn off all LEDs\n"+
        "    leds.setPixelColor(i, red, green, blue);  // Set just this one\n"+
        "    leds.show();\n"+
        "    delay(delayVal);\n"+
        "  }\n"+
        "}\n"+
        " \n"


    def voidFuncHeader(name: String) = 
        "void " + name + "() {\n"

    def loopFuncHeader() = 
        "void loop() {\n"

}