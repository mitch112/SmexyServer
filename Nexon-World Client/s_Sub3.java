/* s_Sub3 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class s_Sub3 extends s
{
    private float aFloat5255;
    private int anInt5256;
    private byte[][] aByteArrayArray5257;
    private Class285[][] aClass285ArrayArray5258;
    private byte[][] aByteArrayArray5259;
    private float aFloat5260;
    private Class328[][] aClass328ArrayArray5261;
    private int anInt5262 = -1;
    private float aFloat5263;
    private float aFloat5264;
    private Class327[][] aClass327ArrayArray5265;
    private Class120[][] aClass120ArrayArray5266;
    private float aFloat5267;
    private float aFloat5268;
    private ha_Sub2 aHa_Sub2_5269;
    private float aFloat5270;
    private float aFloat5271;
    private Class193[][] aClass193ArrayArray5272;
    private float aFloat5273;
    private float aFloat5274;
    private float aFloat5275;
    private float aFloat5276;
    
    final void ka(int i, int i_0_, int i_1_) {
	if (aByteArrayArray5259[i][i_0_] < i_1_)
	    aByteArrayArray5259[i][i_0_] = (byte) i_1_;
    }
    
    final void method3422(int i, int i_2_, int i_3_, int i_4_, int i_5_,
			  int i_6_, int i_7_, boolean[][] bools) {
	Class235 class235 = aHa_Sub2_5269.method1921(Thread.currentThread());
	Class12 class12 = ((Class235) class235).aClass12_1767;
	((Class12) class12).anInt137 = 0;
	((Class12) class12).aBoolean135 = true;
	aHa_Sub2_5269.ya();
	if (aClass193ArrayArray5272 != null || aClass120ArrayArray5266 != null)
	    method3444(i, i_2_, i_3_, i_4_, i_5_, i_6_, i_7_, bools, class235,
		       class12, ((Class235) class235).anIntArray1795,
		       ((Class235) class235).anIntArray1788);
	else if (aClass327ArrayArray5265 != null)
	    method3437(i, i_2_, i_3_, i_4_, i_5_, i_6_, i_7_, bools, class235,
		       class12, ((Class235) class235).anIntArray1795,
		       ((Class235) class235).anIntArray1788);
    }
    
    s_Sub3(ha_Sub2 var_ha_Sub2, int i, int i_8_, int i_9_, int i_10_,
	   int[][] is, int[][] is_11_, int i_12_) {
	super(i_9_, i_10_, i_12_, is);
	aHa_Sub2_5269 = var_ha_Sub2;
	anInt5256 = i_8_;
	aByteArrayArray5257 = new byte[i_9_ + 1][i_10_ + 1];
	int i_13_ = ((ha_Sub2) aHa_Sub2_5269).anInt4516 >> 9;
	for (int i_14_ = 1; i_14_ < i_10_; i_14_++) {
	    for (int i_15_ = 1; i_15_ < i_9_; i_15_++) {
		int i_16_ = i_13_;
		int i_17_
		    = is_11_[i_15_ + 1][i_14_] - is_11_[i_15_ - 1][i_14_];
		int i_18_
		    = is_11_[i_15_][i_14_ + 1] - is_11_[i_15_][i_14_ - 1];
		int i_19_
		    = (int) Math.sqrt((double) (i_17_ * i_17_ + 512 * i_12_
						+ i_18_ * i_18_));
		int i_20_ = (i_17_ << 8) / i_19_;
		int i_21_ = -512 * i_12_ / i_19_;
		int i_22_ = (i_18_ << 8) / i_19_;
		i_16_ += (((ha_Sub2) aHa_Sub2_5269).anInt4481 * i_20_
			  + ((ha_Sub2) aHa_Sub2_5269).anInt4515 * i_21_
			  + ((ha_Sub2) aHa_Sub2_5269).anInt4500 * i_22_) >> 17;
		i_16_ >>= 1;
		if (i_16_ < 2)
		    i_16_ = 2;
		else if (i_16_ > 126)
		    i_16_ = 126;
		aByteArrayArray5257[i_15_][i_14_] = (byte) i_16_;
	    }
	}
	aByteArrayArray5259 = new byte[i_9_ + 1][i_10_ + 1];
    }
    
    final r fa(int i, int i_23_, r var_r) {
	return null;
    }
    
    private final void method3437(int i, int i_24_, int i_25_, int i_26_,
				  int i_27_, int i_28_, int i_29_,
				  boolean[][] bools, Class235 class235,
				  Class12 class12, int[] is, int[] is_30_) {
	int i_31_ = (i_29_ - i_27_) * i_25_ / 256;
	int i_32_ = i_25_ >> 8;
	boolean bool = ((Class235) class235).aBoolean1762;
	aHa_Sub2_5269.C(false);
	((Class12) class12).aBoolean134 = false;
	((Class12) class12).aBoolean130 = false;
	int i_33_ = i;
	int i_34_ = i_24_ + i_31_;
	for (int i_35_ = i_26_; i_35_ < i_28_; i_35_++) {
	    for (int i_36_ = i_27_; i_36_ < i_29_; i_36_++) {
		if (bools[i_35_ - i_26_][i_36_ - i_27_]) {
		    if (aClass327ArrayArray5265[i_35_][i_36_] != null) {
			Class327 class327
			    = aClass327ArrayArray5265[i_35_][i_36_];
			if (((Class327) class327).aShort2744 != -1
			    && (((Class327) class327).aByte2740 & 0x2) == 0
			    && ((Class327) class327).anInt2743 == -1) {
			    int i_37_ = aHa_Sub2_5269.method1926(((Class327)
								  class327)
								 .aShort2744);
			    class12.method216((float) (i_34_ - i_32_),
					      (float) (i_34_ - i_32_),
					      (float) i_34_,
					      (float) (i_33_ + i_32_),
					      (float) i_33_,
					      (float) (i_33_ + i_32_), 100.0F,
					      100.0F, 100.0F,
					      (float) (Class246_Sub7.method3132
						       ((((Class327) class327)
							 .aShort2745) & 0xffff,
							(byte) 118, i_37_)),
					      (float) (Class246_Sub7.method3132
						       ((((Class327) class327)
							 .aShort2742) & 0xffff,
							(byte) 118, i_37_)),
					      (float) (Class246_Sub7.method3132
						       ((((Class327) class327)
							 .aShort2739) & 0xffff,
							(byte) 118, i_37_)));
			    class12.method216((float) i_34_, (float) i_34_,
					      (float) (i_34_ - i_32_),
					      (float) i_33_,
					      (float) (i_33_ + i_32_),
					      (float) i_33_, 100.0F, 100.0F,
					      100.0F,
					      (float) (Class246_Sub7.method3132
						       ((((Class327) class327)
							 .aShort2741) & 0xffff,
							(byte) 118, i_37_)),
					      (float) (Class246_Sub7.method3132
						       ((((Class327) class327)
							 .aShort2739) & 0xffff,
							(byte) 118, i_37_)),
					      (float) (Class246_Sub7.method3132
						       ((((Class327) class327)
							 .aShort2742) & 0xffff,
							(byte) 118, i_37_)));
			} else if (((Class327) class327).anInt2743 == -1) {
			    class12.method216
				((float) (i_34_ - i_32_),
				 (float) (i_34_ - i_32_), (float) i_34_,
				 (float) (i_33_ + i_32_), (float) i_33_,
				 (float) (i_33_ + i_32_), 100.0F, 100.0F,
				 100.0F,
				 (float) (((Class327) class327).aShort2745
					  & 0xffff),
				 (float) (((Class327) class327).aShort2742
					  & 0xffff),
				 (float) (((Class327) class327).aShort2739
					  & 0xffff));
			    class12.method216
				((float) i_34_, (float) i_34_,
				 (float) (i_34_ - i_32_), (float) i_33_,
				 (float) (i_33_ + i_32_), (float) i_33_,
				 100.0F, 100.0F, 100.0F,
				 (float) (((Class327) class327).aShort2741
					  & 0xffff),
				 (float) (((Class327) class327).aShort2739
					  & 0xffff),
				 (float) (((Class327) class327).aShort2742
					  & 0xffff));
			} else {
			    int i_38_ = ((Class327) class327).anInt2743;
			    class12.method216((float) (i_34_ - i_32_),
					      (float) (i_34_ - i_32_),
					      (float) i_34_,
					      (float) (i_33_ + i_32_),
					      (float) i_33_,
					      (float) (i_33_ + i_32_), 100.0F,
					      100.0F, 100.0F, (float) i_38_,
					      (float) i_38_, (float) i_38_);
			    class12.method216((float) i_34_, (float) i_34_,
					      (float) (i_34_ - i_32_),
					      (float) i_33_,
					      (float) (i_33_ + i_32_),
					      (float) i_33_, 100.0F, 100.0F,
					      100.0F, (float) i_38_,
					      (float) i_38_, (float) i_38_);
			}
		    } else if (aClass328ArrayArray5261[i_35_][i_36_] != null) {
			Class328 class328
			    = aClass328ArrayArray5261[i_35_][i_36_];
			for (int i_39_ = 0;
			     i_39_ < ((Class328) class328).aShort2748;
			     i_39_++) {
			    is[i_39_]
				= i_33_ + ((((Class328) class328)
					    .aShortArray2755[i_39_])
					   * i_32_ / ((s) this).anInt2206);
			    is_30_[i_39_]
				= i_34_ - ((((Class328) class328)
					    .aShortArray2757[i_39_])
					   * i_32_ / ((s) this).anInt2206);
			}
			for (int i_40_ = 0;
			     i_40_ < ((Class328) class328).aShort2746;
			     i_40_++) {
			    short i_41_
				= ((Class328) class328).aShortArray2758[i_40_];
			    short i_42_
				= ((Class328) class328).aShortArray2751[i_40_];
			    short i_43_
				= ((Class328) class328).aShortArray2759[i_40_];
			    int i_44_ = is[i_41_];
			    int i_45_ = is[i_42_];
			    int i_46_ = is[i_43_];
			    int i_47_ = is_30_[i_41_];
			    int i_48_ = is_30_[i_42_];
			    int i_49_ = is_30_[i_43_];
			    if (((Class328) class328).anIntArray2756 != null
				&& (((Class328) class328).anIntArray2756[i_40_]
				    != -1)) {
				int i_50_ = (((Class328) class328)
					     .anIntArray2756[i_40_]);
				class12.method216
				    ((float) i_47_, (float) i_48_,
				     (float) i_49_, (float) i_44_,
				     (float) i_45_, (float) i_46_, 100.0F,
				     100.0F, 100.0F,
				     (float) (Class246_Sub7.method3132
					      ((((Class328) class328)
						.aShortArray2750[i_41_]),
					       (byte) 118, i_50_)),
				     (float) (Class246_Sub7.method3132
					      ((((Class328) class328)
						.aShortArray2750[i_42_]),
					       (byte) 118, i_50_)),
				     (float) (Class246_Sub7.method3132
					      ((((Class328) class328)
						.aShortArray2750[i_43_]),
					       (byte) 118, i_50_)));
			    } else if ((((Class328) class328).aShortArray2752
					!= null)
				       && (((Class328) class328)
					   .aShortArray2752[i_40_]) != -1) {
				int i_51_
				    = aHa_Sub2_5269.method1926(((Class328)
								class328)
							       .aShortArray2752
							       [i_40_]);
				class12.method216
				    ((float) i_47_, (float) i_48_,
				     (float) i_49_, (float) i_44_,
				     (float) i_45_, (float) i_46_, 100.0F,
				     100.0F, 100.0F,
				     (float) (Class246_Sub7.method3132
					      ((((Class328) class328)
						.aShortArray2750[i_41_]),
					       (byte) 118, i_51_)),
				     (float) (Class246_Sub7.method3132
					      ((((Class328) class328)
						.aShortArray2750[i_42_]),
					       (byte) 118, i_51_)),
				     (float) (Class246_Sub7.method3132
					      ((((Class328) class328)
						.aShortArray2750[i_43_]),
					       (byte) 118, i_51_)));
			    } else {
				int i_52_ = (((Class328) class328)
					     .anIntArray2749[i_40_]);
				class12.method216
				    ((float) i_47_, (float) i_48_,
				     (float) i_49_, (float) i_44_,
				     (float) i_45_, (float) i_46_, 100.0F,
				     100.0F, 100.0F,
				     (float) (Class246_Sub7.method3132
					      ((((Class328) class328)
						.aShortArray2750[i_41_]),
					       (byte) 118, i_52_)),
				     (float) (Class246_Sub7.method3132
					      ((((Class328) class328)
						.aShortArray2750[i_42_]),
					       (byte) 118, i_52_)),
				     (float) (Class246_Sub7.method3132
					      ((((Class328) class328)
						.aShortArray2750[i_43_]),
					       (byte) 118, i_52_)));
			    }
			}
		    }
		}
		i_34_ -= i_32_;
	    }
	    i_34_ = i_24_ + i_31_;
	    i_33_ += i_32_;
	}
	((Class12) class12).aBoolean134 = true;
	aHa_Sub2_5269.C(bool);
    }
    
    final void method3421(Class98_Sub5 class98_sub5, int[] is) {
	/* empty */
    }
    
    private final void method3438
	(int i, int i_53_, boolean bool, Class235 class235, Class12 class12,
	 int[] is, int[] is_54_, int[] is_55_, int[] is_56_, int i_57_) {
	Class120 class120 = aClass120ArrayArray5266[i][i_53_];
	if (i_57_ == 0 || (i_57_ & 0x2) == 0) {
	    if (class120 != null) {
		if (anInt5262 == -1) {
		    for (int i_58_ = 0;
			 i_58_ < ((Class120) class120).aShort994; i_58_++) {
			int i_59_
			    = (((Class120) class120).aShortArray995[i_58_]
			       + (i << ((s) this).anInt2200));
			int i_60_
			    = ((Class120) class120).aShortArray996[i_58_];
			int i_61_
			    = (((Class120) class120).aShortArray992[i_58_]
			       + (i_53_ << ((s) this).anInt2200));
			float f = aFloat5274 + (aFloat5260 * (float) i_59_
						+ aFloat5270 * (float) i_60_
						+ aFloat5263 * (float) i_61_);
			if (f <= (float) ((ha_Sub2) aHa_Sub2_5269).anInt4502)
			    return;
			is_56_[i_58_] = 0;
			if (bool) {
			    int i_62_
				= (int) (f - (float) (((Class235) class235)
						      .anInt1761));
			    if (i_62_ > 255)
				i_62_ = 255;
			    if (i_62_ > 0) {
				is_56_[i_58_] = i_62_;
				int i_63_ = ((((Class120) class120)
					      .aShortArray993[i_58_])
					     * i_62_ / 255);
				if (i_63_ > 0)
				    i_60_ -= i_63_;
			    }
			} else if (((Class235) class235).aBoolean1758) {
			    int i_64_
				= (int) (f - (float) (((Class235) class235)
						      .anInt1761));
			    if (i_64_ > 0) {
				is_56_[i_58_] = i_64_;
				if (is_56_[i_58_] > 255)
				    is_56_[i_58_] = 255;
			    }
			}
			float f_65_
			    = aFloat5268 + (aFloat5275 * (float) i_59_
					    + aFloat5271 * (float) i_60_
					    + aFloat5276 * (float) i_61_);
			float f_66_
			    = aFloat5255 + (aFloat5264 * (float) i_59_
					    + aFloat5273 * (float) i_60_
					    + aFloat5267 * (float) i_61_);
			is[i_58_]
			    = (((Class12) class12).anInt136
			       + (int) (f_65_
					* (float) (((ha_Sub2) aHa_Sub2_5269)
						   .anInt4514)
					/ f));
			is_54_[i_58_]
			    = (((Class12) class12).anInt128
			       + (int) (f_66_
					* (float) (((ha_Sub2) aHa_Sub2_5269)
						   .anInt4490)
					/ f));
			is_55_[i_58_] = (int) f;
		    }
		} else {
		    for (int i_67_ = 0;
			 i_67_ < ((Class120) class120).aShort994; i_67_++) {
			int i_68_
			    = (((Class120) class120).aShortArray995[i_67_]
			       + (i << ((s) this).anInt2200));
			int i_69_
			    = ((Class120) class120).aShortArray996[i_67_];
			int i_70_
			    = (((Class120) class120).aShortArray992[i_67_]
			       + (i_53_ << ((s) this).anInt2200));
			float f = aFloat5274 + (aFloat5260 * (float) i_68_
						+ aFloat5270 * (float) i_69_
						+ aFloat5263 * (float) i_70_);
			is_56_[i_67_] = 0;
			if (bool) {
			    int i_71_
				= anInt5262 - ((Class235) class235).anInt1761;
			    if (i_71_ > 255)
				i_71_ = 255;
			    if (i_71_ > 0) {
				is_56_[i_67_] = i_71_;
				int i_72_ = ((((Class120) class120)
					      .aShortArray993[i_67_])
					     * i_71_ / 255);
				if (i_72_ > 0)
				    i_69_ -= i_72_;
			    }
			} else if (((Class235) class235).aBoolean1758) {
			    int i_73_
				= anInt5262 - ((Class235) class235).anInt1761;
			    if (i_73_ > 0) {
				is_56_[i_67_] = i_73_;
				if (is_56_[i_67_] > 255)
				    is_56_[i_67_] = 255;
			    }
			}
			float f_74_
			    = aFloat5268 + (aFloat5275 * (float) i_68_
					    + aFloat5271 * (float) i_69_
					    + aFloat5276 * (float) i_70_);
			float f_75_
			    = aFloat5255 + (aFloat5264 * (float) i_68_
					    + aFloat5273 * (float) i_69_
					    + aFloat5267 * (float) i_70_);
			is[i_67_]
			    = (((Class12) class12).anInt136
			       + (int) (f_74_
					* (float) (((ha_Sub2) aHa_Sub2_5269)
						   .anInt4514)
					/ (float) anInt5262));
			is_54_[i_67_]
			    = (((Class12) class12).anInt128
			       + (int) (f_75_
					* (float) (((ha_Sub2) aHa_Sub2_5269)
						   .anInt4490)
					/ (float) anInt5262));
			is_55_[i_67_] = (int) f;
		    }
		}
		float f = (float) ((s) this).anInt2206;
		for (int i_76_ = 0; i_76_ < ((Class120) class120).aShort991;
		     i_76_++) {
		    int i_77_ = i_76_ * 3;
		    int i_78_ = i_77_ + 1;
		    int i_79_ = i_78_ + 1;
		    int i_80_ = is[i_77_];
		    int i_81_ = is[i_78_];
		    int i_82_ = is[i_79_];
		    int i_83_ = is_54_[i_77_];
		    int i_84_ = is_54_[i_78_];
		    int i_85_ = is_54_[i_79_];
		    if (((i_80_ - i_81_) * (i_85_ - i_84_)
			 - (i_83_ - i_84_) * (i_82_ - i_81_))
			> 0) {
			((Class12) class12).aBoolean135
			    = (i_80_ < 0 || i_81_ < 0 || i_82_ < 0
			       || i_80_ > ((Class12) class12).anInt141
			       || i_81_ > ((Class12) class12).anInt141
			       || i_82_ > ((Class12) class12).anInt141);
			if (is_56_[i_77_] + is_56_[i_78_] + is_56_[i_79_]
			    < 765) {
			    int i_86_ = i << ((s) this).anInt2200;
			    int i_87_ = i_53_ << ((s) this).anInt2200;
			    if ((((Class120) class120).anIntArray999[i_77_]
				 & 0xffffff)
				!= 0) {
				if (((((Class120) class120).aShortArray998
				      [i_77_])
				     == (((Class120) class120).aShortArray998
					 [i_78_]))
				    && ((((Class120) class120).aShortArray998
					 [i_77_])
					== (((Class120) class120)
					    .aShortArray998[i_79_]))
				    && ((((Class120) class120).aShortArray990
					 [i_77_])
					== (((Class120) class120)
					    .aShortArray990[i_78_]))
				    && ((((Class120) class120).aShortArray990
					 [i_77_])
					== (((Class120) class120)
					    .aShortArray990[i_79_])))
				    class12.method212
					((float) i_83_, (float) i_84_,
					 (float) i_85_, (float) i_80_,
					 (float) i_81_, (float) i_82_,
					 (float) is_55_[i_77_],
					 (float) is_55_[i_78_],
					 (float) is_55_[i_79_],
					 ((float) (i_86_
						   + (((Class120) class120)
						      .aShortArray995[i_77_]))
					  / (float) (((Class120) class120)
						     .aShortArray990[i_77_])),
					 ((float) (i_86_
						   + (((Class120) class120)
						      .aShortArray995[i_78_]))
					  / (float) (((Class120) class120)
						     .aShortArray990[i_78_])),
					 ((float) (i_86_
						   + (((Class120) class120)
						      .aShortArray995[i_79_]))
					  / (float) (((Class120) class120)
						     .aShortArray990[i_79_])),
					 ((float) (i_87_
						   + (((Class120) class120)
						      .aShortArray992[i_77_]))
					  / (float) (((Class120) class120)
						     .aShortArray990[i_77_])),
					 ((float) (i_87_
						   + (((Class120) class120)
						      .aShortArray992[i_78_]))
					  / (float) (((Class120) class120)
						     .aShortArray990[i_78_])),
					 ((float) (i_87_
						   + (((Class120) class120)
						      .aShortArray992[i_79_]))
					  / (float) (((Class120) class120)
						     .aShortArray990[i_79_])),
					 (((Class120) class120).anIntArray999
					  [i_77_]),
					 (((Class120) class120).anIntArray999
					  [i_78_]),
					 (((Class120) class120).anIntArray999
					  [i_79_]),
					 ((Class235) class235).anInt1763,
					 is_56_[i_77_], is_56_[i_78_],
					 is_56_[i_79_],
					 (((Class120) class120).aShortArray998
					  [i_77_]));
				else
				    class12.method209
					((float) i_83_, (float) i_84_,
					 (float) i_85_, (float) i_80_,
					 (float) i_81_, (float) i_82_,
					 (float) is_55_[i_77_],
					 (float) is_55_[i_78_],
					 (float) is_55_[i_79_],
					 ((float) (i_86_
						   + (((Class120) class120)
						      .aShortArray995[i_77_]))
					  / f),
					 ((float) (i_86_
						   + (((Class120) class120)
						      .aShortArray995[i_78_]))
					  / f),
					 ((float) (i_86_
						   + (((Class120) class120)
						      .aShortArray995[i_79_]))
					  / f),
					 ((float) (i_87_
						   + (((Class120) class120)
						      .aShortArray992[i_77_]))
					  / f),
					 ((float) (i_87_
						   + (((Class120) class120)
						      .aShortArray992[i_78_]))
					  / f),
					 ((float) (i_87_
						   + (((Class120) class120)
						      .aShortArray992[i_79_]))
					  / f),
					 (((Class120) class120).anIntArray999
					  [i_77_]),
					 (((Class120) class120).anIntArray999
					  [i_78_]),
					 (((Class120) class120).anIntArray999
					  [i_79_]),
					 ((Class235) class235).anInt1763,
					 is_56_[i_77_], is_56_[i_78_],
					 is_56_[i_79_],
					 (((Class120) class120).aShortArray998
					  [i_77_]),
					 f / (float) (((Class120) class120)
						      .aShortArray990[i_77_]),
					 (((Class120) class120).aShortArray998
					  [i_78_]),
					 f / (float) (((Class120) class120)
						      .aShortArray990[i_78_]),
					 (((Class120) class120).aShortArray998
					  [i_79_]),
					 f / (float) (((Class120) class120)
						      .aShortArray990[i_79_]));
			    }
			} else
			    class12.method208((float) i_83_, (float) i_84_,
					      (float) i_85_, (float) i_80_,
					      (float) i_81_, (float) i_82_,
					      (float) is_55_[i_77_],
					      (float) is_55_[i_78_],
					      (float) is_55_[i_79_],
					      ((Class235) class235).anInt1763);
		    }
		}
	    }
	}
    }
    
    private static final int method3439(int i, int i_88_) {
	int i_89_ = (i & 0xff0000) * i_88_ >> 23;
	if (i_89_ < 2)
	    i_89_ = 2;
	else if (i_89_ > 253)
	    i_89_ = 253;
	int i_90_ = (i & 0xff00) * i_88_ >> 15;
	if (i_90_ < 2)
	    i_90_ = 2;
	else if (i_90_ > 253)
	    i_90_ = 253;
	int i_91_ = (i & 0xff) * i_88_ >> 7;
	if (i_91_ < 2)
	    i_91_ = 2;
	else if (i_91_ > 253)
	    i_91_ = 253;
	return i_89_ << 16 | i_90_ << 8 | i_91_;
    }
    
    final void YA() {
	aByteArrayArray5257 = null;
	aByteArrayArray5259 = null;
    }
    
    private final void method3440(int i, int i_92_, Class12 class12, int[] is,
				  int[] is_93_, int[] is_94_, int[] is_95_,
				  int i_96_) {
	Class327 class327 = aClass327ArrayArray5265[i][i_92_];
	if (class327 != null) {
	    if ((((Class327) class327).aByte2740 & 0x2) == 0) {
		if (i_96_ != 0) {
		    if ((((Class327) class327).aByte2740 & 0x4) != 0) {
			if ((i_96_ & 0x1) != 0)
			    return;
		    } else if ((i_96_ & 0x2) != 0)
			return;
		}
		int i_97_ = i * ((s) this).anInt2206;
		int i_98_ = i_97_ + ((s) this).anInt2206;
		int i_99_ = i_92_ * ((s) this).anInt2206;
		int i_100_ = i_99_ + ((s) this).anInt2206;
		float f;
		float f_101_;
		float f_102_;
		float f_103_;
		int i_104_;
		int i_105_;
		int i_106_;
		int i_107_;
		int i_108_;
		int i_109_;
		int i_110_;
		int i_111_;
		if ((((Class327) class327).aByte2740 & 0x1) != 0) {
		    int i_112_ = ((s) this).anIntArrayArray2201[i][i_92_];
		    float f_113_ = aFloat5270 * (float) i_112_;
		    if (anInt5262 == -1) {
			f = aFloat5274 + (aFloat5260 * (float) i_97_ + f_113_
					  + aFloat5263 * (float) i_99_);
			if (f <= (float) ((ha_Sub2) aHa_Sub2_5269).anInt4502)
			    return;
			f_101_
			    = aFloat5274 + (aFloat5260 * (float) i_98_ + f_113_
					    + aFloat5263 * (float) i_99_);
			if (f_101_
			    <= (float) ((ha_Sub2) aHa_Sub2_5269).anInt4502)
			    return;
			f_102_
			    = aFloat5274 + (aFloat5260 * (float) i_98_ + f_113_
					    + aFloat5263 * (float) i_100_);
			if (f_102_
			    <= (float) ((ha_Sub2) aHa_Sub2_5269).anInt4502)
			    return;
			f_103_
			    = aFloat5274 + (aFloat5260 * (float) i_97_ + f_113_
					    + aFloat5263 * (float) i_100_);
			if (f_103_
			    <= (float) ((ha_Sub2) aHa_Sub2_5269).anInt4502)
			    return;
		    } else {
			f = aFloat5274 + (aFloat5260 * (float) i_97_ + f_113_
					  + aFloat5263 * (float) i_99_);
			f_101_
			    = aFloat5274 + (aFloat5260 * (float) i_98_ + f_113_
					    + aFloat5263 * (float) i_99_);
			f_102_
			    = aFloat5274 + (aFloat5260 * (float) i_98_ + f_113_
					    + aFloat5263 * (float) i_100_);
			f_103_
			    = aFloat5274 + (aFloat5260 * (float) i_97_ + f_113_
					    + aFloat5263 * (float) i_100_);
		    }
		    float f_114_ = aFloat5271 * (float) i_112_;
		    float f_115_ = aFloat5273 * (float) i_112_;
		    if (anInt5262 == -1) {
			float f_116_
			    = aFloat5268 + (aFloat5275 * (float) i_97_ + f_114_
					    + aFloat5276 * (float) i_99_);
			i_104_ = (((Class12) class12).anInt136
				  + (int) (f_116_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4514)
					   / f));
			float f_117_
			    = aFloat5255 + (aFloat5264 * (float) i_97_ + f_115_
					    + aFloat5267 * (float) i_99_);
			i_105_ = (((Class12) class12).anInt128
				  + (int) (f_117_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4490)
					   / f));
			float f_118_
			    = aFloat5268 + (aFloat5275 * (float) i_98_ + f_114_
					    + aFloat5276 * (float) i_99_);
			i_106_ = (((Class12) class12).anInt136
				  + (int) (f_118_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4514)
					   / f_101_));
			float f_119_
			    = aFloat5255 + (aFloat5264 * (float) i_98_ + f_115_
					    + aFloat5267 * (float) i_99_);
			i_107_ = (((Class12) class12).anInt128
				  + (int) (f_119_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4490)
					   / f_101_));
			float f_120_
			    = aFloat5268 + (aFloat5275 * (float) i_98_ + f_114_
					    + aFloat5276 * (float) i_100_);
			i_108_ = (((Class12) class12).anInt136
				  + (int) (f_120_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4514)
					   / f_102_));
			float f_121_
			    = aFloat5255 + (aFloat5264 * (float) i_98_ + f_115_
					    + aFloat5267 * (float) i_100_);
			i_109_ = (((Class12) class12).anInt128
				  + (int) (f_121_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4490)
					   / f_102_));
			float f_122_
			    = aFloat5268 + (aFloat5275 * (float) i_97_ + f_114_
					    + aFloat5276 * (float) i_100_);
			i_110_ = (((Class12) class12).anInt136
				  + (int) (f_122_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4514)
					   / f_103_));
			float f_123_
			    = aFloat5255 + (aFloat5264 * (float) i_97_ + f_115_
					    + aFloat5267 * (float) i_100_);
			i_111_ = (((Class12) class12).anInt128
				  + (int) (f_123_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4490)
					   / f_103_));
		    } else {
			float f_124_
			    = aFloat5268 + (aFloat5275 * (float) i_97_ + f_114_
					    + aFloat5276 * (float) i_99_);
			i_104_ = (((Class12) class12).anInt136
				  + (int) (f_124_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4514)
					   / (float) anInt5262));
			float f_125_
			    = aFloat5255 + (aFloat5264 * (float) i_97_ + f_115_
					    + aFloat5267 * (float) i_99_);
			i_105_ = (((Class12) class12).anInt128
				  + (int) (f_125_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4490)
					   / (float) anInt5262));
			float f_126_
			    = aFloat5268 + (aFloat5275 * (float) i_98_ + f_114_
					    + aFloat5276 * (float) i_99_);
			i_106_ = (((Class12) class12).anInt136
				  + (int) (f_126_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4514)
					   / (float) anInt5262));
			float f_127_
			    = aFloat5255 + (aFloat5264 * (float) i_98_ + f_115_
					    + aFloat5267 * (float) i_99_);
			i_107_ = (((Class12) class12).anInt128
				  + (int) (f_127_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4490)
					   / (float) anInt5262));
			float f_128_
			    = aFloat5268 + (aFloat5275 * (float) i_98_ + f_114_
					    + aFloat5276 * (float) i_100_);
			i_108_ = (((Class12) class12).anInt136
				  + (int) (f_128_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4514)
					   / (float) anInt5262));
			float f_129_
			    = aFloat5255 + (aFloat5264 * (float) i_98_ + f_115_
					    + aFloat5267 * (float) i_100_);
			i_109_ = (((Class12) class12).anInt128
				  + (int) (f_129_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4490)
					   / (float) anInt5262));
			float f_130_
			    = aFloat5268 + (aFloat5275 * (float) i_97_ + f_114_
					    + aFloat5276 * (float) i_100_);
			i_110_ = (((Class12) class12).anInt136
				  + (int) (f_130_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4514)
					   / (float) anInt5262));
			float f_131_
			    = aFloat5255 + (aFloat5264 * (float) i_97_ + f_115_
					    + aFloat5267 * (float) i_100_);
			i_111_ = (((Class12) class12).anInt128
				  + (int) (f_131_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4490)
					   / (float) anInt5262));
		    }
		} else {
		    int i_132_ = ((s) this).anIntArrayArray2201[i][i_92_];
		    int i_133_ = ((s) this).anIntArrayArray2201[i + 1][i_92_];
		    int i_134_
			= ((s) this).anIntArrayArray2201[i + 1][i_92_ + 1];
		    int i_135_ = ((s) this).anIntArrayArray2201[i][i_92_ + 1];
		    if (anInt5262 == -1) {
			f = aFloat5274 + (aFloat5260 * (float) i_97_
					  + aFloat5270 * (float) i_132_
					  + aFloat5263 * (float) i_99_);
			if (f <= (float) ((ha_Sub2) aHa_Sub2_5269).anInt4502)
			    return;
			f_101_ = aFloat5274 + (aFloat5260 * (float) i_98_
					       + aFloat5270 * (float) i_133_
					       + aFloat5263 * (float) i_99_);
			if (f_101_
			    <= (float) ((ha_Sub2) aHa_Sub2_5269).anInt4502)
			    return;
			f_102_ = aFloat5274 + (aFloat5260 * (float) i_98_
					       + aFloat5270 * (float) i_134_
					       + aFloat5263 * (float) i_100_);
			if (f_102_
			    <= (float) ((ha_Sub2) aHa_Sub2_5269).anInt4502)
			    return;
			f_103_ = aFloat5274 + (aFloat5260 * (float) i_97_
					       + aFloat5270 * (float) i_135_
					       + aFloat5263 * (float) i_100_);
			if (f_103_
			    <= (float) ((ha_Sub2) aHa_Sub2_5269).anInt4502)
			    return;
			float f_136_
			    = aFloat5268 + (aFloat5275 * (float) i_97_
					    + aFloat5271 * (float) i_132_
					    + aFloat5276 * (float) i_99_);
			i_104_ = (((Class12) class12).anInt136
				  + (int) (f_136_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4514)
					   / f));
			float f_137_
			    = aFloat5255 + (aFloat5264 * (float) i_97_
					    + aFloat5273 * (float) i_132_
					    + aFloat5267 * (float) i_99_);
			i_105_ = (((Class12) class12).anInt128
				  + (int) (f_137_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4490)
					   / f));
			float f_138_
			    = aFloat5268 + (aFloat5275 * (float) i_98_
					    + aFloat5271 * (float) i_133_
					    + aFloat5276 * (float) i_99_);
			i_106_ = (((Class12) class12).anInt136
				  + (int) (f_138_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4514)
					   / f_101_));
			float f_139_
			    = aFloat5255 + (aFloat5264 * (float) i_98_
					    + aFloat5273 * (float) i_133_
					    + aFloat5267 * (float) i_99_);
			i_107_ = (((Class12) class12).anInt128
				  + (int) (f_139_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4490)
					   / f_101_));
			float f_140_
			    = aFloat5268 + (aFloat5275 * (float) i_98_
					    + aFloat5271 * (float) i_134_
					    + aFloat5276 * (float) i_100_);
			i_108_ = (((Class12) class12).anInt136
				  + (int) (f_140_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4514)
					   / f_102_));
			float f_141_
			    = aFloat5255 + (aFloat5264 * (float) i_98_
					    + aFloat5273 * (float) i_134_
					    + aFloat5267 * (float) i_100_);
			i_109_ = (((Class12) class12).anInt128
				  + (int) (f_141_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4490)
					   / f_102_));
			float f_142_
			    = aFloat5268 + (aFloat5275 * (float) i_97_
					    + aFloat5271 * (float) i_135_
					    + aFloat5276 * (float) i_100_);
			i_110_ = (((Class12) class12).anInt136
				  + (int) (f_142_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4514)
					   / f_103_));
			float f_143_
			    = aFloat5255 + (aFloat5264 * (float) i_97_
					    + aFloat5273 * (float) i_135_
					    + aFloat5267 * (float) i_100_);
			i_111_ = (((Class12) class12).anInt128
				  + (int) (f_143_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4490)
					   / f_103_));
		    } else {
			f = aFloat5274 + (aFloat5260 * (float) i_97_
					  + aFloat5270 * (float) i_132_
					  + aFloat5263 * (float) i_99_);
			f_101_ = aFloat5274 + (aFloat5260 * (float) i_98_
					       + aFloat5270 * (float) i_133_
					       + aFloat5263 * (float) i_99_);
			f_102_ = aFloat5274 + (aFloat5260 * (float) i_98_
					       + aFloat5270 * (float) i_134_
					       + aFloat5263 * (float) i_100_);
			f_103_ = aFloat5274 + (aFloat5260 * (float) i_97_
					       + aFloat5270 * (float) i_135_
					       + aFloat5263 * (float) i_100_);
			float f_144_
			    = aFloat5268 + (aFloat5275 * (float) i_97_
					    + aFloat5271 * (float) i_132_
					    + aFloat5276 * (float) i_99_);
			i_104_ = (((Class12) class12).anInt136
				  + (int) (f_144_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4514)
					   / (float) anInt5262));
			float f_145_
			    = aFloat5255 + (aFloat5264 * (float) i_97_
					    + aFloat5273 * (float) i_132_
					    + aFloat5267 * (float) i_99_);
			i_105_ = (((Class12) class12).anInt128
				  + (int) (f_145_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4490)
					   / (float) anInt5262));
			float f_146_
			    = aFloat5268 + (aFloat5275 * (float) i_98_
					    + aFloat5271 * (float) i_133_
					    + aFloat5276 * (float) i_99_);
			i_106_ = (((Class12) class12).anInt136
				  + (int) (f_146_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4514)
					   / (float) anInt5262));
			float f_147_
			    = aFloat5255 + (aFloat5264 * (float) i_98_
					    + aFloat5273 * (float) i_133_
					    + aFloat5267 * (float) i_99_);
			i_107_ = (((Class12) class12).anInt128
				  + (int) (f_147_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4490)
					   / (float) anInt5262));
			float f_148_
			    = aFloat5268 + (aFloat5275 * (float) i_98_
					    + aFloat5271 * (float) i_134_
					    + aFloat5276 * (float) i_100_);
			i_108_ = (((Class12) class12).anInt136
				  + (int) (f_148_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4514)
					   / (float) anInt5262));
			float f_149_
			    = aFloat5255 + (aFloat5264 * (float) i_98_
					    + aFloat5273 * (float) i_134_
					    + aFloat5267 * (float) i_100_);
			i_109_ = (((Class12) class12).anInt128
				  + (int) (f_149_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4490)
					   / (float) anInt5262));
			float f_150_
			    = aFloat5268 + (aFloat5275 * (float) i_97_
					    + aFloat5271 * (float) i_135_
					    + aFloat5276 * (float) i_100_);
			i_110_ = (((Class12) class12).anInt136
				  + (int) (f_150_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4514)
					   / (float) anInt5262));
			float f_151_
			    = aFloat5255 + (aFloat5264 * (float) i_97_
					    + aFloat5273 * (float) i_135_
					    + aFloat5267 * (float) i_100_);
			i_111_ = (((Class12) class12).anInt128
				  + (int) (f_151_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4490)
					   / (float) anInt5262));
		    }
		}
		if (anInt5262 == -1) {
		    if (((i_108_ - i_110_) * (i_107_ - i_111_)
			 - (i_109_ - i_111_) * (i_106_ - i_110_))
			> 0) {
			((Class12) class12).aBoolean135
			    = (i_108_ < 0 || i_110_ < 0 || i_106_ < 0
			       || i_108_ > ((Class12) class12).anInt141
			       || i_110_ > ((Class12) class12).anInt141
			       || i_106_ > ((Class12) class12).anInt141);
			if (((Class327) class327).aShort2744 >= 0)
			    class12.method212
				((float) i_109_, (float) i_111_,
				 (float) i_107_, (float) i_108_,
				 (float) i_110_, (float) i_106_, f_102_,
				 f_103_, f_101_, 1.0F, 0.0F, 1.0F, 1.0F, 1.0F,
				 0.0F,
				 (~0xffffff
				  | (Class221.anIntArray1665
				     [(((Class327) class327).aShort2745
				       & 0xffff)]) & 0xffffff),
				 (~0xffffff
				  | (Class221.anIntArray1665
				     [(((Class327) class327).aShort2742
				       & 0xffff)]) & 0xffffff),
				 (~0xffffff
				  | (Class221.anIntArray1665
				     [(((Class327) class327).aShort2739
				       & 0xffff)]) & 0xffffff),
				 0, 0, 0, 0, ((Class327) class327).aShort2744);
			else
			    class12.method216
				((float) i_109_, (float) i_111_,
				 (float) i_107_, (float) i_108_,
				 (float) i_110_, (float) i_106_,
				 (float) (int) f_102_, (float) (int) f_103_,
				 (float) (int) f_101_,
				 (float) (((Class327) class327).aShort2745
					  & 0xffff),
				 (float) (((Class327) class327).aShort2742
					  & 0xffff),
				 (float) (((Class327) class327).aShort2739
					  & 0xffff));
		    }
		    if (((i_104_ - i_106_) * (i_111_ - i_107_)
			 - (i_105_ - i_107_) * (i_110_ - i_106_))
			> 0) {
			((Class12) class12).aBoolean135
			    = (i_104_ < 0 || i_106_ < 0 || i_110_ < 0
			       || i_104_ > ((Class12) class12).anInt141
			       || i_106_ > ((Class12) class12).anInt141
			       || i_110_ > ((Class12) class12).anInt141);
			if (((Class327) class327).aShort2744 >= 0)
			    class12.method212
				((float) i_105_, (float) i_107_,
				 (float) i_111_, (float) i_104_,
				 (float) i_106_, (float) i_110_, f, f_101_,
				 f_103_, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F,
				 (~0xffffff
				  | (Class221.anIntArray1665
				     [(((Class327) class327).aShort2741
				       & 0xffff)]) & 0xffffff),
				 (~0xffffff
				  | (Class221.anIntArray1665
				     [(((Class327) class327).aShort2739
				       & 0xffff)]) & 0xffffff),
				 (~0xffffff
				  | (Class221.anIntArray1665
				     [(((Class327) class327).aShort2742
				       & 0xffff)]) & 0xffffff),
				 0, 0, 0, 0, ((Class327) class327).aShort2744);
			else
			    class12.method216
				((float) i_105_, (float) i_107_,
				 (float) i_111_, (float) i_104_,
				 (float) i_106_, (float) i_110_,
				 (float) (int) f, (float) (int) f_101_,
				 (float) (int) f_103_,
				 (float) (((Class327) class327).aShort2741
					  & 0xffff),
				 (float) (((Class327) class327).aShort2739
					  & 0xffff),
				 (float) (((Class327) class327).aShort2742
					  & 0xffff));
		    }
		} else {
		    if (((i_108_ - i_110_) * (i_107_ - i_111_)
			 - (i_109_ - i_111_) * (i_106_ - i_110_))
			> 0) {
			((Class12) class12).aBoolean135
			    = (i_108_ < 0 || i_110_ < 0 || i_106_ < 0
			       || i_108_ > ((Class12) class12).anInt141
			       || i_110_ > ((Class12) class12).anInt141
			       || i_106_ > ((Class12) class12).anInt141);
			if (((Class327) class327).aShort2744 >= 0)
			    class12.method212
				((float) i_109_, (float) i_111_,
				 (float) i_107_, (float) i_108_,
				 (float) i_110_, (float) i_106_, f_102_,
				 f_103_, f_101_, 1.0F, 0.0F, 1.0F, 1.0F, 1.0F,
				 0.0F,
				 (~0xffffff
				  | (Class221.anIntArray1665
				     [(((Class327) class327).aShort2745
				       & 0xffff)]) & 0xffffff),
				 (~0xffffff
				  | (Class221.anIntArray1665
				     [(((Class327) class327).aShort2742
				       & 0xffff)]) & 0xffffff),
				 (~0xffffff
				  | (Class221.anIntArray1665
				     [(((Class327) class327).aShort2739
				       & 0xffff)]) & 0xffffff),
				 0, 0, 0, 0, ((Class327) class327).aShort2744);
			else
			    class12.method216
				((float) i_109_, (float) i_111_,
				 (float) i_107_, (float) i_108_,
				 (float) i_110_, (float) i_106_,
				 (float) (int) f_102_, (float) (int) f_103_,
				 (float) (int) f_101_,
				 (float) (((Class327) class327).aShort2745
					  & 0xffff),
				 (float) (((Class327) class327).aShort2742
					  & 0xffff),
				 (float) (((Class327) class327).aShort2739
					  & 0xffff));
		    }
		    if (((i_104_ - i_106_) * (i_111_ - i_107_)
			 - (i_105_ - i_107_) * (i_110_ - i_106_))
			> 0) {
			((Class12) class12).aBoolean135
			    = (i_104_ < 0 || i_106_ < 0 || i_110_ < 0
			       || i_104_ > ((Class12) class12).anInt141
			       || i_106_ > ((Class12) class12).anInt141
			       || i_110_ > ((Class12) class12).anInt141);
			if (((Class327) class327).aShort2744 >= 0)
			    class12.method212
				((float) i_105_, (float) i_107_,
				 (float) i_111_, (float) i_104_,
				 (float) i_106_, (float) i_110_, f, f_101_,
				 f_103_, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F,
				 (~0xffffff
				  | (Class221.anIntArray1665
				     [(((Class327) class327).aShort2741
				       & 0xffff)]) & 0xffffff),
				 (~0xffffff
				  | (Class221.anIntArray1665
				     [(((Class327) class327).aShort2739
				       & 0xffff)]) & 0xffffff),
				 (~0xffffff
				  | (Class221.anIntArray1665
				     [(((Class327) class327).aShort2742
				       & 0xffff)]) & 0xffffff),
				 0, 0, 0, 0, ((Class327) class327).aShort2744);
			else
			    class12.method216
				((float) i_105_, (float) i_107_,
				 (float) i_111_, (float) i_104_,
				 (float) i_106_, (float) i_110_,
				 (float) (int) f, (float) (int) f_101_,
				 (float) (int) f_103_,
				 (float) (((Class327) class327).aShort2741
					  & 0xffff),
				 (float) (((Class327) class327).aShort2739
					  & 0xffff),
				 (float) (((Class327) class327).aShort2742
					  & 0xffff));
		    }
		}
	    }
	} else {
	    Class328 class328 = aClass328ArrayArray5261[i][i_92_];
	    if (class328 != null) {
		if (i_96_ != 0) {
		    if ((((Class328) class328).aByte2747 & 0x4) != 0) {
			if ((i_96_ & 0x1) != 0)
			    return;
		    } else if ((i_96_ & 0x2) != 0)
			return;
		}
		if (anInt5262 == -1) {
		    for (int i_152_ = 0;
			 i_152_ < ((Class328) class328).aShort2748; i_152_++) {
			int i_153_
			    = (((Class328) class328).aShortArray2755[i_152_]
			       + (i << ((s) this).anInt2200));
			short i_154_
			    = ((Class328) class328).aShortArray2754[i_152_];
			int i_155_
			    = (((Class328) class328).aShortArray2757[i_152_]
			       + (i_92_ << ((s) this).anInt2200));
			float f = aFloat5274 + (aFloat5260 * (float) i_153_
						+ aFloat5270 * (float) i_154_
						+ aFloat5263 * (float) i_155_);
			if (f <= (float) ((ha_Sub2) aHa_Sub2_5269).anInt4502)
			    return;
			float f_156_
			    = aFloat5268 + (aFloat5275 * (float) i_153_
					    + aFloat5271 * (float) i_154_
					    + aFloat5276 * (float) i_155_);
			float f_157_
			    = aFloat5255 + (aFloat5264 * (float) i_153_
					    + aFloat5273 * (float) i_154_
					    + aFloat5267 * (float) i_155_);
			is[i_152_]
			    = (((Class12) class12).anInt136
			       + (int) (f_156_
					* (float) (((ha_Sub2) aHa_Sub2_5269)
						   .anInt4514)
					/ f));
			is_93_[i_152_]
			    = (((Class12) class12).anInt128
			       + (int) (f_157_
					* (float) (((ha_Sub2) aHa_Sub2_5269)
						   .anInt4490)
					/ f));
			is_94_[i_152_] = (int) f;
		    }
		} else {
		    for (int i_158_ = 0;
			 i_158_ < ((Class328) class328).aShort2748; i_158_++) {
			int i_159_
			    = (((Class328) class328).aShortArray2755[i_158_]
			       + (i << ((s) this).anInt2200));
			short i_160_
			    = ((Class328) class328).aShortArray2754[i_158_];
			int i_161_
			    = (((Class328) class328).aShortArray2757[i_158_]
			       + (i_92_ << ((s) this).anInt2200));
			float f = aFloat5274 + (aFloat5260 * (float) i_159_
						+ aFloat5270 * (float) i_160_
						+ aFloat5263 * (float) i_161_);
			float f_162_
			    = aFloat5268 + (aFloat5275 * (float) i_159_
					    + aFloat5271 * (float) i_160_
					    + aFloat5276 * (float) i_161_);
			float f_163_
			    = aFloat5255 + (aFloat5264 * (float) i_159_
					    + aFloat5273 * (float) i_160_
					    + aFloat5267 * (float) i_161_);
			is[i_158_]
			    = (((Class12) class12).anInt136
			       + (int) (f_162_
					* (float) (((ha_Sub2) aHa_Sub2_5269)
						   .anInt4514)
					/ (float) anInt5262));
			is_93_[i_158_]
			    = (((Class12) class12).anInt128
			       + (int) (f_163_
					* (float) (((ha_Sub2) aHa_Sub2_5269)
						   .anInt4490)
					/ (float) anInt5262));
			is_94_[i_158_] = (int) f;
		    }
		}
		if (((Class328) class328).aShortArray2752 != null) {
		    if (anInt5262 == -1) {
			for (int i_164_ = 0;
			     i_164_ < ((Class328) class328).aShort2746;
			     i_164_++) {
			    short i_165_ = (((Class328) class328)
					    .aShortArray2758[i_164_]);
			    short i_166_ = (((Class328) class328)
					    .aShortArray2751[i_164_]);
			    short i_167_ = (((Class328) class328)
					    .aShortArray2759[i_164_]);
			    int i_168_ = is[i_165_];
			    int i_169_ = is[i_166_];
			    int i_170_ = is[i_167_];
			    int i_171_ = is_93_[i_165_];
			    int i_172_ = is_93_[i_166_];
			    int i_173_ = is_93_[i_167_];
			    if (((i_168_ - i_169_) * (i_173_ - i_172_)
				 - (i_171_ - i_172_) * (i_170_ - i_169_))
				> 0) {
				((Class12) class12).aBoolean135
				    = (i_168_ < 0 || i_169_ < 0 || i_170_ < 0
				       || i_168_ > ((Class12) class12).anInt141
				       || i_169_ > ((Class12) class12).anInt141
				       || (i_170_
					   > ((Class12) class12).anInt141));
				short i_174_ = (((Class328) class328)
						.aShortArray2752[i_164_]);
				if (i_174_ != -1)
				    class12.method212
					((float) i_171_, (float) i_172_,
					 (float) i_173_, (float) i_168_,
					 (float) i_169_, (float) i_170_,
					 (float) is_94_[i_165_],
					 (float) is_94_[i_166_],
					 (float) is_94_[i_167_],
					 ((float) (((Class328) class328)
						   .aShortArray2755[i_165_])
					  / (float) ((s) this).anInt2206),
					 ((float) (((Class328) class328)
						   .aShortArray2755[i_166_])
					  / (float) ((s) this).anInt2206),
					 ((float) (((Class328) class328)
						   .aShortArray2755[i_167_])
					  / (float) ((s) this).anInt2206),
					 ((float) (((Class328) class328)
						   .aShortArray2757[i_165_])
					  / (float) ((s) this).anInt2206),
					 ((float) (((Class328) class328)
						   .aShortArray2757[i_166_])
					  / (float) ((s) this).anInt2206),
					 ((float) (((Class328) class328)
						   .aShortArray2757[i_167_])
					  / (float) ((s) this).anInt2206),
					 ~0xffffff | ((Class221.anIntArray1665
						       [(((Class328) class328)
							 .aShortArray2750
							 [i_165_]) & 0xffff])
						      & 0xffffff),
					 ~0xffffff | ((Class221.anIntArray1665
						       [(((Class328) class328)
							 .aShortArray2750
							 [i_166_]) & 0xffff])
						      & 0xffffff),
					 ~0xffffff | ((Class221.anIntArray1665
						       [(((Class328) class328)
							 .aShortArray2750
							 [i_167_]) & 0xffff])
						      & 0xffffff),
					 0, 0, 0, 0, i_174_);
				else {
				    int i_175_ = (((Class328) class328)
						  .anIntArray2749[i_164_]);
				    if (i_175_ != -1)
					class12.method216
					    ((float) i_171_, (float) i_172_,
					     (float) i_173_, (float) i_168_,
					     (float) i_169_, (float) i_170_,
					     (float) is_94_[i_165_],
					     (float) is_94_[i_166_],
					     (float) is_94_[i_167_],
					     (float) (Class246_Sub7.method3132
						      ((((Class328) class328)
							.aShortArray2750
							[i_165_]),
						       (byte) 118, i_175_)),
					     (float) (Class246_Sub7.method3132
						      ((((Class328) class328)
							.aShortArray2750
							[i_166_]),
						       (byte) 118, i_175_)),
					     (float) (Class246_Sub7.method3132
						      ((((Class328) class328)
							.aShortArray2750
							[i_167_]),
						       (byte) 118, i_175_)));
				}
			    }
			}
		    } else {
			for (int i_176_ = 0;
			     i_176_ < ((Class328) class328).aShort2746;
			     i_176_++) {
			    short i_177_ = (((Class328) class328)
					    .aShortArray2758[i_176_]);
			    short i_178_ = (((Class328) class328)
					    .aShortArray2751[i_176_]);
			    short i_179_ = (((Class328) class328)
					    .aShortArray2759[i_176_]);
			    int i_180_ = is[i_177_];
			    int i_181_ = is[i_178_];
			    int i_182_ = is[i_179_];
			    int i_183_ = is_93_[i_177_];
			    int i_184_ = is_93_[i_178_];
			    int i_185_ = is_93_[i_179_];
			    if (((i_180_ - i_181_) * (i_185_ - i_184_)
				 - (i_183_ - i_184_) * (i_182_ - i_181_))
				> 0) {
				((Class12) class12).aBoolean135
				    = (i_180_ < 0 || i_181_ < 0 || i_182_ < 0
				       || i_180_ > ((Class12) class12).anInt141
				       || i_181_ > ((Class12) class12).anInt141
				       || (i_182_
					   > ((Class12) class12).anInt141));
				short i_186_ = (((Class328) class328)
						.aShortArray2752[i_176_]);
				if (i_186_ != -1)
				    class12.method212
					((float) i_183_, (float) i_184_,
					 (float) i_185_, (float) i_180_,
					 (float) i_181_, (float) i_182_,
					 (float) is_94_[i_177_],
					 (float) is_94_[i_178_],
					 (float) is_94_[i_179_],
					 ((float) (((Class328) class328)
						   .aShortArray2755[i_177_])
					  / (float) ((s) this).anInt2206),
					 ((float) (((Class328) class328)
						   .aShortArray2755[i_178_])
					  / (float) ((s) this).anInt2206),
					 ((float) (((Class328) class328)
						   .aShortArray2755[i_179_])
					  / (float) ((s) this).anInt2206),
					 ((float) (((Class328) class328)
						   .aShortArray2757[i_177_])
					  / (float) ((s) this).anInt2206),
					 ((float) (((Class328) class328)
						   .aShortArray2757[i_178_])
					  / (float) ((s) this).anInt2206),
					 ((float) (((Class328) class328)
						   .aShortArray2757[i_179_])
					  / (float) ((s) this).anInt2206),
					 ~0xffffff | ((Class221.anIntArray1665
						       [(((Class328) class328)
							 .aShortArray2750
							 [i_177_]) & 0xffff])
						      & 0xffffff),
					 ~0xffffff | ((Class221.anIntArray1665
						       [(((Class328) class328)
							 .aShortArray2750
							 [i_178_]) & 0xffff])
						      & 0xffffff),
					 ~0xffffff | ((Class221.anIntArray1665
						       [(((Class328) class328)
							 .aShortArray2750
							 [i_179_]) & 0xffff])
						      & 0xffffff),
					 0, 0, 0, 0, i_186_);
				else {
				    int i_187_ = (((Class328) class328)
						  .anIntArray2749[i_176_]);
				    if (i_187_ != -1)
					class12.method216
					    ((float) i_183_, (float) i_184_,
					     (float) i_185_, (float) i_180_,
					     (float) i_181_, (float) i_182_,
					     (float) is_94_[i_177_],
					     (float) is_94_[i_178_],
					     (float) is_94_[i_179_],
					     (float) (Class246_Sub7.method3132
						      ((((Class328) class328)
							.aShortArray2750
							[i_177_]),
						       (byte) 118, i_187_)),
					     (float) (Class246_Sub7.method3132
						      ((((Class328) class328)
							.aShortArray2750
							[i_178_]),
						       (byte) 118, i_187_)),
					     (float) (Class246_Sub7.method3132
						      ((((Class328) class328)
							.aShortArray2750
							[i_179_]),
						       (byte) 118, i_187_)));
				}
			    }
			}
		    }
		} else {
		    for (int i_188_ = 0;
			 i_188_ < ((Class328) class328).aShort2746; i_188_++) {
			short i_189_
			    = ((Class328) class328).aShortArray2758[i_188_];
			short i_190_
			    = ((Class328) class328).aShortArray2751[i_188_];
			short i_191_
			    = ((Class328) class328).aShortArray2759[i_188_];
			int i_192_ = is[i_189_];
			int i_193_ = is[i_190_];
			int i_194_ = is[i_191_];
			int i_195_ = is_93_[i_189_];
			int i_196_ = is_93_[i_190_];
			int i_197_ = is_93_[i_191_];
			if (((i_192_ - i_193_) * (i_197_ - i_196_)
			     - (i_195_ - i_196_) * (i_194_ - i_193_))
			    > 0) {
			    int i_198_
				= ((Class328) class328).anIntArray2749[i_188_];
			    if (i_198_ != -1) {
				((Class12) class12).aBoolean135
				    = (i_192_ < 0 || i_193_ < 0 || i_194_ < 0
				       || i_192_ > ((Class12) class12).anInt141
				       || i_193_ > ((Class12) class12).anInt141
				       || (i_194_
					   > ((Class12) class12).anInt141));
				class12.method216
				    ((float) i_195_, (float) i_196_,
				     (float) i_197_, (float) i_192_,
				     (float) i_193_, (float) i_194_,
				     (float) is_94_[i_189_],
				     (float) is_94_[i_190_],
				     (float) is_94_[i_191_],
				     (float) (Class246_Sub7.method3132
					      ((((Class328) class328)
						.aShortArray2750[i_189_]),
					       (byte) 118, i_198_)),
				     (float) (Class246_Sub7.method3132
					      ((((Class328) class328)
						.aShortArray2750[i_190_]),
					       (byte) 118, i_198_)),
				     (float) (Class246_Sub7.method3132
					      ((((Class328) class328)
						.aShortArray2750[i_191_]),
					       (byte) 118, i_198_)));
			    }
			}
		    }
		}
	    }
	}
    }
    
    final boolean method3418(r var_r, int i, int i_199_, int i_200_,
			     int i_201_, boolean bool) {
	return false;
    }
    
    private final boolean method3441(int i) {
	if ((anInt5256 & 0x8) == 0)
	    return false;
	if (i == 4)
	    return true;
	if (i == 8)
	    return true;
	if (i == 9)
	    return true;
	return false;
    }
    
    final void method3425(int i, int i_202_) {
	method3443(i, i_202_, 0);
    }
    
    final void U(int i, int i_203_, int[] is, int[] is_204_, int[] is_205_,
		 int[] is_206_, int[] is_207_, int[] is_208_, int[] is_209_,
		 int[] is_210_, int i_211_, int i_212_, int i_213_,
		 boolean bool) {
	boolean bool_214_ = (anInt5256 & 0x20) == 0;
	if (aClass193ArrayArray5272 == null && !bool_214_) {
	    aClass193ArrayArray5272
		= new Class193[((s) this).anInt2203][((s) this).anInt2204];
	    aClass285ArrayArray5258
		= new Class285[((s) this).anInt2203][((s) this).anInt2204];
	} else if (aClass120ArrayArray5266 == null && bool_214_)
	    aClass120ArrayArray5266
		= new Class120[((s) this).anInt2203][((s) this).anInt2204];
	else if (aClass327ArrayArray5265 != null)
	    throw new IllegalStateException();
	if (is != null && is.length != 0) {
	    for (int i_215_ = 0; i_215_ < is_207_.length; i_215_++) {
		if (is_207_[i_215_] == -1)
		    is_207_[i_215_] = 0;
		else
		    is_207_[i_215_]
			= (Class221.anIntArray1665
			   [(Class111_Sub2.method2117(is_207_[i_215_], -67)
			     & 0xffff)]) << 8 | 0xff;
	    }
	    if (is_208_ != null) {
		for (int i_216_ = 0; i_216_ < is_208_.length; i_216_++) {
		    if (is_208_[i_216_] == -1)
			is_208_[i_216_] = 0;
		    else
			is_208_[i_216_]
			    = (Class221.anIntArray1665
			       [(Class111_Sub2.method2117(is_208_[i_216_], 57)
				 & 0xffff)]) << 8 | 0xff;
		}
	    }
	    if (bool_214_) {
		Class120 class120 = new Class120();
		((Class120) class120).aShort994 = (short) is.length;
		((Class120) class120).aShort991 = (short) (is.length / 3);
		((Class120) class120).aShortArray995
		    = new short[((Class120) class120).aShort994];
		((Class120) class120).aShortArray996
		    = new short[((Class120) class120).aShort994];
		((Class120) class120).aShortArray992
		    = new short[((Class120) class120).aShort994];
		((Class120) class120).anIntArray999
		    = new int[((Class120) class120).aShort994];
		((Class120) class120).aShortArray998
		    = new short[((Class120) class120).aShort994];
		((Class120) class120).aShortArray990
		    = new short[((Class120) class120).aShort994];
		((Class120) class120).aByteArray1000
		    = new byte[((Class120) class120).aShort994];
		if (is_206_ != null)
		    ((Class120) class120).aShortArray993
			= new short[((Class120) class120).aShort994];
		for (int i_217_ = 0; i_217_ < ((Class120) class120).aShort994;
		     i_217_++) {
		    int i_218_ = is[i_217_];
		    int i_219_ = is_205_[i_217_];
		    boolean bool_220_ = false;
		    int i_221_;
		    if (i_218_ == 0 && i_219_ == 0)
			i_221_ = (aByteArrayArray5257[i][i_203_]
				  - aByteArrayArray5259[i][i_203_]);
		    else if (i_218_ == 0 && i_219_ == ((s) this).anInt2206)
			i_221_ = (aByteArrayArray5257[i][i_203_ + 1]
				  - aByteArrayArray5259[i][i_203_ + 1]);
		    else if (i_218_ == ((s) this).anInt2206
			     && i_219_ == ((s) this).anInt2206)
			i_221_ = (aByteArrayArray5257[i + 1][i_203_ + 1]
				  - aByteArrayArray5259[i + 1][i_203_ + 1]);
		    else if (i_218_ == ((s) this).anInt2206 && i_219_ == 0)
			i_221_ = (aByteArrayArray5257[i + 1][i_203_]
				  - aByteArrayArray5259[i + 1][i_203_]);
		    else {
			int i_222_ = (((aByteArrayArray5257[i][i_203_]
					- aByteArrayArray5259[i][i_203_])
				       * (((s) this).anInt2206 - i_218_))
				      + ((aByteArrayArray5257[i + 1][i_203_]
					  - aByteArrayArray5259[i + 1][i_203_])
					 * i_218_));
			int i_223_
			    = (((aByteArrayArray5257[i][i_203_ + 1]
				 - aByteArrayArray5259[i][i_203_ + 1])
				* (((s) this).anInt2206 - i_218_))
			       + ((aByteArrayArray5257[i + 1][i_203_ + 1]
				   - aByteArrayArray5259[i + 1][i_203_ + 1])
				  * i_218_));
			i_221_
			    = (i_222_ * (((s) this).anInt2206 - i_219_)
			       + i_223_ * i_219_) >> 2 * ((s) this).anInt2200;
		    }
		    int i_224_ = (i << ((s) this).anInt2200) + i_218_;
		    int i_225_ = (i_203_ << ((s) this).anInt2200) + i_219_;
		    ((Class120) class120).aShortArray995[i_217_]
			= (short) i_218_;
		    ((Class120) class120).aShortArray992[i_217_]
			= (short) i_219_;
		    ((Class120) class120).aShortArray996[i_217_]
			= (short) (this.method3417(i_224_, i_225_, true)
				   + (is_204_ != null ? is_204_[i_217_] : 0));
		    if (i_221_ < 0)
			i_221_ = 0;
		    if (is_207_[i_217_] == 0) {
			((Class120) class120).anIntArray999[i_217_] = 0;
			if (is_208_ != null)
			    ((Class120) class120).aByteArray1000[i_217_]
				= (byte) i_221_;
		    } else {
			int i_226_ = 0;
			if (is_206_ != null) {
			    int i_227_
				= (((Class120) class120).aShortArray993[i_217_]
				   = (short) is_206_[i_217_]);
			    if (i_212_ != 0) {
				i_226_ = 255 * i_227_ / i_212_;
				if (i_226_ < 0)
				    i_226_ = 0;
				else if (i_226_ > 255)
				    i_226_ = 255;
			    }
			}
			int i_228_ = -16777216;
			if (is_209_[i_217_] != -1
			    && method3441(((Class238) (((ha) aHa_Sub2_5269)
							   .aD938.method11
						       (is_209_[i_217_],
							-28755))).aByte1820))
			    i_228_ = -1694498816;
			((Class120) class120).anIntArray999[i_217_]
			    = (i_228_
			       | Class215.method2790(127, i_226_,
						     method3439(((is_207_
								  [i_217_])
								 >> 8),
								i_221_),
						     i_211_));
			if (is_208_ != null)
			    ((Class120) class120).aByteArray1000[i_217_]
				= (byte) i_221_;
		    }
		    ((Class120) class120).aShortArray998[i_217_]
			= (short) is_209_[i_217_];
		    ((Class120) class120).aShortArray990[i_217_]
			= (short) is_210_[i_217_];
		}
		if (is_208_ != null)
		    ((Class120) class120).anIntArray997
			= new int[((Class120) class120).aShort991];
		for (int i_229_ = 0; i_229_ < ((Class120) class120).aShort991;
		     i_229_++) {
		    int i_230_ = i_229_ * 3;
		    if (is_208_ != null && is_208_[i_230_] != 0)
			((Class120) class120).anIntArray997[i_229_]
			    = ~0xffffff | is_208_[i_230_] >> 8;
		}
		aClass120ArrayArray5266[i][i_203_] = class120;
	    } else {
		boolean bool_231_ = true;
		int i_232_ = -1;
		int i_233_ = -1;
		int i_234_ = -1;
		int i_235_ = -1;
		if (is.length == 6) {
		    for (int i_236_ = 0; i_236_ < 6; i_236_++) {
			if (is[i_236_] == 0 && is_205_[i_236_] == 0) {
			    if (i_232_ != -1
				&& is_207_[i_232_] != is_207_[i_236_]) {
				bool_231_ = false;
				break;
			    }
			    i_232_ = i_236_;
			} else if (is[i_236_] == ((s) this).anInt2206
				   && is_205_[i_236_] == 0) {
			    if (i_233_ != -1
				&& is_207_[i_233_] != is_207_[i_236_]) {
				bool_231_ = false;
				break;
			    }
			    i_233_ = i_236_;
			} else if (is[i_236_] == ((s) this).anInt2206
				   && (is_205_[i_236_]
				       == ((s) this).anInt2206)) {
			    if (i_234_ != -1
				&& is_207_[i_234_] != is_207_[i_236_]) {
				bool_231_ = false;
				break;
			    }
			    i_234_ = i_236_;
			} else if (is[i_236_] == 0
				   && (is_205_[i_236_]
				       == ((s) this).anInt2206)) {
			    if (i_235_ != -1
				&& is_207_[i_235_] != is_207_[i_236_]) {
				bool_231_ = false;
				break;
			    }
			    i_235_ = i_236_;
			}
		    }
		    if (i_232_ == -1 || i_233_ == -1 || i_234_ == -1
			|| i_235_ == -1)
			bool_231_ = false;
		    if (bool_231_) {
			if (is_204_ != null) {
			    for (int i_237_ = 0; i_237_ < 4; i_237_++) {
				if (is_204_[i_237_] != 0) {
				    bool_231_ = false;
				    break;
				}
			    }
			}
			if (bool_231_) {
			    for (int i_238_ = 1; i_238_ < 4; i_238_++) {
				if (is[i_238_] != is[0]
				    && (is[i_238_]
					!= is[0] + ((s) this).anInt2206)
				    && (is[i_238_]
					!= is[0] - ((s) this).anInt2206)) {
				    bool_231_ = false;
				    break;
				}
				if (is_205_[i_238_] != is_205_[0]
				    && (is_205_[i_238_]
					!= is_205_[0] + ((s) this).anInt2206)
				    && (is_205_[i_238_]
					!= (is_205_[0]
					    - ((s) this).anInt2206))) {
				    bool_231_ = false;
				    break;
				}
			    }
			}
		    }
		} else
		    bool_231_ = false;
		if (bool_231_) {
		    Class193 class193 = new Class193();
		    int i_239_ = is_207_[0];
		    int i_240_ = is_209_[0];
		    if (is_208_ != null) {
			((Class193) class193).anInt1494 = is_208_[0] >> 8;
			if (i_239_ == 0)
			    ((Class193) class193).aByte1492 |= 0x2;
		    } else if (i_239_ == 0)
			return;
		    if ((((s) this).anIntArrayArray2201[i][i_203_]
			 == ((s) this).anIntArrayArray2201[i + 1][i_203_])
			&& (((s) this).anIntArrayArray2201[i][i_203_]
			    == (((s) this).anIntArrayArray2201[i + 1]
				[i_203_ + 1]))
			&& (((s) this).anIntArrayArray2201[i][i_203_]
			    == ((s) this).anIntArrayArray2201[i][i_203_ + 1]))
			((Class193) class193).aByte1492 |= 0x1;
		    if (i_240_ != -1
			&& (((Class193) class193).aByte1492 & 0x2) == 0
			&& !(((Class238) ((ha) aHa_Sub2_5269).aD938
					     .method11(i_240_, -28755))
			     .aBoolean1825)) {
			int i_241_;
			if (is_206_ != null && i_212_ != 0) {
			    i_241_ = 255 * is_206_[i_232_] / i_212_;
			    if (i_241_ < 0)
				i_241_ = 0;
			    else if (i_241_ > 255)
				i_241_ = 255;
			} else
			    i_241_ = 0;
			((Class193) class193).anInt1490
			    = (Class215.method2790
			       (127, i_241_,
				method3439(is_207_[i_232_] >> 8,
					   (aByteArrayArray5257[i][i_203_]
					    - aByteArrayArray5259[i][i_203_])),
				i_211_));
			if (((Class193) class193).anInt1494 != 0)
			    ((Class193) class193).anInt1490
				|= (255 - (aByteArrayArray5257[i][i_203_]
					   - aByteArrayArray5259[i][i_203_])
				    << 25);
			if (is_206_ != null && i_212_ != 0) {
			    i_241_ = 255 * is_206_[i_233_] / i_212_;
			    if (i_241_ < 0)
				i_241_ = 0;
			    else if (i_241_ > 255)
				i_241_ = 255;
			} else
			    i_241_ = 0;
			((Class193) class193).anInt1491
			    = (Class215.method2790
			       (126, i_241_,
				method3439(is_207_[i_233_] >> 8,
					   (aByteArrayArray5257[i + 1][i_203_]
					    - (aByteArrayArray5259[i + 1]
					       [i_203_]))),
				i_211_));
			if (((Class193) class193).anInt1494 != 0)
			    ((Class193) class193).anInt1491
				|= 255 - (aByteArrayArray5257[i + 1][i_203_]
					  - (aByteArrayArray5259[i + 1]
					     [i_203_])) << 25;
			if (is_206_ != null && i_212_ != 0) {
			    i_241_ = 255 * is_206_[i_234_] / i_212_;
			    if (i_241_ < 0)
				i_241_ = 0;
			    else if (i_241_ > 255)
				i_241_ = 255;
			} else
			    i_241_ = 0;
			((Class193) class193).anInt1493
			    = (Class215.method2790
			       (127, i_241_,
				method3439(is_207_[i_234_] >> 8,
					   ((aByteArrayArray5257[i + 1]
					     [i_203_ + 1])
					    - (aByteArrayArray5259[i + 1]
					       [i_203_ + 1]))),
				i_211_));
			if (((Class193) class193).anInt1494 != 0)
			    ((Class193) class193).anInt1493
				|= (255
				    - (aByteArrayArray5257[i + 1][i_203_ + 1]
				       - (aByteArrayArray5259[i + 1]
					  [i_203_ + 1]))) << 25;
			if (is_206_ != null && i_212_ != 0) {
			    i_241_ = 255 * is_206_[i_235_] / i_212_;
			    if (i_241_ < 0)
				i_241_ = 0;
			    else if (i_241_ > 255)
				i_241_ = 255;
			} else
			    i_241_ = 0;
			((Class193) class193).anInt1484
			    = (Class215.method2790
			       (126, i_241_,
				method3439(is_207_[i_235_] >> 8,
					   (aByteArrayArray5257[i][i_203_ + 1]
					    - (aByteArrayArray5259[i]
					       [i_203_ + 1]))),
				i_211_));
			((Class193) class193).aShort1487 = (short) i_240_;
		    } else {
			int i_242_;
			if (is_206_ != null && i_212_ != 0) {
			    i_242_ = 255 * is_206_[i_232_] / i_212_;
			    if (i_242_ < 0)
				i_242_ = 0;
			    else if (i_242_ > 255)
				i_242_ = 255;
			} else
			    i_242_ = 0;
			((Class193) class193).anInt1490
			    = (Class215.method2790
			       (126, i_242_,
				method3439(is_207_[i_232_] >> 8,
					   (aByteArrayArray5257[i][i_203_]
					    - aByteArrayArray5259[i][i_203_])),
				i_211_));
			if (((Class193) class193).anInt1494 != 0)
			    ((Class193) class193).anInt1490
				|= (255 - (aByteArrayArray5257[i][i_203_]
					   - aByteArrayArray5259[i][i_203_])
				    << 25);
			if (is_206_ != null && i_212_ != 0) {
			    i_242_ = 255 * is_206_[i_233_] / i_212_;
			    if (i_242_ < 0)
				i_242_ = 0;
			    else if (i_242_ > 255)
				i_242_ = 255;
			} else
			    i_242_ = 0;
			((Class193) class193).anInt1491
			    = (Class215.method2790
			       (126, i_242_,
				method3439(is_207_[i_233_] >> 8,
					   (aByteArrayArray5257[i + 1][i_203_]
					    - (aByteArrayArray5259[i + 1]
					       [i_203_]))),
				i_211_));
			if (((Class193) class193).anInt1494 != 0)
			    ((Class193) class193).anInt1491
				|= 255 - (aByteArrayArray5257[i + 1][i_203_]
					  - (aByteArrayArray5259[i + 1]
					     [i_203_])) << 25;
			if (is_206_ != null && i_212_ != 0) {
			    i_242_ = 255 * is_206_[i_234_] / i_212_;
			    if (i_242_ < 0)
				i_242_ = 0;
			    else if (i_242_ > 255)
				i_242_ = 255;
			} else
			    i_242_ = 0;
			((Class193) class193).anInt1493
			    = (Class215.method2790
			       (126, i_242_,
				method3439(is_207_[i_234_] >> 8,
					   ((aByteArrayArray5257[i + 1]
					     [i_203_ + 1])
					    - (aByteArrayArray5259[i + 1]
					       [i_203_ + 1]))),
				i_211_));
			if (((Class193) class193).anInt1494 != 0)
			    ((Class193) class193).anInt1493
				|= (255
				    - (aByteArrayArray5257[i + 1][i_203_ + 1]
				       - (aByteArrayArray5259[i + 1]
					  [i_203_ + 1]))) << 25;
			if (is_206_ != null && i_212_ != 0) {
			    i_242_ = 255 * is_206_[i_235_] / i_212_;
			    if (i_242_ < 0)
				i_242_ = 0;
			    else if (i_242_ > 255)
				i_242_ = 255;
			} else
			    i_242_ = 0;
			((Class193) class193).anInt1484
			    = (Class215.method2790
			       (127, i_242_,
				method3439(is_207_[i_235_] >> 8,
					   (aByteArrayArray5257[i][i_203_ + 1]
					    - (aByteArrayArray5259[i]
					       [i_203_ + 1]))),
				i_211_));
			if (((Class193) class193).anInt1494 != 0)
			    ((Class193) class193).anInt1484
				|= 255 - (aByteArrayArray5257[i][i_203_ + 1]
					  - (aByteArrayArray5259[i]
					     [i_203_ + 1])) << 25;
			((Class193) class193).aShort1487 = (short) -1;
		    }
		    if (is_206_ != null) {
			((Class193) class193).aShort1486
			    = (short) is_206_[i_234_];
			((Class193) class193).aShort1488
			    = (short) is_206_[i_235_];
			((Class193) class193).aShort1485
			    = (short) is_206_[i_233_];
			((Class193) class193).aShort1489
			    = (short) is_206_[i_232_];
		    }
		    aClass193ArrayArray5272[i][i_203_] = class193;
		} else {
		    Class285 class285 = new Class285();
		    ((Class285) class285).aShort2174 = (short) is.length;
		    ((Class285) class285).aShort2171 = (short) (is.length / 3);
		    ((Class285) class285).aShortArray2176
			= new short[((Class285) class285).aShort2174];
		    ((Class285) class285).aShortArray2179
			= new short[((Class285) class285).aShort2174];
		    ((Class285) class285).aShortArray2170
			= new short[((Class285) class285).aShort2174];
		    ((Class285) class285).anIntArray2173
			= new int[((Class285) class285).aShort2174];
		    if (is_206_ != null)
			((Class285) class285).aShortArray2178
			    = new short[((Class285) class285).aShort2174];
		    for (int i_243_ = 0;
			 i_243_ < ((Class285) class285).aShort2174; i_243_++) {
			int i_244_ = is[i_243_];
			int i_245_ = is_205_[i_243_];
			boolean bool_246_ = false;
			int i_247_;
			if (i_244_ == 0 && i_245_ == 0)
			    i_247_ = (aByteArrayArray5257[i][i_203_]
				      - aByteArrayArray5259[i][i_203_]);
			else if (i_244_ == 0 && i_245_ == ((s) this).anInt2206)
			    i_247_ = (aByteArrayArray5257[i][i_203_ + 1]
				      - aByteArrayArray5259[i][i_203_ + 1]);
			else if (i_244_ == ((s) this).anInt2206
				 && i_245_ == ((s) this).anInt2206)
			    i_247_
				= (aByteArrayArray5257[i + 1][i_203_ + 1]
				   - aByteArrayArray5259[i + 1][i_203_ + 1]);
			else if (i_244_ == ((s) this).anInt2206 && i_245_ == 0)
			    i_247_ = (aByteArrayArray5257[i + 1][i_203_]
				      - aByteArrayArray5259[i + 1][i_203_]);
			else {
			    int i_248_
				= (((aByteArrayArray5257[i][i_203_]
				     - aByteArrayArray5259[i][i_203_])
				    * (((s) this).anInt2206 - i_244_))
				   + ((aByteArrayArray5257[i + 1][i_203_]
				       - aByteArrayArray5259[i + 1][i_203_])
				      * i_244_));
			    int i_249_
				= (((aByteArrayArray5257[i][i_203_ + 1]
				     - aByteArrayArray5259[i][i_203_ + 1])
				    * (((s) this).anInt2206 - i_244_))
				   + (aByteArrayArray5257[i + 1][i_203_ + 1]
				      - (aByteArrayArray5259[i + 1]
					 [i_203_ + 1])) * i_244_);
			    i_247_ = ((i_248_ * (((s) this).anInt2206 - i_245_)
				       + i_249_ * i_245_)
				      >> 2 * ((s) this).anInt2200);
			}
			int i_250_ = (i << ((s) this).anInt2200) + i_244_;
			int i_251_ = (i_203_ << ((s) this).anInt2200) + i_245_;
			((Class285) class285).aShortArray2176[i_243_]
			    = (short) i_244_;
			((Class285) class285).aShortArray2170[i_243_]
			    = (short) i_245_;
			((Class285) class285).aShortArray2179[i_243_]
			    = (short) (this.method3417(i_250_, i_251_, true)
				       + (is_204_ != null ? is_204_[i_243_]
					  : 0));
			if (i_247_ < 0)
			    i_247_ = 0;
			if (is_207_[i_243_] == 0) {
			    if (is_208_ != null)
				((Class285) class285).anIntArray2173[i_243_]
				    = i_247_ << 25;
			    else
				((Class285) class285).anIntArray2173[i_243_]
				    = 0;
			} else {
			    int i_252_ = 0;
			    if (is_206_ != null) {
				int i_253_ = (((Class285) class285)
						  .aShortArray2178[i_243_]
					      = (short) is_206_[i_243_]);
				if (i_212_ != 0) {
				    i_252_ = 255 * i_253_ / i_212_;
				    if (i_252_ < 0)
					i_252_ = 0;
				    else if (i_252_ > 255)
					i_252_ = 255;
				}
			    }
			    ((Class285) class285).anIntArray2173[i_243_]
				= Class215.method2790(126, i_252_,
						      method3439(((is_207_
								   [i_243_])
								  >> 8),
								 i_247_),
						      i_211_);
			    if (is_208_ != null)
				((Class285) class285).anIntArray2173[i_243_]
				    |= i_247_ << 25;
			}
		    }
		    boolean bool_254_ = false;
		    for (int i_255_ = 0;
			 i_255_ < ((Class285) class285).aShort2171; i_255_++) {
			if (is_209_[i_255_ * 3] != -1
			    && !(((Class238)
				  ((ha) aHa_Sub2_5269).aD938
				      .method11(is_209_[i_255_ * 3], -28755))
				 .aBoolean1825))
			    bool_254_ = true;
		    }
		    if (is_208_ != null)
			((Class285) class285).anIntArray2175
			    = new int[((Class285) class285).aShort2171];
		    if (bool_254_) {
			((Class285) class285).aShortArray2169
			    = new short[((Class285) class285).aShort2171];
			((Class285) class285).aShortArray2177
			    = new short[((Class285) class285).aShort2171];
		    }
		    for (int i_256_ = 0;
			 i_256_ < ((Class285) class285).aShort2171; i_256_++) {
			int i_257_ = i_256_ * 3;
			if (is_208_ != null && is_208_[i_257_] != 0)
			    ((Class285) class285).anIntArray2175[i_256_]
				= is_208_[i_257_] >> 8;
			if (bool_254_) {
			    int i_258_ = i_257_ + 1;
			    int i_259_ = i_258_ + 1;
			    boolean bool_260_ = false;
			    boolean bool_261_ = true;
			    int i_262_ = is_209_[i_257_];
			    if (i_262_ == -1
				|| (((Class238) ((ha) aHa_Sub2_5269).aD938
						    .method11(i_262_, -28755))
				    .aBoolean1825))
				bool_261_ = false;
			    else
				bool_260_ = true;
			    i_262_ = is_209_[i_258_];
			    if (i_262_ == -1
				|| (((Class238) ((ha) aHa_Sub2_5269).aD938
						    .method11(i_262_, -28755))
				    .aBoolean1825))
				bool_261_ = false;
			    else
				bool_260_ = true;
			    i_262_ = is_209_[i_259_];
			    if (i_262_ == -1
				|| (((Class238) ((ha) aHa_Sub2_5269).aD938
						    .method11(i_262_, -28755))
				    .aBoolean1825))
				bool_261_ = false;
			    else
				bool_260_ = true;
			    if (bool_261_) {
				((Class285) class285).aShortArray2169[i_256_]
				    = (short) i_262_;
				((Class285) class285).aShortArray2177[i_256_]
				    = (short) is_210_[i_257_];
			    } else {
				if (bool_260_) {
				    i_262_ = is_209_[i_257_];
				    if (i_262_ != -1
					&& !(((Class238)
					      ((ha) aHa_Sub2_5269).aD938
						  .method11(i_262_, -28755))
					     .aBoolean1825))
					((Class285) class285)
					    .anIntArray2173[i_257_]
					    = (Class221.anIntArray1665
					       [(Class111_Sub2.method2117
						 ((((Class238)
						    (((ha) aHa_Sub2_5269)
							 .aD938.method11
						     (i_262_, -28755)))
						   .aShort1831) & 0xffff,
						  109)) & 0xffff]);
				    i_262_ = is_209_[i_258_];
				    if (i_262_ != -1
					&& !(((Class238)
					      ((ha) aHa_Sub2_5269).aD938
						  .method11(i_262_, -28755))
					     .aBoolean1825))
					((Class285) class285)
					    .anIntArray2173[i_258_]
					    = (Class221.anIntArray1665
					       [(Class111_Sub2.method2117
						 ((((Class238)
						    (((ha) aHa_Sub2_5269)
							 .aD938.method11
						     (i_262_, -28755)))
						   .aShort1831) & 0xffff,
						  -51)) & 0xffff]);
				    i_262_ = is_209_[i_259_];
				    if (i_262_ != -1
					&& !(((Class238)
					      ((ha) aHa_Sub2_5269).aD938
						  .method11(i_262_, -28755))
					     .aBoolean1825))
					((Class285) class285)
					    .anIntArray2173[i_259_]
					    = (Class221.anIntArray1665
					       [(Class111_Sub2.method2117
						 ((((Class238)
						    (((ha) aHa_Sub2_5269)
							 .aD938.method11
						     (i_262_, -28755)))
						   .aShort1831) & 0xffff,
						  115)) & 0xffff]);
				}
				((Class285) class285).aShortArray2169[i_256_]
				    = (short) -1;
			    }
			}
		    }
		    aClass285ArrayArray5258[i][i_203_] = class285;
		}
	    }
	}
    }
    
    private final void method3442
	(int i, int i_263_, boolean bool, Class235 class235, Class12 class12,
	 int[] is, int[] is_264_, int[] is_265_, int[] is_266_, int i_267_) {
	Class193 class193 = aClass193ArrayArray5272[i][i_263_];
	if (class193 != null) {
	    if ((((Class193) class193).aByte1492 & 0x2) == 0) {
		if (i_267_ != 0) {
		    if ((((Class193) class193).aByte1492 & 0x4) != 0) {
			if ((i_267_ & 0x1) != 0)
			    return;
		    } else if ((i_267_ & 0x2) != 0)
			return;
		}
		int i_268_ = i * ((s) this).anInt2206;
		int i_269_ = i_268_ + ((s) this).anInt2206;
		int i_270_ = i_263_ * ((s) this).anInt2206;
		int i_271_ = i_270_ + ((s) this).anInt2206;
		int i_272_ = 0;
		int i_273_ = 0;
		int i_274_ = 0;
		int i_275_ = 0;
		float f;
		float f_276_;
		float f_277_;
		float f_278_;
		int i_279_;
		int i_280_;
		int i_281_;
		int i_282_;
		int i_283_;
		int i_284_;
		int i_285_;
		int i_286_;
		if ((((Class193) class193).aByte1492 & 0x1) != 0 && !bool) {
		    int i_287_ = ((s) this).anIntArrayArray2201[i][i_263_];
		    float f_288_ = aFloat5270 * (float) i_287_;
		    if (anInt5262 == -1) {
			f = aFloat5274 + (aFloat5260 * (float) i_268_ + f_288_
					  + aFloat5263 * (float) i_270_);
			if (f <= (float) ((ha_Sub2) aHa_Sub2_5269).anInt4502)
			    return;
			f_276_ = aFloat5274 + (aFloat5260 * (float) i_269_
					       + f_288_
					       + aFloat5263 * (float) i_270_);
			if (f_276_
			    <= (float) ((ha_Sub2) aHa_Sub2_5269).anInt4502)
			    return;
			f_277_ = aFloat5274 + (aFloat5260 * (float) i_269_
					       + f_288_
					       + aFloat5263 * (float) i_271_);
			if (f_277_
			    <= (float) ((ha_Sub2) aHa_Sub2_5269).anInt4502)
			    return;
			f_278_ = aFloat5274 + (aFloat5260 * (float) i_268_
					       + f_288_
					       + aFloat5263 * (float) i_271_);
			if (f_278_
			    <= (float) ((ha_Sub2) aHa_Sub2_5269).anInt4502)
			    return;
		    } else {
			f = aFloat5274 + (aFloat5260 * (float) i_268_ + f_288_
					  + aFloat5263 * (float) i_270_);
			f_276_ = aFloat5274 + (aFloat5260 * (float) i_269_
					       + f_288_
					       + aFloat5263 * (float) i_270_);
			f_277_ = aFloat5274 + (aFloat5260 * (float) i_269_
					       + f_288_
					       + aFloat5263 * (float) i_271_);
			f_278_ = aFloat5274 + (aFloat5260 * (float) i_268_
					       + f_288_
					       + aFloat5263 * (float) i_271_);
		    }
		    if (((Class235) class235).aBoolean1758) {
			int i_289_ = (int) (f - (float) (((Class235) class235)
							 .anInt1761));
			if (i_289_ > 0) {
			    i_272_ = i_289_;
			    if (i_272_ > 255)
				i_272_ = 255;
			}
			i_289_ = (int) (f_276_ - (float) (((Class235) class235)
							  .anInt1761));
			if (i_289_ > 0) {
			    i_273_ = i_289_;
			    if (i_273_ > 255)
				i_273_ = 255;
			}
			i_289_ = (int) (f_277_ - (float) (((Class235) class235)
							  .anInt1761));
			if (i_289_ > 0) {
			    i_274_ = i_289_;
			    if (i_274_ > 255)
				i_274_ = 255;
			}
			i_289_ = (int) (f_278_ - (float) (((Class235) class235)
							  .anInt1761));
			if (i_289_ > 0) {
			    i_275_ = i_289_;
			    if (i_275_ > 255)
				i_275_ = 255;
			}
		    }
		    float f_290_ = aFloat5271 * (float) i_287_;
		    float f_291_ = aFloat5273 * (float) i_287_;
		    if (anInt5262 == -1) {
			float f_292_ = (aFloat5268
					+ (aFloat5275 * (float) i_268_ + f_290_
					   + aFloat5276 * (float) i_270_));
			i_279_ = (((Class12) class12).anInt136
				  + (int) (f_292_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4514)
					   / f));
			float f_293_ = (aFloat5255
					+ (aFloat5264 * (float) i_268_ + f_291_
					   + aFloat5267 * (float) i_270_));
			i_280_ = (((Class12) class12).anInt128
				  + (int) (f_293_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4490)
					   / f));
			float f_294_ = (aFloat5268
					+ (aFloat5275 * (float) i_269_ + f_290_
					   + aFloat5276 * (float) i_270_));
			i_281_ = (((Class12) class12).anInt136
				  + (int) (f_294_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4514)
					   / f_276_));
			float f_295_ = (aFloat5255
					+ (aFloat5264 * (float) i_269_ + f_291_
					   + aFloat5267 * (float) i_270_));
			i_282_ = (((Class12) class12).anInt128
				  + (int) (f_295_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4490)
					   / f_276_));
			float f_296_ = (aFloat5268
					+ (aFloat5275 * (float) i_269_ + f_290_
					   + aFloat5276 * (float) i_271_));
			i_283_ = (((Class12) class12).anInt136
				  + (int) (f_296_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4514)
					   / f_277_));
			float f_297_ = (aFloat5255
					+ (aFloat5264 * (float) i_269_ + f_291_
					   + aFloat5267 * (float) i_271_));
			i_284_ = (((Class12) class12).anInt128
				  + (int) (f_297_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4490)
					   / f_277_));
			float f_298_ = (aFloat5268
					+ (aFloat5275 * (float) i_268_ + f_290_
					   + aFloat5276 * (float) i_271_));
			i_285_ = (((Class12) class12).anInt136
				  + (int) (f_298_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4514)
					   / f_278_));
			float f_299_ = (aFloat5255
					+ (aFloat5264 * (float) i_268_ + f_291_
					   + aFloat5267 * (float) i_271_));
			i_286_ = (((Class12) class12).anInt128
				  + (int) (f_299_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4490)
					   / f_278_));
		    } else {
			float f_300_ = (aFloat5268
					+ (aFloat5275 * (float) i_268_ + f_290_
					   + aFloat5276 * (float) i_270_));
			i_279_ = (((Class12) class12).anInt136
				  + (int) (f_300_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4514)
					   / (float) anInt5262));
			float f_301_ = (aFloat5255
					+ (aFloat5264 * (float) i_268_ + f_291_
					   + aFloat5267 * (float) i_270_));
			i_280_ = (((Class12) class12).anInt128
				  + (int) (f_301_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4490)
					   / (float) anInt5262));
			float f_302_ = (aFloat5268
					+ (aFloat5275 * (float) i_269_ + f_290_
					   + aFloat5276 * (float) i_270_));
			i_281_ = (((Class12) class12).anInt136
				  + (int) (f_302_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4514)
					   / (float) anInt5262));
			float f_303_ = (aFloat5255
					+ (aFloat5264 * (float) i_269_ + f_291_
					   + aFloat5267 * (float) i_270_));
			i_282_ = (((Class12) class12).anInt128
				  + (int) (f_303_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4490)
					   / (float) anInt5262));
			float f_304_ = (aFloat5268
					+ (aFloat5275 * (float) i_269_ + f_290_
					   + aFloat5276 * (float) i_271_));
			i_283_ = (((Class12) class12).anInt136
				  + (int) (f_304_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4514)
					   / (float) anInt5262));
			float f_305_ = (aFloat5255
					+ (aFloat5264 * (float) i_269_ + f_291_
					   + aFloat5267 * (float) i_271_));
			i_284_ = (((Class12) class12).anInt128
				  + (int) (f_305_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4490)
					   / (float) anInt5262));
			float f_306_ = (aFloat5268
					+ (aFloat5275 * (float) i_268_ + f_290_
					   + aFloat5276 * (float) i_271_));
			i_285_ = (((Class12) class12).anInt136
				  + (int) (f_306_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4514)
					   / (float) anInt5262));
			float f_307_ = (aFloat5255
					+ (aFloat5264 * (float) i_268_ + f_291_
					   + aFloat5267 * (float) i_271_));
			i_286_ = (((Class12) class12).anInt128
				  + (int) (f_307_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4490)
					   / (float) anInt5262));
		    }
		} else {
		    int i_308_ = ((s) this).anIntArrayArray2201[i][i_263_];
		    int i_309_ = ((s) this).anIntArrayArray2201[i + 1][i_263_];
		    int i_310_
			= ((s) this).anIntArrayArray2201[i + 1][i_263_ + 1];
		    int i_311_ = ((s) this).anIntArrayArray2201[i][i_263_ + 1];
		    if (anInt5262 == -1) {
			f = aFloat5274 + (aFloat5260 * (float) i_268_
					  + aFloat5270 * (float) i_308_
					  + aFloat5263 * (float) i_270_);
			if (f <= (float) ((ha_Sub2) aHa_Sub2_5269).anInt4502)
			    return;
			f_276_ = aFloat5274 + (aFloat5260 * (float) i_269_
					       + aFloat5270 * (float) i_309_
					       + aFloat5263 * (float) i_270_);
			if (f_276_
			    <= (float) ((ha_Sub2) aHa_Sub2_5269).anInt4502)
			    return;
			f_277_ = aFloat5274 + (aFloat5260 * (float) i_269_
					       + aFloat5270 * (float) i_310_
					       + aFloat5263 * (float) i_271_);
			if (f_277_
			    <= (float) ((ha_Sub2) aHa_Sub2_5269).anInt4502)
			    return;
			f_278_ = aFloat5274 + (aFloat5260 * (float) i_268_
					       + aFloat5270 * (float) i_311_
					       + aFloat5263 * (float) i_271_);
			if (f_278_
			    <= (float) ((ha_Sub2) aHa_Sub2_5269).anInt4502)
			    return;
		    } else {
			f = aFloat5274 + (aFloat5260 * (float) i_268_
					  + aFloat5270 * (float) i_308_
					  + aFloat5263 * (float) i_270_);
			f_276_ = aFloat5274 + (aFloat5260 * (float) i_269_
					       + aFloat5270 * (float) i_309_
					       + aFloat5263 * (float) i_270_);
			f_277_ = aFloat5274 + (aFloat5260 * (float) i_269_
					       + aFloat5270 * (float) i_310_
					       + aFloat5263 * (float) i_271_);
			f_278_ = aFloat5274 + (aFloat5260 * (float) i_268_
					       + aFloat5270 * (float) i_311_
					       + aFloat5263 * (float) i_271_);
		    }
		    if (bool) {
			int i_312_ = (int) (f - (float) (((Class235) class235)
							 .anInt1761));
			if (i_312_ > 255)
			    i_312_ = 255;
			if (i_312_ > 0) {
			    i_272_ = i_312_;
			    int i_313_ = (((Class193) class193).aShort1489
					  * i_312_ / 255);
			    if (i_313_ > 0)
				i_308_ -= i_313_;
			}
			i_312_ = (int) (f_276_ - (float) (((Class235) class235)
							  .anInt1761));
			if (i_312_ > 255)
			    i_312_ = 255;
			if (i_312_ > 0) {
			    i_273_ = i_312_;
			    int i_314_ = (((Class193) class193).aShort1485
					  * i_312_ / 255);
			    if (i_314_ > 0)
				i_309_ -= i_314_;
			}
			i_312_ = (int) (f_277_ - (float) (((Class235) class235)
							  .anInt1761));
			if (i_312_ > 255)
			    i_312_ = 255;
			if (i_312_ > 0) {
			    i_274_ = i_312_;
			    int i_315_ = (((Class193) class193).aShort1486
					  * i_312_ / 255);
			    if (i_315_ > 0)
				i_310_ -= i_315_;
			}
			i_312_ = (int) (f_278_ - (float) (((Class235) class235)
							  .anInt1761));
			if (i_312_ > 255)
			    i_312_ = 255;
			if (i_312_ > 0) {
			    i_275_ = i_312_;
			    int i_316_ = (((Class193) class193).aShort1488
					  * i_312_ / 255);
			    if (i_316_ > 0)
				i_311_ -= i_316_;
			}
		    } else if (((Class235) class235).aBoolean1758) {
			int i_317_ = (int) (f - (float) (((Class235) class235)
							 .anInt1761));
			if (i_317_ > 0) {
			    i_272_ = i_317_;
			    if (i_272_ > 255)
				i_272_ = 255;
			}
			i_317_ = (int) (f_276_ - (float) (((Class235) class235)
							  .anInt1761));
			if (i_317_ > 0) {
			    i_273_ = i_317_;
			    if (i_273_ > 255)
				i_273_ = 255;
			}
			i_317_ = (int) (f_277_ - (float) (((Class235) class235)
							  .anInt1761));
			if (i_317_ > 0) {
			    i_274_ = i_317_;
			    if (i_274_ > 255)
				i_274_ = 255;
			}
			i_317_ = (int) (f_278_ - (float) (((Class235) class235)
							  .anInt1761));
			if (i_317_ > 0) {
			    i_275_ = i_317_;
			    if (i_275_ > 255)
				i_275_ = 255;
			}
		    }
		    if (anInt5262 == -1) {
			float f_318_
			    = aFloat5268 + (aFloat5275 * (float) i_268_
					    + aFloat5271 * (float) i_308_
					    + aFloat5276 * (float) i_270_);
			i_279_ = (((Class12) class12).anInt136
				  + (int) (f_318_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4514)
					   / f));
			float f_319_
			    = aFloat5255 + (aFloat5264 * (float) i_268_
					    + aFloat5273 * (float) i_308_
					    + aFloat5267 * (float) i_270_);
			i_280_ = (((Class12) class12).anInt128
				  + (int) (f_319_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4490)
					   / f));
			float f_320_
			    = aFloat5268 + (aFloat5275 * (float) i_269_
					    + aFloat5271 * (float) i_309_
					    + aFloat5276 * (float) i_270_);
			i_281_ = (((Class12) class12).anInt136
				  + (int) (f_320_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4514)
					   / f_276_));
			float f_321_
			    = aFloat5255 + (aFloat5264 * (float) i_269_
					    + aFloat5273 * (float) i_309_
					    + aFloat5267 * (float) i_270_);
			i_282_ = (((Class12) class12).anInt128
				  + (int) (f_321_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4490)
					   / f_276_));
			float f_322_
			    = aFloat5268 + (aFloat5275 * (float) i_269_
					    + aFloat5271 * (float) i_310_
					    + aFloat5276 * (float) i_271_);
			i_283_ = (((Class12) class12).anInt136
				  + (int) (f_322_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4514)
					   / f_277_));
			float f_323_
			    = aFloat5255 + (aFloat5264 * (float) i_269_
					    + aFloat5273 * (float) i_310_
					    + aFloat5267 * (float) i_271_);
			i_284_ = (((Class12) class12).anInt128
				  + (int) (f_323_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4490)
					   / f_277_));
			float f_324_
			    = aFloat5268 + (aFloat5275 * (float) i_268_
					    + aFloat5271 * (float) i_311_
					    + aFloat5276 * (float) i_271_);
			i_285_ = (((Class12) class12).anInt136
				  + (int) (f_324_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4514)
					   / f_278_));
			float f_325_
			    = aFloat5255 + (aFloat5264 * (float) i_268_
					    + aFloat5273 * (float) i_311_
					    + aFloat5267 * (float) i_271_);
			i_286_ = (((Class12) class12).anInt128
				  + (int) (f_325_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4490)
					   / f_278_));
		    } else {
			float f_326_
			    = aFloat5268 + (aFloat5275 * (float) i_268_
					    + aFloat5271 * (float) i_308_
					    + aFloat5276 * (float) i_270_);
			i_279_ = (((Class12) class12).anInt136
				  + (int) (f_326_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4514)
					   / (float) anInt5262));
			float f_327_
			    = aFloat5255 + (aFloat5264 * (float) i_268_
					    + aFloat5273 * (float) i_308_
					    + aFloat5267 * (float) i_270_);
			i_280_ = (((Class12) class12).anInt128
				  + (int) (f_327_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4490)
					   / (float) anInt5262));
			float f_328_
			    = aFloat5268 + (aFloat5275 * (float) i_269_
					    + aFloat5271 * (float) i_309_
					    + aFloat5276 * (float) i_270_);
			i_281_ = (((Class12) class12).anInt136
				  + (int) (f_328_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4514)
					   / (float) anInt5262));
			float f_329_
			    = aFloat5255 + (aFloat5264 * (float) i_269_
					    + aFloat5273 * (float) i_309_
					    + aFloat5267 * (float) i_270_);
			i_282_ = (((Class12) class12).anInt128
				  + (int) (f_329_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4490)
					   / (float) anInt5262));
			float f_330_
			    = aFloat5268 + (aFloat5275 * (float) i_269_
					    + aFloat5271 * (float) i_310_
					    + aFloat5276 * (float) i_271_);
			i_283_ = (((Class12) class12).anInt136
				  + (int) (f_330_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4514)
					   / (float) anInt5262));
			float f_331_
			    = aFloat5255 + (aFloat5264 * (float) i_269_
					    + aFloat5273 * (float) i_310_
					    + aFloat5267 * (float) i_271_);
			i_284_ = (((Class12) class12).anInt128
				  + (int) (f_331_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4490)
					   / (float) anInt5262));
			float f_332_
			    = aFloat5268 + (aFloat5275 * (float) i_268_
					    + aFloat5271 * (float) i_311_
					    + aFloat5276 * (float) i_271_);
			i_285_ = (((Class12) class12).anInt136
				  + (int) (f_332_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4514)
					   / (float) anInt5262));
			float f_333_
			    = aFloat5255 + (aFloat5264 * (float) i_268_
					    + aFloat5273 * (float) i_311_
					    + aFloat5267 * (float) i_271_);
			i_286_ = (((Class12) class12).anInt128
				  + (int) (f_333_
					   * (float) (((ha_Sub2) aHa_Sub2_5269)
						      .anInt4490)
					   / (float) anInt5262));
		    }
		}
		boolean bool_334_
		    = (((Class193) class193).aShort1487 != -1
		       && method3441(((Class238)
				      (((ha) aHa_Sub2_5269).aD938.method11
				       (((Class193) class193).aShort1487,
					-28755))).aByte1820));
		if (anInt5262 == -1) {
		    int i_335_ = i_273_ + i_274_ + i_275_;
		    if (((i_283_ - i_285_) * (i_282_ - i_286_)
			 - (i_284_ - i_286_) * (i_281_ - i_285_))
			> 0) {
			((Class12) class12).aBoolean135
			    = (i_283_ < 0 || i_285_ < 0 || i_281_ < 0
			       || i_283_ > ((Class12) class12).anInt141
			       || i_285_ > ((Class12) class12).anInt141
			       || i_281_ > ((Class12) class12).anInt141);
			if (i_335_ < 765) {
			    if (i_335_ > 0) {
				if (((Class193) class193).aShort1487 >= 0) {
				    int i_336_ = -16777216;
				    if (bool_334_)
					i_336_ = -1694498816;
				    class12.method212
					((float) i_284_, (float) i_286_,
					 (float) i_282_, (float) i_283_,
					 (float) i_285_, (float) i_281_,
					 f_277_, f_278_, f_276_, 1.0F, 0.0F,
					 1.0F, 1.0F, 1.0F, 0.0F,
					 i_336_ | (((Class193) class193)
						   .anInt1493) & 0xffffff,
					 i_336_ | (((Class193) class193)
						   .anInt1484) & 0xffffff,
					 i_336_ | (((Class193) class193)
						   .anInt1491) & 0xffffff,
					 ((Class235) class235).anInt1763,
					 i_274_, i_275_, i_273_,
					 ((Class193) class193).aShort1487);
				} else {
				    if (bool_334_)
					((Class12) class12).anInt137 = 100;
				    class12.method206
					((float) i_284_, (float) i_286_,
					 (float) i_282_, (float) i_283_,
					 (float) i_285_, (float) i_281_,
					 (float) (int) f_277_,
					 (float) (int) f_278_,
					 (float) (int) f_276_,
					 (Class98_Sub46_Sub5.method1544
					  ((i_274_ << 24
					    | ((Class235) class235).anInt1763),
					   (byte) 104,
					   ((Class193) class193).anInt1493)),
					 (Class98_Sub46_Sub5.method1544
					  ((i_275_ << 24
					    | ((Class235) class235).anInt1763),
					   (byte) 109,
					   ((Class193) class193).anInt1484)),
					 (Class98_Sub46_Sub5.method1544
					  ((i_273_ << 24
					    | ((Class235) class235).anInt1763),
					   (byte) 107,
					   ((Class193) class193).anInt1491)));
				    ((Class12) class12).anInt137 = 0;
				}
			    } else if (((Class193) class193).aShort1487 >= 0) {
				int i_337_ = -16777216;
				if (bool_334_)
				    i_337_ = -1694498816;
				class12.method212
				    ((float) i_284_, (float) i_286_,
				     (float) i_282_, (float) i_283_,
				     (float) i_285_, (float) i_281_, f_277_,
				     f_278_, f_276_, 1.0F, 0.0F, 1.0F, 1.0F,
				     1.0F, 0.0F,
				     i_337_ | (((Class193) class193).anInt1493
					       & 0xffffff),
				     i_337_ | (((Class193) class193).anInt1484
					       & 0xffffff),
				     i_337_ | (((Class193) class193).anInt1491
					       & 0xffffff),
				     0, 0, 0, 0,
				     ((Class193) class193).aShort1487);
			    } else {
				if (bool_334_)
				    ((Class12) class12).anInt137 = 100;
				class12.method206
				    ((float) i_284_, (float) i_286_,
				     (float) i_282_, (float) i_283_,
				     (float) i_285_, (float) i_281_,
				     (float) (int) f_277_,
				     (float) (int) f_278_,
				     (float) (int) f_276_,
				     ((Class193) class193).anInt1493,
				     ((Class193) class193).anInt1484,
				     ((Class193) class193).anInt1491);
				((Class12) class12).anInt137 = 0;
			    }
			} else
			    class12.method208((float) i_284_, (float) i_286_,
					      (float) i_282_, (float) i_283_,
					      (float) i_285_, (float) i_281_,
					      (float) (int) f_277_,
					      (float) (int) f_278_,
					      (float) (int) f_276_,
					      ((Class235) class235).anInt1763);
		    }
		    i_335_ = i_272_ + i_273_ + i_275_;
		    if (((i_279_ - i_281_) * (i_286_ - i_282_)
			 - (i_280_ - i_282_) * (i_285_ - i_281_))
			> 0) {
			((Class12) class12).aBoolean135
			    = (i_279_ < 0 || i_281_ < 0 || i_285_ < 0
			       || i_279_ > ((Class12) class12).anInt141
			       || i_281_ > ((Class12) class12).anInt141
			       || i_285_ > ((Class12) class12).anInt141);
			if (i_335_ < 765) {
			    if (bool_334_)
				((Class12) class12).anInt137 = -1694498816;
			    if (i_335_ > 0) {
				if (((Class193) class193).aShort1487 >= 0) {
				    int i_338_ = -16777216;
				    if (bool_334_)
					i_338_ = -1694498816;
				    class12.method212
					((float) i_280_, (float) i_282_,
					 (float) i_286_, (float) i_279_,
					 (float) i_281_, (float) i_285_, f,
					 f_276_, f_278_, 0.0F, 1.0F, 1.0F,
					 0.0F, 0.0F, 1.0F,
					 i_338_ | (((Class193) class193)
						   .anInt1490) & 0xffffff,
					 i_338_ | (((Class193) class193)
						   .anInt1491) & 0xffffff,
					 i_338_ | (((Class193) class193)
						   .anInt1484) & 0xffffff,
					 ((Class235) class235).anInt1763,
					 i_272_, i_273_, i_275_,
					 ((Class193) class193).aShort1487);
				} else {
				    if (bool_334_)
					((Class12) class12).anInt137 = 100;
				    class12.method206
					((float) i_280_, (float) i_282_,
					 (float) i_286_, (float) i_279_,
					 (float) i_281_, (float) i_285_,
					 (float) (int) f, (float) (int) f_276_,
					 (float) (int) f_278_,
					 (Class98_Sub46_Sub5.method1544
					  ((i_272_ << 24
					    | ((Class235) class235).anInt1763),
					   (byte) 112,
					   ((Class193) class193).anInt1490)),
					 (Class98_Sub46_Sub5.method1544
					  ((i_273_ << 24
					    | ((Class235) class235).anInt1763),
					   (byte) 122,
					   ((Class193) class193).anInt1491)),
					 (Class98_Sub46_Sub5.method1544
					  ((i_275_ << 24
					    | ((Class235) class235).anInt1763),
					   (byte) 121,
					   ((Class193) class193).anInt1484)));
				    ((Class12) class12).anInt137 = 0;
				}
			    } else if (((Class193) class193).aShort1487 >= 0) {
				int i_339_ = -16777216;
				if (bool_334_)
				    i_339_ = -1694498816;
				class12.method212
				    ((float) i_280_, (float) i_282_,
				     (float) i_286_, (float) i_279_,
				     (float) i_281_, (float) i_285_, f, f_276_,
				     f_278_, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F,
				     1.0F,
				     i_339_ | (((Class193) class193).anInt1490
					       & 0xffffff),
				     i_339_ | (((Class193) class193).anInt1491
					       & 0xffffff),
				     i_339_ | (((Class193) class193).anInt1484
					       & 0xffffff),
				     0, 0, 0, 0,
				     ((Class193) class193).aShort1487);
			    } else {
				if (bool_334_)
				    ((Class12) class12).anInt137 = 100;
				class12.method206
				    ((float) i_280_, (float) i_282_,
				     (float) i_286_, (float) i_279_,
				     (float) i_281_, (float) i_285_,
				     (float) (int) f, (float) (int) f_276_,
				     (float) (int) f_278_,
				     ((Class193) class193).anInt1490,
				     ((Class193) class193).anInt1491,
				     ((Class193) class193).anInt1484);
				((Class12) class12).anInt137 = 0;
			    }
			} else
			    class12.method208((float) i_280_, (float) i_282_,
					      (float) i_286_, (float) i_279_,
					      (float) i_281_, (float) i_285_,
					      (float) (int) f,
					      (float) (int) f_276_,
					      (float) (int) f_278_,
					      ((Class235) class235).anInt1763);
		    }
		} else {
		    int i_340_ = i_273_ + i_274_ + i_275_;
		    if (((i_283_ - i_285_) * (i_282_ - i_286_)
			 - (i_284_ - i_286_) * (i_281_ - i_285_))
			> 0) {
			((Class12) class12).aBoolean135
			    = (i_283_ < 0 || i_285_ < 0 || i_281_ < 0
			       || i_283_ > ((Class12) class12).anInt141
			       || i_285_ > ((Class12) class12).anInt141
			       || i_281_ > ((Class12) class12).anInt141);
			if (i_340_ < 765) {
			    if (bool_334_)
				((Class12) class12).anInt137 = -1694498816;
			    if (i_340_ > 0) {
				if (((Class193) class193).aShort1487 >= 0) {
				    int i_341_ = -16777216;
				    if (bool_334_)
					i_341_ = -1694498816;
				    class12.method212
					((float) i_284_, (float) i_286_,
					 (float) i_282_, (float) i_283_,
					 (float) i_285_, (float) i_281_,
					 f_277_, f_278_, f_276_, 1.0F, 0.0F,
					 1.0F, 1.0F, 1.0F, 0.0F,
					 i_341_ | (((Class193) class193)
						   .anInt1493) & 0xffffff,
					 i_341_ | (((Class193) class193)
						   .anInt1484) & 0xffffff,
					 i_341_ | (((Class193) class193)
						   .anInt1491) & 0xffffff,
					 ((Class235) class235).anInt1763,
					 i_274_, i_275_, i_273_,
					 ((Class193) class193).aShort1487);
				} else {
				    if (bool_334_)
					((Class12) class12).anInt137 = 100;
				    class12.method206
					((float) i_284_, (float) i_286_,
					 (float) i_282_, (float) i_283_,
					 (float) i_285_, (float) i_281_,
					 (float) (int) f_277_,
					 (float) (int) f_278_,
					 (float) (int) f_276_,
					 (Class98_Sub46_Sub5.method1544
					  ((i_274_ << 24
					    | ((Class235) class235).anInt1763),
					   (byte) 127,
					   ((Class193) class193).anInt1493)),
					 (Class98_Sub46_Sub5.method1544
					  ((i_275_ << 24
					    | ((Class235) class235).anInt1763),
					   (byte) 124,
					   ((Class193) class193).anInt1484)),
					 (Class98_Sub46_Sub5.method1544
					  ((i_273_ << 24
					    | ((Class235) class235).anInt1763),
					   (byte) 114,
					   ((Class193) class193).anInt1491)));
				    ((Class12) class12).anInt137 = 0;
				}
			    } else if (((Class193) class193).aShort1487 >= 0) {
				int i_342_ = -16777216;
				if (bool_334_)
				    i_342_ = -1694498816;
				class12.method212
				    ((float) i_284_, (float) i_286_,
				     (float) i_282_, (float) i_283_,
				     (float) i_285_, (float) i_281_, f_277_,
				     f_278_, f_276_, 1.0F, 0.0F, 1.0F, 1.0F,
				     1.0F, 0.0F,
				     i_342_ | (((Class193) class193).anInt1493
					       & 0xffffff),
				     i_342_ | (((Class193) class193).anInt1484
					       & 0xffffff),
				     i_342_ | (((Class193) class193).anInt1491
					       & 0xffffff),
				     0, 0, 0, 0,
				     ((Class193) class193).aShort1487);
			    } else {
				if (bool_334_)
				    ((Class12) class12).anInt137 = 100;
				class12.method206
				    ((float) i_284_, (float) i_286_,
				     (float) i_282_, (float) i_283_,
				     (float) i_285_, (float) i_281_,
				     (float) (int) f_277_,
				     (float) (int) f_278_,
				     (float) (int) f_276_,
				     ((Class193) class193).anInt1493,
				     ((Class193) class193).anInt1484,
				     ((Class193) class193).anInt1491);
				((Class12) class12).anInt137 = 0;
			    }
			} else
			    class12.method208((float) i_284_, (float) i_286_,
					      (float) i_282_, (float) i_283_,
					      (float) i_285_, (float) i_281_,
					      (float) (int) f_277_,
					      (float) (int) f_278_,
					      (float) (int) f_276_,
					      ((Class235) class235).anInt1763);
		    }
		    i_340_ = i_272_ + i_273_ + i_275_;
		    if (((i_279_ - i_281_) * (i_286_ - i_282_)
			 - (i_280_ - i_282_) * (i_285_ - i_281_))
			> 0) {
			((Class12) class12).aBoolean135
			    = (i_279_ < 0 || i_281_ < 0 || i_285_ < 0
			       || i_279_ > ((Class12) class12).anInt141
			       || i_281_ > ((Class12) class12).anInt141
			       || i_285_ > ((Class12) class12).anInt141);
			if (i_340_ < 765) {
			    if (bool_334_)
				((Class12) class12).anInt137 = -1694498816;
			    if (i_340_ > 0) {
				if (((Class193) class193).aShort1487 >= 0) {
				    int i_343_ = -16777216;
				    if (bool_334_)
					i_343_ = -1694498816;
				    class12.method212
					((float) i_280_, (float) i_282_,
					 (float) i_286_, (float) i_279_,
					 (float) i_281_, (float) i_285_, f,
					 f_276_, f_278_, 0.0F, 1.0F, 1.0F,
					 0.0F, 0.0F, 1.0F,
					 i_343_ | (((Class193) class193)
						   .anInt1490) & 0xffffff,
					 i_343_ | (((Class193) class193)
						   .anInt1491) & 0xffffff,
					 i_343_ | (((Class193) class193)
						   .anInt1484) & 0xffffff,
					 ((Class235) class235).anInt1763,
					 i_272_, i_273_, i_275_,
					 ((Class193) class193).aShort1487);
				} else {
				    if (bool_334_)
					((Class12) class12).anInt137 = 100;
				    class12.method206
					((float) i_280_, (float) i_282_,
					 (float) i_286_, (float) i_279_,
					 (float) i_281_, (float) i_285_,
					 (float) (int) f, (float) (int) f_276_,
					 (float) (int) f_278_,
					 (Class98_Sub46_Sub5.method1544
					  ((i_272_ << 24
					    | ((Class235) class235).anInt1763),
					   (byte) 105,
					   ((Class193) class193).anInt1490)),
					 (Class98_Sub46_Sub5.method1544
					  ((i_273_ << 24
					    | ((Class235) class235).anInt1763),
					   (byte) 118,
					   ((Class193) class193).anInt1491)),
					 (Class98_Sub46_Sub5.method1544
					  ((i_275_ << 24
					    | ((Class235) class235).anInt1763),
					   (byte) 105,
					   ((Class193) class193).anInt1484)));
				    ((Class12) class12).anInt137 = 0;
				}
			    } else if (((Class193) class193).aShort1487 >= 0) {
				int i_344_ = -16777216;
				if (bool_334_)
				    i_344_ = -1694498816;
				class12.method212
				    ((float) i_280_, (float) i_282_,
				     (float) i_286_, (float) i_279_,
				     (float) i_281_, (float) i_285_, f, f_276_,
				     f_278_, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F,
				     1.0F,
				     i_344_ | (((Class193) class193).anInt1490
					       & 0xffffff),
				     i_344_ | (((Class193) class193).anInt1491
					       & 0xffffff),
				     i_344_ | (((Class193) class193).anInt1484
					       & 0xffffff),
				     0, 0, 0, 0,
				     ((Class193) class193).aShort1487);
			    } else {
				if (bool_334_)
				    ((Class12) class12).anInt137 = 100;
				class12.method206
				    ((float) i_280_, (float) i_282_,
				     (float) i_286_, (float) i_279_,
				     (float) i_281_, (float) i_285_,
				     (float) (int) f, (float) (int) f_276_,
				     (float) (int) f_278_,
				     ((Class193) class193).anInt1490,
				     ((Class193) class193).anInt1491,
				     ((Class193) class193).anInt1484);
				((Class12) class12).anInt137 = 0;
			    }
			} else
			    class12.method208((float) i_280_, (float) i_282_,
					      (float) i_286_, (float) i_279_,
					      (float) i_281_, (float) i_285_,
					      (float) (int) f,
					      (float) (int) f_276_,
					      (float) (int) f_278_,
					      ((Class235) class235).anInt1763);
		    }
		}
	    }
	} else {
	    Class285 class285 = aClass285ArrayArray5258[i][i_263_];
	    if (class285 != null) {
		if (i_267_ != 0) {
		    if ((((Class285) class285).aByte2172 & 0x4) != 0) {
			if ((i_267_ & 0x1) != 0)
			    return;
		    } else if ((i_267_ & 0x2) != 0)
			return;
		}
		if (anInt5262 == -1) {
		    for (int i_345_ = 0;
			 i_345_ < ((Class285) class285).aShort2174; i_345_++) {
			int i_346_
			    = (((Class285) class285).aShortArray2176[i_345_]
			       + (i << ((s) this).anInt2200));
			int i_347_
			    = ((Class285) class285).aShortArray2179[i_345_];
			int i_348_
			    = (((Class285) class285).aShortArray2170[i_345_]
			       + (i_263_ << ((s) this).anInt2200));
			float f = aFloat5274 + (aFloat5260 * (float) i_346_
						+ aFloat5270 * (float) i_347_
						+ aFloat5263 * (float) i_348_);
			if (f <= (float) ((ha_Sub2) aHa_Sub2_5269).anInt4502)
			    return;
			is_266_[i_345_] = 0;
			if (bool) {
			    int i_349_
				= (int) (f - (float) (((Class235) class235)
						      .anInt1761));
			    if (i_349_ > 255)
				i_349_ = 255;
			    if (i_349_ > 0) {
				is_266_[i_345_] = i_349_;
				int i_350_ = ((((Class285) class285)
					       .aShortArray2178[i_345_])
					      * i_349_ / 255);
				if (i_350_ > 0)
				    i_347_ -= i_350_;
			    }
			} else if (((Class235) class235).aBoolean1758) {
			    int i_351_
				= (int) (f - (float) (((Class235) class235)
						      .anInt1761));
			    if (i_351_ > 0) {
				is_266_[i_345_] = i_351_;
				if (is_266_[i_345_] > 255)
				    is_266_[i_345_] = 255;
			    }
			}
			float f_352_
			    = aFloat5268 + (aFloat5275 * (float) i_346_
					    + aFloat5271 * (float) i_347_
					    + aFloat5276 * (float) i_348_);
			float f_353_
			    = aFloat5255 + (aFloat5264 * (float) i_346_
					    + aFloat5273 * (float) i_347_
					    + aFloat5267 * (float) i_348_);
			is[i_345_]
			    = (((Class12) class12).anInt136
			       + (int) (f_352_
					* (float) (((ha_Sub2) aHa_Sub2_5269)
						   .anInt4514)
					/ f));
			is_264_[i_345_]
			    = (((Class12) class12).anInt128
			       + (int) (f_353_
					* (float) (((ha_Sub2) aHa_Sub2_5269)
						   .anInt4490)
					/ f));
			is_265_[i_345_] = (int) f;
		    }
		} else {
		    for (int i_354_ = 0;
			 i_354_ < ((Class285) class285).aShort2174; i_354_++) {
			int i_355_
			    = (((Class285) class285).aShortArray2176[i_354_]
			       + (i << ((s) this).anInt2200));
			int i_356_
			    = ((Class285) class285).aShortArray2179[i_354_];
			int i_357_
			    = (((Class285) class285).aShortArray2170[i_354_]
			       + (i_263_ << ((s) this).anInt2200));
			float f = aFloat5274 + (aFloat5260 * (float) i_355_
						+ aFloat5270 * (float) i_356_
						+ aFloat5263 * (float) i_357_);
			is_266_[i_354_] = 0;
			if (bool) {
			    int i_358_
				= anInt5262 - ((Class235) class235).anInt1761;
			    if (i_358_ > 255)
				i_358_ = 255;
			    if (i_358_ > 0) {
				is_266_[i_354_] = i_358_;
				int i_359_ = ((((Class285) class285)
					       .aShortArray2178[i_354_])
					      * i_358_ / 255);
				if (i_359_ > 0)
				    i_356_ -= i_359_;
			    }
			} else if (((Class235) class235).aBoolean1758) {
			    int i_360_
				= anInt5262 - ((Class235) class235).anInt1761;
			    if (i_360_ > 0) {
				is_266_[i_354_] = i_360_;
				if (is_266_[i_354_] > 255)
				    is_266_[i_354_] = 255;
			    }
			}
			float f_361_
			    = aFloat5268 + (aFloat5275 * (float) i_355_
					    + aFloat5271 * (float) i_356_
					    + aFloat5276 * (float) i_357_);
			float f_362_
			    = aFloat5255 + (aFloat5264 * (float) i_355_
					    + aFloat5273 * (float) i_356_
					    + aFloat5267 * (float) i_357_);
			is[i_354_]
			    = (((Class12) class12).anInt136
			       + (int) (f_361_
					* (float) (((ha_Sub2) aHa_Sub2_5269)
						   .anInt4514)
					/ (float) anInt5262));
			is_264_[i_354_]
			    = (((Class12) class12).anInt128
			       + (int) (f_362_
					* (float) (((ha_Sub2) aHa_Sub2_5269)
						   .anInt4490)
					/ (float) anInt5262));
			is_265_[i_354_] = (int) f;
		    }
		}
		if (((Class285) class285).aShortArray2169 != null) {
		    if (anInt5262 == -1) {
			for (int i_363_ = 0;
			     i_363_ < ((Class285) class285).aShort2171;
			     i_363_++) {
			    int i_364_ = i_363_ * 3;
			    int i_365_ = i_364_ + 1;
			    int i_366_ = i_365_ + 1;
			    int i_367_ = is[i_364_];
			    int i_368_ = is[i_365_];
			    int i_369_ = is[i_366_];
			    int i_370_ = is_264_[i_364_];
			    int i_371_ = is_264_[i_365_];
			    int i_372_ = is_264_[i_366_];
			    int i_373_ = (is_266_[i_364_] + is_266_[i_365_]
					  + is_266_[i_366_]);
			    if (((i_367_ - i_368_) * (i_372_ - i_371_)
				 - (i_370_ - i_371_) * (i_369_ - i_368_))
				> 0) {
				((Class12) class12).aBoolean135
				    = (i_367_ < 0 || i_368_ < 0 || i_369_ < 0
				       || i_367_ > ((Class12) class12).anInt141
				       || i_368_ > ((Class12) class12).anInt141
				       || (i_369_
					   > ((Class12) class12).anInt141));
				short i_374_ = (((Class285) class285)
						.aShortArray2169[i_363_]);
				if (i_373_ < 765) {
				    if (i_373_ > 0) {
					if (i_374_ != -1) {
					    int i_375_ = -16777216;
					    if (i_374_ != -1
						&& method3441(((Class238)
							       (((ha)
								 aHa_Sub2_5269)
								    .aD938
								    .method11
								(i_374_,
								 -28755)))
							      .aByte1820))
						i_375_ = -1694498816;
					    class12.method212
						((float) i_370_,
						 (float) i_371_,
						 (float) i_372_,
						 (float) i_367_,
						 (float) i_368_,
						 (float) i_369_,
						 (float) is_265_[i_364_],
						 (float) is_265_[i_365_],
						 (float) is_265_[i_366_],
						 ((float) (((Class285)
							    class285)
							   .aShortArray2176
							   [i_364_])
						  / (float) (((s) this)
							     .anInt2206)),
						 ((float) (((Class285)
							    class285)
							   .aShortArray2176
							   [i_365_])
						  / (float) (((s) this)
							     .anInt2206)),
						 ((float) (((Class285)
							    class285)
							   .aShortArray2176
							   [i_366_])
						  / (float) (((s) this)
							     .anInt2206)),
						 ((float) (((Class285)
							    class285)
							   .aShortArray2170
							   [i_364_])
						  / (float) (((s) this)
							     .anInt2206)),
						 ((float) (((Class285)
							    class285)
							   .aShortArray2170
							   [i_365_])
						  / (float) (((s) this)
							     .anInt2206)),
						 ((float) (((Class285)
							    class285)
							   .aShortArray2170
							   [i_366_])
						  / (float) (((s) this)
							     .anInt2206)),
						 (i_375_
						  | ((((Class285) class285)
						      .anIntArray2173[i_364_])
						     & 0xffffff)),
						 (i_375_
						  | ((((Class285) class285)
						      .anIntArray2173[i_365_])
						     & 0xffffff)),
						 (i_375_
						  | ((((Class285) class285)
						      .anIntArray2173[i_366_])
						     & 0xffffff)),
						 (((Class235) class235)
						  .anInt1763),
						 is_266_[i_364_],
						 is_266_[i_365_],
						 is_266_[i_366_], i_374_);
					} else if (((((Class285) class285)
						     .anIntArray2173[i_364_])
						    & 0xffffff)
						   != 0) {
					    if (i_374_ != -1
						&& method3441(((Class238)
							       (((ha)
								 aHa_Sub2_5269)
								    .aD938
								    .method11
								(i_374_,
								 -28755)))
							      .aByte1820))
						((Class12) class12).anInt137
						    = -1694498816;
					    class12.method206
						((float) i_370_,
						 (float) i_371_,
						 (float) i_372_,
						 (float) i_367_,
						 (float) i_368_,
						 (float) i_369_,
						 (float) is_265_[i_364_],
						 (float) is_265_[i_365_],
						 (float) is_265_[i_366_],
						 (Class98_Sub46_Sub5.method1544
						  ((is_266_[i_364_] << 24
						    | (((Class235) class235)
						       .anInt1763)),
						   (byte) 119,
						   (((Class285) class285)
						    .anIntArray2173[i_364_]))),
						 (Class98_Sub46_Sub5.method1544
						  ((is_266_[i_365_] << 24
						    | (((Class235) class235)
						       .anInt1763)),
						   (byte) 120,
						   (((Class285) class285)
						    .anIntArray2173[i_365_]))),
						 (Class98_Sub46_Sub5.method1544
						  ((is_266_[i_366_] << 24
						    | (((Class235) class235)
						       .anInt1763)),
						   (byte) 122,
						   (((Class285) class285)
						    .anIntArray2173
						    [i_366_]))));
					    ((Class12) class12).anInt137 = 0;
					}
				    } else if (i_374_ != -1) {
					int i_376_ = -16777216;
					if (i_374_ != -1
					    && method3441(((Class238)
							   (((ha)
							     aHa_Sub2_5269)
								.aD938.method11
							    (i_374_, -28755)))
							  .aByte1820))
					    i_376_ = -1694498816;
					class12.method212
					    ((float) i_370_, (float) i_371_,
					     (float) i_372_, (float) i_367_,
					     (float) i_368_, (float) i_369_,
					     (float) is_265_[i_364_],
					     (float) is_265_[i_365_],
					     (float) is_265_[i_366_],
					     ((float) (((Class285) class285)
						       .aShortArray2176
						       [i_364_])
					      / (float) ((s) this).anInt2206),
					     ((float) (((Class285) class285)
						       .aShortArray2176
						       [i_365_])
					      / (float) ((s) this).anInt2206),
					     ((float) (((Class285) class285)
						       .aShortArray2176
						       [i_366_])
					      / (float) ((s) this).anInt2206),
					     ((float) (((Class285) class285)
						       .aShortArray2170
						       [i_364_])
					      / (float) ((s) this).anInt2206),
					     ((float) (((Class285) class285)
						       .aShortArray2170
						       [i_365_])
					      / (float) ((s) this).anInt2206),
					     ((float) (((Class285) class285)
						       .aShortArray2170
						       [i_366_])
					      / (float) ((s) this).anInt2206),
					     i_376_ | (((Class285) class285)
						       .anIntArray2173
						       [i_364_]) & 0xffffff,
					     i_376_ | (((Class285) class285)
						       .anIntArray2173
						       [i_365_]) & 0xffffff,
					     i_376_ | (((Class285) class285)
						       .anIntArray2173
						       [i_366_]) & 0xffffff,
					     0, 0, 0, 0, i_374_);
				    } else if (((((Class285) class285)
						 .anIntArray2173[i_364_])
						& 0xffffff)
					       != 0) {
					if (i_374_ != -1
					    && method3441(((Class238)
							   (((ha)
							     aHa_Sub2_5269)
								.aD938.method11
							    (i_374_, -28755)))
							  .aByte1820))
					    ((Class12) class12).anInt137
						= -1694498816;
					class12.method206
					    ((float) i_370_, (float) i_371_,
					     (float) i_372_, (float) i_367_,
					     (float) i_368_, (float) i_369_,
					     (float) is_265_[i_364_],
					     (float) is_265_[i_365_],
					     (float) is_265_[i_366_],
					     (((Class285) class285)
					      .anIntArray2173[i_364_]),
					     (((Class285) class285)
					      .anIntArray2173[i_365_]),
					     (((Class285) class285)
					      .anIntArray2173[i_366_]));
					((Class12) class12).anInt137 = 0;
				    }
				} else
				    class12.method208((float) i_370_,
						      (float) i_371_,
						      (float) i_372_,
						      (float) i_367_,
						      (float) i_368_,
						      (float) i_369_,
						      (float) is_265_[i_364_],
						      (float) is_265_[i_365_],
						      (float) is_265_[i_366_],
						      (((Class235) class235)
						       .anInt1763));
			    }
			}
		    } else {
			for (int i_377_ = 0;
			     i_377_ < ((Class285) class285).aShort2171;
			     i_377_++) {
			    int i_378_ = i_377_ * 3;
			    int i_379_ = i_378_ + 1;
			    int i_380_ = i_379_ + 1;
			    int i_381_ = is[i_378_];
			    int i_382_ = is[i_379_];
			    int i_383_ = is[i_380_];
			    int i_384_ = is_264_[i_378_];
			    int i_385_ = is_264_[i_379_];
			    int i_386_ = is_264_[i_380_];
			    int i_387_ = (is_266_[i_378_] + is_266_[i_379_]
					  + is_266_[i_380_]);
			    if (((i_381_ - i_382_) * (i_386_ - i_385_)
				 - (i_384_ - i_385_) * (i_383_ - i_382_))
				> 0) {
				((Class12) class12).aBoolean135
				    = (i_381_ < 0 || i_382_ < 0 || i_383_ < 0
				       || i_381_ > ((Class12) class12).anInt141
				       || i_382_ > ((Class12) class12).anInt141
				       || (i_383_
					   > ((Class12) class12).anInt141));
				short i_388_ = (((Class285) class285)
						.aShortArray2169[i_377_]);
				if (i_387_ < 765) {
				    if (i_388_ != -1
					&& method3441(((Class238)
						       (((ha) aHa_Sub2_5269)
							    .aD938.method11
							(i_388_, -28755)))
						      .aByte1820))
					((Class12) class12).anInt137
					    = -1694498816;
				    if (i_387_ > 0) {
					if (i_388_ != -1) {
					    int i_389_ = -16777216;
					    if (i_388_ != -1
						&& method3441(((Class238)
							       (((ha)
								 aHa_Sub2_5269)
								    .aD938
								    .method11
								(i_388_,
								 -28755)))
							      .aByte1820))
						i_389_ = -1694498816;
					    class12.method212
						((float) i_384_,
						 (float) i_385_,
						 (float) i_386_,
						 (float) i_381_,
						 (float) i_382_,
						 (float) i_383_,
						 (float) is_265_[i_378_],
						 (float) is_265_[i_379_],
						 (float) is_265_[i_380_],
						 ((float) (((Class285)
							    class285)
							   .aShortArray2176
							   [i_378_])
						  / (float) (((s) this)
							     .anInt2206)),
						 ((float) (((Class285)
							    class285)
							   .aShortArray2176
							   [i_379_])
						  / (float) (((s) this)
							     .anInt2206)),
						 ((float) (((Class285)
							    class285)
							   .aShortArray2176
							   [i_380_])
						  / (float) (((s) this)
							     .anInt2206)),
						 ((float) (((Class285)
							    class285)
							   .aShortArray2170
							   [i_378_])
						  / (float) (((s) this)
							     .anInt2206)),
						 ((float) (((Class285)
							    class285)
							   .aShortArray2170
							   [i_379_])
						  / (float) (((s) this)
							     .anInt2206)),
						 ((float) (((Class285)
							    class285)
							   .aShortArray2170
							   [i_380_])
						  / (float) (((s) this)
							     .anInt2206)),
						 (i_389_
						  | ((((Class285) class285)
						      .anIntArray2173[i_378_])
						     & 0xffffff)),
						 (i_389_
						  | ((((Class285) class285)
						      .anIntArray2173[i_379_])
						     & 0xffffff)),
						 (i_389_
						  | ((((Class285) class285)
						      .anIntArray2173[i_380_])
						     & 0xffffff)),
						 (((Class235) class235)
						  .anInt1763),
						 is_266_[i_378_],
						 is_266_[i_379_],
						 is_266_[i_380_], i_388_);
					} else if (((((Class285) class285)
						     .anIntArray2173[i_378_])
						    & 0xffffff)
						   != 0) {
					    if (i_388_ != -1
						&& method3441(((Class238)
							       (((ha)
								 aHa_Sub2_5269)
								    .aD938
								    .method11
								(i_388_,
								 -28755)))
							      .aByte1820))
						((Class12) class12).anInt137
						    = -1694498816;
					    class12.method206
						((float) i_384_,
						 (float) i_385_,
						 (float) i_386_,
						 (float) i_381_,
						 (float) i_382_,
						 (float) i_383_,
						 (float) is_265_[i_378_],
						 (float) is_265_[i_379_],
						 (float) is_265_[i_380_],
						 (Class98_Sub46_Sub5.method1544
						  ((is_266_[i_378_] << 24
						    | (((Class235) class235)
						       .anInt1763)),
						   (byte) 117,
						   (((Class285) class285)
						    .anIntArray2173[i_378_]))),
						 (Class98_Sub46_Sub5.method1544
						  ((is_266_[i_379_] << 24
						    | (((Class235) class235)
						       .anInt1763)),
						   (byte) 104,
						   (((Class285) class285)
						    .anIntArray2173[i_379_]))),
						 (Class98_Sub46_Sub5.method1544
						  ((is_266_[i_380_] << 24
						    | (((Class235) class235)
						       .anInt1763)),
						   (byte) 123,
						   (((Class285) class285)
						    .anIntArray2173
						    [i_380_]))));
					    ((Class12) class12).anInt137 = 0;
					}
				    } else if (i_388_ != -1) {
					int i_390_ = -16777216;
					if (i_388_ != -1
					    && method3441(((Class238)
							   (((ha)
							     aHa_Sub2_5269)
								.aD938.method11
							    (i_388_, -28755)))
							  .aByte1820))
					    i_390_ = -1694498816;
					class12.method212
					    ((float) i_384_, (float) i_385_,
					     (float) i_386_, (float) i_381_,
					     (float) i_382_, (float) i_383_,
					     (float) is_265_[i_378_],
					     (float) is_265_[i_379_],
					     (float) is_265_[i_380_],
					     ((float) (((Class285) class285)
						       .aShortArray2176
						       [i_378_])
					      / (float) ((s) this).anInt2206),
					     ((float) (((Class285) class285)
						       .aShortArray2176
						       [i_379_])
					      / (float) ((s) this).anInt2206),
					     ((float) (((Class285) class285)
						       .aShortArray2176
						       [i_380_])
					      / (float) ((s) this).anInt2206),
					     ((float) (((Class285) class285)
						       .aShortArray2170
						       [i_378_])
					      / (float) ((s) this).anInt2206),
					     ((float) (((Class285) class285)
						       .aShortArray2170
						       [i_379_])
					      / (float) ((s) this).anInt2206),
					     ((float) (((Class285) class285)
						       .aShortArray2170
						       [i_380_])
					      / (float) ((s) this).anInt2206),
					     i_390_ | (((Class285) class285)
						       .anIntArray2173
						       [i_378_]) & 0xffffff,
					     i_390_ | (((Class285) class285)
						       .anIntArray2173
						       [i_379_]) & 0xffffff,
					     i_390_ | (((Class285) class285)
						       .anIntArray2173
						       [i_380_]) & 0xffffff,
					     0, 0, 0, 0, i_388_);
				    } else if (((((Class285) class285)
						 .anIntArray2173[i_378_])
						& 0xffffff)
					       != 0) {
					if (i_388_ != -1
					    && method3441(((Class238)
							   (((ha)
							     aHa_Sub2_5269)
								.aD938.method11
							    (i_388_, -28755)))
							  .aByte1820))
					    ((Class12) class12).anInt137
						= -1694498816;
					class12.method206
					    ((float) i_384_, (float) i_385_,
					     (float) i_386_, (float) i_381_,
					     (float) i_382_, (float) i_383_,
					     (float) is_265_[i_378_],
					     (float) is_265_[i_379_],
					     (float) is_265_[i_380_],
					     (((Class285) class285)
					      .anIntArray2173[i_378_]),
					     (((Class285) class285)
					      .anIntArray2173[i_379_]),
					     (((Class285) class285)
					      .anIntArray2173[i_380_]));
					((Class12) class12).anInt137 = 0;
				    }
				    ((Class12) class12).anInt137 = 0;
				} else
				    class12.method208((float) i_384_,
						      (float) i_385_,
						      (float) i_386_,
						      (float) i_381_,
						      (float) i_382_,
						      (float) i_383_,
						      (float) is_265_[i_378_],
						      (float) is_265_[i_379_],
						      (float) is_265_[i_380_],
						      (((Class235) class235)
						       .anInt1763));
			    }
			}
		    }
		} else {
		    for (int i_391_ = 0;
			 i_391_ < ((Class285) class285).aShort2171; i_391_++) {
			int i_392_ = i_391_ * 3;
			int i_393_ = i_392_ + 1;
			int i_394_ = i_393_ + 1;
			int i_395_ = is[i_392_];
			int i_396_ = is[i_393_];
			int i_397_ = is[i_394_];
			int i_398_ = is_264_[i_392_];
			int i_399_ = is_264_[i_393_];
			int i_400_ = is_264_[i_394_];
			int i_401_ = (is_266_[i_392_] + is_266_[i_393_]
				      + is_266_[i_394_]);
			if (((i_395_ - i_396_) * (i_400_ - i_399_)
			     - (i_398_ - i_399_) * (i_397_ - i_396_))
			    > 0) {
			    ((Class12) class12).aBoolean135
				= (i_395_ < 0 || i_396_ < 0 || i_397_ < 0
				   || i_395_ > ((Class12) class12).anInt141
				   || i_396_ > ((Class12) class12).anInt141
				   || i_397_ > ((Class12) class12).anInt141);
			    if (i_401_ < 765) {
				if (i_401_ > 0) {
				    if (((((Class285) class285).anIntArray2173
					  [i_392_])
					 & 0xffffff)
					!= 0)
					class12.method206
					    ((float) i_398_, (float) i_399_,
					     (float) i_400_, (float) i_395_,
					     (float) i_396_, (float) i_397_,
					     (float) is_265_[i_392_],
					     (float) is_265_[i_393_],
					     (float) is_265_[i_394_],
					     (Class215.method2790
					      (126, is_266_[i_392_],
					       (((Class285) class285)
						.anIntArray2173[i_392_]),
					       (((Class235) class235)
						.anInt1763))),
					     (Class215.method2790
					      (126, is_266_[i_393_],
					       (((Class285) class285)
						.anIntArray2173[i_393_]),
					       (((Class235) class235)
						.anInt1763))),
					     (Class215.method2790
					      (127, is_266_[i_394_],
					       (((Class285) class285)
						.anIntArray2173[i_394_]),
					       (((Class235) class235)
						.anInt1763))));
				} else if (((((Class285) class285)
					     .anIntArray2173[i_392_])
					    & 0xffffff)
					   != 0)
				    class12.method206
					((float) i_398_, (float) i_399_,
					 (float) i_400_, (float) i_395_,
					 (float) i_396_, (float) i_397_,
					 (float) is_265_[i_392_],
					 (float) is_265_[i_393_],
					 (float) is_265_[i_394_],
					 (((Class285) class285).anIntArray2173
					  [i_392_]),
					 (((Class285) class285).anIntArray2173
					  [i_393_]),
					 (((Class285) class285).anIntArray2173
					  [i_394_]));
			    } else
				class12.method208((float) i_398_,
						  (float) i_399_,
						  (float) i_400_,
						  (float) i_395_,
						  (float) i_396_,
						  (float) i_397_,
						  (float) is_265_[i_392_],
						  (float) is_265_[i_393_],
						  (float) is_265_[i_394_],
						  (((Class235) class235)
						   .anInt1763));
			}
		    }
		}
	    }
	}
    }
    
    final void method3426(int i, int i_402_, int i_403_, boolean[][] bools,
			  boolean bool, int i_404_) {
	Class111_Sub2 class111_sub2
	    = ((ha_Sub2) aHa_Sub2_5269).aClass111_Sub2_4513;
	anInt5262 = -1;
	aFloat5275 = ((Class111_Sub2) class111_sub2).aFloat4700;
	aFloat5271 = ((Class111_Sub2) class111_sub2).aFloat4699;
	aFloat5276 = ((Class111_Sub2) class111_sub2).aFloat4690;
	aFloat5268 = ((Class111_Sub2) class111_sub2).aFloat4697;
	aFloat5264 = ((Class111_Sub2) class111_sub2).aFloat4692;
	aFloat5273 = ((Class111_Sub2) class111_sub2).aFloat4688;
	aFloat5267 = ((Class111_Sub2) class111_sub2).aFloat4696;
	aFloat5255 = ((Class111_Sub2) class111_sub2).aFloat4691;
	aFloat5260 = ((Class111_Sub2) class111_sub2).aFloat4693;
	aFloat5270 = ((Class111_Sub2) class111_sub2).aFloat4698;
	aFloat5263 = ((Class111_Sub2) class111_sub2).aFloat4694;
	aFloat5274 = ((Class111_Sub2) class111_sub2).aFloat4689;
	for (int i_405_ = 0; i_405_ < i_403_ + i_403_; i_405_++) {
	    for (int i_406_ = 0; i_406_ < i_403_ + i_403_; i_406_++) {
		if (bools[i_405_][i_406_]) {
		    int i_407_ = i - i_403_ + i_405_;
		    int i_408_ = i_402_ - i_403_ + i_406_;
		    if (i_407_ >= 0 && i_407_ < ((s) this).anInt2203
			&& i_408_ >= 0 && i_408_ < ((s) this).anInt2204)
			method3443(i_407_, i_408_, i_404_);
		}
	    }
	}
    }
    
    private final void method3443(int i, int i_409_, int i_410_) {
	Class235 class235 = aHa_Sub2_5269.method1921(Thread.currentThread());
	((Class12) ((Class235) class235).aClass12_1767).anInt137 = 0;
	if (aClass193ArrayArray5272 != null)
	    method3442(i, i_409_, ((Class235) class235).aBoolean1759, class235,
		       ((Class235) class235).aClass12_1767,
		       ((Class235) class235).anIntArray1795,
		       ((Class235) class235).anIntArray1788,
		       ((Class235) class235).anIntArray1784,
		       ((Class235) class235).anIntArray1781, i_410_);
	else if (aClass327ArrayArray5265 != null)
	    method3440(i, i_409_, ((Class235) class235).aClass12_1767,
		       ((Class235) class235).anIntArray1795,
		       ((Class235) class235).anIntArray1788,
		       ((Class235) class235).anIntArray1784,
		       ((Class235) class235).anIntArray1781, i_410_);
	else if (aClass120ArrayArray5266 != null)
	    method3438(i, i_409_, ((Class235) class235).aBoolean1759, class235,
		       ((Class235) class235).aClass12_1767,
		       ((Class235) class235).anIntArray1795,
		       ((Class235) class235).anIntArray1788,
		       ((Class235) class235).anIntArray1784,
		       ((Class235) class235).anIntArray1781, i_410_);
    }
    
    final void method3416(int i, int i_411_, int i_412_, boolean[][] bools,
			  boolean bool, int i_413_, int i_414_) {
	Class111_Sub2 class111_sub2
	    = ((ha_Sub2) aHa_Sub2_5269).aClass111_Sub2_4513;
	anInt5262 = i_413_;
	aFloat5275 = ((Class111_Sub2) class111_sub2).aFloat4700;
	aFloat5271 = ((Class111_Sub2) class111_sub2).aFloat4699;
	aFloat5276 = ((Class111_Sub2) class111_sub2).aFloat4690;
	aFloat5268 = ((Class111_Sub2) class111_sub2).aFloat4697;
	aFloat5264 = ((Class111_Sub2) class111_sub2).aFloat4692;
	aFloat5273 = ((Class111_Sub2) class111_sub2).aFloat4688;
	aFloat5267 = ((Class111_Sub2) class111_sub2).aFloat4696;
	aFloat5255 = ((Class111_Sub2) class111_sub2).aFloat4691;
	aFloat5260 = ((Class111_Sub2) class111_sub2).aFloat4693;
	aFloat5270 = ((Class111_Sub2) class111_sub2).aFloat4698;
	aFloat5263 = ((Class111_Sub2) class111_sub2).aFloat4694;
	aFloat5274 = ((Class111_Sub2) class111_sub2).aFloat4689;
	for (int i_415_ = 0; i_415_ < i_412_ + i_412_; i_415_++) {
	    for (int i_416_ = 0; i_416_ < i_412_ + i_412_; i_416_++) {
		if (bools[i_415_][i_416_]) {
		    int i_417_ = i - i_412_ + i_415_;
		    int i_418_ = i_411_ - i_412_ + i_416_;
		    if (i_417_ >= 0 && i_417_ < ((s) this).anInt2203
			&& i_418_ >= 0 && i_418_ < ((s) this).anInt2204)
			method3443(i_417_, i_418_, i_414_);
		}
	    }
	}
    }
    
    final void method3424(int i, int i_419_, int[] is, int[] is_420_,
			  int[] is_421_, int[] is_422_, int[] is_423_,
			  int[] is_424_, int[] is_425_, int[] is_426_,
			  int[] is_427_, int[] is_428_, int[] is_429_,
			  int i_430_, int i_431_, int i_432_, boolean bool) {
	if (aClass327ArrayArray5265 == null) {
	    aClass327ArrayArray5265
		= new Class327[((s) this).anInt2203][((s) this).anInt2204];
	    aClass328ArrayArray5261
		= new Class328[((s) this).anInt2203][((s) this).anInt2204];
	} else if (aClass193ArrayArray5272 != null
		   || aClass120ArrayArray5266 != null)
	    throw new IllegalStateException();
	boolean bool_433_ = false;
	if (is_426_.length == 2 && is_423_.length == 2
	    && (is_426_[0] == is_426_[1]
		|| is_428_[0] != -1 && is_428_[0] == is_428_[1])) {
	    bool_433_ = true;
	    for (int i_434_ = 1; i_434_ < 2; i_434_++) {
		int i_435_ = is[is_423_[i_434_]];
		int i_436_ = is_421_[is_423_[i_434_]];
		if (i_435_ != 0 && i_435_ != ((s) this).anInt2206
		    || i_436_ != 0 && i_436_ != ((s) this).anInt2206) {
		    bool_433_ = false;
		    break;
		}
	    }
	}
	if (!bool_433_) {
	    Class328 class328 = new Class328();
	    short i_437_ = (short) is.length;
	    int i_438_ = (short) is_426_.length;
	    ((Class328) class328).aShort2748 = i_437_;
	    ((Class328) class328).aShortArray2750 = new short[i_437_];
	    ((Class328) class328).aShortArray2755 = new short[i_437_];
	    ((Class328) class328).aShortArray2754 = new short[i_437_];
	    ((Class328) class328).aShortArray2757 = new short[i_437_];
	    for (int i_439_ = 0; i_439_ < i_437_; i_439_++) {
		int i_440_ = is[i_439_];
		int i_441_ = is_421_[i_439_];
		if (i_440_ == 0 && i_441_ == 0)
		    ((Class328) class328).aShortArray2750[i_439_]
			= (short) (aByteArrayArray5257[i][i_419_]
				   - aByteArrayArray5259[i][i_419_]);
		else if (i_440_ == 0 && i_441_ == ((s) this).anInt2206)
		    ((Class328) class328).aShortArray2750[i_439_]
			= (short) (aByteArrayArray5257[i][i_419_ + 1]
				   - aByteArrayArray5259[i][i_419_ + 1]);
		else if (i_440_ == ((s) this).anInt2206
			 && i_441_ == ((s) this).anInt2206)
		    ((Class328) class328).aShortArray2750[i_439_]
			= (short) (aByteArrayArray5257[i + 1][i_419_ + 1]
				   - aByteArrayArray5259[i + 1][i_419_ + 1]);
		else if (i_440_ == ((s) this).anInt2206 && i_441_ == 0)
		    ((Class328) class328).aShortArray2750[i_439_]
			= (short) (aByteArrayArray5257[i + 1][i_419_]
				   - aByteArrayArray5259[i + 1][i_419_]);
		else {
		    int i_442_
			= (((aByteArrayArray5257[i][i_419_]
			     - aByteArrayArray5259[i][i_419_])
			    * (((s) this).anInt2206 - i_440_))
			   + (aByteArrayArray5257[i + 1][i_419_]
			      - aByteArrayArray5259[i + 1][i_419_]) * i_440_);
		    int i_443_ = (((aByteArrayArray5257[i][i_419_ + 1]
				    - aByteArrayArray5259[i][i_419_ + 1])
				   * (((s) this).anInt2206 - i_440_))
				  + ((aByteArrayArray5257[i + 1][i_419_ + 1]
				      - aByteArrayArray5259[i + 1][i_419_ + 1])
				     * i_440_));
		    ((Class328) class328).aShortArray2750[i_439_]
			= (short) ((i_442_ * (((s) this).anInt2206 - i_441_)
				    + i_443_ * i_441_)
				   >> 2 * ((s) this).anInt2200);
		}
		int i_444_ = (i << ((s) this).anInt2200) + i_440_;
		int i_445_ = (i_419_ << ((s) this).anInt2200) + i_441_;
		((Class328) class328).aShortArray2755[i_439_] = (short) i_440_;
		((Class328) class328).aShortArray2757[i_439_] = (short) i_441_;
		((Class328) class328).aShortArray2754[i_439_]
		    = (short) (this.method3417(i_444_, i_445_, true)
			       + (is_420_ != null ? is_420_[i_439_] : 0));
		if (((Class328) class328).aShortArray2750[i_439_] < 2)
		    ((Class328) class328).aShortArray2750[i_439_] = (short) 2;
	    }
	    boolean bool_446_ = false;
	    int i_447_ = 0;
	    for (int i_448_ = 0; i_448_ < i_438_; i_448_++) {
		if (is_426_[i_448_] >= 0
		    || is_427_ != null && is_427_[i_448_] >= 0)
		    i_447_++;
		int i_449_ = is_428_[i_448_];
		if (i_449_ != -1) {
		    Class238 class238
			= ((ha) aHa_Sub2_5269).aD938.method11(i_449_, -28755);
		    if (!((Class238) class238).aBoolean1825) {
			bool_446_ = true;
			if (method3441(((Class238) class238).aByte1820)
			    || ((Class238) class238).aByte1823 != 0
			    || ((Class238) class238).aByte1837 != 0)
			    ((Class328) class328).aByte2747 |= 0x4;
		    }
		}
	    }
	    ((Class328) class328).anIntArray2749 = new int[i_447_];
	    if (is_427_ != null)
		((Class328) class328).anIntArray2756 = new int[i_447_];
	    ((Class328) class328).aShortArray2758 = new short[i_447_];
	    ((Class328) class328).aShortArray2751 = new short[i_447_];
	    ((Class328) class328).aShortArray2759 = new short[i_447_];
	    if (bool_446_) {
		((Class328) class328).aShortArray2752 = new short[i_447_];
		((Class328) class328).aShortArray2753 = new short[i_447_];
	    }
	    for (int i_450_ = 0; i_450_ < i_438_; i_450_++) {
		if (is_426_[i_450_] >= 0
		    || is_427_ != null && is_427_[i_450_] >= 0) {
		    if (is_426_[i_450_] >= 0)
			((Class328) class328).anIntArray2749
			    [((Class328) class328).aShort2746]
			    = Class111_Sub2.method2117(is_426_[i_450_], -107);
		    else
			((Class328) class328).anIntArray2749
			    [((Class328) class328).aShort2746]
			    = -1;
		    if (is_427_ != null) {
			if (is_427_[i_450_] != -1)
			    ((Class328) class328).anIntArray2756
				[((Class328) class328).aShort2746]
				= Class111_Sub2.method2117(is_427_[i_450_],
							   110);
			else
			    ((Class328) class328).anIntArray2756
				[((Class328) class328).aShort2746]
				= -1;
		    }
		    ((Class328) class328).aShortArray2758
			[((Class328) class328).aShort2746]
			= (short) is_423_[i_450_];
		    ((Class328) class328).aShortArray2751
			[((Class328) class328).aShort2746]
			= (short) is_424_[i_450_];
		    ((Class328) class328).aShortArray2759
			[((Class328) class328).aShort2746]
			= (short) is_425_[i_450_];
		    if (bool_446_) {
			if (is_428_[i_450_] != -1
			    && !(((Class238)
				  ((ha) aHa_Sub2_5269).aD938
				      .method11(is_428_[i_450_], -28755))
				 .aBoolean1825)) {
			    ((Class328) class328).aShortArray2752
				[((Class328) class328).aShort2746]
				= (short) is_428_[i_450_];
			    ((Class328) class328).aShortArray2753
				[((Class328) class328).aShort2746]
				= (short) is_429_[i_450_];
			} else
			    ((Class328) class328).aShortArray2752
				[((Class328) class328).aShort2746]
				= (short) -1;
		    }
		    ((Class328) class328).aShort2746++;
		}
	    }
	    aClass328ArrayArray5261[i][i_419_] = class328;
	} else if (is_426_[0] >= 0 || is_427_ != null && is_427_[0] >= 0) {
	    Class327 class327 = new Class327();
	    int i_451_ = is_426_[0];
	    int i_452_ = is_428_[0];
	    if (is_427_ != null) {
		((Class327) class327).anInt2743
		    = (Class246_Sub7.method3132
		       ((aByteArrayArray5257[i][i_419_]
			 - aByteArrayArray5259[i][i_419_]),
			(byte) 118,
			Class111_Sub2.method2117(is_427_[0], -112)));
		if (i_451_ == -1)
		    ((Class327) class327).aByte2740 |= 0x2;
	    }
	    if ((((s) this).anIntArrayArray2201[i][i_419_]
		 == ((s) this).anIntArrayArray2201[i + 1][i_419_])
		&& (((s) this).anIntArrayArray2201[i][i_419_]
		    == ((s) this).anIntArrayArray2201[i + 1][i_419_ + 1])
		&& (((s) this).anIntArrayArray2201[i][i_419_]
		    == ((s) this).anIntArrayArray2201[i][i_419_ + 1]))
		((Class327) class327).aByte2740 |= 0x1;
	    Class238 class238 = null;
	    if (i_452_ != -1)
		class238 = ((ha) aHa_Sub2_5269).aD938.method11(i_452_, -28755);
	    if (class238 != null
		&& (((Class327) class327).aByte2740 & 0x2) == 0
		&& !((Class238) class238).aBoolean1825) {
		((Class327) class327).aShort2741
		    = (short) (aByteArrayArray5257[i][i_419_]
			       - aByteArrayArray5259[i][i_419_]);
		((Class327) class327).aShort2739
		    = (short) (aByteArrayArray5257[i + 1][i_419_]
			       - aByteArrayArray5259[i + 1][i_419_]);
		((Class327) class327).aShort2745
		    = (short) (aByteArrayArray5257[i + 1][i_419_ + 1]
			       - aByteArrayArray5259[i + 1][i_419_ + 1]);
		((Class327) class327).aShort2742
		    = (short) (aByteArrayArray5257[i][i_419_ + 1]
			       - aByteArrayArray5259[i][i_419_ + 1]);
		((Class327) class327).aShort2744 = (short) i_452_;
		if (method3441(((Class238) class238).aByte1820)
		    || ((Class238) class238).aByte1823 != 0
		    || ((Class238) class238).aByte1837 != 0)
		    ((Class327) class327).aByte2740 |= 0x4;
	    } else {
		short i_453_ = Class111_Sub2.method2117(i_451_, -105);
		((Class327) class327).aShort2741
		    = (short) Class246_Sub7.method3132(((aByteArrayArray5257[i]
							 [i_419_])
							- (aByteArrayArray5259
							   [i][i_419_])),
						       (byte) 118, i_453_);
		((Class327) class327).aShort2739
		    = (short) Class246_Sub7.method3132(((aByteArrayArray5257
							 [i + 1][i_419_])
							- (aByteArrayArray5259
							   [i + 1][i_419_])),
						       (byte) 118, i_453_);
		((Class327) class327).aShort2745
		    = (short) Class246_Sub7.method3132(((aByteArrayArray5257
							 [i + 1][i_419_ + 1])
							- (aByteArrayArray5259
							   [i + 1]
							   [i_419_ + 1])),
						       (byte) 118, i_453_);
		((Class327) class327).aShort2742
		    = (short) Class246_Sub7.method3132(((aByteArrayArray5257[i]
							 [i_419_ + 1])
							- (aByteArrayArray5259
							   [i][i_419_ + 1])),
						       (byte) 118, i_453_);
		((Class327) class327).aShort2744 = (short) -1;
	    }
	    aClass327ArrayArray5265[i][i_419_] = class327;
	}
    }
    
    final void wa(r var_r, int i, int i_454_, int i_455_, int i_456_,
		  boolean bool) {
	/* empty */
    }
    
    private final void method3444(int i, int i_457_, int i_458_, int i_459_,
				  int i_460_, int i_461_, int i_462_,
				  boolean[][] bools, Class235 class235,
				  Class12 class12, int[] is, int[] is_463_) {
	int i_464_ = (i_462_ - i_460_) * i_458_ / 256;
	int i_465_ = i_458_ >> 8;
	boolean bool = ((Class235) class235).aBoolean1762;
	aHa_Sub2_5269.C(false);
	((Class12) class12).aBoolean134 = false;
	((Class12) class12).aBoolean130 = false;
	int i_466_ = i;
	int i_467_ = i_457_ + i_464_;
	for (int i_468_ = i_459_; i_468_ < i_461_; i_468_++) {
	    for (int i_469_ = i_460_; i_469_ < i_462_; i_469_++) {
		if (bools[i_468_ - i_459_][i_469_ - i_460_]) {
		    if (aClass193ArrayArray5272 != null) {
			if (aClass193ArrayArray5272[i_468_][i_469_] != null) {
			    Class193 class193
				= aClass193ArrayArray5272[i_468_][i_469_];
			    if (((Class193) class193).aShort1487 != -1
				&& (((Class193) class193).aByte1492 & 0x2) == 0
				&& ((Class193) class193).anInt1494 == 0) {
				int i_470_
				    = aHa_Sub2_5269.method1926(((Class193)
								class193)
							       .aShort1487);
				class12.method216
				    ((float) (i_467_ - i_465_),
				     (float) (i_467_ - i_465_), (float) i_467_,
				     (float) (i_466_ + i_465_), (float) i_466_,
				     (float) (i_466_ + i_465_), 100.0F, 100.0F,
				     100.0F,
				     (float) (Class246_Sub7.method3132
					      (((Class193) class193).anInt1493,
					       (byte) 118, i_470_)),
				     (float) (Class246_Sub7.method3132
					      (((Class193) class193).anInt1484,
					       (byte) 118, i_470_)),
				     (float) (Class246_Sub7.method3132
					      (((Class193) class193).anInt1491,
					       (byte) 118, i_470_)));
				class12.method216
				    ((float) i_467_, (float) i_467_,
				     (float) (i_467_ - i_465_), (float) i_466_,
				     (float) (i_466_ + i_465_), (float) i_466_,
				     100.0F, 100.0F, 100.0F,
				     (float) (Class246_Sub7.method3132
					      (((Class193) class193).anInt1490,
					       (byte) 118, i_470_)),
				     (float) (Class246_Sub7.method3132
					      (((Class193) class193).anInt1491,
					       (byte) 118, i_470_)),
				     (float) (Class246_Sub7.method3132
					      (((Class193) class193).anInt1484,
					       (byte) 118, i_470_)));
			    } else if (((Class193) class193).anInt1494 == 0) {
				class12.method206
				    ((float) (i_467_ - i_465_),
				     (float) (i_467_ - i_465_), (float) i_467_,
				     (float) (i_466_ + i_465_), (float) i_466_,
				     (float) (i_466_ + i_465_), 100.0F, 100.0F,
				     100.0F, ((Class193) class193).anInt1493,
				     ((Class193) class193).anInt1484,
				     ((Class193) class193).anInt1491);
				class12.method206
				    ((float) i_467_, (float) i_467_,
				     (float) (i_467_ - i_465_), (float) i_466_,
				     (float) (i_466_ + i_465_), (float) i_466_,
				     100.0F, 100.0F, 100.0F,
				     ((Class193) class193).anInt1490,
				     ((Class193) class193).anInt1491,
				     ((Class193) class193).anInt1484);
			    } else {
				int i_471_ = ((Class193) class193).anInt1494;
				class12.method206
				    ((float) (i_467_ - i_465_),
				     (float) (i_467_ - i_465_), (float) i_467_,
				     (float) (i_466_ + i_465_), (float) i_466_,
				     (float) (i_466_ + i_465_), 100.0F, 100.0F,
				     100.0F,
				     (Class98_Sub46_Sub5.method1544
				      ((((Class193) class193).anInt1493
					& ~0xffffff),
				       (byte) 105, i_471_)),
				     (Class98_Sub46_Sub5.method1544
				      ((((Class193) class193).anInt1484
					& ~0xffffff),
				       (byte) 120, i_471_)),
				     (Class98_Sub46_Sub5.method1544
				      ((((Class193) class193).anInt1491
					& ~0xffffff),
				       (byte) 120, i_471_)));
				class12.method206
				    ((float) i_467_, (float) i_467_,
				     (float) (i_467_ - i_465_), (float) i_466_,
				     (float) (i_466_ + i_465_), (float) i_466_,
				     100.0F, 100.0F, 100.0F,
				     (Class98_Sub46_Sub5.method1544
				      ((((Class193) class193).anInt1490
					& ~0xffffff),
				       (byte) 117, i_471_)),
				     (Class98_Sub46_Sub5.method1544
				      ((((Class193) class193).anInt1491
					& ~0xffffff),
				       (byte) 115, i_471_)),
				     (Class98_Sub46_Sub5.method1544
				      ((((Class193) class193).anInt1484
					& ~0xffffff),
				       (byte) 113, i_471_)));
			    }
			} else if (aClass285ArrayArray5258[i_468_][i_469_]
				   != null) {
			    Class285 class285
				= aClass285ArrayArray5258[i_468_][i_469_];
			    for (int i_472_ = 0;
				 i_472_ < ((Class285) class285).aShort2174;
				 i_472_++) {
				is[i_472_]
				    = i_466_ + ((((Class285) class285)
						 .aShortArray2176[i_472_])
						* i_465_
						/ ((s) this).anInt2206);
				is_463_[i_472_]
				    = i_467_ - ((((Class285) class285)
						 .aShortArray2170[i_472_])
						* i_465_
						/ ((s) this).anInt2206);
			    }
			    for (int i_473_ = 0;
				 i_473_ < ((Class285) class285).aShort2171;
				 i_473_++) {
				int i_474_ = i_473_ * 3;
				int i_475_ = i_474_ + 1;
				int i_476_ = i_475_ + 1;
				int i_477_ = is[i_474_];
				int i_478_ = is[i_475_];
				int i_479_ = is[i_476_];
				int i_480_ = is_463_[i_474_];
				int i_481_ = is_463_[i_475_];
				int i_482_ = is_463_[i_476_];
				if ((((Class285) class285).anIntArray2175
				     != null)
				    && (((Class285) class285).anIntArray2175
					[i_473_]) != 0
				    && ((((Class285) class285).aShortArray2169
					 == null)
					|| ((((Class285) class285)
					     .aShortArray2169) != null
					    && ((((Class285) class285)
						 .aShortArray2169[i_473_])
						== -1)))) {
				    int i_483_ = (((Class285) class285)
						  .anIntArray2175[i_473_]);
				    class12.method206
					((float) i_480_, (float) i_481_,
					 (float) i_482_, (float) i_477_,
					 (float) i_478_, (float) i_479_,
					 100.0F, 100.0F, 100.0F,
					 (Class98_Sub46_Sub5.method1544
					  (-16777216 - ((((Class285) class285)
							 .anIntArray2173
							 [i_474_])
							& ~0xffffff),
					   (byte) 125, i_483_)),
					 (Class98_Sub46_Sub5.method1544
					  (-16777216 - ((((Class285) class285)
							 .anIntArray2173
							 [i_475_])
							& ~0xffffff),
					   (byte) 124, i_483_)),
					 (Class98_Sub46_Sub5.method1544
					  (-16777216 - ((((Class285) class285)
							 .anIntArray2173
							 [i_476_])
							& ~0xffffff),
					   (byte) 111, i_483_)));
				} else if ((((Class285) class285)
					    .aShortArray2169) != null
					   && ((((Class285) class285)
						.aShortArray2169[i_473_])
					       != -1)) {
				    int i_484_ = (aHa_Sub2_5269.method1926
						  (((Class285) class285)
						   .aShortArray2169[i_473_]));
				    class12.method216((float) i_480_,
						      (float) i_481_,
						      (float) i_482_,
						      (float) i_477_,
						      (float) i_478_,
						      (float) i_479_, 100.0F,
						      100.0F, 100.0F,
						      (float) i_484_,
						      (float) i_484_,
						      (float) i_484_);
				} else
				    class12.method206
					((float) i_480_, (float) i_481_,
					 (float) i_482_, (float) i_477_,
					 (float) i_478_, (float) i_479_,
					 100.0F, 100.0F, 100.0F,
					 (((Class285) class285).anIntArray2173
					  [i_474_]),
					 (((Class285) class285).anIntArray2173
					  [i_475_]),
					 (((Class285) class285).anIntArray2173
					  [i_476_]));
			    }
			}
		    } else if (aClass120ArrayArray5266[i_468_][i_469_]
			       != null) {
			Class120 class120
			    = aClass120ArrayArray5266[i_468_][i_469_];
			for (int i_485_ = 0;
			     i_485_ < ((Class120) class120).aShort994;
			     i_485_++) {
			    is[i_485_]
				= i_466_ + ((((Class120) class120)
					     .aShortArray995[i_485_])
					    * i_465_ / ((s) this).anInt2206);
			    is_463_[i_485_]
				= i_467_ - ((((Class120) class120)
					     .aShortArray992[i_485_])
					    * i_465_ / ((s) this).anInt2206);
			}
			for (int i_486_ = 0;
			     i_486_ < ((Class120) class120).aShort991;
			     i_486_++) {
			    int i_487_ = i_486_ * 3;
			    int i_488_ = i_487_ + 1;
			    int i_489_ = i_488_ + 1;
			    int i_490_ = is[i_487_];
			    int i_491_ = is[i_488_];
			    int i_492_ = is[i_489_];
			    int i_493_ = is_463_[i_487_];
			    int i_494_ = is_463_[i_488_];
			    int i_495_ = is_463_[i_489_];
			    if (((Class120) class120).anIntArray997 != null
				&& (((Class120) class120).anIntArray997[i_486_]
				    != 0)) {
				int i_496_ = (((Class120) class120)
					      .anIntArray997[i_486_]);
				class12.method206((float) i_493_,
						  (float) i_494_,
						  (float) i_495_,
						  (float) i_490_,
						  (float) i_491_,
						  (float) i_492_, 100.0F,
						  100.0F, 100.0F, i_496_,
						  i_496_, i_496_);
			    } else
				class12.method206((float) i_493_,
						  (float) i_494_,
						  (float) i_495_,
						  (float) i_490_,
						  (float) i_491_,
						  (float) i_492_, 100.0F,
						  100.0F, 100.0F,
						  (((Class120) class120)
						   .anIntArray999[i_487_]),
						  (((Class120) class120)
						   .anIntArray999[i_488_]),
						  (((Class120) class120)
						   .anIntArray999[i_489_]));
			}
		    }
		}
		i_467_ -= i_465_;
	    }
	    i_467_ = i_457_ + i_464_;
	    i_466_ += i_465_;
	}
	((Class12) class12).aBoolean134 = true;
	aHa_Sub2_5269.C(bool);
    }
    
    final void CA(r var_r, int i, int i_497_, int i_498_, int i_499_,
		  boolean bool) {
	/* empty */
    }
}
