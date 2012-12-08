/* Stream - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package jaclib.memory;

public final class Stream
{
    private Buffer a;
    private int b;
    private byte[] c;
    private int d;
    private int e;
    
    public final void a(float f) {
	try {
	    if (b - -3 >= c.length)
		c();
	    int i = floatToRawIntBits(f);
	    c[b++] = (byte) i;
	    c[b++] = (byte) (i >> -1571973048);
	    c[b++] = (byte) (i >> -867554672);
	    c[b++] = (byte) (i >> -675913608);
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    public final void a(int i) {
	try {
	    if (b + 3 >= c.length)
		c();
	    c[b++] = (byte) (i >> -142119792);
	    c[b++] = (byte) (i >> -1412802328);
	    c[b++] = (byte) i;
	    c[b++] = (byte) (i >> -1806138600);
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    public final void b(int i) {
	try {
	    c();
	    e = i;
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    public final void b(float f) {
	try {
	    if ((b - -3 ^ 0xffffffff) <= (c.length ^ 0xffffffff))
		c();
	    int i = floatToRawIntBits(f);
	    c[b++] = (byte) (i >> -804863784);
	    c[b++] = (byte) (i >> 1242398928);
	    c[b++] = (byte) (i >> -2034164664);
	    c[b++] = (byte) i;
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    public final void a(int i, int i_0_, int i_1_, int i_2_) {
	try {
	    if (c.length <= b + 3)
		c();
	    c[b++] = (byte) i_1_;
	    c[b++] = (byte) i_0_;
	    c[b++] = (byte) i;
	    c[b++] = (byte) i_2_;
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    public Stream(Buffer buffer, int i, int i_3_) {
	this(buffer.getSize() >= 4096 ? 4096 : buffer.getSize());
	try {
	    a(buffer, i, i_3_);
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    public static final boolean a() {
	try {
	    if ((getLSB(-65536) ^ 0xffffffff) != 0)
		return false;
	    return true;
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    public final int b() {
	try {
	    return b + e;
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    public final void b(int i, int i_4_, int i_5_, int i_6_) {
	try {
	    if (3 + b >= c.length)
		c();
	    c[b++] = (byte) i;
	    c[b++] = (byte) i_4_;
	    c[b++] = (byte) i_5_;
	    c[b++] = (byte) i_6_;
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    public final void a(Buffer buffer) {
	try {
	    a(buffer, 0, buffer.getSize());
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    private static final native byte getLSB(int i);
    
    private final void a(Buffer buffer, int i, int i_7_) {
	try {
	    c();
	    e = i;
	    d = i_7_ + i;
	    a = buffer;
	    if ((d ^ 0xffffffff) < (buffer.getSize() ^ 0xffffffff))
		throw new RuntimeException();
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    public final void c(int i) {
	try {
	    if (c.length <= 1 + b)
		c();
	    c[b++] = (byte) (i >> 446021192);
	    c[b++] = (byte) i;
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    public final void d(int i) {
	try {
	    if (1 + b >= c.length)
		c();
	    c[b++] = (byte) i;
	    c[b++] = (byte) (i >> 1731009608);
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    public final void e(int i) {
	try {
	    if (b >= c.length)
		c();
	    c[b++] = (byte) i;
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    public Stream() {
	this(4096);
    }
    
    public final void f(int i) {
	try {
	    if (3 + b >= c.length)
		c();
	    c[b++] = (byte) i;
	    c[b++] = (byte) (i >> -1554826648);
	    c[b++] = (byte) (i >> 153807472);
	    c[b++] = (byte) (i >> 1864436248);
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    public final void c() {
	do {
	    try {
		if ((b ^ 0xffffffff) >= -1)
		    break;
		if ((b + e ^ 0xffffffff) < (d ^ 0xffffffff))
		    throw new RuntimeException();
		a.a(c, 0, e, b);
		e += b;
		b = 0;
	    } catch (RuntimeException runtimeexception) {
		throw runtimeexception;
	    }
	    break;
	} while (false);
    }
    
    public Stream(Buffer buffer) {
	this(buffer, 0, buffer.getSize());
    }
    
    public static final native int floatToRawIntBits(float f);
    
    private Stream(int i) {
	try {
	    c = new byte[i];
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
}
