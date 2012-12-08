/* Class98_Sub5 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

abstract class Class98_Sub5 extends Class98
{
    int anInt3830;
    private int anInt3831;
    float aFloat3832;
    int anInt3833;
    int anInt3834;
    static Class157 aClass157_3835 = new Class157();
    private int anInt3836;
    static String aString3837 = "";
    
    final int method954(int i) {
	try {
	    if (i != 7019)
		method957(70);
	    return ((Class98_Sub5) this).anInt3833;
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  "cba.F(" + i + ')');
	}
    }
    
    abstract void method955(int i, byte i_0_, int i_1_, int i_2_);
    
    final float method956(boolean bool) {
	try {
	    if (bool != false)
		return -0.407301F;
	    return ((Class98_Sub5) this).aFloat3832;
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  "cba.G(" + bool + ')');
	}
    }
    
    public static void method957(int i) {
	try {
	    if (i == -3509) {
		aString3837 = null;
		aClass157_3835 = null;
	    }
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  "cba.I(" + i + ')');
	}
    }
    
    final int method958(int i) {
	try {
	    int i_3_ = 10 % ((66 - i) / 58);
	    return anInt3836;
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  "cba.B(" + i + ')');
	}
    }
    
    abstract void method959(float f, int i);
    
    static final boolean method960(int i, int i_4_, int i_5_, int i_6_,
				   int i_7_, int i_8_, int i_9_, int i_10_,
				   int i_11_) {
	try {
	    if ((i_8_ ^ 0xffffffff) <= (i - -i_4_ ^ 0xffffffff)
		|| (i ^ 0xffffffff) <= (i_11_ + i_8_ ^ 0xffffffff))
		return false;
	    if (i_7_ + i_9_ <= i_6_ || i_9_ >= i_6_ + i_10_)
		return false;
	    if (i_5_ >= -100)
		return true;
	    return true;
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  ("cba.C(" + i + ',' + i_4_ + ','
					   + i_5_ + ',' + i_6_ + ',' + i_7_
					   + ',' + i_8_ + ',' + i_9_ + ','
					   + i_10_ + ',' + i_11_ + ')'));
	}
    }
    
    final int method961(byte i) {
	try {
	    if (i != -78)
		aClass157_3835 = null;
	    return anInt3831;
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  "cba.J(" + i + ')');
	}
    }
    
    final int method962(int i) {
	try {
	    if (i != 28699)
		anInt3831 = -23;
	    return ((Class98_Sub5) this).anInt3834;
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  "cba.H(" + i + ')');
	}
    }
    
    final int method963(byte i) {
	try {
	    if (i < 68)
		method960(-59, -92, -21, -124, 59, -109, 69, 61, -32);
	    return ((Class98_Sub5) this).anInt3830;
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  "cba.E(" + i + ')');
	}
    }
    
    Class98_Sub5(int i, int i_12_, int i_13_, int i_14_, int i_15_, float f) {
	try {
	    anInt3831 = i_15_;
	    ((Class98_Sub5) this).anInt3833 = i;
	    anInt3836 = i_14_;
	    ((Class98_Sub5) this).aFloat3832 = f;
	    ((Class98_Sub5) this).anInt3834 = i_13_;
	    ((Class98_Sub5) this).anInt3830 = i_12_;
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  ("cba.<init>(" + i + ',' + i_12_
					   + ',' + i_13_ + ',' + i_14_ + ','
					   + i_15_ + ',' + f + ')'));
	}
    }
}
