/* Class98_Sub5_Sub2 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class Class98_Sub5_Sub2 extends Class98_Sub5
{
    static boolean aBoolean5535;
    static int anInt5536 = -1;
    static double aDouble5537;
    
    static final String method968(int i, String[] strings, int i_0_,
				  int i_1_) {
	try {
	    if ((i ^ 0xffffffff) == -1)
		return "";
	    if (i == 1) {
		String string = strings[i_0_];
		if (string == null)
		    return "null";
		return string.toString();
	    }
	    int i_2_ = i_0_ + i;
	    int i_3_ = 0;
	    for (int i_4_ = i_0_; (i_4_ ^ 0xffffffff) > (i_2_ ^ 0xffffffff);
		 i_4_++) {
		String string = strings[i_4_];
		if (string == null)
		    i_3_ += 4;
		else
		    i_3_ += string.length();
	    }
	    StringBuffer stringbuffer = new StringBuffer(i_3_);
	    for (int i_5_ = i_0_; i_2_ > i_5_; i_5_++) {
		String string = strings[i_5_];
		if (string == null)
		    stringbuffer.append("null");
		else
		    stringbuffer.append(string);
	    }
	    if (i_1_ != -17120)
		method970(-109, null, -36, -75);
	    return stringbuffer.toString();
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  ("im.M(" + i + ','
					   + (strings != null ? "{...}"
					      : "null")
					   + ',' + i_0_ + ',' + i_1_ + ')'));
	}
    }
    
    static final boolean method969(int i, int i_6_, int i_7_) {
	try {
	    if (i_7_ < 70)
		aDouble5537 = -0.3046933013113084;
	    if ((0x84080 & i_6_) == 0)
		return false;
	    return true;
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  ("im.K(" + i + ',' + i_6_ + ','
					   + i_7_ + ')'));
	}
    }
    
    static final void method970(int i, Class293 class293, int i_8_, int i_9_) {
	try {
	    if (class293 != null) {
		if (i_9_ != -6838)
		    method968(67, null, -92, 84);
		if (((Class293) class293).anObjectArray2257 != null) {
		    Class98_Sub21 class98_sub21 = new Class98_Sub21();
		    ((Class98_Sub21) class98_sub21).aClass293_3986 = class293;
		    ((Class98_Sub21) class98_sub21).anObjectArray3981
			= ((Class293) class293).anObjectArray2257;
		    Class247.method3144(class98_sub21);
		}
		Class98_Sub10_Sub9.aBoolean5585 = true;
		Class98_Sub46_Sub1.anInt5945 = i;
		Class98_Sub4.anInt3826 = i_8_;
		Class187.anInt1450 = ((Class293) class293).anInt2248;
		Class21_Sub2.anInt5387 = ((Class293) class293).anInt2318;
		Class310.anInt2652 = ((Class293) class293).anInt2300;
		Class376.anInt3173 = ((Class293) class293).anInt2302;
		Class336.anInt2823 = ((Class293) class293).anInt2309;
		Class341.method3812(i_9_ ^ ~0x1ab4, class293);
	    }
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  ("im.L(" + i + ','
					   + (class293 != null ? "{...}"
					      : "null")
					   + ',' + i_8_ + ',' + i_9_ + ')'));
	}
    }
    
    final void method959(float f, int i) {
	try {
	    if (i < 12)
		method970(-34, null, 53, 96);
	    ((Class98_Sub5) this).aFloat3832 = f;
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  "im.D(" + f + ',' + i + ')');
	}
    }
    
    Class98_Sub5_Sub2(int i, int i_10_, int i_11_, int i_12_, int i_13_,
		      float f) {
	super(i, i_10_, i_11_, i_12_, i_13_, f);
    }
    
    final void method955(int i, byte i_14_, int i_15_, int i_16_) {
	try {
	    if (i_14_ >= -120)
		method970(-97, null, 25, 43);
	    ((Class98_Sub5) this).anInt3833 = i_15_;
	    ((Class98_Sub5) this).anInt3830 = i_16_;
	    ((Class98_Sub5) this).anInt3834 = i;
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  ("im.A(" + i + ',' + i_14_ + ','
					   + i_15_ + ',' + i_16_ + ')'));
	}
    }
}
