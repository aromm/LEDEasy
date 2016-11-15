package ledplusplus

import ledplusplus.absyn._


////////////////////// THIS ISN'T RIGHT //////////////////////
package object semantics {
    var code = ""
    def evalProgram(program: List[Stmt]): String = {
        System.out.println("HIII")
        evalStmts(program)
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
        case Effect(name, body)    => voidFuncHeader(name) + evalExprs(body) + "}"
        case Main(body)            => loopFuncHeader() + evalExprs(body) + "}"
        case default                    => "//default//"
    }

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
        case StripColor(col, dur)   => "\tstripColor(" + evalColor(col) + ", " + dur + ");\n"
        case CustomEffect(name)     => "\t" + name + "();\n"
        case default                     => "//default//"
    }

    def evalColor(col: Color): String = col match {
        case RED        => "RED"
        case BLUE       => "BLUE"
        case GREEN      => "GREEN"
        case ORANGE     => "ORANGE"
        case INDIGO     => "INDIGO"
        case PINK       => "PINK"
        case RGB(r,g,b) => evalRGB(r, g, b)
    }

    def evalRGB(red: Integer, green: Integer, blue: Integer): String = 
        "RGB"// turn into hex value..

}