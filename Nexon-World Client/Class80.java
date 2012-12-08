/* Class80 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import jaclib.memory.Buffer;
import jaclib.memory.Source;

import jagdx.IDirect3DVertexBuffer;
import jagdx.kg;

final class Class80 implements Interface2_Impl1
{
    IDirect3DVertexBuffer anIDirect3DVertexBuffer5337;
    private byte aByte5338;
    private int anInt5339;
    private boolean aBoolean5340;
    private int anInt5341;
    private ha_Sub3_Sub1 aHa_Sub3_Sub1_5342;
    private boolean aBoolean5343 = false;
    
    final int method810(byte i) {
	byte i_0_;
	try {
	    if (i != -22)
		method810((byte) -72);
	    i_0_ = aByte5338;
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
	return i_0_;
    }
    
    public final boolean method73(byte i, int i_1_, int i_2_, Source source) {
	boolean bool;
	try {
	    if (method74(-20279, i_2_, i_1_))
		return (((Class80) this).anIDirect3DVertexBuffer5337.a
			(source, 0, 0, anInt5339, !aBoolean5340 ? 0 : 8192));
	    if (i >= -79)
		return false;
	    bool = false;
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
	return bool;
    }
    
    public final boolean method74(int i, int i_3_, int i_4_) {
	boolean bool;
	try {
	    anInt5339 = i_4_;
	    if (i != -20279)
		method73((byte) 73, 31, -108, null);
	    aByte5338 = (byte) i_3_;
	    if (anInt5341 < anInt5339) {
		int i_5_ = 8;
		int i_6_;
		if (aBoolean5340) {
		    i_6_ = 0;
		    i_5_ |= 0x200;
		} else
		    i_6_ = 1;
		if (null != ((Class80) this).anIDirect3DVertexBuffer5337)
		    ((Class80) this).anIDirect3DVertexBuffer5337.b(119);
		((Class80) this).anIDirect3DVertexBuffer5337
		    = (((ha_Sub3_Sub1) aHa_Sub3_Sub1_5342)
			   .anIDirect3DDevice6098.a
		       (anInt5339, i_5_, 0, i_6_,
			((Class80) this).anIDirect3DVertexBuffer5337));
		anInt5341 = anInt5339;
	    }
	    if (null != ((Class80) this).anIDirect3DVertexBuffer5337)
		return true;
	    bool = false;
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
	return bool;
    }
    
    public final Buffer method75(boolean bool, byte i) {
	Buffer buffer;
	try {
	    if (null == ((Class80) this).anIDirect3DVertexBuffer5337)
		return null;
	    if (i != 27)
		method74(118, -74, 74);
	    bool &= aBoolean5340;
	    if (!aBoolean5343
		&& kg.a(-21593,
			(((Class80) this).anIDirect3DVertexBuffer5337.Lock
			 (0, anInt5341, bool ? 8192 : 0,
			  (((ha_Sub3_Sub1) aHa_Sub3_Sub1_5342)
			   .aGeometryBuffer6086))))) {
		aBoolean5343 = true;
		return ((ha_Sub3_Sub1) aHa_Sub3_Sub1_5342).aGeometryBuffer6086;
	    }
	    buffer = null;
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
	return buffer;
    }
    
    public final int method2(int i) {
	int i_7_;
	try {
	    if (i != 200)
		method2(44);
	    i_7_ = anInt5339;
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
	return i_7_;
    }
    
    public final boolean method71(int i) {
	boolean bool;
	try {
	    if (aBoolean5343
		&& kg.a(-21593, ((Class80) this)
				    .anIDirect3DVertexBuffer5337.Unlock())) {
		aBoolean5343 = false;
		return true;
	    }
	    if (i != 13623)
		aHa_Sub3_Sub1_5342 = null;
	    bool = false;
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
	return bool;
    }
    
    public final void method72(boolean bool) {
	try {
	    if (bool)
		method74(-75, -93, 67);
	    if (null != ((Class80) this).anIDirect3DVertexBuffer5337) {
		((Class80) this).anIDirect3DVertexBuffer5337.b(112);
		((Class80) this).anIDirect3DVertexBuffer5337 = null;
	    }
	    anInt5339 = 0;
	    anInt5341 = 0;
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    Class80(ha_Sub3_Sub1 var_ha_Sub3_Sub1, boolean bool) {
	try {
	    aBoolean5340 = bool;
	    aHa_Sub3_Sub1_5342 = var_ha_Sub3_Sub1;
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
}
