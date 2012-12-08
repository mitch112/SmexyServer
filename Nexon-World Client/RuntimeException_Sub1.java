/* RuntimeException_Sub1 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class RuntimeException_Sub1 extends RuntimeException
{
    Throwable aThrowable3199;
    static int[] anIntArray3200 = new int[1];
    static int anInt3201;
    String aString3202;
    static Class111 aClass111_3203;
    static Class79 aClass79_3204;
    static int anInt3205 = -1;
    
    static final void method4010(int i, int i_0_, int i_1_, int i_2_, int i_3_,
				 int i_4_) {
	do {
	    try {
		if ((Class218.anInt1635 ^ 0xffffffff) <= (i_2_ ^ 0xffffffff)
		    && i_0_ >= Class98_Sub10_Sub38.anInt5753) {
		    boolean bool;
		    if ((Class76_Sub8.anInt3778 ^ 0xffffffff)
			< (i_1_ ^ 0xffffffff)) {
			bool = false;
			i_1_ = Class76_Sub8.anInt3778;
		    } else if (Class3.anInt77 >= i_1_)
			bool = true;
		    else {
			i_1_ = Class3.anInt77;
			bool = false;
		    }
		    boolean bool_5_;
		    if (i_3_ < Class76_Sub8.anInt3778) {
			bool_5_ = false;
			i_3_ = Class76_Sub8.anInt3778;
		    } else if (i_3_ <= Class3.anInt77)
			bool_5_ = true;
		    else {
			i_3_ = Class3.anInt77;
			bool_5_ = false;
		    }
		    if (i_2_ < Class98_Sub10_Sub38.anInt5753)
			i_2_ = Class98_Sub10_Sub38.anInt5753;
		    else
			Class333.method3761(i_4_,
					    Class97.anIntArrayArray814[i_2_++],
					    i_1_, i_3_, (byte) 113);
		    if ((i_0_ ^ 0xffffffff)
			< (Class218.anInt1635 ^ 0xffffffff))
			i_0_ = Class218.anInt1635;
		    else
			Class333.method3761(i_4_,
					    Class97.anIntArrayArray814[i_0_--],
					    i_1_, i_3_, (byte) 26);
		    if (bool && bool_5_) {
			for (int i_6_ = i_2_; i_0_ >= i_6_; i_6_++) {
			    int[] is = Class97.anIntArrayArray814[i_6_];
			    is[i_1_] = is[i_3_] = i_4_;
			}
		    } else if (!bool) {
			if (bool_5_) {
			    for (int i_7_ = i_2_; i_7_ <= i_0_; i_7_++)
				Class97.anIntArrayArray814[i_7_][i_3_] = i_4_;
			}
		    } else {
			for (int i_8_ = i_2_; i_8_ <= i_0_; i_8_++)
			    Class97.anIntArrayArray814[i_8_][i_1_] = i_4_;
		    }
		}
		if (i == -31085)
		    break;
		method4012(false);
	    } catch (RuntimeException runtimeexception) {
		throw Class64_Sub27.method667(runtimeexception,
					      ("ru.B(" + i + ',' + i_0_ + ','
					       + i_1_ + ',' + i_2_ + ',' + i_3_
					       + ',' + i_4_ + ')'));
	    }
	    break;
	} while (false);
    }
    
    static final void method4011(int i) {
	try {
	    if ((Class98_Sub10_Sub6.anInt5570 ^ 0xffffffff) <= -1) {
		long l = Class343.method3819(-47);
		Class98_Sub10_Sub6.anInt5570
		    -= -Class98_Sub46_Sub12.aLong6035 + l;
		do {
		    if (Class98_Sub10_Sub6.anInt5570 <= 0) {
			Class98_Sub46_Sub6.anInt5979
			    = ((Class28) aa.aClass28_50).anInt290;
			Class159.aFloat1254
			    = ((Class28) aa.aClass28_50).aFloat281;
			Class215.aFloat1613
			    = ((Class28) aa.aClass28_50).aFloat289;
			Class263.anInt1965
			    = ((Class28) aa.aClass28_50).anInt283;
			Class141.aFloat1150
			    = ((Class28) aa.aClass28_50).aFloat288;
			Class98_Sub10_Sub6.anInt5570 = -1;
			Class284_Sub1_Sub2.anInt6192
			    = ((Class28) aa.aClass28_50).anInt285;
			Class46.aFloat388
			    = ((Class28) aa.aClass28_50).aFloat293;
			Class98_Sub46_Sub4.aClass48_5962
			    = ((Class28) aa.aClass28_50).aClass48_287;
			Class260.aFloat3260
			    = ((Class28) aa.aClass28_50).aFloat295;
			Class97.aFloat831
			    = ((Class28) aa.aClass28_50).aFloat291;
			if (!client.aBoolean3553)
			    break;
		    }
		    int i_9_ = ((Class98_Sub10_Sub6.anInt5570 << -869608184)
				/ Class287.anInt2196);
		    int i_10_ = -i_9_ + 255;
		    float f = (float) i_9_ / 255.0F;
		    float f_11_ = 1.0F - f;
		    Class98_Sub46_Sub6.anInt5979
			= ((0xff0000
			    & (i_9_ * (Class98_Sub28_Sub1.anInt5811 & 0xff00)
			       - -(i_10_ * (((Class28) aa.aClass28_50).anInt290
					    & 0xff00))))
			   + ((i_10_ * (0xff00ff
					& ((Class28) aa.aClass28_50).anInt290)
			       + ((Class98_Sub28_Sub1.anInt5811 & 0xff00ff)
				  * i_9_))
			      & ~0xff00ff)) >>> -1850804568;
		    Class46.aFloat388
			= (f_11_ * (-IOException_Sub1.aFloat31
				    + ((Class28) aa.aClass28_50).aFloat293)
			   + IOException_Sub1.aFloat31);
		    Class215.aFloat1613
			= (Class3.aFloat78
			   + f_11_ * (((Class28) aa.aClass28_50).aFloat289
				      - Class3.aFloat78));
		    Class97.aFloat831
			= (Class157.aFloat1249
			   + f_11_ * (-Class157.aFloat1249
				      + ((Class28) aa.aClass28_50).aFloat291));
		    Class260.aFloat3260
			= ((((Class28) aa.aClass28_50).aFloat295
			    - Class346.aFloat2900) * f_11_
			   + Class346.aFloat2900);
		    Class159.aFloat1254
			= ((-Class135.aFloat1053
			    + ((Class28) aa.aClass28_50).aFloat281) * f_11_
			   + Class135.aFloat1053);
		    Class284_Sub1_Sub2.anInt6192
			= (((i_9_ * (Class162.anInt1271 & 0xff00)
			     - -(i_10_
				 * (0xff00
				    & ((Class28) aa.aClass28_50).anInt285)))
			    & 0xff0000)
			   + (~0xff00ff
			      & ((Class162.anInt1271 & 0xff00ff) * i_9_
				 + (((Class28) aa.aClass28_50).anInt285
				    & 0xff00ff) * i_10_))) >>> 1466852232;
		    Class263.anInt1965
			= ((i_9_ * Class98_Sub12.anInt3872
			    + ((Class28) aa.aClass28_50).anInt283 * i_10_)
			   >> 40165512);
		    Class141.aFloat1150
			= (Class234.aFloat1749
			   + (((Class28) aa.aClass28_50).aFloat288
			      - Class234.aFloat1749) * f_11_);
		    if (((Class28) aa.aClass28_50).aClass48_287
			!= Class140.aClass48_3245)
			Class98_Sub46_Sub4.aClass48_5962
			    = (Class98_Sub37.aHa4185.method1769
			       (Class140.aClass48_3245,
				((Class28) aa.aClass28_50).aClass48_287, f_11_,
				Class98_Sub46_Sub4.aClass48_5962));
		} while (false);
		Class98_Sub46_Sub12.aLong6035 = l;
	    }
	    if (i > -36)
		method4010(24, 114, 12, -24, 33, -8);
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception, "ru.A(" + i + ')');
	}
    }
    
    RuntimeException_Sub1(Throwable throwable, String string) {
	try {
	    ((RuntimeException_Sub1) this).aThrowable3199 = throwable;
	    ((RuntimeException_Sub1) this).aString3202 = string;
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    static final int method4012(boolean bool) {
	try {
	    if (bool != true)
		method4010(46, -81, -49, 16, 90, -120);
	    return Class140.aClass47_3241.method450((byte) 3);
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  "ru.D(" + bool + ')');
	}
    }
    
    public static void method4013(int i) {
	try {
	    anIntArray3200 = null;
	    aClass111_3203 = null;
	    if (i == 16711935)
		aClass79_3204 = null;
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    static {
	aClass79_3204 = new Class79(64);
    }
}
