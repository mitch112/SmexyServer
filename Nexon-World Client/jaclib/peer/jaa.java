/* jaa - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package jaclib.peer;
import java.lang.ref.ReferenceQueue;

public final class jaa
{
    ReferenceQueue a = new ReferenceQueue();
    private PeerReference b;
    private PeerReference c;
    
    public final void a(byte i) {
	try {
	    a(-16615);
	    int i_0_ = 110 % ((64 - i) / 60);
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    private final void a(PeerReference peerreference, byte i) {
	do {
	    try {
		peerreference.a(0);
		if (peerreference == c)
		    c = peerreference.a;
		if (b == peerreference)
		    b = peerreference.b;
		if (peerreference.a != null)
		    peerreference.a.b = peerreference.b;
		if (peerreference.b != null)
		    peerreference.b.a = peerreference.a;
		if (i == 69)
		    break;
		b = null;
	    } catch (RuntimeException runtimeexception) {
		throw runtimeexception;
	    }
	    break;
	} while (false);
    }
    
    public final void b(byte i) {
	try {
	    if (i >= -122)
		b((byte) 116);
	    a(-16615);
	    while (null != b)
		a(b, (byte) 69);
	    a(-16615);
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    final void a(PeerReference peerreference, int i) {
	do {
	    try {
		peerreference.b = b;
		peerreference.a = null;
		if (null != c)
		    b.a = peerreference;
		else
		    c = peerreference;
		b = peerreference;
		if (i == -31112)
		    break;
		a(null, (int) 1);
	    } catch (RuntimeException runtimeexception) {
		throw runtimeexception;
	    }
	    break;
	} while (false);
    }
    
    private final void a(int i) {
	do {
	    try {
		for (;;) {
		    java.lang.ref.Reference reference = a.poll();
		    if (reference == null)
			break;
		    PeerReference peerreference = (PeerReference) reference;
		    a(peerreference, (byte) 69);
		}
		if (i == -16615)
		    break;
		a(null, (byte) 127);
	    } catch (RuntimeException runtimeexception) {
		throw runtimeexception;
	    }
	    break;
	} while (false);
    }
}
