import javax.script.*;
import java.util.List;
public class TestScript{
	public static void main(String []arg)
  	{	
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("nashorn");
		List<ScriptEngineFactory> factories = manager.getEngineFactories();
		System.out.println("Engines available : "+factories.size());
		for(ScriptEngineFactory factory : factories)
		{
			System.out.println(factory.getEngineName());
		}
	}
}

