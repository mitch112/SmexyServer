/* Class98_Sub15 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class Class98_Sub15 extends Class98
{
    static int anInt3915;
    static float[] aFloatArray3916 = new float[4];
    String aString3917;
    
    static final void method1144(int i, int i_0_, boolean bool, int i_1_,
				 Class207 class207, int i_2_, long l) {
	try {
	    if (i_0_ != 4)
		anInt3915 = 126;
	    Class64_Sub13.method604(0, bool, false, class207, i_1_, i, i_2_,
				    l);
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  ("gia.B(" + i + ',' + i_0_ + ','
					   + bool + ',' + i_1_ + ','
					   + (class207 != null ? "{...}"
					      : "null")
					   + ',' + i_2_ + ',' + l + ')'));
	}
    }
    
    public static void method1145(int i) {
	try {
	    aFloatArray3916 = null;
	    int i_3_ = -121 / ((2 - i) / 63);
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  "gia.A(" + i + ')');
	}
    }
    
    public Class98_Sub15() {
	/* empty */
    }
    
    Class98_Sub15(String string) {
	try {
	    ((Class98_Sub15) this).aString3917 = string;
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  "gia.<init>(" + (string != null
							   ? "{...}"
							   : "null") + ')');
	}
    }
}
