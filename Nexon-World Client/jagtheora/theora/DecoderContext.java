/* DecoderContext - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package jagtheora.theora;
import jagtheora.misc.SimplePeer;
import jagtheora.ogg.OggPacket;

public class DecoderContext extends SimplePeer
{
    public DecoderContext(TheoraInfo theorainfo, SetupInfo setupinfo) {
	try {
	    init(theorainfo, setupinfo);
	    if (this.b())
		throw new IllegalArgumentException("");
	} catch (RuntimeException runtimeexception) {
	    throw runtimeexception;
	}
    }
    
    public final native int decodePacketIn(OggPacket oggpacket,
					   GranulePos granulepos);
    
    protected final native void clear();
    
    public final native int decodeFrame(Frame frame);
    
    public final native int setPostProcessingLevel(int i);
    
    private final native void init(TheoraInfo theorainfo, SetupInfo setupinfo);
    
    public final native double granuleTime(GranulePos granulepos);
    
    public final native long granuleFrame(GranulePos granulepos);
    
    public final native int getMaxPostProcessingLevel();
    
    public final native int setGranulePosition(long l);
}
