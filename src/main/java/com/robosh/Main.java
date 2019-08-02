package com.robosh;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;

class Main{
    public static void main(String[] args) throws IOException {
        ScriptEngineManager factory = new ScriptEngineManager();

        ScriptEngine engine = factory.getEngineByName("nashorn");

        try{
            engine.eval("print('Hello world!');");
        }catch (ScriptException ignored){
        }
    }
}
