using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace net_app
{
    /// <summary>
    /// Custom delegate to provide notifications
    /// </summary>
    /// <param name="sender"></param>
    /// <param name="args"></param>
    public delegate void TestDelegate(Object sender, MyEventArgs args);

    /// <summary>
    /// Event args for custom delegate
    /// </summary>
    public class MyEventArgs : EventArgs {
        public MyEventArgs() {
        }

        public new static readonly MyEventArgs Empty = new MyEventArgs();
    }

    /// <summary>
    /// Able to use interfaces
    /// </summary>
    public interface ITestClass {
        String getSomeString();

        event TestDelegate MyEvent;
    }

    /// <summary>
    /// Class implementation
    /// </summary>
    public class TestClass : ITestClass
    {
        public String getSomeString() {
            if (null != MyEvent) MyEvent(this, MyEventArgs.Empty);
            return "some string";
        }

        public event TestDelegate MyEvent;
    }
}
