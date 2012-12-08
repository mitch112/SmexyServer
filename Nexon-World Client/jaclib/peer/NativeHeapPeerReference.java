/* NativeHeapPeerReference - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package jaclib.peer;

class NativeHeapPeerReference extends PeerReference
{
    NativeHeapPeerReference(mfa var_mfa, jaa var_jaa) {
	super((Peer) var_mfa, var_jaa);
    }
    
    protected final native long releasePeer(long l);
}
