package module3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach; 
 
public class ContactTest { 

  private Contact c;

  @BeforeEach
  void setUp() {
    c = new Contact("Ada Lovelace", "+1 617 555 0101");
  }
 
  @Test 
  void constructor_setsNameCorrectly() { 
    assertEquals("Ada Lovelace", c.getName()); 
  } 
 
  @Test
  void constructor_setsPhoneCorrectly() { 
    assertEquals("+1 617 555 0101", c.getPhone()); 
  } 
 
  @Test
  void getName_returnsExactString_notTransformed() { 
    Contact contact = new Contact("Grace Hopper", "555-0000"); 
    assertEquals("Grace Hopper", contact.getName());
  } 
 
  @Test
  void toString_containsName() { 
    assertTrue(c.toString().contains("Ada Lovelace"));
  } 
 
  @Test
  void toString_containsPhone() {
    assertTrue(c.toString().contains("+1 617 555 0101"));
  }

  @Test
  void twoContactsWithSameName_areIndependentObjects() {
    Contact c2 = new Contact("Ada Lovelace", "+1 716 555 1010");

    assertEquals(c.getName(), c2.getName());
    assertNotEquals(c.getPhone(), c2.getPhone());

    assertNotSame(c, c2);
  }
} 