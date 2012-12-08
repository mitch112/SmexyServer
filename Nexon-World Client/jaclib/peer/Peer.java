/* Peer - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package jaclib.peer;

abstract class Peer
{
    protected PeerReference reference;
    /*synthetic*/ static Class a;
    
    private static final native void init(Class var_class);
    
    protected long a() {
	long l;
	try {
	    l = reference.a(0);
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
	return l;
    }
    
    public final boolean a(int i) {
	boolean bool;
	try {
	    if (i != 25759)
		a();
	    bool = reference.b(i + -25881);
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
	return bool;
    }
    
    protected Peer() {
	/* empty */
    }
    
    /*synthetic*/ static Class a(String string) {
	Class var_class;
	try {
	    var_class = Class.forName(string);
	} catch (ClassNotFoundException classnotfoundexception) {
	    throw new NoClassDefFoundError(classnotfoundexception
					       .getMessage());
	}
	return var_class;
    }
    
    static {
	init(a == null ? a = a("jaclib.peer.PeerReference") : a);
    }
}
