package lesson12.test1;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import lesson12.exam1.*;

public class DeliveryRobot1Test {

   @Test
   /**
    * 提示されたクラスが実装されているかどうかの検査
    */
   public void 配送ロボット1クラス実装検査01() {
      try {
         Class.forName("lesson12.exam1.DeliveryRobot1");
         assertTrue(true);
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
         fail();
      }
   }

   @Test
   /**
    * 提示されたメソッドが実装されているかどうかの検査
    */
   public void 配送ロボット1メソッド実装検査01() throws SecurityException, NoSuchMethodException {
      List<String> methods = new ArrayList<String>();
      methods.add("voiceCommand");
      methods.add("resetCommand");
      methods.add("detectCollapse");

      for(Method m : DeliveryRobot1.class.getDeclaredMethods()) {
         assertTrue(methods.contains(m.getName()));
         methods.remove(m.getName());
         assertTrue(Modifier.isPublic(m.getModifiers()));
      }

      int expected = 0;
      int actual = methods.size();
      assertEquals(expected, actual);
   }

   @Test
   /**
    * 提示されたフィールドが実装されているかどうかの検査
    */
   public void 配送ロボット1フィールド実装検査01() {
      List<String> fields = new ArrayList<String>();
      fields.add("WAITING");
      fields.add("DELIVERING");
      fields.add("EMERGENCYSTOP");
      fields.add("state");

      for(Field f : DeliveryRobot1.class.getDeclaredFields()) {
         assertTrue(fields.contains(f.getName()));
         fields.remove(f.getName());
      }

      int expected = 0;
      int actual = fields.size();
      assertEquals(expected, actual);
   }

}
