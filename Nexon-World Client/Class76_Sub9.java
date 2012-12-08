/* Class76_Sub9 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import jaggl.OpenGL;

final class Class76_Sub9 extends Class76
{
    private boolean aBoolean3782;
    static Thread aThread3783;
    static float[] aFloatArray3784;
    static int[] anIntArray3785 = new int[1];
    static int anInt3786 = 1;
    static Class207 aClass207_3787;
    static boolean aBoolean3788 = false;
    private boolean aBoolean3789;
    private Class195 aClass195_3790;
    static int[] anIntArray3791;
    private Class82 aClass82_3792;
    
    static final String method765(String string, int i, String string_0_,
				  String string_1_) {
	try {
	    if (i != 4185)
		return null;
	    for (int i_2_ = string_1_.indexOf(string_0_);
		 (i_2_ ^ 0xffffffff) != 0;
		 i_2_ = string_1_.indexOf(string_0_, string.length() + i_2_))
		string_1_
		    = (string_1_.substring(0, i_2_) + string
		       + string_1_.substring(i_2_ - -string_0_.length()));
	    return string_1_;
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    static final boolean method766(int i, int i_3_, int i_4_) {
	try {
	    if (i > -84)
		anInt3786 = -19;
	    if ((0x34 & i_4_) == 0)
		return false;
	    return true;
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  ("q.F(" + i + ',' + i_3_ + ',' + i_4_
					   + ')'));
	}
    }
    
    final void method739(int i) {
	try {
	    if (i != -2)
		method768(31);
	    if (aBoolean3789) {
		((Class76) this).aHa_Sub3_585.method1951((byte) 120, 1);
		((Class76) this).aHa_Sub3_585.method2005(null, 40);
		((Class76) this).aHa_Sub3_585.method1951((byte) 120, 0);
		((Class76) this).aHa_Sub3_585.method2005(null, -114);
		OpenGL.glUseProgramObjectARB(0L);
		aBoolean3789 = false;
	    }
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception, "q.C(" + i + ')');
	}
    }
    
    final void method748(int i, boolean bool) {
	do {
	    try {
		if (i != 69)
		    aBoolean3789 = true;
		Interface4_Impl3 interface4_impl3
		    = ((Class76) this).aHa_Sub3_585.method1939(-93);
		if (!aBoolean3782 || interface4_impl3 == null)
		    break;
		((Class76) this).aHa_Sub3_585.method1951((byte) 120, 1);
		((Class76) this).aHa_Sub3_585.method2005(interface4_impl3,
							 i + 11);
		((Class76) this).aHa_Sub3_585.method1951((byte) 120, 0);
		((Class76) this).aHa_Sub3_585.method2005
		    (((Class195) aClass195_3790).anInterface4_Impl1_1500,
		     i + -197);
		long l = ((Class82) aClass82_3792).aLong628;
		OpenGL.glUseProgramObjectARB(l);
		OpenGL.glUniform1iARB
		    (OpenGL.glGetUniformLocationARB(l, "normalSampler"), 0);
		OpenGL.glUniform1iARB
		    (OpenGL.glGetUniformLocationARB(l, "envMapSampler"), 1);
		OpenGL.glUniform3fARB
		    (OpenGL.glGetUniformLocationARB(l, "sunDir"),
		     -(((ha_Sub3) ((Class76) this).aHa_Sub3_585)
		       .aFloatArray4596[0]),
		     -(((ha_Sub3) ((Class76) this).aHa_Sub3_585)
		       .aFloatArray4596[1]),
		     -(((ha_Sub3) ((Class76) this).aHa_Sub3_585)
		       .aFloatArray4596[2]));
		OpenGL.glUniform4fARB
		    (OpenGL.glGetUniformLocationARB(l, "sunColour"),
		     ((ha_Sub3) ((Class76) this).aHa_Sub3_585).aFloat4611,
		     ((ha_Sub3) ((Class76) this).aHa_Sub3_585).aFloat4549,
		     ((ha_Sub3) ((Class76) this).aHa_Sub3_585).aFloat4591,
		     1.0F);
		OpenGL.glUniform1fARB
		    (OpenGL.glGetUniformLocationARB(l, "sunExponent"),
		     96.0F + 928.0F * Math.abs(((ha_Sub3)
						((Class76) this).aHa_Sub3_585)
					       .aFloatArray4596[1]));
		aBoolean3789 = true;
	    } catch (RuntimeException runtimeexception) {
		throw Class64_Sub27.method667(runtimeexception,
					      "q.B(" + i + ',' + bool + ')');
	    }
	    break;
	} while (false);
    }
    
    public static void method767(boolean bool) {
	try {
	    anIntArray3791 = null;
	    aClass207_3787 = null;
	    aFloatArray3784 = null;
	    if (bool != true)
		aThread3783 = null;
	    anIntArray3785 = null;
	    aThread3783 = null;
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  "q.A(" + bool + ')');
	}
    }
    
    final boolean method745(byte i) {
	try {
	    if (i != 27)
		aClass207_3787 = null;
	    return aBoolean3782;
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception, "q.H(" + i + ')');
	}
    }
    
    final void method743(int i, boolean bool) {
	do {
	    try {
		if (i > 93)
		    break;
		aBoolean3788 = true;
	    } catch (RuntimeException runtimeexception) {
		throw Class64_Sub27.method667(runtimeexception,
					      "q.D(" + i + ',' + bool + ')');
	    }
	    break;
	} while (false);
    }
    
    final void method746(int i, int i_5_, int i_6_) {
	try {
	    if (i_6_ <= -75) {
		if (aBoolean3789) {
		    int i_7_ = 1 << (0x3 & i);
		    float f
			= (float) (1 << ((0x3f & i) >> 1719984675)) / 32.0F;
		    int i_8_ = 0xffff & i_5_;
		    float f_9_ = (float) (i_5_ >> -1594334576 & 0x3) / 8.0F;
		    long l = ((Class82) aClass82_3792).aLong628;
		    OpenGL.glUniform1fARB
			(OpenGL.glGetUniformLocationARB(l, "time"),
			 (float) (i_7_
				  * (((ha_Sub3) ((Class76) this).aHa_Sub3_585)
				     .anInt4556)
				  % 40000) / 40000.0F);
		    OpenGL.glUniform1fARB
			(OpenGL.glGetUniformLocationARB(l, "scale"), f);
		    OpenGL.glUniform1fARB
			(OpenGL.glGetUniformLocationARB(l, "breakWaterDepth"),
			 (float) i_8_);
		    OpenGL.glUniform1fARB
			(OpenGL.glGetUniformLocationARB(l, "breakWaterOffset"),
			 f_9_);
		}
	    }
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  ("q.E(" + i + ',' + i_5_ + ',' + i_6_
					   + ')'));
	}
    }
    
    final void method742(int i, int i_10_, Interface4 interface4) {
	try {
	    if (i == 6) {
		if (!aBoolean3789) {
		    ((Class76) this).aHa_Sub3_585.method2005(interface4, 103);
		    ((Class76) this).aHa_Sub3_585.method2015(i_10_,
							     (byte) -105);
		}
	    }
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  ("q.I(" + i + ',' + i_10_ + ','
					   + (interface4 != null ? "{...}"
					      : "null")
					   + ')'));
	}
    }
    
    static final void method768(int i) {
	do {
	    try {
		Class159.aClass293ArrayArray1252
		    = new Class293[Class98_Sub17_Sub1.aClass207_5783
				       .method2752((byte) -11)][];
		Class64_Sub13.aClass293ArrayArray3674
		    = new Class293[Class98_Sub17_Sub1.aClass207_5783
				       .method2752((byte) -11)][];
		Class246_Sub3_Sub3_Sub1.aBooleanArray6256
		    = new boolean[Class98_Sub17_Sub1.aClass207_5783
				      .method2752((byte) -11)];
		if (i >= 103)
		    break;
		method766(-4, -90, 36);
	    } catch (RuntimeException runtimeexception) {
		throw Class64_Sub27.method667(runtimeexception,
					      "q.O(" + i + ')');
	    }
	    break;
	} while (false);
    }
    
    Class76_Sub9(ha_Sub3_Sub2 var_ha_Sub3_Sub2, Class207 class207,
		 Class195 class195) {
	super(var_ha_Sub3_Sub2);
	try {
	    aClass195_3790 = class195;
	    if (class207 != null
		&& ((ha_Sub3_Sub2) var_ha_Sub3_Sub2).aBoolean6133
		&& ((ha_Sub3_Sub2) var_ha_Sub3_Sub2).aBoolean6136) {
		Class230 class230
		    = (Class98_Sub46.method1526
		       (class207.method2739("gl", "environment_mapped_water_v",
					    -32734),
			var_ha_Sub3_Sub2, -25671, 35633));
		Class230 class230_11_
		    = (Class98_Sub46.method1526
		       (class207.method2739("gl", "environment_mapped_water_f",
					    -32734),
			var_ha_Sub3_Sub2, -25671, 35632));
		aClass82_3792
		    = Class205.method2713(var_ha_Sub3_Sub2, 0,
					  new Class230[] { class230,
							   class230_11_ });
		aBoolean3782
		    = aClass82_3792 != null && aClass195_3790.method2664(-118);
	    } else
		aBoolean3782 = false;
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667
		      (runtimeexception,
		       ("q.<init>("
			+ (var_ha_Sub3_Sub2 != null ? "{...}" : "null") + ','
			+ (class207 != null ? "{...}" : "null") + ','
			+ (class195 != null ? "{...}" : "null") + ')'));
	}
    }
    
    static {
	aFloatArray3784 = new float[2];
	anIntArray3791 = new int[2048];
    }
}
