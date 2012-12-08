/* Class98_Sub24_Sub1 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class Class98_Sub24_Sub1 extends Class98_Sub24
{
    int anInt5795;
    int anInt5796;
    boolean aBoolean5797;
    int anInt5798;
    byte[] aByteArray5799;
    
    final Class98_Sub24_Sub1 method1269(Class314 class314) {
	((Class98_Sub24_Sub1) this).aByteArray5799
	    = class314.method3642(true,
				  ((Class98_Sub24_Sub1) this).aByteArray5799);
	((Class98_Sub24_Sub1) this).anInt5795
	    = class314.method3643(((Class98_Sub24_Sub1) this).anInt5795, 1);
	if (((Class98_Sub24_Sub1) this).anInt5798
	    == ((Class98_Sub24_Sub1) this).anInt5796)
	    ((Class98_Sub24_Sub1) this).anInt5798
		= ((Class98_Sub24_Sub1) this).anInt5796
		= class314.method3638(6,
				      ((Class98_Sub24_Sub1) this).anInt5798);
	else {
	    ((Class98_Sub24_Sub1) this).anInt5798
		= class314.method3638(6,
				      ((Class98_Sub24_Sub1) this).anInt5798);
	    ((Class98_Sub24_Sub1) this).anInt5796
		= class314.method3638(6,
				      ((Class98_Sub24_Sub1) this).anInt5796);
	    if (((Class98_Sub24_Sub1) this).anInt5798
		== ((Class98_Sub24_Sub1) this).anInt5796)
		((Class98_Sub24_Sub1) this).anInt5798--;
	}
	return this;
    }
    
    Class98_Sub24_Sub1(int i, byte[] is, int i_0_, int i_1_) {
	((Class98_Sub24_Sub1) this).anInt5795 = i;
	((Class98_Sub24_Sub1) this).aByteArray5799 = is;
	((Class98_Sub24_Sub1) this).anInt5798 = i_0_;
	((Class98_Sub24_Sub1) this).anInt5796 = i_1_;
    }
    
    Class98_Sub24_Sub1(int i, byte[] is, int i_2_, int i_3_, boolean bool) {
	((Class98_Sub24_Sub1) this).anInt5795 = i;
	((Class98_Sub24_Sub1) this).aByteArray5799 = is;
	((Class98_Sub24_Sub1) this).anInt5798 = i_2_;
	((Class98_Sub24_Sub1) this).anInt5796 = i_3_;
	((Class98_Sub24_Sub1) this).aBoolean5797 = bool;
    }
}
