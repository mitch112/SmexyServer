/* Class81 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import jaclib.memory.Buffer;
import jaclib.memory.Stream;

final class Class81
{
    private int[] anIntArray608 = new int[1600];
    private Interface2_Impl2 anInterface2_Impl2_609;
    private Class246_Sub4_Sub2[][] aClass246_Sub4_Sub2ArrayArray610
	= new Class246_Sub4_Sub2[64][768];
    private Class256 aClass256_611;
    private Interface2_Impl1 anInterface2_Impl1_612;
    private int anInt613;
    private int[] anIntArray614 = new int[64];
    private int[] anIntArray615;
    private Class246_Sub4_Sub2[][] aClass246_Sub4_Sub2ArrayArray616;
    static Class100 aClass100_617 = new Class100(16);
    static s[] aSArray618;
    static Class98_Sub31_Sub3 aClass98_Sub31_Sub3_619;
    static Class98_Sub7 aClass98_Sub7_620;
    static boolean aBoolean621 = false;
    static Class207 aClass207_622;
    private Interface2_Impl1 anInterface2_Impl1_623;
    static int anInt624;
    
    private final void method811(ha_Sub3 var_ha_Sub3, byte i, int i_0_) {
	do {
	    try {
		int i_1_ = 0;
		Class111_Sub3 class111_sub3 = var_ha_Sub3.method2027(0);
		float f = ((Class111_Sub3) class111_sub3).aFloat4712;
		float f_2_ = ((Class111_Sub3) class111_sub3).aFloat4711;
		float f_3_ = ((Class111_Sub3) class111_sub3).aFloat4705;
		float f_4_ = ((Class111_Sub3) class111_sub3).aFloat4714;
		float f_5_ = ((Class111_Sub3) class111_sub3).aFloat4706;
		float f_6_ = ((Class111_Sub3) class111_sub3).aFloat4710;
		float f_7_ = f_4_ + f;
		float f_8_ = f_2_ + f_5_;
		float f_9_ = f_3_ + f_6_;
		float f_10_ = -f_4_ + f;
		float f_11_ = -f_5_ + f_2_;
		float f_12_ = -f_6_ + f_3_;
		float f_13_ = -f + f_4_;
		float f_14_ = f_5_ - f_2_;
		float f_15_ = f_6_ - f_3_;
		if (i != -14)
		    anInt624 = -5;
		Buffer buffer
		    = anInterface2_Impl1_623.method75(true, (byte) 27);
		if (buffer != null) {
		    Stream stream = var_ha_Sub3.method2043(i + 24036, buffer);
		    if (Stream.a()) {
			for (int i_16_ = i_0_ - 1; (i_16_ ^ 0xffffffff) <= -1;
			     i_16_--) {
			    int i_17_ = (anIntArray608[i_16_] > 64 ? 64
					 : anIntArray608[i_16_]);
			    if ((i_17_ ^ 0xffffffff) < -1) {
				for (int i_18_ = i_17_ - 1;
				     (i_18_ ^ 0xffffffff) <= -1; i_18_--) {
				    Class246_Sub4_Sub2 class246_sub4_sub2
					= (aClass246_Sub4_Sub2ArrayArray616
					   [i_16_][i_18_]);
				    int i_19_ = (((Class246_Sub4_Sub2)
						  class246_sub4_sub2)
						 .anInt6178);
				    byte i_20_ = (byte) (i_19_ >> 1004982320);
				    byte i_21_ = (byte) (i_19_ >> -1475022584);
				    byte i_22_ = (byte) i_19_;
				    byte i_23_ = (byte) (i_19_ >>> 499468248);
				    float f_24_
					= (float) ((((Class246_Sub4_Sub2)
						     class246_sub4_sub2)
						    .anInt6176)
						   >> -1148612052);
				    float f_25_
					= (float) ((((Class246_Sub4_Sub2)
						     class246_sub4_sub2)
						    .anInt6177)
						   >> -1842071796);
				    float f_26_
					= (float) ((((Class246_Sub4_Sub2)
						     class246_sub4_sub2)
						    .anInt6175)
						   >> 1522356492);
				    int i_27_ = (((Class246_Sub4_Sub2)
						  class246_sub4_sub2).anInt6179
						 >> -2078565748);
				    stream.b(f_24_ + f_7_ * (float) -i_27_);
				    stream.b(f_25_ + f_8_ * (float) -i_27_);
				    stream.b((float) -i_27_ * f_9_ + f_26_);
				    if (((ha_Sub3) var_ha_Sub3).anInt4580 != 0)
					stream.b(i_20_, i_21_, i_22_, i_23_);
				    else
					stream.a(i_20_, i_21_, i_22_, i_23_);
				    stream.b(0.0F);
				    stream.b(0.0F);
				    stream.b(f_24_ + f_10_ * (float) i_27_);
				    stream.b(f_25_ + f_11_ * (float) i_27_);
				    stream.b(f_12_ * (float) i_27_ + f_26_);
				    if ((((ha_Sub3) var_ha_Sub3).anInt4580
					 ^ 0xffffffff)
					== -1)
					stream.a(i_20_, i_21_, i_22_, i_23_);
				    else
					stream.b(i_20_, i_21_, i_22_, i_23_);
				    stream.b(1.0F);
				    stream.b(0.0F);
				    stream.b(f_7_ * (float) i_27_ + f_24_);
				    stream.b((float) i_27_ * f_8_ + f_25_);
				    stream.b((float) i_27_ * f_9_ + f_26_);
				    if (((ha_Sub3) var_ha_Sub3).anInt4580 == 0)
					stream.a(i_20_, i_21_, i_22_, i_23_);
				    else
					stream.b(i_20_, i_21_, i_22_, i_23_);
				    stream.b(1.0F);
				    stream.b(1.0F);
				    stream.b(f_24_ + f_13_ * (float) i_27_);
				    stream.b(f_14_ * (float) i_27_ + f_25_);
				    stream.b((float) i_27_ * f_15_ + f_26_);
				    if ((((ha_Sub3) var_ha_Sub3).anInt4580
					 ^ 0xffffffff)
					!= -1)
					stream.b(i_20_, i_21_, i_22_, i_23_);
				    else
					stream.a(i_20_, i_21_, i_22_, i_23_);
				    stream.b(0.0F);
				    i_1_++;
				    stream.b(1.0F);
				}
				if (anIntArray608[i_16_] > 64) {
				    int i_28_
					= anIntArray608[i_16_] + -64 + -1;
				    for (int i_29_ = anIntArray614[i_28_] + -1;
					 i_29_ >= 0; i_29_--) {
					Class246_Sub4_Sub2 class246_sub4_sub2
					    = (aClass246_Sub4_Sub2ArrayArray610
					       [i_28_][i_29_]);
					int i_30_ = (((Class246_Sub4_Sub2)
						      class246_sub4_sub2)
						     .anInt6178);
					byte i_31_
					    = (byte) (i_30_ >> -1731208688);
					byte i_32_
					    = (byte) (i_30_ >> 2114755272);
					byte i_33_ = (byte) i_30_;
					byte i_34_
					    = (byte) (i_30_ >>> 42394680);
					float f_35_
					    = (float) ((((Class246_Sub4_Sub2)
							 class246_sub4_sub2)
							.anInt6176)
						       >> -1812783700);
					float f_36_
					    = (float) ((((Class246_Sub4_Sub2)
							 class246_sub4_sub2)
							.anInt6177)
						       >> -1875090740);
					float f_37_
					    = (float) ((((Class246_Sub4_Sub2)
							 class246_sub4_sub2)
							.anInt6175)
						       >> -1949960628);
					int i_38_
					    = (((Class246_Sub4_Sub2)
						class246_sub4_sub2).anInt6179
					       >> 1949500780);
					stream
					    .b(f_35_ + f_7_ * (float) -i_38_);
					stream
					    .b(f_8_ * (float) -i_38_ + f_36_);
					stream
					    .b(f_37_ + (float) -i_38_ * f_9_);
					if (((ha_Sub3) var_ha_Sub3).anInt4580
					    == 0)
					    stream.a(i_31_, i_32_, i_33_,
						     i_34_);
					else
					    stream.b(i_31_, i_32_, i_33_,
						     i_34_);
					stream.b(0.0F);
					stream.b(0.0F);
					stream
					    .b(f_10_ * (float) i_38_ + f_35_);
					stream
					    .b((float) i_38_ * f_11_ + f_36_);
					stream
					    .b(f_37_ + f_12_ * (float) i_38_);
					if (((ha_Sub3) var_ha_Sub3).anInt4580
					    != 0)
					    stream.b(i_31_, i_32_, i_33_,
						     i_34_);
					else
					    stream.a(i_31_, i_32_, i_33_,
						     i_34_);
					stream.b(1.0F);
					stream.b(0.0F);
					stream.b(f_35_ + f_7_ * (float) i_38_);
					stream.b(f_36_ + (float) i_38_ * f_8_);
					stream.b(f_37_ + (float) i_38_ * f_9_);
					if ((((ha_Sub3) var_ha_Sub3).anInt4580
					     ^ 0xffffffff)
					    != -1)
					    stream.b(i_31_, i_32_, i_33_,
						     i_34_);
					else
					    stream.a(i_31_, i_32_, i_33_,
						     i_34_);
					stream.b(1.0F);
					stream.b(1.0F);
					stream
					    .b(f_35_ + (float) i_38_ * f_13_);
					stream
					    .b((float) i_38_ * f_14_ + f_36_);
					stream
					    .b(f_37_ + (float) i_38_ * f_15_);
					if (((ha_Sub3) var_ha_Sub3).anInt4580
					    == 0)
					    stream.a(i_31_, i_32_, i_33_,
						     i_34_);
					else
					    stream.b(i_31_, i_32_, i_33_,
						     i_34_);
					stream.b(0.0F);
					i_1_++;
					stream.b(1.0F);
				    }
				}
			    }
			}
		    } else {
			for (int i_39_ = -1 + i_0_; (i_39_ ^ 0xffffffff) <= -1;
			     i_39_--) {
			    int i_40_ = (anIntArray608[i_39_] > 64 ? 64
					 : anIntArray608[i_39_]);
			    if (i_40_ > 0) {
				for (int i_41_ = i_40_ + -1; i_41_ >= 0;
				     i_41_--) {
				    Class246_Sub4_Sub2 class246_sub4_sub2
					= (aClass246_Sub4_Sub2ArrayArray616
					   [i_39_][i_41_]);
				    int i_42_ = (((Class246_Sub4_Sub2)
						  class246_sub4_sub2)
						 .anInt6178);
				    byte i_43_ = (byte) (i_42_ >> -1414407312);
				    byte i_44_ = (byte) (i_42_ >> 1123272776);
				    byte i_45_ = (byte) i_42_;
				    byte i_46_ = (byte) (i_42_ >>> -997863304);
				    float f_47_
					= (float) ((((Class246_Sub4_Sub2)
						     class246_sub4_sub2)
						    .anInt6176)
						   >> -83946644);
				    float f_48_
					= (float) ((((Class246_Sub4_Sub2)
						     class246_sub4_sub2)
						    .anInt6177)
						   >> -867938740);
				    float f_49_
					= (float) ((((Class246_Sub4_Sub2)
						     class246_sub4_sub2)
						    .anInt6175)
						   >> 13807948);
				    int i_50_ = (((Class246_Sub4_Sub2)
						  class246_sub4_sub2).anInt6179
						 >> -1405584212);
				    stream.a((float) -i_50_ * f_7_ + f_47_);
				    stream.a(f_48_ + f_8_ * (float) -i_50_);
				    stream.a(f_49_ + (float) -i_50_ * f_9_);
				    if ((((ha_Sub3) var_ha_Sub3).anInt4580
					 ^ 0xffffffff)
					== -1)
					stream.a(i_43_, i_44_, i_45_, i_46_);
				    else
					stream.b(i_43_, i_44_, i_45_, i_46_);
				    stream.a(0.0F);
				    stream.a(0.0F);
				    stream.a(f_47_ + (float) i_50_ * f_10_);
				    stream.a(f_48_ + (float) i_50_ * f_11_);
				    stream.a(f_12_ * (float) i_50_ + f_49_);
				    if ((((ha_Sub3) var_ha_Sub3).anInt4580
					 ^ 0xffffffff)
					!= -1)
					stream.b(i_43_, i_44_, i_45_, i_46_);
				    else
					stream.a(i_43_, i_44_, i_45_, i_46_);
				    stream.a(1.0F);
				    stream.a(0.0F);
				    stream.a((float) i_50_ * f_7_ + f_47_);
				    stream.a((float) i_50_ * f_8_ + f_48_);
				    stream.a(f_49_ + (float) i_50_ * f_9_);
				    if ((((ha_Sub3) var_ha_Sub3).anInt4580
					 ^ 0xffffffff)
					== -1)
					stream.a(i_43_, i_44_, i_45_, i_46_);
				    else
					stream.b(i_43_, i_44_, i_45_, i_46_);
				    stream.a(1.0F);
				    stream.a(1.0F);
				    stream.a(f_47_ + f_13_ * (float) i_50_);
				    stream.a((float) i_50_ * f_14_ + f_48_);
				    stream.a((float) i_50_ * f_15_ + f_49_);
				    if ((((ha_Sub3) var_ha_Sub3).anInt4580
					 ^ 0xffffffff)
					== -1)
					stream.a(i_43_, i_44_, i_45_, i_46_);
				    else
					stream.b(i_43_, i_44_, i_45_, i_46_);
				    stream.a(0.0F);
				    i_1_++;
				    stream.a(1.0F);
				}
				if ((anIntArray608[i_39_] ^ 0xffffffff)
				    < -65) {
				    int i_51_
					= -1 + (-64 + anIntArray608[i_39_]);
				    for (int i_52_ = -1 + anIntArray614[i_51_];
					 i_52_ >= 0; i_52_--) {
					Class246_Sub4_Sub2 class246_sub4_sub2
					    = (aClass246_Sub4_Sub2ArrayArray610
					       [i_51_][i_52_]);
					int i_53_ = (((Class246_Sub4_Sub2)
						      class246_sub4_sub2)
						     .anInt6178);
					byte i_54_
					    = (byte) (i_53_ >> -924804944);
					byte i_55_
					    = (byte) (i_53_ >> 1479709480);
					byte i_56_ = (byte) i_53_;
					byte i_57_
					    = (byte) (i_53_ >>> 989558680);
					float f_58_
					    = (float) ((((Class246_Sub4_Sub2)
							 class246_sub4_sub2)
							.anInt6176)
						       >> -1539946420);
					float f_59_
					    = (float) ((((Class246_Sub4_Sub2)
							 class246_sub4_sub2)
							.anInt6177)
						       >> 1485597036);
					float f_60_
					    = (float) ((((Class246_Sub4_Sub2)
							 class246_sub4_sub2)
							.anInt6175)
						       >> 750057452);
					int i_61_
					    = (((Class246_Sub4_Sub2)
						class246_sub4_sub2).anInt6179
					       >> 2108567500);
					stream
					    .a((float) -i_61_ * f_7_ + f_58_);
					stream
					    .a(f_59_ + f_8_ * (float) -i_61_);
					stream
					    .a((float) -i_61_ * f_9_ + f_60_);
					if (((ha_Sub3) var_ha_Sub3).anInt4580
					    != 0)
					    stream.b(i_54_, i_55_, i_56_,
						     i_57_);
					else
					    stream.a(i_54_, i_55_, i_56_,
						     i_57_);
					stream.a(0.0F);
					stream.a(0.0F);
					stream
					    .a((float) i_61_ * f_10_ + f_58_);
					stream
					    .a(f_59_ + (float) i_61_ * f_11_);
					stream
					    .a(f_60_ + f_12_ * (float) i_61_);
					if ((((ha_Sub3) var_ha_Sub3).anInt4580
					     ^ 0xffffffff)
					    == -1)
					    stream.a(i_54_, i_55_, i_56_,
						     i_57_);
					else
					    stream.b(i_54_, i_55_, i_56_,
						     i_57_);
					stream.a(1.0F);
					stream.a(0.0F);
					stream.a(f_58_ + f_7_ * (float) i_61_);
					stream.a(f_59_ + f_8_ * (float) i_61_);
					stream.a(f_9_ * (float) i_61_ + f_60_);
					if ((((ha_Sub3) var_ha_Sub3).anInt4580
					     ^ 0xffffffff)
					    != -1)
					    stream.b(i_54_, i_55_, i_56_,
						     i_57_);
					else
					    stream.a(i_54_, i_55_, i_56_,
						     i_57_);
					stream.a(1.0F);
					stream.a(1.0F);
					stream
					    .a(f_13_ * (float) i_61_ + f_58_);
					stream
					    .a(f_59_ + f_14_ * (float) i_61_);
					stream
					    .a((float) i_61_ * f_15_ + f_60_);
					if (((ha_Sub3) var_ha_Sub3).anInt4580
					    != 0)
					    stream.b(i_54_, i_55_, i_56_,
						     i_57_);
					else
					    stream.a(i_54_, i_55_, i_56_,
						     i_57_);
					stream.a(0.0F);
					stream.a(1.0F);
					i_1_++;
				    }
				}
			    }
			}
		    }
		    stream.c();
		    if (!anInterface2_Impl1_623.method71(i + 13637))
			break;
		    var_ha_Sub3.method1971(0, true, anInterface2_Impl1_623);
		    var_ha_Sub3.method1971(1, true, anInterface2_Impl1_612);
		    var_ha_Sub3.method2042(aClass256_611, (byte) 101);
		    var_ha_Sub3.method1973(Class336.aClass232_2822, 4 * i_1_,
					   0, i + 26824,
					   anInterface2_Impl2_609, 0,
					   2 * i_1_);
		}
	    } catch (RuntimeException runtimeexception) {
		throw Class64_Sub27.method667(runtimeexception,
					      ("fea.I("
					       + (var_ha_Sub3 != null ? "{...}"
						  : "null")
					       + ',' + i + ',' + i_0_ + ')'));
	    }
	    break;
	} while (false);
    }
    
    final void method812(ha_Sub3 var_ha_Sub3, byte i) {
	try {
	    if (i != 36)
		aClass246_Sub4_Sub2ArrayArray616 = null;
	    anInterface2_Impl1_623.method74(-20279, 24, 786336);
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  ("fea.H("
					   + (var_ha_Sub3 != null ? "{...}"
					      : "null")
					   + ',' + i + ')'));
	}
    }
    
    private final void method813(ha_Sub3 var_ha_Sub3, int i) {
	try {
	    Class98_Sub32_Sub1.aFloat5886 = ((ha_Sub3) var_ha_Sub3).aFloat4576;
	    if (i != -64)
		anInterface2_Impl2_609 = null;
	    var_ha_Sub3.method1976(i ^ 0x4e);
	    var_ha_Sub3.method1986(false, (byte) -119);
	    var_ha_Sub3.method1997(0, false);
	    var_ha_Sub3.method1960(13951);
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  ("fea.G("
					   + (var_ha_Sub3 != null ? "{...}"
					      : "null")
					   + ',' + i + ')'));
	}
    }
    
    final void method814(byte i) {
	try {
	    if (i != 4)
		anIntArray615 = null;
	    anInterface2_Impl1_623.method72(false);
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  "fea.C(" + i + ')');
	}
    }
    
    static final boolean method815(int i, int i_62_) {
	try {
	    if (i_62_ != 0)
		method817(true);
	    if ((i ^ 0xffffffff) != (-i & i ^ 0xffffffff))
		return false;
	    return true;
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  "fea.A(" + i + ',' + i_62_ + ')');
	}
    }
    
    private final void method816(int i, ha_Sub3 var_ha_Sub3) {
	do {
	    try {
		var_ha_Sub3.method1997(0, true);
		var_ha_Sub3.method1986(true, (byte) -7);
		if (Class98_Sub32_Sub1.aFloat5886
		    != ((ha_Sub3) var_ha_Sub3).aFloat4576)
		    var_ha_Sub3.xa(Class98_Sub32_Sub1.aFloat5886);
		if (i <= -97)
		    break;
		anIntArray614 = null;
	    } catch (RuntimeException runtimeexception) {
		throw Class64_Sub27.method667(runtimeexception,
					      ("fea.J(" + i + ','
					       + (var_ha_Sub3 != null ? "{...}"
						  : "null")
					       + ')'));
	    }
	    break;
	} while (false);
    }
    
    static final void method817(boolean bool) {
	do {
	    try {
		Class129.method2229();
		for (int i = 0; i < 4; i++)
		    Class167.aClass243Array1281[i].method2950((byte) -99);
		InputStream_Sub2.method124(52);
		Class98_Sub10_Sub15.method1050((byte) 125);
		Class301.method3542(50);
		System.gc();
		Class265.aHa1974.ya();
		if (bool == false)
		    break;
		aBoolean621 = true;
	    } catch (RuntimeException runtimeexception) {
		throw Class64_Sub27.method667(runtimeexception,
					      "fea.B(" + bool + ')');
	    }
	    break;
	} while (false);
    }
    
    final void method818(byte i, Class242 class242, int i_63_,
			 ha_Sub3 var_ha_Sub3) {
	try {
	    if (((ha_Sub3) var_ha_Sub3).aClass111_Sub3_4543 != null) {
		if (i_63_ < 0)
		    method813(var_ha_Sub3, -64);
		else
		    method819(-11402, i_63_, var_ha_Sub3);
		float f = (((Class111_Sub3)
			    ((ha_Sub3) var_ha_Sub3).aClass111_Sub3_4543)
			   .aFloat4708);
		float f_64_ = (((Class111_Sub3)
				((ha_Sub3) var_ha_Sub3).aClass111_Sub3_4543)
			       .aFloat4713);
		float f_65_ = (((Class111_Sub3)
				((ha_Sub3) var_ha_Sub3).aClass111_Sub3_4543)
			       .aFloat4704);
		float f_66_ = (((Class111_Sub3)
				((ha_Sub3) var_ha_Sub3).aClass111_Sub3_4543)
			       .aFloat4703);
		try {
		    int i_67_ = 0;
		    int i_68_ = 2147483647;
		    int i_69_ = 0;
		    Class246_Sub4 class246_sub4
			= (((Class358) ((Class242) class242).aClass358_1850)
			   .aClass246_Sub4_3028);
		    for (Class246_Sub4 class246_sub4_70_
			     = (((Class246_Sub4) class246_sub4)
				.aClass246_Sub4_5091);
			 class246_sub4_70_ != class246_sub4;
			 class246_sub4_70_
			     = (((Class246_Sub4) class246_sub4_70_)
				.aClass246_Sub4_5091)) {
			Class246_Sub4_Sub2 class246_sub4_sub2
			    = (Class246_Sub4_Sub2) class246_sub4_70_;
			int i_71_
			    = (int) (f_66_
				     + ((float) (((Class246_Sub4_Sub2)
						  class246_sub4_sub2).anInt6175
						 >> 912414860) * f_65_
					+ ((float) ((((Class246_Sub4_Sub2)
						      class246_sub4_sub2)
						     .anInt6177)
						    >> -493384788) * f_64_
					   + (float) ((((Class246_Sub4_Sub2)
							class246_sub4_sub2)
						       .anInt6176)
						      >> 1402072204) * f)));
			if ((i_69_ ^ 0xffffffff) > (i_71_ ^ 0xffffffff))
			    i_69_ = i_71_;
			if ((i_71_ ^ 0xffffffff) > (i_68_ ^ 0xffffffff))
			    i_68_ = i_71_;
			anIntArray615[i_67_++] = i_71_;
		    }
		    int i_72_ = i_69_ - i_68_;
		    int i_73_;
		    if ((2 + i_72_ ^ 0xffffffff) >= -1601) {
			i_72_ += 2;
			i_73_ = 0;
		    } else {
			i_73_ = 1 + (Class48_Sub2_Sub1.method474(i_72_,
								 (byte) 31)
				     + -Class373.anInt3477);
			i_72_ = 2 + (i_72_ >> i_73_);
		    }
		    i_67_ = 0;
		    Class246_Sub4 class246_sub4_74_
			= ((Class246_Sub4) class246_sub4).aClass246_Sub4_5091;
		    int i_75_ = -2;
		    if (i != -108)
			anInterface2_Impl1_623 = null;
		    boolean bool = true;
		    boolean bool_76_ = true;
		    while (class246_sub4 != class246_sub4_74_) {
			anInt613 = 0;
			for (int i_77_ = 0;
			     (i_77_ ^ 0xffffffff) > (i_72_ ^ 0xffffffff);
			     i_77_++)
			    anIntArray608[i_77_] = 0;
			for (int i_78_ = 0; i_78_ < 64; i_78_++)
			    anIntArray614[i_78_] = 0;
			for (/**/; class246_sub4_74_ != class246_sub4;
			     class246_sub4_74_
				 = (((Class246_Sub4) class246_sub4_74_)
				    .aClass246_Sub4_5091)) {
			    Class246_Sub4_Sub2 class246_sub4_sub2
				= (Class246_Sub4_Sub2) class246_sub4_74_;
			    if (bool_76_) {
				bool_76_ = false;
				bool = ((Class246_Sub4_Sub2)
					class246_sub4_sub2).aBoolean6174;
				i_75_ = ((Class246_Sub4_Sub2)
					 class246_sub4_sub2).anInt6180;
			    }
			    if (i_67_ > 0
				&& (i_75_ != ((Class246_Sub4_Sub2)
					      class246_sub4_sub2).anInt6180
				    || (((Class246_Sub4_Sub2)
					 class246_sub4_sub2).aBoolean6174
					== !bool))) {
				bool_76_ = true;
				break;
			    }
			    int i_79_
				= -i_68_ + anIntArray615[i_67_++] >> i_73_;
			    if ((i_79_ ^ 0xffffffff) > -1601) {
				if ((anIntArray608[i_79_] ^ 0xffffffff) > -65)
				    aClass246_Sub4_Sub2ArrayArray616[i_79_]
					[anIntArray608[i_79_]++]
					= class246_sub4_sub2;
				else {
				    if ((anIntArray608[i_79_] ^ 0xffffffff)
					== -65) {
					if ((anInt613 ^ 0xffffffff) == -65)
					    continue;
					anIntArray608[i_79_] += 1 + anInt613++;
				    }
				    aClass246_Sub4_Sub2ArrayArray610
					[anIntArray608[i_79_] - 64 - 1]
					[anIntArray614[(-1
							+ anIntArray608[i_79_]
							+ -64)]++]
					= class246_sub4_sub2;
				}
			    }
			}
			var_ha_Sub3.method2039(false, i ^ ~0x6b,
					       ((i_75_ ^ 0xffffffff) > -1 ? -1
						: i_75_),
					       false);
			if (!bool || (Class98_Sub32_Sub1.aFloat5886
				      == ((ha_Sub3) var_ha_Sub3).aFloat4576)) {
			    if (((ha_Sub3) var_ha_Sub3).aFloat4576 != 1.0F)
				var_ha_Sub3.xa(1.0F);
			} else
			    var_ha_Sub3.xa(Class98_Sub32_Sub1.aFloat5886);
			method811(var_ha_Sub3, (byte) -14, i_72_);
		    }
		} catch (Exception exception) {
		    /* empty */
		}
		method816(-103, var_ha_Sub3);
	    }
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  ("fea.D(" + i + ','
					   + (class242 != null ? "{...}"
					      : "null")
					   + ',' + i_63_ + ','
					   + (var_ha_Sub3 != null ? "{...}"
					      : "null")
					   + ')'));
	}
    }
    
    private final void method819(int i, int i_80_, ha_Sub3 var_ha_Sub3) {
	try {
	    Class98_Sub32_Sub1.aFloat5886 = ((ha_Sub3) var_ha_Sub3).aFloat4576;
	    var_ha_Sub3.method2056(i ^ ~0x2cbd, (float) i_80_);
	    if (i != -11402)
		anIntArray614 = null;
	    var_ha_Sub3.method1937(4);
	    var_ha_Sub3.method1986(false, (byte) -126);
	    var_ha_Sub3.method1997(0, false);
	    var_ha_Sub3.method1960(13951);
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  ("fea.E(" + i + ',' + i_80_ + ','
					   + (var_ha_Sub3 != null ? "{...}"
					      : "null")
					   + ')'));
	}
    }
    
    Class81(ha_Sub3 var_ha_Sub3) {
	anInt613 = 0;
	anIntArray615 = new int[8191];
	aClass246_Sub4_Sub2ArrayArray616 = new Class246_Sub4_Sub2[1600][64];
	do {
	    try {
		aClass256_611 = (var_ha_Sub3.method1982
				 ((new Class49[]
				   { new Class49(new Class169[]
						 { Class169.aClass169_1294,
						   Class169.aClass169_1298,
						   Class169.aClass169_1301 }),
				     new Class49(Class169.aClass169_1297) }),
				  6));
		anInterface2_Impl1_623 = var_ha_Sub3.method2060(true, 107);
		anInterface2_Impl1_612 = var_ha_Sub3.method2060(false, 119);
		anInterface2_Impl1_612.method74(-20279, 12, 393168);
		anInterface2_Impl2_609
		    = var_ha_Sub3.method1990((byte) 84, false);
		anInterface2_Impl2_609.method76(49146, 20779);
		Buffer buffer = anInterface2_Impl2_609.method78(true, -87);
		if (buffer != null) {
		    Stream stream = var_ha_Sub3.method2043(24022, buffer);
		    if (!Stream.a()) {
			for (int i = 0; (i ^ 0xffffffff) > -8192; i++) {
			    int i_81_ = 4 * i;
			    stream.d(i_81_);
			    stream.d(1 + i_81_);
			    stream.d(2 + i_81_);
			    stream.d(2 + i_81_);
			    stream.d(3 + i_81_);
			    stream.d(i_81_);
			}
		    } else {
			for (int i = 0; (i ^ 0xffffffff) > -8192; i++) {
			    int i_82_ = 4 * i;
			    stream.c(i_82_);
			    stream.c(i_82_ - -1);
			    stream.c(i_82_ - -2);
			    stream.c(2 + i_82_);
			    stream.c(3 + i_82_);
			    stream.c(i_82_);
			}
		    }
		    stream.c();
		    anInterface2_Impl2_609.method79((byte) -117);
		}
		Buffer buffer_83_
		    = anInterface2_Impl1_612.method75(true, (byte) 27);
		if (buffer_83_ == null)
		    break;
		Stream stream = var_ha_Sub3.method2043(24022, buffer_83_);
		if (Stream.a()) {
		    for (int i = 0; i < 8191; i++) {
			stream.b(0.0F);
			stream.b(-1.0F);
			stream.b(0.0F);
			stream.b(0.0F);
			stream.b(-1.0F);
			stream.b(0.0F);
			stream.b(0.0F);
			stream.b(-1.0F);
			stream.b(0.0F);
			stream.b(0.0F);
			stream.b(-1.0F);
			stream.b(0.0F);
		    }
		} else {
		    for (int i = 0; (i ^ 0xffffffff) > -8192; i++) {
			stream.a(0.0F);
			stream.a(-1.0F);
			stream.a(0.0F);
			stream.a(0.0F);
			stream.a(-1.0F);
			stream.a(0.0F);
			stream.a(0.0F);
			stream.a(-1.0F);
			stream.a(0.0F);
			stream.a(0.0F);
			stream.a(-1.0F);
			stream.a(0.0F);
		    }
		}
		stream.c();
		anInterface2_Impl1_612.method71(13623);
	    } catch (RuntimeException runtimeexception) {
		throw Class64_Sub27.method667(runtimeexception,
					      ("fea.<init>("
					       + (var_ha_Sub3 != null ? "{...}"
						  : "null")
					       + ')'));
	    }
	    break;
	} while (false);
    }
    
    public static void method820(int i) {
	try {
	    aSArray618 = null;
	    aClass100_617 = null;
	    aClass98_Sub31_Sub3_619 = null;
	    if (i != 1)
		aBoolean621 = true;
	    aClass98_Sub7_620 = null;
	    aClass207_622 = null;
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  "fea.F(" + i + ')');
	}
    }
}
