/* n - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class n extends Class43 implements Interface9
{
    long nativeid;
    
    private final native void PA(char c, int i, int i_0_, int i_1_,
				 boolean bool, aa var_aa, int i_2_, int i_3_);
    
    public final native void w(boolean bool);
    
    final native void fa(char c, int i, int i_4_, int i_5_, boolean bool);
    
    private final native void S(oa var_oa, ya var_ya, byte[][] is, int[] is_6_,
				int[] is_7_, int[] is_8_, int[] is_9_,
				int[] is_10_);
    
    n(oa var_oa, ya var_ya, Class197 class197, Class324[] class324s,
      Class332[] class332s) {
	super(var_oa, class197);
	byte[][] is = new byte[class324s.length][];
	int[] is_11_ = new int[class324s.length];
	int[] is_12_ = new int[class324s.length];
	int[] is_13_ = new int[class324s.length];
	int[] is_14_ = new int[class324s.length];
	for (int i = 0; i < class324s.length; i++) {
	    is[i] = ((Class324) class324s[i]).aByteArray2717;
	    is_11_[i] = ((Class324) class324s[i]).anInt2722;
	    is_12_[i] = ((Class324) class324s[i]).anInt2720;
	    is_13_[i] = ((Class324) class324s[i]).anInt2725;
	    is_14_[i] = ((Class324) class324s[i]).anInt2721;
	}
	S(var_oa, var_ya, is, ((Class324) class324s[0]).anIntArray2718, is_11_,
	  is_12_, is_13_, is_14_);
    }
    
    final void method409(char c, int i, int i_15_, int i_16_, boolean bool,
			 aa var_aa, int i_17_, int i_18_) {
	PA(c, i, i_15_, i_16_, bool, var_aa, i_17_, i_18_);
    }
    
    protected final void finalize() {
	if (((n) this).nativeid != 0L)
	    Class192.method2654(false, this);
    }
}
