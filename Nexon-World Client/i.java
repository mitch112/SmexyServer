/* i - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class i extends Class146 implements Interface9
{
    private ya aYa3292;
    private oa anOa3293;
    Class87[] aClass87Array3294;
    long nativeid;
    Class35[] aClass35Array3295;
    
    private final native void l(long l, int i, int[] is, int i_0_, int i_1_,
				int i_2_, int i_3_, boolean bool);
    
    final native void ia(short i, short i_4_);
    
    final boolean method2333(int i, int i_5_, Class111 class111, boolean bool,
			     int i_6_, int i_7_) {
	return anOa3293.method1930().method147(this, i, i_5_, class111, bool,
					       i_7_);
    }
    
    final native void a(int i);
    
    private final void method2376(int[] is, Class111 class111) {
	anOa3293.method1930().method143(this, is, class111);
    }
    
    final native void ZA(i var_i_8_, i var_i_9_, int i, boolean bool,
			 boolean bool_10_);
    
    private final native void oa(oa var_oa);
    
    final Class35[] method2322() {
	return ((i) this).aClass35Array3295;
    }
    
    final native void s(int i);
    
    final native int RA();
    
    final native boolean r();
    
    final native int V();
    
    final boolean method2339(int i, int i_11_, Class111 class111, boolean bool,
			     int i_12_) {
	return anOa3293.method1930().method150(this, i, i_11_, class111, bool);
    }
    
    final native void LA(int i);
    
    final void method2331(Class111 class111, int i, boolean bool) {
	A(((ja) (ja) class111).nativeid, i, bool);
    }
    
    final native int G();
    
    private final native void A(long l, int i, boolean bool);
    
    final native void aa(short i, short i_13_);
    
    final native int ma();
    
    final native int da();
    
    final native void p(int i, int i_14_, s var_s, s var_s_15_, int i_16_,
			int i_17_, int i_18_);
    
    final native r ba(r var_r);
    
    final native void VA(int i);
    
    final void method2343(Class111 class111) {
	method2376(oa.anIntArray3306, class111);
	int i = 0;
	if (((i) this).aClass87Array3294 != null) {
	    for (int i_19_ = 0; i_19_ < ((i) this).aClass87Array3294.length;
		 i_19_++) {
		Class87 class87 = ((i) this).aClass87Array3294[i_19_];
		((Class87) class87).anInt670 = oa.anIntArray3306[i++];
		((Class87) class87).anInt668 = oa.anIntArray3306[i++];
		((Class87) class87).anInt671 = oa.anIntArray3306[i++];
		((Class87) class87).anInt663 = oa.anIntArray3306[i++];
		((Class87) class87).anInt664 = oa.anIntArray3306[i++];
		((Class87) class87).anInt656 = oa.anIntArray3306[i++];
		((Class87) class87).anInt659 = oa.anIntArray3306[i++];
		((Class87) class87).anInt669 = oa.anIntArray3306[i++];
		((Class87) class87).anInt662 = oa.anIntArray3306[i++];
	    }
	}
	if (((i) this).aClass35Array3295 != null) {
	    for (int i_20_ = 0; i_20_ < ((i) this).aClass35Array3295.length;
		 i_20_++) {
		Class35 class35 = ((i) this).aClass35Array3295[i_20_];
		Class35 class35_21_ = class35;
		if (((Class35) class35).aClass35_328 != null)
		    class35_21_ = ((Class35) class35).aClass35_328;
		if (((Class35) class35).aClass111_334 != null)
		    ((Class35) class35).aClass111_334.method2092(class111);
		else
		    ((Class35) class35).aClass111_334 = class111.method2102();
		((Class35) class35_21_).anInt331 = oa.anIntArray3306[i++];
		((Class35) class35_21_).anInt330 = oa.anIntArray3306[i++];
		((Class35) class35_21_).anInt337 = oa.anIntArray3306[i++];
	    }
	}
    }
    
    public final native void w(boolean bool);
    
    final Class87[] method2320() {
	return ((i) this).aClass87Array3294;
    }
    
    final native boolean F();
    
    final native boolean NA();
    
    final native void wa();
    
    final native void I(int i, int[] is, int i_22_, int i_23_, int i_24_,
			boolean bool, int i_25_, int[] is_26_);
    
    final void method2342() {
	if (((oa) anOa3293).anInt3316 > 1) {
	    synchronized (this) {
		while (((Class146) this).aBoolean1181) {
		    try {
			this.wait();
		    } catch (InterruptedException interruptedexception) {
			/* empty */
		    }
		}
		((Class146) this).aBoolean1181 = true;
	    }
	}
    }
    
    final native int EA();
    
    final native int ua();
    
    final boolean method2324() {
	return true;
    }
    
    protected final void finalize() {
	if (((i) this).nativeid != 0L)
	    Class192.method2654(false, this);
    }
    
    final native void O(int i, int i_27_, int i_28_);
    
    final native void v();
    
    final native void FA(int i);
    
    final void method2325(Class111 class111, Class246_Sub6 class246_sub6,
			  int i) {
	if (class246_sub6 == null)
	    anOa3293.method1930().method149(this, class111, null, i);
	else {
	    oa.anIntArray3313[5] = 0;
	    anOa3293.method1930().method149(this, class111, oa.anIntArray3313,
					    i);
	    ((Class246_Sub6) class246_sub6).anInt5111 = oa.anIntArray3313[0];
	    ((Class246_Sub6) class246_sub6).anInt5113 = oa.anIntArray3313[1];
	    ((Class246_Sub6) class246_sub6).anInt5110 = oa.anIntArray3313[2];
	    ((Class246_Sub6) class246_sub6).anInt5112 = oa.anIntArray3313[3];
	    ((Class246_Sub6) class246_sub6).anInt5109 = oa.anIntArray3313[4];
	    ((Class246_Sub6) class246_sub6).aBoolean5114
		= oa.anIntArray3313[5] != 0;
	}
    }
    
    final native void C(int i);
    
    final void method2332(Class146 class146, int i, int i_29_, int i_30_,
			  boolean bool) {
	anOa3293.method1930().method140(this, class146, i, i_29_, i_30_, bool);
    }
    
    final void method2337(int i, int i_31_, int i_32_, int i_33_) {
	/* empty */
    }
    
    final native int fa();
    
    final native void P(int i, int i_34_, int i_35_, int i_36_);
    
    final native void k(int i);
    
    final native void H(int i, int i_37_, int i_38_);
    
    final native int WA();
    
    final void method2344(int i, int[] is, int i_39_, int i_40_, int i_41_,
			  int i_42_, boolean bool) {
	l(((i) this).nativeid, i, is, i_39_, i_40_, i_41_, i_42_, bool);
    }
    
    final void method2326() {
	/* empty */
    }
    
    final Class146 method2341(byte i, int i_43_, boolean bool) {
	return anOa3293.method1930().method137(this, i, i_43_, bool);
    }
    
    final void method2327() {
	if (((oa) anOa3293).anInt3316 > 1) {
	    synchronized (this) {
		((Class146) this).aBoolean1181 = false;
		this.notifyAll();
	    }
	}
    }
    
    final void method2329(Class111 class111, Class246_Sub6 class246_sub6,
			  int i, int i_44_) {
	if (class246_sub6 == null)
	    anOa3293.method1930().method146(this, class111, null, i, i_44_);
	else {
	    oa.anIntArray3313[5] = 0;
	    anOa3293.method1930().method146(this, class111, oa.anIntArray3313,
					    i, i_44_);
	    ((Class246_Sub6) class246_sub6).anInt5111 = oa.anIntArray3313[0];
	    ((Class246_Sub6) class246_sub6).anInt5113 = oa.anIntArray3313[1];
	    ((Class246_Sub6) class246_sub6).anInt5110 = oa.anIntArray3313[2];
	    ((Class246_Sub6) class246_sub6).anInt5112 = oa.anIntArray3313[3];
	    ((Class246_Sub6) class246_sub6).anInt5109 = oa.anIntArray3313[4];
	    ((Class246_Sub6) class246_sub6).aBoolean5114
		= oa.anIntArray3313[5] != 0;
	}
    }
    
    private final native void R
	(oa var_oa, ya var_ya, int i, int i_45_, int[] is, int[] is_46_,
	 int[] is_47_, int[] is_48_, short[] is_49_, int i_50_, short[] is_51_,
	 short[] is_52_, short[] is_53_, byte[] is_54_, byte[] is_55_,
	 byte[] is_56_, byte[] is_57_, short[] is_58_, short[] is_59_,
	 int[] is_60_, byte i_61_, short[] is_62_, int i_63_, byte[] is_64_,
	 short[] is_65_, short[] is_66_, short[] is_67_, int[] is_68_,
	 int[] is_69_, int[] is_70_, byte[] is_71_, byte[] is_72_,
	 int[] is_73_, int[] is_74_, int[] is_75_, int[] is_76_, int i_77_,
	 int i_78_, int i_79_, int i_80_, int i_81_, int i_82_, int[] is_83_);
    
    final native int na();
    
    i(oa var_oa, ya var_ya, Class178 class178, int i, int i_84_, int i_85_,
      int i_86_) {
	anOa3293 = var_oa;
	aYa3292 = var_ya;
	((i) this).aClass87Array3294 = ((Class178) class178).aClass87Array1413;
	((i) this).aClass35Array3295 = ((Class178) class178).aClass35Array1398;
	int i_87_ = (((Class178) class178).aClass87Array1413 == null ? 0
		     : ((Class178) class178).aClass87Array1413.length);
	int i_88_ = (((Class178) class178).aClass35Array1398 == null ? 0
		     : ((Class178) class178).aClass35Array1398.length);
	int i_89_ = 0;
	int[] is = new int[i_87_ * 3 + i_88_];
	for (int i_90_ = 0; i_90_ < i_87_; i_90_++) {
	    is[i_89_++]
		= ((Class87) ((i) this).aClass87Array3294[i_90_]).anInt666;
	    is[i_89_++]
		= ((Class87) ((i) this).aClass87Array3294[i_90_]).anInt661;
	    is[i_89_++]
		= ((Class87) ((i) this).aClass87Array3294[i_90_]).anInt674;
	}
	for (int i_91_ = 0; i_91_ < i_88_; i_91_++)
	    is[i_89_++]
		= ((Class35) ((i) this).aClass35Array3295[i_91_]).anInt327;
	int i_92_ = (((Class178) class178).aClass106Array1419 == null ? 0
		     : ((Class178) class178).aClass106Array1419.length);
	int[] is_93_ = new int[i_92_ * 8];
	int i_94_ = 0;
	for (int i_95_ = 0; i_95_ < i_92_; i_95_++) {
	    Class106 class106
		= ((Class178) class178).aClass106Array1419[i_95_];
	    Class177 class177
		= Class67.method689(((Class106) class106).anInt905,
				    (byte) -119);
	    is_93_[i_94_++] = ((Class106) class106).anInt906;
	    is_93_[i_94_++] = ((Class177) class177).anInt1374;
	    is_93_[i_94_++] = ((Class177) class177).anInt1380;
	    is_93_[i_94_++] = ((Class177) class177).anInt1373;
	    is_93_[i_94_++] = ((Class177) class177).anInt1384;
	    is_93_[i_94_++] = ((Class177) class177).anInt1379;
	    is_93_[i_94_++] = ((Class177) class177).aBoolean1377 ? -1 : 0;
	}
	for (int i_96_ = 0; i_96_ < i_92_; i_96_++) {
	    Class106 class106
		= ((Class178) class178).aClass106Array1419[i_96_];
	    is_93_[i_94_++] = ((Class106) class106).anInt908;
	}
	R(anOa3293, aYa3292, ((Class178) class178).anInt1407,
	  ((Class178) class178).anInt1406,
	  ((Class178) class178).anIntArray1416,
	  ((Class178) class178).anIntArray1400,
	  ((Class178) class178).anIntArray1418,
	  ((Class178) class178).anIntArray1417,
	  ((Class178) class178).aShortArray1408,
	  ((Class178) class178).anInt1391,
	  ((Class178) class178).aShortArray1393,
	  ((Class178) class178).aShortArray1410,
	  ((Class178) class178).aShortArray1392,
	  ((Class178) class178).aByteArray1414,
	  ((Class178) class178).aByteArray1402,
	  ((Class178) class178).aByteArray1411,
	  ((Class178) class178).aByteArray1420,
	  ((Class178) class178).aShortArray1415,
	  ((Class178) class178).aShortArray1409,
	  ((Class178) class178).anIntArray1395,
	  ((Class178) class178).aByte1422,
	  ((Class178) class178).aShortArray1394,
	  ((Class178) class178).anInt1396,
	  ((Class178) class178).aByteArray1388,
	  ((Class178) class178).aShortArray1403,
	  ((Class178) class178).aShortArray1421,
	  ((Class178) class178).aShortArray1385,
	  ((Class178) class178).anIntArray1389,
	  ((Class178) class178).anIntArray1404,
	  ((Class178) class178).anIntArray1390,
	  ((Class178) class178).aByteArray1423,
	  ((Class178) class178).aByteArray1399,
	  ((Class178) class178).anIntArray1412,
	  ((Class178) class178).anIntArray1397,
	  ((Class178) class178).anIntArray1386, is, i_87_, i_88_, i, i_84_,
	  i_85_, i_86_, is_93_);
    }
    
    final native int HA();
    
    i(oa var_oa) {
	anOa3293 = var_oa;
	aYa3292 = null;
	oa(var_oa);
    }
}
