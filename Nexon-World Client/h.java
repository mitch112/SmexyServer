/* h - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class h extends Class43 implements Interface9
{
    long nativeid;
    
    final native void fa(char c, int i, int i_0_, int i_1_, boolean bool);
    
    private final native void JA(oa var_oa, ya var_ya, byte[][] is,
				 int[] is_2_, int[] is_3_, int[] is_4_,
				 int[] is_5_);
    
    public final native void w(boolean bool);
    
    private final native void NA(char c, int i, int i_6_, int i_7_,
				 boolean bool, aa var_aa, int i_8_, int i_9_);
    
    final void method409(char c, int i, int i_10_, int i_11_, boolean bool,
			 aa var_aa, int i_12_, int i_13_) {
	NA(c, i, i_10_, i_11_, bool, var_aa, i_12_, i_13_);
    }
    
    h(oa var_oa, ya var_ya, Class197 class197, Class324[] class324s,
      Class332[] class332s) {
	super(var_oa, class197);
	byte[][] is = new byte[class324s.length][];
	int[] is_14_ = new int[class324s.length];
	int[] is_15_ = new int[class324s.length];
	int[] is_16_ = new int[class324s.length];
	int[] is_17_ = new int[class324s.length];
	for (int i = 0; i < class324s.length; i++) {
	    is[i] = ((Class324) class324s[i]).aByteArray2717;
	    is_14_[i] = ((Class324) class324s[i]).anInt2722;
	    is_15_[i] = ((Class324) class324s[i]).anInt2720;
	    is_16_[i] = ((Class324) class324s[i]).anInt2725;
	    is_17_[i] = ((Class324) class324s[i]).anInt2721;
	}
	JA(var_oa, var_ya, is, is_14_, is_15_, is_16_, is_17_);
    }
    
    protected final void finalize() {
	if (((h) this).nativeid != 0L)
	    Class192.method2654(false, this);
    }
}
