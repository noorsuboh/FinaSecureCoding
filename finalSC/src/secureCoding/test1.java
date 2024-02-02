package secureCoding;

import static org.junit.Assert.*;
import org.junit.Test;

public class test1 {
	@Test
	void testIsRegLogValidCredentials() {
        assertTrue(HealthClinic.isRegLog("Noor", HealthClinic.getHash("no-or2003")));
    }
}
   