import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class BindingDemo {
  public static void main(String[] args) throws Exception {
    ScriptEngineManager manager = new ScriptEngineManager();
    ScriptEngine engine = manager.getEngineByName("nashorn");
    engine.put("a", 1);
    engine.put("b", 5);

    Bindings bindings = engine.getBindings(ScriptContext.ENGINE_SCOPE);
    Object a = bindings.get("a");
    Object b = bindings.get("b");
    System.out.println("a = " + a);
    System.out.println("b = " + b);

    Object result = engine.eval("c = a + b;");
    System.out.println("a + b = " + result);
  }
}
