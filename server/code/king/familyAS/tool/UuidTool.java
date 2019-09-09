package king.familyAS.tool;

import com.fasterxml.uuid.Generators;
import java.util.UUID;

public class UuidTool {

      public static UUID obtainUUID(){
	     UUID uuid0 = Generators.randomBasedGenerator().generate();
//             UUID uuid1 = Generators.timeBasedGenerator().generate();
	     return uuid0;
	}
}
