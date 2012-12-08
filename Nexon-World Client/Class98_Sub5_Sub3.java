/* Class98_Sub5_Sub3 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import java.io.IOException;

final class Class98_Sub5_Sub3 extends Class98_Sub5
{
    static int anInt5538;
    static boolean aBoolean5539 = false;
    static Class111 aClass111_5540;
    
    final void method959(float f, int i) {
	do {
	    try {
		((Class98_Sub5) this).aFloat3832 = f;
		if (i > 12)
		    break;
		aClass111_5540 = null;
	    } catch (RuntimeException runtimeexception) {
		throw Class64_Sub27.method667(runtimeexception,
					      "lh.D(" + f + ',' + i + ')');
	    }
	    break;
	} while (false);
    }
    
    static final int method971(int i, int i_0_, int i_1_, int i_2_) {
	try {
	    if (i_2_ > -39)
		return -27;
	    int i_3_ = i / i_1_;
	    int i_4_ = i & i_1_ - 1;
	    int i_5_ = i_0_ / i_1_;
	    int i_6_ = i_0_ & i_1_ - 1;
	    int i_7_ = Class156_Sub1.method2499(19, i_5_, i_3_);
	    int i_8_ = Class156_Sub1.method2499(-117, i_5_, i_3_ + 1);
	    int i_9_ = Class156_Sub1.method2499(84, i_5_ + 1, i_3_);
	    int i_10_ = Class156_Sub1.method2499(19, 1 + i_5_, i_3_ + 1);
	    int i_11_
		= Class98_Sub21.method1180(i_1_, (byte) -38, i_7_, i_4_, i_8_);
	    int i_12_ = Class98_Sub21.method1180(i_1_, (byte) 107, i_9_, i_4_,
						 i_10_);
	    return Class98_Sub21.method1180(i_1_, (byte) 104, i_11_, i_6_,
					    i_12_);
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  ("lh.L(" + i + ',' + i_0_ + ','
					   + i_1_ + ',' + i_2_ + ')'));
	}
    }
    
    static final Class98_Sub27 method972(int i) {
	try {
	    int i_13_ = 93 % ((i - -68) / 52);
	    Class356 class356 = null;
	    Class98_Sub27 class98_sub27
		= new Class98_Sub27(Class4.aClass279_86, 0);
	    try {
		Class143 class143
		    = Class98_Sub43_Sub2.aClass88_5907.method875("", true,
								 21516);
		while ((class143.anInt1163 ^ 0xffffffff) == -1)
		    Class246_Sub7.method3131(0, 1L);
		if (class143.anInt1163 == 1) {
		    class356 = (Class356) class143.anObject1162;
		    byte[] is
			= new byte[(int) class356.method3878((byte) -112)];
		    int i_14_;
		    for (int i_15_ = 0;
			 (is.length ^ 0xffffffff) < (i_15_ ^ 0xffffffff);
			 i_15_ += i_14_) {
			i_14_ = class356.method3879(is.length - i_15_,
						    (byte) -26, i_15_, is);
			if (i_14_ == -1)
			    throw new IOException("EOF");
		    }
		    class98_sub27 = new Class98_Sub27(new Class98_Sub22(is),
						      Class4.aClass279_86, 0);
		}
	    } catch (Exception exception) {
		/* empty */
	    }
	    try {
		if (class356 != null)
		    class356.method3880(true);
	    } catch (Exception exception) {
		/* empty */
	    }
	    return class98_sub27;
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception, "lh.K(" + i + ')');
	}
    }
    
    Class98_Sub5_Sub3(int i, int i_16_, int i_17_, int i_18_, int i_19_,
		      float f) {
	super(i, i_16_, i_17_, i_18_, i_19_, f);
    }
    
    public static void method973(int i) {
	do {
	    try {
		aClass111_5540 = null;
		if (i == 1)
		    break;
		aBoolean5539 = false;
	    } catch (RuntimeException runtimeexception) {
		throw Class64_Sub27.method667(runtimeexception,
					      "lh.N(" + i + ')');
	    }
	    break;
	} while (false);
    }
    
    static final boolean method974(int i, byte i_20_) {
	try {
	    if (i_20_ > -36)
		method972(-63);
	    if (i != 7 && (i ^ 0xffffffff) != -10)
		return false;
	    return true;
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  "lh.M(" + i + ',' + i_20_ + ')');
	}
    }
    
    final void method955(int i, byte i_21_, int i_22_, int i_23_) {
	try {
	    ((Class98_Sub5) this).anInt3834 = i;
	    ((Class98_Sub5) this).anInt3833 = i_22_;
	    if (i_21_ > -120)
		method972(-17);
	    ((Class98_Sub5) this).anInt3830 = i_23_;
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  ("lh.A(" + i + ',' + i_21_ + ','
					   + i_22_ + ',' + i_23_ + ')'));
	}
    }
    
    static {
	anInt5538 = 1;
    }
}
