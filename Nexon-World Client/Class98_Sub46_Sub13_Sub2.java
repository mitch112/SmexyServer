/* Class98_Sub46_Sub13_Sub2 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class Class98_Sub46_Sub13_Sub2 extends Class98_Sub46_Sub13
{
    static int anInt6309;
    int anInt6310;
    static int[][][] anIntArrayArrayArray6311;
    Class17 aClass17_6312;
    byte[] aByteArray6313;
    
    static final int method1598(int i, int i_0_) {
	try {
	    if (i_0_ != -22645)
		method1601(41, -108);
	    return i >>> 1951350663;
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  "rba.E(" + i + ',' + i_0_ + ')');
	}
    }
    
    public static void method1599(int i) {
	try {
	    if (i >= 100)
		anIntArrayArrayArray6311 = null;
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  "rba.F(" + i + ')');
	}
    }
    
    final int method1590(int i) {
	try {
	    if (i != 100)
		return -47;
	    if (((Class98_Sub46_Sub13) this).aBoolean6038)
		return 0;
	    return 100;
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  "rba.B(" + i + ')');
	}
    }
    
    static final int method1600(byte i) {
	try {
	    if (i >= -6)
		method1598(73, -45);
	    return Class337_Sub1.anInt5497;
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  "rba.A(" + i + ')');
	}
    }
    
    static final Class98_Sub46_Sub4 method1601(int i, int i_1_) {
	try {
	    Class98_Sub46_Sub4 class98_sub46_sub4
		= ((Class98_Sub46_Sub4)
		   Class38.aClass100_357.method1694((byte) 117, (long) i));
	    if (class98_sub46_sub4 != null)
		return class98_sub46_sub4;
	    byte[] is = Class52.aClass207_3494.method2745(0, i, false);
	    if (i_1_ != 100)
		method1599(-28);
	    if (is == null || is.length <= 1)
		return null;
	    try {
		class98_sub46_sub4 = Class22.method280(is, 0);
	    } catch (Exception exception) {
		throw new RuntimeException(exception.getMessage() + " S: "
					   + i);
	    }
	    Class38.aClass100_357.method1695(26404, class98_sub46_sub4,
					     (long) i);
	    return class98_sub46_sub4;
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  "rba.D(" + i + ',' + i_1_ + ')');
	}
    }
    
    final byte[] method1591(int i) {
	try {
	    if (i < 5)
		((Class98_Sub46_Sub13_Sub2) this).aClass17_6312 = null;
	    if (((Class98_Sub46_Sub13) this).aBoolean6038)
		throw new RuntimeException();
	    return ((Class98_Sub46_Sub13_Sub2) this).aByteArray6313;
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  "rba.C(" + i + ')');
	}
    }
    
    public Class98_Sub46_Sub13_Sub2() {
	/* empty */
    }
}
