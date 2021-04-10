package seedu.address.model.issue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class RoomNumberTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new RoomNumber(null));
    }

    @Test
    public void constructor_invalidRoomNumber_throwsIllegalArgumentException() {
        String invalidRoomNumber = "03-1234";
        assertThrows(IllegalArgumentException.class, () -> new RoomNumber(invalidRoomNumber));
    }

    @Test
    public void isValidRoomNumber() {
        // null room
        assertThrows(NullPointerException.class, () -> RoomNumber.isValidRoomNumber(null));

        // invalid rooms
        assertFalse(RoomNumber.isValidRoomNumber("")); // empty string
        assertFalse(RoomNumber.isValidRoomNumber("-")); // no numbers
        assertFalse(RoomNumber.isValidRoomNumber("03144")); // room does not have hyphen
        assertFalse(RoomNumber.isValidRoomNumber("floor-unit")); // non-numeric
        assertFalse(RoomNumber.isValidRoomNumber("fl00r-un1t")); // alphabets with number
        assertFalse(RoomNumber.isValidRoomNumber("0-123")); // floor is fewer than 2 digits
        assertFalse(RoomNumber.isValidRoomNumber("000-123")); // floor is more than 2 digits
        assertFalse(RoomNumber.isValidRoomNumber("00-12")); // unit is few than 3 digits
        assertFalse(RoomNumber.isValidRoomNumber("00-1234")); // unit is more than 3 digits

        // valid rooms
        assertTrue(RoomNumber.isValidRoomNumber("01-234"));
    }

    @Test
    public void equals() {
        RoomNumber one = new RoomNumber("00-001");
        RoomNumber two = new RoomNumber("00-001");
        RoomNumber three = new RoomNumber("00-003");

        // same room number -> true
        assertEquals(one, one);

        // same value -> true
        assertEquals(one, two);

        // different value -> false
        assertNotEquals(one, three);

        // null room number -> false
        assertNotEquals(one, null);

        // different instance -> false
        assertNotEquals(one, 1);
    }
}
