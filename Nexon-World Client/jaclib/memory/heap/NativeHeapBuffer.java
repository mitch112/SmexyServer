/* NativeHeapBuffer - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package jaclib.memory.heap;
import jaclib.memory.Buffer;
import jaclib.memory.Source;

public final class NativeHeapBuffer implements Buffer, Source
{
    private NativeHeap a;
    private int b;
    public int c;
    private boolean d = true;
    
    private final synchronized boolean a() {
	try {
	    if (!a.a() || !d)
		return false;
	    return true;
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    private final synchronized void b() {
	try {
	    if (a())
		a.deallocateBuffer(b);
	    d = false;
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    public final int getSize() {
	try {
	    return c;
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    protected final synchronized void finalize() throws Throwable {
	try {
	    super.finalize();
	    b();
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    public final synchronized void a(byte[] is, int i, int i_0_, int i_1_) {
	try {
	    if (!a() | is == null | i < 0 | is.length < i - -i_1_ | i_0_ < 0
		| (c ^ 0xffffffff) > (i_1_ + i_0_ ^ 0xffffffff))
		throw new RuntimeException();
	    a.put(b, is, i, i_0_, i_1_);
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    public final long getAddress() {
	try {
	    return a.getBufferAddress(b);
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    NativeHeapBuffer(NativeHeap nativeheap, int i, int i_2_) {
	try {
	    a = nativeheap;
	    c = i_2_;
	    b = i;
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
}
