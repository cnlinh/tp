package seedu.address.model.issue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class DescriptionTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Description(null));
    }

    @Test
    public void constructor_invalidDescription_throwsIllegalArgumentException() {
        String invalidDescription = "";
        assertThrows(IllegalArgumentException.class, () -> new Description(invalidDescription));
    }

    @Test
    public void isValidName() {
        // null description
        assertThrows(NullPointerException.class, () -> Description.isValidDescription(null));

        // invalid description
        assertFalse(Description.isValidDescription("")); // empty description

        // valid description
        assertTrue(Description.isValidDescription("a")); // single alphabet
        assertTrue(Description.isValidDescription("1")); // single digit
        assertTrue(Description.isValidDescription("fdasf1212")); // alphanumberical
        assertTrue(Description.isValidDescription("jk23l1 j32k1 k2k21l df")); // alphanumerical with spaces
        // All valid characters
        assertTrue(Description.isValidDescription(
                "ABCDEFGHIJKLMNOPQRSTUWXYZabcdefghijklmnopqrstuvwxyz1234567890 "));
    }

    @Test
    public void equals() {
        Description one = new Description("one");
        Description two = new Description("one");
        Description three = new Description("three");

        // same description -> true
        assertEquals(one, one);

        // same value -> true
        assertEquals(one, two);

        // different value -> false
        assertNotEquals(one, three);

        // null category -> false
        assertNotEquals(one, null);

        // different instance -> false
        assertNotEquals(one, 1);
    }
}
