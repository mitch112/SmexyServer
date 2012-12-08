/* Frame - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package jagtheora.theora;
import jagtheora.misc.SimplePeer;

public class Frame extends SimplePeer
{
    public int[] pixels;
    public int a;
    public int b;
    
    private static final native void init();
    
    public Frame(int i, int i_0_) {
	try {
	    b = i_0_;
	    a = i;
	    pixels = new int[a * b];
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    protected final native void clear();
    
    static {
	init();
    }
}
