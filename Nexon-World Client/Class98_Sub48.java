/* Class98_Sub48 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class Class98_Sub48 extends Class98
{
    static int anInt4277 = 0;
    int anInt4278;
    static int anInt4279;
    static int anInt4280;
    static int anInt4281 = 0;
    int anInt4282;
    
    static final int method1660(int i) {
	try {
	    if (i <= 21)
		return 2;
	    return 16;
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  "vfa.B(" + i + ')');
	}
    }
    
    static final void method1661(int i, int i_0_, Class39 class39, byte i_1_,
				 float f, float f_2_, int i_3_, float f_4_,
				 int i_5_, int i_6_, float f_7_, byte[] is,
				 float f_8_) {
	try {
	    for (int i_9_ = 0; i_9_ < i_0_; i_9_++) {
		Class98_Sub10_Sub5_Sub1.method1018(f_4_, false, i, f_2_, i_0_,
						   f, class39, i_6_, f_7_,
						   i_3_, is, f_8_, i_5_, i_9_);
		i += i_5_ * i_3_;
	    }
	    if (i_1_ > -14)
		anInt4281 = 28;
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  ("vfa.A(" + i + ',' + i_0_ + ','
					   + (class39 != null ? "{...}"
					      : "null")
					   + ',' + i_1_ + ',' + f + ',' + f_2_
					   + ',' + i_3_ + ',' + f_4_ + ','
					   + i_5_ + ',' + i_6_ + ',' + f_7_
					   + ','
					   + (is != null ? "{...}" : "null")
					   + ',' + f_8_ + ')'));
	}
    }
    
    Class98_Sub48(int i, int i_10_) {
	try {
	    ((Class98_Sub48) this).anInt4278 = i;
	    ((Class98_Sub48) this).anInt4282 = i_10_;
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  ("vfa.<init>(" + i + ',' + i_10_
					   + ')'));
	}
    }
}
