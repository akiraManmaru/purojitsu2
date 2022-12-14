package lesson12.test2;

import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import lesson12.exam2.*;

public class StatePatternTest {

   @Test
   /**
    * 課題で提示されたクラスが実装されているかどうかの検査
    */
   public void ConcreteStateクラス実装検査01() {
      try {
         Class.forName("lesson12.exam2.Waiting");
         Class.forName("lesson12.exam2.Delivering");
         Class.forName("lesson12.exam2.EmergencyStop");
         assertTrue(true);
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
         fail();
      }
   }

   @Test
   /**
    * Stateインタフェースに関する依存関係検査
    */
   public void Stateパターン依存関係検査01() {
      // State はインタフェースであること
      assertTrue(State.class.isInterface());
      // それぞれの状態を表すクラスは State インタフェースの実装であること
      DeliveryRobot2 rc = new DeliveryRobot2();
      State subclass = new Delivering(rc);
      assertEquals("interface lesson12.exam2.State", subclass.getClass().getInterfaces()[0].toString());
      subclass = new EmergencyStop(rc);
      assertEquals("interface lesson12.exam2.State", subclass.getClass().getInterfaces()[0].toString());
      subclass = new Waiting(rc);
      assertEquals("interface lesson12.exam2.State", subclass.getClass().getInterfaces()[0].toString());
   }

   /**
    * 各クラスで提示されたメソッドが実装されているかどうかの検査
    */
   @Test
   /**
    * 「待ち」クラスのメソッド
    */
   public void 待ちクラスメソッド実装検査01() throws SecurityException, NoSuchMethodException {
      List<String> methods = new ArrayList<String>();
      methods.add("detectCollapse");
      methods.add("voiceCommand");
      methods.add("resetCommand");

      for(Method m : Waiting.class.getDeclaredMethods()) {
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
    * 「配送中」クラスのメソッド
    */
   public void 配送中クラスメソッド実装検査01() throws SecurityException, NoSuchMethodException {
      List<String> methods = new ArrayList<String>();
      methods.add("detectCollapse");
      methods.add("voiceCommand");
      methods.add("resetCommand");

      for(Method m : Delivering.class.getDeclaredMethods()) {
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
    * 「緊急停止」クラスのメソッド
    */
   public void 緊急停止クラスメソッド実装検査01() throws SecurityException, NoSuchMethodException {
      List<String> methods = new ArrayList<String>();
      methods.add("detectCollapse");
      methods.add("voiceCommand");
      methods.add("resetCommand");

      for(Method m : EmergencyStop.class.getDeclaredMethods()) {
         assertTrue(methods.contains(m.getName()));
         methods.remove(m.getName());
         assertTrue(Modifier.isPublic(m.getModifiers()));
      }

      int expected = 0;
      int actual = methods.size();
      assertEquals(expected, actual);
   }
}

