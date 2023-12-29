///usr/bin/env jbang "$0" "$@" ; exit $?

//DEPS com.fasterxml.uuid:java-uuid-generator:4.3.0
import static java.lang.System.*;
import com.fasterxml.uuid.Generators;

import java.util.UUID;
import java.text.SimpleDateFormat;
import java.util.Date;

public class uuid {

    public static void main(String... args) {
        out.println("Hello!");
        UUID uuidv1 = Generators.timeBasedGenerator().generate(); // Version 1
	UUID uuidv4 = Generators.randomBasedGenerator().generate(); // Version 4
	UUID uuidv5 = Generators.nameBasedGenerator().generate("string to hash"); // Version 5
// With JUG 4.1+: support for https://github.com/uuid6/uuid6-ietf-draft versions 6 and 7:
	UUID uuidv6 = Generators.timeBasedReorderedGenerator().generate(); // Version 6
	UUID uuidv7 = Generators.timeBasedEpochGenerator().generate(); // Version 7

	long mostSignificantBits = uuidv7.getMostSignificantBits();
	Date date = new Date(mostSignificantBits >> 16);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


	System.out.println("uuidv1 = " + uuidv1);
	System.out.println("uuidv4 = " + uuidv4);
	System.out.println("uuidv5 = " + uuidv5);
	System.out.println("uuidv6 = " + uuidv6);
	System.out.println("uuidv7 = " + uuidv7);

	System.out.println("uuidv7 created at " + sdf.format(date));

    }
}
