package su.elwood;

import net.sf.jni4net.Bridge;
import net_app.ITestClass;
import net_app.MyEventArgs;
import net_app.TestClass;
import net_app.TestDelegate;
import system.Console;
import system.Object;

import java.io.IOException;

public class Main {

    /**
     * Полезная функция для определения разрядности JVM, на которой был запущен java-процесс.
     * @return
     */
    public static boolean is64BitVM() {
        String bits = System.getProperty( "sun.arch.data.model", "?" );
        if ( bits.equals( "64" )) {
            return true;
        }
        if ( bits.equals( "?" )) {
            // probably sun.arch.data.model isn't available
            // maybe not a Sun JVM?
            // try with the vm.name property
            return
                    System.getProperty( "java.vm.name" )
                            .toLowerCase().indexOf( "64" ) >= 0;
        }
        // probably 32bit
        return false;
    }

    public static void main(String[] args) throws IOException {
        Bridge.setVerbose( true );
        Bridge.init();
        Bridge.LoadAndRegisterAssemblyFrom(new java.io.File("net-app.j4n.dll"));

        Console.WriteLine( "Hello .NET runtime!" );
        ITestClass test = new TestClass();
        test.addMyEvent( new TestDelegate() {
            public void Invoke( Object sender, MyEventArgs args ) {
                System.out.println("Event from .NET!");
            }
        } );

        System.out.println( "GetSomeString: " + test.getSomeString() );
    }
}
