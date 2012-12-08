/* p - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Rectangle;

final class p extends Class98 implements Interface9
{
    int anInt3319;
    Canvas aCanvas3320;
    private static boolean aBoolean3321 = false;
    int anInt3322;
    long nativeid;
    private static long aLong3323;
    
    protected final void finalize() {
	if (((p) this).nativeid != 0L)
	    Class192.method2654(false, this);
    }
    
    final void method1445(Rectangle[] rectangles, int i, int i_0_, int i_1_) {
	try {
	    synchronized (((p) this).aCanvas3320.getTreeLock()) {
		for (int i_2_ = 0; i_2_ < i; i_2_++) {
		    Rectangle rectangle = rectangles[i_2_];
		    if (rectangle.width > 0 && rectangle.height > 0)
			K(rectangle.x, rectangle.y, rectangle.width,
			  rectangle.height, i_0_, i_1_);
		}
		aBoolean3321 = false;
	    }
	} catch (Exception exception) {
	    method1446(exception);
	}
    }
    
    private final native void H(int i, int i_3_, int i_4_, int i_5_);
    
    private final void method1446(Exception exception) {
	if (!aBoolean3321) {
	    aLong3323 = Class343.method3819(-47);
	    aBoolean3321 = true;
	} else if (Class343.method3819(-47) - aLong3323 < 30000L)
	    ((p) this).aCanvas3320.repaint();
	else
	    throw new RuntimeException(exception.getMessage());
    }
    
    private final native void oa(Canvas canvas, int i, int i_6_);
    
    private final native void K(int i, int i_7_, int i_8_, int i_9_, int i_10_,
				int i_11_);
    
    public final native void w(boolean bool);
    
    final void method1447(int i, int i_12_) {
	try {
	    synchronized (((p) this).aCanvas3320.getTreeLock()) {
		Dimension dimension = ((p) this).aCanvas3320.getSize();
		H(i, i_12_, dimension.width, dimension.height);
		aBoolean3321 = false;
	    }
	} catch (Exception exception) {
	    method1446(exception);
	}
    }
    
    p(oa var_oa, Canvas canvas, int i, int i_13_) {
	((p) this).aCanvas3320 = canvas;
	((p) this).anInt3319 = i;
	((p) this).anInt3322 = i_13_;
	sa(var_oa, ((p) this).aCanvas3320, i, i_13_);
    }
    
    final void method1448(Canvas canvas, int i, int i_14_) {
	((p) this).anInt3319 = i;
	((p) this).anInt3322 = i_14_;
	oa(canvas, i, i_14_);
    }
    
    final void method1449() {
	w(true);
	((p) this).nativeid = 0L;
	((p) this).aCanvas3320 = null;
    }
    
    private final native void sa(oa var_oa, Canvas canvas, int i, int i_15_);
}
