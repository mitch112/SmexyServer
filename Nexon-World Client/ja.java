/* ja - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class ja extends Class111 implements Interface9
{
    long nativeid;
    
    final void method2099(int i, int i_0_, int i_1_, int[] is) {
	XA(((ja) this).nativeid, i, i_0_, i_1_, is);
    }
    
    final void method2100(int i, int i_2_, int i_3_) {
	FA(((ja) this).nativeid, i, i_2_, i_3_);
    }
    
    private final native void l(long l, long l_4_);
    
    private final native void a(long l, int i, int i_5_, int i_6_);
    
    final void method2107(int i) {
	VA(((ja) this).nativeid, i);
    }
    
    final void method2090(int i) {
	za(((ja) this).nativeid, i);
    }
    
    private final native void XA(long l, int i, int i_7_, int i_8_, int[] is);
    
    private final native void b(long l, int i, int i_9_, int i_10_, int[] is);
    
    private final native void FA(long l, int i, int i_11_, int i_12_);
    
    final void method2093(int i, int i_13_, int i_14_, int i_15_, int i_16_,
			  int i_17_) {
	P(((ja) this).nativeid, i, i_13_, i_14_, i_15_, i_16_, i_17_);
    }
    
    protected final void finalize() {
	if (((ja) this).nativeid != 0L)
	    Class192.method2654(false, this);
    }
    
    final void method2103(int i, int i_18_, int i_19_, int[] is) {
	b(((ja) this).nativeid, i, i_18_, i_19_, is);
    }
    
    final void method2092(Class111 class111) {
	l(((ja) this).nativeid, ((ja) (ja) class111).nativeid);
    }
    
    final void method2101(int i) {
	t(((ja) this).nativeid, i);
    }
    
    private final native void m(long l, int i);
    
    final void method2097(int i) {
	m(((ja) this).nativeid, i);
    }
    
    private final native void AA(long l, boolean bool);
    
    private final native void VA(long l, int i);
    
    final void method2108(int[] is) {
	w(((ja) this).nativeid, is);
    }
    
    private final native void va(long l, int i, int i_20_, int i_21_,
				 int[] is);
    
    final void method2104(int i) {
	NA(((ja) this).nativeid, i);
    }
    
    public final void w(boolean bool) {
	AA(((ja) this).nativeid, bool);
    }
    
    private final native void t(long l, int i);
    
    private final native void NA(long l, int i);
    
    private final native void J(long l, int i);
    
    private final native void la();
    
    private final native void P(long l, int i, int i_22_, int i_23_, int i_24_,
				int i_25_, int i_26_);
    
    final void method2106(int i, int i_27_, int i_28_) {
	a(((ja) this).nativeid, i, i_27_, i_28_);
    }
    
    final Class111 method2102() {
	ja var_ja_29_ = new ja();
	var_ja_29_.method2092(this);
	return var_ja_29_;
    }
    
    private final native void za(long l, int i);
    
    final void method2091() {
	u(((ja) this).nativeid);
    }
    
    final void method2105(int i) {
	J(((ja) this).nativeid, i);
    }
    
    private final native void u(long l);
    
    private final native void w(long l, int[] is);
    
    final void method2096(int i, int i_30_, int i_31_, int[] is) {
	va(((ja) this).nativeid, i, i_30_, i_31_, is);
    }
    
    ja() {
	la();
    }
}
