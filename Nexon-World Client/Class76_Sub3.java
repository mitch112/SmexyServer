/* Class76_Sub3 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import jagdx.IDirect3DDevice;
import jagdx.IDirect3DVertexShader;

final class Class76_Sub3 extends Class76
{
    private IDirect3DVertexShader anIDirect3DVertexShader3734;
    private Class195 aClass195_3735;
    private static float[] aFloatArray3736 = new float[16];
    private ha_Sub3_Sub1 aHa_Sub3_Sub1_3737;
    
    final void method743(int i, boolean bool) {
	do {
	    try {
		((Class76_Sub3) this).aHa_Sub3_585.method2019
		    (Class1.aClass128_64, Class323.aClass128_2715, 22831);
		if (i > 93)
		    break;
		aClass195_3735 = null;
	    } catch (RuntimeException runtimeexception) {
		throw runtimeexception;
	    }
	    break;
	} while (false);
    }
    
    final void method741(byte i) {
	try {
	    if (null != anIDirect3DVertexShader3734) {
		IDirect3DDevice idirect3ddevice
		    = (((ha_Sub3_Sub1) aHa_Sub3_Sub1_3737)
		       .anIDirect3DDevice6098);
		Class111_Sub3 class111_sub3 = aHa_Sub3_Sub1_3737.method2027(0);
		idirect3ddevice
		    .a(0, class111_sub3.method2128(127, aFloatArray3736));
	    }
	    int i_0_ = -90 / ((i - -63) / 38);
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    final void method742(int i, int i_1_, Interface4 interface4) {
	do {
	    try {
		if (i == 6)
		    break;
		aClass195_3735 = null;
	    } catch (RuntimeException runtimeexception) {
		throw runtimeexception;
	    }
	    break;
	} while (false);
    }
    
    final void method746(int i, int i_2_, int i_3_) {
	try {
	    if (i_3_ <= -75) {
		IDirect3DDevice idirect3ddevice
		    = (((ha_Sub3_Sub1) aHa_Sub3_Sub1_3737)
		       .anIDirect3DDevice6098);
		if (!((Class195) aClass195_3735).aBoolean1501) {
		    int i_4_ = ((((ha_Sub3) ((Class76_Sub3) this).aHa_Sub3_585)
				 .anInt4556)
				% 4000 * 16 / 4000);
		    ((Class76_Sub3) this).aHa_Sub3_585.method2005
			((((Class195) aClass195_3735)
			  .anInterface4_Impl2Array1503[i_4_]),
			 17);
		    idirect3ddevice.b(11, 0.0F, 0.0F, 0.0F, 0.0F);
		} else {
		    float f = ((float) (((ha_Sub3) (((Class76_Sub3) this)
						    .aHa_Sub3_585)).anInt4556
					% 4000)
			       / 4000.0F);
		    ((Class76_Sub3) this).aHa_Sub3_585.method2005
			(((Class195) aClass195_3735).anInterface4_Impl1_1498,
			 22);
		    idirect3ddevice.b(11, f, 0.0F, 0.0F, 0.0F);
		}
	    }
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    final void method740(int i) {
	do {
	    try {
		if (i >= -49)
		    method742(61, 19, null);
		if (null == anIDirect3DVertexShader3734)
		    break;
		IDirect3DDevice idirect3ddevice
		    = (((ha_Sub3_Sub1) aHa_Sub3_Sub1_3737)
		       .anIDirect3DDevice6098);
		idirect3ddevice.a(4, ((Class76_Sub3) this).aHa_Sub3_585
					 .method2040(aFloatArray3736, 32227));
	    } catch (RuntimeException runtimeexception) {
		throw runtimeexception;
	    }
	    break;
	} while (false);
    }
    
    final void method738(int i) {
	do {
	    try {
		if (i < -45) {
		    if (null == anIDirect3DVertexShader3734)
			break;
		    IDirect3DDevice idirect3ddevice
			= (((ha_Sub3_Sub1) aHa_Sub3_Sub1_3737)
			   .anIDirect3DDevice6098);
		    if (((((ha_Sub3) ((Class76_Sub3) this).aHa_Sub3_585)
			  .anInt4581)
			 ^ 0xffffffff)
			>= -1)
			idirect3ddevice.b(10, 0.0F, 0.0F, 0.0F, 0.0F);
		    else {
			float f
			    = (((ha_Sub3) ((Class76_Sub3) this).aHa_Sub3_585)
			       .aFloat4592);
			float f_5_
			    = (((ha_Sub3) ((Class76_Sub3) this).aHa_Sub3_585)
			       .aFloat4615);
			float f_6_ = f_5_ - 512.0F;
			idirect3ddevice.b(10, f_6_, 1.0F / (f_5_ - f_6_), f_5_,
					  1.0F / (-f_5_ + f));
		    }
		    ((Class76_Sub3) this).aHa_Sub3_585.method1984
			(2, (((ha_Sub3) ((Class76_Sub3) this).aHa_Sub3_585)
			     .anInt4636));
		}
	    } catch (RuntimeException runtimeexception) {
		throw runtimeexception;
	    }
	    break;
	} while (false);
    }
    
    final void method739(int i) {
	try {
	    aHa_Sub3_Sub1_3737.method2070(null, true);
	    ((Class76_Sub3) this).aHa_Sub3_585
		.method2051(0, -56, Class300.aClass65_2499);
	    ((Class76_Sub3) this).aHa_Sub3_585
		.method2051(1, -113, Class98_Sub43_Sub3.aClass65_5926);
	    if (i != -2)
		anIDirect3DVertexShader3734 = null;
	    ((Class76_Sub3) this).aHa_Sub3_585
		.method2051(2, -89, Class64_Sub16.aClass65_3681);
	    ((Class76_Sub3) this).aHa_Sub3_585.method1945((byte) 121, true);
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    final boolean method745(byte i) {
	boolean bool;
	try {
	    if (i != 27)
		anIDirect3DVertexShader3734 = null;
	    if (null != anIDirect3DVertexShader3734)
		return true;
	    bool = false;
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
	return bool;
    }
    
    final void method749(int i) {
	do {
	    try {
		if (null != anIDirect3DVertexShader3734) {
		    IDirect3DDevice idirect3ddevice
			= (((ha_Sub3_Sub1) aHa_Sub3_Sub1_3737)
			   .anIDirect3DDevice6098);
		    Class111_Sub3 class111_sub3
			= ((Class76_Sub3) this).aHa_Sub3_585.method2061(1);
		    class111_sub3.method2129(aFloatArray3736, 4);
		    aFloatArray3736[5] *= 0.25F;
		    aFloatArray3736[2] *= 0.25F;
		    aFloatArray3736[7] *= 0.25F;
		    aFloatArray3736[4] *= 0.25F;
		    aFloatArray3736[0] *= 0.25F;
		    aFloatArray3736[6] *= 0.25F;
		    aFloatArray3736[1] *= 0.25F;
		    aFloatArray3736[3] *= 0.25F;
		    idirect3ddevice
			.SetVertexShaderConstantF(8, aFloatArray3736, 2);
		}
		if (i == 8)
		    break;
		aClass195_3735 = null;
	    } catch (RuntimeException runtimeexception) {
		throw runtimeexception;
	    }
	    break;
	} while (false);
    }
    
    Class76_Sub3(ha_Sub3_Sub1 var_ha_Sub3_Sub1, Class207 class207,
		 Class195 class195) {
	super(var_ha_Sub3_Sub1);
	try {
	    aHa_Sub3_Sub1_3737 = var_ha_Sub3_Sub1;
	    aClass195_3735 = class195;
	    if (class207 != null && aClass195_3735.method2659(-22382)
		&& 257 <= ((((ha_Sub3_Sub1) aHa_Sub3_Sub1_3737).aD3DCAPS6093
			    .VertexShaderVersion)
			   & 0xffff))
		anIDirect3DVertexShader3734
		    = (((ha_Sub3_Sub1) aHa_Sub3_Sub1_3737)
			   .anIDirect3DDevice6098.a
		       (class207.method2739("dx", "transparent_water",
					    -32734)));
	    else
		anIDirect3DVertexShader3734 = null;
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    final void method737(int i) {
	do {
	    try {
		if (i != 2899)
		    aFloatArray3736 = null;
		if (anIDirect3DVertexShader3734 == null)
		    break;
		IDirect3DDevice idirect3ddevice
		    = (((ha_Sub3_Sub1) aHa_Sub3_Sub1_3737)
		       .anIDirect3DDevice6098);
		Class111_Sub3 class111_sub3 = aHa_Sub3_Sub1_3737.method2027(0);
		idirect3ddevice
		    .a(0, class111_sub3.method2128(127, aFloatArray3736));
	    } catch (RuntimeException runtimeexception) {
		throw runtimeexception;
	    }
	    break;
	} while (false);
    }
    
    final void method748(int i, boolean bool) {
	try {
	    ((Class76_Sub3) this).aHa_Sub3_585
		.method2051(0, i ^ ~0x3f, Class300.aClass65_2499);
	    ((Class76_Sub3) this).aHa_Sub3_585
		.method2051(1, -88, Class64_Sub16.aClass65_3681);
	    ((Class76_Sub3) this).aHa_Sub3_585.method2026(2, false, (byte) 27,
							  (Class98_Sub43_Sub3
							   .aClass65_5926),
							  true);
	    ((Class76_Sub3) this).aHa_Sub3_585.method1945((byte) 110, false);
	    aHa_Sub3_Sub1_3737.method2070(anIDirect3DVertexShader3734, true);
	    if (i == 69) {
		method741((byte) -111);
		method749(i ^ 0x4d);
		method740(-116);
		method738(-75);
	    }
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
}
