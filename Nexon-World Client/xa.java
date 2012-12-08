/* xa - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class xa implements Interface13, Interface9
{
    long nativeid = 0L;
    
    private final native void va(long l, boolean bool);
    
    protected final void finalize() {
	if (((xa) this).nativeid != 0L)
	    Class192.method2654(false, this);
    }
    
    public final void w(boolean bool) {
	va(((xa) this).nativeid, bool);
    }
    
    private final native void r(int i, int i_0_);
    
    xa(int i, int i_1_) {
	r(i, i_1_);
    }
}
