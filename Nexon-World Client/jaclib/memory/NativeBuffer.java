/* NativeBuffer - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package jaclib.memory;

public class NativeBuffer implements Buffer, Source
{
    private long a;
    private int b = -1;
    
    public final long getAddress() {
	try {
	    return a;
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    private final native void get(long l, byte[] is, int i, int i_0_,
				  int i_1_);
    
    public void a(byte[] is, int i, int i_2_, int i_3_) {
	try {
	    if (i + i_3_ > is.length
		| ((i ^ 0xffffffff) > -1
		   | (is == null | (a ^ 0xffffffffffffffffL) == -1L))
		| (i_2_ ^ 0xffffffff) > -1 | b < i_3_ + i_2_)
		throw new RuntimeException();
	    put(a, is, i, i_2_, i_3_);
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    public final int getSize() {
	try {
	    return b;
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    protected final void a(long l, int i) {
	try {
	    a = l;
	    b = i;
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    private final native void put(long l, byte[] is, int i, int i_4_,
				  int i_5_);
}
