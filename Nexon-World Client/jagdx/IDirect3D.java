/* IDirect3D - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package jagdx;
import java.awt.Canvas;

import jaclib.peer.IUnknown;
import jaclib.peer.jaa;

public class IDirect3D extends IUnknown
{
    private jaa b;
    
    public final IDirect3DDevice a
	(int i, int i_0_, Canvas canvas, int i_1_,
	 D3DPRESENT_PARAMETERS d3dpresent_parameters) {
	IDirect3DDevice idirect3ddevice;
	try {
	    IDirect3DDevice idirect3ddevice_2_ = new IDirect3DDevice(b);
	    int i_3_
		= _CreateDevice(i, i_0_, canvas, i_1_, d3dpresent_parameters,
				idirect3ddevice_2_);
	    if (kg.b(-7175, i_3_))
		throw new jc(String.valueOf(i_3_));
	    idirect3ddevice = idirect3ddevice_2_;
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
	return idirect3ddevice;
    }
    
    public final native int CheckDeviceMultiSampleType
	(int i, int i_4_, int i_5_, boolean bool, int i_6_);
    
    public final D3DCAPS a(int i, int i_7_) {
	D3DCAPS d3dcaps;
	try {
	    D3DCAPS d3dcaps_8_ = new D3DCAPS();
	    int i_9_ = _GetDeviceCaps(i, i_7_, d3dcaps_8_);
	    if (kg.b(-7175, i_9_))
		throw new jc(String.valueOf(i_9_));
	    d3dcaps = d3dcaps_8_;
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
	return d3dcaps;
    }
    
    public final D3DADAPTER_IDENTIFIER b(int i, int i_10_) {
	D3DADAPTER_IDENTIFIER d3dadapter_identifier;
	try {
	    D3DADAPTER_IDENTIFIER d3dadapter_identifier_11_
		= new D3DADAPTER_IDENTIFIER();
	    int i_12_
		= _GetAdapterIdentifier(i, i_10_, d3dadapter_identifier_11_);
	    if (kg.b(-7175, i_12_))
		throw new jc(String.valueOf(i_12_));
	    d3dadapter_identifier = d3dadapter_identifier_11_;
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
	return d3dadapter_identifier;
    }
    
    public final native int CheckDepthStencilMatch(int i, int i_13_, int i_14_,
						   int i_15_, int i_16_);
    
    private final native int _GetAdapterIdentifier
	(int i, int i_17_, D3DADAPTER_IDENTIFIER d3dadapter_identifier);
    
    public static final IDirect3D a(int i, jaa var_jaa) {
	IDirect3D idirect3d;
	try {
	    IDirect3D idirect3d_18_ = new IDirect3D(var_jaa);
	    int i_19_ = _Direct3DCreate(i, idirect3d_18_);
	    if (kg.b(-7175, i_19_))
		throw new jc(String.valueOf(i_19_));
	    idirect3d = idirect3d_18_;
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
	return idirect3d;
    }
    
    private final native int _GetDeviceCaps(int i, int i_20_, D3DCAPS d3dcaps);
    
    public final native int CheckDeviceFormat(int i, int i_21_, int i_22_,
					      int i_23_, int i_24_, int i_25_);
    
    public final native int CheckDeviceType(int i, int i_26_, int i_27_,
					    int i_28_, boolean bool);
    
    public final int a(int i, D3DDISPLAYMODE d3ddisplaymode) {
	int i_29_;
	try {
	    i_29_ = _GetAdapterDisplayMode(i, d3ddisplaymode);
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
	return i_29_;
    }
    
    private IDirect3D(jaa var_jaa) {
	super(var_jaa);
	try {
	    b = var_jaa;
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    private final native int _CreateDevice
	(int i, int i_30_, Canvas canvas, int i_31_,
	 D3DPRESENT_PARAMETERS d3dpresent_parameters,
	 IDirect3DDevice idirect3ddevice);
    
    private final native int _GetAdapterDisplayMode
	(int i, D3DDISPLAYMODE d3ddisplaymode);
    
    private static final native int _Direct3DCreate(int i,
						    IDirect3D idirect3d);
}
