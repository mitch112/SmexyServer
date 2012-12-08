/* Class69_Sub1 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import jaclib.memory.Buffer;

final class Class69_Sub1 extends Class69 implements Interface2_Impl2
{
    static int anInt5329 = 0;
    static int anInt5330 = -1;
    private Class162 aClass162_5331;
    
    Class69_Sub1(ha_Sub3_Sub2 var_ha_Sub3_Sub2, Class162 class162,
		 boolean bool) {
	super(var_ha_Sub3_Sub2, 34963, bool);
	try {
	    aClass162_5331 = class162;
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  ("ud.<init>("
					   + (var_ha_Sub3_Sub2 != null
					      ? "{...}" : "null")
					   + ','
					   + (class162 != null ? "{...}"
					      : "null")
					   + ',' + bool + ')'));
	}
    }
    
    public final void method72(boolean bool) {
	try {
	    super.method72(bool);
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  "ud.L(" + bool + ')');
	}
    }
    
    public final int method2(int i) {
	try {
	    if (i != 200)
		aClass162_5331 = null;
	    return super.method2(200);
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception, "ud.E(" + i + ')');
	}
    }
    
    public final boolean method79(byte i) {
	try {
	    int i_0_ = 116 % ((-46 - i) / 32);
	    return super.method703((byte) -68,
				   (((ha_Sub3_Sub2)
				     ((Class69) this).aHa_Sub3_Sub2_3217)
				    .aMapBuffer6125));
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception, "ud.N(" + i + ')');
	}
    }
    
    public final Buffer method78(boolean bool, int i) {
	try {
	    if (i > -79)
		anInt5330 = 20;
	    return super.method694(bool, (((ha_Sub3_Sub2)
					   ((Class69) this).aHa_Sub3_Sub2_3217)
					  .aMapBuffer6125), -15793);
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  "ud.O(" + bool + ',' + i + ')');
	}
    }
    
    public final void method76(int i, int i_1_) {
	try {
	    super.method76(((Class162) aClass162_5331).anInt1263 * i, i_1_);
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  "ud.G(" + i + ',' + i_1_ + ')');
	}
    }
    
    public final Class162 method77(int i) {
	try {
	    if (i != -15448)
		method2(120);
	    return aClass162_5331;
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception, "ud.P(" + i + ')');
	}
    }
}
