/* Class98_Sub46_Sub13 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

abstract class Class98_Sub46_Sub13 extends Class98_Sub46
{
    boolean aBoolean6036;
    boolean aBoolean6037;
    volatile boolean aBoolean6038 = true;
    
    abstract int method1590(int i);
    
    abstract byte[] method1591(int i);
    
    static final void method1592(int i, int i_0_, int i_1_, int i_2_, int i_3_,
				 int i_4_) {
	try {
	    Class98_Sub4.anInt3828 = i_3_;
	    Class98_Sub15.anInt3915 = i_4_;
	    if (i == -25686) {
		Class98_Sub41.anInt4202 = i_0_;
		Class303.anInt2530 = i_2_;
		Exception_Sub1.anInt44 = i_1_;
		if (Class98_Sub4.anInt3828 >= 100) {
		    int i_5_ = 256 + Exception_Sub1.anInt44 * 512;
		    int i_6_ = Class98_Sub15.anInt3915 * 512 + 256;
		    int i_7_
			= (Class98_Sub46_Sub2_Sub2
			       .method1538(Class43.anInt377, i_6_, i_5_, 24111)
			   + -Class303.anInt2530);
		    int i_8_ = i_5_ + -Class98_Sub46_Sub10.anInt6020;
		    int i_9_ = -Class79.anInt601 + i_7_;
		    int i_10_ = -Class134.anInt3461 + i_6_;
		    int i_11_ = (int) Math.sqrt((double) (i_8_ * i_8_
							  + i_10_ * i_10_));
		    Class246_Sub3_Sub4_Sub2.anInt6357
			= 0x3fff & (int) (2607.5945876176133
					  * Math.atan2((double) i_9_,
						       (double) i_11_));
		    Class186.anInt3424
			= 0x3fff & (int) (Math.atan2((double) i_8_,
						     (double) i_10_)
					  * -2607.5945876176133);
		    Class308.anInt2584 = 0;
		    if ((Class246_Sub3_Sub4_Sub2.anInt6357 ^ 0xffffffff)
			> -1025)
			Class246_Sub3_Sub4_Sub2.anInt6357 = 1024;
		    if ((Class246_Sub3_Sub4_Sub2.anInt6357 ^ 0xffffffff)
			< -3073)
			Class246_Sub3_Sub4_Sub2.anInt6357 = 3072;
		}
		Class98_Sub46_Sub20_Sub2.anInt6319 = 2;
		Class116.anInt967 = Class64_Sub26.anInt3712 = -1;
	    }
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  ("hia.M(" + i + ',' + i_0_ + ','
					   + i_1_ + ',' + i_2_ + ',' + i_3_
					   + ',' + i_4_ + ')'));
	}
    }
    
    public Class98_Sub46_Sub13() {
	/* empty */
    }
}
