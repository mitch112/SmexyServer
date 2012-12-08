/* Class98_Sub17 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

abstract class Class98_Sub17 extends Class98
{
    static boolean aBoolean3942 = true;
    static int anInt3943 = 0;
    static boolean aBoolean3944 = false;
    
    public Class98_Sub17() {
	/* empty */
    }
    
    abstract int method1151(int i);
    
    abstract int method1152(int i);
    
    static final String method1153(byte i) {
	try {
	    if (i >= -28)
		return null;
	    String string = "www";
	    if (Class64_Sub29.aClass196_3720 == Class146.aClass196_1182)
		string = "www-wtrc";
	    else if (Class246_Sub3_Sub4_Sub2_Sub2.aClass196_6543
		     == Class64_Sub29.aClass196_3720)
		string = "www-wtqa";
	    else if (Class64_Sub29.aClass196_3720 == Class207.aClass196_1578)
		string = "www-wtwip";
	    String string_0_ = "";
	    if (Class89.aString716 != null)
		string_0_ = "/p=" + Class89.aString716;
	    return ("http://" + string + "."
		    + ((Class279) Class4.aClass279_86).aString2098 + ".com/l="
		    + Class374.anInt3159 + "/a="
		    + Class98_Sub10_Sub15.anInt5619 + string_0_ + "/");
	} catch (RuntimeException runtimeexception) {
	    throw Class64_Sub27.method667(runtimeexception,
					  "hfa.J(" + i + ')');
	}
    }
    
    abstract long method1154(boolean bool);
    
    abstract int method1155(int i);
    
    abstract int method1156(int i);
}
