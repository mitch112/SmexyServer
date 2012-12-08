/* Class98_Sub46_Sub20_Sub1 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import java.lang.ref.SoftReference;

final class Class98_Sub46_Sub20_Sub1 extends Class98_Sub46_Sub20
{
    private SoftReference aSoftReference6314;
    
    final boolean method1638(int i) {
	boolean bool;
	try {
	    if (i != 896)
		return true;
	    bool = true;
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
	return bool;
    }
    
    Class98_Sub46_Sub20_Sub1(Interface20 interface20, Object object, int i) {
	super(interface20, i);
	try {
	    aSoftReference6314 = new SoftReference(object);
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    final Object method1635(int i) {
	Object object;
	try {
	    int i_0_ = 76 % ((-54 - i) / 41);
	    object = aSoftReference6314.get();
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
	return object;
    }
}
