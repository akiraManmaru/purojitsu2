package lesson12.test3;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import lesson12.exam3.*;

public class DeliveryRobot3Test {

   @Test
   /**
    * 提示されたクラスが実装されているかどうかの検査
    */
   public void 配送ロボット3クラス実装検査01() {
      try {
         Class.forName("lesson12.exam3.DeliveryRobot3");
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
   public void 配送ロボット3メソッド実装検査01() throws SecurityException, NoSuchMethodException {
      List<String> methods = new ArrayList<String>();
      methods.add("voiceCommand");
      methods.add("resetCommand");
      methods.add("detectEmergencyVehicle");
      methods.add("detectPrime");
      methods.add("detectCollapse");

      for(Method m : DeliveryRobot3.class.getDeclaredMethods()) {
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
   public void 配送ロボット3フィールド実装検査01() {
      List<String> fields = new ArrayList<String>();
      fields.add("WAITING");
      fields.add("DELIVERING");
      fields.add("EMERGENCYSTOP");
      fields.add("PRIMEDELIVERING");
      fields.add("state");

      for(Field f : DeliveryRobot3.class.getDeclaredFields()) {
         assertTrue(fields.contains(f.getName()));
         fields.remove(f.getName());
      }

      int expected = 0;
      int actual = fields.size();
      assertEquals(actual, expected);
   }

}
