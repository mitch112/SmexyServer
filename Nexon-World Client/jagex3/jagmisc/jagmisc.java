/* jagmisc - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package jagex3.jagmisc;

public class jagmisc
{
    private static native int ping0(byte i, byte i_0_, byte i_1_, byte i_2_,
				    long l);
    
    private static native void Quit0();
    
    public static native long nanoTime();
    
    public static native long getTotalPhysicalMemory();
    
    public static native long getAvailablePhysicalMemory();
    
    public static void quit() {
	try {
	    Quit0();
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    public static native boolean init();
    
    public static int ping(byte i, byte i_3_, byte i_4_, byte i_5_, long l)
	throws Throwable {
	try {
	    int i_6_ = ping0(i, i_3_, i_4_, i_5_, l);
	    if (i_6_ < 0)
		throw new Exception(String.valueOf(i_6_));
	    return i_6_;
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
}
