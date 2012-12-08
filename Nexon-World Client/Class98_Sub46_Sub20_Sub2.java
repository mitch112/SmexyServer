/* Class98_Sub46_Sub20_Sub2 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class Class98_Sub46_Sub20_Sub2 extends Class98_Sub46_Sub20
{
    private Object anObject6315;
    static Class218[] aClass218Array6316 = new Class218[5];
    static int anInt6317;
    static int[] anIntArray6318;
    static int anInt6319;
    
    final Object method1635(int i) {
	try {
	    int i_0_ = 111 / ((i - -54) / 41);
	    return anObject6315;
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception, "to.A(" + i + ')');
	}
    }
    
    final boolean method1638(int i) {
	try {
	    if (i != 896)
		return false;
	    return false;
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception, "to.B(" + i + ')');
	}
    }
    
    public static void method1640(byte i) {
	try {
	    aClass218Array6316 = null;
	    if (i > 40)
		anIntArray6318 = null;
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception, "to.F(" + i + ')');
	}
    }
    
    Class98_Sub46_Sub20_Sub2(Interface20 interface20, Object object, int i) {
	super(interface20, i);
	try {
	    anObject6315 = object;
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  ("to.<init>("
					   + (interface20 != null ? "{...}"
					      : "null")
					   + ','
					   + (object != null ? "{...}"
					      : "null")
					   + ',' + i + ')'));
	}
    }
    
    static {
	for (int i = 0; i < aClass218Array6316.length; i++)
	    aClass218Array6316[i] = new Class218();
	anIntArray6318
	    = new int[] { 2, 1, 1, 1, 2, 2, 2, 1, 3, 3, 3, 2, 0, 4, 0 };
    }
}
