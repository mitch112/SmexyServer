/* j - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class j extends Class332 implements Interface9
{
    long nativeid;
    
    private final native void b(long l, float f, float f_0_, float f_1_,
				float f_2_, float f_3_, float f_4_, int i,
				int i_5_, int i_6_, int i_7_);
    
    private final native void ma(oa var_oa, int[] is, byte[] is_8_,
				 byte[] is_9_, int i, int i_10_, int i_11_,
				 int i_12_);
    
    final int method3737() {
	return wa(((j) this).nativeid);
    }
    
    final void method3740(int i, int i_13_, int i_14_, int i_15_) {
	A(((j) this).nativeid, i, i_13_, i_14_, i_15_);
    }
    
    private final native void P(long l, int i, int i_16_, int i_17_, int i_18_,
				int i_19_, int i_20_, int i_21_);
    
    private final native void R(long l, boolean bool);
    
    private final native int M(long l);
    
    final void method3728(int i, int i_22_, int i_23_, int i_24_, int i_25_,
			  int i_26_, int i_27_) {
	P(((j) this).nativeid, i, i_22_, i_23_, i_24_, i_25_, i_26_, i_27_);
    }
    
    private final native void h(oa var_oa, int i, int i_28_, int i_29_,
				int i_30_, boolean bool);
    
    final int method3734() {
	return M(((j) this).nativeid);
    }
    
    final int method3731() {
	return I(((j) this).nativeid);
    }
    
    final void method3741(int[] is) {
	CA(((j) this).nativeid, is);
    }
    
    private final native int I(long l);
    
    private final native void W(long l, int i, int i_31_, int i_32_, int i_33_,
				int i_34_);
    
    public final void w(boolean bool) {
	R(((j) this).nativeid, bool);
    }
    
    j(oa var_oa, int i, int i_35_) {
	EA(var_oa, i, i_35_);
    }
    
    final void method3742(int i, int i_36_, int i_37_) {
	N(((j) this).nativeid, i, i_36_, i_37_);
    }
    
    final void method3747(float f, float f_38_, float f_39_, float f_40_,
			  float f_41_, float f_42_, int i, aa var_aa,
			  int i_43_, int i_44_) {
	UA(((j) this).nativeid, f, f_38_, f_39_, f_40_, f_41_, f_42_, i,
	   ((na) (na) var_aa).nativeid, i_43_, i_44_);
    }
    
    private final native void CA(long l, int[] is);
    
    private final native void EA(oa var_oa, int i, int i_45_);
    
    private final native int JA(long l);
    
    j(oa var_oa, int[] is, int i, int i_46_, int i_47_, int i_48_,
      boolean bool) {
	ua(var_oa, is, i, i_46_, i_47_, i_48_, bool);
    }
    
    private final native void UA(long l, float f, float f_49_, float f_50_,
				 float f_51_, float f_52_, float f_53_, int i,
				 long l_54_, int i_55_, int i_56_);
    
    final void method3733(float f, float f_57_, float f_58_, float f_59_,
			  float f_60_, float f_61_, int i, int i_62_,
			  int i_63_, int i_64_) {
	b(((j) this).nativeid, f, f_57_, f_58_, f_59_, f_60_, f_61_, i, i_62_,
	  i_63_, i_64_);
    }
    
    protected final void finalize() {
	if (((j) this).nativeid != 0L)
	    Class192.method2654(false, this);
    }
    
    j(oa var_oa, int[] is, byte[] is_65_, byte[] is_66_, int i, int i_67_,
      int i_68_, int i_69_) {
	ma(var_oa, is, is_65_, is_66_, i, i_67_, i_68_, i_69_);
    }
    
    private final native void YA(long l, int i, int i_70_, int i_71_,
				 int i_72_, int i_73_, int i_74_);
    
    final void method3736(int i, int i_75_, int i_76_, int i_77_, int i_78_,
			  int i_79_) {
	YA(((j) this).nativeid, i, i_75_, i_76_, i_77_, i_78_, i_79_);
    }
    
    final void method3748(int i, int i_80_, int i_81_, int i_82_, int i_83_) {
	W(((j) this).nativeid, i, i_80_, i_81_, i_82_, i_83_);
    }
    
    private final native void ua(oa var_oa, int[] is, int i, int i_84_,
				 int i_85_, int i_86_, boolean bool);
    
    private final native void N(long l, int i, int i_87_, int i_88_);
    
    final void method3729(int i, int i_89_, aa var_aa, int i_90_, int i_91_) {
	V(((j) this).nativeid, i, i_89_, ((na) (na) var_aa).nativeid, i_90_,
	  i_91_);
    }
    
    private final native void V(long l, int i, int i_92_, long l_93_,
				int i_94_, int i_95_);
    
    private final native void A(long l, int i, int i_96_, int i_97_,
				int i_98_);
    
    private final native int wa(long l);
    
    j(oa var_oa, int i, int i_99_, int i_100_, int i_101_, boolean bool) {
	h(var_oa, i, i_99_, i_100_, i_101_, bool);
    }
    
    private final native void RA(long l, int i, int i_102_, int i_103_,
				 int i_104_, int i_105_, int i_106_,
				 int i_107_, int i_108_);
    
    final void method3745(int i, int i_109_, int i_110_, int i_111_,
			  int i_112_, int i_113_, int i_114_, int i_115_) {
	RA(((j) this).nativeid, i, i_109_, i_110_, i_111_, i_112_, i_113_,
	   i_114_, i_115_);
    }
    
    final int method3749() {
	return JA(((j) this).nativeid);
    }
}
