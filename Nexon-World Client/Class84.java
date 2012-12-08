/* Class84 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class Class84
{
    Class218 aClass218_635 = new Class218();
    static String[] aStringArray636;
    boolean aBoolean637 = false;
    
    static final void method832(String string, byte i) {
	try {
	    Class98_Sub45.method1521((byte) 52, 0, string, 0, "", "", "");
	    int i_0_ = 74 % ((i - 8) / 60);
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  ("fh.C("
					   + (string != null ? "{...}"
					      : "null")
					   + ',' + i + ')'));
	}
    }
    
    final void method833(int i) {
	do {
	    try {
		for (;;) {
		    Class246_Sub1 class246_sub1
			= (Class246_Sub1) ((Class84) this).aClass218_635
					      .method2805((byte) -72);
		    if (class246_sub1 == null)
			break;
		    class246_sub1.method2965((byte) -96);
		    Class35.method333(class246_sub1, i ^ ~0x75);
		}
		if (i == 0)
		    break;
		((Class84) this).aClass218_635 = null;
	    } catch (RuntimeException runtimeexception) {
		throw Class64_Sub27.method667(runtimeexception,
					      "fh.B(" + i + ')');
	    }
	    break;
	} while (false);
    }
    
    static final void method834(Class207 class207, int i) {
	try {
	    Class244.anInt1860 = class207.method2750((byte) -62, "p11_full");
	    int i_1_ = 105 / ((i - -25) / 51);
	    Class269.anInt2026 = class207.method2750((byte) -122, "p12_full");
	    Class123_Sub1.anInt4742
		= class207.method2750((byte) -91, "b12_full");
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  ("fh.E("
					   + (class207 != null ? "{...}"
					      : "null")
					   + ',' + i + ')'));
	}
    }
    
    public static void method835(int i) {
	do {
	    try {
		aStringArray636 = null;
		if (i == 2169)
		    break;
		aStringArray636 = null;
	    } catch (RuntimeException runtimeexception) {
		throw Class64_Sub27.method667(runtimeexception,
					      "fh.D(" + i + ')');
	    }
	    break;
	} while (false);
    }
    
    final void method836(int i, Class246_Sub1 class246_sub1) {
	try {
	    Class246_Sub3 class246_sub3
		= ((Class246_Sub1) class246_sub1).aClass246_Sub3_5069;
	    boolean bool = true;
	    Class246_Sub6[] class246_sub6s
		= ((Class246_Sub1) class246_sub1).aClass246_Sub6Array5067;
	    for (int i_2_ = i; class246_sub6s.length > i_2_; i_2_++) {
		if (((Class246_Sub6) class246_sub6s[i_2_]).aBoolean5114) {
		    bool = false;
		    break;
		}
	    }
	    if (!bool) {
		if (((Class84) this).aBoolean637) {
		    for (Class246_Sub1 class246_sub1_3_
			     = (Class246_Sub1) ((Class84) this)
						   .aClass218_635
						   .method2803((byte) 15);
			 class246_sub1_3_ != null;
			 class246_sub1_3_
			     = (Class246_Sub1) ((Class84) this)
						   .aClass218_635
						   .method2809(false)) {
			if (class246_sub3
			    == (((Class246_Sub1) class246_sub1_3_)
				.aClass246_Sub3_5069)) {
			    class246_sub1_3_.method2965((byte) 18);
			    Class35.method333(class246_sub1_3_, -120);
			}
		    }
		}
		for (Class246_Sub1 class246_sub1_4_
			 = (Class246_Sub1) ((Class84) this).aClass218_635
					       .method2803((byte) 15);
		     class246_sub1_4_ != null;
		     class246_sub1_4_
			 = (Class246_Sub1) ((Class84) this).aClass218_635
					       .method2809(false)) {
		    if (((Class246_Sub3) (((Class246_Sub1) class246_sub1_4_)
					  .aClass246_Sub3_5069)).anInt5083
			<= ((Class246_Sub3) class246_sub3).anInt5083) {
			Class151_Sub3.method2458(class246_sub1,
						 class246_sub1_4_, (byte) 27);
			return;
		    }
		}
		((Class84) this).aClass218_635.method2808(true, class246_sub1);
	    }
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  ("fh.A(" + i + ','
					   + (class246_sub1 != null ? "{...}"
					      : "null")
					   + ')'));
	}
    }
    
    Class84(boolean bool) {
	try {
	    ((Class84) this).aBoolean637 = bool;
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  "fh.<init>(" + bool + ')');
	}
    }
}
